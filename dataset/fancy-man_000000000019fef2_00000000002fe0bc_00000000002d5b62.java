
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {


    private static boolean solve (int c, int x, int y)
    {
        String result = "";
        int x0 = Math.abs(x);
        int y0 = Math.abs(y);
        boolean p1 = x>0;
        boolean p2 = y>0;
//        if ((x0 | y0) == x0+y0)
//        {
//            return print(x, y);
//        }

        while (x0 > 0 || y0 > 0)
        {
            int b1 = x0 % 2;
            int b11 = y0 % 2;

            if (b1>0 && b11>0) return false;

            x0 = x0/2;
            y0 = y0/2;

            int b2 = x0%2;
            int b3 = y0%2;

            boolean isShirt = false;
            if (b2>0 && b3>0)
            {
                isShirt = true;
                //shift
                if (b1 > 0)
                    x0++;
                else
                    y0++;

            }

            if (isShirt)
            {
                if (b1 > 0)
                    result += p1 ? "W" : "E";
                else
                    result += p2 ? "S" : "N";
            }
            else {
                if (b1 > 0)
                    result += p1 ? "E" : "W";
                else
                    result += p2 ? "N" : "S";
            }

        }
        System.out.println("Case #" + c + ": " + result);
        return true;

    }
/*
    private static boolean print (int x, int y)
    {
        int x0 = Math.abs(x);
        int y0 = Math.abs(y);
        boolean p1 = x>0;
        boolean p2 = y>0;
        String result = "";
        while (x0 > 0 || y0 > 0)
        {
            int b1 = x0 % 2;
            if (b1 > 0)
                result += p1? "E" : "W";
            else
                result += p2? "N" : "S";

            x0 = x0/2;
            y0 = y0/2;
        }
        return  false;

        return
    }*/

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int c = 1; c <= t; ++c) {

            String[] tokens = in.nextLine().split(" ");

            int n = Integer.parseInt(tokens[0]);
            int k = Integer.parseInt(tokens[1]);

            if (!solve(c, n, k))
                System.out.println("Case #" + c + ": IMPOSSIBLE");

        }
    }

}
