package Ivan;

public class Person {
    int height;
    String name;
    private int how_old;

    public int summ(int height){
        return height+height;
    }
    public Person() {

    }
    public Person(int height, String name,int how_old){
        this.height = height;
        this.name = name;
        this.how_old= how_old;

    }
}
