
var loc = window.location;
var pathName = loc.pathname.substring(0, loc.pathname.lastIndexOf('/') + 1);
var uriabsoluta = loc.href.substring(0, loc.href.length - ((loc.pathname + loc.search + loc.hash).length - pathName.length));


function editfact(id) {
    alert("Codigo:" + id);
}


$(document).ready(function () {

    //cuando carga la pagina llama la funcion listar cliente
    
    SearchFact("0");

});

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



function SearchFact(id) {
    // validamos los campos
    var tablafactura = $('#comprobante_data').dataTable({
        aProcessing: true, //Activamos el procesamiento del datatables
        aServerSide: true, //Paginación y filtrado realizados por el servidor
        dom: 'Bfrtip', //Definimos los elementos del control de tabla
        buttons: ['copyHtml5', 'excelHtml5', 'csvHtml5', 'pdf'],
        ajax: {
            "url": uriabsoluta + "Cventas?accion=listfact&id="+id,
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

}