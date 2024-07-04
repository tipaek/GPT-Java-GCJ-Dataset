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

    static void solve(int A, int B) throws Exception {
        int hi = 0;
        int lo = -1000000000;
        while (hi - lo > 2) {
            int x = (lo + hi) / 2;
            System.out.println(x + " 0");
            String line = in.readLine();
            if (line.equals("CENTER")) return;
            if (line.equals("HIT")) hi = x;
            else lo = x;
        }
        int left = (hi + lo) / 2;

        hi = 1000000000;
        lo = 0;
        while (hi - lo > 2) {
            int x = (lo + hi) / 2;
            System.out.println(x + " 0");
            String line = in.readLine();
            if (line.equals("CENTER")) return;
            if (line.equals("HIT")) lo = x;
            else hi = x;
        }
        int right = (hi + lo) / 2;

        hi = 0;
        lo = -1000000000;
        while (hi - lo > 2) {
            int y = (lo + hi) / 2;
            System.out.println("0 " + y);
            String line = in.readLine();
            if (line.equals("CENTER")) return;
            if (line.equals("HIT")) hi = y;
            else lo = y;
        }
        int bottom = (hi + lo) / 2;

        hi = 1000000000;
        lo = 0;
        while (hi - lo > 2) {
            int y = (lo + hi) / 2;
            System.out.println("0 " + y);
            String line = in.readLine();
            if (line.equals("CENTER")) return;
            if (line.equals("HIT")) lo = y;
            else hi = y;
        }
        int top = (hi + lo) / 2;

        long xAvg = (left + right) / 2;
        long yAvg = (top + bottom) / 2;
        for (int dx = -5; dx <= 5; dx++) {
            for (int dy = -5; dy <= 5; dy++) {
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