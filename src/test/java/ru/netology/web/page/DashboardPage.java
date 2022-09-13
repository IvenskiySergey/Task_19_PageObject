package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private static SelenideElement topUp0001 = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0'] button");
    private static SelenideElement topUp0002 = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d'] button");
    private SelenideElement update = $("[data-test-id=action-reload]");
    private static SelenideElement balanceCard1 = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    private static SelenideElement balanceCard2 = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");

    public DashboardPage() {
        heading.shouldBe(visible);
    }

    public static CardReplenishmentPage replenishmentCard0001() {
        topUp0001.click();
        return new CardReplenishmentPage();
    }

    public static CardReplenishmentPage replenishmentCard0002() {
        topUp0002.click();
        return new CardReplenishmentPage();
    }

    public static String balanceOfCard1() {
        String balanceOfCard = balanceCard1.text();
        return balanceOfCard;
    }

    public static String balanceOfCard2() {
        String balanceOfCard = balanceCard2.text();
        return balanceOfCard;
    }

    public DashboardPage update() {
        update.click();
        return new DashboardPage();
    }
}
