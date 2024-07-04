import java.io.OutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner scanner = new Scanner(inputStream);
        PrintWriter writer = new PrintWriter(outputStream);
        PancakeSolver solver = new PancakeSolver();
        int testCases = Integer.parseInt(scanner.next());
        for (int i = 1; i <= testCases; i++) {
            solver.solve(i, scanner, writer);
        }
        writer.close();
    }

    static class PancakeSolver {
        private String calculate(long L, long R) {
            long li = 0;
            long ri = 2000000000L;
            long smaller = Math.min(L, R);
            long greater = Math.max(L, R);

            while (li < ri - 1) {
                long mid = (li + ri) / 2;
                long sum = mid * (mid + 1) / 2;
                if (smaller <= greater - sum) {
                    li = mid;
                } else {
                    ri = mid;
                }
            }

            if (L < R) {
                R -= li * (li + 1) / 2;
            } else {
                L -= li * (li + 1) / 2;
            }

            long start = ri;
            ri = 2000000000L;
            smaller = Math.min(L, R);
            greater = Math.max(L, R);

            while (li < ri - 1) {
                long mid = (li + ri) / 2;
                long greaterCount = (mid - start + 2) / 2;
                long lesserCount = (mid - start + 1) / 2;
                long greaterSum = (start + start + 2 * (greaterCount - 1)) * greaterCount / 2;
                long lesserSum = (start + 1 + start + 1 + 2 * (lesserCount - 1)) * lesserCount / 2;

                if (greater >= greaterSum && smaller >= lesserSum) {
                    li = mid;
                } else {
                    ri = mid;
                }
            }

            long greaterCount = (li - start + 2) / 2;
            long lesserCount = (li - start + 1) / 2;
            long greaterSum = (start + start + 2 * (greaterCount - 1)) * greaterCount / 2;
            long lesserSum = (start + 1 + start + 1 + 2 * (lesserCount - 1)) * lesserCount / 2;

            if (L >= R) {
                L -= greaterSum;
                R -= lesserSum;
            } else {
                R -= greaterSum;
                L -= lesserSum;
            }

            return li + " " + L + " " + R;
        }

        public void solve(int testNumber, Scanner scanner, PrintWriter writer) {
            long L = scanner.nextLong();
            long R = scanner.nextLong();
            writer.println("Case #" + testNumber + ": " + calculate(L, R));
        }
    }
}