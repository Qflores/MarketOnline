<%-- 
    Document   : menu
    Created on : 11-feb-2019, 14:12:45
    Author     : QfloresRA
--%>



<!-- menu lateral -->
<div  data-simplebar="" data-simplebar-auto-hide="true" id="sidebar-wrapper">			
    <div class="brand-logo">
        <a href="index.jsp">
            <img class="logo-icon" src="assets/images/farmers-market.png"  alt="Libreria Aroni">
                <h5 class="logo-text">MINIMARKET MEGAMAX</h5>
            
        </a>
    </div>

    <!-- end menu lateral -->

    <!-- start data user -->

    <div class="user-details">
        <div class="media align-items-center user-pointer collapsed" data-toggle="collapse" data-target="#user-dropdown">
            <div class="avatar">
                <img class="mr-3 side-user-img" src="assets/images/avatars/avatar-13.png" alt="user avatar">	
            </div>

            <div class="media-body">
                <h6 class="side-user-name">Quincho FLores</h6>
            </div>				
        </div>

        <div id="user-dropdown" class="collapse">
            <ul class="user-setting-menu">
                <li><a href="javaScript:void();"><i class="fal fa-user-tie"></i>Mi Perfíl</a></li>
                <li><a href="javaScript:void();"><i class="fal fa-tools"></i>Configuración</a></li>
                <li><a href="javaScript:void();"><i class="fal fa-power-off"></i>Cerrar Sesión</a></li>
            </ul>
        </div>

    </div>

    <!-- end menu user -->



    <!-- start menu navigation -->
    <ul class="sidebar-menu do-nicescrol">

        <li class="sidebar-header">Menu Príncipal</li>
        <!--Menu tablero -->
        <li id="tabledo">
            <a class="waves-effect"  href="javaScript:void();" >
                <i class="fas fa-tablet-android-alt" style="color: #0464f5;font-weight: bold;"></i>
                <span>Tablero</span>
                <i class="fa fa-angle-left pull-right"></i>
            </a>
            <ul class="sidebar-submenu" style="background: #1a237e;">
                <li>
                    <a href=""><i class="fas fa-user-chart" style="color: #80d8ff;"></i>Movimientos</a>
                </li>
                <li>
                    <a href=""><i class="far fa-clipboard-check" style="color: #40c4ff;"></i>Pedidos</a>
                </li>
                <li>
                    <a href=""><i class="fas fa-hands-helping" style="color:#00b0ff;"></i>Servicios & Soporte</a>
                </li>
                <li>
                    <a href=""><i class="far fa-shipping-timed" style="color: #0091ea;"></i>Logística</a>
                </li>

            </ul>					
        </li>	
        <!-- Menu Ventas -->
        <li>
            <a class="waves-effect"  href="javaScript:void();" >
                <!-- <i class="fas fa-shopping-cart"></i> -->
                <i class="fal fa-chart-line" style="color: #00bcd4;font-weight: bold;"></i>
                <span>Ventas</span> 
                <i class="fa fa-angle-left pull-right"></i>
            </a>

            <ul class="sidebar-submenu" style="background: #01579b;">
                <li>
                    <a href="Cventas?accion=newventa"><i class="far fa-shopping-bag" style="color: #18ffff;"></i>Realizar Venta</a>
                </li>
                <li>
                    <a href="Cventas?accion=listventa">
                        <i class="far fa-clipboard-list" style="color: #e0f7fa;"></i>Lista de Ventas
                    </a>
                </li>
                <li>
                    <a href=""> 
                        <i class="far fa-file-chart-line" style="color: #b2ebf2;"></i>Reporte Venta
                    </a>
                </li>
                <li>
                    <a href="">
                        <i class="far fa-file-chart-pie" style="color: #80deea;"></i>Reporte Venta a Crédito
                    </a>
                </li>
                <li>
                    <a href="">
                        <i class="fas fa-file-chart-pie" style="color: #4dd0e1;"></i>Informes
                    </a>
                </li>
            </ul>
        </li>
        <!-- Menu Productos -->
        <li>
            <a class="waves-effect"  href="javaScript:void();" >
                <i class="fal fa-box-full" style="color: #14b919;font-weight: bold;"></i>
                <span>Productos</span> <i class="fa fa-angle-left pull-right" ></i>
            </a>

            <ul class="sidebar-submenu" style="background: #33691e;">
                <li>
                    <a href="Cproduct?accion=insert"><i class="far fa-plus-hexagon" style="color: #64ffda;"></i>Registrar Producto</a>
                </li>
                <li>
                    <a href="Cproduct?accion=list"><i class="far fa-clipboard-list-check" style="color:#1de9b6;"></i>Lista de Productos</a>
                </li>
                <li>
                    <a href="index.jsp"><i class="far fa-file-chart-pie" style="color:#A7ffeb "></i>Reporte de Productos</a>
                </li>
            </ul>					
        </li>
        <!-- Menu Clientes -->
        <li>
            <a class="waves-effect"  href="javaScript:void();" >
                <i class="fal fa-users" style="color: #ff3b00;font-weight: bold;"></i>
                <span>Clientes</span> <i class="fa fa-angle-left pull-right"></i>
            </a>

            <ul class="sidebar-submenu" style="background: #bf360c;">
                <li>
                    <a href="Ccustomer?accion=vinsertc"> <i  class="zmdi zmdi-long-arrow-right">Registrar Cliente Nuevo</i></a>
                </li>
                <li>
                    <a href="Ccustomer?accion=viewlistc"> <i  class="zmdi zmdi-long-arrow-right">Lista de Clientes</i></a>
                </li>
                
            </ul>					
        </li>
        <!-- Menu Proveedores -->
        <li>
            <a class="waves-effect" href="javascript:void();" >
                <i class="fal fa-users" style="color: #c1b411;font-weight: bold;"></i>
                <span>Proveedor</span> <i class="fa fa-angle-left pull-right"></i>
            </a>

            <ul class="sidebar-submenu" style="background: #827717;">
                <li>
                    <a href=""> <i  class="zmdi zmdi-long-arrow-right"></i>Registrar Proveedor</a>
                </li>
                <li>
                    <a href=""> <i  class="zmdi zmdi-long-arrow-right"></i>Lista Proveedores</a>
                </li>
                
            </ul>					
        </li>
        <!-- Menu Compras -->
        <li>
            <a class="waves-effect"  href="javaScript:void();" >
                <i class="far fa-shopping-cart" style="color: #FF4081;font-weight: bold;"></i>
                <span>Compras</span> <i class="fa fa-angle-left pull-right"></i>
            </a>

            <ul class="sidebar-submenu" style="background: #F50057;">
                <li>
                    <a href=""> <i  class="zmdi zmdi-long-arrow-right"></i></a>
                </li>
                
            </ul>					
        </li>
        <!-- Menu Reportes -->
        <li>
            <a class="waves-effect"  href="javaScript:void();" >
                <i class="far fa-print-search" style="color: #D500F9;font-weight: bold;"></i>
                <span>Reportes</span> <i class="fa fa-angle-left pull-right"></i>
            </a>

            <ul class="sidebar-submenu" style="background: #4a148c;">
                <li>
                    <a href=""> <i  class="zmdi zmdi-long-arrow-right"></i></a>
                </li>
                
            </ul>					
        </li>	
        <!-- Menu Configuration systems -->
        <li>
            <a class="waves-effect"  href="javaScript:void();" >
                <i class="far fa-tools" style="color: #1De9B6; font-weight: bold;"></i>
                <span>Configuración</span> <i class="fa fa-angle-left pull-right"></i>
            </a>

            <ul class="sidebar-submenu" style="background: #006064;">
                <li>
                    <a href=""> <i  class="zmdi zmdi-long-arrow-right"></i></a>
                </li>
               
            </ul>					
        </li>
        <!-- menu hidden-->
        <li class="sidebar-header">
             Ocultar Menu
        </li>
        <li class="navbar-nav">					
            <a class="nav-link toggle-menu"  href="javaScript:void();" >		    	
                <i class="icon-menu fas fa-angle-double-left pull-right"></i>
            </a>
            <ul class="nav-item">
            </ul>				   
        </li>

        <div class="clearfix"></div>

    </ul>
    <!-- end menu navigation -->


