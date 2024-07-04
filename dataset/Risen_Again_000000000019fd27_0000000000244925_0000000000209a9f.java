import java.util.*;

class Solution
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t = 1;t <= T;t++)
        {
            String s = sc.next();
            String r = "";
            int opened = 0;
            for(int i = 0;i < s.length(); i++)
            {
                int d = s.charAt(i) - '0';
                if(opened < d)
                {
                    for(int j = 0;j < (d-opened); j++)
                    {
                        r += "(";
                    }
                    opened = d;
                }
                else if(opened > d)
                {
                    for(int j = 0;j < (opened-d); j++)
                    {
                        r += ")";
                    }
                    opened = d;
                }
                r += s.charAt(i);
            }
            for(int j = 0;j < opened; j++)
            {
                r += ")";
            }
            System.out.println("Case #" + t + ": " + r);
        }

    }
}