package ctci.water.iotconfig.controller;

import com.alibaba.fastjson.JSONObject;
import ctci.water.iotconfig.service.ProductCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/ProductCategory")
@Api(value = "水保项目领域管理")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;


    @ApiOperation(value = "iot页面", notes = "领域分类", httpMethod = "GET")
    @GetMapping("iot/Product")
    // @ApiImplicitParams({
    //       @ApiImplicitParam(paramType="header", name="token",required=true, value="token", dataType="String")})
    public JSONObject getUnits() {
        JSONObject res = new JSONObject();
        res.put("code", 200);
        res.put("message", "sucessfully");
        res.put("data",productCategoryService.getProductCategory());
        return res;
    }
}


