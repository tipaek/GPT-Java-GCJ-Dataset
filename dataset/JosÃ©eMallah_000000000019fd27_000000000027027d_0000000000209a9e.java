import java.util.Scanner;

public class Solution
{
    public static void main(String args[])
    {
        Scanner in = new Scanner (System.in);
        int t = in.nextInt();
        int b = in.nextInt();
        int x = 1;
        String a;
        int p = 1;
        int queries = 0;
        String c;
        int q = 0;
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        StringBuilder s3 = new StringBuilder();
        StringBuilder s4 = new StringBuilder();
        String a;
        while (x <= t)
        {
            while (q <= b)
            {
                a = in.next();
                System.out.println(p);
                p++;
                queries++;
                q++;
                c = in.next();
                if (c.equals("N"))
                    q = 0;
                else
                    s1.append(c);
            }
            System.out.println(s1.toString());
            a = in.next();
            if (a == "Y")
                x++;
            else
                break;
        }
    }
}