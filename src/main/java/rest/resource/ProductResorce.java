package rest.resource;

import org.apache.log4j.Logger;
import rest.entity.Product;
import rest.service.ProductService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;

/**
 * Created by Юыху on 19.01.2016.
 */
@Path("/product")
public class ProductResorce {
    private Logger logger=Logger.getLogger("ProductResorce");

    private ProductService productService;

    public ProductResorce(ProductService productService) {
        this.productService = productService;
    }

    public ProductResorce() {
        productService= new ProductService();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public Response getProduct(@PathParam("id") int id) {
        return Response.ok(productService.select(id)).build() ;
    }




    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/create")
    public Response creat(
            @QueryParam("ownerid") int ownerId,
            @QueryParam("name") String name,
            @QueryParam("description") String description,
            @QueryParam("value") double value,
            @QueryParam("createdDate") String date
    ){


        return  Response.ok(productService.creat(ownerId,name, description, value, date)).build();

    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/update")
    public Response update(
            @QueryParam("id") int id,
            @QueryParam("ownerid") int ownerId,
            @QueryParam("name") String name,
            @QueryParam("description") String description,
            @QueryParam("value") double value,
            @QueryParam("createdDate") String date
    ){
        return Response.ok(productService.update(id,ownerId,name,description,value,date)).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/del")
    public Response del(@QueryParam("id") int id){
        return Response.ok(productService.del(id)).build();

    }

}
