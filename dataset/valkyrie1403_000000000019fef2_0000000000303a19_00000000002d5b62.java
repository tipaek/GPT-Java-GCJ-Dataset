import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; i++)
        {
            int east = in.nextInt();
            int north = in.nextInt();

            System.out.println("Case #" + i + ": " + solve(east, north));
       }
    }

    private static String solve(int east, int north)
    {
        StringBuilder sb = new StringBuilder();

        boolean eastFlip = (east < 0);
        boolean northFlip = (north < 0);

        east = Math.abs(east);
        north = Math.abs(north);

        while (east > 0 || north > 0)
        {
            int ebit = east & 1;
            int nbit = north & 1;

            int e2bit = (east & 2) >> 1;
            int n2bit = (north & 2) >> 1;

            if ((ebit ^ nbit) == 0)
                return "IMPOSSIBLE";

            if ((e2bit == 1) && (n2bit == 1))
            {
                // subtractive bit
                sb.append(ebit == 1 ? (eastFlip ? 'E' : 'W') : (northFlip ? 'N' : 'S'));

                east >>= 1;
                north >>= 1;

                // print 1s from the other onw
                while ((e2bit == 1) && (n2bit == 1))
                {
                    sb.append(ebit == 0 ? (eastFlip ? 'W' : 'E') : (northFlip ? 'S' : 'N'));
                    east >>= 1;
                    north >>= 1;
                    e2bit = east & 1;
                    n2bit = north & 1;
                }

                if ((e2bit == 0) && (n2bit == 0))
                    sb.append(ebit == 1 ? (eastFlip ? 'W' : 'E') : (northFlip ? 'S' : 'N'));
                else
                    return "IMPOSSIBLE";

            }
            else
            {
                sb.append(ebit == 1 ? (eastFlip ? 'W' : 'E') : (northFlip ? 'S' : 'N'));
                east >>= 1;
                north >>= 1;
            }
        }

        return sb.toString();
    }

}
