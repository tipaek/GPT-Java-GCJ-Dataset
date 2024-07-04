import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int openBracket = 0;

        String testCaseCount;
        testCaseCount = scan.nextLine();
        int testCase = testCaseCount.charAt(0) - '0';

        for(int i = 0; i < testCase; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            String testCaseString = scan.nextLine();
            StringBuilder stringBuilder = new StringBuilder();
            int previousValue = 0;
            for (int j = 0; j < testCaseString.length(); j++) {
                int currentValue = Integer.parseInt(testCaseString.charAt(j) + "");
                if(previousValue < currentValue){
                    openBracket = currentValue - previousValue;
                    for(int a = 0; a < openBracket; a++)
                        stringBuilder.append("(");
                }
                else if(previousValue > currentValue) {
                    for (int a = 0; a < (previousValue - currentValue); a++)
                        stringBuilder.append(")");
                }
                stringBuilder.append(currentValue);
                previousValue = currentValue;
                openBracket = currentValue;
            }
            for (int a = 0; a < openBracket; a++)
                stringBuilder.append(")");
            System.out.println(stringBuilder.toString());
        }
    }
}
