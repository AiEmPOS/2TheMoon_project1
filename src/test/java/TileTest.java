/* Copyright (C) 2021 Worameth Siritanakorn - All Rights Reserved
 * You may use, distribute and modify this code under the terms of the MIT license.
 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import processing.core.PImage;
import processing.data.JSONObject;
import project_16x16.Tileset;
import project_16x16.components.Tile;

public class TileTest {
    PImage test_image;
    Tile newTile;
    @Test
    public void TestGetTileType() {
//        public enum TileType {
//            COLLISION, BACKGROUND, OBJECT, ENTITY;
//        }
        // Tile type COLLISION exists
        test_image = new Tileset.getTile(298, 291, 9, 9, 4);
        newTile = new Tile(4,"test_name", test_image, Tile.TileType.COLLISION);
        Assertions.assertEquals(Tile.TileType.COLLISION, newTile.getTileType());

        // Tile type BACKGROUND exists
        newTile = new Tile(4,"test_name", test_image, Tile.TileType.BACKGROUND);
        Assertions.assertEquals(Tile.TileType.BACKGROUND, newTile.getTileType());

        // Tile type OBJECT exists
        newTile = new Tile(4,"test_name", test_image, Tile.TileType.OBJECT);
        Assertions.assertEquals(Tile.TileType.OBJECT, newTile.getTileType());

        // Tile type ENTITY exists
        newTile = new Tile(4,"test_name", test_image, Tile.TileType.ENTITY);
        Assertions.assertEquals(Tile.TileType.ENTITY, newTile.getTileType());



    }

    @Test
    public void TestGetPImage() {
        PImage test_image = new Tileset.getTile(291, 291, 9, 9, 4);
        Tile newTile = new Tile(4,"test_name", test_image, Tile.TileType.COLLISION);
        Assertions.assertEquals(test_image, newTile.getPImage());
    }
}
