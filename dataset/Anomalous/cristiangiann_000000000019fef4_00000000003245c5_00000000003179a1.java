import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            char[] modifiedValues = new char[10];
            int U = scanner.nextInt();
            Set<Character>[] validNumbers = new HashSet[10];

            for (int i = 0; i < 10; i++) {
                validNumbers[i] = new HashSet<>();
            }

            for (int i = 0; i < 10000; i++) {
                int x = scanner.nextInt();
                String result = scanner.next();
                int resultLength = result.length();
                int xLength = (int) Math.ceil(Math.log10(x + 1));

                if (resultLength == xLength) {
                    int index = (int) (x / Math.pow(10, (int) Math.log10(x)));
                    validNumbers[index].add(result.charAt(0));
                }

                validNumbers[0].add(result.charAt(resultLength - 1));
            }

            for (int i = 1; i < 10; i++) {
                modifiedValues[i] = calculateValues(validNumbers[i], validNumbers);
            }
            modifiedValues[0] = validNumbers[0].iterator().next();

            System.out.print("Case #" + testCase + ": ");
            for (char value : modifiedValues) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    private static char calculateValues(Set<Character> validNumbers, Set<Character>[] allValidNumbers) {
        char firstValidChar = validNumbers.iterator().next();
        for (Set<Character> validSet : allValidNumbers) {
            validSet.remove(firstValidChar);
        }
        return firstValidChar;
    }
}