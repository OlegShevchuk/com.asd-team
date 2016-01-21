package rest.factory;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import rest.mapper.ProductMapper;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by Юыху on 20.01.2016.
 */
public class MapperFactory {
    private static ProductMapper productMapper;
    private static SqlSessionFactory sqlSessionFactory;
    private static SqlSession sqlSession;

    public static ProductMapper getProductMapped(){
        if (productMapper!=null){
            return productMapper;
        }
        try (Reader reader=Resources.getResourceAsReader("mybatis-config.xml")){
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = sqlSessionFactory.openSession();
            productMapper=sqlSession.getMapper(ProductMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productMapper;
    }
    public static SqlSession getSesion(){
        if (sqlSession!=null){
            return sqlSession;
        }
        sqlSession= sqlSessionFactory.openSession();
        return sqlSession;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        sqlSession.commit();
        sqlSession.close();
    }
}
