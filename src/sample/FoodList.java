package sample;
public class FoodList {


    String nameFood;
    String numberFood;
    String pathPictureFood;
    String priceFood;
    int quantityFood;

    public FoodList(String foodPointer) {
    }

    public int getQuantityFood() {
        return quantityFood;
    }

    public FoodList() {

    }

    public int setQuantityFood(int quantityFood) {
        this.quantityFood = quantityFood;
        return quantityFood;
    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public String getNumberFood() {
        return numberFood;
    }

    public void setNumberFood(String numberFood) {
        this.numberFood = numberFood;
    }

    public String getPathPictureFood() {
        return pathPictureFood;
    }

    public void setPathPictureFood(String pathPictureFood) {
        this.pathPictureFood = pathPictureFood;
    }

    public String getPriceFood() {
        return priceFood;
    }

    public void setPriceFood(String priceFood) {
        this.priceFood = priceFood;
    }

    public FoodList(String numberFood, String nameFood, String pathPictureFood, String priceFood,int quantityFood)
    {
        this.numberFood = numberFood;
        this.nameFood = nameFood;
        this.pathPictureFood = pathPictureFood;
        this.priceFood = priceFood;
        this.quantityFood = quantityFood;
    }


}

