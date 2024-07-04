import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
        	int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    matrix[j][k] = in.nextInt();
                }
            }
            
            int trace = 0;
            for(int j = 0; j < n; j++) {
                trace += matrix[j][j];
            }
            
            int r = 0;
            for(int j = 0; j < n; j++) {
                Set<Integer> s = new HashSet<>();
                for(int k = 0; k < n; k++) {
                    if(!s.contains(matrix[j][k])) {
                       s.add(matrix[j][k]); 
                    } else {
                        r++;
                        break;
                    }
                }
            }
            
            int c = 0;
            for(int j = 0; j < n; j++) {
                Set<Integer> s = new HashSet<>();
                for(int k = 0; k < n; k++) {
                    if(!s.contains(matrix[k][j])) {
                       s.add(matrix[k][j]); 
                    } else {
                        c++;
                        break;
                    }
                }
            }
            
            System.out.println("Case #" + i + ": " + trace + " " + r + " " + c);
        }
        
    }
}