import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;
class Vestigum {
    static boolean duplicates(int [] arr, int n) {
      boolean dups = false;
      Arrays.sort(arr);
      for (int i=0; i < n-1; ++i) {
        if (arr[i] == arr[i+1]) {
          return true;
        }
      }
      return dups;
    }

    static int checkCol(int [][] arr, int n) {
      int sum = 0;
      for (int i=0; i < n; ++i) {
        int [] a = new int [n];
        for (int j=0; j < n; ++j) {
            a[j] = arr[j][i];
        }
        if (duplicates(a, n)) {
              sum++;
        }
    } 
    return sum;
  }

   public static void main(String [] args) {
       Scanner sc = new Scanner(System.in);
       int t = sc.nextInt();
       for (int i=0; i < t; ++i) {
            int sum = 0;
            int r = 0;
            int c  = 0;
            int n = sc.nextInt();
            HashSet<Integer> set = new HashSet<>();
            int [][] arr = new int[n][n];
           for (int k=0; k < n; ++k) {
               for (int j=0; j < n; ++j) {
                   arr[k][j] = sc.nextInt();
                   if (k == j) {
                    sum += arr[k][j];
                   }
                   set.add(arr[k][j]);
               }
               if (set.size() < n) {
                r++;
               }
           }
           c = checkCol(arr, n);

           System.out.println("Case #" + (i+1) + ": " + sum + " " + r + " " + c);
       }
   } 
}