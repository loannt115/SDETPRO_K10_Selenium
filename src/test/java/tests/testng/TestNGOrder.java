package tests.testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.Verifier;

public class TestNGOrder {
    @Test(dependsOnMethods = {"testB"})
    public void testA(){
        System.out.println("test A");
    }

    @Test
    public void testB(){
        System.out.println("test B");
        Assert.assertEquals(1,3, "[ERR] fail...");
    }
    @Test
    public void testC(){
        System.out.println("test C");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(1,3, "[ERR] fail...");
        softAssert.assertEquals(1,1);
        softAssert.assertAll();
        System.out.println("check");
    }
}
