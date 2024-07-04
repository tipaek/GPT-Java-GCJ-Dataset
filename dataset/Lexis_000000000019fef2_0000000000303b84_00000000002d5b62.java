import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public void processRawInput(InputStream is) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        int caseNumber = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= caseNumber; i++) {
            String target = reader.readLine();
            String[] parts = target.split(" ");
            long x = Long.parseLong(parts[0]);
            long y = Long.parseLong(parts[1]);
            System.out.println("Case #" + i + ": " + process(x, y));
        }

    }

    public String process(long x, long y) {
        if (x % 2 != 0 && y % 2 != 0) {
            return "IMPOSSIBLE";
        }

        long maxValue = Math.max(Math.abs(x), Math.abs(y));
        maxValue = Math.max(maxValue, Math.min(Math.abs(x), Math.abs(y)) * 2);

        long multiplier;
        if (maxValue > 1) {
            multiplier = 2;

            long sum = 3;
            while (sum < maxValue) {
                multiplier *= 2;
                sum += multiplier;
            }
        } else {
            multiplier = 1;
        }

        String res1 = test(x, y, multiplier);
        if (res1.equals("IMPOSSIBLE")) {
            return test(x, y, multiplier * 2);
        } else {
            return res1;
        }
    }

    private static String test(long x, long y, long multiplier) {
        StringBuilder sb = new StringBuilder();
        while (multiplier > 0) {
            if (Math.abs(x) > Math.abs(y)) {
                if (x < 0) {
                    x += multiplier;
                    sb.append('W');
                } else {
                    x -= multiplier;
                    sb.append('E');
                }
            } else {
                if (y < 0) {
                    y += multiplier;
                    sb.append('S');
                } else {
                    y -= multiplier;
                    sb.append('N');
                }

            }
            multiplier /= 2;
        }
        if (x != 0 || y != 0) {
            return "IMPOSSIBLE";
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        new Solution().processRawInput(System.in);
    }
}
