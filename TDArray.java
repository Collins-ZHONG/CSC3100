// package CSC3100;

public class TDArray {
    public static void main(String args) {
        int[][] a = new int[3][];
        int[] b = {1,2};
        a[0] = b;
        a[1] = new int[]{3,4};
        a[2] = new int[]{4,5};
        printTDArray(a);
    }
    public static void printTDArray(int[][] a) {
        // System.out.println("check");
        for (int i = 0; i<a.length; i++) {
            System.out.println(a[i][0]+"and"+a[i][1]);
        }
    }
}
