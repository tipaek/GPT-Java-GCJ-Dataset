import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int numCases = s.nextInt();

        for(int caseNum=1; caseNum <= numCases; caseNum++) {
            String inputString = s.next();
            String resultString = parenthesize(inputString);

            System.out.format("Case #%d: %s\n", caseNum, resultString);
        }
    }

    private static String parenthesize(String inputString) {
        int currentNumberOfParanthesis = 0;
        StringBuilder sb = new StringBuilder();

        for(char c : inputString.toCharArray()) {
            int nextNumber = c-'0';

            while(nextNumber>currentNumberOfParanthesis) {
                sb.append("(");
                currentNumberOfParanthesis++;
            }
            while(nextNumber<currentNumberOfParanthesis) {
                sb.append(")");
                currentNumberOfParanthesis--;
            }
            sb.append(nextNumber);
        }

        while(currentNumberOfParanthesis > 0) {
            sb.append(")");
            currentNumberOfParanthesis--;
        }

        return sb.toString();
    }
}
