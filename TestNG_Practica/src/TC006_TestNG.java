import org.testng.annotations.Test;

public class TC006_TestNG {

    @Test(groups = {"sanity"})
    void test1()
    {
        System.out.println("This is test1...");
    }

    @Test(groups = {"sanity"})
    void test2()
    {
        System.out.println("This is test2...");
    }
    @Test(groups = {"regression"})
    void test3()
    {
        System.out.println("This is test3...");
    }

    @Test(groups = {"regression"})
    void test4()
    {
        System.out.println("This is test4...");
    }

    @Test(groups = {"sanity", "regression"})
    void test5()
    {
        System.out.println("This is test5...");
    }

    @Test(groups = {"possitive"})
    void test6()
    {
        System.out.println("This is test6...");
    }

    @Test(groups = {"possitive"})
    void test7()
    {
        System.out.println("This is test7...");
    }

    @Test(groups = {"sanity", "regression", "possitive"})
    void test8()
    {
        System.out.println("This is test8...");
    }

}
