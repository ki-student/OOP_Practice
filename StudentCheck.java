class Student{
    private String name;
    private int number;
    private double gpa;

    Student(String name, int num, double gpa){
        this.name = name;
        number = num;
        this.gpa = gpa;
    }
    public String getName(){return name;}
    public int getNumber(){return number;}
    public double getGPA(){return gpa;}
    public String toString(){
        System.out.println("Name: " + name + ", Number: " + number + ", GPA: " + gpa);
        return "";
    }
}

class StudentDB {
    private Student[] students;
    private int count;
    private static int LOWER_THAN = 1;
    private static int HIGHER_THAN = 0;

    public StudentDB() {
        students = new Student[3];
        count = 0;
    }

    public void add(Student student) {
        if (count < students.length) {
            students[count] = student;
            count++;
        } else {
            System.out.println("Student database is full. Cannot add more students.");
        }
    }

    public void add(String name, int num, double gpa) {
        if (count < students.length) {
            students[count] = new Student(name, num, gpa);
            count++;
        } else {
            System.out.println("Student database is full. Cannot add more students.");
        }
    }

    public Student findBy(String name) {
        for (int i = 0; i < count; i++) {
            if (students[i].getName().equals(name)) {
                return students[i];
            }
        }
        return null; // Student not found
    }

    public Student findBy(int number) {
        for (int i = 0; i < count; i++) {
            if (students[i].getNumber() == number) {
                return students[i];
            }
        }
        return null;
    }

    public Student findBy(double gpa) {
        for (int i = 0; i < count; i++) {
            if (students[i].getGPA() == gpa) {
                return students[i];
            }
        }
        return null;
    }

    public Student findBy(int param, double gpa) {
        for (int i = 0; i < count; i++) {
            if (param == LOWER_THAN && students[i].getGPA() < gpa) {
                return students[i];
            } else if (param == HIGHER_THAN && students[i].getGPA() > gpa) {
                return students[i];
            }
        }
        return null;
    }
}
public class StudentCheck {
    public static void main(String[] args) {
        StudentDB db = new StudentDB();

        Student student1 = new Student("김지우", 201911111, 4.01);
        db.add(student1);
        db.add("이민준", 201922222, 4.01);
        db.add("박서윤", 201933333, 3.90);

        Student name = db.findBy("김지우");
        System.out.println(name);
        Student num = db.findBy(201922222);
        System.out.println(num);
        Student gpa = db.findBy(3.90);
        System.out.println(gpa);
        Student lower = db.findBy(1, 3.95);
        System.out.println(lower);
        Student higher = db.findBy(0, 3.95);
        System.out.println(higher);
    }
}
