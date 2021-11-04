package Day19;

import org.testng.annotations.*;

public class TestNGAnnotation {


//    @BeforeSuite
//    @AfterSuite
//    @BeforeTest
//    @AfterTest
//    @BeforeGroups
//    @AfterGroups
//    @BeforeClass
//    @AfterClass
//    @BeforeMethod
//    @AfterMethod
 @BeforeSuite(groups={"Smoke","E2E"})
    public void t1(){
     System.out.println("before suite");
 }
    @AfterSuite(groups={"Smoke","E2E"})
    public void t2(){
        System.out.println("After suite");
    }
    @BeforeTest(groups={"Smoke","E2E"})
    public void t3(){
        System.out.println("Before test");
    }
    @AfterTest(groups={"Smoke","E2E"})
    public void t4(){
        System.out.println("After test");
    }
//    @BeforeGroups
//    public void t5(){
//        System.out.println("Before Groups");
//    }
//    @AfterGroups
//    public void t6(){
//        System.out.println("After Groups");
//    }
    @BeforeClass(groups={"E2E"})
    public void t5(){
        System.out.println("Before class");
    }
    @AfterClass(groups={"Smoke","E2E"})
    public void t6(){
        System.out.println("After class");
    }
    @BeforeMethod(groups={"Smoke","E2E"})
    public void t7(){
        System.out.println("Before Method");
    }
    @AfterMethod(groups={"Smoke","E2E"})
    public void t8(){
        System.out.println("After method");
    }

    @BeforeGroups(groups={"Smoke","E2E"})
    public void t11(){
        System.out.println("Before Groups");
    }
    @AfterGroups(groups ={ "Smoke","E2E"})
    public void t12(){
        System.out.println("After groups");
    }





    @Test(priority=1,groups={"Smoke"})
    public void t9(){
        System.out.println("Script 1");
    }
    @Test(priority=2,groups = "E2E")
    public void t10(){
        System.out.println("Script 2");
    }

}
