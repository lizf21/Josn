package ctci.water.iotconfig.service;

import com.alibaba.fastjson.JSONObject;
import ctci.water.iotconfig.dao.ProductCategoryDao;
import ctci.water.iotconfig.model.ProductCategory;
import ctci.water.iotconfig.model.UnitList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProducService {

    @Autowired
    ProductCategoryDao productCategoryDao;

    public static Logger logger = LoggerFactory.getLogger(TokenService.class);

    /**
     * 污水分类  ok
     *
     * @return
     */
    public ProductCategory[] getProductCategory() {
        return productCategoryDao.selectAllProduct();
    }

    public JSONObject getclass(ProductCategory[] productCategories) {
        JSONObject res = new JSONObject();
        ArrayList<JSONObject> product = new ArrayList<>();

        for (int i = 0; i < productCategories.length; i++) {
            JSONObject res3 = new JSONObject();
            res3.put("categoryid", productCategories[i].getCategoryId());
            res3.put("categorykey", productCategories[i].getCategorykey());
            res3.put("categoryname", productCategories[i].getCategoryname());

        }
//categorykey,categoryname
        return res;

    }
}
