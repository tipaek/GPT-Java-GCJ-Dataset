import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Solution 
{
   public static void main(String[] args) 
   {
      Scanner sc = new Scanner(System.in); 
      int num= sc.nextInt();
      int x=1;
      while(x<=num)
      {
      int N = sc.nextInt(); 
      int row = N;
      int col = N;
      int arr[][] = new int[row][col];
      for(int i=0;i<row;i++)
      {
          for(int j=0;j<col;j++)
          {
              arr[i][j] = sc.nextInt();
          }
      }
      int counti=0;
      Set<Integer> hs = new HashSet<>();
      for(int i=0;i<row;i++)
      {
          for(int j=0;j<col;j++)
          {
              if(hs.contains(arr[i][j]))
              {
                  counti++;
                  break;
              } else {
                  hs.add(arr[i][j]);
              }
          }
          hs.clear();
      }
      int countj=0;
      for(int j=0;j<col;j++)
      {
          for(int i=0;i<row;i++)
          {
              if(hs.contains(arr[i][j]))
              {
                  countj++;
                  break;
              } else {
                  hs.add(arr[i][j]);
              }
          }
          hs.clear();
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
      
      System.out.println(" case #"+(x)+": "+(sum)+" "+(counti)+" "+(countj));
      
      x++;
      }
   }
}