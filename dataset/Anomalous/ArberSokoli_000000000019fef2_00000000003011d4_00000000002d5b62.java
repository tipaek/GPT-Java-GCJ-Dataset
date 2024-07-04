import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = Integer.parseInt(sc.nextLine());
            for (int t0 = 0; t0 < t; t0++) {
                String[] s = sc.nextLine().split(" ");
                long x = Long.parseLong(s[0]);
                long y = Long.parseLong(s[1]);

                String answer = findPath(x, y);
                System.out.println("Case #" + (t0 + 1) + ": " + answer);
            }
        }
    }

    private static String findPath(long x, long y) {
        long step1 = 1;
        while (Math.abs(x) * 2 >= step1 || Math.abs(y) * 2 >= step1) {
            step1 *= 2;
        }

        String answer = "";
        long step = step1 / 4;
        long fx = x, fy = y;

        answer = move(fx, fy, step);
        if (answer.isEmpty()) {
            answer = move(fx, fy, step1 / 2);
        }
        if (answer.isEmpty()) {
            answer = move(fx, fy, step1);
        }
        return answer.isEmpty() ? "IMPOSSIBLE" : answer;
    }

    private static String move(long fx, long fy, long step) {
        StringBuilder answer = new StringBuilder();
        while (true) {
            if (Math.abs(fx) > Math.abs(fy)) {
                if (fx > 0) {
                    answer.insert(0, "E");
                    fx -= step;
                } else {
                    answer.insert(0, "W");
                    fx += step;
                }
            } else {
                if (fy > 0) {
                    answer.insert(0, "N");
                    fy -= step;
                } else {
                    answer.insert(0, "S");
                    fy += step;
                }
            }
            if (step <= 1 || (fx == 0 && fy == 0)) {
                break;
            }
            step /= 2;
        }
        return (fx == 0 && fy == 0) ? answer.toString() : "";
    }
}