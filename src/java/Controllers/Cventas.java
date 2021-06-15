package Controllers;

import Dao.CreditDetailsDao;
import Dao.CreditsDao;
import Dao.CustomerDao;
import Dao.HeaderPurchaseOrderDao;
import Dao.NumfactDao;
import Dao.OrderDetailsDao;
import Dao.PersonDao;
import Dao.ProductDao;
import Entity.CreditDetails;
import Entity.Credits;
import Entity.Customer;
import Entity.Fecha;
import Entity.HeaderPurchaseOrder;
import Entity.OrderDetails;
import Entity.Person;
import Entity.Product;
import Entity.TypePay;
import Utils.GenerateNumFact;
import Utils.Validate;
import static Utils.Validate.RedondearDec;
import static Utils.Validate.esDecimal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet(name = "Cventas", urlPatterns = {"/Cventas"})
public class Cventas extends HttpServlet {

    String acceso = "";
    String ruta = "ventas/";
    String msg = "";
    HttpSession session = null;
    List<OrderDetails> DetailSales = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String page = request.getParameter("accion");

        if (page.equals("newventa")) {
            this.vistaventa(request, response);
        } else if (page.equals("listventa")) {
            this.listaventas(request, response);
        } else if (page.equals("searchcus")) {// metodo para buscar cliente por dni
            this.searchcli(request, response);
        } else if (page.equals("incustomer")) {
            this.innewcustomer(request, response);
        } else if (page.equals("productlist")) {
            this.registerNewCustomer(request, response);
        } else if (page.equals("addToCar")) {
            this.addDetailSales(request, response);
        } else if (page.equals("searhArticle")) {
            this.searchArticle(request, response);
        } else if (page.equals("sDc")) {
            this.saveSales(request, response);
        } else if (page.equals("cs")) {
            this.deleteSales(request, response);
        } else if (page.equals("anulaFact")) {
            this.anulaFact(request, response);
        } else if (page.equals("listpagos")) {
            this.listpagos(request, response);
        } else if (page.equals("printCredit")) {
            this.printCredit(request, response);
        }else if (page.equals("regpago")) {
            this.regpago(request, response);
        }
        else if (page.equals("listfact")) {
            this.Listafacturas(request, response);
        }else {
            this.homepage(request, response);
        }
        
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

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    //registrando pagos
    
