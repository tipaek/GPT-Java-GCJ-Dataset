import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t1=sc.nextInt();
        for(int z=1;z<=t1;z++)
        {
            String o="";
            int n=sc.nextInt();
            int ca[][]=new int[n][2];
            int ja[][]=new int[n][2];
            int cl=0,jl=0,c=1,j;
            for(int i=0;i<n;i++)
            {
                 c=0;j=0;
                int s=sc.nextInt();
                int e=sc.nextInt();
                if(c==-1)
                continue;
                for(int h=0;h<cl;h++)
                if((ca[h][1]>s&&ca[h][0]<=s)||(ca[h][1]>=e&&ca[h][0]<e))
                {
                  c=1;
                  break;
                }
                 for(int h=0;h<jl;h++)
                 if((ja[h][1]>s&&ja[h][0]<=s)||(ja[h][1]>=e&&ja[h][0]<e))
                {
                  j=1;
                  break;
                }
                if(c==0)
                {
                    o+='C';
                    ca[cl][0]=s;
                    ca[cl][1]=e;
                    cl++;
                }
                else if(j==0)
                {
                    o+='J';
                    ja[jl][0]=s;
                    ja[jl][1]=e;
                    jl++;
                }
                else
                    c=-1;
            }
          System.out.println("Case #"+z+": "+(c==-1?"IMPOSSIBLE":o));
        }
    }
}