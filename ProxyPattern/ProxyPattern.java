package ProxyPattern;

/**
 * 代理模式
 * @author 秋玄
 * @version 1.0
 * @email qiu_2022@aliyun.com
 * @project DesignModel
 * @package ProxyPattern
 * @date 2022-10-25-09:00
 * @since 1.0
 */
public class ProxyPattern {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        Proxy proxy = new Proxy(realSubject);
        proxy.buy();
    }
}

interface Subject{
    public void buy();
}

class Proxy implements Subject{
    protected RealSubject realSubject;

    public Proxy(RealSubject realSubject){
        this.realSubject = realSubject;
    }

    @Override
    public void buy() {
        System.out.println("办理购买前的手续");
        realSubject.buy();
        System.out.println("办理购买后的手续");
    }
}

class RealSubject implements Subject{
    @Override
    public void buy() {
        System.out.println("付钱");
    }
}
