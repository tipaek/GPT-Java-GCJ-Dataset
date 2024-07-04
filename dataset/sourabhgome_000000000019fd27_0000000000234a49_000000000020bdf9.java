import java.util.*;
import java.io.*;
public class Solution
{
 public static void main(String[] args) 
 {
  Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  int t = sc.nextInt();
  for (int z = 1; z <= t; ++z)
  {
   String res="";
   int ones[]=new int[24*60];
   int i=0,j=0;
   int n;
   int count=0;
   n=sc.nextInt();
   int inp[][]=new int[n][2];
   for(i=0;i<n;i++)
   {
    inp[i][0]=sc.nextInt();
    inp[i][1]=sc.nextInt();
   }
   //1 for C is busy
   //2 for J is busy
   //3 for both is busy
   //0 for both free
   for(i=0;i<n;i++)
   {
    count=0;
    for(j=inp[i][0];j<inp[i][1];j++)
    {
     if(ones[j]==0)
     {
      ones[j]=1;
      count=1;
     }
     else if(ones[j]==1)
     {
      ones[j]=2;
      count=2;
     }
     else if(ones[j]==2)
     {
      ones[j]=3;
      count=3;
      break;
     }
    }
    if(count==1) res+="C";
    else if(count==2) res+="J";
    else if(count==3)
    {
     res="IMPOSSIBLE";
     break;
    }
   }
   System.out.println("Case #"+z+": "+res);
  }
 }
}