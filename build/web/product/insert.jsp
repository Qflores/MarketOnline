
<%@page import="Entity.Color"%>
<%@page import="Dao.ColorDao"%>
<%@page import="Dao.TypeProductDao"%>
<%@page import="Entity.TypeProduct"%>
<%@page import="java.util.Iterator"%>
<%@page import="Entity.Size"%>
<%@page import="java.util.List"%>
<%@page import="Dao.SizeDao"%>

<h1><%=(request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : "")%></h1>
<%=(request.getAttribute("newproduct") != null ? request.getAttribute("newproduct") : "")%> 
<%=(request.getAttribute("newprice") != null ? request.getAttribute("newprice") : "")%>

<div class="row">
    <div class="col-lg-12">
        <div class="card">
            <div class="card-header text-uppercase">Registrar Nuevo Producto</div>
            <div class="card-body">
                <form class="form-group searchandvalidate" method="POST" action="Cproduct?accion=insertp" onkeypress="return pulsar(event)">

                    <div class="col-lg-auto" style="display: flex; ">                        
                        <div class="form-group col-lg-6">
                            <label for="Forname" class="fileimportant">Código Producto</label>
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="far fa-key"></i></span>
                                </div>
                                <input type="number" name="prodsku" class="form-control searchvalidate" id="prodsku" aria-describedby="skuHelp" placeholder="Ingrese SKU Producto" required="" />
                                <div class="input-group-append">
                                    <span class="input-group-text btn btn-primary" id="isvalidsku"><i class="fa fa-search fa-2x"></i> Validar</span>
                                </div>
                            </div>
                            <small id="skuHelp" class="form-text text-muted alert alert-danger"><%=(request.getAttribute("skup") != null ? request.getAttribute("skup") : "")%></small>
                        </div> 

                        <div class="form-group col-lg-6">
                            <label for="Forname" class="fileimportant">Nombre Producto</label>
                            <input value="" type="text" name="namep" class="form-control" id="namep" aria-describedby="nameHelp" placeholder="Ingrese Nombre Producto" required="" />
                            <small id="nameHelp" class="form-text text-muted alert alert-danger"><%=(request.getAttribute("namep") != null ? request.getAttribute("namep") : "")%></small>
                        </div>
                    </div>   

                    <div class="col-lg-auto" style="display: flex; ">   
                        <div class="form-group col-lg-6">                            
                            <label for="descripcionp">Ingrese Descripción del Producto</label>
                            <textarea name="descripcionp" class="form-control" id="descripcionp" rows="3" placeholder="Ingrese Descripción del producto"></textarea>
                        </div> 

                        <div class="form-group col-lg-6">
                            <label for="Forname">Observación del producto</label>
                            <textarea name="observacionp" class="form-control" id="observacionp" rows="3"  placeholder="Opciona! Ingrese Observaciones"></textarea>
                        </div>
                    </div>

                    <div class="col-lg-auto" style="display: flex; ">
                        <div class="form-group col-lg-6">
                            <label for="forname" class="fileimportant">Ingrese tamaño producto</label>
                            <small id="tamanioHelp" class="form-text text-muted alert alert-danger"><%=(request.getAttribute("sizep") != null ? request.getAttribute("sizep") : "")%></small>

                            <div class="input-group"> 
                                <input name="tamanio" id="tamanio" type="number" step="0.01" min="0.00" class="form-control" placeholder="Tamaño/Peso" />
                                
                                <div class="input-group-append">
                                    <select class="form-control" id="simbolo" name="simbolo">
                                        <option value="" class="fileimportant" >Seleccione una medida</option>
                                        <%
                                            SizeDao sized = new SizeDao();
                                            List<Size> listaSize = sized.ListByPag("", 0, 30);//pasando parametros al dao producto
                                            Iterator<Size> iterSize = listaSize.iterator();
                                            Size sizel = null;
                                            if (listaSize.size() > 0) {

                                                while (iterSize.hasNext()) {
                                                    sizel = iterSize.next();
                                        %>       
                                        <option value="<%=sizel.getId()%>"><%= sizel.getSimbolo()%></option>
                                        <% }
                                            }
                                        %>

                                    </select>

                                </div>
                            </div>
                            <small id="simbolHelp" class="form-text text-muted alert alert-danger"><%=(request.getAttribute("simbol") != null ? request.getAttribute("simbol") : "")%></small>
                        </div> 
                        <div class="form-group col-lg-6">
                            <label for="estadop">Seleccione estado del producto</label>
                            <small id="stateprod" class="form-text text-muted alert alert-danger" ></small>
                            <select class="form-control form-control-sm" id="estadop" name="estadop">
                                <option value="a" selected="">Activo</option>
                                <option value="i">Inactivo</option>
                            </select>                            
                        </div>
                    </div>

                    <div class="col-lg-auto" style="display: flex;">
                        <div class="form-group col-lg-6">
                            <label for="Forname" class="fileimportant">Seleccione Categoría</label>
                            <small id="cantegoryHelp" class="form-text text-muted alert alert-danger"><%=(request.getAttribute("category") != null ? request.getAttribute("category") : "")%></small>
                            <select class="form-control form-control-sm" id="categoria" name="categoria">

                                <option value="">Elija una opción</option>

                                <%
                                    TypeProductDao catepD = new TypeProductDao();
                                    List<TypeProduct> listCat = catepD.ListByPag("", 0, 30);
                                    Iterator<TypeProduct> iterCat = listCat.iterator();
                                    TypeProduct viewCat = null;

                                    if (listCat.size() > 0) {
                                        while (iterCat.hasNext()) {
                                            viewCat = iterCat.next();
                                %>
                                <option value="<%= viewCat.getId()%>"><%=viewCat.getName()%></option>


                                <% }

                                    }
                                %>
                            </select>

                        </div>
                        <div class="form-group col-lg-6">
                            <label for="Forname">Seleccione un color</label>
                            <small id="colorHelp" class="form-text text-muted alert alert-danger"><%=(request.getAttribute("colorprod") != null ? request.getAttribute("colorprod") : "")%></small>
                            <select class="form-control form-control-sm" id="colorp" name="colorp">                                

                                <%
                                    ColorDao colordao = new ColorDao();
                                    List<Color> listCl = colordao.ListByPag("", 0, 30);
                                    Iterator<Color> iterColor = listCl.iterator();
                                    Color newColor = null;

                                    if (listCl.size() > 0) {

                                        while (iterColor.hasNext()) {
                                            newColor = iterColor.next();
                                %>

                                <option value="<%= newColor.getId()%>" selected=""><%= newColor.getName()%></option>


                                <%
                                        }
                                    }
                                %>
                            </select>
                        </div>                        
                    </div>

                    <div class="col-lg-auto" style="display: flex;">
                        <div class="form-group col-lg-6">
                            <label for="Forname">Ingrese Stock Mínimo y Máximo</label>
                            <div class="input-group">
                                <input type="number" step="0.01" min="0.00" name="stockmin" class="form-control" id="stockmin" aria-describedby="stockminHelp" placeholder="Stock Mínimo" />
                                <div class="input-group-prepend">
                                    <span class="input-group-text">Hasta</span>
                                </div>
                                <input type="number" step="0.001" min="0.00" name="stockmax" class="form-control" id="stockmax" aria-describedby="stockmaxHelp" placeholder="Stock Máximo" />
                            </div>

                            <small id="stockminHelp" class="form-text text-muted alert alert-danger"><%=(request.getAttribute("stockmin") != null ? request.getAttribute("stockmin") : "")%></small>
                        </div>
                        <div class="form-group col-lg-6">
                            <label for="Forname">Ingrese Cantidad por paquete</label>
                            <input name="cantpack" type="number" step="0.10"  class="form-control" id="cantpack" aria-describedby="cantpackHelp" placeholder="Ingrese la cantidad de productos por paquete" />
                            <small id="cantpackHelp" class="form-text text-muted alert alert-danger"><%=(request.getAttribute("cantpack") != null ? request.getAttribute("cantpack") : "")%></small>
                        </div> 
                    </div>

                    <br class="offset-10">

                    <fieldset class="scheduler-border">
                        <legend class="scheduler-border">Precio Producto</legend>
                        <div class="col-lg-auto" style="display: flex;">
                            <div class="form-group col-lg-6">
                                <label for="Forname" class="fileimportant">Ingrese Precio Producto</label>
                                <small id="pricepHelp" class="form-text text-muted alert alert-danger"><%=(request.getAttribute("cantp") != null ? request.getAttribute("cantp") : "")%></small>
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">$ </span>
                                    </div>
                                    <input type="number" name="pricep" id="pricep"  step="0.01" min="0.00" class="form-control"   placeholder="000.00" required="" />
                                </div>
                            </div>
                            <div class="form-group col-lg-6">
                                <label for="Forname">Ingrese Precio Promocion</label>
                                <small id="pricepromoHelp" class="form-text text-muted alert alert-danger"><%=(request.getAttribute("pricep") != null ? request.getAttribute("pricep") : "")%></small>
                                <div class="input-group mb-3">                                    
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">$ </span>
                                    </div>                                    
                                    <input class="form-control" type="number" name="pricepromo" id="pricepromo"  step="0.00"  placeholder="Precio Promoción" />
                                </div>                                
                            </div>

                        </div>

                        <div class="form-product col-lg-auto" style="display: flex;">
                            <div class="form-group col-lg-6">
                                <label for="Forname">Cantidad de producto en promocion</label>
                                <small id="cantHelp" class="form-text text-muted alert alert-danger"><%=(request.getAttribute("promo") != null ? request.getAttribute("promo") : "")%></small>
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">$ </span>
                                    </div>
                                    <input value="" type="text" name="cantpromo" id="cantpromo" class="form-control"   placeholder="####.00 Opcional" />                                    
                                </div>
                            </div>
                            <div class="form-group col-lg-6">
                                <label for="Forname">Fecha de expiracion de promocion</label>
                                <small id="fechaHelp" class="form-text text-muted alert alert-danger"><%=(request.getAttribute("fecha") != null ? request.getAttribute("fecha") : "")%></small>
                                <div class="input-group mb-3">                                    
                                    <div class="input-group-prepend">
                                        <span class="input-group-text"><i class="fa fa-calendar"></i></span>
                                    </div>
                                    <input id="fechaex" name="fechaex" type="date" class="form-control" value="" />
                                    <input id="horaex" name="horaex" type="time" class="form-control" value="" />
                                </div>
                            </div>

                        </div>

                    </fieldset>


                    <div class="clearfix"></div>
                    <div class="well span2 "></div>
                    <br><br>
                    <div class="" style="">
                        <input type="reset" class="btn btn-warning btn-md" name="resetform" value="Borrar Formulario">

                        <input type="submit" class="btn btn-primary btn-md" name="insertp" value="Registrar Producto">
                    </div>   


                </form>
            </div>

        </div>    
    </div>

    <style>
        fieldset.scheduler-border {
            border: 1px groove #ddd !important;
            padding: 3px 4px;
            -webkit-box-shadow:  0px 0px 0px 0px #000;
            box-shadow:  0px 0px 0px 0px #000;
        }

        legend.scheduler-border {
            font-size: 1.2em !important;
            font-weight: bold !important;
            text-align: left !important;
        }
        fieldset legend {
            padding: 5px 0 0 0;
            margin: 0 0 0 2em;
        }

        .alert-danger {color: #ffffff !important; padding: 0px 10px;}
        
        .fileimportant{
            
            color: rgba(8, 251, 15, 0.75);
        }
    </style>
    <!-- Modal HTML Markup -->


</div>

                                

<!-- para actualizar preco del producto, Modal para actualizar datos del producto--->

<div id="ModalEditProduct" class="modal fade">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header color-tabs bg-primary">
                <h1 class="modal-title" id="titleprod">Editar Producto</h1>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span class="text-white" aria-hidden="true"><i class="fa fa-times fa-1x"></i></span>
                </button>
            </div> 
            <div class="modal-body bg-dark">
                <form role="form" method="POST" action="Cproduct?accion=update">

                    <div class="form-row">
                        <input type="hidden" name="mskup" id="mskup" value="">
                        <input type="hidden" name="uprodexist" id="mskup" value="true">
                        
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
                                <input name="mprodxpack" id="mprodxpack" type="number" step="0.01" class="form-control is-invalid" placeholder="Unidades por paquete" aria-describedby="inputGroupPrepend3">
                                <div class="invalid-feedback"></div>
                            </div>
                        </div>


                        <div class="rows col-lg-6 col-md-12 col-sm-12">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="inputGroupPrepend3">Precio Unitario $</span>
                                </div>
                                <input name="prodprice" id="upricep" type="number" step="0.01" class="form-control is-invalid" placeholder="Precio Unitario" aria-describedby="inputGroupPrepend3" required="" />
                                <div class="invalid-feedback"></div>
                            </div>

                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="inputGroupPrepend3">Precio Promoción $</span>
                                </div>
                                <input name="pricepromo" id="upricepromo" type="number" step="0.01" class="form-control is-invalid" placeholder="Precio Promoción" aria-describedby="inputGroupPrepend3" />

                                <div class="invalid-feedback"></div>
                            </div>                            
                        </div>

                        <div class="rows col-lg-6 col-md-12 col-sm-12">                          
                            <div class="input-group">                                
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="inputGroupPrepend3">Cantidad en promoción</span>
                                </div>
                                <input name="cantypromo" id="ucantypromo" type="number"  step="0.01" class="form-control is-invalid" placeholder="Cantidad de productos en promoción" aria-describedby="inputGroupPrepend3" />
                                <div class="invalid-feedback"></div>
                            </div>
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="inputGroupPrepend3">Fecha fin promoción</span>
                                </div>
                                <input name="fpfin" id="ufpfin" type="date" value="" class="form-control is-invalid" placeholder="Promoción expira en" aria-describedby="inputGroupPrepend3" />
                                <div class="invalid-feedback"></div>
                            </div>                            
                        </div>

                        <div class="rows col-lg-6 col-md-12 col-sm-12"> 
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="inputGroupPrepend3">Hora fin promoción</span>
                                </div>
                                <input name="hpfin" id="uhpfin" value="" type="time" class="form-control is-invalid"  placeholder="" aria-describedby="inputGroupPrepend3"/>
                                <div class="invalid-feedback"></div>
                            </div>

                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="inputGroupPrepend3">Estado</span>
                                </div>
                                <select  name="prodstate" id="uprodstate" class="form-control">
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
                                <input name="prodsize" id="uprodsize" type="number" step="0.01" class="form-control">
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
                                <select  name="prodcolor" id="uprodcolor" class="form-control">                                  
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
                                <input class="form-control" name="stockmin" id="ustockmin" step="0.01" type="number" placeholder="Mínimo" />
                                <div class="input-group-prepend">
                                    <span class="input-group-text">
                                        Hasta
                                    </span>
                                </div>
                                <input class="form-control" name="stockmax" id="ustockmax" step="0.01" type="number" placeholder="Máximo"/>                                
                            </div>
                            <div class="clearfix"></div>                            
                            <br>
                        </div>

                        <div class="rows col-lg-6">    

                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="inputGroupPrepend3">Categoría</span>
                                </div>
                                <select name="prodcat" id="uprodcat" class="form-control">
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="form-footer">

                        <button type="button" class="btn btn-danger pull-right" data-dismiss="modal"><i class="fa fa-times fa-2x" aria-hidden="true"></i> Cerrar</button>
                        <button type="submit" class="btn btn-warning pull-right"><i class="far fa-thumbs-up fa-2x"></i> Update Product</button> 
                    </div>
                </form>
            </div>
            <div class="modal-footer bg-primary">

            </div>
        </div>
    </div>
</div>                              