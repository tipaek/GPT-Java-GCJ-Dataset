import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
    
        Scanner input = new Scanner(System.in);
        
        int t = Integer.parseInt(input.nextLine());
        int n;
        String line;
        String[] output = new String[t];
        
        for(int q = 1; q <= t; q++) {
            
            n = Integer.parseInt(input.nextLine());
            int[][] matrix = new int[n][n];
            for(int x = 0; x < n; x++) {
                int[][] intLine = new int[n][n];
                line = input.nextLine();
                String[] lined = line.split(" ");
                for(int k = 0; k < lined.length; k++) {
                  intLine[k][x] = Integer.parseInt(lined[k]);
                }
                for(int y = 0; y < n; y++) {
                    matrix[y][x] = intLine[y][x];
                }
            }
            output[q-1] = latinSquare(q, n, matrix);
        }
        
        for(int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
    }
    
    public static String latinSquare(int x, int n, int[][] matrix) {
        int k = 0;
        int r = 0;
        int c = 0;

        int hold;

        boolean repeated;
        
        for(int i = 0; i < n; i++) {
            //trace
            k += matrix[i][i];
        }
        //rows check
        for(int i = 0; i < n; i++) {
          repeated = false;
          for(int a = 0; a < n; a++) {
            for(int b = a+1; b < n; b++) {
              if(b!=a && matrix[a][i] == matrix[b][i]) {
                repeated=true;
              }
            }
          }
          if(repeated) r++;
        }

        //columns check
        for(int i = 0; i < n; i++) {
          repeated = false;
          for(int a = 0; a < n; a++) {
            for(int b = a+1; b < n; b++) {
              if(b!=a && matrix[i][a] == matrix[i][b]) {
                repeated=true;
              }
            }
          }
          if(repeated) c++;
        }
    
        return "Case #" + x + ": " + k + " " + r + " " + c;
    }
    
}