
import java.util.*;

public class A4_P1_122090814 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Scanner sc = new Scanner("C:/Users/Collins/Python/Java/CSC3100/Assignment4/sample_as4/sample_dfs.in");
        int times = sc.nextInt();
        for (int t=0; t<times; t++) {
            int n = sc.nextInt();
            if (n==1) {     // 极特殊情况, 输入只有node 1
                if (sc.nextInt() == 1) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else
            {
            int[] fathers = new int[n];
            int[] numberOfChildren = new int[n];

            int tmp;        // 1 <= pi <= i-1   -->  1 <= pn <= n-1  -->  1 <= tmp <= n-1
            for (int i=1; i<n; i++) {
                tmp = sc.nextInt();
                fathers[i] = tmp;       // father of the i node is pi, where i = (id - 1), tmp = id
                                        // For node 1 (root), here i = 0, tmp = 1
                numberOfChildren[tmp-1]++;      // ArrayIndexOutOfBoundsException: 7
            }

            // input part
            Stack<Integer> s = new Stack<>();
            s.push(sc.nextInt());   // the first input must be 1
            int current, next;
            for (int i=1; i<n; i++) {
                // if (s.empty()) {    
                //     s.push(sc.nextInt());
                // } 
                current = s.peek();         // current is the one in the stack, refer to the true id
                next = sc.nextInt();        // next is the newly imported number, also true id

                if (fathers[next-1] != current) {
                    // 还要继续走完所有 int 不然下一个 test case 会读到上一个 test
                    // 妈的要是能整行输入就好了
                    for (int j=i+1; j<n; j++) {
                        sc.nextInt();
                    }
                    // System.out.println("NO");
                    break;
                } 
                
                numberOfChildren[current-1] --;
                if (numberOfChildren[next-1] == 0) {     // leaf, have to check if pop
                    while (!s.empty() && numberOfChildren[current-1] == 0) {
                        s.pop();
                        if (s.empty()) break;
                        current = s.peek();
                    }
                } else {    // not leaf, append in the stack
                    s.push(next);
                }

                // if success: the stack is empty or the for loop naturally end
                
            }
            // System.out.println(s.size());
            
            System.out.println((s.empty() ? "YES" : "NO"));
            }
        }   
        sc.close();
    }
}
