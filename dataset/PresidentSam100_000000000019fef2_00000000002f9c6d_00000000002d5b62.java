import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++)
        {
            System.out.print("Case #" + i + ": ");
            long x = sc.nextLong();
            long y = sc.nextLong();
            long X = 0;
            long Y = 0;
            String work = work(x,y);
            System.out.println(work);
        }
    }
    public static String work(long x, long y)
    {
        if (Math.abs(x)%2==Math.abs(y)%2)
            return "IMPOSSIBLE";
        long[] move = new long[63];
        long speed = 1;
        for (int i = 0; i < 63; i++)
        {
            move[i] = speed;
            speed *= 2;
        }
        long[] work = new long[63];
        Arrays.fill(work,-1);
        while (true) {
            long[] dir = {0, 0};
            work[0]++;
            for (int i = 0; i < 62; i++) {
                if (work[i] == 4) {
                    work[i] = 0;
                    work[i + 1]++;
                } else
                    break;
            }
            for (int i = 0; i < 63; i++)
            {
                if (work[i] == -1)
                    break;
                else if (work[i] == 0)
                    dir[0] += move[i];
                else if (work[i] == 1)
                    dir[0] -= move[i];
                else if (work[i] == 2)
                    dir[1] += move[i];
                else if (work[i] == 3)
                    dir[1] -= move[i];
            }
            if (dir[0] == x&&dir[1] == y)
                break;
        }
        String s = "";
        for (int i = 0; i < 63; i++)
        {
            if (work[i] == -1)
                break;
            else if (work[i] == 0)
                s += "E";
            else if (work[i] == 1)
                s += "W";
            else if (work[i] == 2)
                s += "N";
            else if (work[i] == 3)
                s += "S";
        }
        return s;
    }
}
