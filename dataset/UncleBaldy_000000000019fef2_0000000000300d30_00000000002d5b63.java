import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader in;
    public static void main(String[] args) throws Exception {
        in = new BufferedReader(
                new InputStreamReader(System.in)
        );
        String[] line = in.readLine().split(" ");
        int T = Integer.parseInt(line[0]);
        int A = Integer.parseInt(line[1]);
        int B = Integer.parseInt(line[2]);
        for (int x = 1; x <= T; x++) {
            solve(A, B);
        }
    }

    static void solve(int X, int Y) throws Exception {
        Random rnd = new Random("GCJ2020".hashCode());

        int randLim = 300 - 81;
        long xSum = 0;
        long ySum = 0;
        int hits = 0;
        for (int i = 0; i < randLim; i++) {
            int x = rnd.nextInt(2000000001) - 1000000000;
            int y = rnd.nextInt(2000000001) - 1000000000;
            System.out.println(x + " " + y);
            String line = in.readLine();
            if (line.equals("CENTER")) {
                return;
            }
            if (line.equals("HIT")) {
                xSum += x;
                ySum += y;
                hits++;
            }
        }
        long xAvg = xSum / hits;
        long yAvg = ySum / hits;
        for (int dx = -4; dx <= 4; dx++) {
            for (int dy = -4; dy <= 4; dy++) {
                System.out.printf("%d %d\n", xAvg + dx, yAvg + dy);
                String line = in.readLine();
                if (line.equals("CENTER")) {
                    return;
                }
            }
        }
        throw new Exception("DRAT!");
    }
}
