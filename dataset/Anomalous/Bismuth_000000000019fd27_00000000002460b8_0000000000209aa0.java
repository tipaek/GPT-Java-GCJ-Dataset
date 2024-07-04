import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < T; i++) {
            result.append("Case #").append(i + 1).append(": ");
            int N = sc.nextInt();
            int K = sc.nextInt();
            int quotient = K / N;

            if (K % N == 0 && quotient <= N) {
                result.append("POSSIBLE\n");
                StringBuilder[] rows = new StringBuilder[N];
                int last = N;

                for (int j = 0; j < N; j++) {
                    rows[j] = new StringBuilder();
                    if (j == 0) {
                        for (int k = 1; k <= N; k++) {
                            rows[0].append(k).append(" ");
                        }
                    } else {
                        rows[j].append(rows[j - 1]);
                        rows[j].delete(rows[j].length() - 3, rows[j].length());
                        rows[j].insert(0, last + " ");
                        last--;
                    }
                    rows[j].append("\n");
                }

                StringBuilder orderedRows = new StringBuilder();
                int splitIndex = N;

                for (int j = 0; j < N; j++) {
                    int firstElement = Character.getNumericValue(rows[j].charAt(0));
                    if (firstElement == quotient) {
                        splitIndex = j;
                    }
                    if (j >= splitIndex) {
                        result.append(rows[j]);
                    } else {
                        orderedRows.append(rows[j]);
                    }
                }
                result.append(orderedRows);
            } else {
                result.append("IMPOSSIBLE\n");
            }
        }

        System.out.print(result.toString());
    }
}