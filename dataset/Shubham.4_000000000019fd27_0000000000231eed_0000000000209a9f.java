import java.util.Scanner;
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int testCase = 1;testCase <= t;testCase++)
        {
            String str = sc.next();
            int d, co = 0;
            StringBuilder sb = new StringBuilder();
            for(char ch : str.toCharArray())
            {
                d = ch-'0';
                if(co > d)
                {
                    while(co != d)
                    {
                        sb.append(")");
                        co--;
                    }
                }
                else
                {
                    while(co != d)
                    {
                        sb.append("(");
                        co++;
                    }
                }
                sb.append(ch);
            }
            while(co-->0)
            {
                sb.append(")");
            }
            System.out.println("Case #"+testCase+": "+sb);
        }
    }
}