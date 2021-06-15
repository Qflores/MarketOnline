
<h1><%=(request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : "")%></h1>


<!-- INFORMACION CON DATATABLE --->
<div class="panel-body table-responsive">

    <table id="comprobante_data" class="table table-bordered table-striped">

        <thead class="thead-dark">
            <tr>
                <th scope="col" width="20%">N°Comprobante</th>
                <th scope="col" width="25%">F. Emision</th>
                <th scope="col" width="15%">Estado</th>
                <th scope="col" width="10%">Inpuesto</th>
                <th scope="col" width="15%">Monto Total</th>
                <th scope="col" width="15%">Acción</th>
            </tr>
        </thead>

        <tbody>


        </tbody>


    </table>

</div>

<div class="clearfix"> </div>

<script type="text/javascript">
    var numfact = "";
    function PrintDoc(id) {
        numfact = id;
        $("#printreporte").modal("show");
    }

</script>

<!-- modal para ver detalle de pagos --->

<div class="modal fade" id="regpagos" tabindex="-1" role="dialog" aria-labelledby="" aria-hidden="true">
    <div class="modal-dialog" style="max-width: 90% !important;" >
        <div class="modal-content text-dark" style="background-color: #1e4638fa">
            <div class="modal-header color-tabs bg-primary">
                <h4 class="modal-title font-weight-bold">Numero de Factura : <span id="nmfact"></span></h4>

                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>

            </div>            

            <div class="modal-body"> 
                <div class="secction" id="secctionpagos">
                    <div class="row">
                        <div class="rows col-lg-6 col-md-6 col-sm-6">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <label class="form-control badge-info">Monto Total </label>
                                </div>
                                <span class="badge badge-info" style="font-size: 22px" id="montototal"></span>
                            </div>                        
                        </div> 
                        <div class="rows col-lg-6 col-md-6 col-sm-6">
                            <div class="input-group">
                                <div class="input-group-prepend ">
                                    <label class="form-control badge-warning">Monto Por pagar </label>
                                </div>
                                <span class="badge badge-warning" style="font-size: 22px" id="montopagar"></span>
                            </div>
                        </div>
                    </div>

                    <div class="clearfix"> </div>

                    <form role="form" method="POST" action="Cventas?accion=regpago">

                        <div class="form-row">
                            <div class="rows col-lg-6 col-md-6 col-sm-6">
                                <input type="hidden" name="idcredit" id="idcredit" >
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text" id="inputGroupPrepend3">Ingrese Monto a pagar</span>
                                    </div>
                                    <input type="number" name="monto" id="mpagar"  step="0.01" min="0.00" class="form-control is-invalid" placeholder="Ingrese Monto">
                                    <div class="invalid-feedback"></div>
                                </div>
                                
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text" id="inputGroupPrepend3">Nombre Cliente</span>
                                    </div>
                                    <input type="text" name="namec" id="namec"  class="form-control is-invalid" aria-describedby="inputGroupPrepend3" placeholder="opcional">
                                    <div class="invalid-feedback"></div>
                                </div>
                            </div>
                        </div> 
                        <div class="form-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal"> <i class="fa fa-times"></i> CANCELAR</button>
                            <button type="submit" class="btn btn-success"><i class="fa fa-check-square-o"></i> PAGAR</button>
                        </div>

                    </form>
                </div>                

                <div class="clearfix"> </div>

                <div class="table-responsive">
                    <table id="listpagos" class="table table-bordered table-striped" style="width: 100%; border-collapse: collapse !important;">
                        <thead class="listpagos thead-primary" >
                            <tr>                                
                                <th class="">Items</th>
                                <th class="">Monto Abonado</th>
                                <th class="">Fecha de Pago</th>  
                                <th class="">Responsable</th> 
                            </tr>
                        </thead>

                        <tbody class="" style="color: #fff; font-weight: bold ">                            
                        </tbody>
                        <tfoot align="left" style="background-color: #3f87a6; color: #fff; font-size: 20px" >
                            <tr><th></th><th></th><th></th><th></th></tr>
                        </tfoot>

                    </table>
                </div>

            </div>
            <div class="modal-footer bg-primary">
                <button type="button" class="btn btn-warning pull-right" data-dismiss="modal">
                    <i class="fa fa-times" aria-hidden="true"></i> Cerrar</button>
            </div>
        </div>
    </div>
</div>
