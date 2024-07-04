import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static int testcaseNumber = 0;

    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
        int testcases = scan.nextInt();
        List<String> list = new ArrayList<>();
        while (testcases > 0) {
            String input = scan.next();
            list.add(input);
            testcases--;
        }

        for (String input : list) {
            testcaseNumber += 1;
            int i = 0;
            StringBuilder result = new StringBuilder();
            int openingCount = 0;

            while (i < input.length()) {
                char currChar = input.charAt(i);
                Integer current = currChar - '0';
                int diff = current - openingCount;

                if (current == 0) {
                    while (openingCount > 0) {
                        result.append(")");
                        openingCount--;
                    }
                    result.append("0");
                    i++;
                    continue;
                }

                if (diff > 0) {
                    while (diff > 0) {
                        result.append("(");
                        openingCount++;
                        diff--;
                    }
                } else if (diff < 0) {
                    while (diff < 0) {
                        result.append(")");
                        openingCount--;
                        diff++;
                    }
                }

                result.append(currChar);
                i++;
            }
            while (openingCount > 0) {
                result.append(")");
                openingCount--;
            }

            System.out.println("Case #" + testcaseNumber + ": " + result);
        }
    }    
}
