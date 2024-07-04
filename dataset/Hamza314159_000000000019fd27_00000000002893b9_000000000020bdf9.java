import java.util.*;
public class Solution
{
    static void perform(int b[],int e[])
    {
        for(int p=0;p<b.length;p++)
        {
            int s=p;
            for(int j=p+1;j<b.length;j++)
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
        int cb[]=new int[b.length],ce[]=new int[b.length];
        for(int i=0;i<b.length;i++)
        {
            cb[i]=b[i];
            ce[i]=e[i];

        }
        String c="",j="";
        for(int i=0;i<b.length;i++)
        {
            if(b[i]==-1)
            {
                c+="0";
                continue;
            }
            boolean flag=true;
            for(int jj=0;jj<b.length;jj++)
            {

                if(i==jj)
                    continue;
                if(b[jj]==-1)
                {
                    continue;
                }
                if((b[i]>=e[jj]||e[i]<=b[jj]))
                {

                    flag=true;
                }
                else
                {

                    b[jj]=-1;
                    e[jj]=-1; 
                }

            }
            if(flag)
                c+='C';

        }
        for(int i=0;i<b.length;i++)
        {
            boolean flag=true;
            if(b[i]!=-1)
            {
                j+='0';
                continue;
            }
            for(int jj=0;jj<b.length;jj++)
            {
                if(i==jj)
                    continue;
                if(b[jj]!=-1)
                    continue;
                if(cb[i]>=ce[jj]||ce[i]<=cb[jj])  
                {
                    flag=true;
                }
                else
                {
                    flag=false;
                    break;
                }
            }
            if(flag)
                j+="J";
            else
                j+="0";
        }
        String ot="";
        for(int i=0;i<b.length;i++)
        {
            if(c.charAt(i)=='0'&&j.charAt(i)=='0')
            {
                ot="IMPOSSIBLE";
                break;
            }
            else
            {
                if(c.charAt(i)=='0')
                    ot+=j.charAt(i);
                else
                    ot+=c.charAt(i);
            }
        }
        System.out.println(ot);
    }

    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        if(t>=1&&t<=100)
        {
            for(int j=0;j<t;j++){
                int n=sc.nextInt();

                if(n>=2&&n<=1000)
                {
                    int b[]=new int[n];
                    int e[]=new int[n];
                    for(int i=0;i<n;i++)
                    {
                        int bg=sc.nextInt();
                        int en=sc.nextInt();
                        if(bg>=0&&bg<=(24*60)&&en>=0&&en<=(24*60)&&(bg<en))
                        {
                            b[i]=bg;
                            e[i]=en;
                        }

                    }
                    System.out.print("Case #"+(j+1)+": ");
                    Solution ob=new Solution();
                    ob.perform(b,e);
                }
            }
        }
    }
}