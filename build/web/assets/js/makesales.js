
var loc = window.location;
var pathName = loc.pathname.substring(0, loc.pathname.lastIndexOf('/') + 1);
var uriabsoluta = loc.href.substring(0, loc.href.length - ((loc.pathname + loc.search + loc.hash).length - pathName.length));

function pulsar(e) {
    tecla = (document.all) ? e.keyCode : e.which;
    return (tecla !== 13);
}

//--- detallde de venta
//--objeto detalle producto
function addDetail(item, name, peso, cantidad, precio, total, button) {
    this.item = item;
    this.name = name;
    this.peso = peso;
    this.cantidad = cantidad;
    this.precio = precio;
    //.descuento = descuento;
    this.total = total;
    this._button = button;
    this.button = function () {
        return this._button;
    };
}

$(document).ready(function () {
    $("#wrapper").toggleClass("toggled");
    var updatehora = function () {
        var fecha = new Date();
        var anio = fecha.getFullYear();
        var mes = (fecha.getMonth()) + 1;
        var hora = fecha.getHours();
        var minute = fecha.getMinutes();
        var segundo = fecha.getSeconds();
        var dia = fecha.getDate();
        if (minute < 10) {
            minute = "0" + minute;
        }
        if (segundo < 10) {
            segundo = "0" + segundo;
        }
        var fulldate = anio + "-" + mes + "-" + dia + " " + hora + ":" + minute + ":" + segundo;
        $('#fechanew').val(fulldate);
    }
    updatehora();

    var intervalo = setInterval(updatehora, 1000);
    $('.listproductos').click(function () {
        $('#lista_productos_ventas').modal('show');
    });

});


//buscar cliente en la bd
function searchdata() {
    var identity = $(".buscarendba").val();
    Searchcustom(identity);
}
//buscar cliente
function Searchcustom(docid) {
    $('.errorduplicado').remove();
    $.ajax({
        url: uriabsoluta + "Cventas?accion=searchcus",
        type: "POST",
        cache: false,
        data: {doc: docid},
        dataType: "json",
        success: function (data) {
            if (data.id == "c") {
                $('#namecli').val(data.nombre);
                $('#customid').val(data.cusid);
                $('#direccion').val(data.address);
                $('.messageout').append(data.msg);
            } else if (data.id == "p") {
                $('#namecli').val(data.nombre);
                $('#customid').val(data.idper);
                $('#nombrecliente').val(data.nombre);
                $('.messageout').append(data.msg);
            } else {
                console.log(data);
                $('#namecli').val(data.nombre);
                $('#customid').val(data.idanon);
                $('.messageout').append(data.msg);
            }
        },
        error: function (data) {
            alert("El cliente no existe, intente otra vez.");
        }
    });
}

// mostramos modal para registrar cliente
function addcustomer(idpc) {
    $('#idperson').val(idpc);
    $('#regcustomern').modal('show');
}

//mostra articulos en la ventana modal
var tabla;
function ArticleList() {
    var atrribProd = $("#searchForCustomer").val();
    if (atrribProd == "") {
        atrribProd = "a";
    }
    tabla = $("#productLists").dataTable(
            {
                "aProcessing": true,
                "aServerSide": true,
                dom: 'Blfrtip',
                select: true,
                searching: false,
                ordering: true,
                lengthMenu: [[10, 25, 50, -1], ['10 Registros', '25 Registros', '50 registros', 'Mostrar Todo los registrar']],
                "scrollCollapse": true,
                "paging": true,
                "bDestroy": true,
                "iDisplayLength": 7,
                "order": [[0, "desc"]],
                buttons: [],
                "language": {
                    "emptyTable": "No hay datos disponibles",
                    "info": "Del _START_ al _END_ de _TOTAL_ ",
                    "lengthMenu": "Mostrar _MENU_ registros",
                    "loadingRecords": "Cargando...",
                    "processing": "Procesando...",
                    "paginate": {
                        "first": "Primera",
                        "last": "Última",
                        "next": "Siguiente",
                        "previous": "Anterior"
                    },
                    "aria": {
                        "sortAscending": "Ordenación ascendente"//"sortDescending": "Ordenación descendente"
                    }
                },
                "ajax":
                        {
                            url: uriabsoluta + "Cventas?accion=productlist",
                            type: "POST",
                            data: {searching: atrribProd},
                            error: function (e) {
                                warning_noti("No se pudo cargar los datos! Verifique su conexion a DBA" + e);
                            }
                        }
            }
    ).DataTable();

}




