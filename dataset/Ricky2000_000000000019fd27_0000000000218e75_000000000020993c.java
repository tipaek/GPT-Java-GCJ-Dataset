import java.util.Scanner;

public class vestigum 
{
   public static void main(String[] args) 
   {
      Scanner sc = new Scanner(System.in); 
      System.out.print("Enter the number of inputs: ");
      int num= sc.nextInt();
      int x=1;
      while(x<=num)
      {
      System.out.println("Please enter the value of N : "); 
      int N = sc.nextInt(); 
      int row = N;
      int col = N;
      int arr[][] = new int[row][col];
      System.out.println("Enter the elements: ");
      for(int i=0;i<row;i++)
      {
          for(int j=0;j<col;j++)
          {
              arr[i][j] = sc.nextInt();
          }
      }
      int first = arr[0][0];
      int counti=0;
      for(int i=0;i<row;i++)
      {
          for(int j=0;j<col;j++)
          {
              if(arr[i][j]==first)
              {
                  counti++;
              }
          }
      }
       int countj=0;
      for(int j=0;j<row;j++)
      {
          for(int i=0;i<col;i++)
          {
              if(arr[j][i]==first)
              {
                  countj++;
              }
          }
      }
       int sum=0;
       for(int i=0;i<row;i++)
      {
          for(int j=0;j<col;j++)
          {
              if(i==j)
              {
                  sum += arr[i][j];
              }
          }
      }
      
      System.out.println("The matrix is:");
       for(int i=0;i<row;i++)
      {
          for(int j=0;j<col;j++)
          {
              System.out.println(arr[i][j] + " ");
          }
          System.out.println();
      }
      
      System.out.println(" case "+(x)+": "+(sum)+" "+(counti)+" "+(countj));
      
      x++;
      }
   }
}

      
     