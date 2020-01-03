package ctci.water.iotconfig.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import ctci.water.iotconfig.dao.*;
import ctci.water.iotconfig.model.ChildAbility;
import ctci.water.iotconfig.model.DataSpecs;
import ctci.water.iotconfig.model.MainAbility;
import ctci.water.iotconfig.model.UnitList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class IotService {

    @Autowired
    UnitListDAO unitListDAO;
    @Autowired
    MainAbilityDao mainAbilityDao;
    @Autowired
    ChildAbilityDao childAbilityDao;
    @Autowired
    DataSpecsDao dataSpecsDao;

    public static Logger logger = LoggerFactory.getLogger(TokenService.class);

    public UnitList[] getUnitList(){
        return unitListDAO.selectAllUnit();
    }

    public MainAbility[] getMainAbility() {
        return mainAbilityDao.selectAllMainAbility();
    }

    public JSONObject getStdAbilityInfo(MainAbility[] mainAbilitys){
        JSONObject res = new JSONObject();
        ArrayList<JSONObject> childAbility = new ArrayList<>();
        ArrayList<JSONObject> mainAbility= new ArrayList<>();
        for (int j=0;j<mainAbilitys.length;j++){
            JSONObject res2 = new JSONObject();
            res2.put("Name",mainAbilitys[j].getName());
            res2.put("Description",mainAbilitys[j].getDescription());
            res2.put("Identifier",mainAbilitys[j].getIdentifier());
            res2.put("DataType",mainAbilitys[j].getDatatype());
            res2.put("CategoryType",mainAbilitys[j].getCategorytype());
            res2.put("Required",mainAbilitys[j].getRequired());
            res2.put("RwFlag",mainAbilitys[j].getRwflag());
            res2.put("Required",mainAbilitys[j].getRequired());
            if (mainAbilitys[j].getDatatype().equals("STRUCT")){
                ChildAbility[] childAbilities= childAbilityDao.selectChildAbilityByIdentifier(mainAbilitys[j].getIdentifier());
                for (int i=0;i<childAbilities.length;i++){
                    JSONObject res1 = new JSONObject();
                    res1.put("childName",childAbilities[i].getChildName());
                    res1.put("childDataType",childAbilities[i].getChildDatatype());
                    res1.put("childIdentifier",childAbilities[i].getChildIdentifier());
                    res1.put("isStd",childAbilities[i].getStd());
                    res1.put("dataSpecs",dataSpecsDao.selectDataSpecs(childAbilities[i].getChildIdentifier()));
                    childAbility.add(res1);
                }
                res2.put("DataSpecsList", childAbility);
            }else {
                res2.put("DataSpecs",dataSpecsDao.selectDataSpecs(mainAbilitys[j].getIdentifier()));
            }
            mainAbility.add(res2);
        }
        res.put("AbilityInfo",mainAbility);
        return res;
    }
}
