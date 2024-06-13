import java.util.*;

public class A4_P2_122090814 {
    public static int[] color;
    public static int[] update;
    public static int[][] priceTable;
    public static int n, w;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        w = sc.nextInt();

        priceTable = new int[n][];
        update = new int[n];
        color = new int[n];
        for (int i=0; i<n; i++) {
            priceTable[i] = new int[n];
            update[i] = w;

            int temp;
            for (int j=0; j<n; j++) {
                temp = sc.nextInt();
                // priceTable[i][j] = (temp < w) ? temp : w;       // if price higher than original price, replace it
                priceTable[i][j] = temp;
            }
        }
        sc.close();


        prim();      // O(n2)
        int summation = 0;
        for (int i : update) {
            summation += i;
        }
        System.out.println(summation);
    }

    public static void prim() {
        int min_price;
        int next = 0;
        int current = 0;
        for (int k=0; k<n; k++) {                                  // O(n)
            min_price = Integer.MAX_VALUE;
            color[current] = 1;

            /*
            In Prim's algorithm, all nodes is only updated once
            in each iteration, we choose the explored but not yet visited node to be the next one
            */

            // for the current node, update all its adjacent node
            for (int i=0; i<n; i++) {                                   // O(n)
                
                // also note that 0 is not "buy one get one free"
                if (color[i] == 0 && (priceTable[current][i] < update[i] && priceTable[current][i] > 0)) {
                    // update cost if the price is lower than the current 
                    update[i] = priceTable[current][i];
                }
            }

            // choose the node with lowest next cost to arrive with current nodes (also being adjacent to all current nodes)
            for (int j=0; j<n; j++) {                                   // O(n)

                if (color[j] == 0 && update[j] < min_price) {       // if update[j] <= min_price, we choose the largest index when equal
                    min_price = update[j];
                    next = j;
                }
            }
            current = next;
        }
    }
}
