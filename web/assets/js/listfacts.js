
var loc = window.location;
var pathName = loc.pathname.substring(0, loc.pathname.lastIndexOf('/') + 1);
var uriabsoluta = loc.href.substring(0, loc.href.length - ((loc.pathname + loc.search + loc.hash).length - pathName.length));


var tabla;

function VerCuenta(c) {

    $("#regpagos").modal("show");
    this.printCredit(c);

    var tabla = $("#listpagos").dataTable({
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
        "iDisplayLength": 8,
        "order": [[0, "desc"]],
        buttons: [],

        ajax:
                {
                    url: uriabsoluta + "Cventas?accion=listpagos&id=" + c,
                    type: "POST",
                    "dataType": "JSON",
                    dataSrc: "datos",
                    error: function (e) {
                        warning_noti("No se pudo cargar los datos! Verifique su conexion a DBA" + e);
                    }
                },
        columns: [
            {data: "i"},
            {data: "monto"},
            {data: "fpago"},
            {data: "rp"}
        ],
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

        "footerCallback": function (row, data, start, end, display) {
            var api = this.api(), data;
            // convert to double
            var intVal = function (i) {
                return typeof i === 'string' ?
                        i.replace(/[\$S/ ]/g, '') * 1 :
                        typeof i === 'number' ?
                        i : 0.00;
            };

            var mtotal = api
                    .column(1)
                    .data()
                    .reduce(function (a, b) {
                        return parseFloat(intVal(a)) + parseFloat(intVal(b));
                    }, 0);

            $(api.column(0).footer()).html('Total De pagos');
            $(api.column(1).footer()).html("S/. " + mtotal.toFixed(2));
        }//end footer

    });



}


function printCredit(id) {

    $.ajax({
        url: uriabsoluta + "Cventas?accion=printCredit",
        method: "POST",
        data: {id: id},
        dataType: "JSON",
        success: function (rs) {
            if (rs.total > rs.acum || rs.total === undefined) {
                $("#montototal").html("").append(rs.total);
                $("#montopagar").html("").append(rs.pagar);
                $("#mpagar").html("").val(rs.pagar);
                $("#idcredit").html("").val(rs.id);
                $("#secctionpagos").css({"display": "block"});
            } else {
                $("#secctionpagos").css({"display": "none"});
            }
        },
        error: function (error) {
            error_noti();
        }
    });

}



function editfact(id) {
    alert("Codigo:" + id);
}
var numfact = "";

//abre la factura en una ventana nueva
function PrintDoc(id) {
    var uri = uriabsoluta + "printfact.jsp?n=" + id
    window.open(uri, '_blank');
}

//anulamos la factura
function AnulateDoc(id) {
    swal({
        title: "Seguro de anular la factura: " + id + "?",
        text: "Se reralizara cambios en el estado de la factura!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    }).then((willDelete) => {
        if (willDelete) {
            $.ajax({
                url: uriabsoluta + "Cventas?accion=anulaFact&id=" + id,
                method: "POST",
                data: {id: id},
                dataType: "JSON",
                success: function (result) {
                    swal("" + result.ok, {
                        icon: "success",
                    });
                },
                error: function (error) {
                    error_noti("error: " + error);
                }
            });


        } else {
            swal("Opss! NO se realizo cambios en el sistema!");
        }
    });

    //cambiando color de fondo de ewet aler
    var nuevoCSS = {"border-radius": '0.25rem', "background-color": 'rgb(152 0 0 / 90%)', "font-weight": 'bold'};
    $(".swal-modal").css(nuevoCSS);


}


function anulatefact() {

    $.ajax({
        url: uriabsoluta + "Cventas?accion=anulaFact&id=" + id,
        method: "POST",
        data: {skup: id},
        dataType: "JSON",
        success: function (result) {

        },
        error: function (error) {
            error_noti();
        }
    });

}

function pulsar(e) {
    tecla = (document.all) ? e.keyCode : e.which;
    return (tecla != 13);
}

$(document).ready(function () {

    SearchFact("0");

    $(".buscarendba").keypress(function (e) {
        var valuesearch = $(".buscarendba").val();
        if (e.which == 13) {
            SearchFact(valuesearch, 300);
        }
    });

});

function searchdata() {
    var buscar = $(".buscarendba").val();
    SearchFact(buscar, 30);
}


$(".buscarendba").keypress(function () {

    var valuesearch = $(".buscarendba").val();
    SearchFact(valuesearch);
});

function searchdata() {
    var buscar = $(".buscarendba").val();
    SearchFact(buscar);
    console.log("usted preciono en buscar");
}

var tablafactura;


//listamos las facturas
function SearchFact(id) {
    // validamos los campos
    var tablafactura = $('#comprobante_data').dataTable({
        aProcessing: true, //Activamos el procesamiento del datatables
        aServerSide: true, //Paginación y filtrado realizados por el servidor
        dom: 'Bfrtip', //Definimos los elementos del control de tabla
        buttons: ['copyHtml5', 'excelHtml5', 'csvHtml5', 'pdf'],
        orderCellsTop: true,
        fixedHeader: true,
        ajax: {
            "url": uriabsoluta + "Cventas?accion=listfact&id=" + id,
            "type": "GET",
            "dataType": "JSON",
            dataSrc: "datos",
            error: function (e) {
                console.log(e.responseText);
            }
        },

        columns: [
            {data: "id"},
            {data: "femis"},
            {data: "estado"},
            {data: "inpuesto"},
            {data: "total"},
            {data: "accion"}
        ],
        "bDestroy": true,
        "responsive": true,
        "bInfo": true,
        "iDisplayLength": 15, //Por cada 10 registros hace una paginación
        "order": [
            [0, "asc"]
        ], //Ordenar (columna,orden)
        "oLanguage": {
            "sProcessing": "Procesando...",
            "sLengthMenu": "Mostrar _MENU_ registros",
            "sZeroRecords": "No se encontraron resultados",
            "sEmptyTable": "Ningún dato disponible en esta tabla",
            "sInfo": "Mostrando un total de _TOTAL_ registros",
            "sInfoEmpty": "Mostrando un total de 0 registros",
            "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
            "sInfoPostFix": "",
            "sSearch": "Buscar:",
            "sUrl": "",
            "sInfoThousands": ",",
            "sLoadingRecords": "Cargando...",
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
        } //cerrando language 
    });

    ////Creamos una fila en el head de la tabla y lo clonamos para cada columna
    /*$('#comprobante_data thead tr').clone(true).appendTo('#comprobante_data thead');

    $('#comprobante_data thead tr:eq(1) th').each(function (i) {
        var title = $(this).text(); //es el nombre de la columna
        $(this).html('<input type="text" placeholder="Search...' + title + '" />');

        $('input', this).on('keyup change', function () {
            if (tablafactura.column(i).search() !== this.value) {
                tablafactura
                        .column(i)
                        .search(this.value)
                        .draw();
            }
        });
    });*/
}