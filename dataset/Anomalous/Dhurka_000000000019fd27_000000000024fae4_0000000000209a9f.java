import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            String input = scanner.next();
            int num = Integer.parseInt(input);
            List<String> result = new ArrayList<>();
            char[] characters = input.toCharArray();
            int length = characters.length;
            int openBrackets = 0;

            for (int i = 0; i < length; i++) {
                int currentDigit = characters[i] - '0';

                if (i == 0) {
                    openBrackets = currentDigit;
                    for (int j = 0; j < openBrackets; j++) {
                        result.add("(");
                    }
                    result.add(Character.toString(characters[i]));
                    for (int j = 0; j < openBrackets; j++) {
                        result.add(")");
                    }
                } else {
                    int previousDigit = characters[i - 1] - '0';

                    if (currentDigit > previousDigit) {
                        int difference = currentDigit - previousDigit;
                        for (int j = 0; j < difference; j++) {
                            result.add("(");
                        }
                        result.add(Character.toString(characters[i]));
                        for (int j = 0; j < difference; j++) {
                            result.add(")");
                        }
                    } else if (currentDigit < previousDigit) {
                        int difference = previousDigit - currentDigit;
                        openBrackets += difference;
                        result.add(Character.toString(characters[i]));
                    } else {
                        result.add(Character.toString(characters[i]));
                    }
                }
            }

            StringBuilder output = new StringBuilder();
            for (String str : result) {
                output.append(str);
            }

            System.out.println("Case #" + caseNumber + ": " + output.toString());
            caseNumber++;
        }
    }
}