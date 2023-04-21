package tests.day10_TestNGFramework;

import org.testng.annotations.*;

public class C03_BeforeAfterNotasyonlari {
    /*
        Smoke Test
        Regression Test
        EndToEnd (E2E)
        Test Suite : Birden fazla Test'in bir amac icin biraraya getirilmesidir
        Test : Bir amac icin bir araya getirilmis test method'lari, class'lari
               ve/veya package'lari icerir
        Test Hiyerarsisi :
            - Suite
            - Test
            - groups, packages, classes, methods
     */

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod");
    }

    @Test
    public void test01(){
        System.out.println("test01");
    }
    @Test
    public void test02(){
        System.out.println("test02");
    }
    @Test
    public void test03(){
        System.out.println("test03");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("AfterTest");
    }
    @AfterClass (groups = "smoke")
    public void afterClass(){
        System.out.println("AfterClass");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("AfterMethod");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite");
    }
}
