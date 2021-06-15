
package Controllers;

import Dao.HeaderPurchaseOrderDao;
import Dao.OrderDetailsDao;
import Entity.Fecha;
import Entity.HeaderPurchaseOrder;
import Entity.OrderDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Chome extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");

        String page = request.getParameter("accion");

        if (page.equals("lpxm")) {//muestra el formulario para registrar cliente
            this.listprodventa(request, response);
        } else if (page.equals("lpxc")) {// inserta en las tablas: contact; person y Customer
            this.listprodtotal(request, response);
        } else if (page.equals("tv")) {//inserta en tabla customer
            this.totalventas(request, response);
        } else if (page.equals("gb")) {
            this.grafBarras(request, response);
        }
        
    }
    
    //ventas por meses para grafico de barras
    private void grafBarras(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        String x = (String) Fecha.OnlyFecha().substring(0, 5);

        JSONArray r = new JSONArray();
        String sms = "";

        for (int i = 1; i <= 12; i++) {
            
            String mes = "";
            
            if (i < 10) {
                mes = x + "0" + i + "-";
            } else {
                mes = x + i + "-";
            }
            
            OrderDetailsDao c = new OrderDetailsDao();
            OrderDetails o = c.ListTotalProduct(mes);

            JSONObject j = new JSONObject();

            if (o != null) {               
                
                
                j.put("cant", o.getQuantity());
                j.put("total", o.getTotalPagar());

                r.add(j);

            } else {
                
                j.put("cant", "0");
                j.put("total", "0.00");
            }
        }
        JSONObject data = new JSONObject();  
        
        data.put("data", r);
        data.put("sms", sms);

        out.print(data);

    }

    // lista de productos mas vendidos
    private void listprodventa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String x = Fecha.OnlyFecha();

        String a = (request.getParameter("a").trim() != "" ? request.getParameter("a").trim() : x + " 00:00:00");
        String b = (request.getParameter("b").trim() != "" ? request.getParameter("b").trim() : x + " 23:59:59");

        OrderDetailsDao c = new OrderDetailsDao();

        List<OrderDetails> o = c.ListTotalProduct(a, b);

        

        OrderDetails l = null;

        JSONArray r = new JSONArray();

        String sms = "";

        int n = 1;

        if (o != null) {
            Iterator<OrderDetails> i = o.iterator();
            while (i.hasNext()) {
                l = i.next();

                JSONObject j = new JSONObject();
                j.put("i", n);
                j.put("name", l.getProductname().toUpperCase());
                j.put("peso", l.getSimbolo());
                j.put("cant", l.getQuantity());
                j.put("total", l.getTotalPagar());

                r.add(j);
                n++;
            }

            sms = "ok";

        } else {
            sms = "err";
        }
        JSONObject data = new JSONObject();

        data.put("data", r);
        data.put("sms", sms);

        out.print(data);

    }

    //total de ventas por mes
    private void listprodtotal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String z = (request.getParameter("m").trim() != "" ? request.getParameter("m").trim() : "");

        String x = "";
        if (z.equals("m")) {
            x = (String) Fecha.OnlyFecha().substring(0, 8);
        } else {
            x = (String) Fecha.OnlyFecha().substring(0, 10);

        }

        OrderDetailsDao c = new OrderDetailsDao();

        OrderDetails o = c.ListTotalProduct(x);

        JSONObject j = new JSONObject();

        if (o != null) {
            j.put("cant", o.getQuantity());
            j.put("total", o.getTotalPagar());

        } else {
            j.put("cant", 0);
            j.put("total", 0.0);
        }

        out.print(j);
    }

    //total de ventas
    private void totalventas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        HeaderPurchaseOrderDao c = new HeaderPurchaseOrderDao();

        String a = (request.getParameter("a").trim() != "" ? request.getParameter("a").trim() : "");
        String b = (request.getParameter("b").trim() != "" ? request.getParameter("b").trim() : "");

        String i = a + " 00:00:00";
        String f = b + " 23:59:59";

        JSONObject data = new JSONObject();

        if (Fecha.compareFecha(i, f) && a != "" && b != "") {

            HeaderPurchaseOrder o = c.totalventas(i, f);
            if (o != null) {
                data.put("data", o.getTotalamount());
            } else {
                data.put("data", "no hay datos encontrados");
            }
            

        } else{
            data.put("data", "Fecha incorrecto");
        }

        out.print(data);
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

}
