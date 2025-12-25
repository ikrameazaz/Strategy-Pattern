package ma.enset.glsid.ikrameazaz.strategy;

public class Context {
    private IStrategy strategy;

    public Context() {
        this.strategy = new DefaultStrategyImpl();
    }

    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void effectuerOperation() {
        System.out.println("***************");
        strategy.operationStrategy();
        System.out.println("***************");
    }
}
