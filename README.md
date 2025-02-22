# 2TheMoon Project
## Particle Class Test
### 1.TestEmissionNewPosition()
**Test function:** AreaEmission.newPosition()

**Goal:** To test if the new position is calculated correctly

**Input:** spread < float >, position < PVector >

**Return:** newPosition < PVector >

**Exceptional Behavior:** --

**Model:**
- ![TestNewPosition_Model](https://i.imgur.com/0nHHLzq.png)

**Combination:** Pair-wise	

**Test Case:**
- ![TestNewPosition_Test_Case](https://i.imgur.com/9lMIVjo.png)
	
---
	
### 2.TestEmissionNewVelocity()
**Test function:** AreaEmission.newVelocity(float phi)

**Goal:** To test if new velocity vector is calculated correctly

**Input:** velocity < float >, phi < float >

**Return:** newVelocity < PVector >

**Exceptional Behavior:** --

**Model:**
- ![TestEmissionVelocity_Model](https://i.imgur.com/w7KQYXA.png)

**Combination:** MBCC	

**Test Case:**
- ![TestEmissionVelocity_Test_Case](https://i.imgur.com/tqxh23J.png)
	
---
	
### 3.TestEmissionNewAcceleration()
**Test function:** AreaEmission.newAcceleration(float phi)

**Goal:** To test if new acceleration is calculated correctly

**Input:** acceleration < float >, phi < float >

**Return:** newAcceleration < PVector >

**Exceptional Behavior:** --

**Model:**
- ![TestEmissionAcceleration_Model](https://i.imgur.com/w7KQYXA.png)

**Combination:** MBCC	

**Test Case:**
- ![TestEmissionAcceleration_Test_Case](https://i.imgur.com/EbK2pDH.png)
		
---
	
### 4.TestRunParticle()
**Test function:** ParticleSystem.runParticle()

**Goal:** To test if the run function is perform correctly, and the dead particle is sent to InactiveParticle array list

**Input:** ActiveParticle< Particle >[] < ArrayList >

**Return:** ActiveParticle< Particle >[] < ArrayList >, InactiveParticle< Particle >[] < ArrayList >

**Exceptional Behavior:** --

**Model:**
- ![TestRunParticle_Model](https://i.imgur.com/dRwY3gF.png)

**Combination:** ECC	

**Test Case:**
- ![TestRunParticle_Test_Case](https://i.imgur.com/lnlpuc5.png)
		
---
	
### 5.TestNewParticle()
**Test function:** ParticleSystem.runParticle()

**Goal:** To test if particle is created and added to ActiveParticle correctly

**Input:** ActiveParticle< Particle >[] < ArrayList >

**Return:** ActiveParticle< Particle >[] < ArrayList >

**Exceptional Behavior:** --

**Model:**
- ![TestNewParticle_Model](https://i.imgur.com/sogQ5E7.png)

**Combination:** ACoC	

**Test Case:**
- ![TestNewParticle_Test_Case](https://i.imgur.com/HAb8ink.png)
	
---

## CleanerRobot Class Test
### 6.TestGetDistance()
**Test function:** CleanerRobot.getDistance()

**Goal:** to test if the distance value is correctly provided. 

**Input:** PVector , PVector

**Return:** Double

**Exceptional Behavior:** --

**Model:**
- Interface-Based characteristic
	- ![TestGetDistance_Model_1](https://i.imgur.com/xhPqfYX.png)
- Functionality-Based characteristic
	- ![TestGetDistance_Model_2](https://i.imgur.com/Ty3tJEP.png)

**Combination:** Pair-Wise, ACoC

**Test Case:**
- Interface-Based characteristic [ Pair-Wise]
	- ![TestGetDistance_Test_Case](https://i.imgur.com/sYF5eTL.png)
- Functionality-Based characteristic [ ACoC ]
	- ![TestGetDistance_Model_2](https://i.imgur.com/DTbDQYZ.png)
		
---
## Enemy Class Test
### 7.TestCollides()
**Test function:** Enemy.Collides()

**Goal:** To test if the collide function performs correctly and the enemy is not outside the map.

**Input:** CollidableObject, CollidableObject

**Return:** Boolean

**Exceptional Behavior:** --

**Model:**
- ![TestCollides_Model](https://i.imgur.com/sLhGk3G.png)

**Combination:** ECC

**Test Case:**
- ![TestCollides_Test_Case](https://i.imgur.com/dXNrWUU.png)

---

## Tile Class Test
### 8.TestGetTileType()
**Test function:** Tile.getTiletype()

**Goal:** To test if a specific tile has the correct tile type

**Input:** Tile

**Return:** Tile.tiletype  (COLLISION, OBJECT, BACKGROUND, ENTITY)

**Exceptional behavior:** --

**Model:**
- ![TestGetTileType_Model](https://i.imgur.com/r9fhrYb.png)

**Combination:** ACoC

**Test Case:**
- ![TestGetTileType_Test_Case](https://i.imgur.com/xPru1TC.png)

---

### 9.TestGetPImage()
**Test function:** Tile.getPImage()

**Goal:** To test if the tile has PImage.

**Input:** Tile

**Return:** Image

**Exceptional behavior:** --

**Model:**
- ![TestGetPImage_Model](https://i.imgur.com/wWHBXVe.png)

**Combination:** ECC

**Test Case:**
- ![TestGetPImage_Test_Case](https://i.imgur.com/7OaA0uw.png)


---

### 10.CollisionTest()
**Test function:** Tile.getPImage()

**Goal:** To test if the object has collided.

**Input:** width, height, position.x, position.y

**Return:** Boolean

**Exceptional behavior:** --

**Model:**
- Interface-Based characteristic
	- ![CollisionTest_Model_1](https://i.imgur.com/aesi14B.png)
- Functionality-Based characteristic
	- ![CollisionTest_Model_2](https://i.imgur.com/iIzHpl8.png)

**Combination:** BCC

**Test Case:**
- Interface-Based characteristic
	- ![CollisionTest_Test_Case_1](https://i.imgur.com/YINhI7H.png)
- Functionality-Based characteristic
	- ![CollisionTest_Test_Case_2](https://i.imgur.com/yhkMnjA.png)

---

### 11.setImageSizeTest()
**Test function:** collidableObject.setImageHeight(), collidableObject.setImageWidth()

**Goal:** To test if the object image size is changed after setting   

**Input:** width, height

**Return:** width, height

**Exceptional behavior:** --

**Model:**
- ![CollisionTest_Model_1](https://i.imgur.com/8hy3mk1.png)


**Combination:** BCC

**Test Case:**
- ![CollisionTest_Test_Case_1](https://i.imgur.com/NSYRLV4.png)
