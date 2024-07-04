import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
//        for (int i = 0; i < 5; i++) {
//            for (int j = i; j < 5; j++) {
//                testStep = 1;
//                System.out.println("i == " + i + "  j == " + j + "  rest= " + test(i, j));
////                findMost(i, j);
////                map = new HashMap<>();
////                String res = getRes(i, j, new StringBuilder());
////                System.out.println("i == " + i + "  j == " + j + " res ==" + res);
//            }
//        }
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int index = 1; index <= t; ++index) {
            long x = in.nextInt();
            long y = in.nextInt();
            testStep = 1;
            String res = test(x, y);
            System.out.println("Case #" + index + ": " + ("-1".equals(res) ? "IMPOSSIBLE" : res));
        }
    }

    static long testStep = 1;
    private static String test(long i, long j) {
        Deque<String[]> deque = new ArrayDeque<>();
        deque.add(new String[]{"0", "0", ""});
        while (!deque.isEmpty()) {
            int size = deque.size();
            if (testStep > 256L) {
                break;
            }
            while (size-- > 0) {
                String[] tmp = deque.poll();
                int x = Integer.valueOf(tmp[0]);
                int y = Integer.valueOf(tmp[1]);
                if (x == i && y == j) {
                    return tmp[2];
                }
                deque.add(new String[]{"" + (x + testStep), "" + y, tmp[2] + "E"});
                deque.add(new String[]{"" + (x - testStep), "" + y, tmp[2] + "W"});
                deque.add(new String[]{"" + x, "" + (y + testStep), tmp[2] + "N"});
                deque.add(new String[]{"" + x, "" + (y - testStep), tmp[2] + "S"});
            }
            testStep <<= 1;
        }
        return "-1";
    }


}