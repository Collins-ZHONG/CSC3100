package CSC3100.Assignment1;
import java.util.*;

public class QTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        long p = sc.nextLong();

        long result = 0;
        for (int index=0; index<p; index++) {
            result = (result + calculate(n, m, sc.nextLong(), sc.nextLong(), sc.nextLong()));
            result = result % 998244353;
        }

        System.out.println(result % 998244353);
        sc.close();
    }
    public static long calculate(long n, long m, long i, long j, long k) {
        long result = ((n-i+1) * i * j * (m-j+1) * k);
        return result;
    }
}
