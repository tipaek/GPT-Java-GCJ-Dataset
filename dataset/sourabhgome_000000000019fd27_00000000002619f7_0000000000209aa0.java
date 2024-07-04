import java.util.*;
import java.io.*;
public class Solution
{
 public static void main(String gg[])
 {
  Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  int tests=sc.nextInt();
  int t=0;
  while(t<tests)
  {
   int n=sc.nextInt();
   int k=sc.nextInt();
   int lat[][];
   lat=latin(n);
   int i,j,x,l;
   int temp=k;
   int temp2=0;
   int arr[]=new int[n];
   int res[][]=new int[n][n];
   j=n;
   for(i=0;i<k;i++)
   {
    arr[i%n]+=1;
   }
   int sum=0;
   for(i=0;i<n;i++)
   {
    sum+=arr[i];
   }
   int count=0;
   for(i=0;i<n;i++)
   {
    for(x=0;x<n;x++)
    {
     if(lat[x][i]==arr[i]) break;
    }
    if(x==n)
    {
     count=1;
     break;
    }
    for(j=0;j<n;j++)
    {
     res[i][j]=lat[x][j];
     lat[x][j]=0;
    }
   }
   if(count==1 || k<n) System.out.println("Case #"+(t+1)+": IMPOSSIBLE");
   else
   {
    System.out.println("Case #"+(t+1)+": POSSIBLE");
    for(i=0;i<n;i++)
    {
     for(j=0;j<n;j++)
     {
      if(j<n-1) System.out.print(res[i][j]+" ");
      else  System.out.print(res[i][j]);
     }
     System.out.println();
    }
   }
   t++;
  }
 }
 public static int[][] latin(int n)
 {
  int a[]=new int[n];
  int lat[][]=new int[n][n];
  int i,j,k=0;
  for(i=n;i>0;i--) a[i-1]=i;
  for(i=0;i<n;i++)
  {
   k=i;
   for(j=0;j<n;j++)
   {
    lat[i][j]=a[k%n];
    k++;
   }
  }
  return lat;
 }
}