package tests.practice.TeamCalismalari.Task11_12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class Test12 {
    @Test
    public void test12(){
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get("http://practice.automationtesting.in/");

        //3) Click on Shop Menu
        WebElement shopMenuElement=Driver.getDriver().findElement(By.linkText("Shop"));
        shopMenuElement.click();

        //4) Now click on Home menu button
        Driver.getDriver().navigate().back();
        Driver.getDriver().navigate().forward();
        WebElement homeButtonElement=Driver.getDriver().findElement(By.linkText("Home"));
        homeButtonElement.click();

        //5) Test whether the Home page has Three Arrivals only
        List<WebElement> arrivalElements=Driver.getDriver().findElements(By.className("woocommerce-LoopProduct-link"));
        Assert.assertEquals(arrivalElements.size(), 3);

        //6) The Home page must contains only three Arrivals
        //7) Now click the image in the Arrivals
        Driver.getDriver().findElement(By.xpath("(//*[@class='woocommerce-LoopProduct-link'])[1]")).click();
        Driver.getDriver().navigate().back();
        Driver.getDriver().findElement(By.xpath("(//*[@class='woocommerce-LoopProduct-link'])[2]")).click();
        Driver.getDriver().navigate().back();
        Driver.getDriver().findElement(By.xpath("(//*[@class='woocommerce-LoopProduct-link'])[3]")).click();

        //8) Test whether it is navigating to next page where the user can add that book into his basket.
        //9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
        Assert.assertTrue(Driver.getDriver().findElement(By.tagName("h1")).isDisplayed());
        WebElement addToBasketElement=Driver.getDriver().findElement(By.xpath("//*[text()='Add to basket']"));
        Assert.assertTrue(addToBasketElement.isEnabled());

        //10) Click on the Add To Basket button which adds that book to your basket
        addToBasketElement.click();

        //11) User can view that Book in the Menu item with price.
        WebElement itemPriceElement=Driver.getDriver().findElement(By.xpath("//*[@title='View your shopping cart']"));
        Assert.assertTrue(itemPriceElement.isDisplayed());

        //12) Now click on Item link which navigates to proceed to check out page.
        itemPriceElement.click();

        //13) Click on textbox value under quantity in Check out page to add or subtract books.
        Driver.getDriver().findElement(By.xpath("//*[@inputmode='numeric']")).click();

        //14) Now after the above change ‘Update Basket’ button will turn into Clickable mode.
        WebElement qTyElement=Driver.getDriver().findElement(By.xpath("//input[@title='Qty']"));
        qTyElement.click();
        qTyElement.sendKeys(Keys.ARROW_UP);
        WebElement updateBasketElement=Driver.getDriver().findElement(By.xpath("//*[@value='Update Basket']"));
        Assert.assertTrue(updateBasketElement.isEnabled());

        //15) Now click on Update Basket to reflect those changes
        updateBasketElement.click();

        //16) User has the feasibility to Update Basket at the time of check out.
        updateBasketElement.sendKeys(Keys.END);
        ReusableMethods.bekle(2);
        Driver.getDriver().findElement(By.xpath("//a[@class='checkout-button button alt wc-forward']")).click();
        WebElement itemPriceElement2=Driver.getDriver().findElement(By.xpath("//*[@title='View your shopping cart']"));
        Assert.assertTrue(itemPriceElement2.isEnabled());
        Driver.closeDriver();
    }
}
