package practice;

import org.junit.*;

public class Q6 {
    @BeforeClass
    public static void setup(){
        System.out.println("BeforeClass");
    }
    @AfterClass
    public static void tearDown(){
        System.out.println("AfterClass");
    }
    @Before
    public  void before(){
        System.out.println("Before");
    }
   @After
    public  void after(){
        System.out.println("Before");
    }
    @Test
    public void tugba(){
        System.out.println("Tugba");
    }
    @Test
    public void fidan(){
        System.out.println("Fidan");
    }


}
