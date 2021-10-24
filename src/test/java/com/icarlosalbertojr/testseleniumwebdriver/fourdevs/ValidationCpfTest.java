package com.icarlosalbertojr.testseleniumwebdriver.fourdevs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationCpfTest extends Abstract4DevsTest {

    @DisplayName("Validation CPF Test - is Valid")
    @Test
    public void isValid() throws InterruptedException {
        String validCPF = "689.783.530-70";
        String expectedValidResult = validCPF + " - Verdadeiro";
        execute(validCPF, expectedValidResult);
    }

    @DisplayName("Validation CPF Test - is Invalid")
    @Test
    public void isInvalid() throws InterruptedException {
        String invalidCPF = "689.783.539-70";
        String expectedInvalidResult = invalidCPF + " - Falso";
        execute(invalidCPF, expectedInvalidResult);
    }

    private void execute(String cpf, String expectedResult) throws InterruptedException {
        goToHomePage();
        goToValidationPage();
        insertCpf(cpf);
        clickValidationCpf();
        Thread.sleep(500);
        String result = getResult();
        assertEquals(expectedResult, result);
    }

    private void goToValidationPage() {
        findElementByXPath("/html/body/main/div/div[1]/ul/li[35]/a").click();
    }

    private void insertCpf(String cpf) {
        findElementByXPath("//*[@id=\"txt_cpf\"]").sendKeys(cpf);
    }

    private void clickValidationCpf() {
        findElementByXPath("//*[@id=\"bt_validar_cpf\"]").click();
    }

    private String getResult() {
        return findElementByXPath("//*[@id=\"texto_resposta\"]").getAttribute("value");
    }

}
