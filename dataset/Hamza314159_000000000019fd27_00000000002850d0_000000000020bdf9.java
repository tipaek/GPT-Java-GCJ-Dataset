import java.util.Scanner;
public class Solution
{
    public static void main(String[]args)
    {
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
    if(t>=1&&t<=100)
    {
        for(int i=1;i<=t;i++)
        {
            int n=sc.nextInt();
            if(n>=2&&n<=1000)
            {
                int b[]=new int[n];boolean flag=true;int chb[]=new int[n];
                int e[]=new int[n];String jj="";int che[]=new int[n];int cr=0;
                for(int j=0;j<n;j++)
                {
                    int bg=sc.nextInt();
                    int en=sc.nextInt();
                    if(bg>=0&&en>bg&&en<=(24*60))
                    {
                        b[j]=bg;
                        e[j]=en;
                    }
                }
                for(int ii=0;ii<n;ii++)
                {
                    if(b[ii]==-1)
                    {
                        jj+='C';
                        continue;
                    }
                    for(int j=0;j<n;j++)
                    {
                        if(ii==j)
                            continue;
                        else if(b[j]==-1)
                            continue;
                        if(!(b[ii]>=e[j]||e[ii]<=b[j]))
                        {
                            chb[cr]=b[j];
                            che[cr]=e[j];
                            b[j]=-1;
                            e[j]=-1;
                            cr++;
                        }

                    }
                    jj+='J';
                }
                for(int j=0;j<cr-1;j++)
                {
                    if(!(chb[j]>=che[j+1]||che[j]<=chb[j+1]))
                    {
                        flag=false;
                        break;
                    }
                }
                if(flag)
                    System.out.println("Case#"+i+": "+jj);
                else
                    System.out.println("Case#"+i+": IMPOSSIBLE");
            }
        }
    }
}
}