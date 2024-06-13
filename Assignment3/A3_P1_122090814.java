package CSC3100.Assignment3;
import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();

        pigcup(s);
    }

    public static void pigcup(String s) {

        int a=0, b=0;   // note the score of team A & B
        int len = s.length();
        for (int i=0; i<len; i++) {
            char c = s.charAt(i);

            if (c == 'A') a++;
            else if (c == 'B') b++;
            // ignore if O
        }

        System.out.println("A:" + a);
        System.out.println("B:" + b);
        if (a==b) System.out.println("Draw!");
        else System.out.print(a > b ? "A wins!" : "B wins!");
    }
}
