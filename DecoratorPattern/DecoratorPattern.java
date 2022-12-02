package DecoratorPattern;

/**
 * 装饰者模式
 * @author 秋玄
 * @version 1.0
 * @email qiu_2022@aliyun.com
 * @project DesignModel
 * @package DecoratorPattern
 * @date 2022-10-24-17:32
 * @since 1.0
 */
public class DecoratorPattern {
    public static void main(String[] args) {
        Person zhangsan = new Student("张三");
        zhangsan.operation();

        System.out.println("\n=============");

        zhangsan = new DecoratorA(zhangsan);
        zhangsan.operation();

        System.out.println("\n=============");

        zhangsan = new DecoratorB(zhangsan);
        zhangsan.operation();
    }
}

abstract class Decorator extends Person{
    protected Person person;

}

class DecoratorA extends Decorator{
    public DecoratorA(Person person){
        this.person = person;
    }
    @Override
    public void operation() {
        person.operation(); // 原本的职责
        // 额外的职责
        System.out.print("写作业 ");
    }
}

class DecoratorB extends Decorator{
    public DecoratorB(Person person){
        this.person = person;
    }
    @Override
    public void operation() {
        person.operation(); // 原本的职责
        // 额外的职责
        System.out.print("考试 ");
    }
}

abstract class Person{
    protected String name;
    public abstract void operation();
}

class Student extends Person{
    public Student(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.print(name + "的职责：学习 ");
    }
}
