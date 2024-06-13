package CSC3100.Assignment4;
import java.util.*;

public class Q2_2 {

    public static int[][] priceTable;
    // public static int[][] colorTable;
    public static int[] colorTable;
    public static int[] updateTable;
    public static int n, w;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        w = sc.nextInt();       // acquiescent price of buying a gift
        
        priceTable = new int[n][];
        // colorTable = new int[n][];
        colorTable = new int[n];        // 0 -- visited
        updateTable = new int[n];
        // int temp;
        for (int i=0; i<n; i++) {
            priceTable[i] = new int[n];
            // colorTable[i] = new int[n];     // acquiescent 0, black --> 1
            
            updateTable[i] = 10000;

            for (int j=0; j<n; j++) {
                // temp = sc.nextInt();
                // priceTable[i][j] = (temp < w) ? temp : w;       // if price higher than original price, replace it

                priceTable[i][j] = sc.nextInt();        // change at 4.24, 14:52
                // updateTable[i][j] = 10000;

            }
        }
        sc.close();

        updateTable[0] = 0;
        colorTable[0] = 1;
        
        prim();

        for (int k : updateTable) {
            System.out.println(k);
        }
    }

    public static void prim() {
        int i, j;  
        /* 0<= i <=n-1, 0<= j <=n-1,  i != j,  showing all the combination of edges*/

        for (int v=1; v<n-1; v++) {     // for each node in the middle
            // for each edge
            for (i=0; i<n; i++) {
                for (j=0; j<n; j++) {
                    if (i != j && colorTable[i]==1) {       // only consider this case
                        // relax
                        // System.out.println((updateTable[i] + priceTable[i][j]) + " " + updateTable[j] + " from" + (i+1) + " to" + (j+1));
                        // updateTable[j] = (updateTable[i] + priceTable[i][j] < updateTable[j]) ? (updateTable[i] + priceTable[i][j]) : updateTable[j];
                        
                        updateTable[j] = (priceTable[i][j] < updateTable[j]) ? (priceTable[i][j]) : updateTable[j];     // 如果更低就update
                        colorTable[j] = 1;
                    }
                }
            }
        }
    }
}
