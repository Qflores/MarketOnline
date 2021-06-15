package Controllers;

import Dao.ColorDao;
import Dao.ContactDao;
import Dao.CreditDetailsDao;
import Dao.CreditsDao;
import Dao.CustomerDao;
import Dao.NumfactDao;
import Dao.OrderDetailsDao;
import Dao.PersonDao;
import Dao.ProductDao;
import Dao.ProductPriceDao;
import Entity.Color;
import Entity.Contact;
import Entity.CreditDetails;
import Entity.Credits;
import Entity.Customer;
import Entity.Fecha;
import Entity.OrderDetails;
import Entity.Person;
import Entity.Product;
import Entity.ProductPrice;
import Entity.Size;
import Utils.GenerateNumFact;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class main {

    public static void main(String[] args) {
       
        
        
        
        /* GenerateNumFact nFact = new GenerateNumFact();       
       String rs  = nFact.lastID("b");
       
        if (rs != null) {            
            System.out.println("Numero de Factura es:"+rs);
        }else{
            System.out.println("no hay datos");
        }
        
         String rss  = nFact.lastID("f");       
        if (rs != null) {            
            System.out.println("Numero de Factura es:"+rss);
        }else{
            System.out.println("no hay datos");
        }*/
 /*double precio = 653.594632;
        BigDecimal bd = new BigDecimal(precio);
        bd = bd.setScale(1, RoundingMode.HALF_UP);
        System.out.println("precio a pagar es: "+bd);
         */
 /*
        ProductDao productDao = new ProductDao();
        String codigo = "0";
        int limite = 30;
        JSONArray array = new JSONArray();
        System.out.println("codigo:" + codigo);

        for (int i = 0; i < 0; i++) {
            codigo =codigo+"0";

            try {

                if (codigo != null) {

                    List<Product> listProduct = productDao.listAll(codigo, 0, limite);

                    System.out.println("rs: " + listProduct);
                    if (listProduct != null) {

                        Iterator<Product> iterpro = listProduct.iterator();
                        Product listprod = null;

                        if (listProduct.size() > 0) {
                            while (iterpro.hasNext()) {

                                listprod = iterpro.next();
                                
                                System.out.println("SkupP: "+listprod.getSku());
                                System.out.println("NameP: "+listprod.getName());
                                System.out.println("---");
                                
                            }
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Error sms: " + e.getMessage());
                System.out.println("Error code: " + e.getCause());
                System.out.println("error: " + e.getLocalizedMessage());
            }
            System.out.println("Vuelta: " +i);
            System.out.println("codigo: "+ codigo);
        }
         */
 /* String fecha = Fecha.getFecha();
        
        System.out.println("fecha es : "+fecha);*/
 /* ColorDao colordao = new ColorDao();
        List<Color> listCl = colordao.ListByPag("", 0, 30);
        Iterator<Color> iterColor = listCl.iterator();
        Color newColor = null;

        if (listCl.size() > 0) {

            while (iterColor.hasNext()) {
                newColor = iterColor.next();
                
                System.out.println("id: "+newColor.getId()+ " Nombre: " +newColor.getName());
            }
        
        }*/
 /* //String docp = request.getParameter("doc").trim();     
        
        CustomerDao customerd = new CustomerDao();
        Customer customer = new Customer();

        PersonDao persond = new PersonDao();
        Person person = new Person();
        
        String docp = "12345678";//"20100190797";
                
        person = persond.SearchBydoc(docp);
        
        
        int id = 0;
        String nombre="";
        String sms = "";
        
        
        if (person != null ) {
            
            customer = customerd.ListByAtrib(person.getId());
            
            if (customer != null) {
                
                sms = "El cliente ya existe";
                nombre = person.getName();
                id = -1;
            }else{
            
                sms = "Ya exisite Un usuario, desea crear un cliente con usuario existente? Click aqui para crear.";
                id = person.getId();
                nombre = person.getName();
            }
        }
        
        
        if (id > 0) {
            System.out.println("registre el cliente nombre: " + nombre);
            System.out.println("IDperson: "+ id);
            System.out.println("mensaje: " + sms);
        }else if(id == -1){
        
            System.out.println("nombre: " + nombre);
            System.out.println("IDperson: "+ id);
             System.out.println("mensaje: " + sms);
            
        }else if(id == 0){
            System.out.println("no hay coincidencia de cliente"); 
             System.out.println("mensaje: " + sms);
        }*/
 /* System.out.println("");
        
       
        
       /* CustomerDao  cusd = new CustomerDao();
        
       Customer customer = cusd.ListByAtrib(2);
        
        if (customer != null) {
            System.out.println("Resultado :"+ customer.getPerson_id());
        }else{
        System.out.println("Resultado : no hay datos");
        }
        /*
       /* String fechav = "2019-03-17 12:10:00";
        String fechan = Fecha.getFecha();
        
        if (Fecha.compareFecha(fechan, fechav)) {
            System.out.println("true");
        }else{
            System.out.println("false;");
        }*/
        //------------query---procedure---product--
        /*ProductDao listprocedure = new ProductDao();

        List<Product> listpro = listprocedure.listAll("a", 0, 20);
        Iterator<Product> iterpro = listpro.iterator();

        Product pro = null;

        if (listpro.size() > 0) {

            while (iterpro.hasNext()) {
                pro = iterpro.next();

                System.out.print(" Sku: " + pro.getSku());
                System.out.print(" Nombre: " + pro.getName());
                System.out.print(" Descripcion: " + pro.getDescription());
                System.out.print(" estado: " + pro.getState());
                System.out.print(" Peso: " + pro.getPeso());
                System.out.print(" CantStock"+ pro.getStock().getQuantity());
                System.out.print(" Color:" + pro.getColor().getName());
                System.out.print(" Size: " + pro.getSize().getSimbolo());
                System.out.print(" Categoria: " + pro.getCategory().getName());
                System.out.print(" Precio: " + pro.getPrice().getPrice());
                System.out.print(" Precio Promo: " + pro.getPrice().getPricepromo());
                System.out.print(" Cantidad Prom: " + pro.getPrice().getCantidadpromo());
                System.out.print(" Fecha: " + pro.getPrice().getFexpiration());

                System.out.println("");
            }
            System.out.println("Cantidad de producto: "+listpro.size());
        } else {
            System.out.println("no hay productos");
        }*/
        //-----------------store procedure ---detalle producto------------        
        /*ProductDao listprocedure = new ProductDao();

        Product  pro = listprocedure.ListByAtrib("7750670313537");        
       
        if (pro != null) {
            
                System.out.print(" Sku: " + pro.getSku());
                System.out.print(" Nombre: " + pro.getName());
                System.out.print(" Descripcion: " + pro.getDescription());
                System.out.print(" estado: " + pro.getState());
                System.out.print(" Peso: " + pro.getPeso());
                System.out.print(" CantStock"+ pro.getStock().getQuantity());
                System.out.print(" Color:" + pro.getColor().getName());
                System.out.print(" Size: " + pro.getSize().getSimbolo());
                System.out.print(" Categoria: " + pro.getCategory().getName());
                System.out.print(" Precio: " + pro.getPrice().getPrice());
                System.out.print(" Ruta Imagen: "+ pro.getPicture().getPath());
                System.out.print(" Nombre Imagen: " +pro.getPicture().getAlt());
                System.out.print(" Precio Promo: " + pro.getPrice().getPricepromo());
                System.out.print(" Cantidad Prom: " + pro.getPrice().getCantidadpromo());
                System.out.print(" Fecha: " + pro.getPrice().getFexpiration());

                System.out.println("");
            }
        else {
            System.out.println("no hay productos");
        }
         */
 /*
         String text = "Thís is ñáño example é";
         byte[] byteText = text.getBytes(Charset.forName("UTF-8"));
         try {
         //To get original string from byte.
         String originalString= new String(byteText , "UTF-8");
            
         System.out.println("el mtesto es: "+ byteText);
            
         } catch (UnsupportedEncodingException ex) {
         Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
         }    
         // convertir letras español  
         String myString = "Ñaño tílde Aáéúí";
         byte ptext[]  = myString.getBytes(Charset.forName("UTF-8")); 
         String value = new String(ptext, UTF_8); 
         System.out.println("segunda prueba1"+ptext);
         System.out.println("segunda prueba"+value);
         */
 /* //creamos nuevo objeto de ColorDao para mostar en el combo
         ColorDao colord = new ColorDao();
         //creamos nuevo objeto productSizedao para mostarr en el combo tamaño
         SizeDao sizeD = new SizeDao();

         ProductPriceDao PriceDao = new ProductPriceDao();
            
         String cantidad = ""; //aqui alamacenamos el stock de cada producto            
         String stado = "";//personalizamos el estado del producto

         int i = 1;
         ProductDao ProductD = new ProductDao();
         List<Product> listapro = ProductD.ListByPag("", 0,20);//pasando parametros al dao producto
         Iterator<Product> iterPro = listapro.iterator();
         Product pro = null;

         String productosesistentes = Integer.toString(listapro.size());

         if (listapro.size() > 0) {//si el ArrayList no es isEmpty() 'vacio'  listamos los productos
            
         while (iterPro.hasNext()) {//miestras existe un prodcuto, leermos los registros
         // Product pro = new Product();
            
         pro = iterPro.next();
         //creamos objecto de stock
         StockProductDao stock = new StockProductDao();
         //buscando stock pasando sku de producto*
         StockProduct stockpro = new StockProduct();
         stockpro = stock.ListByAtrib(pro.getSku());
            
         if (stockpro != null) { //si existe estock  mostramos la cantidad
            
         if (stockpro.getQuantity() > pro.getStockmin()) {//si la cantidad minima del estock es menos, perzonalizamos la etiqueta
         cantidad =  stockpro.getQuantity().toString();
         } else {
         cantidad =  stockpro.getQuantity().toString();
         }
         //ingrese stock
         stockpro = null;
            
         } else {//si no hay stock, ponemos mostramos 0.00
         cantidad = "0.00";
            
         }
         //personalizando estado de los productos
         if (pro.getState().equals("a")) {
         stado = "Activo";
         } else if (pro.getState().equals("i")) {
         stado = "Inactivo";
         }
            
            
            
            
         //stockpro = null;// stockproduct
            
         //StockProduct stockp = new StockProduct();
            
         //int idp  = stockp.getId(0);
            
            
            
         System.out.print(" item: "+i);  //<th scope="row"><%=i%></th>
         System.out.print(" nombre pro:"+pro.getName()); // <td><%= pro.getName()%></td>
         System.out.print(" estado: "+ stado); //<td><%= stado%> </td>
         System.out.print(" Stock: "+cantidad);//<td><%= cantidad%></td>
            
         String color = "";
            
         Color colorP = colord.ListByAtrib(pro.getColor_id());
            
         if (colorP != null) {
            
         color = colorP.getName();
         colorP = null;
         } else {
         color = "Único";
         }
            
            
         System.out.print(" Color: "+ color);
            
            
         String tamanio = "ninguno";
            
         Size sizep = sizeD.ListByAtrib(pro.getSize_id());
            
         if (sizep != null) {
            
         String esistet = String.valueOf(pro.getSize());
         if (esistet.equals("0.0")) {
         tamanio = sizep.getSimbolo();
         } else {
         tamanio = pro.getSize() + " " + sizep.getSimbolo();
         }
         sizep = null;
            
         } else {
         tamanio = "";
         }
            
            
            
            
         System.out.print(" Tamaño: "+ tamanio);
            
         ProductPrice PriceP = PriceDao.ListByAtrib(pro.getSku());
            
         String precio = "";
            
         if (PriceP != null) {
         precio = PriceP.getPrice().toString();
            
         }
            
            
            
         System.out.print(" Precio:"+precio);
         i++;//item agrega en 1
         //reseteamos producto
         pro = null;
            
            
         System.out.println("");
         }
         System.out.println("");
            
         }else{
            
         System.out.println("datos no encontrados");
         }
            
         System.out.println("Total :" +productosesistentes);
            
            
            
         */
 /*
         Product product = new Product();
            
         ProductDao productDao = new ProductDao();
            
         product.setSku("hgjghjghjghj");
         product.setName("Tílde ñ ö]}]][S ]");
         product.setDescription("ñÑ Ú Í ÁÓÉ áéúíó");
         product.setQuantityperpackage(0.0);
         product.setRanking(0);
         product.setObservation("");
         product.setState("i");
         product.setStockmin(0.0);
         product.setStockmax(0.0);
         product.setSize(0.0);
         product.setColor_id(1);
         product.setSize_id(1);
         product.setTypeproduct_id(1);
            
         Product printp = product; //new Product();
            
         System.out.println("sku:" +printp.getSku());
         System.out.println("Nombre: "+ printp.getName());
         System.out.println("Descripción:: "+printp.getDescription());
         System.out.println("");
         */
        //ProductPrice ProductPrice = new ProductPrice();
        /*ProductPrice.setId(0);
         ProductPrice.setPrice(999.85);
         ProductPrice.setState("");
         ProductPrice.setPricepromo(0.0);
         ProductPrice.setCantidadpromo(0);
         ProductPrice.setFexpiration("");
         ProductPrice.setProducts_sku("hgjghjghjghj");*/
        //ProductPriceDao pricedao = new ProductPriceDao();
        /*if (productDao.Insert(product)) {
            
         System.out.println("se regitro el producto");
         if (pricedao.Insert(ProductPrice)) {
         System.out.println("se registro el precio");
         } else {
         System.out.println("no se registro el preico");
         }
         } else {
         System.out.println("no se registro el producto");
         }*/
 /*  if (pricedao.DeleteByKey("ghjghjjghjgjgh")) {
            
         System.out.println("se elimino el produto");
            
         }else{
         System.out.println("no se elimno el pproducto");
         }*/
 /*
 ProductPriceDao pricedao = new ProductPriceDao();
            
         if (pricedao.Insert(ProductPrice)) {
         System.out.println("se registro");
         }else{
         System.out.println("no se registro");
         }
                //System.out.println("hello world");
                 String vacio = "";
            
         if (ValidarD.getValidar(vacio) ) {
            
         System.out.println("es double");
         }else{
         System.out.println("es cadena");
         }
         */
 /*              
 ProductPriceDao prodao = new ProductPriceDao();
            
         ProductPrice ProductPrice = new ProductPrice(0,1.11, "i", 1.12, 1.13, "2019-03-11 11:52", "0742832820000");
            
         if (prodao.Insert(ProductPrice)) {
            System.out.println("se registró");
         }else{
            System.out.println("alg salio mal");
         }
 
         ProductDao producd = new ProductDao();
         Product product = new Product();
            
         product.setSku("000000000000");
         product.setName("");
         product.setDescription("");
         product.setQuantityperpackage(1111111.11);
         product.setRanking(00101);
         product.setObservation("sin boservacion");
         product.setState("i");
         product.setStockmin(0.111);
         product.setStockmax(0.222);
         product.setSize(new Size(2));
         product.setColor_id(1);
         product.setSize_id(1);
         product.setTypeproduct_id(1);
            
         if (producd.Insert(product)) {
            System.out.println("se registró!");
         }else{
         System.out.println("no se registró");
         }
         */
        //----------ProductStock----------prueba de fecha----------------
        /*String fecha1 = "2020-04-12 12:26:22";
         String fecha2 = "2020-04-12 12:26:23";
         if (Fecha.compareFecha(fecha1, fecha2)) {
         System.out.println("Es menos la fecha1");
         }else{
         System.out.println("NO es igual la fecha o revice su fecha");
         }
         String fechactual = Fecha.getFecha();
         System.out.println("Fecha: "+fechactual);*/
 /*StockProductDao stockDao = new StockProductDao();
         StockProduct stockp = new StockProduct();
         stockp.setQuantity(11.3);
         stockp.setFupdate(fechactual);
         stockp.setProducts_sku("7751271025010");
         stockp.setHumantalent_id(2);
         if (stockDao.Insert(stockp)) {
         System.out.println("Se inserto");
         }else{
         System.out.println("No se pudo insertar");
         }*/
        //-------------------------probando lista de producto-------------------------
        /* StockProductDao stock = new StockProductDao();
         //creamos nuevo objeto de ColorDao para mostar en el combo
         ColorDao colod = new ColorDao();
         //creamos nuevo objeto productSizedao para mostarr en el combo tamaño
         SizeDao sizeDao = new SizeDao();
         String cantidad = "";
         //recorriendo lista de productos
         String stado="";
         int i= 1;
         ProductDao pdao = new ProductDao();
         List<Product> lpro = pdao.ListByPag("pr000001",0 ,10);
         Iterator<Product> iter = lpro.iterator();
         Product pro = null;
         int longitud = lpro.size();
         System.out.println("tamaño: "+ longitud);
         // si no encunetra resultados muestra vacio
         if (lpro.size() > 0) {
         while(iter.hasNext()){
         pro = iter.next();
         //buscando stock pasando sku de producto
         StockProduct buscar = stock.ListByAtrib(pro.getSku());
         //System.out.println("buscar: " + buscar);
         if(buscar == null){
         System.out.println("buscar: " + buscar);
         }else{
         if (buscar.getQuantity() >= pro.getStockmin())
         {
         cantidad = buscar.getQuantity().toString();
         }
         else
         {
         cantidad =buscar.getQuantity().toString();
         }
         buscar.setId(0); buscar.setProducts_sku(""); buscar.setQuantity(0.00);
         }
         System.out.println(cantidad);
         System.out.println("aquí");
         //reseteando stockproduct
         //
         //personalizando estado
         if(pro.getState().equals("a")){stado="Activo";
         }
         else if(pro.getState().equals("i") )
         {
         stado ="Inactivo";
         }
         // mostrando colores de los productos
         System.out.println(stado);
         }
         }else{
         System.out.println("no hay producto");
         }/*
         //--------------ProductSize muestra un registro por product_sku -----7751271025010  | 7613036415248
         /*ProductSizeDao psdao = new ProductSizeDao();
         ProductSize psz = psdao.ListByAtrib("7751271025010");
         System.out.println(psz.getId()+" "+psz.getSizeId()+ " "+ psz.getProductSku());*/
        //--------------lista de productSize
        /*ProductSizeDao psdao = new ProductSizeDao();
         List<ProductSize> lista = psdao.ListByKey("7751271025010");
         Iterator<ProductSize> inter =  lista.iterator();
         ProductSize psd = null;
         int longitud = lista.size() ;
         System.out.println("longitud : " + longitud);
         while (inter.hasNext()) {
         psd = inter.next();
         System.out.println(psd.getId()+ " "+ psd.getSizeId()+" "+ psd.getProductSku());
         }*/
        //----------------Size listas por key
        /*SizeDao szdao = new SizeDao();
         Size listS = szdao.ListByAtrib(2);
         System.out.println(listS.getId()+" "+listS.getName()+" "+ listS.getSimbolo());*/
        //---------------lista de tamaños----------------
        /* SizeDao sdao = new SizeDao();
         List<Size> lista = sdao.ListByKey(0);
         Iterator<Size> inter =  lista.iterator();
         Size sizes = null;
         int longitud = lista.size() ;
         System.out.println("longitud : " + longitud);
         while (inter.hasNext()) {
         sizes = inter.next();
         System.out.println(sizes.getId()+ " "+ sizes.getName()+" "+ sizes.getSimbolo());
         }*/
        //-------------------lista de productos paginado--------------------------------------
        /*ProductDao prDao = new ProductDao();
         List<Product> lista = prDao.ListByPag("pr000001",0,10);
         Iterator<Product> inter =  lista.iterator();
         Product pro = null;
         int longitud = lista.size() ;
         System.out.println("longitud : " + longitud);
         while (inter.hasNext()) {
         pro = inter.next();
         System.out.println(pro.getSku()+ " "+ pro.getName()+" "+ pro.getDescription());
         }*/
        //-----------------lista de productoColor by sku-------------------
        /*ProductColorDao pcd = new ProductColorDao();
         List<ProductColor>lista = pcd.ListByKey("7751271025010");//7613036415248 |7613036415248
         Iterator<ProductColor>iter = lista.iterator();
         ProductColor pc= null;
         int longitud = lista.size();
         System.out.println("tamaño: "+ longitud);
         while (iter.hasNext()) {
         pc =  iter.next();
         System.out.println("id: "+pc.getId()+" idColor: "+pc.getColor_id()+" SKU: "+pc.getProducts_sku());
         }*/
        //---------------Muestra un ProductColor by id------
        /*ProductColorDao pcdi= new ProductColorDao();
         ProductColor pci = pcdi.ListByAtrib(1);
         System.out.println(pci.getId()+" "+pci.getColor_id()+" "+pci.getProducts_sku());*/
        //----------------------lista de colores----------------
        /*ColorDao color = new ColorDao();
         List<Color>lista = color.ListByKey("1");
         Iterator<Color>iter = lista.iterator();
         Color cl= null;
         int longitud = lista.size();
         while (iter.hasNext()) {
         cl =  iter.next();
         System.out.println(cl.getId() +" "+ cl.getName());
         }*/
        //----------buscando un stock por sku de producto------ /7751271025010
        /*StockProductDao stock = new StockProductDao();
         StockProduct buscar = stock.ListByAtrib("0742832821773");
         System.out.println(buscar.getQuantity());
         buscar.setQuantity(0.0);//pr000001
         StockProduct buscar1 = stock.ListByAtrib("7613036415248");
         System.out.println(buscar1.getQuantity());
         StockProduct buscar3 = stock.ListByAtrib("pr000001");
         System.out.println(buscar3.getQuantity());*/
        //-----------------------Prueba ------------------------
        /*ColorDao cd = new ColorDao();
         Color c = cd.ListByAtrib(2);
         System.out.println(c.getId() +" "+ c.getName());*/
        //============================prueba size====================
        /*SizeDao dsize = new SizeDao();              //success
         List<Size>lista = dsize.ListByKey("cualquiera");//lista todo los de tamaños
         Iterator<Size>isize = lista.iterator();
         Size osize= null;
         int lsize = lista.size();
         System.out.println(lsize);
         while (isize.hasNext()) {
         osize =  isize.next();
         System.out.println(osize.getId() +" "+ osize.getName()+" "+ osize.getSimbolo());
         }*/
        //-----size_--- by-key-     success
        /*SizeDao dsize = new SizeDao();
         Size asize = dsize.ListByAtrib(0);
         if (asize != null) {
         System.out.println(asize.getId() +" "+ asize.getName() + " "+ asize.getSimbolo());
         }else{
         System.out.println("No hay datos encontrados");
         }*/
        //--------size------inser       success
        /*Size insize = new Size();
         //agregamos al al objeto size los valores
         insize.setName("Onzas ");
         insize.setSimbolo("oz");
         SizeDao dsize = new SizeDao();
         if (dsize.Insert(insize)) {
         System.out.println("Se inserto!!");
         }else{
         System.out.println("No Se insertó");
         }*/
        //----------size---update
        /*Size usize = new Size();
         //agregamos al al objeto size los valores
         usize.setName("Onzas ");
         usize.setSimbolo("OZOZOZOZOZOZOZOZOZOZOZOZOZOZ");
         usize.setId(14);
         SizeDao dsize = new SizeDao();
         if (dsize.Update(usize)) {
         System.out.println("Se Actualizo!!");
         }else{
         System.out.println("No Se Actualizo");
         }*/
        //----------size---update
        //agregamos al al objeto size los valores
        /*SizeDao dsize = new SizeDao();
         if (dsize.DeleteByKey(0.0)) {
         System.out.println("Se Boro!!");
         }else{
         System.out.println("No Se Boroo");
         }*/
    }
}
