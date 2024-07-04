import java.util.*;
import java.io.*;
public class Solution {
    
    public static int[] duplicate(int n, int[][] matrix) {
        int rows = 0;
        int cols = 0;
        
        for(int i=0; i<n; i++) {
            Set<Integer> visited = new HashSet<>();
            for(int j=0; j<n; j++) {
                if(visited.contains(matrix[i][j])) {
                    rows++;
                    break;
                } else {
                    visited.add(matrix[i][j]);
                }
            }
        }
        for(int i=0; i<n; i++) {
            Set<Integer> visited = new HashSet<>();
            for(int j=0; j<n; j++) {
                if(visited.contains(matrix[j][i])) {
                    cols++;
                    break;
                } else {
                    visited.add(matrix[j][i]);
                }
            }
        }
        
        return new int[] {rows, cols};
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        for (int k = 1; k <= t; ++k) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            for(int i=0; i< n; i++) {
                for(int j=0; j< n; j++) {
                    matrix[i][j] = in.nextInt();
                    if(i==j) {
                        trace += matrix[i][j];
                    }
                }
            }
            int[] answer = duplicate(n, matrix);
            
            System.out.println("Case #" + k + ": " + trace + " " + answer[0] + " " + answer[1]);
        }
    }
}