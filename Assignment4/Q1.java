package CSC3100.Assignment4;
import java.util.*;

public class Q1 {
    public static LinkedList<Integer>[] childrens;        // storing children information of each node
    public static int[] visited;
    public static int count;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();

        for (int t=0; t<times; t++) {
            
            int n = sc.nextInt();
            childrens = new LinkedList[n];
            for (int i=0; i<n; i++) {               // initialize children information
                childrens[i] = new LinkedList<>();
            }

            // tree information part
            for (int i=1; i<n; i++) {       // i is (the id of node) - 1
                childrens[sc.nextInt()-1].add(i);     // every children only has one value
                // keeps using the (id - 1) instead of true id, i.e. node + 1 == id
                /* There must be values under childrens[0], but not all nodes have childern */
            }

            // comparison part
            int[] comp = new int[n];
            for (int j=0; j<n; j++) {
                comp[j] = sc.nextInt();
            }
            

            // algorithm part
            visited = new int[n];
            visited[0] = 1; // a place will not be entered
            count = 0;
            dfs(0);     // start dfs from the first one


            /* Compare comp and visited */
            if (Arrays.equals(comp, visited)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
        sc.close();
    }

    public static void dfs(int node) {
        
        visited[count] = node+1;      // add node to visited, here we need assign real id

        for (int child : childrens[node]) {
            if (!checkVistied(child)) {
                count++;
                dfs(child);
            } // end if
        } // end for

    } // end procedure

    public static boolean checkVistied(int node) {
        for (int i : visited) {
            if (i == 0) {
                return false;
            } else if (node+1 == i) {
                return true;
            }
        }
        return false;       // no such cases in theory, all end in i==0
    }
}
