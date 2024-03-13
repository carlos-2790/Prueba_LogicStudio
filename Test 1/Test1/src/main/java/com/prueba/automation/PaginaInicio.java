package com.prueba.automation;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginaInicio extends PaginaBase {

    String code = "30076";
    final String INPUT_PROMO_CODE_XPATH = "//*[@id=\"app\"]/div/div[2]/section[1]/div[3]/div[2]/div[4]/div[1]/div/input";
    final String BUTTON_APPLY_CODE_XPATH = "//*[@id=\"app\"]/div/div[2]/section[1]/div[3]/div[2]/div[4]/div[2]/button";
    final String INPUT_DRAG_AND_DROP_XPATH = "//*[@id=\"app\"]/div/div[2]/section[1]/div[3]/div[1]/div/input";
    final String CHECK_I_AGREE_TO_TERMS_AND_CONDITION_XPATH = "//*[@id=\"app\"]/div/div[2]/section[1]/div[3]/div[2]/div[5]/div/label/div";
    final String BUTTON_PAY_NOW = "//*[@id=\"app\"]/div/div[2]/section[1]/div[3]/div[2]/div[7]/div/button";
    final String BUTTON_BOOKED_XPATH = "//*[@id=\"app\"]/div/section[2]/div[4]/div/div/div[1]/div[4]/button";
    final String INPUT_NAME_XPATH = "//*[@id=\"app\"]/div/div[2]/section[1]/div[3]/div[1]/form/div[1]/input";
    final String INPUT_EMAIL_ADDRESS_XPATH = "//*[@id=\"app\"]/div/div[2]/section[1]/div[3]/div[1]/form/div[2]/input";
    final String INPUT_SOCIAL_SECURITY_NUMBER_XPATH = "//*[@id=\"app\"]/div/div[2]/section[1]/div[3]/div[1]/form/div[3]/input";
    final String INPUT_PHONE_NUMBER_XPATH = "//*[@id=\"app\"]/div/div[2]/section[1]/div[3]/div[1]/form/div[4]/input";
    final String INPUT_SELECT_DESTINATION_XPATH = "//*[@id=\"app\"]/div/section[2]/div[3]/div/div/div[1]/div/input";
    final String DESTINATION_LIST_XPATH = "//*[@id=\"app\"]/div/section[2]/div[3]/div/div/div[1]/ul";


    /**
     * Caso de Prueba : Valida que la página tenga el título "Space & Beyond space| Testim.io demo".
     */
    @Test
    public void TestCase_1() {
        String expectedTitle = "Space & Beyond space| Testim.io demo";
        String actualTitle = driver.getTitle();
        Assertions.assertEquals(expectedTitle, actualTitle, "El título de la página no es el esperado. Título actual: " + actualTitle);
    }

    /**
     * Caso de Prueba : Busca que exista un destino al espacio llamado “Madan”.
     */
    @Test
    public void TestCase_2() {

        //envio el nombre del destino
        String destino = "Madan";

        // Localizar el elemento de entrada
        WebElement inputDestino = driver.findElement(By.xpath("//*[@id=\"app\"]/div/section[2]/div[3]/div/div/div[1]/div/input"));
        inputDestino.click();

        //localizo la lista de destinos
        WebElement listaDestinos = driver.findElement(By.xpath("//*[@id=\"app\"]/div/section[2]/div[3]/div/div/div[1]/ul"));

        //recorro la lista y comparo nombres
        List<WebElement> opcionesDestino = listaDestinos.findElements(By.tagName("li"));
        boolean destinoEncontrado = false;
        for (WebElement opcionDestino : opcionesDestino) {
            String nombreDestino = opcionDestino.getText();
            if (nombreDestino.equalsIgnoreCase(destino)) {
                destinoEncontrado = true;
                System.out.println("Destino " + nombreDestino + " encontrado");
                break;
            }
        }
        Assertions.assertTrue(destinoEncontrado, "El destino " + destino + " no fue encontrado en la lista de destinos.");
    }

    /**
     * Caso de Prueba : Selecciona el 28/04/2023 como fecha de salida.
     */
    @Test
    public void TestCase_3() {
        final String INPUT_CALENDAR_XPATH = "//*[@id=\"app\"]/div/section[1]/div[3]/div/div[1]/div/div/input";
        final String SELECT_YEAR_XPATH = "//*[@id=\"years\"]";
        final String SELECT_YEAR_2023_XPATH = "//*[@id=\"2023\"]";
        final String NEXT_MONTH_BUTTON_XPATH = "//*[@id=\"right\"]";
        final String SELECT_DAY_XPATH = "/html/body/div[2]/div/div[2]/section/div/div/div/span/div/div[2]";
        final String BTN_OK_XPATH = "/html/body/div[2]/div/div[2]/nav/button[2]";
        WebElement inputCalendar = driver.findElement(By.xpath(INPUT_CALENDAR_XPATH));
        inputCalendar.click();
        WebElement selectYear = driver.findElement(By.xpath(SELECT_YEAR_XPATH));
        selectYear.click();
        WebElement selectYear2023 = driver.findElement(By.xpath(SELECT_YEAR_2023_XPATH));
        selectYear2023.click();
        WebElement nextMonthButton = driver.findElement(By.xpath(NEXT_MONTH_BUTTON_XPATH));
        nextMonthButton.click();
        WebElement selectDay = driver.findElement(By.xpath(SELECT_DAY_XPATH));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String selectedDate = "28 April 2023";
        WebElement btnOk = driver.findElement(By.xpath(BTN_OK_XPATH));
        btnOk.click();
        String date = inputCalendar.getAttribute("value");
        Assertions.assertEquals(selectedDate, date, "La fecha seleccionada debería ser la misma que la mostrada");
    }

    /**
     * Caso de Prueba :  Elige que el boleto sea para 2 adultos con 1 niño.
     */
    @Test
    public void TestCase_4() {
        final String SELECT_ADULT_XPATH = "//*[@id=\"app\"]/div/section[1]/div[3]/div/div[3]/div/input";
        final String SELECT_CHILD_XPATH = "//*[@id=\"app\"]/div/section[1]/div[3]/div/div[4]/div/input";
        final String SELECT_ADULT_TICKET_XPATH = "//*[@id=\"app\"]/div/section[1]/div[3]/div/div[3]/ul";
        final String SELECT_CHILD_TICKET_XPATH = "//*[@id=\"app\"]/div/section[1]/div[3]/div/div[4]/ul";
        WebElement selectAdult = driver.findElement(By.xpath(SELECT_ADULT_XPATH));
        selectAdult.click();
        WebElement selectAdultTicket = driver.findElement(By.xpath(SELECT_ADULT_TICKET_XPATH));
        List<WebElement> adultTicketQuantity = selectAdultTicket.findElements(By.tagName("li"));
        String number = "2";
        boolean selected = false;
        for (WebElement adultTicketQuantities : adultTicketQuantity) {
            String quantity = adultTicketQuantities.getText();
            if (quantity.equals(number)) {
                adultTicketQuantities.click();
                selected = true;
                String selectAdultTicketQuantity = selectAdult.getAttribute("value");
                System.out.println("Cantidad de ticket seleccionados para adultos: " + selectAdultTicketQuantity);
                break;
            }
        }
        if (!selected) {
            Assertions.fail("No se pudieron seleccionar los ticket para adulto : " + number);
        }
        WebElement selectChild = driver.findElement(By.xpath(SELECT_CHILD_XPATH));
        selectChild.click();
        WebElement selectChildTicket = driver.findElement(By.xpath(SELECT_CHILD_TICKET_XPATH));
        List<WebElement> childTicketQuantity = selectChildTicket.findElements(By.tagName("li"));
        String numbr = "1";
        boolean selectd = false;
        for (WebElement childTicketQuantities : childTicketQuantity) {
            String quantityy = childTicketQuantities.getText();
            if (quantityy.equals(numbr)) {
                childTicketQuantities.click();
                selectd = true;
                String selectChilTicketQuantity = selectChild.getAttribute("value");
                System.out.println("Cantidad de Ticket seleccionados para niño : " + selectChilTicketQuantity);
                break;
            }
        }
        if (!selectd) {
            Assertions.fail("No se pudieron seleccionar los ticket para niño: " + numbr);
        }
    }


    /**
     * En tu destino, filtra por planetas de color azul.
     */
    @Test
    public void TestCase_5() {
        final String SELECT_PLANET_COLOR_XPATH = "//*[@id=\"app\"]/div/section[2]/div[3]/div/div/div[2]/div/input";
        final String SELECT_PLANET_LIST_COLOR_XPATH = "//*[@id=\"app\"]/div/section[2]/div[3]/div/div/div[2]/ul";
        String color = "Blue";
        boolean selected = false;
        WebElement selectPlanetColor = driver.findElement(By.xpath(SELECT_PLANET_COLOR_XPATH));
        selectPlanetColor.click();
        WebElement selectPlanetListColor = driver.findElement(By.xpath(SELECT_PLANET_LIST_COLOR_XPATH));
        List<WebElement> colorOptions = selectPlanetListColor.findElements(By.tagName("li"));
        for (WebElement colorsOptions : colorOptions) {
            String colors = colorsOptions.getText();
            if (colors.equalsIgnoreCase(color)) {
                colorsOptions.click();
                selected = true;
                String ColorBlue = selectPlanetColor.getAttribute("value");
                System.out.println("El color " + ColorBlue + " fue seleccionado");
            }
        }
        if (!selected) {
            Assertions.fail("El color Blue no pudo ser seleccionado");
        }
    }

    /**
     * Tienes 3 destinos disponibles, reserva el planeta Tayabamba (debe estar como booked).
     */
    @Test
    public void TestCase_6() {
        String destination = "Tayabamba";
        boolean selected = false;
        WebElement inputSelectDestination = driver.findElement(By.xpath(INPUT_SELECT_DESTINATION_XPATH));
        inputSelectDestination.click();
        WebElement destinationList = driver.findElement(By.xpath(DESTINATION_LIST_XPATH));
        List<WebElement> destinations = destinationList.findElements(By.tagName("li"));
        for (WebElement destints : destinations) {
            String destino = destints.getText();
            if (destino.equals(destination)) {
                destints.click();
                selected = true;
                String inputDestination = inputSelectDestination.getAttribute("value");
                System.out.println("El destino " + inputDestination + " fue seleccionado");
            }
        }
        if (!selected) {
            Assertions.fail("El destino " + destination + " no pudo ser seleccionado");
        }
        WebElement buttonBooked = driver.findElement(By.xpath(BUTTON_BOOKED_XPATH));
        String btnBooked = buttonBooked.getText();
        if (btnBooked.equalsIgnoreCase("Booked")) {
            System.out.println("El destino esta como :" + btnBooked);
        } else {
            Assertions.fail("El destino no esta como BOOKED : " + btnBooked);
        }
    }

    /**
     * Realiza el checkout, llena todo los datos del formulario.
     * Utiliza los datos:
     * - Social Security number: 111-11-1111
     * - Phone: 2124567890
     */
    @Test
    public void TestCase_7() {
        WebElement buttonBooked = driver.findElement(By.xpath(BUTTON_BOOKED_XPATH));
        buttonBooked.click();
        WebElement inputName = driver.findElement(By.xpath(INPUT_NAME_XPATH));
        WebElement inputEmailAddress = driver.findElement(By.xpath(INPUT_EMAIL_ADDRESS_XPATH));
        WebElement inputSocialSecurityNumber = driver.findElement(By.xpath(INPUT_SOCIAL_SECURITY_NUMBER_XPATH));
        WebElement inputPhoneNumber = driver.findElement(By.xpath(INPUT_PHONE_NUMBER_XPATH));
        inputName.sendKeys("Carlos");
        inputEmailAddress.sendKeys("prueba@prueba.com");
        inputSocialSecurityNumber.sendKeys("111-11-1111");
        inputPhoneNumber.sendKeys("2124567890");
    }

    /**
     * Carga una fotografía de tu carnet de vacunación (puede ser cualquier imagen no
     * necesariamente la real).
     */
    @Test
    public void TestCase_8() {

        File uploadFile = new File("src/main/resources/arbol.png");

        WebElement buttonBooked = driver.findElement(By.xpath(BUTTON_BOOKED_XPATH));
        buttonBooked.click();
        WebElement inputDragAndDrop = driver.findElement(By.xpath(INPUT_DRAG_AND_DROP_XPATH));
        inputDragAndDrop.sendKeys(uploadFile.getAbsolutePath());
    }

    /**
     * Tenemos un código promocional, ingresa el número 30076.
     */
    @Test
    public void TestCase_9() {

        WebElement buttonBooked = driver.findElement(By.xpath(BUTTON_BOOKED_XPATH));
        buttonBooked.click();

        WebElement inputPromoCode = driver.findElement(By.xpath(INPUT_PROMO_CODE_XPATH));
        inputPromoCode.sendKeys(code);

        WebElement btnApplyCode = driver.findElement(By.xpath(BUTTON_APPLY_CODE_XPATH));
        if (btnApplyCode.isEnabled()) {
            btnApplyCode.click();
            String codePromo = inputPromoCode.getAttribute("value");
            System.out.println("El codigo: " + codePromo + " fué ingresado correctamente");
        } else {
            Assertions.fail("El boton no es clickeable, no se puede aplicar el cupón");
        }
    }

    /**
     * Finalmente realizar el pago.
     */
    @Test
    public void TestCase_10() {
        WebElement buttonBooked = driver.findElement(By.xpath(BUTTON_BOOKED_XPATH));
        buttonBooked.click();
        WebElement inputName = driver.findElement(By.xpath(INPUT_NAME_XPATH));
        WebElement inputEmailAddress = driver.findElement(By.xpath(INPUT_EMAIL_ADDRESS_XPATH));
        WebElement inputSocialSecurityNumber = driver.findElement(By.xpath(INPUT_SOCIAL_SECURITY_NUMBER_XPATH));
        WebElement inputPhoneNumber = driver.findElement(By.xpath(INPUT_PHONE_NUMBER_XPATH));
        inputName.sendKeys("Carlos");
        inputEmailAddress.sendKeys("prueba@prueba.com");
        inputSocialSecurityNumber.sendKeys("111-11-1111");
        inputPhoneNumber.sendKeys("2124567890");
        File uploadFile = new File("src/main/resources/arbol.png");
        WebElement inputDragAndDrop = driver.findElement(By.xpath(INPUT_DRAG_AND_DROP_XPATH));
        inputDragAndDrop.sendKeys(uploadFile.getAbsolutePath());
        WebElement inputPromoCode = driver.findElement(By.xpath(INPUT_PROMO_CODE_XPATH));
        inputPromoCode.sendKeys(code);
        WebElement btnApplyCode = driver.findElement(By.xpath(BUTTON_APPLY_CODE_XPATH));
        if (btnApplyCode.isEnabled()) {
            btnApplyCode.click();
            String codePromo = inputPromoCode.getAttribute("value");
            System.out.println("El codigo: " + codePromo + " fué ingresado correctamnte");
        } else {
            Assertions.fail("El boton no es clickeable, no se puede aplicar el cupón");
        }
        WebElement checkIAgreeToTermsAndCondition = driver.findElement(By.xpath(CHECK_I_AGREE_TO_TERMS_AND_CONDITION_XPATH));
        checkIAgreeToTermsAndCondition.click();
        WebElement btnPayNow = driver.findElement(By.xpath(BUTTON_PAY_NOW));
        if (btnPayNow.isEnabled()) {
            btnPayNow.click();
            System.out.println("Se realizo la compra");
        } else {
            Assertions.fail("El botón Pay Now no es clickeable");
        }


    }

}


