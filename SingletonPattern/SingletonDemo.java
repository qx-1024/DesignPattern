package SingletonPattern;

/**
 * @author 秋玄
 * @version 1.0
 * @email qiu_2022@aliyun.com
 * @project DesignModel
 * @package SingletonModel
 * @date 2022-10-24-14:45
 * @since 1.0
 */
public class SingletonDemo {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        Singleton singleton3 = Singleton.getInstance();
        Singleton singleton4 = Singleton.getInstance();

        /**
         * 输出结果(仅输出一次)：1
         */
    }
}

class Singleton{
    static Singleton instance = new Singleton();

    private int i = 0;

    private Singleton(){
        i++;
        System.out.println(i);
    }

    public static Singleton getInstance(){
        return instance;
    }
}
