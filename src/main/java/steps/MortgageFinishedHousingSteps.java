package steps;

import io.qameta.allure.Step;
import pages.MortgageFinishedHousing;

import java.util.LinkedHashMap;
import java.util.Map;

public class MortgageFinishedHousingSteps {

    //MortgageFinishedHousing mortgageteps = new MortgageFinishedHousing();

    @Step("заполняются поля")
    public MortgageFinishedHousingSteps enterValues(Map<String, String> fields){
        fields.forEach(this::enterValue);
        return this;
    }

    @Step("Поле {nameField} заполняется значением {value}")
    public void enterValue(String nameField, String value) {
        new MortgageFinishedHousing().enterValue(nameField, value);
    }

    @Step("отключение скидки за {nameDiscounts}")
    public MortgageFinishedHousingSteps chooseDiscountsOff(String nameDiscounts){
    new MortgageFinishedHousing().chooseDiscountsOff(nameDiscounts);
        return  this;
    }

    @Step("включение скидки скидки за {nameDiscounts}")
    public MortgageFinishedHousingSteps chooseDiscountsOn(String nameDiscounts){
        new MortgageFinishedHousing().chooseDiscountsOn(nameDiscounts);
        return  this;
    }

    @Step("выполнена проверка заполнения полей:")
    public MortgageFinishedHousingSteps checkResults(Map<String, Double> fields){
        fields.forEach(this::checkResult);
        return this;
    }

    @Step("Проверка соответствия значения поля {nameField} ожидаемому значению {expected}")
    public void checkResult(String nameField, Double expected) {
        new MortgageFinishedHousing().checkResult(nameField, expected);
    }
 }
