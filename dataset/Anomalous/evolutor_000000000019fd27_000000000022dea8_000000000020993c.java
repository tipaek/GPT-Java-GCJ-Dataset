import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 0;

        while (testCases-- > 0) {
            caseNumber++;
            String input = scanner.next();
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);

                if (currentChar == '1') {
                    result.append('(');
                    for (int j = i; j < input.length(); j++) {
                        char nextChar = input.charAt(j);

                        if (nextChar == '1') {
                            result.append(nextChar);
                            if (j == input.length() - 1) {
                                result.append(')');
                                i = j;
                                break;
                            }
                        } else {
                            result.append(')');
                            result.append(nextChar);
                            i = j;
                            break;
                        }
                    }
                } else {
                    result.append(currentChar);
                }
            }

            System.out.println(result.toString());
        }

        scanner.close();
    }
}