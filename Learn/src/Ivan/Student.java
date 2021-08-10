package Ivan;

public class Student extends Person {
    int course= 1;

    public Student (int height, String name,int how_old , int course){
        super(height, name, how_old);
        this.course = course;
    }

    void tell(){
        System.out.printf(super.name + " " + super.height+ " " + course);
    }
}
