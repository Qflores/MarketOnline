
<%@page import="java.time.LocalDate"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="Entity.ProductPrice"%>
<%@page import="Dao.ProductPriceDao"%>
<%@page import="Dao.SizeDao"%>
<%@page import="Entity.Size"%>
<%@page import="Entity.Color"%>
<%@page import="Dao.ColorDao"%>
<%@page import="Entity.StockProduct"%>
<%@page import="Dao.StockProductDao"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Dao.ProductDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entity.Product"%>



<h3><%=(request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : "")%></h3>


<!-- INFORMACION CON DATATABLE --->
<div class="panel-body table-responsive">
    <table id="producto_data" class="table table-bordered table-flush" style="width: 100%;">
        <thead class="tabla-detalle-head">
            <tr>
                <th scope="col" >Item</th>
                <th scope="col" >Nombre</th>
                <th scope="col" >Estado</th>
                <th scope="col" >Stock</th>
                <th scope="col" >Color</th>
                <th scope="col" >Tamaño/Peso</th>
                <th scope="col" >Precio</th>
                <th scope="col" >Acción</th>
            </tr>
        </thead>

        <tbody class="tabledetalle">


        </tbody>


    </table>

</div>

<div class="clearfix"> </div>


<!-- modal para mostrar detalle dle producto-->

<!-- Modal: modalQuickView -->
<div class="modal fade modal-product-details" id="modalQuickView" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <div class="row">
                    <div class="col-lg-5">
                        <!--Carousel Wrapper-->
                        <div id="carousel-thumb" class="carousel slide carousel-fade carousel-thumbnails" data-ride="carousel">

                            <!--Slides-->
                            <div class="carousel-inner" role="listbox">
                                <div class="carousel-item active">
                                    <img class="d-block w-100" src="assets/images/products/canasta.jpg"
                                         alt="First slide">
                                </div>
                                <div class="carousel-item">
                                    <img class="d-block w-100" src="assets/images/products/cocina.jpg"
                                         alt="Second slide">
                                </div>
                                <div class="carousel-item">
                                    <img class="d-block w-100" src="assets/images/products/hogar.jpg"
                                         alt="Third slide">
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="col-lg-7">
                        <h2 class="h2-responsive product-name">
                            <strong id="productname" >Product Name</strong>
                        </h2>
                        <h5 class="">
                            <strong id="productsku" >Product sku</strong> <label id="productstate">estado</label>
                        </h5> 
                        <h3>Detalle Producto: </h3> <p class="productdetalle" id="productdetalle"></p>
                        <!--Accordion precio-->
                        <h4 class="h4-responsive">
                            <span class="green-text">
                                Precio Real: 
                                <s>$ <span class="badge badge-danger" id="productprice"></span></s>
                            </span><br>
                            <span class="grey-text">
                                Precio Promoción: $
                                <span class="badge badge-info" id="productprepromocion"></span>
                            </span>
                        </h4>
                        <!--Accordion tamaño-->
                        <h4 class="h4-responsive">

                            <label>Peso/Tamaño: </label>
                            <strong id="productpeso"></strong><strong id="productsimbolo"></strong>

                        </h4>

                        <!--Accordion stock producto-->
                        <h4 class="h4-responsive">
                            <label>Cantidad en Stock: </label>
                            <strong id="productstock"></strong> <small id="productsimbolo"></small>

                        </h4>

                        <h3 class="h4-responsive">
                            <label id="">Informacion Adificional</label>
                        </h3>
                        <div class="">
                            <label id="">Color: </label>  
                            <strong id="productcolor"></strong> <br>

                            <label id="">Categoría: </label>  
                            <strong id="productcategory"></strong><br>

                            <label id="">Precio Promoción: </label>  
                            <strong id="productprepromocion"></strong><br>

                            <label id="">Cantidad en promoción: </label>  
                            <strong id="cantidadpromocion"></strong><br>

                            <label id="">Fecha expiración de Promoción: </label>  
                            <strong id="fechaexpiration"></strong><br>
                        </div>



                        <div class="text-center">

                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                            <button class="btn btn-primary">Comprar ahora
                                <i class="fas fa-cart-plus ml-2" aria-hidden="true"></i>
                            </button>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!--  Modal para actualizar datos del producto--->

