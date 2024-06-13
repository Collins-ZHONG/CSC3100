package CSC3100.Assignment2;
import java.util.*;

public class Q3GPT {
    public static String smallestNumber(String number, int m) {
        Deque<Character> stack = new ArrayDeque<>(number.length()-m);
        
        for (char c : number.toCharArray()) {
            while (!stack.isEmpty() && m > 0 && stack.peekLast() > c) {     // if find the newest number smaller than top
                stack.pollLast();
                m--;
            }
            stack.offerLast(c);
        }
        
        // 如果m还大于0，继续删除数字
        while (m > 0) {
            stack.pollLast();
            m--;
        }
        
        StringBuilder sb = new StringBuilder();
        boolean headZero = true;
        for (char c1: stack) {
            if (headZero && c1 == '0') continue;
            else headZero = false;
            sb.append(c1);
        }
        
        return sb.length()==0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        
        /* Test case 1 */
        // String number = "1942056387";
        // int m = 5;

        /* Test case 2 */
        // String number = "1234";
        // int m = 4;

        Scanner sc = new Scanner(System.in);
        String number = sc.next();
        int m = sc.nextInt();
        sc.close();

        System.out.println(smallestNumber(number, m));
    }
}


// public class Q3GPT {
//     public static String findSmallestNumber(String number, int m) {
//         Deque<Character> stack = new ArrayDeque<>();
        
//         for (char digit : number.toCharArray()) {
//             while (!stack.isEmpty() && m > 0 && stack.peekLast() > digit) {
//                 stack.pollLast();
//                 m--;
//             }
//             stack.offerLast(digit);
//         }
        
//         // 如果m还大于0，继续删除数字
//         while (m > 0) {
//             stack.pollLast();
//             m--;
//         }
        
//         // 构建最终的数字字符串，确保不以0开头
//         StringBuilder sb = new StringBuilder();
//         boolean leadingZero = true;
//         for (char c : stack) {
//             if (leadingZero && c == '0') {
//                 continue;
//             }
//             leadingZero = false;
//             sb.append(c);
//         }
        
//         return sb.length() == 0 ? "0" : sb.toString();   // 如果字符串全是0，也就是去掉开头的 0 就是空了， 那就只输出一个 0
//     }

//     public static void main(String[] args) {
//         String number = "1942056387";
//         int m = 4;
//         String smallestNumber = findSmallestNumber(number, m);
//         System.out.println("Smallest number after removing " + m + " digits: " + smallestNumber);
//     }
// }