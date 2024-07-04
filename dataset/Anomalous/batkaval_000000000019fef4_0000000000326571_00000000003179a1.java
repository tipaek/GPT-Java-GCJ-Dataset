import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            System.out.print("Case #" + caseNum + ": ");

            int u = scanner.nextInt();
            Map<Character, Set<Integer>> charToPossibleDigits = new HashMap<>();
            Map<Integer, Character> digitToChar = new HashMap<>();

            long maxQueries = (long) Math.pow(10, 4);
            for (int i = 1; i <= maxQueries; i++) {
                int query = scanner.nextInt();
                String response = scanner.next();

                if (response.length() == 1) {
                    char c = response.charAt(0);
                    Set<Integer> possibleDigits = charToPossibleDigits.computeIfAbsent(c, k -> createDigitSet());
                    possibleDigits.remove(0);
                    filterPossibleDigits(query, possibleDigits);
                } else if (response.length() == String.valueOf(query).length()) {
                    String queryStr = String.valueOf(query);
                    char c = response.charAt(0);
                    Set<Integer> possibleDigits = charToPossibleDigits.computeIfAbsent(c, k -> createDigitSet());
                    possibleDigits.remove(0);
                    filterPossibleDigits(Character.getNumericValue(queryStr.charAt(0)), possibleDigits);

                    int index = 0;
                    while (index < queryStr.length() && getDigitAt(index, query) != 1) {
                        index++;
                    }

                    index++;
                    if (index > 0 && index < queryStr.length()) {
                        c = response.charAt(index);
                        possibleDigits = charToPossibleDigits.computeIfAbsent(c, k -> createDigitSet());
                        filterPossibleDigits(getDigitAt(index, query), possibleDigits);
                    }
                }

                charToPossibleDigits.forEach((k, v) -> {
                    if (v.size() == 1) {
                        digitToChar.put(v.iterator().next(), k);
                    }
                });

                charToPossibleDigits.forEach((k, v) -> digitToChar.keySet().forEach(v::remove));

                if (digitToChar.size() == 10) {
                    break;
                }
            }

            for (int i = 0; i <= 9; i++) {
                System.out.print(digitToChar.get(i));
            }
            System.out.println();
        }
    }

    private static int getDigitAt(int index, int number) {
        return Character.getNumericValue(String.valueOf(number).charAt(index));
    }

    private static void filterPossibleDigits(int digit, Set<Integer> possibleDigits) {
        if (digit < 9) {
            for (int x = digit + 1; x <= 9; x++) {
                possibleDigits.remove(x);
            }
        }
    }

    private static Set<Integer> createDigitSet() {
        Set<Integer> digitSet = new HashSet<>();
        for (int i = 0; i <= 9; i++) {
            digitSet.add(i);
        }
        return digitSet;
    }
}