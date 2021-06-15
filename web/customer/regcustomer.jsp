<h1><%=(request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : "")%></h1>

<div class="row">
    <div class="col-lg-12">
        <div class="card">
            <div class="card-header text-uppercase">Registrar Nuevo Cliente</div>
            <div class="card-body" id="advanced-search-form">
                <form class="form-group" method="POST" action="Ccustomer?accion=inc">


                    <!-- validar usuario existente-->
                    <div class="" id="wizard-validation-form">
                        <section>
                            <div class="form-group">
                                <div class="card">
                                    <div class="card-header text-uppercase fileimportant">Ingrese Documento de identidad. N° R.U.C./C.I.</div>
                                    <div class="card-body validardoc">
                                        <div class="input-group mb-3">                                        
                                            <input name="cdoc" id="cdocument" type="number" value="" class="form-control docidentity" placeholder="Ingrese Documento de identidad de 13 caracteres" required="">
                                            <div class="input-group-prepend buscarCliente">
                                                <span class="input-group-text btn btn-primary btn-sm"><i class='far fa-search fa-2x'></i> Validar</span>
                                            </div>                                            
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </section>
                    </div>


                    <!-- first rows-->
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="card">
                                <div class="card-header text-uppercase fileimportant">Nombre Cliente / Razon Social</div>
                                <div class="card-body">
                                    <div class="input-group mb-3">                                        
                                        <input  name="cname" type="text" class="form-control" placeholder="Ingrese sus nombres" required="">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text"><i class="fa fa-user"></i></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="card">
                                <div class="card-header text-uppercase fileimportant">Apellidos</div>
                                <div class="card-body">
                                    <div class="input-group mb-3">
                                        <input name="capep" type="text" class="form-control" placeholder="Ingrese sus apellidos" >
                                        <div class="input-group-append">
                                            <span class="input-group-text"><i class="fa fa-user"></i></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- second rows
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="card">
                                <div class="card-header text-uppercase">Apellido Materno</div>
                                <div class="card-body">
                                    <div class="input-group mb-3">                                        
                                        <input name="capem" type="text" class="form-control" placeholder="Ingrese apellido Materno" required="">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text"><i class="fa fa-user"></i></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="card">
                                <div class="card-header text-uppercase">Nombre Favorito</div>
                                <div class="card-body">
                                    <div class="input-group mb-3">
                                        <input name="calias" type="text" class="form-control" placeholder="Ingrese tu nombre favorito">
                                        <div class="input-group-append">
                                            <span class="input-group-text"><i class="fa fa-user"></i></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>-->
                    
                    <!-- third rows
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="card">
                                <div class="card-header text-uppercase">Cumpleaños</div>
                                <div class="card-body">
                                    <div class="input-group mb-3">                                        
                                        <input name="capphy" type="date" class="form-control" placeholder="Fecha cumpleaño">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text"><i class="fa fa-calendar"></i></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3">

                            <div class="card-header text-uppercase">Seleccione Género</div>

                            <div class="input-group mb-1">
                                <input name="sexo" type="radio"  value="M" class="form-control" required="">Mascolino
                                <input name="sexo" type="radio"  value="F" class="form-control" required="">Femenino
                            </div>


                        </div>
                    </div>-->

                    <!-- quarter rows-->
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="card">
                                <div class="card-header text-uppercase">Dirección</div>
                                <div class="card-body">
                                    <div class="input-group mb-3">
                                        <input name="cadress" type="text" class="form-control" placeholder="Ingrese Dirección">
                                        <div class="input-group-append">
                                            <span class="input-group-text"><i class="fa fa-cart-plus"></i></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-6">
                            <div class="card">
                                <div class="card-header text-uppercase">Correo</div>
                                <div class="card-body">
                                    <div class="input-group mb-3">                                        
                                        <input name="cemail" type="text" class="form-control" placeholder="Ingrese Correo">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">@ejemplo.com</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>


                    </div>

                    <div class="clearfix"></div>

                    <!-- fifth rows-->


                    <!-- sixth rows-->

                    <div class="row">

                        <div class="col-lg-6">
                            <div class="card">
                                <div class="card-header text-uppercase">Número Celular</div>
                                <div class="card-body">
                                    <div class="input-group mb-3">
                                        <input name="cphone" type="number" class="form-control" placeholder="Ingrese su numero telefono">
                                        <div class="input-group-append">
                                            <span class="input-group-text"><i class="fa fa-phone"></i></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="card">
                                <div class="card-header text-uppercase">Teléfono fijo</div>
                                <div class="card-body">
                                    <div class="input-group mb-3">                                        
                                        <input name="chouse" type="number" class="form-control" placeholder="Ingrese Telefono fijo">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text"><i class="fa fa-phone"></i></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>


                    </div>

                    <!-- eighth rows-->
                    <!--<div class="row">

                        <div class="col-lg-6">
                            <div class="card">
                                <div class="card-header text-uppercase">Número trabajo</div>
                                <div class="card-body">
                                    <div class="input-group mb-3">
                                        <input name="cnumwork" type="number" class="form-control" placeholder="Ingrese número trabajo">
                                        <div class="input-group-append">
                                            <span class="input-group-text"><i class="fa fa-phone"></i></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-6">
                            <div class="card">
                                <div class="card-header text-uppercase">Nombre Contacto</div>
                                <div class="card-body">
                                    <div class="input-group mb-3">                                        
                                        <input name="contac" type="text" class="form-control" placeholder="Ingrese Nombre contacto">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text"><i class="fa fa-user"></i></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>-->
                    <!-- neneth rows-->

                    <div class="form-footer">
                        <button type="reset" class="btn btn-danger"><i class="fa fa-times"></i> Borrar Formulario</button>
                        <button id="regclinew" type="submit" class="btn btn-success" disabled="true"><i class="fa fa-check-square"></i> Registrar Cliente</button>
                    </div>

                </form>
            </div>

        </div>
    </div>
