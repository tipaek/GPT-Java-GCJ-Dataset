import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();

            if (n == 1) {
                System.out.println("Case #" + i + ":");
                System.out.println("1 1");
                continue;
            }

            if (n == 2) {
                System.out.println("Case #" + i + ":");
                System.out.println("1 1");
                System.out.println("2 1");
                continue;
            }

            List<String> results = new ArrayList<>(Arrays.asList("1 1", "2 1"));
            n -= 2;
            int second = 2;
            int index = 3;

            while (n > 0) {

                if (n - second < 0) {
                    results.add(index + " 1");
                    n--;
                } else {
                    results.add(index + " 2");
                    n -= second;
                    second++;
                }
                index++;
            }

            System.out.println("Case #" + i + ":");
            for (String line : results) {
                System.out.println(line);
            }
        }
    }
}