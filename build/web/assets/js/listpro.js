

//var URLactual = window.location;
var loc = window.location;
var pathName = loc.pathname.substring(0, loc.pathname.lastIndexOf('/') + 1);
var uriabsoluta = loc.href.substring(0, loc.href.length - ((loc.pathname + loc.search + loc.hash).length - pathName.length));



var tablaproduct;


function editP(id) {
    $.ajax({
        url: uriabsoluta + "Cproduct?accion=uprodselect",
        method: "POST",
        data: {skup: id},
        dataType: "JSON",
        success: function (result) {
            $("#mskup").html("").val(result.skup);
            $("#mprodname").html("").val(result.namep);
            $("#mproddetail").html("").val(result.descp);
            $("#mprodobserve").html("").val(result.obsp);
            $("#mprodxpack").html("").val(result.qxp);
            $("#prodprice").html("").val(result.pricep);
            $("#pricepromo").html("").val(result.priceprom);
            $("#cantypromo").html("").val(result.cantprom);
            $("#prodsize").html("").val(result.pesop);
            $("#stockmin").html("").val(result.stmin);
            $("#stockmax").html("").val(result.stmax);
            $("#prodcat").html("").append(result.categories);
            $("#prodstate").html("").append(result.statep);
            $("#prodcolor").html("").append(result.colors);
            $("#sizesimbol").html("").append(result.sizes);
            $("#fpfin").html("").val(result.fexpromo);
            $("#hpfin").html("").val(result.hexpromo);
            $("#titleprod").html("Editando el producto con el código: " + result.skup);
            $("#mprodname").focus();
            $('#ModalEditProduct').modal('show');
        },
        error: function (error) {
            error_noti();
        }
    });
}

$(document).ready(function () {

    $(document).on("click", "td span.priceproduct", function (e) {
        e.preventDefault();
        $("td:not(.id)").removeClass("priceproduct");
        td = $(this).closest("td");
        campo = $(this).closest("td").data("campo");
        valor = $(this).text();
        skuprod = $(this).attr("id");
        td.text("").html("$ <input class='saveprice' type='number' step='0.010' min'0.000' style='width:4em' name='" + skuprod + "' value='" + valor + "'>");
        $('td input').mouseout(function () {

            var newval = $(this).closest("td").find("input").val();
            e.preventDefault();
            nuevovalor = $(this).closest("td").find("input").val();
            td.text("").html("$<span class='priceproduct' id='" + skuprod + "'>" + nuevovalor + "</span>");
            $.ajax({
                type: "POST",
                url: uriabsoluta + "Cproduct?accion=savepriceprod",
                dataType: "JSON",
                data: {skup: skuprod, pricep: nuevovalor}
            }).done(function (result) {
                success_noti(result.skup);
            });
        });
    });

    var myArticles = ['a', 'e', 'o', 'u'];
    var art = Math.floor(Math.random() * myArticles.length);
    SearchProduct(myArticles[art], 30);



    $(".buscarendba").keypress(function (e) {
        var valuesearch = $(".buscarendba").val();
        if (e.which == 13) {
            SearchProduct(valuesearch, 300);
        }
    });
});//end ready


