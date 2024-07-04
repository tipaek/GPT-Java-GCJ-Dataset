import java.util.*;
import java.io.*;

public class Solution
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int tt = 1; tt <= T; tt++)
        {
            int N = in.nextInt();
            System.out.println("Case #" + tt + ":");
            if(N <= 1000)
            {
                int ct = 1;
                System.out.println("1 1");
                for(int x = 1; x <= 500; x++)
                {
                    if(ct == N)
                    {
                        break;
                    }
                    if(ct + x > N)
                    {
                        for(int y = x-1; y <= N-ct; y++)
                        {
                            System.out.println(y + " 1");
                        }
                        break;
                    }
                    System.out.println(x + " 2");
                    ct += x;
                }
            }
        }
    }
}