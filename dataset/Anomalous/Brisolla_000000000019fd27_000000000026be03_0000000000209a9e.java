import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int cases = in.nextInt();
        int numberOfBits = in.nextInt();

        for (int i = 1; i <= cases; i++) {
            String currentArray = readAnArray(numberOfBits, in);
            List<String> possibilities = getPossibilities(currentArray);

            for (int j = 0; j < numberOfBits; j++) {
                System.out.println(j);
                int currentBit = in.nextInt();

                Iterator<String> iterator = possibilities.iterator();
                while (iterator.hasNext()) {
                    String array = iterator.next();
                    if (array.charAt(j) != (char) (currentBit + '0')) {
                        iterator.remove();
                    }
                }

                if (possibilities.size() == 1 || j == numberOfBits / 2 + 1) {
                    currentArray = possibilities.get(0);
                    break;
                }
            }
            System.out.println(currentArray);
        }
    }

    public static String readAnArray(int size, Scanner in) {
        StringBuilder array = new StringBuilder();

        for (int j = 1; j <= size; j++) {
            System.out.println(j);
            array.append(in.nextInt());
        }

        return array.toString();
    }

    public static List<String> getPossibilities(String array) {
        String complemented = complement(array);
        String reversed = reverse(array);
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

    private static String reverse(String array) {
        return new StringBuilder(array).reverse().toString();
    }
}