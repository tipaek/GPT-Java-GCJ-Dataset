
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Solution implements Runnable
{

    public static void main(String[] args)
    {
        new Solution().run();
    }

    public void run()
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        outer:
        for (int t = 1; t <= T; t++)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int i = 0;
            char[] steps = sc.next().toCharArray();
            if (x + y == 0)
            {
                System.out.println("Case #" + t + ": 0");
                continue;
            }
            for (char c : steps)
            {
                i++;
                switch (c)
                {
                    case 'N':
                        y++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                }
//                System.out.println(Math.abs(x) + "+" + Math.abs(y) + "<=" + i);
                if (Math.abs(x) + Math.abs(y) <= i)
                {
                    System.out.println("Case #" + t + ": " + i);
                    continue outer;
                }

            }
            System.out.println("Case #" + t + ": IMPOSSIBLE");
        }
    }
}
