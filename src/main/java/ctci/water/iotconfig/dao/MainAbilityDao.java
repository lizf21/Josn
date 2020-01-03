package ctci.water.iotconfig.dao;

import ctci.water.iotconfig.model.MainAbility;
import ctci.water.iotconfig.model.UnitList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MainAbilityDao {

    String TABLE_NAME =  " main_ability ";
    String TABLE_FIELDS = " name, identifier, categorytype, std, datatype, description, required, rwflag ";

    @Select({"select", TABLE_FIELDS," from", TABLE_NAME, })
    MainAbility[] selectAllMainAbility();
}
