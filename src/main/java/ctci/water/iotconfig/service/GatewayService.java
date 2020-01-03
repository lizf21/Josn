package ctci.water.iotconfig.service;

import ctci.water.iotconfig.dao.GatewayDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GatewayService {

    @Autowired
    private GatewayDao gatewayDao;

    /**
     * 删除
     * @param id
     * @return
     */
    public int delete(String id){
        int delete = gatewayDao.delete(id);
        return delete;

    }
}
