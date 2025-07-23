package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LogoutTest extends BaseTest {
    @Test
    public void testLogout() {
        driver.get("https://the-internet.herokuapp.com/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickLogin();
        loginPage.clickLogout();

        String mensaje = loginPage.getFlashMessage();
        Assert.assertTrue(mensaje.contains("You logged out of the secure area!"), "Logout no fue exitoso");
    }
}