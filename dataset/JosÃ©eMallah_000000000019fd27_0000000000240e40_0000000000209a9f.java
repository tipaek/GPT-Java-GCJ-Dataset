import java.util.Scanner;

public class Solution
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int x = 1;
        int depth = 0;
        String s = "";
        int l;
        char c;
        StringBuilder y = new StringBuilder();
        while (x <= t)
        {
            s = in.next();
            l = s.length();
            y = new StringBuilder();
            for (int i = 0; i < l; i++)
            {
                c = s.charAt(i);
                if (c == '0')
                {
                    if (depth > 0)
                    {
                        while(depth > 0)
                        {
                            y.append(")");
                            depth--;
                        }
                    }
                    y.append("0");
                }
                else
                {
                    if (depth == 0)
                    {
                        y.append("(1");
                        depth++;
                    }
                    else
                    {
                        y.append("1");
                    }
                }
            }
            while(depth > 0)
            {
                y.append(")");
                depth--;
            }
            System.out.println("Case #" + x + ": " + y.toString());
            x++;
        }
    }
}