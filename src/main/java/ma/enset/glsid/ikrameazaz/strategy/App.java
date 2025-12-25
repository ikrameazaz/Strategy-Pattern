package ma.enset.glsid.ikrameazaz.strategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Context context = new Context();
        Scanner scanner = new Scanner(System.in);
        Map<String, IStrategy> strategyCache = new HashMap<>();

        while (true) {
            System.out.println("Quelle stratégie ? (1, 2, 3) ou 'exit' pour quitter:");
            String strategyKey = scanner.next();

            if ("exit".equalsIgnoreCase(strategyKey)) {
                break;
            }

            try {
                IStrategy strategy = strategyCache.get(strategyKey);

                if (strategy == null) {
                    System.out.println("Création d'un nouvel objet de stratégie...");
                    String className = "ma.enset.glsid.hamzaelghazouani.strategy.StrategyImpl" + strategyKey;
                    Class<?> clazz = Class.forName(className);
                    strategy = (IStrategy) clazz.getConstructor().newInstance();
                    strategyCache.put(strategyKey, strategy);
                } else {
                    System.out.println("Utilisation de la stratégie depuis le cache...");
                }

                context.setStrategy(strategy);
                context.effectuerOperation();

            } catch (ClassNotFoundException e) {
                System.out.println("ERREUR: Stratégie introuvable pour la clé: " + strategyKey);
            } catch (Exception e) {
                System.out.println("ERREUR: Impossible d'instancier la stratégie.");
                e.printStackTrace();
            }
        }
        scanner.close();
    }
}
