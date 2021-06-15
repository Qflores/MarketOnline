

<h1>Bienvenido, Minimarket Mary Luz</h1>

<div class="card mt-3">
    <div class="card-content">
        <div class="row row-group m-0">
            <div class="col-12 col-lg-6 col-xl-3 border-light bg-success">
                <div class="card-body ">
                    <h5 class="text-white mb-0" id="totalventas"><span class="float-right"><i class="fa fa-shopping-cart"></i></span></h5>
                    <div class="progress my-3" style="height:3px;">
                        <div class="progress-bar" style="width:55%"></div>
                    </div>
                    <p class="mb-0 text-white small-font">TOTAL DE VENTAS DEL DIA<span class="float-right">+4.2% <i class="zmdi zmdi-long-arrow-up"></i></span></p>
                </div>
            </div>
            <div class="col-12 col-lg-6 col-xl-3 border-light bg-facebook">
                <div class="card-body ">
                    <h5 class="text-white mb-0" id="cantiprods">  <span class="float-right">(&#8721;)</span></h5>
                    <div class="progress my-3" style="height:3px;">
                        <div class="progress-bar" style="width:55%"></div>
                    </div>
                    <p class="mb-0 text-white small-font">TOTAL DE PRODUCTOS VENDIDOS DEL DIA <span class="float-right">+1.2% <i class="zmdi zmdi-long-arrow-up"></i></span></p>
                </div>
            </div>
            <div class="col-12 col-lg-6 col-xl-3 border-light bg-secondary">
                <div class="card-body ">
                    <h5 class="text-white mb-0" id="vfiltro">$ 0.00 <span class="float-right">(&#8721;)</span></h5>
                    <div class="progress my-3" style="height:3px;">
                        <div class="progress-bar" style="width:55%"></div>
                    </div>
                    <p class="mb-0 text-white small-font">VENTA POR RANGO DE FECHA<span class="float-right">+5.2% <i class="zmdi zmdi-long-arrow-up"></i></span></p>
                    <div class="inline-block d-inline"><input  type="date" id="finicio" name="finicio" class="form-control d-inline"> <input  type="date" id="ffin" name="ffin" class="form-control d-inline"></div>
                </div>
            </div>
            <div class="col-12 col-lg-6 col-xl-3 border-light bg-primary">
                <div class="card-body ">
                    <h5 class="text-white mb-0" id="ventames"> <span class="float-right"><i class="fas fa-cash-register"></i></span></h5>
                    <div class="progress my-3" style="height:3px;">
                        <div class="progress-bar" style="width:55%"></div>
                    </div>
                    <p class="mb-0 text-white small-font">VENTA TOTAL DEL MES ACTUAL <span class="float-right">+2.2% <i class="zmdi zmdi-long-arrow-up"></i></span></p>
                </div>
            </div>
        </div>
    </div>
</div>
<!--end report sales-pay--->



<!--start list product-->
<div class="row">
    <div class="col-12 col-lg-12">
        <div class="card">
            <div class="card-header text-center bg-linkedin">LISTA DE PRODUCTOS MAS VENDIDOS CON MONTOS MAYORES</div>
            <div class="table-responsive">
                <table class="table align-items-center table-flush table-borderless" id="listprodventas">
                    <thead class="bg-primary">
                        <tr>
                            <th >Items</th>
                            <th>Productos</th>
                            <th>Medida</th>
                            <th>Cantidad vendidas</th>
                            <th> Total por Producto  <b class="text-uppercase">(&#8721; $)</b> </th>
                        </tr>
                    </thead>
                    
                    <tbody>                  
                    </tbody>
                    
                    <tfoot class="bg-primary" align="left" style="color: #fff; font-size: 20px" >
                        <tr><th></th><th></th><th></th><th></th><th></th></tr>
                    </tfoot>

                </table>
            </div>
        </div>
    </div>
</div>
<!--end List product-->


<!-- grafica dinamica de las ventas-->
<div class="card">
    <div class="card-header">Venta Histórico del año
        <div class="btn-group group-round btn-group-sm float-right">
            <button type="button" class="btn btn-white waves-effect waves-light">Mensual</button>            
            <button type="button" class="btn btn-light waves-effect waves-light">Diaria</button>
        </div>
    </div>
    <div class="card-body">
        <div class="row">
            <div class="col-12 col-lg-2 text-center">
                <p class="mt-4" id="anioactual">Total de Ventas año </p>
                <h4 class="mb-0" id="ventaanual">$ 0.00</h4>
                <hr>
                <p class="mt-4" id="panioactual">Total de Productos vendidos año </p>
                <h4 class="mb-0" id="totalprod">(&#8721;) 0</h4>
            </div>
            <div class="col-12 col-lg-10">
                <canvas id="dash2-chart1" height="130"></canvas>
            </div>
        </div><!--End Row-->
    </div>
</div><!--End Card-->

<div class="row">
    <div class="col-lg-6">
        <div class="card">
            <div class="card-header">Productos mas Vendidos
                <div class="card-action">
                    <div class="dropdown">
                        <a href="javascript:void();" class="dropdown-toggle dropdown-toggle-nocaret" data-toggle="dropdown">
                            <i class="icon-options"></i>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right">
                            <a class="dropdown-item" href="javascript:void();">Action</a>
                            <a class="dropdown-item" href="javascript:void();">Another action</a>
                            <a class="dropdown-item" href="javascript:void();">Something else here</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="javascript:void();">Separated link</a>
                        </div>
                    </div>
                </div>
            </div>

            
            <div class="card-footer text-center bg-transparent border-0">
                <a href="javascript:void();">View all listings</a>
            </div>

        </div>
    </div>

    <div class="col-lg-6">
        <div class="card">
            <div class="card-header">Cantidad de Productos Vendidos
                <div class="card-action">
                    <div class="dropdown">
                        <a href="javascript:void();" class="dropdown-toggle dropdown-toggle-nocaret" data-toggle="dropdown">
                            <i class="icon-options"></i>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right">
                            <a class="dropdown-item" href="javascript:void();">Action</a>
                            <a class="dropdown-item" href="javascript:void();">Another action</a>
                            <a class="dropdown-item" href="javascript:void();">Something else here</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="javascript:void();">Separated link</a>
                        </div>
                    </div>
                </div>
            </div>

            

            <div class="card-footer text-center border-0">
                <a href="javascript:void();">View all Categories</a>
            </div>

        </div>
    </div>
</div><!--End Row-->





