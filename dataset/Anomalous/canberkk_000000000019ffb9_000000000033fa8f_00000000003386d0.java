import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out)) {
            int cases = in.nextInt();

            for (int c = 1; c <= cases; c++) {
                String result = "Case #" + c + ": ";

                int N = in.nextInt();
                int[] xs = new int[N];
                int[] ys = new int[N];

                for (int i = 0; i < N; i++) {
                    xs[i] = in.nextInt();
                    ys[i] = in.nextInt();
                }

                int maxCollinearPoints = findMaxCollinearPoints(N, xs, ys);
                out.println(result + maxCollinearPoints);
            }
        }
    }

    private static int findMaxCollinearPoints(int N, int[] xs, int[] ys) {
        int max = 2; // Minimum number of collinear points
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int difx = xs[i] - xs[j];
                int dify = ys[i] - ys[j];
                int[] counts = new int[N];
                for (int p1 = 0; p1 < N; p1++) {
                    for (int p2 = 0; p2 < N; p2++) {
                        if (isCollinear(xs[p1], ys[p1], xs[p1] + difx, ys[p1] + dify, xs[p2], ys[p2])) {
                            counts[p1]++;
                        }
                    }
                }
                int score = calculateScore(counts);
                max = Math.max(max, score);
            }
        }
        return max;
    }

    private static int calculateScore(int[] counts) {
        int[] real = new int[counts.length + 1];
        for (int count : counts) {
            real[count]++;
        }

        int score = 0;
        int odds = 0;
        for (int i = 2; i < real.length; i++) {
            if (real[i] % 2 == 0) {
                score += real[i];
            } else {
                score += real[i] - 1;
                odds++;
            }
        }

        if (odds % 2 == 0) {
            return score + odds + Math.min(2, real[1]);
        } else {
            return score + odds + Math.min(1, real[1]);
        }
    }

    private static boolean isCollinear(int x1, int y1, int x2, int y2, int x3, int y3) {
        return (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) == 0;
    }
}