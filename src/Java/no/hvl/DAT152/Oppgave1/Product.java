package no.hvl.DAT152.Oppgave1;

import java.util.ResourceBundle;

/**
 * Class that describes a product
 */
public class Product {
    private String pNo;
    private String pName;
    private String priceInEuro;
    private String imageFile;
    private String resourceKey;
    private int amount;

    public Product(String pNo, String pName, String priceInEuro, String imageFile, String resourceKey) {
        this.pNo = pNo;
        this.pName = pName;
        this.priceInEuro = priceInEuro;
        this.imageFile = imageFile;
        this.resourceKey = resourceKey;
        this.amount = 1;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public String toString(ResourceBundle bundle) {
        return bundle.getString(this.getpName()) + " | " + bundle.getString(this.getPriceInEuro()) + " | " + bundle.getString(this.getResourceKey());
    }

    public boolean compareTo(Product product) {
        if(this.pName.equals(product.getpName())) {
            return true;
        } else {
            return false;
        }
    }
}
