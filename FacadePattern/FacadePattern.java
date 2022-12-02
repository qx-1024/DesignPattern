package FacadePattern;

/**
 * 外观模式
 * @author 秋玄
 * @version 1.0
 * @email qiu_2022@aliyun.com
 * @project DesignModel
 * @package FacadePattern
 * @date 2022-10-24-18:53
 * @since 1.0
 */
public class FacadePattern {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.methodA();
        facade.methodB();
        facade.methodC();
    }
}

class Facade{
    SubSystemOne subSystemOne;
    SubSystemTwo subSystemTwo;
    SubSystemThree subSystemThree;
    public Facade(){
        subSystemOne = new SubSystemOne();
        subSystemTwo = new SubSystemTwo();
        subSystemThree = new SubSystemThree();
    }

    public void methodA(){
        subSystemOne.methodOne();
    }
    public void methodB(){
        subSystemTwo.methodTwo();
    }
    public void methodC(){
        subSystemThree.methodThree();
    }
}

class SubSystemOne{
    public void methodOne(){
        System.out.println("子系统一的方法");
    }
}

class SubSystemTwo{
    public void methodTwo(){
        System.out.println("子系统二的方法");
    }
}

class SubSystemThree{
    public void methodThree(){
        System.out.println("子系统三的方法");
    }
}
