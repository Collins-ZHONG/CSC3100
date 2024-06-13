package CSC3100.Assignment3;
import java.util.LinkedList;
import java.util.Scanner;

public class tryHashMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        @SuppressWarnings("unchecked")
        LinkedList<int[]>[] list = new LinkedList[10];
        
        
        int x;
        for (int j=0; j<10; j++) {      // 初始化 LinkedList
            list[j] = new LinkedList<>();
        }

        LinkedList<int[]> iterlist;
        for (int i=0; i<n; i++) {
            int[] tmp = new int[2];
            x = sc.nextInt();
            tmp[0] = sc.nextInt();
            tmp[1] = sc.nextInt();
            iterlist = list[x];
            iterlist.addLast(tmp);
        }
        sc.close();
        
        // int r1, r2;
        // r1 = map.get(1)[0];
        // r2 = map.get(1)[1];
        // System.out.println(r1+" "+r2);

        System.out.println(list[1].get(0)[1]);

    }
}
