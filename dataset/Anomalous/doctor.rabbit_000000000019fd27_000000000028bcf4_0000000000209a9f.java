import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numOfCases = Character.getNumericValue(scanner.nextLine().charAt(0));

        while (scanner.hasNextLine()) {
            String caseString = scanner.nextLine();
            int currentDepth = 0;
            List<Character> outputList = new ArrayList<>();

            for (char ch : caseString.toCharArray()) {
                if (ch == '0') {
                    if (currentDepth == 1) {
                        outputList.add(')');
                        currentDepth--;
                    }
                    outputList.add(ch);
                } else if (ch == '1') {
                    if (currentDepth == 0) {
                        outputList.add('(');
                        currentDepth++;
                    }
                    outputList.add(ch);
                }
            }

            while (currentDepth > 0) {
                outputList.add(')');
                currentDepth--;
            }

            StringBuilder outputString = new StringBuilder();
            for (char ch : outputList) {
                outputString.append(ch);
            }

            System.out.println(outputString.toString());
        }
    }
}