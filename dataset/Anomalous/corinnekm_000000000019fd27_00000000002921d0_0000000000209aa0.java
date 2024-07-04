import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(sc.nextLine());

        for (int t = 0; t < T; t++) {
            String[] input = sc.nextLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[1]);
            boolean impossible = K < N || K > N * N || K % N != 0;

            String[] lines = new String[N];
            for (int i = 0; i < N; i++) {
                lines[i] = generateLine(K / N, i, N);
            }

            if (impossible) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (t + 1) + ": POSSIBLE");
                for (String line : lines) {
                    System.out.println(line);
                }
            }
        }
    }

    private static String generateLine(int start, int offset, int N) {
        StringBuilder builder = new StringBuilder();
        start = (start - offset + N) % N;

        for (int i = 0; i < N; i++) {
            if (i > 0) {
                builder.append(" ");
            }
            builder.append((start + i) % N + 1);
        }

        return builder.toString();
    }
}