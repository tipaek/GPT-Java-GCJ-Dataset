import java.util.*;
import java.lang.*; 
import java.io.*; 
 class criteria implements Comparator<int[]>
{
    public int compare(final int a[],final int b[])
     {
         if(a[0]>b[0])
         return 1;
         else
         return -1;
     }
}
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t1=sc.nextInt();
        for(int z=1;z<=t1;z++)
        {
            String o="";
            int c=0,j=0,ct=0,jt=0;
            int n=sc.nextInt();
            int a[][]=new int[n][2];
            for(int i=0;i<n;i++)
            {
                 a[i][0]=sc.nextInt();
                 a[i][1]=sc.nextInt();
            }
            Arrays.sort(a,new criteria());
            for(int i=0;i<n;i++)
            {
                int s=a[i][0];
                int e=a[i][1];
                if(c==-1)
                continue;
                if(ct<=s)
                c=0;
                if(jt<=s)
                j=0;
                if(c==0)
                {
                    o+='C';
                    c=1;
                    ct=e;
                }
                else if(j==0)
                {
                    o+='J';
                    j=1;
                    jt=e;
                }
                else
                    c=-1;
            }
          System.out.println("Case #"+z+": "+(c==-1?"IMPOSSIBLE":o));
        }
    }
}