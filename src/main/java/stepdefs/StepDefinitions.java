package stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import steps.BaseSteps;
import steps.MainPageSteps;
import steps.MortgageFinishedHousingSteps;

public class StepDefinitions {

    private MainPageSteps mainPageSteps = new MainPageSteps();
    private BaseSteps baseSteps = new BaseSteps();
    private MortgageFinishedHousingSteps mortgageSteps = new MortgageFinishedHousingSteps();

    @When("выбрано меню {string}")
    public void chooseElementMainMenu(String title) {
        mainPageSteps.chooseElementMainMenu(title);
    }

    @When("выбрано подменю {string}")
    public void chooseElementSubmenu(String title) {
        mainPageSteps.chooseElementSubmenu(title);
    }

    @When("включается отключается скидка :")
    public void chooseDiscounts(String nameDiscounts) {
        mortgageSteps.chooseDiscounts(nameDiscounts);
    }

    @When("заполняются поля:")
    public void enterValues(DataTable fields) {
        mortgageSteps.enterValues(
                fields.asMap(String.class, String.class)
        );
    }

    @Then("ожидаемые значения равны:")
    public void checkResults(DataTable fields) {
        mortgageSteps.checkResults(
                fields.asMap(String.class, Double.class)
        );
    }
}
