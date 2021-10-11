/* Copyright (C) 2021 Waiwarit Wongsawangpanich - All Rights Reserved
 * You may use, distribute and modify this code under the terms of the MIT license.
 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project_16x16.SideScroller;
import project_16x16.objects.CollidableObject;
import project_16x16.projectiles.ProjectileObject;
import project_16x16.scene.GameplayScene;

import static org.mockito.Mockito.mock;

public class ProjectileTest {

    private final SideScroller sc = mock(SideScroller.class);
    private final GameplayScene gs = mock(GameplayScene.class);

    private ProjectileObject po;
    private CollidableObject co;

    @BeforeEach
    void setup(){
        po = new ProjectileObject(sc, gs);
        co = new CollidableObject(sc, gs);

        co.width = 4;
        co.height = 4;
        co.pos.x = 4;
        co.pos.y = 5;
    }

    @Test
    void collisionTest(){
        //BCC

        //Interface

        //Base Choice: >0, >0, >0, >0
        po.width = 2;
        po.height = 2;
        po.pos.x = 3;
        po.pos.y = 5;
        Assertions.assertEquals(true, po.collides(co));

        //Choice: 0, >0, >0, >0
        po.width = 0;
        po.height = 2;
        po.pos.x = 3;
        po.pos.y = 5;
        Assertions.assertEquals(true, po.collides(co));

        //Choice: >0, 0, >0, >0
        po.width = 2;
        po.height = 0;
        po.pos.x = 3;
        po.pos.y = 5;
        Assertions.assertEquals(true, po.collides(co));

        //Choice: >0, >0, <0, >0
        po.width = 2;
        po.height = 2;
        po.pos.x = -3;
        po.pos.y = 5;
        Assertions.assertEquals(false, po.collides(co));

        //Choice: >0, >0, 0, >0
        po.width = 2;
        po.height = 2;
        po.pos.x = 0;
        po.pos.y = 5;
        Assertions.assertEquals(false, po.collides(co));

        //Choice: >0, >0, >0, <0
        po.width = 2;
        po.height = 2;
        po.pos.x = 3;
        po.pos.y = -5;
        Assertions.assertEquals(false, po.collides(co));

        //Choice: >0, >0, <0, 0
        po.width = 2;
        po.height = 2;
        po.pos.x = -3;
        po.pos.y = 0;
        Assertions.assertEquals(false, po.collides(co));

        //Functionality

        //Base Choice: Left, False
        po.width = 2;
        po.height = 2;
        po.pos.x = 3;
        po.pos.y = 5;
        Assertions.assertEquals(true, po.collides(co));

        //Choice: Top Left, False
        po.width = 2;
        po.height = 2;
        po.pos.x = 3;
        po.pos.y = 6;
        Assertions.assertEquals(true, po.collides(co));

        //Choice: Top, False
        po.width = 2;
        po.height = 2;
        po.pos.x = 4;
        po.pos.y = 6;
        Assertions.assertEquals(true, po.collides(co));

        //Choice: Top Right, False
        po.width = 2;
        po.height = 2;
        po.pos.x = 5;
        po.pos.y = 6;
        Assertions.assertEquals(true, po.collides(co));

        //Choice: Right, False
        po.width = 2;
        po.height = 2;
        po.pos.x = 5;
        po.pos.y = 5;
        Assertions.assertEquals(true, po.collides(co));

        //Choice: Down Right, False
        po.width = 2;
        po.height = 2;
        po.pos.x = 5;
        po.pos.y = 4;
        Assertions.assertEquals(true, po.collides(co));

        //Choice: Down, False
        po.width = 2;
        po.height = 2;
        po.pos.x = 4;
        po.pos.y = 4;
        Assertions.assertEquals(true, po.collides(co));

        //Choice: Down Left, False
        po.width = 2;
        po.height = 2;
        po.pos.x = 3;
        po.pos.y = 4;
        Assertions.assertEquals(true, po.collides(co));

        //Choice: Left, True
        po.width = 2;
        po.height = 2;
        po.pos.x = -3;
        po.pos.y = 6;
        Assertions.assertEquals(false, po.collides(co));
    }

}
