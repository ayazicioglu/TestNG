package tests.practice.NevzatHocaUygulama.Tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.practice.NevzatHocaUygulama.pages.Quality.QualityPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class qualityTest {

    QualityPage qualityPage=new QualityPage();

    // Kullanici https://qualitydemy .com/ sayfasina gider
    // Siteye basarili bir sekilde giris yapar
    // sag taraf bulunan kullanici menusunden User Profile kismina gider
    // FirstName,Lastname,Biography, ve Linklerin kendine ait oldugunu dogrular
    // Bu kutucuklarda degisiklik yaparak kaydeder degisiklikleri dogrular

    @Test
    public void qualityProfileTest(){
        // Kullanici https://qualitydemy .com/ sayfasina gider
        // Siteye basarili bir sekilde giris yapar
        Driver.getDriver().get(ConfigReader.getProperty("qualityUrl"));
        qualityPage.loginMethodu();

        // sag taraf bulunan kullanici menusunden User Profile kismina gider
        ReusableMethods.bekle(8);
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(qualityPage.kullaniciLogo).click(qualityPage.userProfile).build().perform();

        // FirstName,Lastname,Biography, ve Linklerin kendine ait oldugunu dogrular
        SoftAssert softAssert=new SoftAssert();

        // FirstName
        String actualFirstName=qualityPage.profileFirstNameBox.getAttribute("value");
        softAssert.assertTrue(actualFirstName.contains("nevzat"));

        // Lastname
        String actualLastName=qualityPage.profileLastNameBox.getAttribute("value");
        softAssert.assertTrue(actualLastName.contains("celik"));

        //Biography
        Driver.getDriver().switchTo().frame(qualityPage.iframeBiography);
        String biography=qualityPage.biographyBox.getText();
        softAssert.assertTrue(biography.contains("wisequarter"));
        Driver.getDriver().switchTo().defaultContent();

        // Bu kutucuklarda degisiklik yaparak kaydeder degisiklikleri dogrular
        qualityPage.profileFirstNameBox.clear();
        qualityPage.profileFirstNameBox.sendKeys("ahmet");
        qualityPage.profileLastNameBox.clear();
        qualityPage.profileLastNameBox.sendKeys("yazicioglu");
        Driver.getDriver().switchTo().frame(qualityPage.iframeBiography);
        qualityPage.biographyBox.clear();
        qualityPage.biographyBox.sendKeys("amazon");
        Driver.getDriver().switchTo().parentFrame();
        actions.sendKeys(Keys.END).perform();
        ReusableMethods.bekle(2);
        actions.click(qualityPage.saveButon).build().perform();


        softAssert.assertTrue(qualityPage.profileFirstNameBox.getText().contains("ahmet"));
        softAssert.assertTrue(qualityPage.profileLastNameBox.getText().contains("yazicioglu"));
        softAssert.assertTrue(qualityPage.iframeBiography.getText().contains("amazon"));

        softAssert.assertAll();


    }
}
