import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.nextLine();
            System.err.println(input);

            StringBuilder output = new StringBuilder();
            boolean isOpen = false;

            for (char character : input.toCharArray()) {
                if (character == '1') {
                    if (!isOpen) {
                        output.append("(");
                        isOpen = true;
                    }
                    output.append(character);
                } else {
                    if (isOpen) {
                        output.append(")");
                        isOpen = false;
                    }
                    output.append(character);
                }
            }
            if (isOpen) {
                output.append(")");
            }

            System.out.println("Case #" + caseNumber + ": " + output.toString());
        }
    }
}