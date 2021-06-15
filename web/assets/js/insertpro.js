//var URLactual = window.location;
var loc = window.location;
var pathName = loc.pathname.substring(0, loc.pathname.lastIndexOf('/') + 1);
var uriabsoluta = loc.href.substring(0, loc.href.length - ((loc.pathname + loc.search + loc.hash).length - pathName.length));


$(document).on('click', '#isvalidsku', function () {
    validateProduct();
});

function validateProduct() {

    var psku = $("#prodsku").val();
    if (psku != "") {

        $.ajax({
            url: uriabsoluta + "Cproduct?accion=shearprod",
            pethod: "post",
            data: {sku: psku},
            dataType: "json",

            success: function (data) {
                if (data.sms == 2) {
                    error_noti("El producto ya se encuentra registrado, con codigo: <b>" + psku + ": " + data.nombres + "</b>, " + data.desc);
                    editP(psku);
                } else if (data.sms == 1) {
                    success_noti("El producto aun no esta registrado. COdigo: <b>" + psku + "</b>");
                } else {
                    warning_noti("El campo código esta vacío.");
                }
            },
            error: function (error) {
                error_noti('Verifique su conexion');
            }

        });
    } else {
        warning_noti("El campo codigo esta vacio.");
        console.log("campo vacio")
    }
}


$(".searchvalidate").keypress(function (e) {
    
   
    var skus = $(".searchvalidate").val();
          
    if (e.which == 13) {               
        if (skus != null) {
            //$(".searchvalidate").val("");
            validateProduct();
            //$(".searchvalidate").val(skus);
        }else{
            warning_noti("El campo codigo esta vacio, Ingrese el codigo");
        }       
    }
});


function pulsar(e) {
    tecla = (document.all) ? e.keyCode : e.which;
    return (tecla != 13);
}


$(".buscarendba").keypress(function (e) {
    if (e.which == 13) {        
        $(".searchvalidate").val($(".buscarendba").val());        
        validateProduct();
    }
});

function searchdata (){
    $(".searchvalidate").val($(".buscarendba").val());        
        validateProduct();
}

//actualizar producto si en caso ya exite en la base de datos


function editP(id) {
    $.ajax({
        url: uriabsoluta+"Cproduct?accion=uprodselect",
        method: "POST",
        data: {skup:id},
        dataType : "JSON",
        success:function(result){
            $("#mskup").html("").val(result.skup);
            $("#mprodname").html("").val(result.namep);
            $("#mproddetail").html("").val(result.descp);
            $("#mprodobserve").html("").val(result.obsp);
            $("#mprodxpack").html("").val(result.qxp);
            $("#upricep").html("").val(result.pricep);
            $("#upricepromo").html("").val(result.priceprom);
            $("#ucantypromo").html("").val(result.cantprom);
            $("#uprodsize").html("").val(result.pesop);
            $("#ustockmin").html("").val(result.stmin);
            $("#ustockmax").html("").val(result.stmax);
            $("#uprodcat").html("").append(result.categories);
            $("#uprodstate").html("").append(result.statep);
            $("#uprodcolor").html("").append(result.colors);
            $("#sizesimbol").html("").append(result.sizes);            
            $("#ufpfin").html("").val(result.fexpromo);
            $("#uhpfin").html("").val(result.hexpromo);            
            $("#titleprod").html("Editando el producto con codigo: "+result.skup);
            $("#mprodname").focus();
            $('#ModalEditProduct').modal('show');           
            
        },
        error:function(error){
            error_noti();
        }
    });
    
}