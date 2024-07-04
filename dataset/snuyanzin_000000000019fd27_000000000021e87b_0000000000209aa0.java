import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = in.nextInt();
        StringBuilder output = new StringBuilder();
        for (int i = 1; i < numberOfCases + 1; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            if (n > 0 && k % n == 0 && k / n <= n && k > 0) {
                int[] array = IntStream.rangeClosed(1, n).toArray();

                StringBuilder sb = new StringBuilder("Case #" + i + ": POSSIBLE\n");

                for (int q = k / n - 1; q < n + k / n - 1; q++) {
                    for (int j = 0; j < n; j++) {
                        int i1 = array[(n + q - j) % n];
                        sb.append(i1);
                        if (j != n - 1) {
                            sb.append(" ");
                        }
                    }
                    sb.append("\n");
                }
                output.append(sb.toString());
            } else {
                output.append("Case #").append(i).append(": IMPOSSIBLE\n");
            }
        }
        System.out.print(output.toString());
    }
}
