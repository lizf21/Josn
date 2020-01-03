package ctci.water.iotconfig.model;

public class MainAbility {

    private String name;
    private String identifier;
    private String categorytype;
    private boolean std;
    private String datatype;
    private String description;
    private boolean required;
    private boolean rwflag;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getCategorytype() {
        return categorytype;
    }

    public void setCategorytype(String categorytype) {
        this.categorytype = categorytype;
    }

    public boolean getStd() {
        return std;
    }

    public void setStd(boolean std) {
        this.std = std;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public boolean getRwflag() {
        return rwflag;
    }

    public void setRwflag(boolean rwflag) {
        this.rwflag = rwflag;
    }

}
