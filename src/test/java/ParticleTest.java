import org.junit.jupiter.api.*;

import processing.core.PApplet;
import processing.core.PApplet.*;
import processing.core.PVector;
import project_16x16.SideScroller;
import project_16x16.Tileset;
import project_16x16.Tileset.*;
import project_16x16.particleSystem.ParticleSystem;

import org.junit.jupiter.api.BeforeAll;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParticleTest {

    private static SideScroller s;
    private static ParticleSystem p;

    @BeforeAll
    void init(){
        s = new SideScroller();
//        PApplet.runSketch(new String[]{"project_16x16.SideScroller"}, s);
    }

    @Test
    void TestNewAcceleration(){
        Assertions.assertEquals(1,1);

    }

    @Test
    void TestNewPosition(){
        Assertions.assertEquals(2,2);
    }

    @AfterAll
//    void stop(){
//        s.stop();
//    }

    @Test
    void TestNewParticle(){
//        Assertions.assertEquals(false, s.debug);
        ParticleSystem s = new ParticleSystem(this.s, new Tileset.getTile(298, 291, 9, 9, 4), 1, 1, (float) 0.1);
        s.particles.newParticle();
        Assertions.assertEquals(1, s.particles.activeParticles.size());

        //Test 1: Zero V, angle < -360
//        ParticleSystem p = new ParticleSystem(new SideScroller(), )

    }



}
