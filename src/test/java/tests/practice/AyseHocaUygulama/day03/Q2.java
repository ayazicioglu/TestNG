package tests.practice.AyseHocaUygulama.day03;

import org.testng.annotations.Test;

public class Q2 {
    /*
    > TestNG default olarak @Test methodlarini alfabetik siraya gore run eder,
    yukaridan asagiya dogru degil.
    > priority annotation testlere oncelik vermek icin kullanilir,
     kucuk olan numara daha once calisir.
    > priority : TestNG testlerinde , testler konsola alfabetik sira ile yazdirilir.
    > priority default degeri sifirdir.
    > enabled = false methodu : Testi gormezden gelmek icin @Test 'in yanina yazilir.
     */
    @Test (priority = 10)
    public void b(){
        System.out.println("b");
    }
    @Test(enabled = false)
    public void d(){
        System.out.println("d");
    }
    @Test (priority = -10)
    public void c(){
        System.out.println("c");
    }
    @Test (dependsOnMethods = "b")
    public void e(){
        System.out.println("e");
    }
    @Test (dependsOnMethods = "b")
    public void a(){
        System.out.println("a");
    }
    @Test (dependsOnMethods = "c")
    public void f(){
        System.out.println("f");
    }
    @Test
    public void g(){
        System.out.println("g");
    }
}
