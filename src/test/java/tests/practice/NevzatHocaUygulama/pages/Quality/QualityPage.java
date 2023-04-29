package tests.practice.NevzatHocaUygulama.pages.Quality;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class QualityPage {


    public QualityPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Accept']")
    public WebElement cookies;

    @FindBy(xpath = "//*[text()='Log in']")
    public WebElement loginButon;

    @FindBy(id = "login-email")
    public WebElement emailBox;

    @FindBy(id = "login-password")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginKayitButton;

    @FindBy(xpath = "(//img[@class='img-fluid'])[1]")
    public WebElement kullaniciLogo;

    @FindBy(xpath = "(//li[@class='user-dropdown-menu-item'])[5]")
    public WebElement userProfile;

    @FindBy(id = "FristName")
    public WebElement profileFirstNameBox;

    @FindBy(xpath = "//*[@name='last_name']")
    public WebElement profileLastNameBox;

    @FindBy(id = "Biography_ifr")
    public WebElement iframeBiography;

    @FindBy(id = "tinymce")
    public WebElement biographyBox;

    @FindBy(name = "twitter_link")
    public WebElement twitterLink;

    @FindBy(xpath = "//*[text()='Save']")
    public WebElement saveButon;


    public void providerMethod(String mail, String password){
        if (cookies.isDisplayed()){
            cookies.click();
        }
        loginButon.click();
        emailBox.sendKeys(mail);
        passwordBox.sendKeys(password);
        loginButon.click();
    }

    public void loginMethodu(){ //değerlleri configden alabilirdik de yazmış olduk
        cookies.click();
        loginButon.click();
        emailBox.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        passwordBox.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        loginKayitButton.click();
    }


}
