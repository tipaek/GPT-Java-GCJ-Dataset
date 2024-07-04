import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; i++) {
      int n = in.nextInt();
      in.nextLine();
      
      int[][] arr = new int[n][n];
      int trace = 0;
      int rows = 0;
      for (int j = 0; j < n; j++) {
         boolean contains = false;
         ArrayList<Integer> temp = new ArrayList<Integer>();
         for (int k = 0; k < n; k++) {
            int curr = in.nextInt();
            arr[j][k] = curr;
            if (temp.contains(curr) && contains == false) {
               rows++;
               contains = true;
            }
            temp.add(curr);
            if (j == k)
               trace += curr;
                     }
      }
      System.out.println("Case #" + i + ": " + trace + " " + rows + " " + col(arr, n));
    }
  }
  
  public static int col(int[][] arr, int n) {
      int temp = 0;
      for (int i = 0; i < arr.length; i++) {
         Set<Integer> s = new HashSet<Integer>();
         for (int j = 0; j < arr.length; j++) {
            s.add(arr[j][i]);
         }
         if (s.size() != n)
            temp++;
      }
      return temp;
  }
}