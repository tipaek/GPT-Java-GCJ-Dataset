import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Solution {

    public static String depth(String s) {
        StringBuilder sb = new StringBuilder();
        int curr = Character.digit(s.charAt(0), 10);
        sb.append(padOpen(curr)).append(s.charAt(0));

        for (int i = 0; i < s.length() - 1; i++) {
            curr = Character.digit(s.charAt(i), 10);
            int next = Character.digit(s.charAt(i + 1), 10);

            if (next > curr) {
                sb.append(padOpen(next - curr));
            } else if (next < curr) {
                sb.append(padClose(curr - next));
            }

            sb.append(next);
        }

        curr = Character.digit(s.charAt(s.length() - 1), 10);
        sb.append(padClose(curr));
        return sb.toString();
    }

    private static String padClose(int n) {
        return IntStream.range(0, n).mapToObj(x -> ")").collect(Collectors.joining());
    }

    private static String padOpen(int n) {
        return IntStream.range(0, n).mapToObj(x -> "(").collect(Collectors.joining());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {
            String r = depth(in.next());
            System.out.println("Case #" + i + ": " + r);
        }
    }
}