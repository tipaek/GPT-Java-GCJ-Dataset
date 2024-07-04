import java.util.Scanner;

public class Solution
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int x = 1;
        int n;
        int i = 2;
        int s;
        int e;
        int lasts;
        int laste;
        int overlap = 0;
        String same = "C";
        String other = "J";
        StringBuilder y = new StringBuilder();
        while (x <= t)
        {
            n = in.nextInt();
            y = new StringBuilder();
            overlap = 0;
            i = 2;
            same = "C";
            other = "J";
            lasts = in.nextInt();
            laste = in.nextInt();
            y.append("C");
            while (i <= n)
            {
                s = in.nextInt();
                e = in.nextInt();
                if (s >= laste)
                    y.append(same);
                else
                {
                    y.append(other);
                    if (other.equals("J"))
                    {
                        same = "J";
                        other = "C";
                    }
                    else
                    {
                        same = "C";
                        other = "J";
                    }
                    if ((e >= lasts && e <= laste) || (s < laste && e > laste))
                        overlap++;
                }
                if (overlap == 2)
                {
                    y = new StringBuilder();
                    y.append("IMPOSSIBLE");
                    break;
                }
                i++;
                lasts = s;
                laste = e;
            }
            System.out.print("Case #" + x + ": ");
            System.out.println(y.toString());
            x++;
        }
    }
}