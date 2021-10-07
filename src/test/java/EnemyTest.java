import org.junit.jupiter.api.*;
import processing.core.PVector;
import project_16x16.SideScroller;
import project_16x16.entities.Enemy;
import project_16x16.objects.CollidableObject;

import java.lang.reflect.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EnemyTest {
    private static Enemy Temp_Enemy;
    private static CollidableObject Temp_CollidableObject;
    private static SideScroller Temp_SideScroller;
    Class EnemyClass;
    @BeforeAll
    void setup() {
        Temp_SideScroller = new SideScroller();
        Temp_Enemy = new Enemy(Temp_SideScroller);
        Temp_CollidableObject = new CollidableObject(Temp_SideScroller);
        EnemyClass = Enemy.class;
    }

    @Test
    void TestCollides_1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method getCollidesMethod = EnemyClass.getDeclaredMethod("collides",CollidableObject.class);
        Temp_CollidableObject.pos = new PVector(10,10);
        Temp_CollidableObject.height = 25;
        Temp_CollidableObject.width = 25;
        System.out.println(Temp_Enemy.pos.x);
        System.out.println(Temp_Enemy.pos.y);
        System.out.println(Temp_Enemy.width);
        System.out.println(Temp_Enemy.height);
        System.out.println(Temp_CollidableObject.pos.x);
        System.out.println(Temp_CollidableObject.pos.y);
        System.out.println(Temp_CollidableObject.width);
        System.out.println(Temp_CollidableObject.height);
        getCollidesMethod.setAccessible(true);
        Assertions.assertTrue((Boolean) getCollidesMethod.invoke(Temp_Enemy,Temp_CollidableObject));
    }
}
