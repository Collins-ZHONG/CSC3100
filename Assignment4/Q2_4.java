package CSC3100.Assignment4;
import java.util.*;;

public class Q2_4 {
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

        // bellmanFord
        dfs(1, 0);
        int summation = 0;
        for (int i : update) {
            summation += i;
        }
        System.out.println(summation);
    }

    public static void dfs(int father, int recur) {
        int min_value = Integer.MAX_VALUE;
        int min_index = 0;
        color[father] = 1;

        for (int i=0; i<priceTable[father].length; i++) {       // find which to update
            if (color[i] == 0 && (priceTable[father][i] < update[i] && priceTable[father][i] > 0)) {
                update[i] = priceTable[father][i];
            }
        }
        for (int j=0; j<update.length; j++) {       // go over all nodes
            if (color[j] == 0 && update[j] < min_value) {
                min_value = update[j];
                min_index = j;
            }
        }
        if (recur < n) {
            dfs(min_index, recur+1);
        }
    }
}
