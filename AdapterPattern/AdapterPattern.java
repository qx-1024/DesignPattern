package AdapterPattern;

/**
 * 适配器模式
 * @author 秋玄
 * @version 1.0
 * @email qiu_2022@aliyun.com
 * @project DesignModel
 * @package AdapterPattern
 * @date 2022-10-24-15:14
 * @since 1.0
 */
public class AdapterPattern {
    public static void main(String[] args) {
        Target target = new Adapter();
        target.request();
    }
}

class Target{
    public void request(){
        System.out.println("普通请求");
    }
}

class Adapter extends Target{
    private Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}

class Adaptee{
    public void specificRequest(){
        System.out.println("特殊请求");
    }
}
