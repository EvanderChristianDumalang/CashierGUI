package sample;
public class DrinkList {


    String nameDrink;
    String numberDrink;
    String pathPictureDrink;
    String priceDrink;
    int quantityDrink;

    public int getQuantityDrink() {
        return quantityDrink;
    }

    public int setQuantityDrink(int quantityDrink) {
        this.quantityDrink = quantityDrink;
        return quantityDrink;
    }

    public DrinkList(String numberDrink, String nameDrink, String pathPictureDrink, String priceDrink, int quantityDrink)
    {
        this.numberDrink = numberDrink;
        this.nameDrink = nameDrink;
        this.pathPictureDrink = pathPictureDrink;
        this.priceDrink = priceDrink;
        this.quantityDrink = quantityDrink;
    }

    public DrinkList() {

    }


    public String getNameDrink() {
        return nameDrink;
    }

    public void setNameDrink(String nameDrink) {
        this.nameDrink = nameDrink;
    }

    public String getNumberDrink() {
        return numberDrink;
    }

    public void setNumberDrink(String numberDrink) {
        this.numberDrink = numberDrink;
    }

    public String getPathPictureDrink() {
        return pathPictureDrink;
    }

    public void setPathPictureDrink(String pathPictureDrink) {
        this.pathPictureDrink = pathPictureDrink;
    }

    public String getPriceDrink() {
        return priceDrink;
    }

    public void setPriceDrink(String priceDrink) {
        this.priceDrink = priceDrink;
    }

}

