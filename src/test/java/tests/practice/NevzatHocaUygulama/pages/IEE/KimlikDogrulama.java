package tests.practice.NevzatHocaUygulama.pages.IEE;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class KimlikDogrulama {

    public KimlikDogrulama(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//input[@id='email']")
    public WebElement kimlikDogrulamMail;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement kimlikDogrulamaOdemeyeGec;

    @FindBy(xpath = "// egitimin ucretsiz oldugunu test eder ve siparisi tamamlar")
    public WebElement ucretsizEgitimCheck;

    @FindBy(xpath = "//*[text()='Siparişi tamamla']")
    public WebElement siparisiTamamlaButton;
}
