package tests.practice.NevzatHocaUygulama.Tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.practice.NevzatHocaUygulama.pages.IEE.*;
import utilities.ConfigReader;
import utilities.Driver;

public class Test1 {

    UdemyHomePage udemyHomePage=new UdemyHomePage();
    LoginPage loginPage=new LoginPage();
    MyPage myPage=new MyPage();
    OnlineEgitimlerPage onlineEgitimlerPage=new OnlineEgitimlerPage();
    @Test
    public void test01(){

        // Kullanici https://www.iienstitu.com/en sayfasina gider
        Driver.getDriver().get("https://www.iienstitu.com/en");

        // Login butonuna tiklar
        udemyHomePage.loginButtonHomePage.click();

        // Giris bilgilerini girer ve basarili sekilde giris yaptigini test eder

        loginPage.loginEmailKutusu.sendKeys(ConfigReader.getProperty("iienEmail"));
        loginPage.loginPasswordKutusu.sendKeys(ConfigReader.getProperty("iienPassword"));
        loginPage.submitButton.click();

        // headers da bulunan egitimler kismina tiklar

        myPage.egitimlerOnHeaders.click();

        // acilan egitimler sayfasindan fiyat araligi olarak artan fiyat olarak secer

        Select select=new Select(onlineEgitimlerPage.ddmEgitimler);
        select.selectByVisibleText("Artan fiyat");

        // ucretsiz egitimlerden herhangi birini alir
        onlineEgitimlerPage.lessonStresYonetimEgitimi.click();
        onlineEgitimlerPage.hemenBaslaButton.click();

        // kimlik dogrulama islemlerini girer
        KimlikDogrulama kimlikDogrulama=new KimlikDogrulama();
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(kimlikDogrulama.kimlikDogrulamMail, ConfigReader.getProperty("iienEmail")).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("nevzat").sendKeys(Keys.TAB).
                sendKeys("celik").sendKeys(Keys.TAB).
                sendKeys("varsova").sendKeys(Keys.TAB).
                sendKeys("15600").sendKeys(Keys.TAB).
                sendKeys("Varsova").sendKeys(Keys.TAB).
                sendKeys("11111111111").sendKeys(Keys.TAB).perform();
        kimlikDogrulama.kimlikDogrulamaOdemeyeGec.click();

        // egitimin ucretsiz oldugunu test eder ve siparisi tamamlar
        Assert.assertTrue( kimlikDogrulama.ucretsizEgitimCheck.isDisplayed());

        // Kullanici profil kismindan dersi basarili bir sekilde kaydedildigini test eder


    }

    @Test
    public void stresYonetimiKontrol(){
        Driver.getDriver().get("https://www.iienstitu.com/en");
        udemyHomePage.loginButtonHomePage.click();

    }
}
