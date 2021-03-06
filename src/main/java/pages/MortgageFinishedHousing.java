package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;
import static org.junit.Assert.assertTrue;
import static steps.BaseSteps.getDriver;

public class MortgageFinishedHousing extends BasePage{

    @FindBy(xpath = "//div[@class='calc-main-cont']")
    private WebElement calculatorInput;

    @FindBy(xpath = "//div[@class='dcCalc_frame__discounts']")
    private WebElement discounts;

    @FindBy(xpath = "//div[@class='aside-cont']")
    private WebElement results;

    @FindBy(xpath = "//iframe[@id='iFrameResizer0']")
    private WebElement frame;

    public MortgageFinishedHousing(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public MortgageFinishedHousing enterValue(String nameField, String value) {
        switchFrame(frame);
        WebElement nameOfField = calculatorInput.findElement(By.xpath
                ("//div[@class = 'dcCalc_input-row-tablet' and contains(., '"+nameField+"')]//input"));
        clear(nameOfField);
        enter(nameOfField, value);
        customWaiting();
        getDriver().switchTo().defaultContent();
        return this;
    }



    public void chooseDiscountsOff(String nameDiscounts){
        switchFrame(frame);
        WebElement nameOfDiscounts = getDriver().findElement
                (By.xpath("//div[@class = 'dcCalc_switch-tablet__row' and contains(.,'"+nameDiscounts+"')]//span[contains(@class, 'dcCalc_switch__icon-on')]"));
        clickElement2(nameOfDiscounts);
        customWaiting();
        getDriver().switchTo().defaultContent();
    }

    public void chooseDiscountsOn(String nameDiscounts){
        switchFrame(frame);
        WebElement nameOfDiscounts = getDriver().findElement
                (By.xpath("//div[@class = 'dcCalc_switch-tablet__row' and contains(.,'"+nameDiscounts+"')]//span[contains(@class, 'dcCalc_switch__icon-off')]"));
        clickElement2(nameOfDiscounts);
        customWaiting();
        getDriver().switchTo().defaultContent();
    }

    public MortgageFinishedHousing checkResult(String nameField, Double expected) {
        switchFrame(frame);
        WebElement fieldResult = results.findElement
                (By.xpath(".//div[@class='dcCalc_result-calculation' and contains(., '"+nameField+"')]//span"));
        String result1 = fieldResult.getText().replaceAll("[\\u20BD%\\s]+","");
//        String result3 = result1.replaceAll("%","");
//        String result4 = result3.replaceAll("\\s", "");
        String result2 = result1.replaceAll("\\,", "\\.");
        double result = Double.parseDouble(result2);
        assertTrue("Значение поля " + nameField + " не соответствует ожидаемому " + result + "!=" + expected, expected == result);
        getDriver().switchTo().defaultContent();
        return this;

    }

    public void customWaiting() {
        WebElement payment = BaseSteps.getDriver().findElement(By.xpath(".//span[@data-test-id='monthlyPayment']"));

        String value1 = payment.getText();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String value2 = payment.getText();
        while (!value1.equals(value2)) {
            value1 = payment.getText();
            value2 = payment.getText();
        }

    }


}
