import org.junit.jupiter.api.*;
import processing.core.PVector;
import project_16x16.SideScroller;
import project_16x16.entities.CleanerRobot;
import project_16x16.scene.GameplayScene;
import static org.mockito.Mockito.mock;

import java.lang.reflect.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CleanerRobotTest {
    private final SideScroller Temp_SideScroller = mock(SideScroller.class);
    private CleanerRobot Temp_CleanerRobot;
    private final GameplayScene Temp_GameplayScene = mock(GameplayScene.class);
    Class CleanerRobotClass;
    @BeforeAll
    void setup() {
        Temp_CleanerRobot = new CleanerRobot(Temp_SideScroller,Temp_GameplayScene);
        CleanerRobotClass = CleanerRobot.class;
    }

    @Test
    void TestGetDistance() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method getDistanceMethod = CleanerRobotClass.getDeclaredMethod("getDistance",PVector.class,PVector.class);
        getDistanceMethod.setAccessible(true);

        // < 0, < 0, < 0, < 0
        PVector data_1 = new PVector(2,3);
        PVector data_2 = new PVector(3,2);
        Assertions.assertEquals(1.41,(double) Math.round((double) getDistanceMethod.invoke(Temp_CleanerRobot,data_1,data_2) * 100) / 100);
        System.out.println("Test Case 1 Passed");

        // 0, 0, 0, < 0
        data_1.x = 0;
        data_1.y = 0;
        data_2.x = 0;
        data_2.y = -1;
        Assertions.assertEquals(1.0,(double) Math.round((double) getDistanceMethod.invoke(Temp_CleanerRobot,data_1,data_2) * 100) / 100);
        System.out.println("Test Case 2 Passed");

        // 0 >, 0 >, 0 >, < 0
        data_1.x = 10;
        data_1.y = 12;
        data_2.x = 25;
        data_2.y = -7;
        Assertions.assertEquals(24.21,(double) Math.round((double) getDistanceMethod.invoke(Temp_CleanerRobot,data_1,data_2) * 100) / 100);
        System.out.println("Test Case 3 Passed");

        // 0 >, 0, < 0, 0
        data_1.x = 64;
        data_1.y = 0;
        data_2.x = -55;
        data_2.y = 0;
        Assertions.assertEquals(119.0,(double) Math.round((double) getDistanceMethod.invoke(Temp_CleanerRobot,data_1,data_2) * 100) / 100);
        System.out.println("Test Case 4 Passed");

        // 0, < 0, 0 >, 0
        data_1.x = 0;
        data_1.y = -24;
        data_2.x = 24;
        data_2.y = 0;
        Assertions.assertEquals(33.94,(double) Math.round((double) getDistanceMethod.invoke(Temp_CleanerRobot,data_1,data_2) * 100) / 100);
        System.out.println("Test Case 5 Passed");

        // < 0, 0 >, 0, 0
        data_1.x = -32;
        data_1.y = 47;
        data_2.x = 0;
        data_2.y = 0;
        Assertions.assertEquals(56.86,(double) Math.round((double) getDistanceMethod.invoke(Temp_CleanerRobot,data_1,data_2) * 100) / 100);
        System.out.println("Test Case 6 Passed");

        // < 0, 0, 0 >, 0 >
        data_1.x = -6;
        data_1.y = 0;
        data_2.x = 59;
        data_2.y = 32;
        Assertions.assertEquals(72.45,(double) Math.round((double) getDistanceMethod.invoke(Temp_CleanerRobot,data_1,data_2) * 100) / 100);
        System.out.println("Test Case 7 Passed");

        // 0, 0 >, < 0, 0 >
        data_1.x = 0;
        data_1.y = 64;
        data_2.x = -49;
        data_2.y = 0;
        Assertions.assertEquals(80.60,(double) Math.round((double) getDistanceMethod.invoke(Temp_CleanerRobot,data_1,data_2) * 100) / 100);
        System.out.println("Test Case 8 Passed");

        // 0 >, < 0, 0, 0 >
        data_1.x = 38;
        data_1.y = -4;
        data_2.x = 0;
        data_2.y = 0;
        Assertions.assertEquals(38.21,(double) Math.round((double) getDistanceMethod.invoke(Temp_CleanerRobot,data_1,data_2) * 100) / 100);
        System.out.println("Test Case 9 Passed");
    }

}
