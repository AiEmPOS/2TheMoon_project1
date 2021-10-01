import org.junit.jupiter.api.*;
import processing.core.PVector;
import project_16x16.SideScroller;
import project_16x16.entities.CleanerRobot;
import java.lang.reflect.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CleanerRobotTest {
    private static SideScroller Temp_SideScroller;
    private static CleanerRobot Temp_CleanerRobot;
    Class CleanerRobotClass;
    @BeforeAll
    void setup() {
        Temp_SideScroller = new SideScroller();
        Temp_CleanerRobot = new CleanerRobot(Temp_SideScroller);
        CleanerRobotClass = CleanerRobot.class;
    }

    @Test
    void TestGetDistance_1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method getDistanceMethod = CleanerRobotClass.getDeclaredMethod("getDistance",PVector.class,PVector.class);
        PVector data_1 = new PVector(20,30);
        PVector data_2 = new PVector(10,10);
        getDistanceMethod.setAccessible(true);
        Assertions.assertEquals(22.36,(double) Math.round((double) getDistanceMethod.invoke(Temp_CleanerRobot,data_1,data_2) * 100) / 100);
    }

}
