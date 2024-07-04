import java.util.*;
import java.io.*;
public class Solution
{
 public static void main(String gg[])
 {
  int testCases;
  Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  testCases=sc.nextInt();
  int res[][]=new int[testCases][3];
  int t=0;
  while(t<testCases)
  {
   
   int n;
   n=sc.nextInt();
   int i=0,j=0,k=0;
   int arr[][]=new int[n][n];
   int rows[]=new int[n];
   int cols[]=new int[n];
   int rowc=0;
   int colc=0;
   int trace=0;

   for(i=0;i<n;i++)
   {
    for(j=0;j<n;j++)
    {
     arr[i][j]=sc.nextInt();
     if(i==j) trace+=arr[i][j];
    }
   }

   for(i=0;i<n;i++)
   {
    for(j=0;j<n;j++)
    {
     for(k=j+1;k<n;k++)
     {
      if(arr[i][j]==arr[i][k])
      {
       rows[i]=1;
      }
      if(arr[j][i]==arr[k][i])
      {
       cols[i]=1;
      }
     }
    }
   }
   
   for(i=0;i<n;i++)
   {
    if(rows[i]==1) rowc++;
    if(cols[i]==1) colc++;
   }
   res[t][0]=trace;
   res[t][1]=rowc;
   res[t][2]=colc;
   t++;
  }
  for(t=0;t<testCases;t++) System.out.println("Case #"+(t+1)+": "+res[t][0]+" "+res[t][1]+" "+res[t][2]);
 }
}