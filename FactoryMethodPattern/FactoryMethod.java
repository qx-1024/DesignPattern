package FactoryMethodPattern;

/**
 * 工厂方法模式
 * @author 秋玄
 * @version 1.0
 * @email qiu_2022@aliyun.com
 * @project DesignModel
 * @package FactoryMethodModel
 * @date 2022-10-24-09:10
 * @since 1.0
 */
public class FactoryMethod {
    public static void main(String[] args) {
        Factory factoryA = new FactoryA();
        Product productA = factoryA.createProduct();
        productA.info();

        Factory factoryB = new FactoryB();
        Product productB = factoryB.createProduct();
        productB.info();
    }
}

interface Factory{
    Product createProduct();
}

class FactoryA implements Factory{
    @Override
    public Product createProduct() {
        return new ProductA();
    }
}

class FactoryB implements Factory{
    @Override
    public Product createProduct() {
        return new ProductB();
    }
}

interface Product{
    void info();
}

class ProductA implements Product {
    @Override
    public void info() {
        System.out.println("产品A");
    }
}

class ProductB implements Product {
    @Override
    public void info() {
        System.out.println("产品B");
    }
}
