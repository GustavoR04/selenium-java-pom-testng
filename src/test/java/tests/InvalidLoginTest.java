package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class InvalidLoginTest extends BaseTest {
    @Test
    public void testInvalidLogin() {
        driver.get("https://the-internet.herokuapp.com/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("usuarioInvalido");
        loginPage.enterPassword("claveIncorrecta");
        loginPage.clickLogin();

        String mensaje = loginPage.getFlashMessage();
        Assert.assertTrue(mensaje.contains("Your username is invalid!"), "No se mostró el mensaje esperado");
    }
}