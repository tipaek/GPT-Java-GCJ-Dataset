import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();

        for (int t = 0; t < tests; t++) {
            int N = scanner.nextInt();
            int[][] day = new int[24 * 60][2];
            StringBuilder order = new StringBuilder();
            boolean possible = true;
            for (int i = 0; i < N; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean result = scheduleJob(day, start, end, i + 1, order);
                if (!result) {
                    possible = false;
                    break;
                }
            }

            sout(t + 1, possible ? order.toString() : "IMPOSSIBLE");
        }
        scanner.close();
    }

    private static boolean scheduleJob(int[][] day, int start, int end, int i, StringBuilder order) {
        boolean can = true;
        for (int j = start; j < end; j++) {
            if (day[j][0] != 0) {
                can = false;
                break;
            }
        }

        if (can) {
            order.append("C");
            for (int j = start; j < end; j++) {
                day[j][0] = i;
            }
            return true;
        }

        can = true;
        for (int j = start; j < end; j++) {
            if (day[j][1] != 0) {
                can = false;
                break;
            }
        }

        if (can) {
            order.append("J");
            for (int j = start; j < end; j++) {
                day[j][1] = i;
            }
            return true;
        }
        return false;
    }

    private static void sout(int x, String s) {
        System.out.println("Case #" + x + ": " + s);
    }
}