<div id="ModalEditProduct" class="modal fade">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header color-tabs bg-primary">
                <h1 class="modal-title" id="titleprod"></h1>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span class="text-white" aria-hidden="true"><i class="fa fa-times fa-1x"></i></span>
                </button>
            </div> 
            <div class="modal-body bg-dark">
                <form role="form" method="POST" action="Cproduct?accion=update"> 

                    <div class="form-row">
                        <input type="hidden" name="mskup" id="mskup" value="">
                        <div class="rows col-lg-6 col-md-12 col-sm-12">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="inputGroupPrepend3">Nombre</span>
                                </div>
                                <input type="text" name="mprodname" id="mprodname" class="form-control is-invalid"  placeholder="Nombre producto" aria-describedby="inputGroupPrepend3" required>
                                <div class="invalid-feedback"></div>
                            </div>

                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="inputGroupPrepend3">Detalle</span>
                                </div>
                                <textarea class="form-control" name="mproddetail" id="mproddetail"></textarea>

                                <div class="invalid-feedback"></div>
                            </div>

                            <div class="clearfix"></div>
                            <br>

                        </div>

                        <div class="rows col-lg-6 col-md-12 col-sm-12">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="inputGroupPrepend3">Observación</span>
                                </div>
                                <input type="text" name="mprodobserve" id="mprodobserve" class="form-control is-invalid" id="validationServerObserve" placeholder="Observación del producto" aria-describedby="inputGroupPrepend3">
                                <div class="invalid-feedback"></div>
                            </div>

                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="inputGroupPrepend3">Unidades en paquete</span>
                                </div>
                                <input name="mprodxpack" id="mprodxpack" type="number" step="0.01" min="0.00" class="form-control is-invalid" placeholder="Unidades por paquete" aria-describedby="inputGroupPrepend3">
                                <div class="invalid-feedback"></div>
                            </div>
                        </div>


                        <div class="rows col-lg-6 col-md-12 col-sm-12">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="inputGroupPrepend3">Precio Unitario $ </span>
                                </div>
                                <input name="prodprice" id="prodprice" type="number" step="0.010"   min="0.000"  class="form-control is-invalid" placeholder="Precio Unitario" aria-describedby="inputGroupPrepend3" required="" />
                                <div class="invalid-feedback"></div>
                            </div>

                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="inputGroupPrepend3">Precio Promoción $ </span>
                                </div>
                                <input name="pricepromo" id="pricepromo" type="number" step="0.010" min="0.000"  class="form-control is-invalid" placeholder="Precio Promoción" aria-describedby="inputGroupPrepend3" />

                                <div class="invalid-feedback"></div>
                            </div>                            
                        </div>

                        <div class="rows col-lg-6 col-md-12 col-sm-12">                          
                            <div class="input-group">                                
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="inputGroupPrepend3">Cantidad en promoción</span>
                                </div>
                                <input name="cantypromo" id="cantypromo" type="number"  step="0.01" min="0.00" class="form-control is-invalid" placeholder="Cantidad de productos en promoción" aria-describedby="inputGroupPrepend3" />
                                <div class="invalid-feedback"></div>
                            </div>
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="inputGroupPrepend3">Fecha fin promoción</span>
                                </div>
                                <input name="fpfin" id="fpfin" type="date" value="" class="form-control is-invalid" placeholder="Promoción expira en" aria-describedby="inputGroupPrepend3" />
                                <div class="invalid-feedback"></div>
                            </div>                            
                        </div>

                        <div class="rows col-lg-6 col-md-12 col-sm-12"> 
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="inputGroupPrepend3">Hora fin promoción</span>
                                </div>
                                <input name="hpfin" id="hpfin" value="" type="time" class="form-control is-invalid"  min="00:00:01" step="1" placeholder="" aria-describedby="inputGroupPrepend3"/>
                                <div class="invalid-feedback"></div>
                            </div>

                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="inputGroupPrepend3">Estado</span>
                                </div>
                                <select  name="prodstate" id="prodstate" class="form-control">
                                </select>
                                <div class="invalid-feedback"></div>
                            </div>
                            <div class="clearfix"></div>
                            <br>
                        </div>

                        <div class="rows col-lg-6 col-md-12 col-sm-12">

                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="inputGroupPrepend3">Peso</span>                                    
                                </div>
                                <input name="prodsize" id="prodsize" type="number" step="0.10" min="0.00"  class="form-control">
                                <div class="input-group-append">
                                    <select  name="sizesimbol" id="sizesimbol" class="form-control">
                                        <option class="dropdown-item" value="1">Select size</option>
                                        <option class="dropdown-item" value="2">md</option>
                                    </select>
                                </div>
                                <div class="invalid-feedback"></div>                                
                            </div>
                            <div class="clearfix"></div>
                            <br>
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="inputGroupPrepend3">Color</span>
                                </div>
                                <select  name="prodcolor" id="prodcolor" class="form-control">                                  
                                </select>       
                                <div class="invalid-feedback"></div>
                            </div>
                            <div class="clearfix"></div>
                            <br>
                        </div>

                        <div class="rows col-lg-6">
                            <div class="input-daterange  input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="inputGroupPrepend3">Stock</span>
                                </div>
                                <input class="form-control" name="stockmin" id="stockmin" step="0.1" min="0.00" type="number" placeholder="Mínimo" />
                                <div class="input-group-prepend">
                                    <span class="input-group-text">
                                        Hasta
                                    </span>
                                </div>
                                <input class="form-control" name="stockmax" id="stockmax" step="0.1" min="0.00"  type="number" placeholder="Máximo"/>                                
                            </div>
                            <div class="clearfix"></div>                            
                            <br>
                        </div>

                        <div class="rows col-lg-6">    

                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="inputGroupPrepend3">Categoría</span>
                                </div>
                                <select name="prodcat" id="prodcat" class="form-control">
                                </select>
                            </div>
                        </div>
                    </div>
                     <div class="form-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal"> <i class="fa fa-times"></i> CANCELAR</button>
                        <button type="submit" class="btn btn-success"><i class="fa fa-check-square-o"></i> GUARDAR</button>
                    </div>  
                </form>
            </div>
            <div class="modal-footer bg-primary">

            </div>
        </div>
    </div>
</div>


<style>
    .dataTables_wrapper .dataTables_length{
	float: left !important;

}

.dataTables_wrapper .dataTables_filter {
   float: right !important;
   text-align: right !important;
}
</style>


