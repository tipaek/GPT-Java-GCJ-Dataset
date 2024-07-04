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

            for (int j = 1; j <= numberOfBits / 2 + 1; j++) {
                System.out.println(j);
                int currentBit = scanner.nextInt();
                
                for (Iterator<String> iterator = possibilities.iterator(); iterator.hasNext();) {
                    String array = iterator.next();
                    int currentPosition = Character.getNumericValue(array.charAt(j - 1));
                    
                    if (currentPosition != currentBit) {
                        iterator.remove();
                    }
                }

                if (possibilities.size() == 1) {
                    break;
                }
            }

            System.out.println(possibilities.get(0));
            scanner.next();
        }
    }

    public static List<String> generatePossibilities(String array) {
        String complemented = complement(array);
        String reversed = reverse(array);
        String complementedReversed = complement(reversed);

        return new ArrayList<>(Arrays.asList(array, complemented, reversed, complementedReversed));
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