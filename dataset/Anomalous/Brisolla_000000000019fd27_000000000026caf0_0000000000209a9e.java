import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cases = scanner.nextInt();
        int numberOfBits = scanner.nextInt();

        for (int i = 0; i < cases; i++) {
            StringBuilder currentArray = new StringBuilder();

            for (int j = 0; j < numberOfBits; j++) {
                System.out.println(j + 1);
                currentArray.append(scanner.nextInt());
            }

            List<String> possibilities = getPossibilities(currentArray.toString());

            for (int j = 0; j < numberOfBits; j++) {
                System.out.println(j + 1);
                int currentBit = scanner.nextInt();

                possibilities.removeIf(array -> array.charAt(j) != (char) (currentBit + '0'));
                
                if (possibilities.size() == 1 || j == numberOfBits / 2) {
                    currentArray = new StringBuilder(possibilities.get(0));
                    break;
                }
            }
            System.out.println(currentArray);
        }
    }

    public static List<String> getPossibilities(String array) {
        String complemented = complement(array);
        String reversed = reverse(array);
        String complementedReversed = complement(reversed);

        return Arrays.asList(array, complemented, reversed, complementedReversed);
    }

    private static String complement(String array) {
        StringBuilder result = new StringBuilder();

        for (char c : array.toCharArray())
            result.append(c == '0' ? '1' : '0');

        return result.toString();
    }

    private static String reverse(String array) {
        return new StringBuilder(array).reverse().toString();
    }
}