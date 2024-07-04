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
   
   int C[]=new int[2];
   int J[]=new int[2];  

   for(i=0;i<n;i++)
   {
    if(C[1]<=inp[i][0] || C[0]>=inp[i][1])
    {
     C[0]=inp[i][0];
     C[1]=inp[i][1];
     res+="C";
     //System.out.println(inp[i][0]+" "+inp[i][1]+" C");
    }
    else if(J[1]<=inp[i][0] || J[0]>=inp[i][1] )
    {
     J[0]=inp[i][0];
     J[1]=inp[i][1];
     res+="J";
     //System.out.println(inp[i][0]+" "+inp[i][1]+" J");
    }
    else
    {
     res="IMPOSSIBLE";
     break;
    }
   }
   System.out.println("Case #"+z+": "+res);
  }
 }
}