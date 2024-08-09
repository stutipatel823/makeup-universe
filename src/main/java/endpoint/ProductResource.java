package endpoint;

import Helper.*;
import Persistence.*;
import Business.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * author stutipatel
 */

@Path("products")
public class ProductResource {

    Product_REST rest = new Product_REST();

    public ProductResource() throws Exception {        
       
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public ArrayList<Product> getAllProducts() throws Exception{
        System.out.println(ANSI.blue+"getAllProducts() was invoked..."+ANSI.reset);
        return rest.getAllProducts();
    }
    
    @Path("{name}")
    @GET
    public ArrayList<Product> getProducts(@PathParam("name") String product_name) throws SQLException {
        System.out.println(ANSI.blue + "getProducts() was invoked..." + ANSI.reset);
        return rest.getProducts(product_name);
    }
    @Path("add")
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public void createProduct(Product p){
        System.out.println(ANSI.blue + "createProduct() was invoked..." + ANSI.reset);
        rest.createProduct(p);
    }
    
    @Path("delete/{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_XML)
    public void deleteProduct(@PathParam("id")int id) throws SQLException{
        System.out.println(ANSI.blue + "deleteProduct() was invoked..." + ANSI.reset);
        rest.deleteProduct(id);
    }
    @Path("update/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void updateProduct(@PathParam("id")int id, Product p)throws SQLException{
        System.out.println(ANSI.blue + "updateProduct() was invoked..." + ANSI.reset);
        rest.updateProductID(id,p);
    }
    
    @Path("update")
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void updateProductINFO(Product p)throws SQLException{
        System.out.println(ANSI.blue + "updateProductINFO() was invoked..." + ANSI.reset);
        rest.updateProductINFO(p);
    }
}
