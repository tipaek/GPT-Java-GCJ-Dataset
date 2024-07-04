import java.util.*;
import java.io.*;
public class sol2
{
 public static void main(String gg[])
 {
  Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  int tests=sc.nextInt();
  int t=1;
  while(t<=tests)
  {
   int sum=sc.nextInt();
   //int arr[][]=pascal(20);
   //int res[][]=new int[100][2];
   //int res_len=0;
   int i=0,j=0;
   /*while(i<20)
   {
    while(j<20)
    {
     res[res_len][0]=i+1;
     res[res_len][1]=j+1;
     res_len++;
     sum-=arr[i][j];
     if(arr[i+1][j])
    }
   }*/
   System.out.println("Case #"+t+":");
   for(j=0;j<sum;j++) System.out.println((j+1)+" 1");
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