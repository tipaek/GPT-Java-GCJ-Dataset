import java.util.*;

public class Solution 
{
   public static void main(String[] args) 
   {
      Scanner sc = new Scanner(System.in); 
      //Enter the number of inputs
      int num= sc.nextInt();
      int x=1;
      while(x<=num)
      {
      // enter the value of N 
      int N = sc.nextInt(); 
      int row = N;
      int col = N;
      int arr[][] = new int[row][col];
      //Enter the elements
      for(int i=0;i<row;i++)
      {
          for(int j=0;j<col;j++)
          {
              arr[i][j] = sc.nextInt();
          }
      }
      
      int countj=0;
      for(int i=0;i<row;i++)
      {
          HashSet<Integer> h = new HashSet<Integer>();
          for(int j=0;j<col;j++)
          {
             
             if(h.contains(arr[i][j]))
             {
                 countj++;
                 break;
             }
             else {
              h.add(arr[i][j]);
            }
          }
      }
          int counti=0;
      for(int j=0;j<col;j++)
      {
         HashSet<Integer> h = new HashSet<Integer>();
          for(int i=0;i<row;i++)
          {
             
             if(h.contains(arr[i][j]))
             {
                 counti++;
                 break;
             }
             else {
              h.add(arr[i][j]);
              
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
      
      System.out.println(" case #"+(x)+": "+(sum)+" "+(countj)+" "+(counti));
      
      x++;
      }
   }
}



      
     