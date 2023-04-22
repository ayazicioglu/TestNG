package tests.day11_POM_Assertions;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C05_softAssert {


    @Test(groups = {"mr1","mr2"})
    public void amazonTesti(){
       /*
       Genel olarak
       test edin denirse hard assert
       dogrulayin (verify) denirse soft assert

        */

        //amazon anasayfaya gidip, doğru sayfaya gittiğimizi DOĞRULAYIN (verify)
        Driver.getDriver().get(ConfigReader.getProperty("amazonURL"));
        String expectedIcerik="amazon";
        String actualURL=Driver.getDriver().getCurrentUrl();

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(actualURL.contains(expectedIcerik),"amazon url testi filed");

        //Nutella icin arama yapip, sonuclarin nutella icerdigini dogrulayin
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonAranacakKelime")+ Keys.ENTER);
        expectedIcerik="Nutella";
        String actualAramaSonucYazisi=amazonPage.aramaSonucYaziElementi.getText();
        softAssert.assertTrue(actualAramaSonucYazisi.contains(expectedIcerik),"nutella arama testi failed");


        //ilk urune tiklayip, urun isminde nutella gectiğini dogrulayin
        amazonPage.ilkUrunElement.click();
        expectedIcerik="Nutella";
        String actualSonuc=amazonPage.ilkUrunIsimYaziElementi.getText();
        softAssert.assertTrue(actualSonuc.contains(expectedIcerik),"ilk urun tiklama failed");


        softAssert.assertAll();
        Driver.closeDriver();
    }
}
