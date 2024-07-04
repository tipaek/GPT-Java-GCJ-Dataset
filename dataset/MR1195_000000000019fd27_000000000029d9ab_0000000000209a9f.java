import java.util.Scanner;

public class Solution {
    static int testcaseNumber = 0;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int testcases = scan.nextInt();

        while (testcases > 0) {
            int i = 0;
            testcaseNumber += 1;
            StringBuilder result = new StringBuilder();
            int openingCount = 0;
            int diff = 0;

            String input = scan.next();
            while (i < input.length()) {
                char currChar = input.charAt(i);
                Integer current = currChar - '0';
                diff = current - openingCount;

            /*check later*/
                if (current == 0) {
                    while (openingCount > 0) {
                        result.append(")");
                        openingCount--;
                    }
                    result.append("0");
                    i++;
                    continue;
                }

                if (diff == 0) {
                    result.append(currChar);
                } else if (diff > 0) {
                    while (diff > 0) {
                        result.append("(");
                        openingCount++;
                        diff--;
                    }
                    result.append(currChar);
                } else {
                    while (diff < 0) {
                        result.append(")");
                        openingCount--;
                        diff++;
                    }
                    result.append(currChar);
                }

                i++;
            }
            while (openingCount > 0) {
                result.append(")");
                openingCount--;
            }

            System.out.println("Case #" + testcaseNumber + ":" + result);
            testcases--;
        }
    }
}
