package ctci.water.iotconfig.dao;

import ctci.water.iotconfig.model.LoginToken;
import ctci.water.iotconfig.model.UnitList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UnitListDAO {

    String TABLE_NAME =  " unit_data ";
    String TABLE_FIELDS = " unitsymbol, unitname ";

    @Select({"select", TABLE_FIELDS," from", TABLE_NAME, })
    UnitList[] selectAllUnit();
}
