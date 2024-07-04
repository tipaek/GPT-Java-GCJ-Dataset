import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < testCases; i++) {
            int numInputs = Integer.parseInt(scanner.nextLine());
            
            String finalAnswer = "";
            boolean conflictDetected = false;

            for (int j = 0; j < numInputs; j++) {
                String input = scanner.nextLine();
                if (input.charAt(0) == '*') {
                    input = input.substring(1);
                }

                if (finalAnswer.contains(input)) {
                    // No operation needed
                } else if (input.contains(finalAnswer)) {
                    finalAnswer = input;
                } else {
                    conflictDetected = true;
                }
            }

            if (conflictDetected) {
                System.out.println("Case #" + (i + 1) + ": *");
            } else {
                System.out.println("Case #" + (i + 1) + ": " + finalAnswer);
            }
        }
    }
}