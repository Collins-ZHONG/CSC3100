package CSC3100.Assignment3;
import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i=0; i<t; i++) {
            int r1 = sc.nextInt();
            double r2 = sc.nextDouble();
            int d = sc.nextInt();
            // System.out.println(r2);

            double rind = r1*r1*r1 - (r1-d)*(r1-d)*(r1-d);  // 3/4 of the rind
            // System.out.println(rind);

            // double one=1.0, three=3.0;
            // System.out.println(one/three);; 
            double ans = r2 - Math.pow(r2*r2*r2 - rind, 1.0/3.0);
            System.out.println(ans);
        }
        sc.close();
    }
}