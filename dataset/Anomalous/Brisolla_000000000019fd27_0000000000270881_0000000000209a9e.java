import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        int numberOfBits = in.nextInt();

        for (int i = 0; i < cases; i++) {
            StringBuilder currentArray = new StringBuilder();

            for (int j = 0; j < numberOfBits; j++) {
                System.out.println(j + 1);
                currentArray.append(in.nextInt());
            }

            List<String> possibilities = generatePossibilities(currentArray.toString());

            for (int j = 0; j <= numberOfBits / 2; j++) {
                System.out.println(j + 1);
                int currentBit = in.nextInt();

                for (Iterator<String> iterator = possibilities.iterator(); iterator.hasNext(); ) {
                    String array = iterator.next();
                    int currentPosition = Character.getNumericValue(array.charAt(j));

                    if (currentPosition != currentBit) {
                        iterator.remove();
                    }
                }

                if (possibilities.size() == 1) {
                    break;
                }
            }
            System.out.println(possibilities.get(0));
        }
    }

    private static List<String> generatePossibilities(String array) {
        String complemented = complement(array);
        String reversed = new StringBuilder(array).reverse().toString();
        String complementedReversed = complement(reversed);

        return new ArrayList<>(Arrays.asList(array, complemented, reversed, complementedReversed));
    }

    private static String complement(String array) {
        StringBuilder result = new StringBuilder(array.length());

        for (char c : array.toCharArray()) {
            result.append(c == '0' ? '1' : '0');
        }

        return result.toString();
    }
}