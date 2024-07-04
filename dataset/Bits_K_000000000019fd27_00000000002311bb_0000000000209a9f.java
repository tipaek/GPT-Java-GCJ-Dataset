import java.util.*;
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(),x=1;
        while (t-->0)
        {
            String s = sc.next();
            String s1 = "0"+s+"0";
            String ans = "";
            int i,n=s1.length(),j;
            for(i=1;i<n;i++)
            {
                int c = s1.charAt(i) - '0';
                int p = s1.charAt(i-1) - '0';
                if(c>p)
                {
                    j=c-p;
                    while(j-->0)
                        ans+="(";
                }
                else if(c<p)
                {
                    j=p-c;
                    while(j-->0)
                        ans+=")";
                }
               if(i<n-1)
                   ans += s1.charAt(i);
            }
            System.out.println("Case #"+x+": "+ans);
            x++;
        }
    }
}
