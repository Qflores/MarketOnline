    

<!DOCTYPE html>


<html lang="">

    <head>
        <%@page language="java"  contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
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

        <!--< %
            String _uricss_ = "" + ((String) request.getAttribute("page"));
            if (_uricss_.equals("product/listar") || _uricss_.equals("customer/listcustomer") || _uricss_.equals("ventas/listventa") || _uricss_.equals("ventas/ventanueva")) {
        % >-->
        <link href="assets/plugins/bootstrap-datatable/css/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css">
        <link href="assets/plugins/bootstrap-datatable/css/buttons.bootstrap4.min.css" rel="stylesheet" type="text/css">
        <!--Bootstrap Datepicker-->
        <link href="assets/plugins/bootstrap-datepicker/css/bootstrap-datepicker.min.css" rel="stylesheet" type="text/css">
        <link href="assets/css/fixedHeader.dataTables.min.css" rel="stylesheet" type="text/css">
        


        <!--< %
            }
        % >-->
        <!-- Sidebar CSS-->
        <link href="assets/css/sidebar-menu.css" rel="stylesheet"/>
        <!-- Custom Style-->
        <link href="assets/css/app-style.css" rel="stylesheet"/>

        <link rel="stylesheet" type="text/css" href="assets/css/all.min.css"> 
        <!-- Notification css -->
        <link rel="stylesheet" href="assets/plugins/notifications/css/lobibox.min.css"/>

        <!-- Dropzone css -->
        <link href="assets/plugins/dropzone/css/dropzone.css" rel="stylesheet" type="text/css">

    </head>

    <body class="bg-theme bg-theme6">

        <div id="wrapper">
            <!--Incluyendo menu navegacion-->
            <%@include  file="views/menu.jsp"%>

            <% String pagina = "" + ((String) request.getAttribute("page"));

                if (pagina.equalsIgnoreCase("null")) {

                    pagina = "views/home";

                }
                String ruta = pagina + ".jsp";

            %>

            <jsp:include page='<%= ruta%>'  flush='true'/> 

            <!-- incluyendo footer-->

        </div>
        <!--End container-fluid-->
    </div>
    <!--End Content-Wrapper-->

    <!--Start Back To Top Button-->
    <a href="javaScript:void();" class="back-to-top"><i class="fa fa-angle-double-up"></i> </a>
    <!--End Back To Top Button-->

    <!--Start footer-->
    <footer class="footer">
        <div class="container">
            <div class="text-center">
                Copyright &COPY; 2019 Management System | Quincho Flores
            </div>
        </div>
    </footer>
    <!--End footer-->

</div>

<!--end wrapper-->
<!-- Bootstrap core JavaScript jquery.min1.9.   jquery-3.3.1-->
<!--<script src="assets/js/jquery.min.js"></script>-->
<script type="text/javascript" src="assets/js/jquery-3.3.1.js" charset="UTF-8"></script>
<script src="assets/js/jquery.editable.js"></script>
<script src="assets/js/popper.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>

<!-- simplebar js -->
<script src="assets/plugins/simplebar/js/simplebar.js"></script>
<!-- sidebar-menu js -->
<script src="assets/js/sidebar-menu.js"></script>

<!-- Custom scripts -->
<script src="assets/js/app-script.js"></script> 
<script src="assets/plugins/Chart.js/Chart.min.js"></script>
<!-- Chart js <script src="assets/js/index2.js"></script>-->
<!--Bootstrap Datepicker Js-->  
<script src="assets/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js"></script>
<!--Notification Js-->  
<script src="assets/plugins/notifications/js/lobibox.min.js"></script>
<script src="assets/plugins/notifications/js/notification-custom-script.js"></script>

<!-- Dropzone JS upload files -->
<script src="assets/plugins/dropzone/js/dropzone.js"></script>
<!-- Dropzone JS upload files -->
<script src="assets/autocomplete/jquery.autocomplete.js"></script>
<script src="assets/autocomplete/jquery.mockjax.js"></script>

<%
    String namepag = "" + ((String) request.getAttribute("page"));
    String jqueryfile = "";
    if (namepag.equalsIgnoreCase("product/listar")) {
        jqueryfile = "listpro.js";
    } else if (namepag.equalsIgnoreCase("product/insert")) {
        jqueryfile = "insertpro.js";

    } else if (namepag.equalsIgnoreCase("customer/regcustomer")) {
        jqueryfile = "validcustomer.js";
    } else if (namepag.equalsIgnoreCase("customer/listcustomer")) {

        jqueryfile = "listcustomer.js";
    } else if (namepag.equalsIgnoreCase("ventas/listventa")) {
        jqueryfile = "listfacts.js";
    } else if (namepag.equalsIgnoreCase("ventas/ventanueva")) {
        jqueryfile = "makesales.js";
    } else {
        jqueryfile = "index.js";
    }
%>

<!--
< %
    if (namepag.equalsIgnoreCase("product/listar") || namepag.equalsIgnoreCase("customer/listcustomer") || namepag.equalsIgnoreCase("ventas/listventa") || namepag.equalsIgnoreCase("ventas/ventanueva")) {
% >-->
<!--Data Tables js-->
<!--<script src="assets/js/jquery.dataTables.min.js"></script>-->
<script src="assets/plugins/bootstrap-datatable/js/jquery.dataTables.min.js"></script>
<script src="assets/plugins/bootstrap-datatable/js/dataTables.bootstrap4.min.js"></script>
<script src="assets/plugins/bootstrap-datatable/js/dataTables.buttons.min.js"></script>
<script src="assets/plugins/bootstrap-datatable/js/buttons.bootstrap4.min.js"></script>
<script src="assets/plugins/bootstrap-datatable/js/jszip.min.js"></script>
<script src="assets/plugins/bootstrap-datatable/js/pdfmake.min.js"></script>
<script src="assets/plugins/bootstrap-datatable/js/vfs_fonts.js"></script>
<script src="assets/plugins/bootstrap-datatable/js/buttons.html5.min.js"></script>
<script src="assets/plugins/bootstrap-datatable/js/buttons.print.min.js"></script>
<script src="assets/plugins/bootstrap-datatable/js/buttons.colVis.min.js"></script>
<script src="assets/plugins/alerts-boxes/js/sweetalert.min.js"></script>
<!-- editable js -->

<!--< % } %>-->

<script src="assets/js/<%=jqueryfile%>"></script>
<script src="assets/js/home.js"></script>
</body>
</html>             