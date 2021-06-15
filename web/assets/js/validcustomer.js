

var loc = window.location;
var pathName = loc.pathname.substring(0, loc.pathname.lastIndexOf('/') + 1);
var uriabsoluta = loc.href.substring(0, loc.href.length - ((loc.pathname + loc.search + loc.hash).length - pathName.length));

/*
$(function(){
    
    $("#cdocument").on("keydown", function(){
       
        var valuesearch= $("#cdocument").val();
        console.log("keydown: "+valuesearch);
        //searchperson(valuesearch);
    });
    
});*/
/*
$(document).ready(function (){
    
    $("#cdocument").click(function(){        
        var valuesearch= $(".docidentity").val();
        console.log("resultado: "+valuesearch);
        searchperson(valuesearch);
    });
    
});*/


$(".buscarCliente").click(function(){
    
     var valuesearch= $("#cdocument").val();
     console.log("Ingresastete: "+valuesearch);
        searchperson(valuesearch);
        
});



$(document).ready(function(){
    $(".docidentity").keypress(function(e) {
        //no recuerdo la fuente pero lo recomiendan para
        //mayor compatibilidad entre navegadores.
        var code = (e.keyCode ? e.keyCode : e.which);
        if(code==13){
            var valuesearch= $("#cdocument").val();
            searchperson(valuesearch);
        }
    });
});


function searchperson(doc) {
    $('.errorduplicado').remove();
    $('#idperson').val("");
    $('#idperson').val("");
    $('.errorduplicado').remove();
    
    $.ajax({
        url: uriabsoluta+"Ccustomer?accion=searchperson&docp="+doc,
        type: "GET",
        cache: false,
        contentType: false,
        processData: false,
        dataType: "json",
        
        success: function (data) {
            if (data.idpc > 0) {
                $('.validardoc').append("<label id='userName2-error' class='alert alert-defaul errorduplicado' for='userName2'>"+data.sms+"</label> <a class='errorduplicado btn btn-primary btn-sm' href='javascript:addcustomer("+data.idpc+")'><i class='far fa-user-plus fa-2x'></i> Registrar</a>");
                $('#personname').val(data.namepc.toUpperCase());
                $('#personname').text(data.namepc.toUpperCase());
                $( "#regclinew" ).prop( "disabled", true);
            }else if(data.idpc == -1){
                $('.validardoc').append("<label id='userName2-error' class='alert alert-danger errorduplicado' for='userName2'>"+data.sms+": '"+ data.namepc+"'</label> ");
                $( "#regclinew" ).prop( "disabled", true);
            }else if(data.idpc == 0){
                $('.validardoc').append("<label id='userName2-error' class='alert alert-success errorduplicado' for='userName2'>El Cliente No existe, Puede continuar registrando</label>");
                $( "#regclinew" ).prop( "disabled", false);
            }
        },
        error: function(data){            
            error_noti(""+data);  
        }
    });
}

function addcustomer(idpc){    
    $('#idperson').val(idpc);
    $('#regcustomern').modal('show');
}
