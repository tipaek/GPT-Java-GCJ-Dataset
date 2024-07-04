import java.util.*;
import java.io.*;
public class Solution
{
 public static void main(String gg[])
 {
  Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  int tests=sc.nextInt();
  int t=1;
  while(t<=tests)
  {
   int sum=sc.nextInt();
   int n=31;
   int arr[][]=pascal(n);
   int res[][]=new int[1000][2];
   int res_len=0;
   int i=0,j=0;
   int flag=0;
   while(i<n)
   {
    flag=0;
    while(j<n)
    {
     res[res_len][0]=i+1;
     res[res_len][1]=j+1;
     res_len++;
     sum-=arr[i][j];
     if(sum==0)
     {
      flag=1;
      break;
     }
     if(i<30 && j<30)
     {
      if(i==0 && j==0)
      {
       i++;
       j++;
      }
      else if(sum-arr[i+1][j]>=0 && arr[i+1][j]!=0)
      {
       i++;
      }
      else if(sum-arr[i+1][j+1]>=0 && arr[i+1][j+1]!=0)
      {
       i++;
       j++;
      }
      else if(sum-arr[i][j+1]>=0 && arr[i][j+1]!=0)
      {
       j++;
      }
     }
     else
     {
      if(sum-arr[i-1][j]>=0 && arr[i-1][j]!=0)
      {
       i--;
      }
      else if(sum-arr[i][j-1]>=0 && arr[i][j-1]!=0)
      {
       j--;
      } 
      else if(sum-arr[i-1][j-1]>=0 && arr[i-1][j-1]>=0)
      {
       i--;
       j--;
      }
     }
    }
    if(flag==1) break;
   }
   System.out.println("Case #"+t+":");
   for(j=0;j<res_len;j++) System.out.println(res[j][0]+" "+res[j][1]);
   t++;
  }
 }
 public static int[][] pascal(int n)
 {  
  int[][] arr = new int[n][n];  
  for(int line = 0; line < n; line++) 
  { 
   for(int i = 0; i <= line; i++) 
   { 
    if (line == i || i == 0) 
     arr[line][i] = 1; 
    else
     arr[line][i] = arr[line-1][i-1] + arr[line-1][i];
   }
  }
  return arr;
 }
}