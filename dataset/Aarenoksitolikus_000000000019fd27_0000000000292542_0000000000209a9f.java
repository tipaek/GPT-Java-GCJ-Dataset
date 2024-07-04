import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        String[] output = new String[t];
        for (int i = 0; i < t; i++) {
            output[i] = "";
            String input = scanner.nextLine();
            String[] currentLine = input.split("");
            int[] currentArray = new int[currentLine.length];
            for (int j = 0; j < currentArray.length; j++) {
                currentArray[j] = Integer.parseInt(currentLine[j]);
            }
            for (int k = 0; k < currentArray[0]; k++) {
                output[i] += "(";
            }
            output[i] += currentArray[0];
            int currentCount = currentArray[0];
            for (int j = 1; j < currentArray.length; j++) {
                if (currentArray[j] > currentCount) {
                    for (int k = 0; k < currentArray[j] - currentCount; k++) {
                        output[i] += "(";
                    }
                } else if (currentArray[j] < currentCount) {
                    for (int k = 0; k < currentCount - currentArray[j]; k++) {
                        output[i] += ")";
                    }
                }
                output[i] += currentArray[j];
                currentCount = currentArray[j];
            }
            for (int j = 0; j < currentCount; j++) {
                output[i] += ")";
            }
        }
        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + output[i]);
        }
    }
}