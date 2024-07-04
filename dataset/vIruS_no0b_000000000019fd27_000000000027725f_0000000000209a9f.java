import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String testCaseCount;
        testCaseCount = scan.nextLine();
        int testCase = Integer.parseInt(testCaseCount);
        for(int i = 0; i < testCase; i++) {
            String testCaseString = scan.nextLine();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Case #" + (i + 1) + ": ");
            int previousValue = 0;
            for (int j = 0; j < testCaseString.length(); j++) {
                int currentValue = Integer.parseInt(testCaseString.charAt(j) + "");
                if(previousValue < currentValue){
                    for(int a = 0; a < currentValue - previousValue; a++)
                        stringBuilder.append("(");
                }
                else if(previousValue > currentValue) {
                    for (int a = 0; a < (previousValue - currentValue); a++)
                        stringBuilder.append(")");
                }
                stringBuilder.append(currentValue);
                previousValue = currentValue;
            }
            for (int a = 0; a < previousValue; a++)
                stringBuilder.append(")");
            System.out.println(stringBuilder.toString());
        }
    }
}