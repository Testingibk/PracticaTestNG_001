import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002_TestNG {

    @Test(priority = 1)
    void setup() {
        System.out.print("Opening browser");
    }

    @Test(priority = 3)
    void searchCustomer() {
        System.out.print("This is search customer test");
        Assert.assertEquals(1,1);
    }

    @Test(priority = 2)
    void addCustomer() {
        System.out.print("This is add customer test");
    }

    @Test(priority = 4)
    void teardowm() {
        System.out.println("Closing browser");
    }

}
