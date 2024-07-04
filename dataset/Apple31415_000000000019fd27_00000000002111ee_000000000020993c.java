
import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numcases = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < numcases;  i++) {
            int size = Integer.parseInt(br.readLine());
            int[][] matrix = new int[size][size];
            
            for (int j = 0; j  < size; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k <  size; k++)
                    matrix[j][k] = Integer.parseInt(st.nextToken());
            }
            
            int trace = 0;
            for (int j = 0; j < size; j++)
                trace += matrix[j][j];
            
            int rowcount = 0;
            int colcount = 0;
            for (int j = 0; j < size; j++) {
                TreeSet<Integer> row = new TreeSet<>();
                for (int k = 0; k <  size; k++) {
                    if (!row.add(matrix[j][k])) {
                        rowcount++;
                        break;
                    }
                }
            }   
            for (int j = 0; j < size; j++) {
                TreeSet<Integer> col = new TreeSet<>();
                for (int k = 0; k <  size; k++) {
                    if (!col.add(matrix[k][j])) {
                        colcount++;
                        break;
                    }
                }
            }   
            
            System.out.printf("Case #%d: %d %d %d%n", i + 1, trace, rowcount, colcount);
            
        }
        
        
    }
    
}