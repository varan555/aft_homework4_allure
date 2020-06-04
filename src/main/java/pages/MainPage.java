package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class MainPage extends BasePage{

    @FindBy(xpath = "//ul[@class='lg-menu__list']")
    public WebElement menuLink;

    public MainPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public MainPage chooseElementMainMenu(String elementMainMenu) {
        //WebElement elementMenu = menuLink.findElement(By.xpath(".//button[contains(., '"+elementMainMenu+"')]"));
        WebElement elementMenu = BaseSteps.getDriver().findElement(By.xpath("//button[contains(., '"+elementMainMenu+"')]"));
        clickElement(elementMenu);
        return this;
    }

    public void chooseElementSubmenu(String elementSubmenu) {
        WebElement elementMenu = menuLink.findElement(By.xpath("//div[@class='kit-col kit-col_lg_5 lg-menu__col']" +
                "//a[contains(text(), '"+elementSubmenu+"')]"));
        clickElement(elementMenu);
    }

}
