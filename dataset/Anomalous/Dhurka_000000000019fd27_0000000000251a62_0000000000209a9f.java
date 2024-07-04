import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            String str = scanner.next();
            int num = Integer.parseInt(str);
            List<String> result = new ArrayList<>();
            char[] characters = str.toCharArray();
            int length = characters.length;
            int openCount = 0;

            for (int i = 0; i < length; i++) {
                int currentDigit = characters[i] - '0';

                if (i == 0) {
                    openCount = currentDigit;
                    for (int j = 0; j < currentDigit; j++) {
                        result.add("(");
                    }
                    result.add(Character.toString(characters[i]));
                    for (int j = 0; j < currentDigit; j++) {
                        result.add(")");
                    }
                } else {
                    int previousDigit = characters[i - 1] - '0';
                    if (currentDigit > previousDigit) {
                        int diff = currentDigit - previousDigit;
                        for (int j = 0; j < diff; j++) {
                            result.add(openCount++, "(");
                        }
                        result.add(openCount++, Character.toString(characters[i]));
                        for (int j = 0; j < diff; j++) {
                            result.add(openCount++, ")");
                        }
                    } else {
                        int diff = previousDigit - currentDigit;
                        openCount += diff;
                        result.add(openCount++, Character.toString(characters[i]));
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (String part : result) {
                sb.append(part);
            }

            System.out.println("Case #" + caseNumber + ": " + sb.toString());
            caseNumber++;
        }

        scanner.close();
    }
}