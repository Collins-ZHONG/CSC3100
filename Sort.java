// package CSC3100;

public class Sort {
    public static void main(String[] args) {
        // int[] a = {2,3,6,1,8,4,9,0};
        // // a= insertionSort(a);
        // mergeSort(a);
        // System.out.println(a[0]);
        // conMergeSort(a);
        // System.out.println(a[0]);
    }
    public static void bubbleSort(int[] arr) {
        int len = arr.length, tmp;
        boolean flag;
        for (int i = 0; i<len; i++) {
            flag = false;
            for (int j = 0; j<len-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    public static void selectionSort(int[] arr) {
        int len = arr.length, tmp, pos;
        for (int i = 0; i<len; i++) {
            pos = i;
            for (int j = i+1; j<len; j++) {
                if (arr[j] < arr[pos]) {
                    pos = j;
                }
            }
            tmp = arr[i];
            arr[i] = arr[pos];
            arr[pos] = tmp;
        }
    }

    public static int[] insertionSort(int[] ar) {
        int len = ar.length;
        for (int j = 1; j<len; j++) {
            int key = ar[j];
            // below is my insertion
            // for (int k = 0; k<j; k++) {
            //     if (k == 0) {
            //         if (ar[0] > key) {
            //             ar[1] = ar[0];
            //             ar[0] = key;
            //         }
            //     }
            //     if (ar[k] < key && ar[k+1] > key) {
            //        int[] temp = new int[len];
            //        System.arraycopy(ar, 0, temp, 0, k+1);   // k号位的不变 
            //        System.arraycopy(ar, k+1, temp, k+2, j-k-1);            // k+1到detect的序列前
            //        System.arraycopy(ar, j, temp, j, len-j);
            //        temp[k+1] = key; 
            //     }
            // }
            int i = j-1;
            while (i>=0 && ar[i] >key) {
                ar[i+1] = ar[i];
                i --;
            }
            ar[i+1] = key;
        }
        return ar;
    }

    public static void mergeSort(int[] a) {     // O(nlogn)
        int[] tempArray = new int[a.length];
        mergeSort(a, tempArray, 0, a.length-1);
    }
    private static void mergeSort(int[] a, int[] tempArray, int left, int right) {
        if (left < right) {
            int center = (left+right) / 2;
            mergeSort(a, tempArray, left, center);
            mergeSort(a, tempArray, center + 1, right);
            merge(a, tempArray, left, center+1, right);
        }
    }
    private static void merge(int[] a, int[] tmpArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos -1, tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;
        
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (a[leftPos] <= a[rightPos]) {
                tmpArray[tmpPos++] = a[leftPos++];
            } else {
                tmpArray[tmpPos++] = a[rightPos++];
            }
        }

        while (leftPos <= leftEnd) {
            tmpArray[tmpPos++] = a[leftPos++];
        }
        while (rightPos <= rightEnd) {
            tmpArray[tmpPos++] = a[rightPos++];
        }
        for(int i = 0; i<numElements; i++, rightEnd--) {    // copy paste the new sorted array
            a[rightEnd] = tmpArray[rightEnd];
        }
    }

    public static void conMergeSort(int[] a) {
        int[] tempArray = new int[a.length];
        conMergeSort(a, tempArray, 0, a.length-1);
    }
    public static void conMergeSort(int[] a, int[] tempArray, int left, int right) {
        if (left < right) {
            int center = (left+right) / 2;
            conMergeSort(a, tempArray, left, center);
            conMergeSort(a, tempArray, center + 1, right);
            conMerge(a, tempArray, left, center+1, right);
        }
    }
    private static void conMerge(int[] a, int[] tmpArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos -1, tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;
        
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (a[leftPos] >= a[rightPos]) {
                tmpArray[tmpPos++] = a[leftPos++];
            } else {
                tmpArray[tmpPos++] = a[rightPos++];
            }
        }

        while (leftPos <= leftEnd) {
            tmpArray[tmpPos++] = a[leftPos++];
        }
        while (rightPos <= rightEnd) {
            tmpArray[tmpPos++] = a[rightPos++];
        }
        for(int i = 0; i<numElements; i++, rightEnd--) {
            a[rightEnd] = tmpArray[rightEnd];
        }
    }

    public static void heapSort(int[] arr) {
        
    }
}
