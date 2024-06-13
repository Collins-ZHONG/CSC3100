package CSC3100.Assignment1;

import CSC3100.TDArray;

public class Test1 {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int T = sc.nextInt();   // T is the number of cases
        int T = 1;
        
        int n, k, id;
        int[] a = {544,243,123};
        for (int t = 0; t<T; t++) { // for all test cases

            // in each test case
            n = 3;
            k = 5;
            id = 1;

            int[][] array = new int[n][2];
            int[] as = new int[n];

            // Append all numbers into 
            for (int i = 0; i<n; i++) {
                as[i] = a[i];
                array[i][0] = a[i] / k;
                array[i][1] = a[i] % k;
            }

            //mergeSort part
            if (id == 1 || id == 2) {
                QOne.mergeSort1(array, id);
            } else if (id == 3 || id == 4) {
                QOne.mergeSort2(as, id, k);
            }
            // Sorting the number
            TDArray.printTDArray(array);
        }

    }
}
