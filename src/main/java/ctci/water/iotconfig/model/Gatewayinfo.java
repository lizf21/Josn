package ctci.water.iotconfig.model;

import lombok.Data;
import lombok.ToString;

/**
 * 网关
 */
@Data
@ToString
public class Gatewayinfo {
        private String productName;
        private String categroyid;
        private Integer nodetype;
        private String netType;
        private String authType;
        private String productKey;
        private String Productret;
}
