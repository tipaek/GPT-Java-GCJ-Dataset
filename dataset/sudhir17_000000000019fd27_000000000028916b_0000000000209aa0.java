import java.util.*;
class Solution
{
 public static void main(String[] args)
 {
   Scanner sc=new Scanner(System.in);
   int t=sc.nextInt();
   for(int m=1;m<=t;m++)
   {
      int n=sc.nextInt();
      int k=sc.nextInt();
      int arr[][]=new int[n][n];
      int l;
      for(int i=0;i<n;i++)
      {
        k=i+1;
        for(int j=0;j<n;j++)
        {
          arr[i][j]=k%(n+1);
           if(k==n)
           k=k+2;
           else
           k++; 
        }
      }
     int sum=0;
     boolean flag=false;
     for(int a=0;a<n-1;a++)
     {
     for(int s=0;s<n-1;s++)
     {
      for(int i=0;i<n;i++)
      {
       sum=0;
       for(int j=0;j<n;j++)
       sum=sum+arr[j%n][(i+j)%n];
       if(sum==k)
       {
        flag=true;
        break;
       } 
      }
       if(flag)
       break;
       int d=0,temp=arr[0][0];
      for( d=0;d<n-1;d++) 
       arr[0][d]=arr[0][d+1];
      arr[0][d]=temp; 
   }
int p=arr[0][0];
arr[0][0]=arr[0][2];
arr[0][2]=p;
p=arr[1][0];
arr[1][0]=arr[1][2];
arr[1][2]=p;
p=arr[2][0];
arr[2][0]=arr[2][2];
arr[2][2]=p;
}
    if(flag)
    System.out.println("Case #"+m+": "+"POSSIBLE");
    else
    System.out.println("Case #"+m+": "+"IMPOSSIBLE");
  }
 }
}