package ctci.water.iotconfig.controller;

import com.alibaba.fastjson.JSONObject;
import ctci.water.iotconfig.model.UnitList;
import ctci.water.iotconfig.service.IotService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api/ctciwater")
@Api(value="水保项目api-iot管理")
public class IotConfigController {
    @Autowired
    IotService iotService;

    @ApiOperation(value="iot页面", notes="查询单位" ,httpMethod="GET")
    @GetMapping("iot/listunit")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="header", name="token",required=true, value="token", dataType="String")})
    public JSONObject getUnits(){
        JSONObject res = new JSONObject();
        res.put("code",200);
        res.put("message","sucessfully");
        res.put("data",iotService.getUnitList());
        return res;
    }
    @ApiOperation(value="iot页面", notes="查询标准功能列表" ,httpMethod="GET")
    @GetMapping("iot/listStdAbility")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="header", name="token",required=true, value="token", dataType="String")})
    public JSONObject getStdAbilityInfo(){
        JSONObject res = new JSONObject();
        res.put("code",200);
        res.put("message","sucessfully");
        res.put("data",iotService.getStdAbilityInfo(iotService.getMainAbility()));
        return res;
    }

}