function SearchProduct(skuid, numfila) {
    if (skuid == "") {
        var myArticles = ['detergente', 'atun', 'papel', 'lava'];
        var art = Math.floor(Math.random() * myArticles.length);
        skuid = myArticles[art];
    }
    var rows = numfila;
    if (rows === "") {
        rows = 20;
    }
    tablaproduct = $('#producto_data').dataTable({
        aProcessing: true, //Activamos el procesamiento del datatables
        aServerSide: true, //Paginación y filtrado realizados por el servidor        
        dom: 'Blfrtip', //Definimos los elementos del control de tabla, select con la cantidad de a mostrar        
        buttons: ['copyHtml5', 'excelHtml5', 'csvHtml5', 'pdf'],
        lengthMenu: [[10, 25, 50, -1], ['10 Registros', '25 Registros', '50 registros', 'Mostrar Todo los registrar']],
        searching: true,
        "paging": true,
        "bDestroy": true, //elimina los datos cargados de DataTable.
        "responsive": true,
        "bInfo": false,
        "iDisplayLength": 10, //Por cada 10 registros hace una paginación
        "order": [[0, "asc"]], //Ordenar (columna,orden)
        "scrollY": false,
        //retrieve: true,//no borra los registro de datatable, ya no permite actualizar la tabla
        columns: [
            {data: "items"},
            {data: "namep"},
            {data: "stado"},
            {data: "stock"},
            {data: "color"},
            {data: "peso"},
            {data: "precio"},
            {data: "botonacion"}
        ],
        "oLanguage": {
            "sProcessing": "Procesando...",
            "sLengthMenu": "Mostrar _MENU_ registros",
            "sZeroRecords": "No se encontraron resultados",
            "sEmptyTable": '<div class="alert alert-danger" role="alert"> <strong>No hay registros</strong></div>',
            "sInfo": "Mostrando un total de _TOTAL_ registros",
            "sInfoEmpty": "Mostrando un total de 0 registros",
            "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
            "sInfoPostFix": "",
            "sSearch": "Buscar:",
            "sUrl": "",
            "sInfoThousands": ",",
            "sLoadingRecords": "Cargando...",
            "lengthMenu": "Mostrar _MENU_ registros",
            "oPaginate": {
                "sFirst": "Primero",
                "sLast": "Último",
                "sNext": "Siguiente",
                "sPrevious": "Anterior"
            },
            "oAria": {
                "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
                "sSortDescending": ": Activar para ordenar la columna de manera descendente"
            }
        }, //cerrando language
        ajax: {
            "url": uriabsoluta + "Cproduct?accion=listproduct&skup=" + skuid + "&rows=" + rows,
            "type": "GET",
            "dataType": "JSON",
            dataSrc: "datos",
            error: function (e) {
                //console.log("BUscador: "+e.responseText);
                error_noti("Lista de productos no encontrados!");
                //console.log("Mensaje: "+ e.responseText);
            }
        },
        "rowCallback": function (Row, Data) {
            if (Data['items'] % 2 == 0 && Data['items'] <= 6) {
                /*$('td', Row).css('background-color', 'rgba(9, 132, 27, 0.76)');*/
                $($(Row).find("td")[5]).css("background-color", "rgba(0, 185, 249, 0.86)");
                $($(Row).find("td")[6]).css({"background-color":"rgb(38, 166, 154)","color":"#ffff"});
                $($(Row).find("td")[7]).css("background-color", "initial");
            } else {
                /*$('td', Row).css('background-color', 'rgba(76, 7, 18, 0.67)');*/
                $($(Row).find("td")[5]).css("background-color", "rgba(0, 185, 249, 0.86)");
                $($(Row).find("td")[6]).css({"background-color":"rgb(38, 166, 154)","color":"#ffff"});
                $($(Row).find("td")[7]).css("background-color", "initial");
            }
        }
    });
}

function pulsar(e) {
    tecla = (document.all) ? e.keyCode : e.which;
    return (tecla != 13);
}

//----VIEWS ---DETAIL --PRODUCT
function detalleP(id) {
    $.ajax({
        url: uriabsoluta + "Cproduct?accion=detallep&skup=" + id,
        type: "GET",
        dataType: "JSON",
        success: function (data) {
            $('#productname').text(data.namep);
            $('#productsku').text(data.skup);
            $('#productdetalle').text(data.descp);
            $('#productstate').text(data.state);
            $('#productstock').text(data.stock);
            $('#productcolor').text(data.color);
            $('#productpeso').text(data.peso);
            $('#productsimbolo').text(data.simbolo);
            $('#productcategory').text(data.category);
            $('#productprice').text(data.price);
            $('#productprepromocion').text(data.pricepromo);
            $('#cantidadpromocion').text(data.cantpromo);
            $('#fechaexpiration').text(data.fexpiration);

            $('.modal-product-details').modal('show');
        }
    });
}

function searchdata() {
    var buscar = $(".buscarendba").val();
    SearchProduct(buscar, 30);
}