import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int T = scanner.nextInt();
        int caseNumber = 0;
        while (caseNumber++ < T) {
            final char[] digits = scanner.next().toCharArray();
            StringBuilder sb = new StringBuilder();
            int oneIdx = -1;
            for (int i = 0; i < digits.length; i++) {
                if (digits[i] == '1') {
                    if (oneIdx == -1) {
                        oneIdx = i;
                    }
                } else {
                    if (oneIdx != -1) {
                        sb.append("(");
                        for (int j = oneIdx; j < i; j++) {
                            sb.append('1');
                        }
                        sb.append(")");
                        oneIdx = -1;
                    }
                    sb.append('0');
                }
            }
            if (oneIdx != -1) {
                sb.append("(");
                for (int j = oneIdx; j < digits.length; j++) {
                    sb.append('1');
                }
                sb.append(")");
            }


            System.out.println(
                    String.format("Case #%d: %s", caseNumber, sb.toString())
            );
        }
    }
}
