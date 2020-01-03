package ctci.water.iotconfig.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class standard {

    private String name;
    private String identifier;
    private String categorytype;
    private Boolean std;
    private String datatype;
    private String description;
    private Boolean required;
    private Boolean rwflag;
    private String status;
    private String Detection;

}
