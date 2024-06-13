package CSC3100.Assignment4;
import java.util.*;

public class Q2_3 {
    public static int[][] priceTable;
    public static int[] updateTable;
    public static int n, w;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        w = sc.nextInt();

        priceTable = new int[n][];
        updateTable = new int[n];
        for (int i=0; i<n; i++) {
            priceTable[i] = new int[n];
            updateTable[i] = 100000;

            int temp;
            for (int j=0; j<n; j++) {
                temp = sc.nextInt();
                priceTable[i][j] = (temp < w) ? temp : w;       // if price higher than original price, replace it

            }
        }
        sc.close();
        
        /* 
        priceTable[i][j] is the weight from gift i to gift j
        
        */

        updateTable[0] = 3;

        prim();
        
        int sum = 0;
        for (int i : updateTable) {
            sum += i;
        }
        System.out.println(sum);
    }

    public static void prim() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int node=0; node<n; node++) {
            // node can be key to the updateTable
            pq.add( node );
        }

        while (!pq.isEmpty()) {
            int u = pq.poll();
            int[] adjacentPrice = priceTable[u];
            for (int v=0; v<n; v++) {
                if (adjacentPrice[v] != 0) {
                    if (pq.contains(v) && priceTable[u][v] < updateTable[v]) {
                        updateTable[v] = priceTable[u][v];
                    }
                }
            }
        }
    }

    // public static int[] adjacentList(int u) {
    //     int[] adjacent = new int[n];
    //     int num = 0;
    //     for (int i=0; i<priceTable[u].length; i++) {
    //         if (priceTable[u][i] != 0) {
    //             adjacent[i] = i;

    //         }
    //     }
    // }
}
