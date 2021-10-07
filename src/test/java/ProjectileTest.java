import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project_16x16.SideScroller;
import project_16x16.objects.CollidableObject;
import project_16x16.projectiles.ProjectileObject;
import project_16x16.scene.GameplayScene;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProjectileTest {

    private final SideScroller sc = mock(SideScroller.class);
    private final GameplayScene gs = mock(GameplayScene.class);

    private ProjectileObject po;
    private CollidableObject co;

    @BeforeEach
    void setup(){
        po = new ProjectileObject(sc, gs);
        co = new CollidableObject(sc, gs);
    }

    @Test
    void projectileTest(){
        Assertions.assertEquals(sc, po.applet);
        Assertions.assertEquals(gs, po.gameScene);
        Assertions.assertEquals(0, po.width);
        Assertions.assertEquals(0, po.height);
        Assertions.assertEquals("", po.id);
        Assertions.assertEquals(0, po.spawnTime);
        Assertions.assertNotNull(po.animation);
        Assertions.assertEquals(0, po.direction);
        Assertions.assertEquals(0, po.prevDirection);
        Assertions.assertEquals(0, po.speed);
        Assertions.assertEquals(false, po.hit);
    }

    @Test
    void collisionFalseTest(){
        Assertions.assertEquals(false, po.collides(co));
    }

    @Test
    void collisionTrueTest(){
        po.width = 2;
        po.height = 2;
        po.pos.x = 3;
        po.pos.y = 5;

        co.width = 4;
        co.height = 4;
        co.pos.x = 4;
        co.pos.y = 5;

        Assertions.assertEquals(true, po.collides(co));
    }

    @Test
    void exportToJsonNullTest(){
        Assertions.assertNull(po.exportToJSON());
    }
}
