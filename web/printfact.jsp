<%@page import="java.util.Map"%>
<%@page import="Config.Conexion"%>
<%@page import="net.sf.jasperreports.engine.JasperRunManager" %>
<%@page import="java.util.HashMap" %>%
<%@page import="java.io.File"%>
<%@page import="java.sql.Connection"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <div class="row">
            <div class="col-lg-6">
                <div class="card" style="color: #ffff; font-weight: bold;">


                    <%
                        
                        String fact = "";
                        fact = ((String) request.getParameter("n"));

                        if (fact != "") {
                            Conexion con = Conexion.knowConexion();
                            File reportef = new File(application.getRealPath("assets/reportes/repfact.jasper"));
                            Map parameters = new HashMap();
                            parameters.put("codfact", fact);

                            byte[] bytes = JasperRunManager.runReportToPdf(reportef.getPath(), parameters, con.getCon());

                            response.setContentType("application/pdf");
                            response.setContentLength(bytes.length);
                            
                            ServletOutputStream output = response.getOutputStream();
                            response.getOutputStream();
                            output.write(bytes, 0, bytes.length);
                            output.flush();
                            output.close();

                        } else {
                            out.print("No hay Documentos: " + fact);
                        }

                    %>

                </div>
            </div>
        </div>

    </body>
</html>
