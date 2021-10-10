/* Copyright (C) 2021 Phonarnun Tatiyamaneekul - All Rights Reserved
 * You may use, distribute and modify this code under the terms of the GPL license.
 */

import org.junit.jupiter.api.*;
import processing.core.PVector;
import project_16x16.SideScroller;
import project_16x16.entities.Enemy;
import project_16x16.objects.CollidableObject;
import project_16x16.scene.GameplayScene;

import java.lang.reflect.*;

import static org.mockito.Mockito.mock;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EnemyTest {
    private Enemy Temp_Enemy;
    private CollidableObject Temp_CollidableObject;
    private final SideScroller Temp_SideScroller = mock(SideScroller.class);
    private final GameplayScene Temp_GameplayScene = mock(GameplayScene.class);
    Class EnemyClass;
    Method getCollidesMethod;
    @BeforeAll
    void setup() throws NoSuchMethodException {
        Temp_CollidableObject = new CollidableObject(Temp_SideScroller,Temp_GameplayScene);
        Temp_Enemy = new Enemy(Temp_SideScroller,Temp_GameplayScene);
        EnemyClass = Enemy.class;
        getCollidesMethod = EnemyClass.getDeclaredMethod("collides",CollidableObject.class);
        getCollidesMethod.setAccessible(true);
    }

    @Test // ECC [ISP Criteria]
    void TestCollides() throws InvocationTargetException, IllegalAccessException {
        System.out.println("=== Test Enemy.collides ===");
        // <0,<0,0,0,<0,<0,0,0
        Temp_Enemy.pos.x = -27;
        Temp_Enemy.pos.y = -24;
        Temp_Enemy.width = 0;
        Temp_Enemy.height = 0;
        Temp_CollidableObject.pos = new PVector(-27,-24);
        Temp_CollidableObject.height = 0;
        Temp_CollidableObject.width = 0;
        //Check that Enemy
        Boolean Enemy_IsOutsideTheMap = false;
        if (Temp_Enemy.pos.x < 0 || Temp_Enemy.pos.y < 0) {
            Enemy_IsOutsideTheMap = true;
        }
        Boolean CollidableObject_IsOutsideTheMap = false;
        if (Temp_CollidableObject.pos.x < 0 || Temp_CollidableObject.pos.y < 0) {
            CollidableObject_IsOutsideTheMap = true;
        }
        Assertions.assertTrue(Enemy_IsOutsideTheMap);
        Assertions.assertTrue(CollidableObject_IsOutsideTheMap);
        // False since the height and width are 0
        Assertions.assertFalse((Boolean) getCollidesMethod.invoke(Temp_Enemy,Temp_CollidableObject));

        System.out.println("Test Case 1 Passed");

        // 0,0,>0,>0,0,0,>0,>0
        Temp_Enemy.pos.x = 0;
        Temp_Enemy.pos.y = 0;
        Temp_Enemy.width = 25;
        Temp_Enemy.height = 45;
        Temp_CollidableObject.pos.x = 0;
        Temp_CollidableObject.pos.y = 0;
        Temp_CollidableObject.height = 37;
        Temp_CollidableObject.width = 55;
        Enemy_IsOutsideTheMap = false;
        if (Temp_Enemy.pos.x < 0 || Temp_Enemy.pos.y < 0) {
            Enemy_IsOutsideTheMap = true;
        }
        CollidableObject_IsOutsideTheMap = false;
        if (Temp_CollidableObject.pos.x < 0 || Temp_CollidableObject.pos.y < 0) {
            CollidableObject_IsOutsideTheMap = true;
        }
        Assertions.assertFalse(Enemy_IsOutsideTheMap);
        Assertions.assertFalse(CollidableObject_IsOutsideTheMap);
        Assertions.assertTrue((Boolean) getCollidesMethod.invoke(Temp_Enemy,Temp_CollidableObject));
        System.out.println("Test Case 2 Passed");

        // 0,<0,>0,>0,<0,0,>0,>0
        Temp_Enemy.pos.x = 0;
        Temp_Enemy.pos.y = -13;
        Temp_Enemy.width = 45;
        Temp_Enemy.height = 95;
        Temp_CollidableObject.pos.x = -20;
        Temp_CollidableObject.pos.y = 0;
        Temp_CollidableObject.height = 50;
        Temp_CollidableObject.width = 50;
        Enemy_IsOutsideTheMap = false;
        if (Temp_Enemy.pos.x < 0 || Temp_Enemy.pos.y < 0) {
            Enemy_IsOutsideTheMap = true;
        }
        CollidableObject_IsOutsideTheMap = false;
        if (Temp_CollidableObject.pos.x < 0 || Temp_CollidableObject.pos.y < 0) {
            CollidableObject_IsOutsideTheMap = true;
        }
        Assertions.assertTrue(Enemy_IsOutsideTheMap);
        Assertions.assertTrue(CollidableObject_IsOutsideTheMap);
        Assertions.assertTrue((Boolean) getCollidesMethod.invoke(Temp_Enemy,Temp_CollidableObject));
        System.out.println("Test Case 3 Passed");
    }
}
