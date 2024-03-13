package com.prueba.automation;

import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class PaginaBase {

    protected WebDriver driver;
    protected final String baseUrl ="https://demo.testim.io/";

    @BeforeEach
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown(){
        //se ccierra despues de cada caso de prueba
        if (driver != null){
            driver.quit();
        }
    }


}