</div>
<!--End sidebar-wrapper-->

<!-- end data user-->

<!--Start topbar header-->
<header class="topbar-nav">
    <nav class="navbar navbar-expand fixed-top">
        <ul class="navbar-nav mr-auto align-items-center">
            <li class="nav-item">
                <a class="nav-link toggle-menu" href="javascript:void();">
                    <i class="icon-menu menu-icon"></i>
                </a>
            </li>
            <li class="nav-item">
                <form class="search-bar" action="" method="POST" onsubmit="" onkeypress="return pulsar(event)">
                    <input name="buscarendba" id="buscarendba" type="text" class="form-control buscarendba" placeholder="Ingrese letra para buscar">
                    <a href="javascript:searchdata();"><i class="icon-magnifier"></i></a>
                </form>
            </li>
        </ul>

        <ul class="navbar-nav align-items-center right-nav-link">
            <li class="nav-item dropdown-lg">
                <a class="nav-link dropdown-toggle dropdown-toggle-nocaret waves-effect" data-toggle="dropdown" href="javascript:void();">
                    <i class="fal fa-envelope"></i>
                    <span class="badge badge-light badge-up">12</span>
                </a>

                <div class="dropdown-menu dropdown-menu-right">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item d-flex justify-content-between align-items-center">
                            Tienes 12 Mensajes nuevos
                            <span class="badge badge-light">12</span>
                        </li>
                        <li class="list-group-item">
                            <a href="javaScript:void();">
                                <div class="media">
                                    <div class="avatar"><img class="align-self-start mr-3" src="assets/images/avatars/avatar-5.png" alt="user avatar"></div>
                                    <div class="media-body">
                                        <h6 class="mt-0 msg-title">De: Quincho FLores Elver</h6>
                                        <p class="msg-info">Contenido del mensaje</p>
                                        <small>Hoy, 20:10 PM</small>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="list-group-item">
                            <a href="javaScript:void();">
                                <div class="media">
                                    <div class="avatar"><img class="align-self-start mr-3" src="assets/images/avatars/avatar-6.png" alt="user avatar"></div>
                                    <div class="media-body">
                                        <h6 class="mt-0 msg-title">Quincho FLores Elver</h6>
                                        <p class="msg-info">...</p>
                                        <small>Yesterday, 8:30 AM</small>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="list-group-item">
                            <a href="javaScript:void();">
                                <div class="media">
                                    <div class="avatar"><img class="align-self-start mr-3" src="assets/images/avatars/avatar-7.png" alt="user avatar"></div>
                                    <div class="media-body">
                                        <h6 class="mt-0 msg-title">Dannish Josh</h6>
                                        <p class="msg-info">Lorem ipsum dolor sit amet...</p>
                                        <small>5/11/2018, 2:50 PM</small>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="list-group-item">
                            <a href="javaScript:void();">
                                <div class="media">
                                    <div class="avatar"><img class="align-self-start mr-3" src="assets/images/avatars/avatar-8.png" alt="user avatar"></div>
                                    <div class="media-body">
                                        <h6 class="mt-0 msg-title">Katrina Mccoy</h6>
                                        <p class="msg-info">Lorem ipsum dolor sit amet.</p>
                                        <small>1/11/2018, 2:50 PM</small>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="list-group-item text-center"><a href="javaScript:void();">Ver Todo los Mensajes</a></li>
                    </ul>
                </div>
            </li>


            <li class="nav-item dropdown-lg">
                <a class="nav-link dropdown-toggle dropdown-toggle-nocaret waves-effect" data-toggle="dropdown" href="javascript:void();">
                    <i class="far fa-bells"></i>
                    <span class="badge badge-info badge-up">14</span>
                </a>
                <div class="dropdown-menu dropdown-menu-right">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item d-flex justify-content-between align-items-center">
                            You have 14 Notifications
                            <span class="badge badge-info">14</span>
                        </li>
                        <li class="list-group-item">
                            <a href="javaScript:void();">
                                <div class="media">
                                    <i class="zmdi zmdi-accounts fa-2x mr-3 text-info"></i>
                                    <div class="media-body">
                                        <h6 class="mt-0 msg-title">Registrar Nuevo usuario</h6>
                                        <p class="msg-info">Lorem ipsum dolor sit amet...</p>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="list-group-item">
                            <a href="javaScript:void();">
                                <div class="media">
                                    <i class="zmdi zmdi-coffee fa-2x mr-3 text-warning"></i>
                                    <div class="media-body">
                                        <h6 class="mt-0 msg-title">New Received Orders</h6>
                                        <p class="msg-info">Lorem ipsum dolor sit amet...</p>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="list-group-item">
                            <a href="javaScript:void();">
                                <div class="media">
                                    <i class="zmdi zmdi-notifications-active fa-2x mr-3 text-danger"></i>
                                    <div class="media-body">
                                        <h6 class="mt-0 msg-title">New Updates</h6>
                                        <p class="msg-info">Lorem ipsum dolor sit amet...</p>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="list-group-item text-center"><a href="javaScript:void();">See All Notifications</a></li>
                    </ul>
                </div>
            </li>
            <li class="nav-item language">
                <a class="nav-link dropdown-toggle dropdown-toggle-nocaret waves-effect" data-toggle="dropdown" href="javascript:void();"><i class="fa fa-flag"></i></a>
                <ul class="dropdown-menu dropdown-menu-right">
                    <li class="dropdown-item"> <i class="flag-icon flag-icon-gb mr-2"></i> English</li>
                    <li class="dropdown-item"> <i class="flag-icon flag-icon-fr mr-2"></i> French</li>
                    <li class="dropdown-item"> <i class="flag-icon flag-icon-cn mr-2"></i> Chinese</li>
                    <li class="dropdown-item"> <i class="flag-icon flag-icon-de mr-2"></i> German</li>
                </ul>
            </li>
            <li class="nav-item">
                <a class="nav-link dropdown-toggle dropdown-toggle-nocaret" data-toggle="dropdown" href="#">
                    <span class="user-profile"><img src="assets/images/avatars/avatar-13.png" class="img-circle" alt="user avatar"></span>
                </a>
                <ul class="dropdown-menu dropdown-menu-right">
                    <li class="dropdown-item user-details">
                        <a href="javaScript:void();">
                            <div class="media">
                                <div class="avatar"><img class="align-self-start mr-3" src="assets/images/avatars/avatar-13.png" alt="user avatar"></div>
                                <div class="media-body">
                                    <h6 class="mt-2 user-title">Quincho, Elver</h6>
                                    <p class="user-subtitle">thonny776@example.com</p>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li class="dropdown-divider"></li>
                    <li class="dropdown-item"><i class="icon-envelope mr-2"></i>Bandeja de Entrada</li>
                    <li class="dropdown-divider"></li>
                    <li class="dropdown-item"><i class="icon-wallet mr-2"></i>Ver Cuenta</li>
                    <li class="dropdown-divider"></li>
                    <li class="dropdown-item"><i class="fal fa-tools mr-2"></i>Configuración</li>
                    <li class="dropdown-divider"></li>
                    <li class="dropdown-item"><i class="fal fa-power-off mr-2"></i>Cerrar Sesión</li>
                </ul>
            </li>
        </ul>
    </nav>
</header>
<!--End topbar header-->		


<div class="clearfix"></div>

<div class="content-wrapper">

    <div class="container-fluid">