$(document).ready(function () {
    //--filter product on popup table 
    $("#searchForCustomer").on("keypress", function (e) {
        var filterprod = $("#searchForCustomer").val();
        if (e.which == 13 && filterprod.length > 1) {
            ArticleList();
        }
    });
    $("#searchForCustomerbtn").on("click", function (e) {
        var filterprod = $("#searchForCustomer").val();
        if (filterprod.length > 1) {
            ArticleList();
        }
    });


//mostrando registros en detalle de ventas
    var tabledit = $('#tablaproducto').DataTable({
        "scrollY": "600px",
        "scrollCollapse": true,
        "paging": true,
        buttons: [],
        "bDestroy": true,
        "iDisplayLength": 20,
        //"bAutoHeight": true, //limitamos la altura
        "order": [[0, "desc"]],
        searching: true,
        columnDefs: [
            {width: "50px", targets: 2},
            {width: "50px", targets: 5},
            {width: "30px", targets: 6}
        ],
        "language": {
            "emptyTable": "No hay datos disponibles",
            "info": "Del _START_ al _END_ de _TOTAL_ ",
            "lengthMenu": "Mostrar _MENU_ registros",
            "loadingRecords": "Cargando...",
            "processing": "Procesando...",
            "sSearch": "Buscar",
            "paginate": {
                "first": "Primera",
                "last": "Última",
                "next": "Siguiente",
                "previous": "Anterior"
            },
            "aria": {
                "sortAscending": "Ordenacion ascendente",
                "sortDescending": "Ordenacion descendente"
            }
        },
        columns: [
            {data: 'item'},
            {data: 'name'},
            {data: 'peso'},
            {data: 'cantidad'},
            {data: 'precio'},
            {data: 'total'},
            {data: 'button'}
        ]
    });//end datatable

    var detalles = new Object();

    //add,delete,insert,update prod on table
//======================================
    function upDetalle(t, i, c, p) {
        var sk = i;
        var pp = 0;
        var cp = 0;
        //var rs = "";
        if (t == 1) {//new prod o update cantidad+1
            pp = p;
            cp = c;
        } else if (t == 2) {//update canty            
            cp = c;
            pp = p;
        }
        var rs = "";
        $.ajax({
            url: uriabsoluta + "Cventas?accion=addToCar",
            data: {type: t, skup: sk, cantp: cp, pricep: pp},
            method: "POST",
            dataType: "json",
            async: false, //espera hasta que se cargue
            cache: false,
            beforeSend: function () {
            },
            success: function (data) {
                rs = data;
            }, error: function (e) {
                error_noti("Error: No se actualizo los datos: " + e.responseText);
                rs = false;
            }
        });
        return rs;
    }//en ajax

//----------Add Porducto to detalle venta
    var tableDetails = $('#tablaproducto').DataTable();
    function addProdTodetail() {
        var skup = $("#skup").val();
        var namep = $("#namep").val();
        var sizep = $("#sizep").val();
        var cantip = $("#cantidad").val();
        var pricep = $("#pricep").val();
        var prip = parseFloat(pricep).toFixed(2);
        if (skup !== "" && namep !== "" && sizep !== "" && (parseFloat(pricep).toFixed(2)) > 0 && (parseFloat(cantip).toFixed(2)) > 0) {

            var rows = $("#tablaproducto").dataTable().fnGetNodes();
            var addtrue = false;
            for (var i = 0; i < rows.length; i++)
            {
                if ($(rows[i]).find("td:eq(5)").html() != 'undefined') {
                    var skush = $(rows[i]).find("td:eq(0)").html();
                    if (skush == skup) {
                        addtrue = true;
                        detalles = upDetalle(1, skup, cantip, prip);

                        $(rows[i]).find("td").eq(3).find('#canty').val(parseFloat(detalles.cantidad * 1))
                        $(rows[i]).find("td:eq(4)").find('#price').val(parseFloat(detalles.precio * 1));
                        $(rows[i]).find("td:eq(5)").html(detalles.subtotal * 1);
                        i = rows.length;
                    }
                }
            }

            if (addtrue) {

                $("#skup").val("");
                $("#namep").val("");
                $("#sizep").val("");
                $("#cantidad").val(1);
                $("#pricep").val("");
                $("#skup").focus();

                $('.dataTables_scrollFoot #montopagar').text((detalles.total * 1).toFixed(2));
                $("#amountv").val((detalles.total * 1).toFixed(2));
                warning_noti("La Cantidad del producto: " + namep + ", actualizado!");


            } else {

                ///---------------------
                detalles = upDetalle(1, skup, cantip, prip);
                var totalp = (parseFloat(pricep) * parseFloat(cantip)).toFixed(2);
                //rows.add fnAddData
                tableDetails.rows.add([
                    new addDetail(skup, namep, sizep, '<input type="number" name="canty" id="canty" value="' + parseFloat(detalles.cantidad * 1) + '" class="form-control"  step="1" min="1" requiret="">', '<div class="input-group mb-0">'
                            + '<div class="input-group-prepend">'
                            + '<span class="input-group-text">S/. </span>'
                            + '</div>'
                            + '<input type="number" name="price" id="price" class="form-control" value="' + detalles.precio * 1 + '" step="0.05" min="0.05" title="PRECIO DEL PRODUCTO">'
                            + '</div>', parseFloat(detalles.subtotal * 1), '<button type="button" id="delete" class="btn btn-danger">QUITAR</button>')
                ]).order([[1, 'asc']])
                        .draw(false);
                success_noti("Exito: Producto agregado al detalle");
                $("#skup").val("");
                $("#namep").val("");
                $("#sizep").val("");
                $("#cantidad").val(1);
                $("#pricep").val("");
                $("#skup").focus();
                //calMontoTotal();
                $('.dataTables_scrollFoot #montopagar').text((detalles.total * 1).toFixed(2));
                $("#amountv").val((detalles.total * 1).toFixed(2));

            }
        } else {
            error_noti("Error: El producto no fue agregado al detalle");
        }
    }
    /*var cantidad ="";
     var subtotal = "";
     var precio ="";
     var total= "";*/


//--update the quantity of product
//================================

    $("#tablaproducto tbody").on('change', '#canty', function () {
        var skk = $(this).parents('tr').find("td:eq(0)").html();
        var canti = $(this).parents('tr').find("td:eq(3)").find("#canty").val();
        var price = $(this).parents('tr').find("td:eq(4)").find("#price").val();
        canti = parseFloat(canti);
        if (canti <= 0) {
            canti = 1
        }
        detalles = upDetalle(2, skk, canti, price);
        if (detalles.ok == true) {
            var cant = parseFloat(detalles.cantidad * 1).toFixed(2);
            var nprice = parseFloat(detalles.precio * 1).toFixed(2);
            $(this).parents('tr').find("td:eq(3)").find("#canty").val(cant + "");
            $(this).parents('tr').find("td:eq(4)").find("#price").val(nprice + "");
            $(this).parents('tr').find("td:eq(5)").html(detalles.subtotal * 1);
            $('.dataTables_scrollFoot #montopagar').text(detalles.total * 1);
            $("#amountv").val((detalles.total * 1).toFixed(2));
            success_noti("Cantidad Actualizada");
        } else {
            $(this).parents('tr').find("td:eq(3)").find("#canty").val(canti);
        }

    });//end
//--update price of product
//=========================
    $("#tablaproducto tbody").on('change', '#price', function () {
        var skp = $(this).parents('tr').find("td:eq(0)").html();
        var qt = $(this).parents('tr').find("td:eq(3)").find("#canty").val();
        var pp = $(this).parents('tr').find("td:eq(4)").find("#price").val();

        detalles = upDetalle(2, skp, qt, pp);
        if (detalles.ok == true) {
            var cant = parseFloat(detalles.cantidad * 1).toFixed(2);
            var nprice = parseFloat(detalles.precio * 1).toFixed(2);
            $(this).parents('tr').find("td:eq(3)").find("#canty").val(cant + "");
            $(this).parents('tr').find("td:eq(4)").find("#price").val(nprice + "");
            $(this).parents('tr').find("td:eq(5)").html(detalles.subtotal * 1);
            $("#amountv").val((detalles.total * 1).toFixed(2));
            $('.dataTables_scrollFoot #montopagar').text(detalles.total * 1);
            success_noti("Precio Actualizado");
        } else {
            $(this).parents('tr').find("td:eq(4)").find("#price").val(pp);
            warning_noti("Error: el precio no se pudo actualizar");
        }
    });//end


    $("#addToDetail").on('click', function () {
        addProdTodetail();

    });//end add detail
    $("#cantidad").on('keypress', function (e) {
        if (e.which == 13) {
            addProdTodetail();

        }
    });
    $("#pricep").on('keypress', function (e) {
        if (e.which == 13) {
            addProdTodetail();

        }
    });
    //---maximizando table
    $(".dataTables_scrollHeadInner").css({"width": "100%"});
    $(".dataTables_scrollHeadInner table").css({"width": "100%"});

    //------------delete product detail--------------
    $("#tablaproducto tbody").on("click", "#delete", function () {
        var sks = $(this).parents('tr').find("td:eq(0)").html();
        detalles = upDetalle(3, sks, 0, 0);
        if (detalles.ok == true) {
            $('.dataTables_scrollFoot #montopagar').text(detalles.total);
            $("#amountv").val((detalles.total * 1).toFixed(2));
            var row = tableDetails.row($(this).parents('tr'));
            row.remove();
            tableDetails.draw();
        } else {
            warning_noti(detalles.sms);
        }

    });

    $("#savepay").on("click", function () {
        var tableD = $('#tablaproducto').DataTable();
        var cId = $("#customid").val();
        var cDni = $("#numdoc").val();
        var mSales = $("#amountv").val();
        var typePay = $("#typePay").val();

        $.ajax({
            url: uriabsoluta + "Cventas?accion=sDc",
            data: {customid: cId, numdoc: cDni, typePay: typePay, amountv: mSales},
            method: "POST",
            dataType: "json",
            async: false, //espera hasta que se cargue
            cache: false,
            beforeSend: function () {
            },
            success: function (data) {
                if (data.ok) {
                    anim5_noti(data.sms);
                    //imprimiendo tikect
                    var uri = uriabsoluta + "printfact.jsp?n=" + data.n
                    window.open(uri, '_blank');
                    tableD.clear().draw()
                } else {
                    warning_noti(data.sms);
                }

            }, error: function (e) {
                error_noti("Error: " + e.responseText);
            }
        });
    });

    $("#deletepay").on("click", function () {
        var tD = $('#tablaproducto').DataTable();
        $.ajax({
            url: uriabsoluta + "Cventas?accion=cs",
            dataType: "json",
            async: false, //espera hasta que se cargue
            cache: false,
            beforeSend: function () {
                console.log("esta cargando");
            },
            success: function (data) {
                if (data.ok) {
                    tD.clear().draw();
                    success_noti(data.sms);
                } else {
                    warning_noti(data.sms);
                }
            }, error: function (e) {
                error_noti("Error: " + e.responseText);
            }
        });

    });

//--getProdByIdFronDBA    
    var listproducts = [];
    $("#skup").keypress(function () {
        var codigop = $("#skup").val();
        if (codigop.length >= 0) {
            searchAjax(codigop);
            AutoProd();
        }
    });
    $("#skup").keypress(function (e) {
        var codigop = $("#skup").val();
        if (e.which == 13) {
            $.ajax({
                url: uriabsoluta + "Cproduct?accion=detallep",
                method: "POST",
                dataType: "JSON",
                data: {skup: codigop},
                async: false, //espera hasta que se cargue
                cache: false,
                beforeSend: function () {
                    console.log("esta cargando autocomplete");
                },
                success: function (data) {
                    var pp = data;//JSON.parse(data);
                    if (pp.emty !== 'null') {
                        $('#skup').val(pp.skup);
                        $('#namep').val(pp.namep);
                        $('#sizep').val(pp.peso + "" + pp.simbolo);
                        $('#pricep').val(pp.price);
                        $('#cantidad').focus().select();
                        addProdTodetail();//agregado productos al detalle

                    } else {
                        $('#skup').focus().select();
                        warning_noti("El producto no se ha encontrado");
                    }
                },
                error: function (e) {
                    danger_noti("Error! Verifique su conexion a DBA" + e);
                }
            });
        }
    });

    function searchAjax(codigop) {

        $.ajax({
            url: uriabsoluta + "Cproduct?accion=spa",
            data: {codigop: '' + codigop + ''},
            method: "post",
            dataType: "json",
            success: function (resultado) {
                if (resultado.error !== "undefined") {
                    listproducts = resultado;//JSON.parse(resultado);
                } else {
                    console.log("TryError: " + resultado.error);
                    console.log("Trysms: " + resultado.sms);
                }
            },
            error: function (e) {
                console.log("Error sms: " + e.responseText);
            }
        });
    }
//---autocomplete-producto  
    function AutoProd() {
        $('#skup').autocomplete({
            lookup: listproducts,
            minChars: 0,
            noCache: false,
            lookupLimit: 30,
            width: 600,
            tabDisabled: true,
            //groupBy: 'skup',
            onSelect: function (suggestion) {
                if (suggestion.data.skup.length) {
                    $('#skup').val(suggestion.data.skup);
                    $('#namep').val(suggestion.data.name);
                    $('#sizep').val(suggestion.data.size);
                    $('#pricep').val(suggestion.data.price);
                    $('#cantidad').focus().select();

                    addProdTodetail();
                }
            }
        });
    }

//---autocomplete-custom-----
    var personas = [];
    $("#namecli").keypress(function () {
        var nombre = $("#namecli").val();
        $.ajax({
            url: uriabsoluta + "Ccustomer?accion=sct",
            data: {cname: nombre},
            method: "POST",
            dataType: "json",
            success: function (result) {
                personas = result;//JSON.parse(result);
            }, error: function (e) {
                warning_noti("Nota! No hay resultados");
                console.log("erro: " + e.responseText);
            }
        });

        buscar();
        if (nombre.length) {
            $("#close-icon").css({"display": "block"});
        } else {
            $("#close-icon").css({"display": "none"});
        }
        $("#close-icon").on('click', function () {
            $(".search-box").val('');
            $("#customid").val("");
            $("#numdoc").val("");
            $("#close-icon").css({"display": "none"});
        });
    });

    function buscar() {
        $('#namecli').autocomplete({
            lookup: personas,
            minChars: 1,
            noCache: false,
            lookupLimit: 30,
            width: 600,
            showNoSuggestionNotice: true,
            onSelect: function (suggestion) {
                anim5_noti("Éxito: Se seleccionó el cliente");
                var value = suggestion.value;
                var nombre = value.split(" | ")[1];
                $('#namecli').val(nombre);
                $('#numdoc').val(suggestion.data.doc);
                $("#customid").val(suggestion.data.idper);
            }
        });
    }

    
});

