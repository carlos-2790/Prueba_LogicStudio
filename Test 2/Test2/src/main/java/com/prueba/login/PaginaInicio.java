package com.prueba.login;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PaginaInicio extends PaginaBase {

    String email = "carlos27@carlos.com";
    String password = "carlos123";
    String loggedUrl = "https://opencart.abstracta.us/index.php?route=account/account";
    final String BUTTON_GO_TO_LOGIN_XPATH = "//*[@id=\"column-right\"]/div/a[1]";
    final String INPUT_EMAIL_ID = "input-email";
    final String INPUT_PASSWORD_ID = "input-password";
    final String BUTTON_LOGIN_XPATH = "//*[@id=\"content\"]/div/div[2]/div/form/input";

    /**
     * Caso 1 - parte 1: Login exitoso, identifica cuales son las entradas para tu request.
     */
    @Test
    public void TestCase_1() {

        WebElement btnGoToLogin = driver.findElement(By.xpath(BUTTON_GO_TO_LOGIN_XPATH));
        btnGoToLogin.click();
        WebElement inputEmail = driver.findElement(By.id(INPUT_EMAIL_ID));
        //entrada de request
        inputEmail.sendKeys(email);
        WebElement inputPassword = driver.findElement(By.id(INPUT_PASSWORD_ID));
        //entrada de request
        inputPassword.sendKeys(password);
        WebElement btnLogin = driver.findElement(By.xpath(BUTTON_LOGIN_XPATH));
        btnLogin.click();
    }

    /**
     * Caso 1 - parte 2: Login exitoso, captura las salidas y agrega 1 validación.
     */
    @Test
    public void TestCase_2(){
        WebElement btnGoToLogin = driver.findElement(By.xpath(BUTTON_GO_TO_LOGIN_XPATH));
        btnGoToLogin.click();

        WebElement inputEmail = driver.findElement(By.id(INPUT_EMAIL_ID));
        //entrada de request
        inputEmail.sendKeys(email);

        WebElement inputPassword = driver.findElement(By.id(INPUT_PASSWORD_ID));
        //entrada de request
        inputPassword.sendKeys(password);
        WebElement btnLogin = driver.findElement(By.xpath(BUTTON_LOGIN_XPATH));
        btnLogin.click();
        String currentUrl = driver.getCurrentUrl();
        //captura de salida y validación
        Assertions.assertEquals(loggedUrl, currentUrl);
    }

    /**
     * Caso 2 - parte 1: Login fallido, identifica cuales son las entradas para tu request.
     */
    @Test
    public void TestCase_3(){
        WebElement btnGoToLogin = driver.findElement(By.xpath(BUTTON_GO_TO_LOGIN_XPATH));
        btnGoToLogin.click();

        WebElement inputEmail = driver.findElement(By.id(INPUT_EMAIL_ID));
        //entrada de request
        inputEmail.sendKeys("prueba@prueba.com.uy");

        WebElement inputPassword = driver.findElement(By.id(INPUT_PASSWORD_ID));
        //entrada de request
        inputPassword.sendKeys("123eses");
        WebElement btnLogin = driver.findElement(By.xpath(BUTTON_LOGIN_XPATH));
        btnLogin.click();
    }

    /**
     * Caso 2 - parte 2: Login fallido, captura las salidas y agrega 2 validaciones.
     */
    @Test
    public void TestCase_4(){
        WebElement btnGoToLogin = driver.findElement(By.xpath(BUTTON_GO_TO_LOGIN_XPATH));
        btnGoToLogin.click();

        WebElement inputEmail = driver.findElement(By.id(INPUT_EMAIL_ID));
        //entrada de request
        inputEmail.sendKeys("prueba@prueba.com.uy");

        WebElement inputPassword = driver.findElement(By.id(INPUT_PASSWORD_ID));
        //entrada de request
        inputPassword.sendKeys("123fffrf");
        WebElement btnLogin = driver.findElement(By.xpath(BUTTON_LOGIN_XPATH));
        btnLogin.click();
        String currentUrl = driver.getCurrentUrl();
        //captura de salida y 2 validación
        Assertions.assertEquals(baseUrl, currentUrl);
        Assertions.assertTrue(driver.getPageSource().contains(" Warning: No match for E-Mail Address and/or Password."));

    }


}
