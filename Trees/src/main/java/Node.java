import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.ArrayList;

@JsonAutoDetect()
public class Node {
    public String key;
    public ArrayList<Node> sons;

    public Node(){
        this.sons = new ArrayList<Node>();
        this.key = "";
    }

    public Node(String key) {
        this.sons = new ArrayList<Node>();
        this.key = key;
    }

    public void addNode_key(String key){
        Node nodeToAdd = new Node(key);
        this.sons.add(nodeToAdd);
    }

    public void addNode(Node nodeToAdd){
        this.sons.add(nodeToAdd);
    }

    public void deleteNode(String key){
        for (Node current: this.sons){
            if(current.key.equals(key)) {
                this.sons.remove(current);
                break;
            }
        }
    }

    public void deleteAllNodes(){
        while(this.sons.stream().count() != 0)
            this.sons.remove(0);
    }

    public Node findNode (String key){
        for (Node current: this.sons) {
            if (current.key.equals(key))
                return current;
        }
        return null;
    }

    public void treePrint()
    {
        System.out.println("(" + this.key + ")");
        for (Node current: this.sons)
            current.treePrint(1);
    }

    public void treePrint(int count)
    {
        for (int i = 0; i < count; i++)
            System.out.print("\t");
        System.out.println("(" + this.key + ")");
        for (Node current: this.sons)
            current.treePrint(count + 1);
    }

    public void changeNode (String key){
        this.key = key;
    }
}
