public class DietPlan {

    private int calories;
    private int protein;
    private int fat;
    private int carbohydrate;

    public DietPlan(int calories, int protein, int fat, int carbohydrate) {
        setCalories(calories);
        setProtein(protein);
        setFat(fat);
        setCarbohydrate(carbohydrate);
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }
}
