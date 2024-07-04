import java.util.*;
class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int c=1;
        for(int i=0;i<t;i++)
        {
            String s="";
            int n=sc.nextInt();
            int k=n;
            int jmax=-1,jmin=1000000,cmax=-1,cmin=100000;
            while(n-->0)
            {
                int a=sc.nextInt();
                int b=sc.nextInt();
                if((a>=jmax || a<jmin) && (b<jmin || b>=jmax))
                {
                    jmax=(int)Math.max(jmax,b);
                    jmin=(int)Math.min(jmin,a);
                    s+="C";
                }
                else
                {
                    if((a>=cmax || a<cmin) && (b<cmin || b>=cmax))
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