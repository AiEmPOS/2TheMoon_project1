import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project_16x16.SideScroller;
import project_16x16.projectiles.ProjectileObject;
import project_16x16.scene.GameplayScene;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProjectileTest {

    private final SideScroller sc = mock(SideScroller.class);
    private final GameplayScene gs = mock(GameplayScene.class);

    private ProjectileObject po;

    @BeforeEach
    void setup(){
        po = new ProjectileObject(sc, gs);
    }

    @Test
    void projectileTest(){
        Assertions.assertEquals(sc, po.applet);
        Assertions.assertEquals(gs, po.gameScene);
        System.out.println(po.width + " " + po.height);
    }

    @Test
    void collisionTest(){

    }
}
