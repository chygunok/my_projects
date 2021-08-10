import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertSame;


public class NodeTest {
    Node sun = new Node("sun");

    Node mercury = new Node("mercury");
    Node venus = new Node("venus");
    Node earth = new Node("earth");
    Node mars = new Node("mars");
    public NodeTest(){
        earth.addNode_key("moon");
        mars.addNode_key("fobos");
        mars.addNode_key("deimos");
        sun.addNode(mercury);
        sun.addNode(venus);
        sun.addNode(earth);
        sun.addNode(mars);
    }

    @Test
    public void createTest(){
        Node newSun = new Node("newSun");
        assertSame("newSun", newSun.key);
    }

    @Test
    public void changeNodeTest(){
        sun.changeNode("newSun");
        assertSame("newSun", sun.key);
    }

    @Test
    public void addNodeTest(){
        sun.addNode_key("pluto");
        assertSame("pluto", sun.findNode("pluto").key);
    }

    @Test
    public void findNodeTest(){
        assertSame(mercury, sun.findNode("mercury"));
        assertSame(venus, sun.findNode("venus"));
        assertSame(earth, sun.findNode("earth"));
    }

    @Test
    public void deleteNodeTest(){
        sun.deleteNode("venus");
        assertFalse(sun.sons.contains(venus));
    }

    @Test
    public void deleteAllNodesTest(){
        sun.deleteAllNodes();
        assertFalse(sun.sons.contains(mercury));
        assertFalse(sun.sons.contains(venus));
        assertFalse(sun.sons.contains(earth));
    }

    @Test
    public void treePrintTest(){
        sun.treePrint();
    }

    @Test
    public void serializeTest(){
        try {
            TestPlayground.serialize(sun);
        } catch(IOException e){
            e.printStackTrace();
        }
        assertTrue(new File("myJson.json").exists());
    }

    @Test
    public void deserializeTest(){
        try {
            assertTrue(new Node("venus").key.equals(TestPlayground.deserialize(new File("myJson.json")).findNode("venus").key));
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
