import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.BasePage;
import steps.BaseSteps;
import steps.MainPageSteps;
import steps.MortgageFinishedHousingSteps;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class AllureTest {

    BaseSteps baseSteps = new BaseSteps();
    MainPageSteps mainPageSteps = new MainPageSteps();
    MortgageFinishedHousingSteps mortgageSteps = new MortgageFinishedHousingSteps();

    @BeforeEach
    void setup() {
        BaseSteps.setUp();
    }

    @Test
    void sberbank2Test() {
        mainPageSteps.chooseElementMainMenu("Ипотека")
                .chooseElementSubmenu("Ипотека на готовое жильё");

        mortgageSteps.enterValues(
                new LinkedHashMap<String, String>(){{
                    put("Стоимость недвижимости","5180000");
                    put("Первоначальный взнос","3058000");
                    put("Срок кредита","30");

                }});
//                .chooseDiscounts("Есть зарплатная карта Сбербанка")
//                .chooseDiscounts("Есть возможность подтвердить доход справкой")
//                .chooseDiscounts("Молодая семья");

        mortgageSteps.checkResults(
                new LinkedHashMap<String, Double>(){{
                    put("Сумма кредита", 2122000.0);
                    put("Ежемесячный платеж", 16317.0);
                    put("Необходимый доход", 27194.0);
                    put("Процентная ставка",11.0);
                }});
    }
    @AfterEach
    void quit(){
        BaseSteps.tearDown();
    }

}
