

//var URLactual = window.location;
var loc = window.location;
var pathName = loc.pathname.substring(0, loc.pathname.lastIndexOf('/') + 1);
var uriabsoluta = loc.href.substring(0, loc.href.length - ((loc.pathname + loc.search + loc.hash).length - pathName.length));

$(document).ready(function () {
    listprodtotales("", "");
    totalventas();
    ventadelmes();

    //si hay cambios ne la fecha se ejecuta  filtro por fecha
    $("#finicio ,#ffin").on('change', function () {
        var i = $("#finicio").val();
        var f = $("#ffin").val();
         vtotal(i,f);
         listprodtotales(i, f);
        
    });


});

// total de ventas  por dia
function totalventas() {
    $.ajax({
        url: uriabsoluta + "Chome?accion=lpxc",
        type: "POST",
        dataType: "JSON",
        data: {m:""},
        success: function (data) {
            $('#cantiprods').append(data.cant);
            $('#totalventas').append("$ " + data.total);
        }, error: function (e) {
            console.log("Error: " + e.responseText);

        }
    });

}


// venta personalizada
function vtotal(i, f) {
    if (i != "" && f != "") {
        $.ajax({
            url: uriabsoluta + "Chome?accion=tv",
            type: "POST",
            dataType: "JSON", 
            data: {a:i, b:f},
            success: function (data) {
                var v="<span class='float-right'>(&#8721;)</span>";
                $('#vfiltro').html("");  
                $('#vfiltro').append("$ "+data.data+v);  
               
            }, error: function (e) {
                console.log("Error: " + e);

            }
        });
    }


    ;
}

//venta total del mes
function ventadelmes() {   
    $.ajax({
            url: uriabsoluta + "Chome?accion=lpxc",
            type: "POST",
            dataType: "JSON",
            data: {m:"m"},
            success: function (data) {                  
                $('#ventames').append("$ "+data.total);  
               
            }, error: function (e) {
                console.log("Error: " + e);

            }
        });
}

//lista de productos mas vendidos
function listprodtotales(i, f) {

    var tabla = $("#listprodventas").dataTable({
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
        "iDisplayLength": 10,
        "order": [[0, "asc"]],
        "scrollY": false,
        buttons: ['copyHtml5', 'excelHtml5', 'csvHtml5', 'pdf'],
        ajax:
                {
                    url: uriabsoluta + "Chome?accion=lpxm",
                    type: "POST",
                    "dataType": "JSON",
                    dataSrc: "data",
                    data: {a: i, b: f},
                    error: function (e) {
                        warning_noti("No se pudo cargar los datos! Verifique su conexion a DBA" + e);
                    }
                },
        columns: [
            {data: "i"},
            {data: "name"},
            {data: "peso"},
            {data: "cant"},
            {data: "total"}
        ],
        "language": {
            "emptyTable": "No hay datos disponibles",
            "info": "Del _START_ al _END_ de _TOTAL_ ",
            "lengthMenu": "Mostrar _MENU_ registros",
            "loadingRecords": "Cargando...",
            "processing": "Procesando...",
            "sEmptyTable": '<div class="alert alert-danger" role="alert"> <strong>Realice una venta para mostrar los productos</strong></div>',
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
                    .column(4)
                    .data()
                    .reduce(function (a, b) {
                        return parseFloat(intVal(a)) + parseFloat(intVal(b));
                    }, 0);
            $(api.column(4).footer()).html("Total S " + mtotal.toFixed(2));
        }//end footer

    });
}// end 