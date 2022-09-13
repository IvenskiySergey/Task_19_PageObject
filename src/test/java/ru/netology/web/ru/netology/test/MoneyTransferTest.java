package ru.netology.web.ru.netology.test;

import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.CardReplenishmentPage;
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
        var cardReplenishmentPage = DashboardPage.replenishmentCard0001();
        var cardNumber = DataHelper.CardNumber.getCardNumber2();
        cardReplenishmentPage.topUpCard("1000", cardNumber.getCardNumber());
        var balanceCard1 = DashboardPage.balanceOfCard1();
        System.out.println(balanceCard1);


    }
}
