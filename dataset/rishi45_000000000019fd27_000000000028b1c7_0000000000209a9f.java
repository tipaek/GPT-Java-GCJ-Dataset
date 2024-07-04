import java.util.*;
class Solution
{
   
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int t=1;t<=T;t++)
        {
            String str=sc.next();
            StringBuffer result=new StringBuffer("");
            char prev='0',cur=str.charAt(0);
            int l=str.length();
            int diff=0;
            for(int i=0;i<l;i++)
            {
                cur=str.charAt(i);
                 diff=cur-prev;
                if(diff==0)
                    result.append(cur);
                else if(diff>0)
                {
                    while(diff-->0)
                        result.append('(');
                    result.append(cur);
                }
                else if(diff<0)
                {
                    while(diff++<0)
                        result.append(')');
                    result.append(cur);
                }
                prev=cur;
                
            }
            diff='0'-str.charAt(l-1);
                while(diff++<0)
                    result.append(')');
            System.out.println("Case #"+t+": "+result);
        }
    }
}