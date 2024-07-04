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
    int arr[][]=new int[n][n];
    for(int i=0;i<n;i++)
    for(int j=0;j<n;j++)
     arr[i][j]=sc.nextInt();
    int sum=0;
    for(int i=0;i<n;i++)
       sum=sum+arr[i][i];
     boolean flag=false;    
     int r=0,c=0;
     for(int i=0;i<n;i++)
     {
       for(int j=0;j<n;j++)
       {
          flag=false;
          for(int k=0;k<n;k++)
          {
             if(k==j)
             continue;
             if(arr[i][j]==arr[i][k])
             {
                r++;
                flag=true;
                break;
              }
           }
          if(flag)
          break;
       }
     }
     for(int i=0;i<n;i++)
     {
      for(int j=0;j<n;j++)
      {
       flag=false;
       for(int k=0;k<n;k++)
       {
         if(k==i)
         continue;
         if(arr[j][i]==arr[k][j])
         {
           c++;
           flag=true;
           break;
         }
       }
      if(flag)
      break;
       }
     }
     System.out.println("Case #"+m+": "+sum+" "+r+" "+c);
  }
 }
}