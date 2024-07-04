import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int T = scanner.nextInt();
        int caseNumber = 0;
        while (caseNumber++ < T) {
            final int N = scanner.nextInt();

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < Math.min(N, 499); i++) {
                sb.append(String.format("%d %d\n", i+1, 1));
            }
            if(N == 501) {
                sb.append(String.format("%d %d\n", 500, 2));
            } else if (N == 500) {
                sb.append(String.format("%d %d\n", 500, 1));
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
