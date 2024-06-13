package CSC3100;
// import java.util.LinkedList;
import java.util.*;

public class DFS {

    // public static void dfs(TNode root) {
        
    //     for (int i=0; i<root.numOfNeighbor; i++) {
    //         if (root.next(i) == null) break;
    //         dfs(root.next(i));
    //     }
    //     System.out.println(root.data);
    // }

    public static void main(String[] args) {
        TNode root = new TNode(0);
        root.addnode(1);
        root.addnode(1);
        
        TNode n1 = root.next(1);
        n1.addnode(2);
        n1.addnode(2);
        n1.addnode(2);

        TNode n2 = root.next(0);
        n2.addnode(3);
        n2.addnode(3);
        n2.addnode(3);

        TNode n3 = n2.next(2);
        n3.addnode(4);
        n3.addnode(4);

        // dfs(root);
    }
    
    public static int[] color;      // initialized to size n
    public static void dfs(TNode x) {
        color[x] = 1;   // 大致这么个意思
        System.out.println(x.data);
        for (TNode children : x.neighborList) {
            if (color[children] == 0) {
                dfs(children);
            }
        }
    }

    // public static Deque<TNode> dq;
    public static void bfs(TNode x) {
        Deque<TNode> dq = new ArrayDeque<>();   // size n
        dq.offerLast(x);
        color[s] = 1;

        while (!dq.isEmpty()) {
            TNode v = dq.pollFirst();
            for (TNode u : v.neighborList) {
                if (color[u] == 0) {
                    dq.offerFirst(u);
                    color[u] = 1;
                }
            }
            color[v] = 2;
            System.out.println(v.data);
        }

    }   
}


