import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Integer cases = in.nextInt();

        Integer numberOfBits = in.nextInt();

        for (int i = 1; i <= cases; i ++) {

            String currentArray = "";

            for (int j = 1; j <= numberOfBits; j++) {

                System.out.println(j);
                currentArray += in.nextInt();
            }

            List<String> possibilities = getPossibilities(currentArray);

            for (int j = 1; j <= numberOfBits / 2 + 1; j++) {

                System.out.println(j);

                Integer currentBit = in.nextInt();

                for (int k = 0; k < possibilities.size(); k++) {

                    String array = possibilities.get(k);

                    Integer currentPosition = Integer.valueOf(array.substring(j - 1, j));

                    if (currentPosition != currentBit)
                        possibilities.remove(k--);
                }

                if (possibilities.size() == 1)
                    break;
            }
            System.out.println(possibilities.get(0));
        }
    }

    public static List<String> getPossibilities(String array) {

        String complemented = complement(array);
        String reversed = reverse(array);
        String complementedReversed = complement(reversed);

        return new LinkedList<>(
                Arrays.asList(array, complemented, reversed, complementedReversed));
    }

    private static String complement(String array) {

        String result = "";

        for (Character c : array.toCharArray())
            result += (c == '0') ? "1" : "0";

        return result;
    }

    private static String reverse(String array) {

        return new StringBuffer(array).reverse().toString();
    }
}
