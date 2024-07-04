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
   int r=sc.nextInt();
   int c=sc.nextInt();
   int arr[][]=new int[r+20][c+20];
   int copy[][]=new int[r][c];
   int i,j;
   for(i=0;i<r+20;i++)
    for(j=0;j<c+20;j++)
    {
     arr[i][j]=0;
    }
   for(i=0;i<r;i++)
    for(j=0;j<c;j++)
    {
     arr[i+10][j+10]=sc.nextInt();
     copy[i][j]=arr[i+10][j+10];
    }
   int interest=0;
   int round=1;
   double bound_avg=0;
   int flag=0;
   int count=0;
   while(round<=10000000)
   {
    flag=0;
    for(i=0;i<r;i++)
    {
     for(j=0;j<c;j++)
     {
      interest+=copy[i][j];
      count=0;
      if(copy[i][j]!=0)
      {
       if(arr[i+10-round][j+10]!=0) count++;
       if(arr[i+10][j+10-round]!=0) count++;
       if(arr[i+10][j+10+round]!=0) count++;
       if(arr[i+10+round][j+10]!=0) count++;
       bound_avg=(double)(arr[i+10-round][j+10]+arr[i+10][j+10-round]+arr[i+10][j+10+round]+arr[i+10+round][j+10])/(double)count;
       if((double)arr[i+10][j+10]<bound_avg)
       {
        flag=1;
        copy[i][j]=0;
       }
      }
     }
    }
    if(flag==0) break;
    round++;
   }
   System.out.println("Case #"+t+": "+interest);
   t++;
  } 
 }
}
