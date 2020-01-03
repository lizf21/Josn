package ctci.water.iotconfig.service;

import com.alibaba.fastjson.JSONObject;
import ctci.water.iotconfig.dao.ProductCategoryDao;
import ctci.water.iotconfig.model.ProductCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    public static Logger logger = LoggerFactory.getLogger(TokenService.class);

    /**
     * 列表
     * @return
     */
    public ProductCategory[] getProductCategory(){
        return productCategoryDao.selectAllProduct();
    }



}
