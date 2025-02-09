import java.io.*;
import java.util.*;
class Solution
{
    public static void main(String[]args)throws IOException
    {
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     int t=Integer.parseInt(br.readLine());
     for(int k=1;k<=t;k++)
     {
        int N=Integer.parseInt(br.readLine());
        int M[][]=new int[N][N];
        for(int i=0;i<N;i++)
        {
            String inp=br.readLine();
            for(int j=0;j<N;j++)
              M[i][j]=Integer.parseInt(inp.split(" ")[j]);
        }
        int X[]=getVal(M,N);
        System.out.println("Case #"+k+": "+X[2]+" "+X[0]+" "+X[1]);
     }
 }
    static int[]getVal(int M[][],int N)
    {
       int r=0,c=0,trace=0;    
       for(int i=0;i<N;i++)
       {
           Set<Integer> set=new HashSet<Integer>();
           for(int j=0;j<N;j++)
           {
               if(set.contains(M[i][j])==false)
                 set.add(M[i][j]);
               else
               { 
                   r++;
                   break;
               }
           }
           set=null;
       }
       for(int i=0;i<N;i++)
       {
           Set<Integer> set=new HashSet<Integer>();
           for(int j=0;j<N;j++)
           {
               if(set.contains(M[j][i])==false)
                 set.add(M[j][i]);
               else
               {
                   c++;
                   break;
               }
           }
           set=null;
       }
       for(int i=0;i<N;i++)
         trace=trace+M[i][i];
      int x[]=new int[3];
      x[0]=r;
      x[1]=c;
      x[2]=trace;
      return x;
    }
}