public class Coder {

    private double height;
    private double weight;
    private int age;
    private Gender gender;

    public Coder() {
    }

    public Coder(double weight, double height) {
        setHeight(height);
        setWeight(weight);
    }

    public Coder(double weight, double height, int age, Gender gender) {
        setWeight(weight);
        setHeight(height);
        setAge(age);
        setGender(gender);
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setWeight(double weight) {
         this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }
}
