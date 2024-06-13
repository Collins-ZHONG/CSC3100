package CSC3100.Assignment1;
import java.util.*;

public class QOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();   // T is the number of cases
        
        int n, k, id;
        int a;
        for (int t = 0; t<T; t++) { // for all test cases

            // in each test case
            n = sc.nextInt();
            k = sc.nextInt();
            id = sc.nextInt();

            //mergeSort part
            if (id == 1 || id == 2) {
                int[][] array = new int[n][2];
                for (int i=0; i<n; i++) {
                    a=sc.nextInt();
                    array[i][0] = a/k;
                    array[i][1] = a % k;
                }
                mergeSort1(array, id);
                for (int j = 0; j<n; j++) {
                    System.out.println(array[j][0]+" "+array[j][1]);
                }
                System.out.println(' ');

            } else if (id == 3 || id == 4) {
                int[] as = new int[n];
                for (int i=0; i<n; i++) {
                    a=sc.nextInt();
                    as[i] = a;
                }
                mergeSort2(as, id, k);
                // below are outputs
                for (int p = 0; p<n; p++) {
                    System.out.println(as[p]);
                }
                System.out.println(' ');
            }   
        }
        sc.close();      // remember to close the Scanner
    }
    public static void mergeSort1(int[][] a, int id) {
        int[][] tmpArray = new int[a.length][2];
        mergeSort1(a, tmpArray, 0, a.length-1, id);
    }
    private static void mergeSort1(int[][] a, int[][] tmpArray, int left, int right, int id) {
        if (left < right) {
            int center = (left+right) / 2;
            mergeSort1(a, tmpArray, left, center, id);
            mergeSort1(a, tmpArray, center + 1, right, id);

            if (id == 1) {
                merge1(a, tmpArray, left, center+1, right);
            } else if (id == 2) {
                merge2(a, tmpArray, left, center+1, right);
            }
        }
    }
    public static void mergeSort2(int[] a, int id, int k) {
        int[] tmpArray = new int[a.length];
        mergeSort2(a, tmpArray, 0, a.length-1, id, k);
    }
    private static void mergeSort2(int[] a, int[] tmpArray, int left, int right, int id, int k) {
        if (left < right) {
            int center = (left+right) / 2;
            mergeSort2(a, tmpArray, left, center, id, k);
            mergeSort2(a, tmpArray, center + 1, right, id, k);
            if (id == 3) {
                merge3(a, tmpArray, left, center+1, right, k);
            } else if (id == 4) {
                merge4(a, tmpArray, left, center+1, right, k);
            }
        }
    }

    public static void merge1(int[][] array, int[][] tmpArray, int leftPos, int rightPos, int rightEnd) {
        // sort all points by x-coordinates from smallest to largest
        int leftEnd = rightPos - 1, tmpPos = leftPos;
        int numElements = rightEnd - leftPos +1;

        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (array[leftPos][0] < array[rightPos][0]) {
                tmpArray[tmpPos++] = array[leftPos++];
            } else if (array[leftPos][0] > array[rightPos][0]) {
                tmpArray[tmpPos++] = array[rightPos++];
            } else if (array[leftPos][0] == array[rightPos][0]) {
                // sort by y-coordinates from smallest to largest
                if (array[leftPos][1] <= array[rightPos][1]) {
                    tmpArray[tmpPos++] = array[leftPos++];
                } else {
                    tmpArray[tmpPos++] = array[rightPos++];
                }
            }
        }
        while (leftPos <= leftEnd) {
            tmpArray[tmpPos++] = array[leftPos++];
        }
        while (rightPos <= rightEnd) {
            tmpArray[tmpPos++] = array[rightPos++];
        }
        for (int i=0; i<numElements; i++, rightEnd--) {
            array[rightEnd] = tmpArray[rightEnd];
        }
    }
    public static void merge2(int[][] array, int[][] tmpArray, int leftPos, int rightPos, int rightEnd) {
        // sort all points by x-coordinates from largest to smallest
        int leftEnd = rightPos - 1, tmpPos = leftPos;
        int numElements = rightEnd - leftPos +1;

        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (array[leftPos][0] > array[rightPos][0]) {           // in the contrary of the above
                tmpArray[tmpPos++] = array[leftPos++];
            } else if (array[leftPos][0] < array[rightPos][0]) {
                tmpArray[tmpPos++] = array[rightPos++];
            } else if (array[leftPos][0] == array[rightPos][0]) {
                // sort by y-coordinates from smallest to largest
                if (array[leftPos][1] <= array[rightPos][1]) {
                    tmpArray[tmpPos++] = array[leftPos++];
                } else {
                    tmpArray[tmpPos++] = array[rightPos++];
                }
            }
        }
        while (leftPos <= leftEnd) {
            tmpArray[tmpPos++] = array[leftPos++];
        }
        while (rightPos <= rightEnd) {
            tmpArray[tmpPos++] = array[rightPos++];
        }
        for (int i=0; i<numElements; i++, rightEnd--) {
            array[rightEnd] = tmpArray[rightEnd];
        }
    }
    public static void merge3(int[] array, int[] tmpArray, int leftPos, int rightPos, int rightEnd, int k) {
        // sort all elemnt a by sorting x from smallest to largest
        int leftEnd = rightPos - 1, tmpPos = leftPos;
        int numElements = rightEnd - leftPos +1;

        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (array[leftPos]/k < array[rightPos]/k) {
                tmpArray[tmpPos++] = array[leftPos++];
            } else if (array[leftPos]/k > array[rightPos]/k) {
                tmpArray[tmpPos++] = array[rightPos++];
            } else if (array[leftPos]/k == array[rightPos]/k) {
                // sort by y-coordinates from largest to smallest
                if (array[leftPos]%k > array[rightPos]%k) {
                    tmpArray[tmpPos++] = array[leftPos++];
                } else {
                    tmpArray[tmpPos++] = array[rightPos++];
                }
            }
        }
        while (leftPos <= leftEnd) {
            tmpArray[tmpPos++] = array[leftPos++];
        }
        while (rightPos <= rightEnd) {
            tmpArray[tmpPos++] = array[rightPos++];
        }
        for (int i=0; i<numElements; i++, rightEnd--) {
            array[rightEnd] = tmpArray[rightEnd];
        }
    }
    public static void merge4(int[] array, int[] tmpArray, int leftPos, int rightPos, int rightEnd, int k) {
        // sort all elemnt a by sorting x from largest to smallest
        int leftEnd = rightPos - 1, tmpPos = leftPos;
        int numElements = rightEnd - leftPos +1;

        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (array[leftPos]/k > array[rightPos]/k) {
                tmpArray[tmpPos++] = array[leftPos++];
            } else if (array[leftPos]/k < array[rightPos]/k) {
                tmpArray[tmpPos++] = array[rightPos++];
            } else if (array[leftPos]/k == array[rightPos]/k) {
                // sort by y-coordinates from largest to smallest
                if (array[leftPos]%k > array[rightPos]%k) {
                    tmpArray[tmpPos++] = array[leftPos++];
                } else {
                    tmpArray[tmpPos++] = array[rightPos++];
                }
            }
        }
        while (leftPos <= leftEnd) {
            tmpArray[tmpPos++] = array[leftPos++];
        }
        while (rightPos <= rightEnd) {
            tmpArray[tmpPos++] = array[rightPos++];
        }
        for (int i=0; i<numElements; i++, rightEnd--) {
            array[rightEnd] = tmpArray[rightEnd];
        }
    }
}