package ru.netology.web.ru.netology.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.DashboardPage;
import ru.netology.web.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class MoneyTransferTest {

    @Test
    void successfulTransferFromCardToCard() {
        open("http://localhost:9999");
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCode(authInfo);
        verificationPage.validVerify(verificationCode);
        var dashboardPage = new DashboardPage();
        var firstBalanceCardOld = dashboardPage.getFirstCardBalance();
        var secondBalanceCardOld = dashboardPage.getSecondCardBalance();
        var cardReplenishmentPage = dashboardPage.replenishmentCard0001();
        var cardNumber = DataHelper.getCardNumber2();
        cardReplenishmentPage.topUpCard("1000", cardNumber.getCardNumber());
        var firstBalanceCardNew = dashboardPage.getFirstCardBalance();
        var secondBalanceCardNew = dashboardPage.getSecondCardBalance();
        Assert.assertEquals(firstBalanceCardNew, firstBalanceCardOld + 1000);
        Assert.assertEquals(secondBalanceCardNew, secondBalanceCardOld - 1000);
    }
}
