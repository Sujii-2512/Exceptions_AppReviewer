package App;

import Exceptions.AppSizeTooLargeException;
import Exceptions.DeveloperBannedException;
import Exceptions.InvalidCategoryException;
import Exceptions.PricingException;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class AppProcessor {

    // Valid categories allowed for submission
    private static final Set<String> ALLOWED_CATEGORIES = Set.of("Games", "Utility", "Finance", "Enterprise");

    // List of developers who are banned from submitting apps
    private static final List<String> BANNED_DEVELOPERS = Arrays.asList("HackerDev", "FakeAppsInc");

    public void processApp(App app) throws AppSizeTooLargeException,
            InvalidCategoryException, PricingException, DeveloperBannedException {

        // Rule 1: App size must not exceed 500 MB
        if (app.appSizeInMB > 500) {
            throw new AppSizeTooLargeException("App size is too large: " + app.appSizeInMB + " MB Maximum allowed is 500 MB.");
        }

        // Rule 2: The category must be one of the allowed types
        if (!ALLOWED_CATEGORIES.contains(app.category)) {
            throw new InvalidCategoryException("Invalid category: " + app.category + ". Allowed categories: " + ALLOWED_CATEGORIES);
        }

        // Rule 3: Price must be >= 0. For non-Enterprise apps, it must not exceed 100
        if (app.price < 0 || (!app.category.equals("Enterprise") && app.price > 100)) {
            throw new PricingException("Invalid price: " + app.price + ". For non-Enterprise apps, max allowed is 100.");
        }

        // Rule 4: Developer must not be on the banned list
        if (BANNED_DEVELOPERS.contains(app.developerName)) {
            throw new DeveloperBannedException("Developer " + app.developerName + " is banned from publishing apps.");
        }

        // If all checks pass print approved for publishing
        System.out.println("\nApp " + app.appName + " by " + app.developerName + " is approved for publishing.");
    }
}