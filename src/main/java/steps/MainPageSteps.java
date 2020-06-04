package steps;

import io.qameta.allure.Step;
import pages.MainPage;



public class MainPageSteps {

    //MainPage mainPage = new MainPage();

    @Step("выбрано меню {elementMainMenu}")
    public MainPageSteps chooseElementMainMenu(String elementMainMenu) {
        MainPage mainPage = new MainPage();
        mainPage.chooseElementMainMenu(elementMainMenu);
        return this;
    }

    @Step("выбрано подменю {elementSubmenu}")
    public void chooseElementSubmenu(String elementSubmenu){
        MainPage mainPage = new MainPage();
        mainPage.chooseElementSubmenu(elementSubmenu);

    }

}
