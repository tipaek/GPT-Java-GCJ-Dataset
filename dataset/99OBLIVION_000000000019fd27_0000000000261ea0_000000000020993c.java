import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
    
        Scanner input = new Scanner(System.in);
        
        int t = Integer.parseInt(input.nextLine());
        int n;
        String line;
        int[] lined;
        String[] output;
        
        for(int t = 1; t <= T; t++) {
            
            n = Integer.parseInt(input.nextLine());
            int[][] matrix = new int[n][n];
            for(int x = 0; x < n; x++) {
                
                line = Integer.parseInt(input.nextLine());
                String[] lined = line.split(" ");
                for(int y = 0; y < n; y++) {
                    matrix[y][x] = lined[y];
                }
            }
            output[t-1] = latinSquare(t, n, matrix);
        }
        
        for(int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
    }
    
    public String latinSquare(int x, int n, int[][] matrix) {
        int k = 0;
        int r = 0;
        int c = 0;
        
        boolean repeated;
        
        for(int i = 0; i < n; i++) {
            //trace
            k += matrix[i][i];
            
            //rows check
            for(int j = 0; j < n; j++) {
                repeated = false;
                for(int w = 0; w < n; w++) {
                    value = matrix[w][j];
                    for(int x = 0; x < n; x++) {
                        if(value == matrix[x][j]) repeated = true;
                    }
                }
                if(repeated) r++;
            }
            
            //columns check
            for(int j = 0; j < n; j++) {
                repeated = false;
                for(int w = 0; w < n; w++) {
                    value = matrix[w][j];
                    for(int x = 0; x < n; x++) {
                        if(value == matrix[j][x]) repeated = true;
                    }
                }
                if(repeated) c++;
            }
            
        }
        
        return "Case #" + x + ": " + k + " " + r + " " + c;
    }
    
}