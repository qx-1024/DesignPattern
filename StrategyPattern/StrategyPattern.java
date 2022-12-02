package StrategyPattern;

/**
 * 策略模式
 * @author 秋玄
 * @version 1.0
 * @email qiu_2022@aliyun.com
 * @project DesignPattern
 * @package StrategyPattern
 * @date 2022-10-25-21:35
 * @since 1.0
 */
public class StrategyPattern {
    public static void main(String[] args) {
        Strategy addStrategy = new AddStrategy();
        Strategy subStrategy = new SubStrategy();
        Strategy mulStrategy = new MulStrategy();

        OperationContext operationContext1 = new OperationContext(addStrategy);
        operationContext1.operation(1,2);

        OperationContext operationContext2 = new OperationContext(subStrategy);
        operationContext2.operation(2,1);

        OperationContext operationContext3 = new OperationContext(mulStrategy);
        operationContext3.operation(3,2);
    }
}

class OperationContext{
    private Strategy strategy;

    public OperationContext(Strategy strategy){
        this.strategy = strategy;
    }

    public void operation(int a,int b){
        strategy.twoNumOperation(a,b);
    }
}

interface Strategy{
    public void twoNumOperation(int a,int b);
}

class AddStrategy implements Strategy{
    @Override
    public void twoNumOperation(int a, int b) {
        System.out.println(a+b);
    }
}

class SubStrategy implements Strategy{
    @Override
    public void twoNumOperation(int a, int b) {
        System.out.println(a-b);
    }
}

class MulStrategy implements Strategy{
    @Override
    public void twoNumOperation(int a, int b) {
        System.out.println(a*b);
    }
}
