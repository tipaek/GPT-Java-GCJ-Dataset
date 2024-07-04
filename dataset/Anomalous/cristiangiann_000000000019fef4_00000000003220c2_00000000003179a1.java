import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            char[] modifiedValues = new char[10];

            int U = scanner.nextInt();
            Set<Character>[] validNumbers = new Set[10];
            for (int i = 0; i < 10; i++) {
                validNumbers[i] = new HashSet<>();
            }

            for (int i = 0; i < 10000; i++) {
                int x = scanner.nextInt();
                String result = scanner.next();
                int length = result.length();

                if (length == (int) Math.ceil(Math.log10(x))) {
                    int leadingDigit = (int) (x / Math.pow(10, (int) Math.log10(x)));
                    validNumbers[leadingDigit].add(result.charAt(0));
                }
                validNumbers[0].add(result.charAt(length - 1));
            }

            for (int i = 1; i < 10; i++) {
                modifiedValues[i] = calculateValue(validNumbers[i], validNumbers);
            }
            modifiedValues[0] = (char) validNumbers[0].toArray()[0];

            System.out.print("Case #" + (t + 1) + ": ");
            for (char value : modifiedValues) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    private static char calculateValue(Set<Character> validNumbers, Set<Character>[] allValidNumbers) {
        char selectedChar = (char) validNumbers.toArray()[0];
        for (Set<Character> set : allValidNumbers) {
            set.remove(selectedChar);
        }
        return selectedChar;
    }
}