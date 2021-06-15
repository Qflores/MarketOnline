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
<script src="assets/plugins/notifications/js/lobibox.min.js">  </script>
<script src="assets/plugins/notifications/js/notification-custom-script.js">  </script>

<!-- Dropzone JS upload files -->
<script src="assets/plugins/dropzone/js/dropzone.js"></script>
<!-- Dropzone JS upload files -->
<script src="assets/autocomplete/jquery.autocomplete.js"></script>
<script src="assets/autocomplete/jquery.mockjax.js"></script>

<%
    String namepag = ""+((String) request.getAttribute("page"));
    String jqueryfile = "";
    if (namepag.equalsIgnoreCase("product/listar")  ) {
            jqueryfile = "listpro.js";
    }else if(namepag.equalsIgnoreCase("product/insert")){
            jqueryfile = "insertpro.js";
    
    }else if(namepag.equalsIgnoreCase("customer/regcustomer")){
        jqueryfile = "validcustomer.js";
    }else if(namepag.equalsIgnoreCase("customer/listcustomer")){
        
        jqueryfile = "listcustomer.js";
    }else if(namepag.equalsIgnoreCase("ventas/listventa")){
        jqueryfile = "listpayment.js";
    }else if(namepag.equalsIgnoreCase("ventas/ventanueva")){
        jqueryfile = "makesales.js";
    }
    else{
            jqueryfile = "index.js";
      }
    %>

       
        <%
            if (namepag.equalsIgnoreCase("product/listar") || namepag.equalsIgnoreCase("customer/listcustomer") || namepag.equalsIgnoreCase("ventas/listventa") || namepag.equalsIgnoreCase("ventas/ventanueva")) {
        %>
              <!--Data Tables js-->
              <!--<script src="assets/js/jquery.dataTables.min.js"></script>-->
              
        <script src="assets/plugins/bootstrap-datatable/js/jquery.dataTables.min.js"></script>
        <script src="assets/plugins/bootstrap-datatable/js/dataTables.bootstrap4.min.js"></script>
        <script src="assets/plugins/bootstrap-datatable/js/dataTables.buttons.min.js"></script>
        <script src="assets/plugins/bootstrap-datatable/js/buttons.bootstrap4.min.js"></script>
        <script src="assets/plugins/bootstrap-datatable/js/jszip.min.js"></script>
        <script src="assets/plugins/bootstrap-datatable/js/pdfmake.min.js"> </script>
        <script src="assets/plugins/bootstrap-datatable/js/vfs_fonts.js"></script>
        <script src="assets/plugins/bootstrap-datatable/js/buttons.html5.min.js"></script>
        <script src="assets/plugins/bootstrap-datatable/js/buttons.print.min.js"></script>
        <script src="assets/plugins/bootstrap-datatable/js/buttons.colVis.min.js"></script>
        
        <!-- editable js -->
        
        
        
        <% }  %>


<script src="assets/js/<%=jqueryfile%>"></script>




</body>
</html>
