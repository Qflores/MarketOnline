package Controllers;

import Dao.ContactDao;
import Dao.CustomerDao;
import Dao.PersonDao;
import Entity.Contact;
import Entity.Customer;
import Entity.Fecha;
import Entity.Person;
import Utils.Validate;
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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet(name = "Ccustomer", urlPatterns = {"/Ccustomer"})

public class Ccustomer extends HttpServlet {

    String ruta = "customer/";
    String acceso = "";
    String msg = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String page = request.getParameter("accion");

        if (page.equals("vinsertc")) {//muestra el formulario para registrar cliente
            this.vinsertc(request, response);
        } else if (page.equals("updatec")) {// inserta en las tablas: contact; person y Customer
            this.insertcn(request, response);
        } else if (page.equals("incustomer")) {//inserta en tabla customer
            this.inewcustomer(request, response);
        } else if (page.equals("searchperson")) {// buscar cliente existente y person
            this.buscarpersona(request, response);
        } else if (page.equals("viewupdate")) {// formulario para actualizar cliente
            this.viewupdatecustomer(request, response);
        } else if (page.equals("viewlistc")) { // vista lista de clientes
            this.viewlistcustomer(request, response);
        } else if (page.equals("listcustomer")) {
            this.searchById(request, response);
        } else if (page.equals("scbyid")) {
            this.BuscarPorId(request, response); // para editar dartos del cliente
        } else if (page.equals("listclientes")) {
            this.searchCustomers(request, response);
        } else if(page.equals("sct")){
            this.BuscarCliKeypress(request, response);
        }//
        else if(page.equals("inc")){ // insertar cliente nuevo
            this.insertNewCustomer(request, response);
        }
        else {                                // retorna al home
            this.viewHome(request, response);
        }

    }

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
    }
    
    //buscar cliente para la venta keypress
    private void BuscarCliKeypress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");        
        PrintWriter out = response.getWriter();
        CustomerDao customerdao = new CustomerDao();        
        String nombre = (request.getParameter("cname").trim() !=null ? request.getParameter("cname").trim():"");
              
        List<Customer> listcus =customerdao.ListCliForOption(nombre);
        
        JSONArray array = new JSONArray();
        
        if (listcus.size() > 0){
            
        Iterator<Customer> itercus = listcus.iterator(); 
        
        Customer listac = null;
        
                    
            while (itercus.hasNext()) {            
                listac = itercus.next();
                
                JSONObject cust = new JSONObject();                
                cust.put("value", listac.getPersona().getNumdoc()+" | "+(listac.getPersona().getName()+" "+listac.getPersona().getFirstname()+" "+listac.getPersona().getLastname()).toUpperCase());
                
                JSONObject data = new JSONObject();
                
                data.put("idper", listac.getId());
                data.put("doc", listac.getPersona().getNumdoc());
                data.put("line", listac.getLinecredito());
                data.put("linea", listac.getLineacumulada());
                data.put("type", listac.getTypecustomer().getName());
                data.put("telefono", listac.getAddress().getNumphone());
                data.put("sexo", listac.getPersona().getSexo());                
                cust.put("data", data);
                array.add(cust);                
            }
        }
        out.print(array);
    }
    
    //buscar cliente por id
    private void searchById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        CustomerDao customerdao = new CustomerDao();

        String doc = (request.getParameter("cname").trim() != null ? request.getParameter("cname").trim() : "0");

        List<Customer> listcus = customerdao.ListByKey(doc);
        Iterator<Customer> itercus = listcus.iterator();
        Customer listac = null;

        JSONArray array = new JSONArray();

        if (listcus.size() > 0) {
            while (itercus.hasNext()) {
                listac = itercus.next();

                JSONObject cust = new JSONObject();
                cust.put("value", listac.getPersona().getNumdoc() + " | " + (listac.getPersona().getName() + " " + listac.getPersona().getFirstname() + " " + listac.getPersona().getLastname()).toUpperCase());

                JSONObject data = new JSONObject();

                data.put("idper", listac.getId());
                data.put("doc", listac.getPersona().getNumdoc());
                data.put("line", listac.getLinecredito());
                data.put("linea", listac.getLineacumulada());
                data.put("type", listac.getTypecustomer().getName());
                data.put("telefono", listac.getAddress().getNumphone());
                data.put("sexo", listac.getPersona().getSexo());

                cust.put("data", data);
                array.add(cust);
            }
        }
        out.print(array);

    }

    private void vinsertc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        msg = "Registre Cliente Nuevo.";
        acceso = "regcustomer";
        request.setAttribute("page", ruta + acceso);
        request.setAttribute("mensaje", msg);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    private void viewHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        acceso = "error";
        msg = "la pagina no se encontró";
        ruta = "views/";

        request.setAttribute("page", ruta + acceso);
        request.setAttribute("mensaje", msg);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }
    //ACTUALIZAR CLIENTE
    private void insertcn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        acceso = "listcustomer";
        msg = "";

        //----------------table person--------------------------------cdoc
        String idp = (request.getParameter("idper") != null ? request.getParameter("idper").trim() : "");//idper
        //String idp = (request.getParameter("cdoc") != null ? request.getParameter("cdoc").trim() : "");//dni/ruc
        String cname = (request.getParameter("name") != null ? request.getParameter("name").trim() : "");//cli name
        String apep = (request.getParameter("ape") != null ? request.getParameter("ape").trim() : "");//ap paterno
        String fechareg = Fecha.getFecha();

        //---------------table contact-------------------------------
        String adress = (request.getParameter("dir") != null ? request.getParameter("dir").trim() : "");
        String email = (request.getParameter("email") != null ? request.getParameter("email").trim() : "");
        String tel1 = (request.getParameter("tel1") != null ? request.getParameter("tel1").trim() : "");
        String tel2 = (request.getParameter("tel2") != null ? request.getParameter("tel2").trim() : "");

        //---------------table customer-------------------------------
        String line1 = (request.getParameter("line1") != null ? request.getParameter("line1").trim() : "0");
        String line2 = (request.getParameter("line2") != null ? request.getParameter("line2").trim() : "0");

        int id = 0;

        if (Validate.esEnteroPositivo(idp)) {
            id = Integer.parseInt(idp);
        }
        
                
        Double lin1 = Double.parseDouble(line1);
        Double lin2 = Double.parseDouble(line2);
        if (id != 0) {
            
            Person person = new Person(); 
            person.setId(id);
            person.setName(cname);
            person.setFirstname(apep);
            person.setEnrollmentdate(fechareg);
            
            PersonDao persondao = new PersonDao();
            
            if (persondao.Update(person)) {
                msg = " ";

                    Contact contact = new Contact(adress, email, tel1, tel2, id);
                    ContactDao contacdao = new ContactDao();
                    if (contacdao.Update(contact)) {
                        msg += "<div class=\"alert alert-success\" role=\"alert\">El Cliente, se actualizo.</div> ";
                    } else {
                        msg += "";
                    }
                    
                    Customer customer = new Customer(id, lin1, lin2);
                    CustomerDao customerdao = new CustomerDao();

                    if (customerdao.Update(customer)) {
                        msg += " ";
                    } else {
                        msg += "";
                    }

            } else {
                msg = "<div class=\"alert alert-warning\" role=\"alert\"> no se Actualizo.</div>";
            }
        }
        request.setAttribute("page", ruta + acceso);
        request.setAttribute("mensaje", msg);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    // registrar cliente nuevo
    private void insertNewCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        acceso = "regcustomer";
        msg = "";

        //----------------table person--------------------------------cdoc
        //String idp = (request.getParameter("idper") != null ? request.getParameter("idper").trim() : "");//idper
        String doc = (request.getParameter("cdoc") != null ? request.getParameter("cdoc").trim() : "");//dni/ruc
        String cname = (request.getParameter("cname") != null ? request.getParameter("cname").trim() : "");//cli name
        String apep = (request.getParameter("capep") != null ? request.getParameter("capep").trim() : "");//ap paterno
        String fechareg = Fecha.getFecha();

        //---------------table contact-------------------------------
        String adress = (request.getParameter("cadress") != null ? request.getParameter("cadress").trim() : "");
        String email = (request.getParameter("cemail") != null ? request.getParameter("cemail").trim() : "");
        String tel1 = (request.getParameter("cphone") != null ? request.getParameter("cphone").trim() : "");
        String tel2 = (request.getParameter("chouse") != null ? request.getParameter("chouse").trim() : "");

        //---------------table customer-------------------------------
        String line1 = "0";//(request.getParameter("line1") != null ? request.getParameter("line1").trim() : "0");
        String line2 = "0";//(request.getParameter("line2") != null ? request.getParameter("line2").trim() : "0");

        long  dc = 0;
        int idper = 0; //almacenamos id de la persona
        if (Validate.esLongPositivo(doc)) {
            dc = Long.parseLong(doc);
        }
        
        
        Double lin1 = Double.parseDouble(line1);
        Double lin2 = Double.parseDouble(line2);
        if (dc != 0) {
            
            Person person = new Person(); 
            person.setNumdoc(doc);
            person.setName(cname);
            person.setFirstname(apep);
            person.setEnrollmentdate(fechareg);
            person.setBirthdate(fechareg);
            person.setSexo("N");
            PersonDao persondao = new PersonDao();
            
            if (persondao.Insert(person)) {
                msg = " ";
                    person = persondao.selectIdPerson(doc);
                    idper = person.getId();
                    
                    Contact contact = new Contact(adress, email, tel1, tel2, idper);
                    
                    ContactDao contacdao = new ContactDao();
                    if (contacdao.Insert(contact)) {
                        msg += "<div class=\"alert alert-success\" role=\"alert\">El Cliente, se inserto.</div> ";
                    } else {
                        msg += "";
                    }
                    
                    Customer customer = new Customer(idper, lin1, lin2);
                    CustomerDao customerdao = new CustomerDao();

                    if (customerdao.Insert(customer)) {
                        msg += " ";
                    } else {
                        msg += "";
                    }

            } else {
                msg = "<div class=\"alert alert-warning\" role=\"alert\">No se registró.</div>";
            }
        }
        request.setAttribute("page", ruta + acceso);
        request.setAttribute("mensaje", msg);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }
    
    private void buscarpersona(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //out = response.getWriter(); 
        Customer customer = new Customer();
        CustomerDao customerd = new CustomerDao();

        Person person = new Person();
        PersonDao persond = new PersonDao();

        String docp = request.getParameter("docp").trim();

        person = persond.SearchBydoc(docp);

        int id = 0;
        String nombre = "";
        String sms = "";

        if (person != null) {

            customer = customerd.ListByAtrib(person.getId());

            if (customer != null) {

                sms = "El cliente ya existe";
                nombre = person.getName();
                id = -1;
            } else {

                sms = "Ya exisite un usuario, desea Agregar como cliente?";
                id = person.getId();
                nombre = person.getName();
            }
        }

        JSONObject json = new JSONObject();

        json.put("idpc", id);
        json.put("namepc", nombre);
        json.put("sms", sms);

        //imprimimos el json
        out.print(json);

    }

    //registrar cliente
    private void inewcustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //incustomer
        acceso = "regcustomer";
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

    private void viewupdatecustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        acceso = "ucustomer";
        msg = "Actualizar Cliente";

        request.setAttribute("page", ruta + acceso);
        request.setAttribute("mensaje", msg);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void BuscarPorId(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        String ids = (request.getParameter("id") != null ? request.getParameter("id").trim() : "0");

        int id = 0;
        if (Validate.esEntero(ids)) {
            id = Integer.parseInt(ids);
        }

        CustomerDao customerdao = new CustomerDao();
        Customer cus = customerdao.searchByID(id);

        JSONObject objcus = new JSONObject();

        if (cus != null) {

            objcus.put("id", cus.getPersona().getId());
            objcus.put("name", cus.getPersona().getName());
            objcus.put("doc", cus.getPersona().getNumdoc());
            objcus.put("ape", cus.getPersona().getFirstname());

            objcus.put("line1", cus.getLinecredito());
            objcus.put("line2", cus.getLineacumulada());

            objcus.put("adress", cus.getAddress().getAdress());
            objcus.put("email", cus.getAddress().getEmail());
            objcus.put("tel1", cus.getAddress().getNumphone());
            objcus.put("tel2", cus.getAddress().getNumhouse());

        }

        out.print(objcus);
    }

    private void viewlistcustomer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html;charset=UTF-8");

        acceso = "listcustomer";
        msg = "Lista de Clientes";

        request.setAttribute("page", ruta + acceso);
        request.setAttribute("mensaje", msg);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    private void searchCustomers(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        CustomerDao customerdao = new CustomerDao();

        String nombre = (request.getParameter("cname") != null ? request.getParameter("cname").trim() : "");

        List<Customer> listcus = customerdao.ListByKey(nombre);
        Iterator<Customer> itercus = listcus.iterator();
        Customer listac = null;

        JSONArray array = new JSONArray();

        if (listcus.size() > 0) {
            while (itercus.hasNext()) {
                listac = itercus.next();

                String be = "<a title='Editar Cliente' class='btn btn-warning btn-sm'  id='" + listac.getPersona().getId() + "'  href='javascript:editcus(" + listac.getPersona().getId() + ")'><i class='far fa-edit fa-2x'></i></a>";
                JSONObject data = new JSONObject();

                //data.put("idper", listac.getPersona().getId());
                data.put("doc", listac.getPersona().getNumdoc());
                data.put("name", listac.getPersona().getName() + " " + listac.getPersona().getFirstname());

                data.put("line1", listac.getLinecredito());
                data.put("line2", listac.getLineacumulada());

                data.put("dir", listac.getAddress().getAdress());
                data.put("email", listac.getAddress().getEmail());
                data.put("tel1", listac.getAddress().getNumphone());
                data.put("accion", be);

                array.add(data);

            }
        }
        JSONObject root = new JSONObject();
        root.put("datos", array);

        out.print(root);
    }
}
