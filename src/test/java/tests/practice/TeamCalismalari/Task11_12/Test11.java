package tests.practice.TeamCalismalari.Task11_12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.List;

public class Test11 {

    @Test
    public void test11(){
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

        //13) Now click on Remove this icon in Check out page which removes that book from the grid.
        WebElement removeElement=Driver.getDriver().findElement(By.xpath("//*[@title='Remove this item']"));
        removeElement.click();

        //14) User has the feasibility to remove the book at the time of check out also
        WebElement itemPriceElement2=Driver.getDriver().findElement(By.xpath("//*[@title='View your shopping cart']"));
        Assert.assertTrue(itemPriceElement2.isDisplayed());

        Driver.closeDriver();
    }
}
