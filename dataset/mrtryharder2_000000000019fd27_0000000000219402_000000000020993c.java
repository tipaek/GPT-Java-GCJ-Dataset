import java.util.Scanner;
public class Vestigium {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        int t = input.nextInt();
        
        
        for(int h = 1; h <= t; h++) {
            
            int n = input.nextInt();
            int[][] matrix = new int[n][n];
            
            for(int i = 0; i < matrix.length; i++)
                for(int j = 0; j < matrix[0].length; j++)
                    matrix[i][j] = input.nextInt();
        
            vestigium(matrix, h);
        }
        
        
       
       
    }
    
    public static void vestigium(int[][] matrix, int case_number) {
        
         int r_row_count = 0;
        int r_col_count = 0;
               
       
       //find number of rows with repeated values
        for(int i = 0; i < matrix.length; i++) {
           outer_loop1:
            for(int j = 0; j < matrix[0].length; j++) {
                
                for(int k = j + 1; k < matrix.length; k++)
                    if(matrix[i][j] == matrix[i][k]) {
                        r_row_count++;
                        break outer_loop1;
                    } 
                
                
            }
        }
       
       //find number of columns with repeated values 
       for(int i = 0; i < matrix.length; i++) {
           outer_loop2:
            for(int j = 0; j < matrix[0].length; j++) {
                
                for(int k = j + 1; k < matrix.length; k++)
                    if(matrix[j][i] == matrix[k][i]) {
                        r_col_count++;
                        break outer_loop2;
                    } 
                
                
            }
        }
        
        int trace = 0;
        for(int i = 0; i < matrix.length; i++) trace += matrix[i][i];
            
            
            
        
        System.out.println("Case #" + case_number + ": " + trace + " " + r_row_count + " " + r_col_count);
        
    }
    
}