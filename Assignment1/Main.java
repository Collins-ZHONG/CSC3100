package CSC3100.Assignment1;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),  m = sc.nextInt(), p = sc.nextInt(), i,j;

        long result = 0, k;
        for (int index=0; index<p; index++) {
            i = sc.nextInt();
            j = sc.nextInt();
            k = sc.nextLong();
            result += (n-i+1) * i * j * (m-j+1) * k;

            result = result % 998244353;
        }

        System.out.println(result);
        sc.close();
    }
}
