<h5 class="form-header text-uppercase"><i class="fa fa-cart-plus"></i> Realizar Ventas</h5>

<div class="messageout"></div>
<h4><%=(request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : "")%></h4>
<div class="row">
    <div class="col-lg-12">
        <div class="card">
            <div class="card-body">
                <form id="signupForm" action="" method="POST"  onkeypress="return pulsar(event)">

                    <!-- almacenamos el identity del cliente-->
                    <input name="customid" value="1" id="customid" type="hidden" class="form-control"   >
                    <!-- almacenamos el id del vendedor -->
                    <input name="numdoc" value="12345678" id="numdoc" type="hidden" class="form-control">
                    <!-- monto TOTal -->
                    <input name="amountv" value="" id="amountv" type="hidden" class="form-control amountv">

                    <!-- Cabecero de ventas -->
                    <div class="form-group row">
                        <label for="input-10" class="col-sm-2 col-form-label" disabled="">CÓDIGO DE LA BOLETA</label>
                        <div class="col-sm-4">
                            <input name="codBol" value="S-001-001-" type="text" class="form-control" id="input-10"  disabled="">
                        </div>
                        <label for="input-10" class="col-sm-2 col-form-label" disabled="">FECHA DE LA VENTA:</label>
                        <div class="col-sm-4">
                            <input name="fechav"  type="text" class="form-control" id="fechanew" value="" disabled="">
                        </div>
                    </div>
                    <div class="form-group row">

                        <label for="input-10" class="col-sm-2 col-form-label">NOMBRE DEL CLIENTE</label>
                        <div class="col-sm-4">
                            <input  type="text" name="namecli" value="" class="search-box form-control" id="namecli" placeholder="Ingres Nombre o DNI">
                            <span title="Borrar" class="close-icon" id="close-icon"> &timesbar;</span>
                        </div>
                        <!--<label for="input-11" class="col-sm-2 col-form-label" >Address</label>
                        <div class="col-sm-4">-->
                        <!--<input name="address" value="" type="hidden" class="form-control" id="direccion"  disabled="">
                         </div>-->
                        <label for="input-13" class="col-sm-2 col-form-label">FORMA DE PAGO:</label>
                        <div class="col-sm-4">
                            <select name="typePay" id="typePay" class="form-control" style="color: #01ff44 !important">
                                <option value="1">Pago en efectivo</option>
                                <option value="2">Pago en cuotas</option>
                                <option value="3">Pago con tarjeta</option>
                                <option value="4">Otros</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group row">
                        
                    </div>

                    <hr class="new1" style="height: 0px; margin-top: 2.5px !important">

                    <div class="form-group row" style="margin-top: 0px; margin-right: -1.0%; margin-left: -1.4%; align-items: center;">

                        <div class="col-lg-4">                            
                            <button type="button" class="btn btn-primary btn-lg btn-md waves-effect waves-light m-1 listproductos" onclick="ArticleList();"><i class="fa fa-cart-plus fa-1x"></i> Agregar Producto</button>                            
                            
                        </div>

                        <div class="col-lg-8">  
                            <div class="input-group" id="group-searching">
                                <input  name="skup" id="skup" value="" type="text" class="idskup form-control" placeholder="Ingrese codigo Producto" title="CÓDIGO DEL PRODUCTO"  maxlength="20" autofocus="autofocus">
                                <input  name="namep" value="" id="namep" type="text" class="form-control" placeholder="Nombre producto" readonly >
                                <input  name="sizep" value="" id="sizep" type="text" class="form-control" placeholder="peso/tamaño" title="TAMAÑO/PESO" readonly>
                                <input  name="pricep" value="" id="pricep" type="number" class="form-control" placeholder="Precio Sugerido" step="0.05" min="0.05" title="PRECIO DEL PRODCUTO" maxlength="7">
                                <input  name="cantidad" id="cantidad" type="number" class="form-control" value="1" step="1.0" min="0.1" placeholder="Ingrese Cantidad" title="CANTIDAD A COMPRAR" >
                                <div class="input-group-prepend">
                                    <!--<span class="input-group-text btn btn-primary"><i class="fa fa-search fa-2x"></i> View</span>-->
                                    <span id="addToDetail" class="addToDetail input-group-text btn bg-success"><i class="fal fa-cart-plus fa-2x"></i> AGREGAR</span>
                                </div>
                            </div>
                        </div>

                    </div>
                    <hr class="new1">

                    <!-- Detalle ventas -->

                    <div class="panel-body table-responsive">
                        <table id="tablaproducto" class="table table-bordered table-flush">
                            <thead class="tabla-detalle-head">
                                <tr>
                                    <th>Items</th>
                                    <th>Nombre del poducto</th>
                                    <th>Peso/Tamaño </th>
                                    <th>Cantidad</th>
                                    <th>Precio</th>
                                    <th>Total</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody class="tabledetalle">                               

                            </tbody>
                            <tfoot> 
                                <tr>
                                    <th></th>
                                    <th></th>
                                    <th></th>
                                    <th></th>
                                    <th class="text-right bg-secondary" id="letter-monto">Monto Total S/. </th>
                                    <th class="text-left bg-secondary" id="montopagar"></th>
                                    <th></th>
                                </tr>
                            </tfoot>
                        </table>
                    </div>    

                    <!-- Botones de accion -->
                    <div class="form-footer">
                        <button type="reset" class="btn btn-danger deletepay" id="deletepay"><i class="far fa-trash-alt fa-2x"></i> CANCELAR COMPRA</button>
                        <button type="button" class="btn btn-success savepay" id="savepay"><i class="far fa-shopping-cart fa-2x"></i> COMPRAR</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div><!--End Row-->




