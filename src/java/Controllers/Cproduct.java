package Controllers;

import Dao.ColorDao;
import Dao.ProductDao;
import Dao.ProductPriceDao;
import Dao.SizeDao;
import Dao.TypeProductDao;
import Entity.Color;
import Entity.Fecha;
import Entity.Product;
import Entity.ProductPrice;
import Entity.Size;
import Entity.TypeProduct;
import Entity.ValidarD;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet(name = "Cproduct", urlPatterns = {"/Cproduct"})
public class Cproduct extends HttpServlet {

    String ruta = "product/";
    String acceso = "";
    String msg = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String pagina = request.getParameter("accion");

        if (pagina.equals("list")) {
            this.ViewsList(request, response);
        } else if (pagina.equals("insert")) {
            this.ViewInser(request, response);
        } else if (pagina.equals("update")) {
            this.UpdateP(request, response);
        } else if (pagina.equals("delete")) {
            this.DeleteP(request, response);
        } else if (pagina.equals("detallep")) {
            this.viewDetails(request, response);
        } else if (pagina.equals("listproduct")) {
            this.ListProductJson(request, response);
        } else if (pagina.equals("insertp")) {
            this.InsertP(request, response);
        } else if (pagina.equals("savepriceprod")) {
            this.updatePriceProd(request, response);
        } else if (pagina.equals("shearprod")) {
            this.searchProdBysku(request, response);
        } else if (pagina.equals("uprodselect")) {
            this.UpdateSelectProd(request, response);
        } else if (pagina.equals("spa")) {
            this.searchProd(request, response);
        } else {
            this.ViewHome(request, response);
        }

    }

    private void ViewsList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        msg = "Lista de productos";
        //String pagina = request.getParameter("accion");

        acceso = "listar";
        //ruta = "product/";

        request.setAttribute("page", ruta + acceso);
        request.setAttribute("mensaje", msg);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    private void ViewInser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        msg = "Registro de Producto Nuevo.";
        acceso = "insert";
        //String ruta = "product/";

        request.setAttribute("page", ruta + acceso);
        request.setAttribute("mensaje", msg);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    private void ViewHome(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        acceso = "error";
        msg = "la pagina no se encontró";
        ruta = "views/";

        request.setAttribute("page", ruta + acceso);
        request.setAttribute("mensaje", msg);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    private void DeleteP(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        acceso = "";
        //String ruta = "product/";
        msg = "";

        String skuproductprice = request.getParameter("id");

        ProductPriceDao delepp = new ProductPriceDao();

        ProductDao deletepro = new ProductDao();

        String prodelete = "";
        String prodprecio = "";

        if (delepp.ListByAtrib(skuproductprice) != null) {//consulto si existe el producto para eliminar//siexiste, se procedea a eliminar
            if (delepp.DeleteByKey(skuproductprice)) {//eliminamos el precio del producto

                if (deletepro.DeleteByKey(skuproductprice)) {//eliminamos el producto

                    prodelete = "Exito. producto Eliminado";
                } else {
                    prodelete = "Error. producto No eliminado";
                }

                prodprecio = "Exito. Precio Eliminado";

                msg = "<div class='alert alert-success' role='alert'>" + prodelete + " <br>" + prodprecio + "</div>";

            } else {
                msg = "<div class='alert alert-warning' role='alert'>Producto: " + skuproductprice + " No se  eliminó.</div>";
            }
        } else {
            if (deletepro.DeleteByKey(skuproductprice)) {

                msg = "<div class='alert alert-success' role='alert'>Exito. producto Eliminado</div>";
            } else {
                msg = "<div class='alert alert-warning' role='alert'>Error. producto No eliminado</div>";
            }

        }

        acceso = "listar";
        request.setAttribute("page", ruta + acceso);
        request.setAttribute("mensaje", msg);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    private void UpdateSelectProd(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();

        response.setContentType("text/html;charset=UTF-8");

        String skup = request.getParameter("skup").trim();

        ProductDao pDao = new ProductDao();
        Product prod = pDao.ViewProdUpdate(skup); //new Product();

        JSONObject objp = new JSONObject();

        if (prod != null) {

            ColorDao cdao = new ColorDao();
            List<Color> cl = cdao.ListColor();
            Iterator<Color> icl = cl.iterator();
            Color c = null;

            String listcolor = "";
            //retorn toda la lista de colores
            if (cl != null) {
                while (icl.hasNext()) {
                    c = icl.next();

                    if (prod.getColor_id() == c.getId()) {
                        listcolor += "<option value='" + c.getId() + "' selected>" + c.getName() + "</option>";
                    } else {
                        listcolor += "<option value='" + c.getId() + "'>" + c.getName() + "</option>";
                    }
                }
            } else {
                listcolor = "<option value='' selected>No hay lista Colores</option>";;
            }

            // retorna lita de tamaños 
            SizeDao zdao = new SizeDao();
            List<Size> zl = zdao.ListSize();
            Iterator<Size> izl = zl.iterator();
            Size z = null;

            String ListSize = "";

            if (zl != null) {
                while (izl.hasNext()) {
                    z = izl.next();

                    if (prod.getSize_id() == z.getId()) {

                        ListSize += "<option value='" + z.getId() + "' selected>" + z.getSimbolo() + "</option>";
                    } else {
                        ListSize += "<option value='" + z.getId() + "' >" + z.getSimbolo() + "</option>";
                    }
                }
            } else {

                ListSize = "<option value='' selected>No hay lista de Signo de Tamaño</option>";
            }

            //cargando lista de categorias
            TypeProductDao tydao = new TypeProductDao();
            List<TypeProduct> lt = tydao.ListCategoria();
            Iterator<TypeProduct> it = lt.iterator();
            TypeProduct t = null;

            String listCat = "";
            if (lt != null) {

                while (it.hasNext()) {
                    t = it.next();

                    if (prod.getTypeproduct_id() == t.getId()) {
                        listCat += "<option value='" + t.getId() + "' selected>" + t.getName() + "</option>";
                    } else {
                        listCat += "<option value='" + t.getId() + "'>" + t.getName() + "</option>";
                    }
                }

            } else {
                listCat = "<option value='' selected>No hay lista de Categorías</option>";
            }

            // stados
            String stprod = "";
            if (prod.getState().equals("a")) {
                stprod = "<option value='a' selected>Activo</option> <option value='i'>Inactivo</option>";
            } else {
                stprod = "<option value='a'>Activo</option> <option value='i' selected>Inactivo</option>";
            }

            // seprando la fecha  hora
            String fechapromo = prod.getPrice().getFexpiration();
            String fechex;
            String horaex;

            if (fechapromo != null || fechapromo != "") {
                String[] parts = fechapromo.split(" ");
                fechex = parts[0];
                horaex = parts[1];
            } else {
                String[] parts = Fecha.getFecha().split(" ");
                fechex = parts[0];
                horaex = parts[1];
            }

            objp.put("skup", prod.getSku());
            objp.put("namep", prod.getName());
            objp.put("descp", prod.getDescription());
            objp.put("obsp", prod.getObservation());
            objp.put("qxp", prod.getQuantityperpackage());
            objp.put("stmin", prod.getStockmin());
            objp.put("stmax", prod.getStockmax());
            objp.put("statep", stprod);
            objp.put("pesop", prod.getPeso());
            objp.put("colors", listcolor); //prod.getColor_id()
            objp.put("sizes", ListSize); //prod.getSize_id()
            objp.put("categories", listCat);//prod.getTypeproduct_id()
            objp.put("pricep", prod.getPrice().getPrice());
            objp.put("priceprom", prod.getPrice().getPricepromo());
            objp.put("cantprom", prod.getPrice().getCantidadpromo());
            objp.put("fexpromo", fechex);
            objp.put("hexpromo", horaex);

        }

        out.print(objp);
    }

    private void UpdateP(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        String skup = request.getParameter("mskup").trim();
        String namep = request.getParameter("mprodname").trim();
        String detailp = request.getParameter("mproddetail").trim();
        String obsp = request.getParameter("mprodobserve").trim();
        double cxp = Double.parseDouble(request.getParameter("mprodxpack").trim());
        double pricep = Double.parseDouble(request.getParameter("prodprice").trim());
        double pricepromo = Double.parseDouble(request.getParameter("pricepromo").trim());
        double cantpromo = Double.parseDouble(request.getParameter("cantypromo").trim());
        String fexpro = request.getParameter("fpfin").trim();
        String hexpro = request.getParameter("hpfin").trim();
        String statep = request.getParameter("prodstate").trim();
        double sizep = Double.parseDouble(request.getParameter("prodsize").trim());
        double stmin = Double.parseDouble(request.getParameter("stockmin").trim());
        double stmax = Double.parseDouble(request.getParameter("stockmax").trim());
        int categoryid = Integer.parseInt(request.getParameter("prodcat").trim());
        int colorid = Integer.parseInt(request.getParameter("prodcolor").trim());
        int simbolid = Integer.parseInt(request.getParameter("sizesimbol").trim());

        // si el producto viene de la página insertar, capturamos este campo;
        String fromInsert = (request.getParameter("uprodexist") != null ? request.getParameter("uprodexist") : "");

        ProductDao pDao = new ProductDao();

        Product prod = new Product(skup, namep, detailp, cxp, 0, obsp, statep, stmin, stmax, sizep, colorid, simbolid, categoryid);

        if (pDao.Update(prod)) {

            
            msg = "Producto ";
            ProductPriceDao pricDao = new ProductPriceDao();
            ProductPrice pPrice = new ProductPrice(pricep, pricepromo, cantpromo, fexpro + ' ' + hexpro, skup);
            if (pricDao.Update(pPrice)) {
                
                msg += " y precio actualizado";
            } else {
                msg += " actualizado y precio no se actualizo";
            }
        } else {
            msg = "Producto no actualizado";
        }

        if (fromInsert != "") {
            request.setAttribute("page", "product/insert");
            request.setAttribute("mensaje", "<div class='alert alert-success'>" + msg + "</div>");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {

            request.setAttribute("page", "product/listar");
            request.setAttribute("mensaje", "<div class='alert alert-success'>" + msg + "</div>");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    private void InsertP(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        acceso = "";
        //ruta = "product/";
        msg = "";

        String skup = request.getParameter("prodsku").trim();

        if (skup.isEmpty()) {
            request.setAttribute("skup", "Campo código vacio");
            request.setAttribute("mensaje", "El campo Código es Obligatorio ");
            request.setAttribute("page", ruta + "insert");
            RequestDispatcher vista = request.getRequestDispatcher("index.jsp");
            vista.forward(request, response);

        }

        String name = request.getParameter("namep").trim();
        if (name.isEmpty()) {
            request.setAttribute("namep", "Campo Nombre producto vacio");
            request.setAttribute("mensaje", "El campo Nombre es Obligatorio ");
            request.setAttribute("page", ruta + "insert");
            RequestDispatcher vista = request.getRequestDispatcher("index.jsp");
            vista.forward(request, response);
        }

        String desc = request.getParameter("descripcionp").trim();

        String cantpack = request.getParameter("cantpack").trim();
        double cantp = 0;
        if (!cantpack.isEmpty()) {
            if (ValidarD.getValidar(cantpack)) {
                cantp = Double.parseDouble(cantpack);
            } else {
                request.setAttribute("cantpack", "Ingrese un número ###.##");
            }
        }

        String obsp = request.getParameter("observacionp").trim();

        String statep = request.getParameter("estadop");

        String stockm = request.getParameter("stockmin").trim();
        double stockmin = 0.0;
        if (!stockm.isEmpty()) {
            if (ValidarD.getValidar(stockm)) {
                stockmin = Double.parseDouble(stockm);
            } else {
                request.setAttribute("stockmin", "Ingrese un numero");
            }
        }
        //
        String stockmx = request.getParameter("stockmax").trim();
        double stockmax = 0.0;
        if (!stockmx.isEmpty()) {
            if (ValidarD.getValidar(stockmx)) {
                stockmax = Double.parseDouble(stockmx);
            } else {
                request.setAttribute("stockmax", "Ingrese un numero");
            }
        }

        String tamano = request.getParameter("tamanio").trim();
        double tamanio = 0.0;
        if (!tamano.isEmpty()) {
            if (ValidarD.getValidar(tamano)) {
                tamanio = Double.parseDouble(tamano);
            } else {
                request.setAttribute("sizep", "Ingrese un número");
            }
        }

        String simbol = request.getParameter("simbolo");
        int simbolo = 0;
        if (!simbol.isEmpty()) {
            if (ValidarD.getValidar(simbol)) {
                simbolo = Integer.parseInt(simbol);
            } else {
                request.setAttribute("simbol", "Seleccione un tipo de tamaño");
            }
        }

        String categoria = request.getParameter("categoria");
        int catp = 0;
        if (!categoria.isEmpty()) {
            if (ValidarD.getValidar(categoria)) {
                catp = Integer.parseInt(categoria);
            } else {
                request.setAttribute("category", "Seleccione una categoría");
            }

        }

        int color = Integer.parseInt(request.getParameter("colorp"));

        String price = request.getParameter("pricep").trim();
        double pricep = 0.0;

        if (!price.isEmpty()) {
            if (ValidarD.getValidar(price)) {
                pricep = Double.parseDouble(price);
            } else {
                request.setAttribute("pricep", "Ingrese un número");
            }
        } else {
            request.setAttribute("mensaje", "El campo Precio es Obligatorio ");
            request.setAttribute("page", ruta + "insert");
            RequestDispatcher vista = request.getRequestDispatcher("index.jsp");
            vista.forward(request, response);
        }

        //-------------cantidad promocion.-------
        String quantitypromo = request.getParameter("cantpromo").trim();
        double cantpromo = 0.0;

        if (!quantitypromo.isEmpty()) {
            if (ValidarD.getValidar(quantitypromo)) {
                cantpromo = Double.parseDouble(quantitypromo);
            } else {
                request.setAttribute("cantpromo", "Ingrese un número");
            }
        }

        //---------------precio---promocion---------------
        String pricepromo = request.getParameter("pricepromo").trim();
        double pricepro = 0.0;

        if (!pricepromo.isEmpty()) {
            if (ValidarD.getValidar(pricepromo)) {
                pricepro = Double.parseDouble(pricepromo);
            } else {
                request.setAttribute("promo", "Ingrese un número");
            }
        }

        String fechad = request.getParameter("fechaex");
        String fechah = request.getParameter("horaex");

        String fechan = "";

        if (!fechad.isEmpty() && !fechah.isEmpty()) {

            fechan = fechad + " " + fechah + ":00";

        } else if (!fechad.isEmpty() || !fechah.isEmpty()) {
            request.setAttribute("fecha", "Complete la fecha");
        } else {

            fechan = Fecha.getFecha();
        }

        Product product = new Product();
        ProductDao productDao = new ProductDao();

        product.setSku(skup);
        product.setName(name);
        product.setDescription(desc);
        product.setQuantityperpackage(cantp);
        product.setRanking(0);
        product.setObservation(obsp);
        product.setState(statep);
        product.setStockmin(stockmin);
        product.setStockmax(stockmax);
        product.setPeso(tamanio);
        product.setColor_id(color);
        product.setSize_id(simbolo);
        product.setTypeproduct_id(catp);

        ProductPrice ProductPrice = new ProductPrice();
        ProductPrice.setId(0);
        ProductPrice.setPrice(pricep);
        ProductPrice.setState(statep);
        ProductPrice.setPricepromo(pricepro);
        ProductPrice.setCantidadpromo(cantpromo);
        ProductPrice.setFexpiration(fechan);
        ProductPrice.setProducts_sku(skup);

        ProductPriceDao pricedao = new ProductPriceDao();

        if (productDao.Insert(product)) {

            if (pricedao.Insert(ProductPrice)) {

                request.setAttribute("newprice", "<div class=\"alert alert-success\" role=\"alert\">Éxito. '" + ProductPrice.getProducts_sku() + "' '" + ProductPrice.getPrice() + "' El precio se registró.</div>");
            } else {
                request.setAttribute("newprice", "<div class=\"alert alert-warning\" role=\"alert\">Error. El precio del producto: " + ProductPrice.getProducts_sku() + "' '" + ProductPrice.getPrice() + "' no se registró.</div>");
            }

            request.setAttribute("newproduct", "<div class=\"alert alert-success\" role=\"alert\"> Éxito. El producto: '" + skup + "' '" + fechan + "' Se registó con éxito </div>");

        } else {

            request.setAttribute("newproduct", "<div class=\"alert alert-warning\" role=\"alert\">Error. El producto: (" + skup + " " + name + ") no se Registró</div>");
        }
        acceso = "insert";

        request.setAttribute("page", ruta + acceso);
        request.setAttribute("mensaje", msg);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    //return one object on JSON
    private void viewDetails(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;

        out = response.getWriter();

        ProductDao modelProduct = new ProductDao();
        String codigo = "";
        codigo = request.getParameter("skup").trim();

        JSONObject json = new JSONObject();
        Product listPro = modelProduct.ListByAtrib(codigo);

        if (listPro != null) {

            String descrp = listPro.getDescription();

            if (descrp.equalsIgnoreCase("null")) {
                descrp = "Sin descripción";
            }

            json.put("skup", listPro.getSku());
            json.put("namep", listPro.getName());
            json.put("descp", descrp);
            json.put("state", listPro.getState());
            json.put("peso", listPro.getPeso());
            json.put("stock", listPro.getStock().getQuantity());
            json.put("color", listPro.getColor().getName());
            json.put("simbolo", listPro.getSize().getSimbolo());
            json.put("category", listPro.getCategory().getName());
            json.put("price", listPro.getPrice().getPrice());
            json.put("Ruta Imagen:", listPro.getPicture().getPath());
            json.put("Nombre Imagen:", listPro.getPicture().getAlt());
            json.put("pricepromo", listPro.getPrice().getPricepromo());
            json.put("cantpromo", listPro.getPrice().getCantidadpromo());
            json.put("fexpiration", listPro.getPrice().getFexpiration());
        } else {
            json.put("emty", "null");
        }
        out.print(json);
    }

    //return---one list of product---on JSON ArrayList
    private void ListProductJson(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = null;
        out = response.getWriter();

        ProductDao modelProduct = new ProductDao();

        String codigo = request.getParameter("skup");
        int rows = Integer.parseInt(request.getParameter("rows"));
        // get a lista of products that match the result//3 params

        List<Product> listProduct = modelProduct.listAll(codigo, 0, rows);

        
        Iterator<Product> iterpro = listProduct.iterator();
        Product listprod = null;

        JSONArray array = new JSONArray();

        int i = 1;

        if (listProduct.size() > 0) {

            while (iterpro.hasNext()) {
                listprod = iterpro.next();

                // create a JSON object for each product. The Product will have the same , but different values.
                //JsonObjectBuilder productBuilder = Json.createObjectBuilder();
                //personalizando cantidadStock
                String cantidadStock = "";
                if (String.valueOf(listprod.getStock().getQuantity()).equals("0.0")) {
                    cantidadStock = "<span class='bg-danger text-white text-center rounded'>" + listprod.getStock().getQuantity().toString() + "</span>";
                } else {//si no hay stock, ponemos mostramos 0.00
                    cantidadStock = "<span class='bg-primary text-white text-center rounded'>" + listprod.getStock().getQuantity().toString() + "</span>";
                }

                //personalizamos estado producto
                //personalizando estado de los productos
                String estadopro = "";
                if (listprod.getState().equals("a")) {
                    estadopro = "<p class='bg-primary text-white text-center rounded'>Activo</p>";
                } else if (listprod.getState().equals("i")) {
                    estadopro = "<p class='bg-danger text-white text-center rounded'>Inactivo</p>";
                }
                //personalizamos Peso/Tamaño
                String pesoproduct = "";

                if (listprod.getPeso() == 0.0) {

                    pesoproduct = listprod.getSize().getSimbolo();
                } else {
                    pesoproduct = String.valueOf(listprod.getPeso()) + " " + listprod.getSize().getSimbolo();
                }

                //personalizamos el precio
                String precioaplicado = "";
                String precioProd = "";
                //  capruramos la cantidad de promocion para comparar
                Double cantipro = listprod.getPrice().getCantidadpromo();

                //  validamos si la fecha de promocion no se a vencido
                String fechaacctual = Fecha.getFecha();
                boolean fechapromo = Fecha.compareFecha(fechaacctual, listprod.getPrice().getFexpiration());

                //capturamos el precioPromocion
                Double preciodepromocion = listprod.getPrice().getPricepromo();

                //si el precio promocion es null o 0.0= establecer 0.0 al precio prmocion
                //si cant en promocion es 0, si la fecha es menor, y el precio es mayor que precio promocion se aplica precio promocion
                if (cantipro > 0.0 && fechapromo == true && listprod.getPrice().getPrice() > preciodepromocion) {
                    precioProd = "" + preciodepromocion;
                    precioaplicado = "<s>$ " + listprod.getPrice().getPrice().toString() + "</s><br><span class='priceproduct text-white'>$ " + preciodepromocion + "</span>";
                } else {
                    precioaplicado = "$ <span id='" + listprod.getSku() + "' class=\"priceproduct text-white\">" + listprod.getPrice().getPrice().toString() + "</span>";
                    precioProd = listprod.getPrice().getPrice().toString();
                }

                String ver = "<a href=\"" + listprod.getSku() + "\" ></a>";

                String botonver = "<a title=\"Ver Detalle\" class=\"btn btn-success btn-sm\" id=\"" + listprod.getSku() + "\"  href=\"javascript:detalleP('" + listprod.getSku() + "')\"><i class=\"far fa-search fa-2x\"></i></a>";
                //String d2_ddddddd = "<a title='Editar Producto' class='btn btn-warning btn-sm'  id='"+listprod.getSku()+"'  href='javascript:editP("+listprod.getSku()+")'><i class='far fa-edit fa-2x'></i></a>";
                String botonEdit = "<a title=\"Editar Producto\" class=\"btn btn-warning btn-sm\" id=\"" + listprod.getSku() + "\"  href=\"javascript:editP('" + listprod.getSku() + "')\"><i class=\"far fa-edit fa-2x\"></i></a>";
                //String botonDelete = "<a title='Eliminar Producto' class='btn btn-danger btn-sm'  id='"+listprod.getSku()+"'  href='Cproduct?accion=delete&id="+listprod.getSku()+"><i class='fal fa-trash-alt fa-2x'></i></a>";

                String botonesaccion = botonver + botonEdit;//+botonDelete;

                JSONObject art = new JSONObject();

                art.put("items", i);
                art.put("namep", "<span class='nameproduct'>" + listprod.getName() + "</span>");
                art.put("stado", estadopro);
                art.put("stock", cantidadStock);
                art.put("stoc", listprod.getStock().getQuantity());
                art.put("color", "<span calss='stateproduct'>" + listprod.getColor().getName() + "</span>");
                art.put("peso", "<span class='pesoproduct'>" + pesoproduct + "</span>");
                art.put("precio", precioaplicado);
                art.put("price", precioProd);
                art.put("botonacion", botonesaccion);
                // add the plan to our array of plants //add(art);
                array.add(art);
                i++;
                //arrayBuilder.add(productJson);
            }
        }
        // add the array of products to a root JSON object.
        //JsonObject root = rootBuilder.add("datos", arrayBuilder).build();       
        JSONObject root = new JSONObject();
        root.put("datos", array);

        out.print(root);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void updatePriceProd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        // update product new price ajax
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        String msg = "";
        out = response.getWriter();
        String ppdsku = request.getParameter("skup").trim();
        String newprice = request.getParameter("pricep");

        double priceprod = 0;

        if (!newprice.isEmpty()) {
            if (ValidarD.getValidar(newprice)) {
                priceprod = Double.parseDouble(newprice);
            } else {

                msg = "No es posible actualizar. Verifique los datos!";
            }
        }

        if (priceprod >= 0.1) {

            ProductDao prodDao = new ProductDao();
            Product prod = new Product(new ProductPrice(priceprod, ppdsku));
            boolean result = prodDao.UpdateProductPrice(prod);

            if (result) {
                msg = "Exito. Precio Actualizado de :" + ppdsku + " price: " + priceprod;
            } else {
                msg = "Error. No Se actualizo Los datos! cod:" + ppdsku + " price: " + priceprod;
            }
        }

        JSONObject json = new JSONObject();
        json.put("skup", msg);

        out.print(json);

    }

    private void searchProdBysku(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String skup = request.getParameter("sku").trim();
        JSONObject pobj = new JSONObject();
        if (!skup.isEmpty()) {
            ProductDao prodDao = new ProductDao();
            Product prod = prodDao.SearchBySku(skup);
            if (prod != null) {
                pobj.put("sms", "2");

                pobj.put("nombres", prod.getName());
                pobj.put("desc", prod.getDescription());

            } else {
                pobj.put("sms", "1");
            }

        } else {
            pobj.put("sms", "0");
        }
        out.print(pobj);

    }

    private void searchProd(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        ProductDao productDao = new ProductDao();
        String codigo = (String) (request.getParameter("codigop") != null ? request.getParameter("codigop").trim() : "");

        int limite = 30;
        JSONArray array = new JSONArray();
        try {
                    
        if (codigo != null) {
            List<Product> listProduct = productDao.listAll(codigo, 0, limite);            
            if (listProduct != null) {
                Iterator<Product> iterpro = listProduct.iterator();
                Product listprod = null;

                if (listProduct.size() > 0) {
                    
                    while (iterpro.hasNext()) {
                        listprod = iterpro.next();
                        //personalizamos Peso/Tamaño
                        String pesoproduct = "";
                        
                        if (listprod.getPeso() == 0.0) {
                            pesoproduct = listprod.getSize().getSimbolo();
                        } else {
                            pesoproduct = String.valueOf(listprod.getPeso()) + " " + listprod.getSize().getSimbolo();
                        }

                        String precioProd = "";
                        //  capruramos la cantidad de promocion para comparar
                        Double cantipro = listprod.getPrice().getCantidadpromo();

                        //  validamos si la fecha de promocion no se a vencido
                        String fechaacctual = Fecha.getFecha();
                        boolean fechapromo = Fecha.compareFecha(fechaacctual, listprod.getPrice().getFexpiration());
                        
                        //capturamos el precioPromocion
                        Double preciodepromocion = listprod.getPrice().getPricepromo();
                        if (cantipro > 0.0 && fechapromo == true && listprod.getPrice().getPrice() > preciodepromocion) {
                            precioProd = preciodepromocion.toString();
                        } else {
                            precioProd = listprod.getPrice().getPrice().toString();
                        }

                        JSONObject art = new JSONObject();
                        art.put("value", listprod.getSku() + " | " + listprod.getName() + " | " + pesoproduct + " | $ " + precioProd);

                        JSONObject data = new JSONObject();
                        data.put("skup", listprod.getSku());
                        data.put("name", listprod.getName());
                        data.put("price", precioProd);
                        data.put("size", pesoproduct);

                        art.put("data", data);
                        array.add(art);
                    }
                }
            }
        }
        
        } catch (Exception e) {
            
            JSONObject error = new JSONObject();
            
            error.put("error", e.getCause().toString());
            error.put("sms", e.getMessage());
            error.put("code", e.getLocalizedMessage());
            array.add(error);
            
        }
        out.print(array);
    }
}
