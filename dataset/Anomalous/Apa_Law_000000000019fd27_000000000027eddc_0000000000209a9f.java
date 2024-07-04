import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < testCases; i++) {
            String[] input = sc.nextLine().split("");
            int[] numbers = new int[input.length];

            for (int j = 0; j < input.length; j++) {
                numbers[j] = Integer.parseInt(input[j]);
            }

            StringBuilder result = new StringBuilder();

            for (int j = 0; j < numbers.length; j++) {
                int currentNumber = numbers[j];

                if (j == 0) {
                    for (int k = 0; k < currentNumber; k++) {
                        result.append("(");
                    }
                    result.append(currentNumber);
                    if (j == numbers.length - 1) {
                        for (int k = 0; k < currentNumber; k++) {
                            result.append(")");
                        }
                    }
                } else {
                    int difference = numbers[j - 1] - currentNumber;

                    if (difference > 0) {
                        for (int k = 0; k < difference; k++) {
                            result.append(")");
                        }
                        result.append(currentNumber);
                    } else {
                        difference = Math.abs(difference);
                        for (int k = 0; k < difference; k++) {
                            result.append("(");
                        }
                        result.append(currentNumber);
                    }

                    if (j == numbers.length - 1) {
                        for (int k = 0; k < currentNumber; k++) {
                            result.append(")");
                        }
                    }
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + result.toString());
        }
        sc.close();
    }
}