<!-- modal reg persona existente-->
<div class="modal fade bd-example-modal-lg" id="regcustomern" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header color-tabs bg-primary">
                <h5 class="modal-title" id="exampleModalLabel">Registra Cliente Nuevo</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <div class="modal-body bg-github">     
                <form class="form-group" method="POST" action="Cventas?accion=incustomer">

                    <input  name="idperson" id="idperson" type="hidden" class="form-control" value="">

                    <div class="row">
                        <div class="col-lg-6">
                            <div class="card">
                                <div class="card-header text-uppercase">Nombre Del Cliente </div>
                                <div class="card-body">
                                    <div class="input-group mb-3">                                        
                                        <input id="nombrecliente" name="personname" type="text" class="form-control" value=""  disabled="">

                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="card">
                                <div class="card-header text-uppercase">Linea Credito Base</div>
                                <div class="card-body">
                                    <div class="input-group mb-3">
                                        <input name="linecredit" type="number" class="form-control" placeholder="Ingrese linea base" required="" value="0.0">
                                        <div class="input-group-append">
                                            <span class="input-group-text"><i class="fa fa-user"></i></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>  

                    <div class="form-footer">
                        <!--<button type="reset" class="btn btn-danger"><i class="fa fa-times"></i> CANCEL</button>-->
                        <button type="submit" class="btn btn-success" ><i class="fa fa-check-square"></i> GUARDAR</button>

                        <span class="col-md-1 col-lg-1 col-md-offset-1">  </span>
                        <button type="button" class="btn btn-danger pull-right" data-dismiss="modal"><i class="fa fa-times fa-2x" aria-hidden="true"></i> CERRAR</button>
                    </div>

                </form> 
            </div>
            <div class="modal-footer bg-primary">

                <span class="badge badge-warning"> Cliente</span>
            </div>
        </div>
    </div>
</div>





<!-- modal para buscar productos--->
<div class="modal fade" id="lista_productos_ventas" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="max-width: 90% !important;" >
        <div class="modal-content text-dark" style="background-color: #1e4638fa">
            <div class="modal-header color-tabs bg-primary">
                <h4 class="modal-title font-weight-bold">Buscar Producto</h4>

                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>

            </div>            

            <div class="modal-body"> 
                <div class="form-group col-lg-6 " style="margin-bottom: -20px !important;">                    
                    <div class="input-group">                       
                        <input class="form-control" style="border: solid #07b3d2 0.7px;" id="searchForCustomer" name="searchForCustomer" placeholder="Ingrese nombre, codigo del producto">
                        <div class="input-group-append">                            
                            <button  class="btn btn-info" name="searchForCustomerbtn" id="searchForCustomerbtn">Buscar <i class="fa fa-search fa-2x"></i> </button>
                        </div>                        
                    </div>
                </div>
                <div class="table-responsive">
                    <table id="productLists" class="table table-bordered " style="width: 100%; border-collapse: collapse !important;">
                        <thead class="listprodhead">
                            <tr>

                                <th class="">ID</th>
                                <th class="">Nombre</th>
                                <th class="min-desktop">Descripción</th>
                                <th class="min-desktop">Unid. Medida</th>
                                <th class="min-desktop">Precio</th>
                                <th class="min-desktop">Stock</th>
                                <th class="min-desktop">Foto</th>
                                <th class="min-desktop">Opción</th>
                            </tr>
                        </thead>

                        <tbody class="bg-success">                            
                        </tbody>

                    </table>
                </div>

            </div>
            <div class="modal-footer bg-primary">
                <button type="button" class="btn btn-warning pull-right" data-dismiss="modal"><i class="fa fa-times" aria-hidden="true"></i> Cerrar</button>
            </div>
        </div>
    </div>
</div>


<!-- modal para imprimir reporte --->
<div class="modal fade" id="printreporte" tabindex="-1" role="dialog" aria-labelledby="" aria-hidden="true">
    <div class="modal-dialog" style="max-width: 90% !important;" >
        <div class="modal-content text-dark" style="background-color: #1e4638fa">
            <div class="modal-header color-tabs bg-primary">
                <h4 class="modal-title font-weight-bold">Numero de Factura : <span id="numfact"></span></h4>

                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>

            </div>            

            <div class="modal-body"> 
                <div class="form-group col-lg-6 " style="margin-bottom: -20px !important;">                    
                    <div class="input-group">                       
                        <input class="form-control" style="border: solid #07b3d2 0.7px;" id="searchForCustomer" name="searchfactura" placeholder="Ingrese número de factura.">
                        <div class="input-group-append">                            
                            <button  class="btn btn-info" name="numfacturasearch" id="searchForCustomerbtn">Buscar <i class="fa fa-search fa-2x"></i> </button>
                        </div>                        
                    </div>
                </div >
                

            </div>
            <div class="modal-footer bg-primary">
                <button type="button" class="btn btn-warning pull-right" data-dismiss="modal">
                    <i class="fa fa-times" aria-hidden="true"></i> Cerrar</button>
            </div>
        </div>
    </div>
</div>

<style>
    .ui-autocomplete {
        background-color: none;
    }

</style>