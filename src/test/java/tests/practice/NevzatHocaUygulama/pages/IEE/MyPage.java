package tests.practice.NevzatHocaUygulama.pages.IEE;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MyPage {


    public MyPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//*[text()='Eğitimler'])[1]")
    public WebElement egitimlerOnHeaders;




}
