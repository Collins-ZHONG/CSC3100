package CSC3100;
import java.util.LinkedList;

public class TNode {
    public int data;
    public LinkedList<TNode> neighborList = new LinkedList<>();
    public int numOfNeighbor = 0;

    public TNode(int e) {
        data = e;
    }
    public void addnode(int e) {
        TNode newNode = new TNode(e);
        this.neighborList.add(newNode);
        numOfNeighbor ++;
    }

    public TNode next() {
        return neighborList.getFirst();
    }
    public TNode next(int i) {
        return neighborList.get(i);
    }
}
