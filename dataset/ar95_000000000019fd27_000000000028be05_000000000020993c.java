// "static void main" must be defined in a public class.
import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int tc = 1; tc <= t; ++tc) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++) matrix[i][j] = in.nextInt();
            }
            int k = 0;
            for(int i=0; i<n; i++)k+=matrix[i][i];
            int r = 0;
            int c = 0;
            for(int i=0; i<n; i++){
                Set<Integer> seen = new HashSet<>();
                for(int j=0; j<n; j++){
                    if(seen.contains(matrix[i][j])){
                        r++;
                        break;
                    }
                    seen.add(matrix[i][j]);
                }
            }
            for(int i=0; i<n; i++){
                Set<Integer> seen = new HashSet<>();
                for(int j=0; j<n; j++){
                    if(seen.contains(matrix[j][i])){
                        c++;
                        break;
                    }
                    seen.add(matrix[j][i]);
                }
            }
            System.out.println("Case #" + tc + ": " + k + " " + r +" "+c);
        }
    }
}