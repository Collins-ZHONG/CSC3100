public class ShellSort {
    public static void main(String[] args) {
        int[] a = {5,4,12,7,4,15,32,12,8,9,10};
    //    shellSort(a);
        int j;
        for (int gap=a.length/2; gap>0; gap/=2) {
            for (int i=gap; i<a.length; i++) {
                int tmp = a[i];
                for (j=i; j>=gap && tmp<a[j-gap]; j-=gap) {
                    a[j] = a[j-gap];
                }
                a[j] = tmp;
            }
        }
        System.out.println(a[0]);
    }
    public static void shellSort(int[] a) {
        int j;
        for (int gap=a.length/2; gap>0; gap/=2) {
            for (int i=gap; i<a.length; i++) {
                int tmp = a[i];
                for (j=i; j>=gap && tmp<a[j-gap]; j-=gap) {
                    a[j] = a[j-gap];
                }
                a[j] = tmp;
            }
        }   
    }
 }