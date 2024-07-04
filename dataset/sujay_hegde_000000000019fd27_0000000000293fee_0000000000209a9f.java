import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        scanner.nextLine();
        String str;

        int curDepth;
        int digit;
        int deptDiff;
        int caseNum = 0;

        StringBuilder sPrime = new StringBuilder();
        while (t-- > 0) {
            str = scanner.nextLine();

            curDepth = 0;
            for (char c : str.toCharArray()) {
                digit = Integer.parseInt(String.valueOf(c));

                deptDiff = digit - curDepth;
                if (deptDiff > 0) {
                    // add parens
                    for (int i = 0; i < deptDiff; i++) {
                        sPrime.append("(");
                    }
                } else if (deptDiff < 0) {
                    // close parens
                    for (int i = 0; i < Math.abs(deptDiff); i++) {
                        sPrime.append(")");
                    }
                }

                sPrime.append(c);
                curDepth = digit;
            }
            while (curDepth-- > 0) {
                sPrime.append(")");

            }

            System.out.println("Case #" + ++caseNum + ": " + sPrime.toString());
            sPrime.setLength(0);
        }
    }
}
