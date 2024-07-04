import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] firstBracket = {"", "(", "((", "(((", "((((", "(((((", "((((((", "(((((((", "((((((((", "((((((((("};
        String[] lastBracket = {"", ")", "))", ")))", "))))", ")))))", "))))))", ")))))))", "))))))))", ")))))))))"};

        int testCase;
        testCase = scan.nextInt();

        String[] testCaseString = new String[testCase];
        scan = new Scanner(System.in);

        for(int i = 0; i < testCase; i++) {
            testCaseString[i] = scan.nextLine();
        }

        for(int i = 0; i < testCase; i++) {
            String result = "Case #" + (i+1) + ": ";
            int number1 = testCaseString[i].charAt(0) - '0';
            result = result.concat(firstBracket[number1] + testCaseString[i].charAt(0));
            for(int j = 1; j < testCaseString[i].length(); j++) {
                int number2 = testCaseString[i].charAt(j) - '0';
                if(number1 > number2) {
                    result = result.concat(lastBracket[number1 - number2] + testCaseString[i].charAt(j));
                }
                else if(number1 < number2) {
                    result = result.concat(firstBracket[number2 - number1] + testCaseString[i].charAt(j));
                }
                else
                    result = result.concat(testCaseString[i].charAt(j) + "");
                number1 = testCaseString[i].charAt(j) - '0';
            }
            result = result.concat(lastBracket[testCaseString[i].charAt(testCaseString[i].length() - 1) - '0']);
            System.out.println(result);
        }
    }
}