    private void regpago(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        request.setCharacterEncoding("UTF-8");
        acceso = "listventa";
        int idc = Integer.parseInt(request.getParameter("idcredit").trim());
        double monto =Double.parseDouble(request.getParameter("monto").trim());        
        String namecli = request.getParameter("namec").trim();
        
        CreditDetails d = new CreditDetails();
        d.setAmountpay(monto);
        d.setCredits_id(idc);
        d.setNamecustomer(namecli);
        
        CreditDetailsDao cd = new CreditDetailsDao();
        
        if (cd.Insert(d)) {
            msg = "<span class='badge bg-success'>Se registró el pago</span>";
        }else{
            msg = "<span class='badge bg-danger'>No se registró el pago</span>";
        }
        request.setAttribute("page", ruta + acceso);
        request.setAttribute("mensaje", msg);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    
    //IMPRIMRI LA CABECERA DE DEUDAS
    private void printCredit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));

        CreditsDao c = new CreditsDao();
        Credits l = c.infocredihead(id);
        
        JSONObject o = new JSONObject(); 
        
        if (l != null) {            
            CreditDetailsDao cd =new CreditDetailsDao();
            
            CreditDetails d = cd.ListByAtrib(l.getId());
            
            double deuda = RedondearDec(l.getAmount());
            
            double pagar = 0.0;
            if (d != null) {                
                deuda = l.getAmount() - d.getAmountpay();
                pagar = d.getAmountpay();
            }
            
            o.put("id", l.getId());
            o.put("total", RedondearDec(l.getAmount()));
            o.put("pagar", RedondearDec(deuda));
            o.put("acum", RedondearDec(pagar)); 
            
        }

        out.print(o);

    }

    private void listpagos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));

        JSONArray jr = new JSONArray();

        CreditDetailsDao cd = new CreditDetailsDao();
        List<CreditDetails> lc = cd.ListByKey(id);

        if (lc != null) {

            Iterator<CreditDetails> icr = lc.iterator();
            CreditDetails ncd = null;
            int i = 1;
            while (icr.hasNext()) {
                ncd = icr.next();

                JSONObject jo = new JSONObject();

                jo.put("i", i);
                jo.put("monto", "S/ " + RedondearDec(ncd.getAmountpay()));
                jo.put("fpago", ncd.getFechapago());
                jo.put("rp", ncd.getNamecustomer());

                i++;
                jr.add(jo);
            }
        }

        JSONObject root = new JSONObject();
        root.put("datos", jr);
        out.print(root);

    }

    private void anulaFact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String id = request.getParameter("id");

        HeaderPurchaseOrderDao hd = new HeaderPurchaseOrderDao();
        JSONObject c = new JSONObject();
        if (hd.AnularFact(id)) {
            c.put("ok", "OK La factura fue anulada");
        } else {
            c.put("ok", "Opss La factura no fue anulada anulo");
        }

        out.print(c);

    }

    private void vistaventa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        acceso = "ventanueva";
        //msg = "Realice Venta Nueva";
        //request.setAttribute("mensaje", msg);
        request.setAttribute("page", ruta + acceso);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    private void Listafacturas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        HeaderPurchaseOrderDao vd = new HeaderPurchaseOrderDao();

        String nfact = (request.getParameter("id")!= null ? request.getParameter("id") : "0");
        
        List<HeaderPurchaseOrder> ls = vd.ListByKey(nfact);

        JSONArray array = new JSONArray();
        String state = "";
        int i = 1;

        if (ls.size() > 0) {

            Iterator<HeaderPurchaseOrder> it = ls.iterator();

            HeaderPurchaseOrder listah = null;

            while (it.hasNext()) {
                listah = it.next();

                String botonEdit = "<a title='Editar Factura' class='btn btn-primary btn-sm'  id='" + listah.getPurchasecode() + "'  href='javascript:editfact(\"" + listah.getPurchasecode() + "\")'><i class='far fa-search  fa-2x'></i></a>";
                String botonprint = "<a title='Imprimir Factura' class='btn btn-success btn-sm'  id='" + listah.getPurchasecode() + "'  href='javascript:PrintDoc(\"" + listah.getPurchasecode() + "\")'><i class='far fa-print  fa-2x'></i></a>";

                String botonAnulate = "";

                JSONObject cust = new JSONObject();

                if (listah.getState().equalsIgnoreCase("a")) {

                    state = "<span class='badge bg-primary' style='font-size: 17px'>Emitido</span>";

                    if (listah.getPaymentmethod_id() == 2) {

                        CreditsDao crd = new CreditsDao();
                        Credits cre = crd.ViewCredits(listah.getId());

                        if (cre != null) {

                            double rss = cre.getAmount() - cre.getCdetalle().getAmountpay();
                            rss = RedondearDec(rss);
                            if (cre.getAmount() <= cre.getCdetalle().getAmountpay()) {
                                state = "<a title='Ver lista de Pagos' class='btn btn-success  btn-sm'  id='" + listah.getId() + "'  href='javascript:VerCuenta(\"" + listah.getId() + "\")'><i class='fas fa-medal  fa-2x'></i></a>";
                            } else {
                                state = "<a title='Ver Crédito' class='btn btn-danger  btn-sm'  id='" + listah.getId() + "'  href='javascript:VerCuenta(\"" + listah.getId() + "\")'><i class='fas fa-frown  fa-2x'></i></a>";
                                state = state + "<span class='badge badge-warning' style='font-size: 17px'>-S/." + rss + "</span></button>";
                            }

                        } else {
                            state = "<a title='No hay Registro de pagos' class='btn btn-warning  btn-sm'  id='" + listah.getId() + "'  href='javascript:VerCuenta(\"" + listah.getId() + "\")'><i class='fas fa-frown  fa-2x'></i></a>";
                        }
                    } else {
                        botonAnulate = "<a title='Anular Factura' class='btn btn-danger btn-sm'  id='" + listah.getPurchasecode() + "'  href='javascript:AnulateDoc(\"" + listah.getPurchasecode() + "\")'><i class='far fa-close  fa-2x'></i></a>";
                    }

                } else {
                    state = "<span class='badge bg-danger' style='font-size: 17px'>Anulado</span>";
                }

                cust.put("id", listah.getPurchasecode());
                cust.put("femis", listah.getOrderdate());
                cust.put("estado", state);
                cust.put("inpuesto", "S/. " + listah.getIgv());
                cust.put("total", "S/. " + listah.getTotalamount());

                cust.put("accion", botonEdit + " " + botonprint + " " + botonAnulate);

                array.add(cust);
                i++;

            }

        }

        JSONObject root = new JSONObject();
        root.put("datos", array);
        out.print(root);
    }

    private void listaventas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        acceso = "listventa";
        msg = "Lista de ventas";
        request.setAttribute("mensaje", msg);
        request.setAttribute("page", ruta + acceso);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void homepage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        acceso = "error";
        msg = "Error: la pagina no encontró";
        ruta = "views/";
        request.setAttribute("menasaje", msg);
        request.setAttribute("page", ruta + acceso);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    private void searchcli(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String idper = request.getParameter("doc");

        CustomerDao cusdao = new CustomerDao();

        Customer listcus = cusdao.SelectByDoc(idper);

        JSONObject c = new JSONObject();

        //buscamos en la tabla personas i se encuentra la persona
        PersonDao persondao = new PersonDao();
        Person person = persondao.SearchBydoc(idper);

        String sms = "";
        String addcus = "";

        if (listcus != null) {
            sms = "Cliente Encontrado";
            addcus = "<label class='alert alert-success errorduplicado'>" + sms + "</label>";

            c.put("id", "c");
            c.put("cusid", listcus.getId());
            c.put("personid", listcus.getPerson_id());
            c.put("lineb", listcus.getLinecredito());
            c.put("linea", listcus.getLineacumulada());
            c.put("nombre", listcus.getPersona().getName());
            c.put("doc", listcus.getPersona().getNumdoc());
            c.put("address", listcus.getAddress().getAdress());
            c.put("msg", addcus);

        } else if (person != null) {

            sms = "Ya exisite Un usuario, desea crear un cliente con usuario existente? Click aqui para crear ";
            addcus = "<label id='userName2-error' class='error errorduplicado' for='userName2'>" + sms + "</label> <a class='errorduplicado btn btn-primary btn-sm' href='javascript:addcustomer(" + person.getId() + ")'><i class='far fa-user-plus fa-2x'></i></a>";

            c.put("id", "p");
            c.put("idper", person.getId());
            c.put("nombre", person.getName());
            c.put("msg", addcus);

        } else {
            sms = "No exisite Cliente solicitado.";
            addcus = "<label id='userName2-error' class='error errorduplicado' for='userName2'>" + sms + "</label>";

            c.put("id", "n");
            c.put("nombre", "#Ningun usuario encontrado");
            c.put("idanon", "000");
            c.put("msg", addcus);
        }

        out.print(c);

    }

    private void innewcustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        response.setContentType("text/html;charset=UTF-8");
        //incustomer
        acceso = "ventanueva";
        msg = "";

        String lineacredito = request.getParameter("linecredit").trim();
        String idper = request.getParameter("idperson").trim();
        // String namecus = request.getParameter("personname").trim();

        CustomerDao customerDao = new CustomerDao();
        Customer customer = new Customer();

        double linec = 0.0;
        if (Validate.esDecimalPositivo(lineacredito)) {

            linec = Double.parseDouble(lineacredito);

        } else {
            request.setAttribute("mensaje", "El campo linea credito no acepta letras.");
            request.setAttribute("page", ruta + acceso);
            RequestDispatcher vista = request.getRequestDispatcher("index.jsp");
            vista.forward(request, response);
        }

        int perid = 0;

        if (Validate.esEnteroPositivo(idper)) {
            perid = Integer.parseInt(idper);
        } else {
            request.setAttribute("mensaje", "El campo codigo persona no acepta caracteres.");
            request.setAttribute("page", ruta + acceso);
            RequestDispatcher vista = request.getRequestDispatcher("index.jsp");
            vista.forward(request, response);
        }

        customer.setLinecredito(linec);
        customer.setPerson_id(perid);
        customer.setTypecustomer_id(1);

        if (customerDao.Insert(customer)) {
            msg = "El cliente:  se registró con Éxito.";
            // request.setAttribute("page", ruta + acceso);
        } else {
            msg = "Erro: El cliente:  no se registró!";
        }

        msg = "todo valido";
        request.setAttribute("page", ruta + acceso);
        request.setAttribute("mensaje", msg);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    //para registrar cliente nuevo desde la ventana modal
    public void registerNewCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        out = response.getWriter();
        ProductDao modelProduct = new ProductDao();

        String codigo = request.getParameter("searching");
        int rows = 10;//Integer.parseInt(request.getParameter("rows"));

        List<Product> listProduct = modelProduct.listAll(codigo, 0, rows);
        Iterator<Product> iterpro = listProduct.iterator();

        Product listprod = null;

        JSONArray array = new JSONArray();

        int i = 1;

        if (listProduct.size() >= 0) {

            //creamos el objeto para llenar los articulos           
            while (iterpro.hasNext()) {

                listprod = iterpro.next();

                //personalizamos Peso/Tamaño
                String pesoproduct = "";
                if (listprod.getPeso() == 0.0) {
                    pesoproduct = listprod.getSize().getSimbolo();
                } else {
                    pesoproduct = String.valueOf(listprod.getPeso()) + " " + listprod.getSize().getSimbolo();
                }

                //personalizamos el precio
                String precioaplicado = "";                //  capruramos la cantidad de promocion para comparar
                Double cantipro = listprod.getPrice().getCantidadpromo();                //  validamos si la fecha de promocion no se a vencido
                String fechaacctual = Fecha.getFecha();
                boolean fechapromo = Fecha.compareFecha(fechaacctual, listprod.getPrice().getFexpiration());                //capturamos el precioPromocion
                Double preciodepromocion = listprod.getPrice().getPricepromo();
                //si el precio promocion es null o 0.0= establecer 0.0 al precio prmocion
                //si cant en promocion es 0, si la fecha es menor, y el precio es mayor que precio promocion se aplica precio promocion
                if (cantipro > 0.0 && fechapromo == true && listprod.getPrice().getPrice() > preciodepromocion) {
                    precioaplicado = "<s>S/. " + listprod.getPrice().getPrice().toString() + "</s><br><span class='priceproduct'>S/." + preciodepromocion + "</span>";
                } else {
                    precioaplicado = "S/.<span id='" + listprod.getSku() + "' class=\"priceproduct\">" + listprod.getPrice().getPrice().toString() + "</span>";
                }

                String cantidadStock = "";
                if (String.valueOf(listprod.getStock().getQuantity()).equals("0.0")) {
                    cantidadStock = "<span class='bg-danger text-white text-center rounded'>" + listprod.getStock().getQuantity().toString() + "</span>";
                } else {//si no hay stock, ponemos mostramos 0.00
                    cantidadStock = "<span class='bg-primary text-white text-center rounded'>" + listprod.getStock().getQuantity().toString() + "</span>";
                }

                //String btnadd = "<button class=\"btn btn-warning\" onclick=\"agregarDetalle(+ listprod.getSku() +',\''+$reg->nombre+'\',\''+$reg->precio_venta+'\')"><span class="fa fa-plus"></span></button>';
                String botonAdd = "<a title=\"Ver Detalle\" class=\"btn btn-primary btn-sm\" id=\"" + listprod.getSku() + "\"  href=\"javascript:addProdToTable('" + listprod.getSku() + "','" + listprod.getName() + "','" + listprod.getPrice().getPrice().toString() + "')\"><i class=\"fas fa-cart-plus fa-2x\"></i></a>";

                JSONObject art = new JSONObject();

                art.put("0", i);//id
                art.put("1", listprod.getName());//nombre
                art.put("2", listprod.getDescription());//descripcion
                art.put("3", pesoproduct);//unidad de medida
                art.put("4", precioaplicado);// precio
                art.put("5", cantidadStock); //stock
                art.put("6", "i"); //foto
                art.put("7", botonAdd); //opcion            

                array.add(art);
                i++;
            }

        }

        JSONObject root = new JSONObject();
        root.put("sEcho", 1); // inf para datatable
        root.put("iTotalRecords", listProduct.size()); //total de registros
        root.put("iTotalDisplayRecords", 15); //total a visualizar
        root.put("aaData", array);
        out.print(root);

    }

    //cargar datos a la ventana modal
    public void showProductOnPopUp(HttpServletRequest rs, HttpServletResponse rp) {

    }

    public void addDetailSales(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        String sms = "";
        

        if (session == null) {
            session = request.getSession(true);            
        }

        JSONObject Detalle = new JSONObject();

        if (session != null) {
            
            if (DetailSales == null) {//si no existe objeto detalle, lo creamos
                DetailSales = new ArrayList<>();
                
            }
            if (session.getAttribute("carrito") == null) {
                session.setAttribute("carrito", DetailSales);               
            }

            if (session.getAttribute("carrito") != null && DetailSales != null) {// si no exite la session, lo creamos
                
                String tipos = (request.getParameter("type") != null ? request.getParameter("type") : "");
                String skup = (request.getParameter("skup") != null ? request.getParameter("skup") : "");
                String cantidad = (request.getParameter("cantp") != null ? request.getParameter("cantp") : "");
                String preciop = (request.getParameter("pricep") != null ? request.getParameter("pricep") : "");
                Double cantp = 0.00;
                Double precio = 0.00;
                int tipo = 0;

                if (Validate.esEnteroPositivo(tipos)) {

                    tipo = Integer.parseInt(tipos);
                    OrderDetails detail = new OrderDetails();
                    ProductDao pdao = new ProductDao();

                    if (tipo <= 2 && tipo > 0) {

                        if (esDecimal(cantidad) && esDecimal(preciop) && !skup.equals("")) {

                            cantp = RedondearDec(Double.parseDouble(cantidad));
                            precio = RedondearDec(Double.parseDouble(preciop));

                            Product prod = pdao.SearchBySku(skup);

                            if (prod != null) {

                                detail.setProduct_sku(prod.getSku());
                                detail.setProductname(prod.getName());
                                detail.setQuantity(cantp);
                                detail.setAmount(precio);

                                detail.setPeso(prod.getPeso());
                                detail.setSimbolo(prod.getSize().getSimbolo());
                                //detail.setHeaderid(cantp);
                                Double newCanti = 0.00;
                                Double Subtotal = cantp * precio;
                                detail.setSubtotal(RedondearDec(Subtotal));

                                OrderDetails det;
                                if (session.isNew() || DetailSales.size() == 0) {

                                    DetailSales.add(detail);
                                    session.setAttribute("carrito", DetailSales);

                                    sms = "La session carrito se creó";

                                    Detalle.put("tipo", 1);
                                    Detalle.put("cantidad", detail.getQuantity());
                                    Detalle.put("precio", detail.getAmount());
                                    Detalle.put("subtotal", detail.getSubtotal());
                                    Detalle.put("ok", true);

                                } else {
                                    DetailSales = (ArrayList<OrderDetails>) session.getAttribute("carrito");
                                    int indice = -1;
                                    for (int i = 0; i < DetailSales.size(); i++) {

                                        det = DetailSales.get(i);

                                        if (det.getProduct_sku().equalsIgnoreCase(prod.getSku()) && tipo == 1) {//cuando se modifique la cantidad e el precio es 
                                            newCanti = (det.getQuantity() + detail.getQuantity()) * 1;

                                            Subtotal = RedondearDec(newCanti * det.getAmount());

                                            DetailSales.get(i).setQuantity(newCanti);
                                            DetailSales.get(i).setAmount(det.getAmount());
                                            DetailSales.get(i).setSubtotal(Subtotal);

                                            Detalle.put("tipo", 1);
                                            Detalle.put("cantidad", newCanti);
                                            Detalle.put("precio", det.getAmount());
                                            Detalle.put("subtotal", Subtotal);
                                            Detalle.put("ok", true);
                                            indice = i;
                                            i = DetailSales.size();
                                            break;
                                        } else if (det.getProduct_sku().equalsIgnoreCase(prod.getSku()) && tipo == 2) { //cuando se modifique el precio en el detalle de compra

                                            Subtotal = RedondearDec(detail.getQuantity() * detail.getAmount());

                                            DetailSales.get(i).setQuantity(detail.getQuantity());
                                            DetailSales.get(i).setAmount(detail.getAmount());
                                            DetailSales.get(i).setSubtotal(Subtotal);

                                            Detalle.put("tipo", 2);
                                            Detalle.put("cantidad", detail.getQuantity());
                                            Detalle.put("precio", detail.getAmount());
                                            Detalle.put("subtotal", Subtotal);
                                            Detalle.put("ok", true);
                                            indice = i;
                                            i = DetailSales.size();
                                            break;
                                        }

                                    }

                                    if (indice == -1) {//agrega al producto cuendo es nuevo
                                        DetailSales.add(detail);
                                        sms = "Agregado con éxito.";
                                        Subtotal = RedondearDec(detail.getQuantity() * detail.getAmount());
                                        Detalle.put("tipo", 3);
                                        Detalle.put("cantidad", detail.getQuantity());
                                        Detalle.put("precio", detail.getAmount());
                                        Detalle.put("subtotal", Subtotal);
                                        Detalle.put("ok", true);

                                    } else {
                                        // DetailSales.set(indice, detail);
                                        sms = "Actualizado con éxito.";
                                    }
                                    sms = "El prodcuto fue " + sms;
                                    session.setAttribute("carrito", DetailSales);
                                    Detalle.put("sms", sms);
                                }//en else add o update producto

                                //imprimiendo los productos del detalle de producto
                                DetailSales = (ArrayList<OrderDetails>) session.getAttribute("carrito");
                                Double monTota = 0.0;

                                for (int i = 0; i < DetailSales.size(); i++) {
                                    OrderDetails dt = DetailSales.get(i);
                                    monTota = monTota + dt.getSubtotal();
                                }

                                Detalle.put("total", RedondearDec(monTota));

                            } else {
                                sms = "El producto ingresado no existe en el sistema";
                                Detalle.put("tipo", 0);
                                Detalle.put("sms", sms);
                                Detalle.put("ok", false);
                            }

                        } else {
                            sms = "Ingrese correctamente los parámetros.";
                            Detalle.put("tipo", 0);
                            Detalle.put("sms", sms);
                            Detalle.put("ok", false);
                        }
                    } else if (tipo == 3 && DetailSales.size() > 0) {//--eliminar porducto de la lista

                        OrderDetails listDel;
                        int eliminado = -1;

                        DetailSales = (ArrayList<OrderDetails>) session.getAttribute("carrito");

                        for (int i = 0; i < DetailSales.size(); i++) {
                            listDel = DetailSales.get(i);
                            if (listDel.getProduct_sku().equalsIgnoreCase(skup)) {
                                DetailSales.remove(i);
                                eliminado = i;
                                i = DetailSales.size();
                                break;
                            }
                        }

                        if (eliminado != -1) {

                            session.setAttribute("carrito", DetailSales);

                            Detalle.put("tipo", 4);
                            Detalle.put("sms", "El artículo se elimino con éxito");
                            Detalle.put("ok", true);
                            DetailSales = (ArrayList<OrderDetails>) session.getAttribute("carrito");
                            Double monTota = 0.0;

                            for (int i = 0; i < DetailSales.size(); i++) {

                                OrderDetails dt = DetailSales.get(i);
                                monTota = monTota + dt.getSubtotal();
                            }
                            Detalle.put("total", RedondearDec(monTota));
                        } else {
                            Detalle.put("sms", "El artículo no se pudo eliminar");
                            Detalle.put("ok", false);
                        }
                    } else {
                        sms = "El artículo a eliminar no existe";
                        Detalle.put("tipo", 0);
                        Detalle.put("sms", sms);
                        Detalle.put("ok", false);
                    }

                    //DetailSales.clear(); //limpiamos el arraylista
                } else {
                    sms = "El tipo no entro, type:" + tipos;
                    Detalle.put("tipo", 0);
                    Detalle.put("sms", sms);
                    Detalle.put("ok", false);
                }
            } else {
                sms = "El carrito es null:" + 0;
                Detalle.put("tipo", 0);
                Detalle.put("sms", sms);
                Detalle.put("ok", false);
            }
        } else {

            sms = "La session es null:" + 0;
            Detalle.put("tipo", 0);
            Detalle.put("sms", sms);
            Detalle.put("ok", false);
        }

        out.print(Detalle);
        Detalle.clear();

    }

    private void searchArticle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String codigo = request.getParameter("sku");

        JSONObject json = new JSONObject();

        if (!codigo.equals(null)) {

            ProductDao modelProduct = new ProductDao();
            Product listPro = modelProduct.ListByAtrib(codigo);

            if (listPro != null) {
                json.put("skup", listPro.getSku());
                json.put("namep", listPro.getName());
                json.put("peso", listPro.getPeso());
                json.put("color", listPro.getColor().getName());
                json.put("simbolo", listPro.getSize().getSimbolo());
                json.put("price", listPro.getPrice().getPrice());
            } else {
                json.put("skup", "-");
                json.put("codigo", "1" + codigo);
            }

        } else {
            json.put("skup", "-");
            json.put("codigo", "2" + codigo);
        }
        out.print(json);
    }//endSearch

    private void saveSales(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        acceso = "ventanueva";
        msg = "";

        String IdCus = (request.getParameter("customid") != null ? request.getParameter("customid") : "1");
        String docCus = (request.getParameter("numdoc") != null ? request.getParameter("numdoc").trim() : "0");
        String typePago = (request.getParameter("typePay") != null ? request.getParameter("typePay") : "");
        String totalPagar = (request.getParameter("amountv") != null ? request.getParameter("amountv") : "");

        //9321654845126
        JSONObject saveSale = new JSONObject();
        Double mtt = 0.0;
        int cusId = 1;

        CustomerDao cd = new CustomerDao();

        //validamos si el cliente existe
        if (!docCus.equals("0")) {
            if (!cd.validateC(docCus)) {
                cusId = 0;
            } else {
                if (Validate.esEnteroPositivo(IdCus)) {
                    cusId = Integer.parseInt(IdCus);
                } else {
                    cusId = 0;
                }
            }
        }

        if (Validate.esDecimalPositivo(totalPagar) && Validate.esEnteroPositivo(typePago) && Validate.esEnteroPositivo(IdCus)) {

            mtt = Double.parseDouble(totalPagar);

            int tipodepago = 0;

            if (cusId != 0) {
                TypePay tipago = new TypePay(Integer.parseInt(typePago));
                if (tipago.getTipo() > 0) {
                    tipodepago = tipago.getTipo();
                } else {
                    tipodepago = 1;
                }
                if (session != null) {

                    if (session.getAttribute("carrito") != null && DetailSales != null) {// si no exite la session, lo creamos

                        OrderDetails listDel;
                        Double totalp = 0.0;
                        GenerateNumFact nFact = new GenerateNumFact();
                        String nCod = nFact.lastID("b");//purchaseCode
                        DetailSales = (ArrayList<OrderDetails>) session.getAttribute("carrito");

                        if (DetailSales.size() > 0) {

                            HeaderPurchaseOrder header = new HeaderPurchaseOrder();
                            header.setPurchasecode(nCod);//numero de documento
                            header.setTypedocument("b");//Tipo Documento
                            header.setOrderdate(Fecha.getFecha());//fecha
                            header.setSubtotal(mtt);
                            header.setIgv(0.00);
                            header.setTotalamount(mtt);
                            header.setState("a");
                            header.setCustomer_id(cusId);
                            header.setPaymentmethod_id(tipodepago);
                            header.setUsersId(1);

                            HeaderPurchaseOrderDao headerDao = new HeaderPurchaseOrderDao();
                            int idHead = headerDao.insertGetId(header);
                            if (idHead != -1) {

                                if (DetailSales.size() > 0) {
                                    int drows = DetailSales.size();
                                    int rg = -1;
                                    String svDok = "";
                                    String nSaved = "";
                                    OrderDetailsDao saveOrder = new OrderDetailsDao();

                                    for (int i = 0; i < DetailSales.size(); i++) {

                                        listDel = DetailSales.get(i);
                                        listDel.setHeaderid(idHead);

                                        if (saveOrder.Insert(listDel)) {
                                            if (drows == i + 1) {
                                                rg = i;
                                            }
                                        } else {
                                            nSaved = nSaved + " | " + listDel.getProduct_sku() + ":" + listDel.getProductname() + " /n;";
                                        }
                                        totalp = totalp + listDel.getSubtotal();
                                        if (drows == i + 1) {
                                            rg = i;
                                        }
                                    }
                                    if (rg != -1) {
                                        DetailSales.clear();
                                        session.removeAttribute("carrito");
                                        NumfactDao nIdFact = new NumfactDao();
                                        nIdFact.Insert("");//genreamos el indice para la factura
                                        String sms = "La venta con N° '" + nCod + "' se registro con éxito: S/. " + RedondearDec(totalp);
                                        saveSale.put("n", nCod);
                                        saveSale.put("ok", true);

                                        if (tipodepago == 2) {

                                            Credits cr = new Credits(0, totalp, "1", "", 1, Fecha.getFecha(), "" + cusId, idHead);
                                            CreditsDao crd = new CreditsDao();

                                            if (crd.Insert(cr)) {
                                                sms = sms + "; Cuenta por pagar Guardado.";
                                            }

                                        }
                                        saveSale.put("sms", sms);

                                    } else {
                                        headerDao.DeleteByKey(idHead);
                                        saveSale.put("sms", "No se registró los producto: " + nSaved);
                                        saveSale.put("ok", false);
                                    }

                                } else {
                                    saveSale.put("ok", false);
                                    saveSale.put("sms", "El Detalle está vacía");
                                }

                            } else {
                                saveSale.put("ok", false);
                                saveSale.put("sms", "Cabecera de la venta no se pudo registrar");
                            }
                        } else {
                            saveSale.put("ok", false);
                            saveSale.put("sms", "Detalle de la venta Vacía");
                        }

                    } else {
                        saveSale.put("ok", false);
                        saveSale.put("sms", "Agregue productos al detalle");
                    }
                } else {
                    saveSale.put("ok", false);
                    saveSale.put("sms", "La session no esta creada");
                }
            } else {
                saveSale.put("ok", false);
                saveSale.put("sms", "El cliente seleccionado no existe o fue modificado en tiempo de ejecucion.");
            }
        } else {
            saveSale.put("ok", false);
            saveSale.put("sms", "Ingrese los campos correctamente");
        }
        out.print(saveSale);

    }

    private void deleteSales(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*HttpSession session = null;
        List<OrderDetails> DetailSales = null;*/
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");

        JSONObject dSale = new JSONObject();

        if (session != null) {
            if (session.getAttribute("carrito") != null && DetailSales != null) {// si no exite la session, lo creamos
                session.removeAttribute("carrito");
                DetailSales.clear();
                dSale.put("sms", "Venta anulada");
                dSale.put("ok", true);
            } else {
                dSale.put("ok", false);
                dSale.put("sms", "El detalle de compras esta vacía");
            }
        } else {
            dSale.put("ok", false);
            dSale.put("sms", "Agrega Productos para comprar");
        }

        out.print(dSale);
    }

}
