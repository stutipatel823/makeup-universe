package Persistence;

import Helper.ANSI;
import Helper.Product;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author stutipatel
 */
public class Product_REST {
   String url = "jdbc:mysql://localhost:3306/search_lbs";
   String sqlUsername = "root";
   String sqlPassword = "student";
   Connection con=null;
   
   public Product_REST() throws Exception {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(url, sqlUsername, sqlPassword);
        System.out.println(ANSI.yellow+"Connected to database "+ANSI.reset);
    }
   
    public ArrayList<Product> getAllProducts() throws SQLException{
       System.out.println(ANSI.green+"getAllProducts() is invoked... "+ANSI.reset);
       ArrayList<Product> productList = new ArrayList<>();
       Statement st = con.createStatement();
       String query = "select * from products";
       ResultSet rs = st.executeQuery(query);
       
       while(rs.next()){
           int productID = rs.getInt("product_id");
           String productName = rs.getString("product_name");
           String currency = rs.getString("currency");
           float price = rs.getFloat("price");
           String brand = rs.getString("brand");
           String category = rs.getString("category");
           int stock = rs.getInt("stock");
           boolean availability = rs.getBoolean("availability");
           Product p = new Product(productID, productName, currency, price, brand, category, stock, availability);
           productList.add(p);
       }
       return productList;
    }
    
    public ArrayList<Product> getProducts(String product_name) throws SQLException {
        System.out.println(ANSI.green+"getProducts(" + product_name + ") is invoked... "+ANSI.reset);
        ArrayList<Product> productList = new ArrayList<>();

        String query = "SELECT * FROM Products where product_name=?";
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1, product_name);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            int productID = rs.getInt("product_id");
            String productName = rs.getString("product_name");
            String currency = rs.getString("currency");
            float price = rs.getFloat("price");
            String brand = rs.getString("brand");
            String category = rs.getString("category");
            int stock = rs.getInt("stock");
            boolean availability = rs.getBoolean("availability");

            Product p = new Product(productID, productName, currency, price, brand, category, stock, availability);
            productList.add(p);
        }

        return productList;
    }
    
    public void createProduct(Product p) {
        System.out.println(ANSI.green+"createProduct() is invoked... "+ANSI.reset);
        String query = "INSERT INTO Products (product_id, product_name, currency, price, brand, category, stock) VALUES(?,?,?,?,?,?,?)";
        /*specify what will be inputed because the user will not be inputting the availability 
        because availability will depend on the #ofStock.->availability BOOLEAN GENERATED ALWAYS AS (stock > 0) STORED*/                                                                       
        try (PreparedStatement st = con.prepareStatement(query)) {
            st.setInt(1, p.getProductID());
            st.setString(2, p.getProductName());
            st.setString(3, p.getCurrency());
            st.setFloat(4, p.getPrice());
            st.setString(5, p.getBrand());
            st.setString(6, p.getCategory());
            st.setInt(7, p.getStock());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void deleteProduct(int id) throws SQLException {
        System.out.println(ANSI.cyan+"deleteProduct() is invoked..."+ANSI.reset);
        String query = "DELETE FROM Products WHERE product_id=?";
        try (PreparedStatement st = con.prepareStatement(query)) {
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleting product: " + e.getMessage());
            throw e;
        }
    }
    
    public void updateProductID(int id, Product p) throws SQLException{
        System.out.println(ANSI.cyan+"updateProduct() is invoked..."+ANSI.reset);
        String query = "UPDATE Products SET product_id=? where product_id=?";
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, p.getProductID());
        st.setInt(2, id); 
        st.executeUpdate();
    }

    public void updateProductINFO(Product p) throws SQLException{
        System.out.println(ANSI.cyan+"updateProduct() is invoked..."+ANSI.reset);
        String query = "UPDATE Products SET product_name=?, currency=?, price=?, brand=?, category=?, stock=? where product_id=?";
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1, p.getProductName());
        st.setString(2, p.getCurrency());
        st.setFloat(3, p.getPrice());
        st.setString(4, p.getBrand());
        st.setString(5, p.getCategory());
        st.setInt(6, p.getStock());
        st.setInt(7, p.getProductID()); 
        st.executeUpdate();
    }   
}