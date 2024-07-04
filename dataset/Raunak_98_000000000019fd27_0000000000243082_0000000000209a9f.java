import java.util.*;
class Solution
{
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int tc = 1;
        while(t-->0)
        {
            String ans = "";
            String str = sc.next();
            int l = str.length();
            
            int f=Character.getNumericValue(str.charAt(0));
            int la=Character.getNumericValue(str.charAt(l-1));
            
            for(int i=0;i<f;i++)
                ans = ans + "(";
             
            for(int i=0;i<l-1;i++)
            {
                int a = Character.getNumericValue(str.charAt(i));
                int b = Character.getNumericValue(str.charAt(i+1));
                int diff = (int)Math.abs(a-b);
                ans=ans+str.charAt(i);
                if(a>b)
                {
                    for(int j=1;j<=diff;j++)
                    ans=ans+")";
                }
                else
                {
                    for(int j=1;j<=diff;j++)
                    ans=ans+"(";
                }
            }
            ans=ans+str.charAt(l-1);
            for(int i=0;i<la;i++)
                ans = ans + ")";
                
            System.out.println("Case #"+tc+": "+ans);
            tc++;
        }
    }
}