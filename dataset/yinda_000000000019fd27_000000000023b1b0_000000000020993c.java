import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for(int a = 0; a < n; a++){
                for(int b = 0; b < n ;b++){
                    matrix[a][b] = in.nextInt();
                }
            }
            int[] ans = helper(matrix);
            System.out.println("Case #" + i+ ": " + ans[0] + " " + ans[1] + " " + ans[2]);
        }
    }

    public static int[] helper(int[][] matrix){
        int[] ans = new int[3];
        int n = matrix.length;
        for(int i  = 0; i < n; i++){
            ans[0]+=matrix[i][i];
        }
        for(int i  = 0; i < n; i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j = 0; j < n; j++){
                if(set.contains(matrix[i][j])){
                    ans[1]++;
                    break;
                }
                set.add(matrix[i][j]);
            }
        }
        for(int i  = 0; i < n; i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j = 0; j < n; j++){
                if(set.contains(matrix[j][i])){
                    ans[2]++;
                    break;
                }
                set.add(matrix[j][i]);
            }

        }
        return ans;
    }
}
  