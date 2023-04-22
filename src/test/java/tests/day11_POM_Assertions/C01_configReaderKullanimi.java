package tests.day11_POM_Assertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_configReaderKullanimi {
    @Test
    public void test01(){
        //amazon anasayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonURL"));

        //Test datasi olarak verilen kelime icin arama yapalim
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonAranacakKelime")+ Keys.ENTER);

        //arama sonuclarinin Nutella icerdigini test edelim
        String actualSonuc=amazonPage.aramaSonucYaziElementi.getText();
        String expectedSonuc=ConfigReader.getProperty("amazonAranacakKelime");
        Assert.assertTrue(actualSonuc.contains(expectedSonuc));

        Driver.closeDriver();
    }
}
