import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int l = 1;
        while(l<=t)
        {
            String s = sc.next();
            int n = s.length();
            String ans = "";
            int p = Character.getNumericValue(s.charAt(0));
            while(p-->=1)
                ans+="(";
            for(int i=1;i<s.length();i++)
            {
                ans += s.charAt(i-1);
                int p1 = Character.getNumericValue(s.charAt(i));
                int p2 = Character.getNumericValue(s.charAt(i-1));
                int q = p2 - p1;
                if(q<0)
                {
                    q = Math.abs(q);
                    while(q-->=1)
                        ans+="(";
                }
                else
                {
                    while(q-->=1)
                        ans+=")";
                }
            }
            ans+=s.charAt(n-1);
            p = Character.getNumericValue(s.charAt(n-1));
            while(p-->=1)
                ans+=")";
            System.out.println("Case #"+l+": "+ans);
            l++;
        }
    }
}