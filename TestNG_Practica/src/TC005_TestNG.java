import org.testng.Assert;
import org.testng.annotations.Test;

public class TC005_TestNG {
    //Dependencias entre tests

    @Test
    void startCar()
    {
        System.out.print("Car started");
        Assert.fail();
    }

    //Este método depende del método startCar
    @Test(dependsOnMethods = {"startCar"})
    void driveCar()
    {
        System.out.print("Car driving");
    }

    //Este método depende del método driveCar
    @Test(dependsOnMethods = {"driveCar"})
    void stopCar()
    {
        System.out.print("Car stopped");
    }

    //También se puede hacer multidependencia
    @Test(dependsOnMethods = {"driveCar", "stopCar"}, alwaysRun = true)
    void parkCar()
    {
        System.out.print("Car parked");
    }

}
