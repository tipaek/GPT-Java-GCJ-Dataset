import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;
class Solution {
    static int checkCol(int [][] arr, int n) {
      int sum = 0;
      for (int i=0; i < n; ++i) {
        HashSet<Integer> set = new HashSet<>();
        for (int j=0; j < n; ++j) {
            set.add(arr[j][i]);
        }
        if (set.size() < n) {
              sum++;
          }
      } 
      return sum;
    }

    static int checkRow(int [][] arr, int n) {
      int sum = 0;
      for (int [] a: arr) {
        if (duplicates(a, n)) {
          sum++;
        }
      }
      return sum;
    }

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


   public static void main(String [] args) {
       Scanner sc = new Scanner(System.in);
       int t = sc.nextInt();
       for (int i=1; i <= t; ++i) {
            int sum = 0;
            int r = 0;
            int c  = 0;
            int n = sc.nextInt();
            //HashSet<Integer> set = new HashSet<>();
            int [][] arr = new int[n][n];
           for (int k=0; k < n; ++k) {
               for (int j=0; j < n; ++j) {
                   arr[k][j] = sc.nextInt();
                   if (k == j) {
                    sum += arr[k][j];
                   }
                   //set.add(arr[k][j]);
               }
               // if (set.size() < n) {
               //  r++;
               // }
           }
           c = checkCol(arr, n);
           r = checkRow(arr, n);
           System.out.println("Case #" + i + ": " + sum + " " + r + " " + c);
       }
   } 
}