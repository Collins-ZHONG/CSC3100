package CSC3100.Assignment4;
import java.util.*;

public class Q2 {

    public static int[][] priceTable;
    public static int[][] colorTable;
    public static int n, w;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        w = sc.nextInt();       // acquiescent price of buying a gift
        
        priceTable = new int[n][];
        colorTable = new int[n][];
        int temp;
        for (int i=0; i<n; i++) {
            priceTable[i] = new int[n];
            colorTable[i] = new int[n];     // acquiescent 0, black --> 1

            for (int j=0; j<n; j++) {
                temp = sc.nextInt();
                priceTable[i][j] = (temp < w) ? temp : w;       // if price higher than original price, replace it

            }
        }
        /* PriceTable.reverse is equal to PriceTable itself */
        

        // printTable(priceTable);  // prove that the input is valid

        sc.close();
    }

    public static void bellmanFord(int source) {
        int i, j;  
        /* 0<= i <=n-1, 0<= j <=n-1,  i != j,  showing all the combination of edges*/

        for (int v=1; v<n-1; v++) {     // for each node in the middle
            // for each edge
            for (i=0; i<n; i++) {
                for (j=0; j<n; j++) {
                    if (i != j) {       // only consider this case
                        
                    }
                }
            }
        }
    }

    public static void printTable(int[][] table) {
        for (int i=0; i<table.length; i++) {
            for (int j=0; j<table[i].length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
