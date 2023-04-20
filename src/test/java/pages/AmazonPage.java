package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {

    /*
      Pages class'lari surekli kullandigimiz locate'leri tekrar tekrar locate etmek zorunda kalmaktan
    kurtulmak icin kullanillir

      Her pages class'i driver class'inda olusturulan driver'i kullanir

      @FindBy notasyonunun Driver'i class'indaki webDriver'i kullanabilmesi icin
      bu class'a tanitmamiz gerekir

      Bunun icin her pages sayfasi ilk olusturuldugunda basina parametresiz bir
      constructor olusturup icerisine driver'i bu class'ta tanitiyoruz
     */

    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="twotabsearchtextbox")
    public WebElement aramaKutusu;

    @FindBy(xpath="//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")
    public WebElement aramaSonucYaziElementi;

    @FindBy(xpath = "(//img[@class='s-image'])[1]")
    public WebElement ilkUrunElement;

    @FindBy(xpath = "//span[@id='productTitle']")
    public WebElement ilkUrunIsimYaziElementi;


}
