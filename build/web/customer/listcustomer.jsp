

<h1><%=(request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : "")%></h1>

<!-- INFORMACION CON DATATABLE --->

<div class="panel-body table-responsive">

    <table id="customer_data" class="table table-bordered table-striped">

        <thead class="thead-dark">
            <tr>
                <th scope="col" width="15%">Nombre CLiente</th>
                <th scope="col" width="10%">R.U.C./C.U.</th>
                <th scope="col" width="20%">Dirección</th>
                <th scope="col" width="15%">E-mail</th>
                <th scope="col" width="10%">Teléfono</th>                
                <th scope="col" width="10%">Linea Credito</th>
                <th scope="col" width="10%">Linea Acumulada </th>
                <th scope="col" width="10%">Acciónes</th>
            </tr>
        </thead>

        <tbody>


        </tbody>


    </table>

</div>


<div class="clearfix"> </div>


<!-- modal para mostrar detalle dle producto-->

<!-- Modal: modalQuickView -->
<div class="modal fade modal-product-details" id="updatecurtomer" tabindex="-1" role="dialog" aria-labelledby="updatecurtomer"
     aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header color-tabs bg-primary">
                <h1 class="modal-title" id="titleprod"></h1>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span class="text-white" aria-hidden="true"><i class="fa fa-times fa-1x"></i></span>
                </button>
            </div> 
            <div class="modal-body bg-dark">
                
            <div class="modal-body">

                <div class="row">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-body">
                                <form id="signupForm" class="form-group searchandvalidate" method="POST" action="Ccustomer?accion=updatec" onkeypress="return pulsar(event)">
                                    <h4 class="form-header text-uppercase">
                                        <i class="fa fa-address-book-o"></i>
                                        Datos del Cliente
                                    </h4>
                                    <div class="form-group row"> 
                                        
                                        <input type="hidden" class="form-control" id="idper" name="idper">
                                        
                                        <label for="input-11" class="col-sm-2 col-form-label">Documento</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" id="doc" disabled="">
                                        </div>                                       
                                        
                                        <label for="input-11" class="col-sm-2 col-form-label">Nombres</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" id="name" name="name">
                                        </div>
                                        <label for="input-11" class="col-sm-2 col-form-label">Apellidos</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" id="ape" name="ape">
                                        </div>                                        
                                    </div>
                                    <h4 class="form-header text-uppercase">
                                        <i class="fa fa-envelope-o"></i>
                                        Datos de cuenta
                                    </h4>
                                    <div class="form-group row">
                                        <label for="input-12" class="col-sm-2 col-form-label">Linea Acumulada</label>
                                        <div class="col-sm-4">
                                            <input type="number"  min="0.00" step="0.01" class="form-control" id="line1" name="line1">
                                        </div>
                                        <label for="input-13" class="col-sm-2 col-form-label">Linea Total</label>
                                        <div class="col-sm-4">
                                            <input type="number" min="0.00" step="0.01"  class="form-control" id="line2" name="line2">
                                        </div>
                                    </div>
                                    <h4 class="form-header text-uppercase">
                                        <i class="fa fa-envelope-o"></i>
                                        Datos de Referencia
                                    </h4>

                                    <div class="form-group row">
                                        <label for="input-14" class="col-sm-2 col-form-label">E-mail</label>
                                        <div class="col-sm-4">
                                            <input type="email" class="form-control" id="email" name="email">
                                        </div>
                                        <label for="input-14" class="col-sm-2 col-form-label">Dirección</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" id="dir" name="dir">
                                        </div>
                                        <label for="input-15" class="col-sm-2 col-form-label">Telefono 1</label>
                                        <div class="col-sm-4">
                                            <input type="number" min="0" class="form-control" id="tel1" name="tel1">
                                        </div>
                                        <label for="input-15" class="col-sm-2 col-form-label">Telefono 2</label>
                                        <div class="col-sm-4">
                                            <input type="number" min="0" class="form-control" id="tel2" name="tel2">
                                        </div>
                                    </div>

                                    
                                    <div class="form-footer">
                                        <button type="button" class="btn btn-danger" data-dismiss="modal"><i class="fa fa-times"></i> CANCEL</button>
                                        <button type="submit" class="btn btn-success"><i class="fa fa-check-square-o"></i> SAVE</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div><!--End Row-->



            </div>
        </div>
    </div>
</div>