/* Copyright (C) 2021 Phonarnun Tatiyamaneekul - All Rights Reserved
 * You may use, distribute and modify this code under the terms of the GPL license.
 */

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
    Method getDistanceMethod;
    @BeforeAll
    void setup() throws NoSuchMethodException {
        Temp_CleanerRobot = new CleanerRobot(Temp_SideScroller,Temp_GameplayScene);
        CleanerRobotClass = CleanerRobot.class;
        getDistanceMethod = CleanerRobotClass.getDeclaredMethod("getDistance",PVector.class,PVector.class);
        getDistanceMethod.setAccessible(true);
    }

    @Test
    void TestGetDistance() throws InvocationTargetException, IllegalAccessException {
        System.out.println("=== Test RobotCleaner.getDistance ===");
        // Interface-Based // Pair-Wise [ISP Criteria]
        // data_1.x, data_1.y, data_2.x, data_2.y
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

        //Functionality-Based // ACoC [ISP Criteria]
        // AreData_1andData_2Similar
        // True
        data_1.x = 45;
        data_1.y = 12;
        data_2.x = 45;
        data_2.y = 12;
        Assertions.assertEquals(data_1,data_2);
        System.out.println("Test Case 10 Passed");

        // False
        data_1.x = 54;
        data_1.y = 44;
        data_2.x = 62;
        data_2.y = 84;
        Assertions.assertNotEquals(data_1,data_2);
        System.out.println("Test Case 11 Passed");
    }

}
