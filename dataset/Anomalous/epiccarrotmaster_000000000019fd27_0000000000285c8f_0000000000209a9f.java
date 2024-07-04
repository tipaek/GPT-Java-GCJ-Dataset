import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputNumber = scanner.nextLine();
            StringBuilder result = new StringBuilder();

            boolean isOpenBracketNeeded = false;
            boolean wasPreviousCharOne = false;

            for (char digit : inputNumber.toCharArray()) {
                if (digit == '1') {
                    if (!wasPreviousCharOne) {
                        result.append('(');
                        wasPreviousCharOne = true;
                    }
                    isOpenBracketNeeded = true;
                } else {
                    if (isOpenBracketNeeded) {
                        result.append(')');
                        isOpenBracketNeeded = false;
                    }
                    wasPreviousCharOne = false;
                }
                result.append(digit);
            }

            if (isOpenBracketNeeded) {
                result.append(')');
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
    }
}