import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int[][] arr = new int[n][n];

        //init
        for(int j=0; j<n; j++){
            for(int k=0; k<n; k++) {
                arr[j][k] = in.nextInt();
            }
        }
        int k = countK(arr,n);
        int r = countR(arr,n);
        int c = countC(arr,n);
        
        Sysemt.out.println("Case #" + i + ": " + k + " " + r + " "+ c);
    }
  }
  public static int countK(int[][] arr, int size){
        int k=0;
        for(int i=0; i<size; i++){
            k += arr[i][i];
        }
        return k;
    }

    public static int countR(int[][] arr, int size){
        int sum=0;
        for(int i=0; i<size; i++){
            Set<Integer> set = new HashSet<>();
            for(int j=0; j<size; j++){
                if(set.contains(arr[i][j])){
                    sum += 1;
                    break;
                }
                set.add(arr[i][j]);
            }
        }
        return sum;
    }

    public static int countC(int[][] arr, int size){
        int sum=0;
        for(int i=0; i<size; i++){
            Set<Integer> set = new HashSet<>();
            for(int j=0; j<size; j++){
                if(set.contains(arr[j][i])){
                    sum += 1;
                    break;
                }
                set.add(arr[j][i]);
            }
        }
        return sum;
    }
}