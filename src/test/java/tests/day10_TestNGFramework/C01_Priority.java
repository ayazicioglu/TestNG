package tests.day10_TestNGFramework;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C01_Priority {
    /*
    TestNG test metotlarını calistirirken standart olarak harf siralamasına bakar
    Ancak TestNG siralamayi bizim kontrol etmemize olanak tanir

    istedigimiz test metoduna istedigimiz önceliigi priority ile tanımlayabilliriz
    Selenium test methodlarini priority'si kucukten buyuge olacak sekilde calistirir

    priority degeri aynı olan methodlari harf sirasına göre calistirir

    priority degeri yazilmazsa default olarak priority=0 kabul edilir
     */


    @Test(priority = 20)
    public void amazonTesti(){
        //Amazon anasayfaya gidip, amazona gittiğimizi test edelim
        Driver.getDriver().get("https://www.amazon.com");

        //url amazon iceriyor mu test edelim
        String expectedIcerik="amazon";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        Driver.closeDriver();
    }

    @Test(priority =30 )
    public void wiseTesti(){
        //wisequarter anasayfaya gidip, wisequartera gittiğimizi test edelim
        Driver.getDriver().get("https://www.wisequarter.com");

        //url amazon iceriyor mu test edelim
        String expectedIcerik="wisequarter";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        Driver.closeDriver();
    }

    @Test(priority =50 )
    public void youtubeTesti(){
        //youtube anasayfaya gidip, youtubea gittiğimizi test edelim
        Driver.getDriver().get("https://www.youtube.com");

        //url amazon iceriyor mu test edelim
        String expectedIcerik="youtube";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        Driver.closeDriver();
    }
}
