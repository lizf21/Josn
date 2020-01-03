package ctci.water.iotconfig.dao;

import ctci.water.iotconfig.model.ProductCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 *污水分类DAO
 */
@Repository
@Mapper
public interface ProductCategoryDao {

    String TABLE_NAME = "product_category";
    String TABLE_FIELDS = "categoryid,categorykey,categoryname";

    @Select({"select", TABLE_FIELDS, "from", TABLE_NAME,})
    ProductCategory[] selectAllProduct();

}