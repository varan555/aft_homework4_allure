package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import steps.BaseSteps;

import static org.junit.Assert.assertTrue;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void clickElement(WebElement element){
        ((JavascriptExecutor) BaseSteps.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        BaseSteps.wait.until(ExpectedConditions.visibilityOf(element));
        BaseSteps.wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public void clickElement2(WebElement element){
        //((JavascriptExecutor) BaseSteps.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        BaseSteps.wait.until(ExpectedConditions.visibilityOf(element));
        BaseSteps.wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }


    public void switchFrame(WebElement element){
        BaseSteps.wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }

    public void clear(WebElement element){
        ((JavascriptExecutor) BaseSteps.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        BaseSteps.wait.until(ExpectedConditions.visibilityOf(element));
        BaseSteps.wait.until(ExpectedConditions.elementToBeClickable(element)).clear();
    }

    public void enter(WebElement nameField, String value) {
        ((JavascriptExecutor) BaseSteps.getDriver()).executeScript("arguments[0].scrollIntoView(true);", nameField);
        BaseSteps.wait.until(ExpectedConditions.visibilityOf(nameField));
        BaseSteps.wait.until(ExpectedConditions.elementToBeClickable(nameField)).sendKeys(value);
    }

    public void waitVisibilityOf(WebElement element){
        BaseSteps.wait.until(ExpectedConditions.visibilityOf(element));
    }


}


