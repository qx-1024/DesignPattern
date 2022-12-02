package SimpleFactoryPattern;

/**
 * 简单工厂模式
 * @author 秋玄
 * @version 1.0
 * @email qiu_2022@aliyun.com
 * @project DesignModel
 * @package SimpleFactoryModel
 * @date 2022-10-24-08:40
 * @since 1.0
 */
public class SimpleFactory {
    public static void main(String[] args) {
        Product productA = Factory.createProduct("A");
        Product productB = Factory.createProduct("B");
        productA.info();
        productB.info();
    }
}

class Factory{
    public static Product createProduct(String type){
        Product product = null;
        switch (type){
            case "A":
                product = new ProductA();
                break;
            case "B":
                product = new ProductB();
                break;
            default:
                System.out.println("没有 " + type + " 类型的产品");
                break;
        }
        return product;
    }
}

abstract class Product{
    public abstract void info();
}

class ProductA extends Product{
    @Override
    public void info() {
        System.out.println("产品A");
    }
}

class ProductB extends Product{
    @Override
    public void info() {
        System.out.println("产品B");
    }
}
