package ctci.water.iotconfig.model;

public class ChildAbility {

    private String childName;
    private String identifier;
    private String childIdentifier;
    private boolean std;
    private String childDatatype;
    private boolean required;



    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getChildIdentifier() {
        return childIdentifier;
    }

    public void setChildIdentifier(String childIdentifier) {
        this.childIdentifier = childIdentifier;
    }

    public boolean getStd() {
        return std;
    }

    public void setStd(boolean std) {
        this.std = std;
    }

    public String getChildDatatype() {
        return childDatatype;
    }

    public void setChildDatatype(String childDatatype) {
        this.childDatatype = childDatatype;
    }

    public boolean getRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }


}
