package ctci.water.iotconfig.model;

public class DataSpecs {

    private String specsId;
    private String specsIdentifier;
    private String datatype;
    private long dscCreate;
    private long dscModified;
    private float max;
    private float min;
    private String unit;
    private String unitname;


    public String getSpecsId() {
        return specsId;
    }

    public void setName(String name) {
        this.specsId = specsId;
    }

    public String getSpecsIdentifier() {
        return specsIdentifier;
    }

    public void setSpecsIdentifier(String specsIdentifier) {
        this.specsIdentifier = specsIdentifier;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public long getDscCreate() {
        return dscCreate;
    }

    public void setDscCreate(long dscCreate) {
        this.dscCreate = dscCreate;
    }

    public long getDscModified() {
        return dscModified;
    }

    public void setDscModified(long dscModified) {
        this.dscModified = dscModified;
    }

    public float getStd() {
        return max;
    }

    public void setStd(float max) { this.max = max; }

    public float getMin() {
        return min;
    }

    public void setMin(float min) {
        this.min = min;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

}
