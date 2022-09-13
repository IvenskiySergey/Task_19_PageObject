package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CardReplenishmentPage {
    private SelenideElement sum = $("[data-test-id=amount] input");
    private SelenideElement where = $("[data-test-id=from] input");
    private SelenideElement topUp = $("[data-test-id=action-transfer]");
    private SelenideElement cancel = $("[data-test-id=action-cancel]");

    public CardReplenishmentPage() {
        sum.shouldBe(visible);
    }

    public DashboardPage topUpCard(String transferAmount, String cardNumber) {
        sum.setValue(transferAmount);
        where.setValue(cardNumber);
        topUp.click();
        return new DashboardPage();
    }

    public DashboardPage actionCancel() {
        cancel.click();
        return new DashboardPage();
    }
}
