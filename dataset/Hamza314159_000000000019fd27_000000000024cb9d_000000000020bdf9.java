import java.util.*;
class Solution
{

    void perform(int b[],int e[])
    {
        int cb[]=new int[b.length],ce[]=new int[e.length];String c="",jr="",f="";
        int jb[]=new int[b.length],je[]=new int[e.length];
        for(int i=0;i<b.length;i++)
        {
            cb[i]=b[i];
            ce[i]=e[i];
            jb[i]=b[i];
            je[i]=e[i];
        }
        for(int i=0;i<b.length;i++)
        {
            for(int j=0;j<b.length;j++)
            {
                if(i==j)
                    continue;
                if(cb[i]>cb[j]&&ce[i]<ce[j])
                    c+="0";
                else
                    c+="C";
            }
        }
        for(int i=0;i<b.length;i++)
        {
            for(int j=0;j<b.length;j++)
            {
                if(i==j)
                    continue;
                if(jb[i]>jb[j]&&je[i]<je[j])
                    jr+="0";
                else
                    jr+="J";
            }
        }

        for(int i=0;i<b.length;i++)
        {

            if(c.charAt(i)=='0'&&jr.charAt(i)=='0')
            {
                f="IMPOSSIBLE";
                break;
            }
            else if(f.length()==0)
            {
                if(jr.charAt(i)=='0')
                    f+=c.charAt(i);
                else
                    f+=jr.charAt(i);
            }
            else if(f.charAt(f.length()-1)=='C'&&jr.charAt(i)!=0)
            {
                f+=jr.charAt(i);

            }
            else if(f.charAt(f.length()-1)=='J'&&c.charAt(i)!=0)
            {
                f+=c.charAt(i);

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