import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int T = scanner.nextInt();
        int caseNumber = 0;
        while (caseNumber++ < T) {
            int N = scanner.nextInt();

            StringBuilder sb = new StringBuilder();
            sb.append("1 1\n");
            --N;
            int curr = 1;
            int row = 2;
            while (N > 0) {
                if (N >= curr) {
                    sb.append(String.format("%d 2\n", row));
                    N -= curr;
                    if (N <= curr) {
                        --row;
                    }
                    ++curr;
                } else {
                    sb.append(String.format("%d 1\n", row));
                    N -= 1;
                }
                ++row;
            }

//            if (N == 501) {
//                sb.append("1 1\n");
//                sb.append("2 1\n");
//                sb.append("3 2\n");
//                sb.append("3 1\n");
//                for (int i = 0; i < 496; i++) {
//                    sb.append(String.format("%d %d\n", i + 4, 1));
//                }
//            } else if (N == 500) {
//                for (int i = 0; i < Math.min(N, 499); i++) {
//                    sb.append(String.format("%d %d\n", i + 1, 1));
//                }
//            }

            System.out.println(
                    String.format(
                            "Case #%d:", caseNumber
                    )
            );
            System.out.print(sb.toString());
        }
    }
}
