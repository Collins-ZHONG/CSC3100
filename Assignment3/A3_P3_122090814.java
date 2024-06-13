package CSC3100.Assignment3;
import java.util.*;

public class A3_P3_122090814 {
    // The 3 global variables need to be invoked globally
    // public static HashMap<Integer, int[]> neighbors;
    public static LinkedList<int[]>[] neighbors;
    public static int[] colors, bsize;
    public static long[] ans;
    public static int n;

    @SuppressWarnings("unchecked")  // quick fix
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        colors = new int[n];
        int tmp;
        for (int t=0; t<n; t++) {       // color information
            tmp = sc.nextInt();
            colors[t] = (tmp == 1) ? 1:0;

        }
        // ArrayList<Integer>[] neighbors = new ArrayList<>[n];
        neighbors = new LinkedList[n + 1];   // range from 0 to n, 0 for initalize
        int x, y, e;
        int[] tmp_1 = new int[2];
        // for initialization
        for (int l=0; l<n+1; l++) {
            neighbors[l] = new LinkedList<>();
        }
        tmp_1[0] = 1;
        tmp_1[1] = 0;       // initialization costs 0
        neighbors[0].add(tmp_1);
        for (int k=0; k<n-1; k++) {       // edge information
            tmp_1 = new int[2]; // in case not overload
            x = sc.nextInt();
            y = sc.nextInt();
            e = sc.nextInt();
            tmp_1[0] = y;
            tmp_1[1] = e;
            neighbors[x].add(tmp_1);
            tmp_1 = new int[]{x, e};
            neighbors[y].add(tmp_1);
        }
        sc.close();

        // check
        // System.out.println(neighbors[1].get(1)[0]);
        
        ans = new long[n];
        bsize = new int[n];       // black size of the tree rooted at each node i
        // remember the index in ans and bsize should minus 1
        
        dfs(1, 0, 0);
        update(1, 0);

        for (long i : ans) {
            System.out.println(i);
            // System.out.print(i + " ");
        }
        // System.out.println(" ");
    }
    public static void dfs(int x, int father, long distance) {
        long d1 = ((1000000007 + distance) % 1000000007);
        ans[0] += (colors[x-1]==1) ? d1 : 0;
        ans[0] = ans[0] % 1000000007;
        bsize[x-1] += (colors[x-1] == 1) ? 1 : 0;

        // for (int[] tmp : neighbors.get(x)) {
        int[] tmp;
        int size = neighbors[x].size();
        for (int i=0; i<size; i++) {        // iterate all neighbors
            tmp = neighbors[x].get(i);
            
            if (tmp[0] != father) {
                dfs(tmp[0], x, tmp[1]+distance);     // the bsize[y] would be set in the recursion
                bsize[x-1] += bsize[tmp[0]-1];
            }
        }
    }

    public static void update(int x, int father) {
        // System.out.println("Recursion: From "+ father+" to "+x);

        int size = neighbors[x].size();
        int[] tmp;
        for (int i=0; i<size; i++) {
            tmp = neighbors[x].get(i);

            if (tmp[0] != father) {
                // System.out.println("from "+x+" to "+tmp[0]+" cost "+tmp[1]);
                // long a1 = (1000000007 + tmp[1]*bsize[0]) % 1000000007;
                // long a2 = (1000000007 + 2*tmp[1]*bsize[tmp[0]-1]) % 1000000007;
                // long a3 = (1000000007 + ans[x-1] + a1 - a2) % 1000000007;
                // ans[tmp[0]-1] = (1000000007 + a3) % 1000000007;
                ans[tmp[0]-1] = (1000000007 + ans[x-1] + (1000000007 +tmp[1]*bsize[0])% 1000000007 - (1000000007 +2*tmp[1]*bsize[tmp[0]-1])% 1000000007) % 1000000007;
                update(tmp[0], x);
            }
        }
    }
}
 