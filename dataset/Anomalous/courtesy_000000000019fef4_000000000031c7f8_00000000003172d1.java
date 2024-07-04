import java.io.*;
import java.util.*;

public class Solution {

    public static Scanner scanner = new Scanner(System.in);
    public static PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        int T = scanner.nextInt();
        for (int cs = 1; cs <= T; cs++) {
            int N = scanner.nextInt();
            int D = scanner.nextInt();
            if (D > 3) return;

            long[] A = new long[N];
            for (int i = 0; i < N; i++) {
                A[i] = scanner.nextLong();
            }
            Arrays.sort(A);

            writer.print("Case #" + cs + ": ");

            if (D == 2) {
                boolean matched = false;
                for (int i = 1; i < N; i++) {
                    if (A[i] == A[i - 1]) {
                        matched = true;
                        break;
                    }
                }
                writer.println(matched ? "0" : "1");
            } else {
                boolean zero = false;
                boolean one = false;
                Set<Long> set = new HashSet<>();
                for (int i = N - 1; i >= 0; i--) {
                    if (i + 2 < N && A[i] == A[i + 1] && A[i] == A[i + 2]) {
                        zero = true;
                        break;
                    }
                    if (set.contains(2 * A[i])) {
                        one = true;
                    }
                    set.add(A[i]);
                }
                if (zero) {
                    writer.println("0");
                } else if (one) {
                    writer.println("1");
                } else {
                    writer.println("2");
                }
            }
        }
        writer.flush();
    }
}