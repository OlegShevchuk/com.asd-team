package rest.service;

import org.apache.log4j.Logger;
import rest.entity.Product;
import rest.factory.MapperFactory;
import rest.mapper.ProductMapper;

import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Олег on 19.01.2016.
 */
public class ProductService {
    private ProductMapper productMapper;
    private Logger logger=Logger.getLogger("ProductService");

    public ProductService() {

        productMapper= MapperFactory.getProductMapped();
    }

    public Product select(int id){
       return productMapper.select(id);
    }


    public Product creat(int ownerId, String name, String description, double value, String date){

        try{
            productMapper.creat(new Product(ownerId, name, description, value, parseDate(date)));
            MapperFactory.getSesion().commit();
            return select(productMapper.getLastId());
        }
        catch (Exception e){
            MapperFactory.getSesion().rollback();
            logger.error(e);
        }
        return null;
    }

    public Product update(int id,int ownerId,String name,String description,double value,String date){

        Product oldProduct=select(id);
        oldProduct.setOwnerId(ownerId).
                setName(name).
                setDescription(description).
                setValue(value).
                setCreatedDate(parseDate(date));
        try {
            productMapper.update(oldProduct);
            MapperFactory.getSesion().commit();}
        catch (Exception e){
            MapperFactory.getSesion().rollback();
            logger.error(e);
        }
        return select(id);

    }

    public Product del(int id){
        Product oldProduct=select(id);
        if (oldProduct!=null){
            try{
                productMapper.del(id);
                MapperFactory.getSesion().commit();

            }catch(Exception e){
                MapperFactory.getSesion().rollback();
                logger.error(e);
                return null;
            }

        }
        return oldProduct;
    }

    private Date parseDate(String date){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date newDate;
        try {
            newDate=simpleDateFormat.parse(date);
        } catch (ParseException e) {
            logger.error("Неверный формат даты", e);
            newDate=null;
        }
        return newDate;
    }
}
