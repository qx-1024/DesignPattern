package TemplateMethodPattern;

/**
 * 模板方法模式
 * @author 秋玄
 * @version 1.0
 * @email qiu_2022@aliyun.com
 * @project DesignPattern
 * @package TemplateMethodPattern
 * @date 2022-10-25-21:53
 * @since 1.0
 */
public class TemplateMethodPattern {
    public static void main(String[] args) {
        Person student = new Student();
        Person teacher = new Teacher();

        student.templateMethod();

        System.out.println("========================");

        teacher.templateMethod();
    }
}

abstract class Person{
    public void templateMethod(){
        System.out.println("上课 去教室");
        primitiveOperation1();
        System.out.println("下课 离开教室");
        primitiveOperation2();
    }

    public abstract void primitiveOperation1();
    public abstract void primitiveOperation2();
}

class Student extends Person{
    @Override
    public void primitiveOperation1() {
        System.out.println("听课");
    }

    @Override
    public void primitiveOperation2() {
        System.out.println("写作业");
    }
}

class Teacher extends Person{
    @Override
    public void primitiveOperation1() {
        System.out.println("讲课");
    }

    @Override
    public void primitiveOperation2() {
        System.out.println("布置作业");
    }
}
