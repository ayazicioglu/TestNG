package tests.practice.NevzatHocaUygulama.pages.IEE;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class OrtakAdimlar {
    public OrtakAdimlar(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//input[@type='text']")
    public WebElement loginEmailKutusu;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement loginPasswordKutusu;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement submitButton;


    public void loginBilgiler(){
        Driver.getDriver().get("https://www.iienstitu.com/en");
        loginEmailKutusu.sendKeys(ConfigReader.getProperty("iienEmail"));
        loginPasswordKutusu.sendKeys(ConfigReader.getProperty("iienPassword"));
        submitButton.click();
    }
}
