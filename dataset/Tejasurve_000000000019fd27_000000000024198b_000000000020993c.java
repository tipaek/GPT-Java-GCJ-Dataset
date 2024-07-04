import java.util.Scanner;

 class JavaMatrix 
{
   public static void main(String[] args) 
   {
      Scanner sc = new Scanner(System.in); 
      System.out.println("Please enter number of matrix rows : "); 
      int row = sc.nextInt(); 
      int col = row;

      // defining two dimensional array java
      int numbers[][] = new int[row][col];

      // filling java matrix
      fillingMatrix(sc, numbers, row, col);

      // printing 2d array in matrix form in java
      printingMatrix(numbers, row, col);
   }

   public static void fillingMatrix(Scanner scan, int num[][], int rows, int columns)
   {
      System.out.println("Please enter elements in matrix : ");
      for(int a = 0; a < rows; a++)
      {
         for(int b = 0; b < columns; b++)
         {
            num[a][b] = scan.nextInt();
         }
      }
   }

   public static void printingMatrix(int num[][], int rows, int columns)
   {
     
      System.out.println("Printing 2d array in matrix form : ");
      for(int a = 0; a < rows; a++)
      {
         for(int b = 0; b < columns; b++)
         {
            System.out.print(num[a][b] + "\t");
         } 
         System.out.println();
      }

     System.out.println("diagonal ");
     int Diagonaladd = 0;
      for(int a = 0; a < rows; a++)
      {
         for(int b = 0; b < columns; b++)
         {
            if(a==b){
                Diagonaladd += num[a][b];
            }
         
           
         } 
      
      }
      System.out.println(Diagonaladd);

   }
}