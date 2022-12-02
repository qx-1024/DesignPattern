package PrototypePattern;

/**
 * 原型模式
 * @author 秋玄
 * @version 1.0
 * @email qiu_2022@aliyun.com
 * @project DesignModel
 * @package PrototypeModel
 * @date 2022-10-24-11:24
 * @since 1.0
 */
public class PrototypeDemo {
    public static void main(String[] args) {
        Product product1 = new Product(2022,9.99);
        System.out.println("product1 : " + product1.getId() + "," + product1.getPrice());

        Product product2 = (Product) product1.clone();
        System.out.println("product2 : " + product2.getId() + "," + product2.getPrice());
    }
}

interface Prototype{
    public Object clone();
}

class Product implements Prototype{
    private int id;
    private double price;

    public Product() {
    }

    public Product(int id, double price) {
        this.id = id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public Object clone() {
        Product object = new Product();
        object.id = this.id;
        object.price = this.price;
        return object;
    }
}
