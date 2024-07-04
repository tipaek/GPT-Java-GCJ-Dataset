import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numOfCases = Integer.parseInt(scanner.nextLine());

        for (int caseNum = 1; caseNum <= numOfCases; caseNum++) {
            String caseString = scanner.nextLine();
            int currentDepth = 0;
            List<Character> outputList = new ArrayList<>();

            for (char ch : caseString.toCharArray()) {
                int digit = ch - '0';
                while (currentDepth < digit) {
                    outputList.add('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    outputList.add(')');
                    currentDepth--;
                }
                outputList.add(ch);
            }

            while (currentDepth > 0) {
                outputList.add(')');
                currentDepth--;
            }

            StringBuilder outputBuilder = new StringBuilder();
            for (char value : outputList) {
                outputBuilder.append(value);
            }

            System.out.println("Case #" + caseNum + ": " + outputBuilder.toString());
        }
    }
}