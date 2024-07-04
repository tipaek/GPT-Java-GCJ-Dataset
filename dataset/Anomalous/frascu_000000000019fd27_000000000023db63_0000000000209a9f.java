import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            scanner.nextLine();

            for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
                String inputString = scanner.nextLine();
                char[] characters = inputString.toCharArray();

                LinkedList<Integer> output = new LinkedList<>();

                for (char character : characters) {
                    int number = character - '0';
                    if (number > 0) {
                        if (!output.isEmpty()) {
                            int lastNumber = output.getLast();

                            if (lastNumber > 0) {
                                output.removeLast();
                            }
                            if (number != lastNumber) {
                                output.add(lastNumber - number);
                            }
                            output.add(0);
                            output.add(number);
                        } else {
                            output.add(-number);
                            output.add(0);
                            output.add(number);
                        }
                    } else {
                        output.add(0);
                    }
                }

                StringBuilder result = new StringBuilder();
                int charIndex = 0;
                for (Integer value : output) {
                    if (value < 0) {
                        result.append("(".repeat(Math.abs(value)));
                    } else if (value > 0) {
                        result.append(")".repeat(value));
                    } else {
                        result.append(characters[charIndex]);
                        charIndex++;
                    }
                }

                System.out.println("Case #" + (caseIndex + 1) + ": " + result);
            }
        }
    }
}