import org.testng.annotations.Test;

public class TC004_TestNG {

    @Test(priority = 0)
    void TestOne() {
        System.out.println("This is Test_01");

    }

    @Test(priority = 1)
    void TestTwo() {
        System.out.println("This is Test_02");
    }

    @Test(priority = 2)
    void TestThree() {
        System.out.println("This is Test_03");
    }

    //De esta manera hacemos que el test 4 no se ejecute
    @Test(priority = 3,enabled = false)
    void TestFour() {
        System.out.println("This is Test_04");
    }


}
