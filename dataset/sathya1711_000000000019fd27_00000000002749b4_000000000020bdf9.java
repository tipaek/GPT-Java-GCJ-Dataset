import java.util.*;
 class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int tt=1;tt<=t;tt++)
        {
            int n=sc.nextInt();
            int k=n;
            String s="";
            int jmax=-1;
            int cmax=-1;
            int jmin=100000;
            int cmin=1000000;
            while(n-->0)
            {
                int a=sc.nextInt();
                int b=sc.nextInt();
                if((a>=jmax || a<=jmin) && (b<=jmin || b>=jmax))
                {
                    jmax=(int)Math.max(jmax,b);
                    jmin=(int)Math.min(jmin,a);
                    s+="C";
                }
                else
                {
                    if((a>=cmax || a<=cmin) && (b<=cmin || b>=cmax))
                    {
                        cmin=(int)Math.min(cmin,a);
                        cmax=(int)Math.max(cmax,b);
                        s+="J";
                    }
                    else
                    {
                        break;
                    }
                }
                
            }
            if(s.length()==k)
            {
                System.out.println("Case #"+tt+": "+s);
            }
            else
            {
                System.out.println("Case #"+tt+": "+"IMPOSSIBLE");
            }
        }
    }
}