import java.util.Scanner;
class Vestigium
{
     public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter The Number Of Matrix Rows");
         
        int matrixRow = scan.nextInt();
         
        System.out.println("Enter The Number Of Matrix Columns");
         
        int matrixCol = scan.nextInt();
        
        System.out.println("Enter value of n : ");
        
        int n= scan.nextInt();
         
        //defining 2D array to hold matrix data
        int[][] matrix = new int[matrixRow][matrixCol];
        // Enter Matrix Data
        enterMatrixData(scan, matrix, matrixRow, matrixCol);
        
        // Print Matrix Data
        printMatrix(matrix, matrixRow, matrixCol);
        
       int principal = 0; 
        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < n; j++) { 
      
                // Condition for principal 
                // diagonal 
                if (i == j) 
                    principal += matrix[i][j]; 
            }
        }
         System.out.println("Principal Diagonal:"
                                    + principal); 

      
  }
  public static void enterMatrixData(Scanner scan, int[][] matrix, int matrixRow, int matrixCol){
     System.out.println("Enter Matrix Data");
          
          for (int i = 0; i < matrixRow; i++)
          {
              for (int j = 0; j < matrixCol; j++)
              {
                  matrix[i][j] = scan.nextInt();
              }
          }
  }
  
  public static void printMatrix(int[][] matrix, int matrixRow, int matrixCol){
    System.out.println("Your Matrix is : ");
        
        for (int i = 0; i < matrixRow; i++)
        {
            for (int j = 0; j < matrixCol; j++)
            {
                System.out.print(matrix[i][j]+"\t");
            }
             
            System.out.println();
        }
  }

}