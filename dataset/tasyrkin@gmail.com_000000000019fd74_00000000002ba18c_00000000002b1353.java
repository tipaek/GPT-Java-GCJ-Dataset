import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int T = scanner.nextInt();
        int caseNumber = 0;
        while (caseNumber++ < T) {
            final int N = scanner.nextInt();

            StringBuilder sb = new StringBuilder();
            if (N == 501) {
                sb.append("1 1\n");
                sb.append("2 1\n");
                sb.append("3 2\n");
                sb.append("3 1\n");
                for (int i = 0; i < 496; i++) {
                    sb.append(String.format("%d %d\n", i + 4, 1));
                }
            } else {
                for (int i = 0; i < Math.min(N, 500); i++) {
                    sb.append(String.format("%d %d\n", i + 1, 1));
                }
            }

            System.out.println(
                    String.format(
                            "Case #%d:", caseNumber
                    )
            );
            System.out.print(sb.toString());
        }
    }
}
