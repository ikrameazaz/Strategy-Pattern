package ma.enset.glsid.ikrameazaz.strategy;

public class DefaultStrategyImpl implements IStrategy {
    @Override
    public void operationStrategy() {
        System.out.println("Stratégie par défaut.");
        System.out.println("Aucun algorithme spécifique sélectionné.");
    }
}
