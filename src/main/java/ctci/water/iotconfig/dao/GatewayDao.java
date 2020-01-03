package ctci.water.iotconfig.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface GatewayDao {
    /**
     *
     * 根据数据库categroyId，进行删除
     */
    String TABLE_NAME =  "gateway_info";

    @Delete({"delete from ",TABLE_NAME,"where categroyId = #{id}"})
    int delete(String id);


    /**
     * 删除之后重新拉一下当前网关信息列表数据
     * 在调用一次接口
     */
}
