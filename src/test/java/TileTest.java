import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import processing.core.PImage;
import processing.data.JSONObject;
import project_16x16.Tileset;
import project_16x16.components.Tile;

public class TileTest {

    @Test
    public void TestExportToJSON(){
        JSONObject item = new JSONObject();
        item.setString("id", "5");
        item.setString("type", "COLLISION");
        item.setInt("x", (int) 30);
        item.setInt("y", (int) 40);
        Assertions.assertEquals("5", item.get("id"));
        Assertions.assertEquals("COLLISION", item.get("type"));
        Assertions.assertEquals(30, item.get("x"));
        Assertions.assertEquals(40, item.get("y"));
    }

    @Test
    public void TestGetTileType() {
        PImage test_image = new Tileset.getTile(298, 291, 9, 9, 4);
        Tile newTile = new Tile(4,"test_name", test_image, Tile.TileType.COLLISION);
        Assertions.assertEquals(Tile.TileType.COLLISION, newTile.getTileType());
    }

    @Test
    public void TestGetPImage() {
        PImage test_image = new Tileset.getTile(298, 291, 9, 9, 4);
        Tile newTile = new Tile(4,"test_name", test_image, Tile.TileType.COLLISION);
        Assertions.assertEquals(test_image, newTile.getPImage());
    }
}
