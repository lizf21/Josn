package ctci.water.iotconfig.model;

public class ProductCategory {

    private int categoryId;
    private String categorykey;
    private String categoryname;


    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategorykey() { return categorykey; }

    public void setCategorykey(String categorykey) {
        this.categorykey = categorykey;
    }

    public String getCategoryname() { return categoryname; }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

}
