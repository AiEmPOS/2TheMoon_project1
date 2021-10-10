/* Copyright (C) 2021 Worameth Siritanakorn - All Rights Reserved
 * You may use, distribute and modify this code under the terms of the MIT license.
 */

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
    void setImageSizeTest(){
        //BCC

        //Base Choice: >0, >0
        collidableObject.setImageHeight(6);
        collidableObject.setImageWidth(5);
        Assertions.assertEquals(6, collidableObject.height);
        Assertions.assertEquals(5, collidableObject.width);

        //Choice: 0, >0
        collidableObject.setImageHeight(0);
        collidableObject.setImageWidth(5);
        Assertions.assertEquals(0, collidableObject.height);
        Assertions.assertEquals(5, collidableObject.width);

        //Choice: >0, 0
        collidableObject.setImageHeight(6);
        collidableObject.setImageWidth(0);
        Assertions.assertEquals(6, collidableObject.height);
        Assertions.assertEquals(0, collidableObject.width);
    }

    @Test
    public void exportToJSONTest(){
        JSONObject item = collidableObject.exportToJSON();

        Assertions.assertNull(item.get("id"));
        Assertions.assertEquals("COLLISION", item.get("type"));
        Assertions.assertEquals(0, item.get("x"));
        Assertions.assertEquals(0, item.get("y"));
    }
}
