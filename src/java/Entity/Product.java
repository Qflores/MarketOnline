package Entity;

public class Product {

    private String sku = "";
    private String name = "";
    private String description = "";
    private double quantityperpackage = 0.0;
    private int ranking = 0;
    private String observation = "";
    private String state = "";
    private double stockmin = 0.0;
    private double stockmax = 0.0;
    private double peso = 0.0;
    private int color_id = 0;
    private int size_id = 0;
    private int typeproduct_id = 0;

    //solo para colsutas
    private Color color;
    private Size size;
    private TypeProduct category;
    private StockProduct stock;
    private Picture picture;
    private ProductPrice price;
    
    public Product() {
    }
    
    public Product(String sku) {
        this.sku = sku;
    }
   
    public Product(ProductPrice price){
        this.price = price;
    }
    public Product(String sku,String name, Double peso){
        this.sku = sku;
        this.name = name;
        this.peso = peso;
    }
    
    public Product(String name, String description){
        this.name = name;
        this.description = description;
    }
    
    // insertar actualizar tabla producto
    public Product(String sku, String name, String description, double quantityperpackage, int ranking, String observation, String state, double stockmin, double stockmax, double peso, int color_id, int size_id, int typeproduct_id) {
        this.sku = sku;
        this.name = name;
        this.description = description;
        this.quantityperpackage = quantityperpackage;
        this.ranking = ranking;
        this.observation = observation;
        this.state = state;
        this.stockmin = stockmin;
        this.stockmax = stockmax;
        this.peso = peso;
        this.color_id = color_id;
        this.size_id = size_id;
        this.typeproduct_id = typeproduct_id;

    }
    //------lista de productos----- consulta ocn store procedure
    public Product(String sku, String name, String estado, double peso, Color color, Size size, StockProduct stock, ProductPrice price) {
        this.sku = sku;
        this.name = name;
        this.state = estado;
        this.color = color;
        this.peso = peso;
        this.size = size;
        this.stock = stock;
        this.price = price;
    }
    
    // -----ver detalle producto ---
        public Product(String sku, String name, String estado, double peso, Color color, Size size, StockProduct stock, ProductPrice price, Picture picture) {
        this.sku = sku;
        this.name = name;
        this.state = estado;
        this.color = color;
        this.peso = peso;
        this.size = size;
        this.stock = stock;
        this.price = price;
        this.picture = picture;
    }
    
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getQuantityperpackage() {
        return quantityperpackage;
    }

    public void setQuantityperpackage(double quantityperpackage) {
        this.quantityperpackage = quantityperpackage;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getStockmin() {
        return stockmin;
    }

    public void setStockmin(double stockmin) {
        this.stockmin = stockmin;
    }

    public double getStockmax() {
        return stockmax;
    }

    public void setStockmax(double stockmax) {
        this.stockmax = stockmax;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getColor_id() {
        return color_id;
    }

    public void setColor_id(int color_id) {
        this.color_id = color_id;
    }

    public int getSize_id() {
        return size_id;
    }

    public void setSize_id(int size_id) {
        this.size_id = size_id;
    }

    public int getTypeproduct_id() {
        return typeproduct_id;
    }

    public void setTypeproduct_id(int typeproduct_id) {
        this.typeproduct_id = typeproduct_id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public TypeProduct getCategory() {
        return category;
    }

    public void setCategory(TypeProduct category) {
        this.category = category;
    }

    public StockProduct getStock() {
        return stock;
    }

    public void setStock(StockProduct stock) {
        this.stock = stock;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public ProductPrice getPrice() {
        return price;
    }

    public void setPrice(ProductPrice price) {
        this.price = price;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

}
