import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numTestCases;
        while (true) {
            numTestCases = scanner.nextInt();
            if (numTestCases >= 1 && numTestCases <= 100) {
                break;
            } else {
                System.out.println("Value must be between 1 and 100");
            }
        }

        for (int eachinput = 0; eachinput < numTestCases; eachinput++) {
            String str;
            while (true) {
                str = scanner.next();
                if (str.matches("[01]+")) {
                    break;
                }
            }

            StringBuilder resultBuf = new StringBuilder();
            boolean bOpenParam = false;

            for (int i = 0; i < str.length(); i++) {
                char currentChar = str.charAt(i);

                if (currentChar == '0') {
                    if (bOpenParam) {
                        resultBuf.append(")");
                        bOpenParam = false;
                    }
                    resultBuf.append("0");
                } else {
                    if (!bOpenParam) {
                        resultBuf.append("(");
                        bOpenParam = true;
                    }
                    resultBuf.append("1");

                    while (i + 1 < str.length() && str.charAt(i + 1) == '1') {
                        resultBuf.append("1");
                        i++;
                    }

                    if (i + 1 == str.length() || str.charAt(i + 1) == '0') {
                        resultBuf.append(")");
                        bOpenParam = false;
                    }
                }
            }

            System.out.println("Case #" + (eachinput + 1) + ": " + resultBuf.toString());
        }

        scanner.close();
    }
}