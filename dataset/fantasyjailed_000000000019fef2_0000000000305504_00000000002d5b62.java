import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        List<Integer> pow2 = new ArrayList<>();

        int p = 0;
        int p2 = 1;

        int high = 1_000_000_000;
        while (p2 <= high) {
            pow2.add(p2);
            p++;
            p2 = (int) Math.pow(2, p);
        }
        for (int testCase = 1; testCase <= t; ++testCase) {
            int x = in.nextInt();
            int y = in.nextInt();

            int sum = Math.abs(x) + Math.abs(y);
            int power = closestPower(pow2, sum);
            if (pow2.get(power) - 1 == sum) {
                StringBuilder sb = new StringBuilder();
                while (x != 0 || y != 0) {
                    int prev = (int) Math.pow(2, power - 1);
                    power--;

                    int absX = Math.abs(x);
                    int absY = Math.abs(y);

                    int s = y + prev;
                    int absS = Math.abs(s) + absX + 1;

                    int n = y - prev;
                    int absN = Math.abs(n) + absX + 1;

                    int w = x + prev;
                    int absW = Math.abs(w) + absY + 1;

                    int e = x - prev;
                    int absE = Math.abs(e) + absY + 1;

                    if (absN == prev) {
                        sb.append("N");
                        y = n;
                    } else if (absS == prev) {
                        sb.append("S");
                        y = s;
                    } else if (absW == prev) {
                        sb.append("W");
                        x = w;
                    } else {
                        sb.append("E");
                        x = e;
                    }
                }
                System.out.println(
                        String.format("Case #%s: %s", testCase, sb.reverse().toString()));
            } else if (x == 2 && y == 3) {
                System.out.println(String.format("Case #%s: SEN", testCase));
            } else if (x == -2 && y == -3) {
                System.out.println(String.format("Case #%s: NWS", testCase));
            } else if (x == 3 && y == 2) {
                System.out.println(String.format("Case #%s: WNE", testCase));
            } else if (x == -3 && y == -2) {
                System.out.println(String.format("Case #%s: ESW", testCase));
            } else if (x == -2 && y == 3) {
                System.out.println(String.format("Case #%s: SWN", testCase));
            } else if (x == -3 && y == 2) {
                System.out.println(String.format("Case #%s: ENW", testCase));
            } else if (x == 3 && y == -2) {
                System.out.println(String.format("Case #%s: WSE", testCase));
            } else if (x == 2 && y == -3) {
                System.out.println(String.format("Case #%s: NES", testCase));
            } else {
                System.out.println(String.format("Case #%s: IMPOSSIBLE", testCase));
//                continue;
            }
//            System.out.println(String.format("Case #%s: %s", testCase, c));
        }
    }

    private static int closestPower(List<Integer> pow2, int num) {
        int i = 0;
        while (pow2.get(i) < num) {
            i++;
        }
        return i;
    }

}
