package com.icarlosalbertojr.testseleniumwebdriver.fourdevs;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GenerateCpfTest extends Abstract4DevsTest {

    public static final String EXEPECTED_PAGE_TITLE = "Gerador de CPF";

    @DisplayName("Generate CPF Test")
    @Test
    public void execute() throws InterruptedException {
        goToGeneratorPage();
        String pageHeaderTitle = getPageHeaderTitle();
        assertEquals(EXEPECTED_PAGE_TITLE, pageHeaderTitle);
        clickGenerateCPF();
        Thread.sleep(500);
        String generatedCPF = getGeneratedCPF();
        assertNotNull(generatedCPF);
    }

    private String getGeneratedCPF() {
        return findElementByXPath("//*[@id=\"texto_cpf\"]").getText();
    }

    private String getPageHeaderTitle() {
        return findElementByXPath("/html/body/main/div/div[2]/div/div[4]/div[1]/div[1]/h1").getText();
    }

    private void goToGeneratorPage() {
        findElementByXPath("//*[@id=\"top-nav\"]/li[6]/a").click();
    }

    private void clickGenerateCPF() {
        findElementByXPath("//*[@id=\"bt_gerar_cpf\"]").click();
    }
}
