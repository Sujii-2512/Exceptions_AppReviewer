import App.App;
import App.AppProcessor;
import Exceptions.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<App> appList = List.of(
                new App("CodeMate", "Bhanu", 300, "Utility", 50),
                new App("MegaFighter", "HackerDev", 400, "Games", 40),
                new App("BudgetTracker", "FinTechPro", 550, "Finance", 25),
                new App("BizzConnect", "TechieDev", 450, "Business", 60),
                new App("CloudDesk", "CorpSoft", 420, "Enterprise", 120)
        );

        AppProcessor processor = new AppProcessor();

        for (App app : appList) {
            try {
                processor.processApp(app);
            } catch (AppSizeTooLargeException | InvalidCategoryException |
                     PricingException | DeveloperBannedException e) {
                System.out.println("Exception: " + e.getMessage());
            } finally {
                System.out.println("\nValidation completed for " + app.appName + "");
            }
        }
    }
}