package Java.CSC3100.Assignment2;
import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();

        Deque<Integer> dq = new ArrayDeque<>();     // This is an index deque
        int[] nums = new int[n];                    // need an array to note down the value

        for (int i=0; i<n; i++) {
            nums[i] = sc.nextInt();                 // give such an array
            
            // If current element is greater than or equal to the element at the end of the data structure, discard the later one
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }

            // If the element at the beginning of the data structure and the current one is k distance away, discard the former one
            while (!dq.isEmpty() && i - dq.peekFirst()>=k) {
                dq.pollFirst();
            }
            

            dq.offerLast(i);
            
            if (i>=k-1) {
                // System.out.print(nums[dq.peekFirst()]+" ");   // maximum lies in the beginning of the data structure
                System.out.println(nums[dq.peekFirst()]);
            }
        }
        sc.close();        

    }
}




//     public static void main(String args[]) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt(), k = sc.nextInt();

//         int[] nums = new int[n];            // store number information
//         // int[] ans = new int[n-k+1];         // result

//         // Input the array
//         for (int p=0; p<n; p++) {
//             nums[p] = sc.nextInt();
//         }
//         sc.close();


//         int max=Integer.MIN_VALUE, max_index=-1, left=0, right=k-1;

//         // int i = 0;
//         while (right < n) {       // i also notes the current index
            
//             // 假设最大者还在区间内
//             if (max_index > left) {

//                 // 若新进值为最大值
//                 if (nums[right] >= max) {
//                     max = nums[right];
//                     max_index = right;
//                 }

//             // 最大的从左边出去了
//             } else if (nums[right] >= max) {         // (max_index <= left)
//                 if (max_index == -1) {
//                     for (int q=0; q<k; q++) {
//                         if (nums[q] >= max) {
//                             max_index = q;
//                             max = nums[max_index];
//                         }
//                     }
//                 } else {
//                     max = nums[right];
//                     max_index = right;
//                 }

//             } else {
//                 // looping through the array from left to right to search the second largest
//                 max = nums[left];
//                 max_index = left;
//                 for (int j=left+1; j<=right; j++) {
//                     if (nums[j] >= max) {
//                         max = nums[j];
//                         max_index = j;
//                     }
//                 }
//             }


//             // ans[i] = max;
//             // System.out.print(max+" ");
//             System.out.println(max);
//             // At last, increment indices
//             // i++
//             right++;
//             left++;
//             // if (i > k-1) left++;        // length of the window is (k)
//             // can be changed to  if (i >= k-1)
//         }

//     }
// }
