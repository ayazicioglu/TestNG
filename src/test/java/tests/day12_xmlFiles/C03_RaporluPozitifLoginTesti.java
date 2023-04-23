package tests.day12_xmlFiles;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_RaporluPozitifLoginTesti extends TestBaseRapor {
    @Test
    public void pozitifLoginTesti() throws InterruptedException {
        extentTest=extentReports.createTest("Pozitif login testi","gecerli bilgilerle giris yapılabilmeli");

        //qd anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdURL"));
        extentTest.info("Qualitydemy anasayfaya gidildi");

        //gecerli kullanici adi ve password ile giris yapin
        QdPage qdPage=new QdPage();
        qdPage.ilkLoginButonu.click();
        extentTest.info("ilk login linkine tiklandi");
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        extentTest.info("Gecerli email yazildi");
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        extentTest.info("Gecerli sifre yazildi");
        qdPage.cookigecmeElement.click();
        extentTest.info("login butonuna tiklandi");
        Thread.sleep(2000);
        qdPage.loginButonu.click();

        //basarili bir sekilde giris yapildigini test edin
        Assert.assertTrue(qdPage.basariliGirisWebElementi.isDisplayed());
        extentTest.pass("Basarili sekilde giris yapildigi test edildi");


    }
}
