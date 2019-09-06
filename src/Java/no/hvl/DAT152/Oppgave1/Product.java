package no.hvl.DAT152.Oppgave1;


/**
 * Class that describes a product
 */
public class Product {
    private String pNo;
    private String pName;
    private String priceInEuro;
    private String imageFile;
    private String resourceKey;



    public Product(String pNo, String pName, String priceInEuro, String imageFile, String resourceKey) {
        this.pNo = pNo;
        this.pName = pName;
        this.priceInEuro = priceInEuro;
        this.imageFile = imageFile;
        this.resourceKey = resourceKey;
    }

    public String getpNo() {
        return pNo;
    }

    public void setpNo(String pNo) {
        this.pNo = pNo;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getPriceInEuro() {
        return priceInEuro;
    }

    public void setPriceInEuro(String priceInEuro) {
        this.priceInEuro = priceInEuro;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

    public String getResourceKey() {
        return resourceKey;
    }

    public void setResourceKey(String resourceKey) {
        this.resourceKey = resourceKey;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pNo='" + pNo + '\'' +
                ", pName='" + pName + '\'' +
                ", priceInEuro='" + priceInEuro + '\'' +
                ", imageFile='" + imageFile + '\'' +
                ", resourceKey='" + resourceKey + '\'' +
                '}';
    }
}
