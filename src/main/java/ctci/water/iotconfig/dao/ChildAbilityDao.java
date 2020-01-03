package ctci.water.iotconfig.dao;

import ctci.water.iotconfig.model.ChildAbility;
import ctci.water.iotconfig.model.MainAbility;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ChildAbilityDao {

    String TABLE_NAME =  " child_ability ";
    String TABLE_FIELDS = " childName, identifier, childIdentifier, std, childDatatype, required ";

    @Select({"select", TABLE_FIELDS, " from", TABLE_NAME, " where identifier = #{identifier}" })
    ChildAbility[] selectChildAbilityByIdentifier(String identifier);
}
