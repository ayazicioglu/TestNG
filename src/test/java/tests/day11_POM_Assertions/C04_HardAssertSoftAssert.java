package tests.day11_POM_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C04_HardAssertSoftAssert {

    @Test
    public void hardAssertionTesti(){
        Assert.assertTrue(5>8);
        Assert.assertFalse(8==8);
        Assert.assertEquals(5,9);
        Assert.assertNotEquals(6,6);
    }
    @Test
    public void softAssertionTesti(){
        SoftAssert softAssert=new SoftAssert();

        softAssert.assertTrue(5>8,"true testi failed");
        softAssert.assertFalse(8==8,"false testi failed");
        softAssert.assertEquals(5,9,"equals testi failed");
        softAssert.assertNotEquals(6,6,"not equals testi failed");


        softAssert.assertAll();
    }
}
