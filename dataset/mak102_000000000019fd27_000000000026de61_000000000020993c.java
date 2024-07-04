import java.util.*;
public class Main
{
	public static void main(String[] args) {
	
		Scanner scanner= new Scanner(System.in); 
		
        int t = scanner.nextInt();
        int n;
        
        while(t < 1 || t > 100){
            System.out.println("You Entered the wrong number , Enter The number between 1 and 100 :");
            t = scanner.nextInt();
        }
        
         for (int i = 0; i < t ;i++ ){
             n = scanner.nextInt();
             
             //defining 2D array to hold matrix data
            int[][] m = new int[n][n];
            int[][]transpose = new int[n][n];
            
            // Enter Matrix Data
            enterMatrixData(scanner, m, n, n);
        
             
            
            
            //Code to transpose a matrix
            for(int a =0; a < n ; a++){
                for(int b = 0 ; b < n ; b++){
                    transpose[a][b] = m[b][a];
                }
            }
             
        
    
            System.out.println("Case #"+(i+1) + ":" 
            + diagnalSum(m) + "\t"+ 
            getCommonrow(m,n,n) + "\t" + 
            getCommonrow(transpose,n,n));
         } 
	}
	
	 private static void enterMatrixData(Scanner scan, int[][] matrix, int matrixRow, int matrixCol){
          for (int i = 0; i < matrixRow; i++) {
              for (int j = 0; j < matrixCol; j++) {
                  matrix[i][j] = scan.nextInt();
              }
          }
     }
  
  
  private static int getCommonrow(int[][] square, int matrixRow, int matrixCol){
      int commonRow = 0;
      for(int row = 0 ; row < matrixRow ; row++){
          for(int col = 0 ; col < matrixCol ; col ++){
              int compare = square[row][0];
              int compareTo = square[row][col];
              if(col != 0 && compare == compareTo){
                  commonRow ++;
              }
          }
      }
      
      return commonRow;
  }
  
  private static int diagnalSum(int[][] matrix){
      int sum = 0;
      for (int p = 0 ;p < matrix.length ; p++ ){
          for(int q = 0; q< matrix.length ; q++){
              if (p == q){
                  sum = sum + matrix[p][q];
              }
          }
      }
      
      return sum;
  }
  
}