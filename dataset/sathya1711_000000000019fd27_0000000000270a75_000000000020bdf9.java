import java.util.*;
class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int c=1;
        while(t-->0)
        {
            int n=sc.nextInt();
            int k=n;
            String s="";
            int a=sc.nextInt();
            int b=sc.nextInt();
            int jmax=b;
            int cmax=-1;
            int jmin=a;
            int cmin=1000000;
            s+="J";
            n=n-1;
            while(n-->0)
            {
                 a=sc.nextInt();
                 b=sc.nextInt();
                if(a>=jmax || a<=jmin)
                {
                    jmax=(int)Math.max(jmax,b);
                    jmin=(int)Math.min(jmin,a);
                    s+="J";
                }
                else
                {
                    if(a>=cmax || a<=cmin)
                    {
                        cmin=(int)Math.min(cmin,a);
                        cmax=(int)Math.max(cmax,b);
                        s+="C";
                    }
                    else
                    {
                        break;
                    }
                }
                
            }
            if(s.length()==k)
            {
                System.out.println("Case #"+c+": "+s);
            }
            else
            {
                System.out.println("Case #"+c+": "+"IMPOSSIBLE");
            }
            c++;
        }
    }
}