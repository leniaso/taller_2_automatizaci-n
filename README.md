# SauceDemo E2E - Screenplay + Serenity BDD

Automated tests for https://www.saucedemo.com/ (Java 17, Gradle, Cucumber, Serenity 4.1.0).

## How to run

Requires JDK 17 and Chrome.

```bash
./gradlew clean test                                                     # everything (excludes @known_defect)
./gradlew test --tests "co.saucedemo.runners.e2e.E2ERunner"              # the full E2E purchase
./gradlew test --tests "co.saucedemo.runners.checkout.CheckoutRunner"    # checkout steps one and two
./gradlew test -Ddelay.ms=1500                                           # slow demo: pause between steps
./gradlew knownDefects                                                   # scenarios that document known defects
```

The Serenity report is generated automatically after `test` (`finalizedBy aggregate`):
`target/site/serenity/index.html`. To regenerate it only: `./gradlew aggregate`.

Tags: `@smoke`, `@regression`, `@e2e`, `@checkout`, ... Run a subset with `-Dcucumber.filter.tags="@smoke"`.

## Structure

| Folder | Content |
|---|---|
| `features/` | Gherkin per module: authentication, catalog, cart, checkout, e2e |
| `tasks/` | Business actions (`Login`, `AddProducts`, `StartCheckout`, `FinishPurchase`...) |
| `interactions/` | Low-level actions (`EnterCredentials`, `FillField`...) |
| `questions/` | Verifications (`CartBadge`, `OrderSummary`, `PurchaseConfirmation`...) |
| `userinterfaces/` | Locators only (`data-test` attributes) |
| `models/` | Test data (`User`, `Product`, `ShippingInformation`) |
| `exceptions/` | Clear failure messages (`CartError`, `CheckoutError`, `OrderError`) |
| `stepdefinitions/` | One class per module + hooks (`StepDefinition`) |
| `runners/` | One runner per module + general `Runner` |

## F.I.R.S.T. evidence

| Principle | How it is applied |
|---|---|
| Fast | Each scenario does only what it needs; the delay between steps is 0 unless `-Ddelay.ms` is set |
| Independent | Every scenario logs in and builds its own cart in `Background`; no scenario relies on another; a new browser per scenario (`use.unique.browser = false`) |
| Repeatable | The site keeps no server state between sessions; incognito browser; fixed test data in `models` |
| Self-validating | Every scenario ends with a `Then` backed by a Question; failures raise a named exception with a clear message |
| Timely | Scenarios were written from the acceptance criteria before the tasks and questions |

## Coverage by rubric criterion

| Criterion | Where |
|---|---|
| Functional coverage | Happy path (`e2e_purchase.feature`), errors (invalid login, empty form fields), limits (empty cart, empty badge after purchase), problem users (`problem_user.feature`) |
| F.I.R.S.T. | Section above |
| Serenity reports | `target/site/serenity/index.html`, epic/feature structure from the folders, tags |
| Code quality | Locators only in `userinterfaces`, business names in tasks, test data in `models`, custom exceptions |
| Creativity | Scenario Outline for validations, arithmetic check of the order (item total = sum of prices, total = item total + tax), configurable delay, known-defect scenarios |
| Presentation | Demo script below |

## Demo script (Person 4 closes the presentation)

1. Say what is being automated and show the folder structure (Screenplay: Feature -> Step -> Task -> Interaction / Question).
2. Run `./gradlew test --tests "co.saucedemo.runners.e2e.E2ERunner" -Ddelay.ms=1500` with the browser visible.
3. While it runs, narrate: login, 3 products added, badge 3, one removed, badge 2, cart, shipping data, summary, finish, back home, badge 0, logout.
4. Open `target/site/serenity/index.html` and show the E2E steps, the checkout features and the tags.
5. Close with the F.I.R.S.T. table.

Tip: keep a report already generated as a backup in case the network fails during the demo.
