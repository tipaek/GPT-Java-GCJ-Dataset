import java.util.*;
class Solution
{
   
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        int T=scan.nextInt();
        for(int t=1;t<=T;t++)
        {
            String str=scan.next();
            StringBuffer result=new StringBuffer("");
            char prev='0',curr=str.charAt(0);
            int l=str.length();
            int diff=0;
            for(int i=0;i<l;i++)
            {
                curr=str.charAt(i);
                 diff=curr-prev;
                if(diff==0)
                    result.append(curr);
                else if(diff>0)
                {
                    while(diff-->0)
                        result.append('(');
                    result.append(curr);
                }
                else if(diff<0)
                {
                    while(diff++<0)
                        result.append(')');
                    result.append(curr);
                }
                prev=curr;
                
            }
            diff='0'-str.charAt(l-1);
                while(diff++<0)
                    result.append(')');
            System.out.println("Case #"+t+": "+result);
        }
    }
}