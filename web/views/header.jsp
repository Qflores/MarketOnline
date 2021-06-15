<%-- 
    Document   : header
    Created on : 11-feb-2019, 14:02:56
    Author     : QfloresRA
--%>
<%
    String css = "views/assets/css/";
    String js = "views/assets/js/";
    String fonts = "views/assets/fonts/";
%>

<!DOCTYPE html>
<html lang="">

    <head>

        <meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <meta mame="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
        <meta name="description" content="Venta de productos de primera necesidad">
        <meta name="author" content="Quincho flores elver">

        <title>Panel Administrativo: Minimarket Mary-luz</title>

        <link rel="icon" type="image/x-icon" href="assets/images/Pink_Diamond.png">



        <!-- Vector CSS -->
        <link href="assets/plugins/vectormap/jquery-jvectormap-2.0.2.css" rel="stylesheet"/>
        <!-- simplebar CSS-->        
        <link href="assets/plugins/simplebar/css/simplebar.css" rel="stylesheet"/>
        <!-- Bootstrap core CSS-->	
        <link href="assets/css/bootstrap.min.css" rel="stylesheet"/>
        <!-- animate CSS-->
        <link href="assets/css/animate.css" rel="stylesheet" type="text/css"/>
        <!-- Icons CSS-->
        <link href="assets/css/icons.css" rel="stylesheet" type="text/css"/>
        <!--Style autocomplete-->
        <link href="assets/css/autocomplete.css" rel="stylesheet" type="text/css">


        <%
            String _uricss_ = "" + ((String) request.getAttribute("page"));
            if (_uricss_.equals("product/listar") || _uricss_.equals("customer/listcustomer") || _uricss_.equals("ventas/listventa") || _uricss_.equals("ventas/ventanueva")) {
        %>
        <link href="assets/plugins/bootstrap-datatable/css/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css">
        <link href="assets/plugins/bootstrap-datatable/css/buttons.bootstrap4.min.css" rel="stylesheet" type="text/css">
        <!--Bootstrap Datepicker-->
        <link href="assets/plugins/bootstrap-datepicker/css/bootstrap-datepicker.min.css" rel="stylesheet" type="text/css">
        

        <%
            }
        %>
        <!-- Sidebar CSS-->
        <link href="assets/css/sidebar-menu.css" rel="stylesheet"/>
        <!-- Custom Style-->
        <link href="assets/css/app-style.css" rel="stylesheet"/>
        <!-- icon fondawesome -->
        <!-- <link rel="stylesheet" type="text/css" href="assets/css/fontawesome.min.css"> -->
        <link rel="stylesheet" type="text/css" href="assets/css/all.min.css"> 


        <!-- Notification css -->
        <link rel="stylesheet" href="assets/plugins/notifications/css/lobibox.min.css"/>

        <!-- Dropzone css -->
        <link href="assets/plugins/dropzone/css/dropzone.css" rel="stylesheet" type="text/css">

    </head>

    <body class="bg-theme bg-theme6">
        <!-- start loader 
        <div id="pageloader-overlay" class="visible incoming">
            <div class="loader-wrapper-outer">
                <div class="loader-wrapper-inner" >
                    <div class="loader"></div>
                </div>
            </div>
        </div>-->
        <!-- end loader -->

        <!-- start wrapper -->
        <div id="wrapper">