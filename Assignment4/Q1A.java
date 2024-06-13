package CSC3100.Assignment4;
import java.util.*;

public class Q1A {
    public static LinkedList<Integer>[] childrens;        // storing children information of each node
    public static int[] fathers;
    public static int[] visited;
    public static int[] numberOfChildren;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();

        for (int t=0; t<times; t++) {
            int n = sc.nextInt();

            childrens = new LinkedList[n];
            fathers = new int[n];
            numberOfChildren = new int[n];
            for (int i=0; i<n; i++) {               // initialize children information
                childrens[i] = new LinkedList<>();
            }

            // tree information part
            for (int i=1; i<n; i++) {       // i is (the id of node) - 1
                int tmp = sc.nextInt()-1;
                childrens[tmp].add(i);     // every children only has one value
                // keeps using the (id - 1) instead of true id, i.e. node + 1 == id
                /* There must be values under childrens[0], but not all nodes have childern */
                fathers[i] = tmp;
            }

            int i = 0;      // 记录每个 node 的 children 数
            for (LinkedList<Integer> lst : childrens) {
                numberOfChildren[i] = lst.size();       // if no children, will be 0 
                i++;
            }
            
            
            // input part -- input the array of length n
            visited[0] = sc.nextInt();   // the first input must be 1
            int currentFather = 1;
            int current;
            for (i=0; i<n; i++) {
                current = sc.nextInt();
                if (check(current, currentFather)) {
                    
                }
            }

        }
        sc.close();
    }

}
