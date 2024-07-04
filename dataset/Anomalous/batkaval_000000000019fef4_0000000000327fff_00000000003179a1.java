import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            System.out.print("Case #" + caseNumber + ": ");

            int u = scanner.nextInt();
            Map<Character, Set<Integer>> charToPossibleDigits = new HashMap<>();
            Map<Integer, Character> digitToCharSolution = new HashMap<>();
            Map<Character, Integer> charToDigitSolution = new HashMap<>();

            long maxQueries = (long) Math.pow(10, 4);
            for (int i = 1; i <= maxQueries; i++) {
                int query = scanner.nextInt();
                String response = scanner.next();

                if (response.length() == 1) {
                    char c = response.charAt(0);
                    Set<Integer> possibles = charToPossibleDigits.computeIfAbsent(c, k -> initializeSet());
                    possibles.remove(0);
                    filterPossibles(query, possibles);
                }
                if (response.length() == String.valueOf(query).length()) {
                    String queryStr = String.valueOf(query);
                    char c = response.charAt(0);
                    Set<Integer> possibles = charToPossibleDigits.computeIfAbsent(c, k -> initializeSet());
                    possibles.remove(0);
                    filterPossibles(Character.getNumericValue(queryStr.charAt(0)), possibles);

                    int index = 0;
                    while (index < queryStr.length() && (getDigitAt(index, query) != 1 ||
                            (charToDigitSolution.get(response.charAt(index)) != null &&
                                    charToDigitSolution.get(response.charAt(index)) == getDigitAt(index, query)))) {
                        index++;
                    }

                    index++;
                    if (index > 0 && index < queryStr.length()) {
                        c = response.charAt(index);
                        possibles = charToPossibleDigits.computeIfAbsent(c, k -> initializeSet());
                        filterPossibles(getDigitAt(index, query), possibles);
                    }
                }

                charToPossibleDigits.forEach((key, value) -> {
                    if (value.size() == 1) {
                        int digit = value.iterator().next();
                        digitToCharSolution.put(digit, key);
                        charToDigitSolution.put(key, digit);
                    }
                });

                charToPossibleDigits.forEach((key, value) -> digitToCharSolution.keySet().forEach(value::remove));
            }

            for (int i = 0; i <= 9; i++) {
                System.out.print(digitToCharSolution.get(i));
            }
            System.out.println();
        }
    }

    private static int getDigitAt(int index, int number) {
        return Character.getNumericValue(String.valueOf(number).charAt(index));
    }

    private static void filterPossibles(int digit, Set<Integer> possibles) {
        if (digit < 9) {
            for (int x = digit + 1; x <= 9; x++) {
                possibles.remove(x);
            }
        }
    }

    private static Set<Integer> initializeSet() {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= 9; i++) {
            set.add(i);
        }
        return set;
    }
}