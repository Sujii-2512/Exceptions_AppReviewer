# App Management System

## Project Statement

Design a Java system for managing a mobile app platform, where multiple users submit apps for publication. You must validate the submission using layered custom exceptions and enforce app rules.

Developers submit apps for review before they're published. Each submission includes:
- `appName` (String)
- `developerName` (String)
- `appSizeInMB` (double)
- `category` (String, e.g., "Games", "Utility", "Finance")
- `price` (double)

Custom Exceptions:
- `AppSizeTooLargeException`: If appSizeInMB > 500
- `InvalidCategoryException`: If the category is not one of the allowed categories
- `PricingException`: If price < 0 or (price > 100 for non-"Enterprise" apps)
- `DeveloperBannedException`: If the developer is in a banned list

Apps are validated from a list. For each app:
- Try to validate
- Catch and print specific custom exception messages
- On success, print approval message
- Always log that validation is completed

---

## Features

- Validates:
  - App size (must be ≤ 500MB)
  - Allowed categories: `Games`, `Utility`, `Finance`, `Enterprise`
  - Pricing rules:
    - No negative pricing
    - Price > 100 allowed only for "Enterprise" apps
  - Developer must not be on the banned list
- Clear exception handling with user-friendly error messages

---
