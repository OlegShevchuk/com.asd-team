package rest.mapper;

import org.apache.ibatis.annotations.*;

import rest.entity.Product;

import java.util.Date;

/**
 * Created by Юыху on 20.01.2016.
 */
public interface ProductMapper {

    @Insert("INSERT INTO product (id,ownerId,name,description,value,createdDate) VALUE(NULL,#{ownerId},#{name},#{description},#{value},#{createdDate}) ")
     int creat(Product entity);

    @Select("SELECT LAST_INSERT_ID()")
    int getLastId();

    @Select("SELECT * FROM product WHERE id = #{id}")
    Product select(int id);


    @Update("UPDATE product SET ownerId=#{ownerId},name=#{name},description=#{description},value=#{value},createdDate=#{createdDate} WHERE id=#{id}")
    void update(Product entity);


    @Delete("DELETE FROM product WHERE id=#{id}")
    void del(int id);
}