</div>

<!-- modal reg persona existente-->

<div class="modal fade" id="regcustomern" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header color-tabs bg-success">
                <h5 class="modal-title">Registra Cliente Nuevo</h5>               
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span class="text-white" aria-hidden="true"><i class="fa fa-times fa-1x"></i></span>
                </button>
            </div>

            <div class="modal-body bg-github">
                <form class="form-group" method="POST" action="Ccustomer?accion=incustomer">
                    <input  name="idperson" id="idperson" type="hidden" class="form-control" value="">

                    <div class="row">
                        <div class="col-lg-6">
                            <div class="card">
                                <div class="card-header text-uppercase">Nombre Cliente </div>
                                <div class="card-body">
                                    <div class="input-group mb-3">                                        
                                        <input id="personname" name="personname" type="text" class="form-control" value=""  disabled="">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text"><i class="fa fa-user"></i></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="card">
                                <div class="card-header text-uppercase">Linea Credito Base</div>
                                <div class="card-body">
                                    <div class="input-group mb-3">
                                        <input name="linecredit" type="number" class="form-control" placeholder="Ingrese linea base" required="">
                                        <div class="input-group-append">
                                            <span class="input-group-text"><i class="fa fa-user"></i></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>  

                    <div class="form-footer">
                        <button type="button" class="btn btn-danger pull-right" data-dismiss="modal"><i class="fa fa-times fa-2x" aria-hidden="true"></i> CERRAR</button>
                        <span class="col-md-1 col-lg-1 col-md-offset-1">  </span>
                        <button type="submit" class="btn btn-warning pull-right"><i class="far fa-thumbs-up fa-2x"></i> AGREGAR</button> 

                    </div>

                </form>
            </div>
            <div class="modal-footer bg-success">
                <span class="badge badge-warning"> Cliente</span>
            </div>
        </div>
    </div>
</div>

<style>
.fileimportant{
            
   color: rgba(8, 251, 15, 0.75);
    }
</style>