import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 0; t < testCases; t++) {
            String input = scanner.next();
            System.out.print("Case #" + (t + 1) + ": ");
            int previousDigit = 0;
            
            for (int i = 0; i < input.length(); i++) {
                int currentDigit = Character.getNumericValue(input.charAt(i));
                int difference = currentDigit - previousDigit;
                
                if (difference > 0) {
                    printCharacters('(', difference);
                } else if (difference < 0) {
                    printCharacters(')', -difference);
                }
                
                System.out.print(currentDigit);
                previousDigit = currentDigit;
            }
            
            printCharacters(')', previousDigit);
            System.out.println();
        }
        scanner.close();
    }

    private static void printCharacters(char character, int times) {
        for (int i = 0; i < times; i++) {
            System.out.print(character);
        }
    }
}