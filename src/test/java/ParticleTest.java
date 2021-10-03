import javafx.geometry.Pos;
import org.junit.jupiter.api.*;
import java.lang.reflect.*;

import processing.core.PVector;
import project_16x16.SideScroller;
import project_16x16.Tileset;
import project_16x16.particleSystem.ParticleSystem;

import org.junit.jupiter.api.BeforeAll;
import project_16x16.particleSystem.emissions.AreaEmission;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParticleTest {

    private static SideScroller s;
    private static ParticleSystem p;

    @BeforeAll
    void init(){
        s = new SideScroller();
//        PApplet.runSketch(new String[]{"project_16x16.SideScroller"}, s);
    }

    //Pair-wise
    @Test
    void TestEmissionNewPosition() {

        AreaEmission areaEmission;
        PVector newPos;

        try {
            //Initialize
            Method newPositionMethod = AreaEmission.class.getDeclaredMethod("newPosition");
            newPositionMethod.setAccessible(true);
            Field PositionField = AreaEmission.class.getDeclaredField("position");
            PositionField.setAccessible(true);
            Field newPositionField = AreaEmission.class.getDeclaredField("newPosition");
            newPositionField.setAccessible(true);
            Field spreadField = AreaEmission.class.getDeclaredField("spread");
            spreadField.setAccessible(true);

            //Spread == 0 && P.x < 0 && P.y < 0 [P1]
            areaEmission = new AreaEmission(new PVector(-1,-1), 1,1,0);
            newPositionMethod.invoke(areaEmission);
            newPos = (PVector) newPositionField.get(areaEmission);
            Assertions.assertEquals(true,(newPos.x == -1));
            Assertions.assertEquals(true, (newPos.y == -1));

            //Spread == 0 && P.x == 0 && P.y == 0 [P2]
            areaEmission = new AreaEmission(new PVector(0,0), 1,1,0);
            newPositionMethod.invoke(areaEmission);
            newPos = (PVector) newPositionField.get(areaEmission);
            Assertions.assertEquals(true,(newPos.x == 0));
            Assertions.assertEquals(true, (newPos.y == 0));

            //Spread == 0 && P.x > 0 && P.y > 0 [P3]
            areaEmission = new AreaEmission(new PVector(1,1), 1,1,0);
            newPositionMethod.invoke(areaEmission);
            newPos = (PVector) newPositionField.get(areaEmission);
            Assertions.assertEquals(true,(newPos.x == 1));
            Assertions.assertEquals(true, (newPos.y == 1));

            //Spread < 1 && P.x < 0 && P.y == 0 [P4]
            areaEmission = new AreaEmission(new PVector(-2,0), 1,1,(float) 0.5);
            newPositionMethod.invoke(areaEmission);
            newPos = (PVector) newPositionField.get(areaEmission);
            Assertions.assertEquals(true,(newPos.x <= -1.5) && (newPos.x >= -2.5));
            Assertions.assertEquals(true, (newPos.y <= 0.5) && (newPos.y >= -0.5));

            //Spread < 1 && P.x == 0 && P.y > 0 [P5]
            areaEmission = new AreaEmission(new PVector(0,2), 1,1,(float) 0.5);
            newPositionMethod.invoke(areaEmission);
            newPos = (PVector) newPositionField.get(areaEmission);
            Assertions.assertEquals(true,(newPos.x <= 0.5) && (newPos.x >= -0.5));
            Assertions.assertEquals(true, (newPos.y <= 2.5) && (newPos.y >= 1.5));

            //Spread < 1 && P.x > 0 && P.y < 0 [P6]
            areaEmission = new AreaEmission(new PVector(2,-2), 1,1,(float) 0.5);
            newPositionMethod.invoke(areaEmission);
            newPos = (PVector) newPositionField.get(areaEmission);
            Assertions.assertEquals(true,(newPos.x <= 2.5) && (newPos.x >= 1.5));
            Assertions.assertEquals(true, (newPos.y <= -1.5) && (newPos.y >= -2.5));

            //Spread >= 1 && P.x < 0 && P.y > 0 [P7]
            areaEmission = new AreaEmission(new PVector(-3,3), 1,1,(float) 1.5);
            newPositionMethod.invoke(areaEmission);
            newPos = (PVector) newPositionField.get(areaEmission);
            Assertions.assertEquals(true,(newPos.x <= -1.5) && (newPos.x >= -4.5));
            Assertions.assertEquals(true, (newPos.y <= 4.5) && (newPos.y >= 1.5));

            //Spread >= 1 && P.x == 0 && P.y < 0 [P8]
            areaEmission = new AreaEmission(new PVector(0,-3), 1,1,(float) 1.5);
            newPositionMethod.invoke(areaEmission);
            newPos = (PVector) newPositionField.get(areaEmission);
            Assertions.assertEquals(true,(newPos.x <= 1.5) && (newPos.x >= -1.5));
            Assertions.assertEquals(true, (newPos.y <= -1.5) && (newPos.y >= -4.5));

            //Spread >= 1 && P.x > 0 && P.y == 0 [P9]
            areaEmission = new AreaEmission(new PVector(3,0), 1,1,(float) 1.5);
            newPositionMethod.invoke(areaEmission);
            newPos = (PVector) newPositionField.get(areaEmission);
            Assertions.assertEquals(true,(newPos.x <= 4.5) && (newPos.x >= 1.5));
            Assertions.assertEquals(true, (newPos.y <= 1.5) && (newPos.y >= -1.5));
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }

    //Multiple Base Choice
    @Test
    void TestEmissionAcceleration() {

        AreaEmission areaEmission;
        PVector result;

        try {
            //Init
            Method newAccelMethod = AreaEmission.class.getDeclaredMethod("newAcceleration", float.class);
            newAccelMethod.setAccessible(true);
            Field newAcceleration = AreaEmission.class.getDeclaredField("newAcceleration");
            newAcceleration.setAccessible(true);

            // Acc. < 0 && Phi in [0,PI/2) [BC1]
            areaEmission = new AreaEmission(new PVector(1,1), 1,-2,1);
            newAccelMethod.invoke(areaEmission, 0);
            result = (PVector) newAcceleration.get(areaEmission);
            Assertions.assertEquals(-2, (int) result.x);
            Assertions.assertEquals(0, (int) result.y);

            //Acc. == 0 && Phi in [PI/2, PI) [BC2]
            areaEmission = new AreaEmission(new PVector(1,1), 1,0,1);
            newAccelMethod.invoke(areaEmission, (float)(Math.PI / 2));
            result = (PVector) newAcceleration.get(areaEmission);
            Assertions.assertEquals(0, (int) result.x);
            Assertions.assertEquals(0, (int) result.y);

            //Acc. > 0 && Phi in [PI, 3PI/2) [BC3]
            areaEmission = new AreaEmission(new PVector(1,1), 1,2,1);
            newAccelMethod.invoke(areaEmission, (float)(Math.PI));
            result = (PVector) newAcceleration.get(areaEmission);
            Assertions.assertEquals(-2, (int) result.x);
            Assertions.assertEquals(0, (int) result.y);

            //Acc. < 0 && Phi in [3PI/2, 2PI] [TC1]
            areaEmission = new AreaEmission(new PVector(1,1), 1,-2,1);
            newAccelMethod.invoke(areaEmission, (float)(3 * Math.PI / 2));
            result = (PVector) newAcceleration.get(areaEmission);
            Assertions.assertEquals(0, (int) result.x);
            Assertions.assertEquals(2, (int) result.y);
            newAccelMethod.invoke(areaEmission, (float)(2 * Math.PI));
            result = (PVector) newAcceleration.get(areaEmission);
            Assertions.assertEquals(-2, (int) result.x);
            Assertions.assertEquals(0, (int) result.y);

            //Acc. == 0 && Phi in [3PI/2, 2PI] [TC2]
            areaEmission = new AreaEmission(new PVector(1,1), 1,0,1);
            newAccelMethod.invoke(areaEmission, (float)(3 * Math.PI / 2));
            result = (PVector) newAcceleration.get(areaEmission);
            Assertions.assertEquals(0, (int) result.x);
            Assertions.assertEquals(0, (int) result.y);
            newAccelMethod.invoke(areaEmission, (float)(2 * Math.PI));
            result = (PVector) newAcceleration.get(areaEmission);
            Assertions.assertEquals(0, (int) result.x);
            Assertions.assertEquals(0, (int) result.y);

            //Acc. > 0 && Phi in [3PI/2, 2PI] [TC3]
            areaEmission = new AreaEmission(new PVector(1,1), 1,2,1);
            newAccelMethod.invoke(areaEmission, (float)(3 * Math.PI / 2));
            result = (PVector) newAcceleration.get(areaEmission);
            Assertions.assertEquals(0, (int) result.x);
            Assertions.assertEquals(-2, (int) result.y);
            newAccelMethod.invoke(areaEmission, (float)(2 * Math.PI));
            result = (PVector) newAcceleration.get(areaEmission);
            Assertions.assertEquals(2, (int) result.x);
            Assertions.assertEquals(0, (int) result.y);

        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }

    @Test
    void TestEmissionVelocity() {

        AreaEmission areaEmission;
        PVector result;

        try {
            //Init
            Method newVelocityMethod = AreaEmission.class.getDeclaredMethod("newVelocity", float.class);
            newVelocityMethod.setAccessible(true);
            Field newVelocity = AreaEmission.class.getDeclaredField("newVelocity");
            newVelocity.setAccessible(true);

            // Velocity < 0 && Phi in [0,PI/2) [BC1]
            areaEmission = new AreaEmission(new PVector(1,1), -2,1,1);
            newVelocityMethod.invoke(areaEmission, 0);
            result = (PVector) newVelocity.get(areaEmission);
            Assertions.assertEquals(-2, (int) result.x);
            Assertions.assertEquals(0, (int) result.y);

            //Velocity == 0 && Phi in [3PI/2, 2PI] [BC2]
            areaEmission = new AreaEmission(new PVector(1,1), 0,1,1);
            newVelocityMethod.invoke(areaEmission, (float)(3 * Math.PI / 2));
            result = (PVector) newVelocity.get(areaEmission);
            Assertions.assertEquals(0, (int) result.x);
            Assertions.assertEquals(0, (int) result.y);
            newVelocityMethod.invoke(areaEmission, (float)(2 * Math.PI));
            result = (PVector) newVelocity.get(areaEmission);
            Assertions.assertEquals(0, (int) result.x);
            Assertions.assertEquals(0, (int) result.y);

            //Velocity < 0 && Phi in [PI/2, PI) [TC1]
            areaEmission = new AreaEmission(new PVector(1,1), -2,1,1);
            newVelocityMethod.invoke(areaEmission, (float)(Math.PI/2));
            result = (PVector) newVelocity.get(areaEmission);
            Assertions.assertEquals(0, (int) result.x);
            Assertions.assertEquals(-2, (int) result.y);

            //Velocity < 0 && Phi in [PI, 3PI/2) [TC2]
            areaEmission = new AreaEmission(new PVector(1,1), -2,1,1);
            newVelocityMethod.invoke(areaEmission, (float)(Math.PI));
            result = (PVector) newVelocity.get(areaEmission);
            Assertions.assertEquals(2, (int) result.x);
            Assertions.assertEquals(0, (int) result.y);

            //Velocity > 0 && Phi in [0, PI/2) [TC3]
            areaEmission = new AreaEmission(new PVector(1,1), 2,1,1);
            newVelocityMethod.invoke(areaEmission, (float)(0));
            result = (PVector) newVelocity.get(areaEmission);
            Assertions.assertEquals(2, (int) result.x);
            Assertions.assertEquals(0, (int) result.y);

            //Velocity > 0 && Phi in [3PI/2, 2PI] [TC4]
            areaEmission = new AreaEmission(new PVector(1,1), 2,1,1);
            newVelocityMethod.invoke(areaEmission, (float)(3 * Math.PI / 2));
            result = (PVector) newVelocity.get(areaEmission);
            Assertions.assertEquals(0, (int) result.x);
            Assertions.assertEquals(-2, (int) result.y);
            newVelocityMethod.invoke(areaEmission, (float)(2 * Math.PI));
            result = (PVector) newVelocity.get(areaEmission);
            Assertions.assertEquals(2, (int) result.x);
            Assertions.assertEquals(0, (int) result.y);

            //Velocity == 0 && Phi in [PI/2, PI) [TC5]
            areaEmission = new AreaEmission(new PVector(1,1), 0,1,1);
            newVelocityMethod.invoke(areaEmission, (float)(Math.PI / 2));
            result = (PVector) newVelocity.get(areaEmission);
            Assertions.assertEquals(0, (int) result.x);
            Assertions.assertEquals(0, (int) result.y);

            //Velocity == 0 && Phi in [PI, 3PI/2) [TC6]
            areaEmission = new AreaEmission(new PVector(1,1), 0,1,1);
            newVelocityMethod.invoke(areaEmission, (float)(Math.PI));
            result = (PVector) newVelocity.get(areaEmission);
            Assertions.assertEquals(0, (int) result.x);
            Assertions.assertEquals(0, (int) result.y);
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }

    //ACoC
    @Test
    void TestRunParticle(){

        //Each particle has 6 frame lifespan
        ParticleSystem s = new ParticleSystem(this.s, new Tileset.getTile(298, 291, 9, 9, 4), 1, 1, (float) 0.1);

        //Has no particle
        Assertions.assertEquals(false, s.particles.hasActiveParticles());
        Assertions.assertEquals(0, s.particles.inactiveParticles.size());

        //Has particles
        s.particles.newParticle();
        s.particles.newParticle();
        Assertions.assertEquals(true, s.particles.hasActiveParticles());
        Assertions.assertEquals(0, s.particles.inactiveParticles.size());


        //Run for all lifespan
        for (int i = 0; i < 6; i++){
            s.particles.runParticles();
        }

        Assertions.assertEquals(false, s.particles.hasActiveParticles());
        Assertions.assertEquals(2, s.particles.inactiveParticles.size());

    }

    //ECC
    @Test
    void TestNewParticle(){

        ParticleSystem s = new ParticleSystem(this.s, new Tileset.getTile(298, 291, 9, 9, 4), 1, 1, (float) 1);

        //No Active Particle
        Assertions.assertEquals(0, s.particles.activeParticles.size());
        //1 Active Particle
        s.particles.newParticle();
        Assertions.assertEquals(1, s.particles.activeParticles.size());
        //>1 Active Particle
        s.particles.newParticle();
        s.particles.newParticle();
        Assertions.assertEquals(3, s.particles.activeParticles.size());
    }

}
