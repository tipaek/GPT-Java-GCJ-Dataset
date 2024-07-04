
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.math.BigInteger; 

public class Solution {
 
    static boolean flag= false;
    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test_cases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= test_cases; ++i) {
            int row = in.nextInt();
            int column = in.nextInt();
            BigInteger sum = new BigInteger("0");
            int[][] matrix = new int[row][column];
            
            for(int r=0;r<row;r++){
                for(int c=0;c<column;c++){
                    matrix[r][c] = in.nextInt();
                    sum = sum.add(BigInteger.valueOf(matrix[r][c]));
                    
                }
            }
            flag = true;
            while(flag){
                flag = false;
                check(matrix);
                if(flag)sum = sum.add(BigInteger.valueOf(calculate(matrix)));
            }

        
        System.out.println("Case #" + i + ": "+ sum);
        }
    }

    private static long calculate(int[][] matrix) {
        long sum =0;
        for(int r=0;r<matrix.length;r++){
                for(int c=0;c<matrix[0].length;c++){
                    if(matrix[r][c]>0){
                                sum += matrix[r][c];
                }
            }
        }
        return sum;
    }

    private static void check(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        
        //check rows
        long[] sum_array_x= new long[row];
        long[] count_array_x= new long[row];
        long[] sum_array_y= new long[column];
        long[] count_array_y= new long[column];
        
        
        for(int r=0;r<row;r++){
                for(int c=0;c<column;c++){
                    if(matrix[r][c]>0){
                        sum_array_x[r]+= matrix[r][c];
                        count_array_x[r]++;
                        sum_array_y[c]+= matrix[r][c];
                        count_array_y[c]++;
                    }
                }
        }
        
         for(int r=0;r<row;r++){
                for(int c=0;c<column;c++){
                    double rowValue=0.0;
                    double columValue=0.0;
                    if(count_array_x[r]>0) rowValue = (sum_array_x[r]+0.0)/count_array_x[r];
                    if(count_array_y[c]>0) columValue = (sum_array_y[c]+0.0)/count_array_y[c];
                    double current = (double) matrix[r][c];
                    if(!(current>=rowValue && current>=columValue)){
                        if(matrix[r][c]!=-1) flag = true;
                        matrix[r][c] = -1;
                    }
                }
        }
         
    }
}


