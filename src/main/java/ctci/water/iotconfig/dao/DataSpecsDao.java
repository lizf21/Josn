package ctci.water.iotconfig.dao;

import ctci.water.iotconfig.model.DataSpecs;
import ctci.water.iotconfig.model.UnitList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DataSpecsDao {

    String TABLE_NAME =  " data_specs ";
    String TABLE_FIELDS = " specsId, specsIdentifier, datatype, dscCreate, dscModified, max, min, unit, unitname ";

    @Select({"select", TABLE_FIELDS," from", TABLE_NAME," where specsIdentifier = #{specsIdentifier} "  })
    DataSpecs selectDataSpecs(String specsIdentifier);
}
