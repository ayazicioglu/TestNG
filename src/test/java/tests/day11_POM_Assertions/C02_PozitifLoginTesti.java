package tests.day11_POM_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_PozitifLoginTesti {
    @Test (groups = "smoke")
    public void pozitifLoginTesti() throws InterruptedException {

        //qd anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdURL"));

        //gecerli kullanici adi ve password ile giris yapin
        QdPage qdPage=new QdPage();
        qdPage.ilkLoginButonu.click();
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        qdPage.cookigecmeElement.click();
        Thread.sleep(2000);
        qdPage.loginButonu.click();

        //basarili bir sekilde giris yapildigini test edin
        Assert.assertTrue(qdPage.basariliGirisWebElementi.isDisplayed());

        Driver.closeDriver();

    }
}
