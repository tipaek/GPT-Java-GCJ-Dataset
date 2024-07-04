import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cases = scanner.nextInt();
        int numberOfBits = scanner.nextInt();

        for (int i = 1; i <= cases; i++) {
            StringBuilder currentArray = new StringBuilder();

            for (int j = 1; j <= numberOfBits; j++) {
                System.out.println(j);
                currentArray.append(scanner.nextInt());
            }

            List<String> possibilities = generatePossibilities(currentArray.toString());

            for (int j = 1; j <= numberOfBits; j++) {
                System.out.println(j);
                int currentBit = scanner.nextInt();

                Iterator<String> iterator = possibilities.iterator();
                while (iterator.hasNext()) {
                    String array = iterator.next();
                    if (array.charAt(j - 1) != (char) (currentBit + '0')) {
                        iterator.remove();
                    }
                }

                if (possibilities.size() == 1 || j == numberOfBits / 2 + 1) {
                    currentArray = new StringBuilder(possibilities.get(0));
                    break;
                }
            }
            System.out.println(currentArray);
        }
    }

    public static List<String> generatePossibilities(String array) {
        String complemented = complement(array);
        String reversed = new StringBuilder(array).reverse().toString();
        String complementedReversed = complement(reversed);

        return Arrays.asList(array, complemented, reversed, complementedReversed);
    }

    private static String complement(String array) {
        StringBuilder result = new StringBuilder();

        for (char c : array.toCharArray()) {
            result.append(c == '0' ? '1' : '0');
        }

        return result.toString();
    }
}