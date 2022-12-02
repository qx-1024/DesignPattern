package VisitorPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问者模式
 * @author 秋玄
 * @version 1.0
 * @email qiu_2022@aliyun.com
 * @project DesignPattern
 * @package VisitorPattern
 * @date 2022-10-25-22:05
 * @since 1.0
 */
public class VisitorPattern {
    public static void main(String[] args) {
        PersonStructure structure = new PersonStructure();

        Visitor visitor1 = new Visitor1();
        System.out.println("访问者1的访问记录：");
        structure.accept(visitor1);

        System.out.println("===========================");

        Visitor visitor2 = new Visitor2();
        System.out.println("访问者2的访问记录：");
        structure.accept(visitor2);
    }
}

interface Visitor{
    public void visitStudent(Student student);
    public void visitTeacher(Teacher teacher);
}

class Visitor1 implements Visitor{
    @Override
    public void visitStudent(Student student) {
        System.out.println("访问者1访问学生：" + student.name);
    }

    @Override
    public void visitTeacher(Teacher teacher) {
        System.out.println("访问者1访问老师：" + teacher.name);
    }
}

class Visitor2 implements Visitor{
    @Override
    public void visitStudent(Student student) {
        System.out.println("访问者2访问学生：" + student.name);
    }

    @Override
    public void visitTeacher(Teacher teacher) {
        System.out.println("访问者2访问老师：" + teacher.name);
    }
}

class PersonStructure{
    private List<Person> personList = new ArrayList<>();

    public PersonStructure(){
        personList.add(new Student("张三"));
        personList.add(new Student("李四"));
        personList.add(new Student("王五"));

        personList.add(new Teacher("赵老师"));
        personList.add(new Teacher("钱老师"));
        personList.add(new Teacher("孙老师"));
    }

    public void accept(Visitor visitor){
        for (Person person : personList) {
            person.accept(visitor);
        }
    }
}

abstract class Person{
    public String name;
    public abstract void accept(Visitor visitor);
}

class Student extends Person{

    public Student(String name){
        this.name = name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitStudent(this);
    }
}

class Teacher extends Person{

    public Teacher(String name){
        this.name = name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitTeacher(this);
    }
}
