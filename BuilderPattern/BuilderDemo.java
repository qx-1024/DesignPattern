package BuilderPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 构建（生成）器模式
 * @author 秋玄
 * @version 1.0
 * @email qiu_2022@aliyun.com
 * @project DesignModel
 * @package BuilderModel
 * @date 2022-10-24-10:58
 * @since 1.0
 */
public class BuilderDemo {
    public static void main(String[] args) {
        Director director = new Director();

        Builder builder1 = new Builder1();
        director.construct(builder1);
        Product product1 = builder1.getResult();
        product1.show();

        Builder builder2 = new Builder2();
        director.construct(builder2);
        Product product2 = builder2.getResult();
        product2.show();
    }
}

class Director{
    public void construct(Builder builder){
        builder.builderPart();
    }
}

abstract class Builder{
    public abstract void builderPart();
    public abstract Product getResult();
}

class Builder1 extends Builder{
    Product product = new Product();

    @Override
    public void builderPart() {
        product.add("A");
        product.add("B");
        product.add("C");
        product.add("D");
        product.add("E");
        product.add("F");
        product.add("G");
    }

    @Override
    public Product getResult() {
        return product;
    }
}

class Builder2 extends Builder{
    Product product = new Product();

    @Override
    public void builderPart() {
        product.add("A");
        product.add("B");
        product.add("C");
        product.add("D");
    }

    @Override
    public Product getResult() {
        return product;
    }
}

class Product{
    List<String> parts = new ArrayList<>();

    public void add(String part){
        parts.add(part);
    }

    public void show(){
        System.out.println("产品的组成：");
        for (String part : parts) {
            System.out.print(part + " ");
        }
        System.out.println();
    }
}
