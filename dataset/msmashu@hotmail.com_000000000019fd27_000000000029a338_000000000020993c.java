import java.util.*;
import java.io.*;
public class Solution {
   public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tcNumber = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= tcNumber; ++i) {
            int lineNumber = in.nextInt();
            int[][] matrix = new int[lineNumber][lineNumber];
            for (int j=0; j < lineNumber; j++) {
                for(int k=0; k < lineNumber; k++) {
                    String ss = in.next();
                    matrix[j][k] = Integer.parseInt(ss);
                }
            }
            
            int diagSum = 0;
            for(int j=0; j<lineNumber; j++) {
                diagSum += matrix[j][j];
            }
            
            int dupRows = 0;
            for(int j=0; j<lineNumber; j++) {
                Set<Integer> set = new HashSet<>();
                for(int k=0; k<lineNumber; k++) {
                    if(set.contains(matrix[j][k])) {
                        dupRows++;
                        break;
                    } 
                    set.add(matrix[j][k]);
                }
            }
            
            int dupCols = 0;
            for(int j=0; j<lineNumber; j++) {
                Set<Integer> set = new HashSet<>();
                for(int k=0; k<lineNumber; k++) {
                    if(set.contains(matrix[k][j])) {
                        dupCols++;
                        break;
                    } 
                    set.add(matrix[k][j]);
                }
            }
            
            System.out.println("Case #" + i + ": " + diagSum + " " + dupRows + " " + dupCols);
        }
        
      }
}