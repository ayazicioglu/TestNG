package tests.practice.NevzatHocaUygulama.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QdPage;
import tests.practice.NevzatHocaUygulama.pages.Quality.QualityPage;
import utilities.ConfigReader;
import utilities.Driver;

public class dataProvider {

    QualityPage qualityPage=new QualityPage();
    @DataProvider
    public static Object [][] gonderilecekMail(){
        Object [][] gonderilecekMailvePassword={{"nevzat","1234"},
                {"nevzat@hotmail.com","123456"},
                {"ahmet@hotmail.com","ahmet123124"},
                {"kalamar@kalamar.com","kalamar"},
                {"anevzatcelik@gmail.com","Nevzat152032"}};
        return gonderilecekMailvePassword;
    }

    @Test(dataProvider = "gonderilecekMail")
    public void qualityTest(String mail,String password){
        Driver.getDriver().get(ConfigReader.getProperty("qualityUrl"));
        qualityPage.providerMethod(mail,password);
    }

    @Test
    public void dersEklemeTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("qualityUrl"));
        qualityPage.loginMethodu();
    }

}
