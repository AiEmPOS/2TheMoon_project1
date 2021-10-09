import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import processing.data.JSONObject;
import project_16x16.SideScroller;
import project_16x16.objects.CollidableObject;
import project_16x16.scene.GameplayScene;

import static org.mockito.Mockito.mock;

public class CollidableObjectTest {

    private final SideScroller sc = mock(SideScroller.class);
    private final GameplayScene gs = mock(GameplayScene.class);

    private CollidableObject collidableObject;

    @BeforeEach
    void setup(){
        collidableObject = new CollidableObject(sc, gs);
    }

    @Test
    void collidableObjectTest(){
        Assertions.assertEquals("", collidableObject.flag);
        Assertions.assertEquals(0, collidableObject.height);
        Assertions.assertEquals(0, collidableObject.width);
    }

    @Test
    void setImageWidthTest(){
        collidableObject.setImageWidth(5);
        Assertions.assertEquals(5, collidableObject.width);
    }

    @Test
    void setImageHeightTest(){
        collidableObject.setImageHeight(5);
        Assertions.assertEquals(5, collidableObject.height);
    }

    @Test
    public void TestExportToJSON(){
        JSONObject item = collidableObject.exportToJSON();

        Assertions.assertNull(item.get("id"));
        Assertions.assertEquals("COLLISION", item.get("type"));
        Assertions.assertEquals(0, item.get("x"));
        Assertions.assertEquals(0, item.get("y"));
    }
}