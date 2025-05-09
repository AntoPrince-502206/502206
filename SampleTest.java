import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Medol
 */
public class SampleTest {
   
    public SampleTest() {
        // Constructor should not contain test methods
    }
   
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Before Class");
    }
   
    @AfterClass
    public static void tearDownClass() {
        System.out.println("After Class");
    }
   
    @Before
    public void setUp() {
        System.out.println("Before each test");
    }
   
    @After
    public void tearDown() {
        System.out.println("After each test");
    }

    // ✅ Test methods should be outside the constructor
    @Test
    public void testAddition() {
        int result = 2 + 3;
        assertEquals(5, result);
    }

    @Test
    public void testString() {
        String str = "Hello, NetBeans!";
        assertNotNull(str);
    }
}




https://github.com/mgsgoms/helloworld-java-maven
