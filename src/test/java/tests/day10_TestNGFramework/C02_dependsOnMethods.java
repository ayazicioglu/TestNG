package tests.day10_TestNGFramework;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_dependsOnMethods {
    /*
    priority öncelik belirler ama testleri birbirine baglamaz

    eger bir test metodunun calismasi baska bir test metoduna bagli ise
    bu durumda dependsOnmethods kullanmak lazımdır

    dependsOnMethods ile baska bir method'a bagli olan bagimsiz calistirmak istersek once bagli oldugu
    method'u calistirir, sonra kendisi calisir
    Ancak bu 2 metot icin gecerlidir, 3 metot calistirmaz (3ubirarada olmaz, 2in1 sever)

    dependsOnMethods bir siralama yontemi DEGILDIR!
       sira bagli olan bir method'a geldiginde,
        oncelikle bagli oldugu method'un calismasini ve PASSED olmasini bekler
        Eger bagli olunan method FAILED olursa
        bagli olan method calistirilmaz, IGNORE edilir

     */
    //3 test metodu olusturun
    //1. amazona gidip amazona gittigimizi test edin
    //2.Nutella aratip sonucun Nutella icerdigini test edin
    //3. ilk urune click yapip, urun isminin Nutella icerdigini test edin
    AmazonPage amazonPage=new AmazonPage();
    @Test()
    public void amazonTesti(){
        Driver.getDriver().get("https://www.amazon.com");
        String actualUrl=Driver.getDriver().getCurrentUrl();
        String expectedIcerik="amazon";
        Assert.assertTrue(actualUrl.contains(expectedIcerik));
    }

    @Test(dependsOnMethods = "amazonTesti")
    public void nutellaTesti(){

        amazonPage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        String expectedIcerik="Nutella";
        String actualSonucYazisi=amazonPage.aramaSonucYaziElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

    }

    @Test(dependsOnMethods = "nutellaTesti")
    public void ilkUrunTesti(){
        amazonPage.ilkUrunElement.click();
        String expectedIcerik="Nutella";
        String actualIsimIcerik=amazonPage.ilkUrunIsimYaziElementi.getText();
        Assert.assertTrue(actualIsimIcerik.contains(expectedIcerik));

        Driver.closeDriver();
    }
}
