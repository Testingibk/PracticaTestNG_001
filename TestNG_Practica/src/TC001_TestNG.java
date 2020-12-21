/*
1. Setup - Open browser and application
2. Login
3. Close
 */

import org.testng.annotations.Test;

public class TC001_TestNG {

    @Test(priority = 1)
    void setup(){
        System.out.print("Opening browser");
    }

    @Test(priority = 2)
    void login(){
        System.out.print("This is login test");
    }

    @Test(priority = 3)
    void teardowm(){
        System.out.println("Closing browser");
    }

}
