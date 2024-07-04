
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    
    public void print2darr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            String s = "";
            for (int j = 0; j < arr[0].length; j++) {
                s += Integer.toString(arr[i][j]) + " ";
            }
            System.out.println(s);
        }
    }
    
    public int trace(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][i];
        }

        return sum;
    }

    public int[] check(int[][] arr) {
        int[] ans = new int[2];
        boolean[] row = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
             
                if (row[arr[i][j] - 1] == true) {
                    ans[0] += 1;
                    break;
                } else {
                    row[arr[i][j] - 1] = true;
                }
            }
            row = new boolean[arr.length];
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (row[arr[j][i] - 1] == true) {
                    ans[1] += 1;
                    break;
                } else {
                    row[arr[j][i] - 1] = true;
                }
            }
            row = new boolean[arr.length];
        }
        
        return ans;
    }

    public static void main(String[] args) {

        Solution p = new Solution();
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            int[][] arr = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int j2 = 0; j2 < n; j2++) {
                    arr[j][j2] = s.nextInt();
                }
            }
            int k = p.trace(arr);
            int[] ans = p.check(arr);
            int r = ans[0];
            int c = ans[1];
            System.out.println("Case #" + (i + 1) + ": " + k + " " + r + " " + c);
        }
    }
}