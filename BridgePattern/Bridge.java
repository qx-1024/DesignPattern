package BridgePattern;

/**
 * 桥接模式
 * @author 秋玄
 * @version 1.0
 * @email qiu_2022@aliyun.com
 * @project DesignModel
 * @package BridgePattern
 * @date 2022-10-24-15:38
 * @since 1.0
 */
public class Bridge {
    public static void main(String[] args) {
        Product productA = new ProductA();
        Color red = new Red();
        productA.setName("ProductA");
        productA.setColor(red);
        productA.operation();
    }
}

abstract class Product{
    private String name;
    protected Color color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public abstract void operation();
}

class ProductA extends Product{
    @Override
    public void operation() {
        color.operationImpl(this.getName());
    }
}

interface Color{
    public void operationImpl(String name);
}

class Red implements Color{
    @Override
    public void operationImpl(String name) {
        System.out.println(name + " : Red");
    }
}

class Blue implements Color{
    @Override
    public void operationImpl(String name) {
        System.out.println(name + " : Blue");
    }
}
