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
                    int b[]=new int[n];boolean flag=true;
                    int e[]=new int[n];String op="";
                    int chb[]=new int[n];
                    int che[]=new int[n];int cr=0;
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
                    for(int p=0;p<n;p++)
                    {
                        int s=p;
                        for(int j=0;j<p;j++)
                        {
                            if(b[s]>b[j])
                            {
                                s=j;
                            }
                        }
                        int t1=b[p];
                        int t2=e[p];
                        b[p]=b[s];
                        e[p]=e[s];
                        b[p]=t1;
                        e[p]=t2;
                    }
                    for(int j=0;j<n;j++)
                    {
                        if(b[j]==-1)
                        {
                            op+='C';
                            continue;
                        }
                        for(int ll=0;ll<n;ll++)
                        {
                            if(b[ll]==-1)
                            {
                                continue;
                            }
                            if(j==ll)
                                continue;
                            if(!(b[j]>=e[ll]||e[j]<=b[ll]))
                            {
                                chb[cr]=b[ll];
                                che[cr]=e[ll];
                                b[ll]=-1;
                                e[ll]=-1;
                                cr++;
                            }
                        }
                        op+='J';
                    }
                    outer:for(int p=0;p<cr;p++)
                    {

                        for(int j=0;j<cr;j++)
                        {
                            if(p==j)
                                continue;

                            if(!(chb[p]>=che[j]||che[p]<=chb[j]))
                            {
                                flag=false;
                                break outer;
                            }
                        }
                    }
                    if(flag)
                        System.out.println("Case#"+i+": "+op);
                    else
                        System.out.println("Case#"+i+": IMPOSSIBLE");
                }
            }
        }
    }
}