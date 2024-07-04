import java.util.*;
class Solution
{

    void perform(int b[],int e[])
    {
        int cb[]=new int[b.length],ce[]=new int[e.length];
        String c="",jr="",f="";        
        for(int i=0;i<b.length;i++)
        {
            cb[i]=b[i];
            ce[i]=e[i];

        }
        for(int i=0;i<b.length;i++)
        {
            if(ce[i]==-1)
            {
                c+='0';
                continue;
            }
            boolean flag=false;
            for(int j=0;j<b.length;j++)
            {
                if(i==j)
                    continue;
                if(cb[i]>=ce[j]||ce[i]<=cb[j])
                    flag=true;
                else
                {

                    ce[j]=-1;
                    cb[j]=-1;

                }
            }
            if(flag)
            {
                c+="C";
            }
            else
            {
                c+='0';
            }
        }
        for(int i=0;i<b.length;i++)
        {
            if(ce[i]!=-1)
            {
                jr+='0';
                continue;
            }
            boolean flag=true;
            for(int j=0;j<b.length;j++)
            {
                if(ce[i]!=-1)
                {
                    continue;
                }
                if(cb[i]>=ce[j]||ce[i]<=cb[j])
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
            jr+='J';
            else
            jr+='0';
        }
        for(int i=0;i<b.length;i++)
        {

            if(c.charAt(i)=='0'&&jr.charAt(i)=='0')
            {
                f="IMPOSSIBLE";
                break;
            }
            else
            {
                if(jr.charAt(i)=='0')
                    f+=c.charAt(i);
                else
                    f+=jr.charAt(i);
            }
            
        }
        System.out.println(f);
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