import org.testng.annotations.*;

public class Prueba01 {

    @BeforeClass
    void beforeClass()
    {
        System.out.println("This will execute before the class");
    }

    @AfterClass
    void afterClass()
    {
        System.out.println("This will execute after the class");
    }

    @BeforeMethod
    void beforeMethod()
    {
        System.out.print("This will execute before every method");
    }

    @AfterMethod
    void afterMethod()
    {
        System.out.println("This will execute after every method");
    }

    @Test
    void test1()
    {
        System.out.print("This is test1...");
    }

    @Test
    void test2()
    {
        System.out.print("This is test2");
    }

    @BeforeTest
    void beforeTest()
    {
        System.out.println("This will execute before the test");
    }
    @AfterTest
    void afterTest()
    {
        System.out.println("This will execute after the test");
    }

}
