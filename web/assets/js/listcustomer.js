
var loc = window.location;
var pathName = loc.pathname.substring(0, loc.pathname.lastIndexOf('/') + 1);
var uriabsoluta = loc.href.substring(0, loc.href.length - ((loc.pathname + loc.search + loc.hash).length - pathName.length));

console.log("path name: ", pathName);
console.log("ruta absoluta: ", uriabsoluta);

function editcus(id) {

    $.ajax({
        url: uriabsoluta + "Ccustomer?accion=scbyid&id=" + id,
        method: "POST",
        data: {skup: id},
        dataType: "JSON",
        success: function (result) {
            $("#idper").html("").val(result.id);
            $("#name").html("").val(result.name);
            $("#ape").html("").val(result.ape);
            $("#doc").html("").val(result.doc);

            $("#line1").html("").val(result.line1);
            $("#line2").html("").val(result.line2);

            $("#dir").html("").val(result.adress);
            $("#email").html("").val(result.email);
            $("#tel1").html("").val(result.tel1);
            $("#tel2").html("").val(result.tel2);

            $("#name").focus();

            $("#updatecurtomer").modal('show');
        },
        error: function (error) {
            error_noti("Error: " + error);
        }
    });


}

function pulsar(e) {
    tecla = (document.all) ? e.keyCode : e.which;
    return (tecla != 13);
}

$(document).ready(function () {
    SearchProduct("");
});

$(".buscarendba").keypress(function () {

    var valuesearch = $(".buscarendba").val();
    console.log(valuesearch);
    SearchProduct(valuesearch);
});

function searchdata() {
    var buscar = $(".buscarendba").val();
    SearchProduct(buscar);
    console.log("usted preciono en buscar");
}

var tablaproduct;

//mostramos las informacion en datable
function SearchProduct(name) {
    // validamos los camos
    var tablaproduct = $('#customer_data').dataTable({
        aProcessing: true, //Activamos el procesamiento del datatables
        aServerSide: true, //Paginación y filtrado realizados por el servidor
        dom: 'Bfrtip', //Definimos los elementos del control de tabla
        buttons: ['copyHtml5', 'excelHtml5', 'csvHtml5', 'pdf'],
        ajax: {
            "url": uriabsoluta + "Ccustomer?accion=listclientes&cname=" + name,
            "type": "GET",
            "dataType": "JSON",
            dataSrc: "datos",
            error: function (e) {
                console.log(e.responseText);
            }
        },
        columns: [

            {data: "name"},
            {data: "doc"},
            {data: "dir"},
            {data: "email"},
            {data: "tel1"},
            {data: "line1"},
            {data: "line2"},
            {data: "accion"}
        ],
        "bDestroy": true,
        "responsive": true,
        "bInfo": true,
        "iDisplayLength": 10, //Por cada 10 registros hace una paginación
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
}