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

            Map<Character, Set<Integer>> charPossibilities = new HashMap<>();
            Map<Integer, Character> solution = new HashMap<>();
            Map<Character, Integer> reverseSolution = new HashMap<>();

            long maxQueries = (long) Math.pow(10, 4);
            for (int i = 1; i <= maxQueries; i++) {
                int query = scanner.nextInt();
                String response = scanner.next();

                if (response.length() == 1) {
                    char c = response.charAt(0);
                    Set<Integer> possibles = charPossibilities.computeIfAbsent(c, k -> initializeSet());
                    possibles.remove(0);
                    filterPossibilities(query, possibles);
                }

                if (response.length() == String.valueOf(query).length()) {
                    String queryStr = String.valueOf(query);
                    char c = response.charAt(0);
                    Set<Integer> possibles = charPossibilities.computeIfAbsent(c, k -> initializeSet());
                    possibles.remove(0);
                    filterPossibilities(Character.getNumericValue(queryStr.charAt(0)), possibles);

                    int index = 0;
                    while (index < queryStr.length()) {
                        if (getDigit(index, query) == 1 ||
                                (reverseSolution.get(response.charAt(index)) != null &&
                                reverseSolution.get(response.charAt(index)) == getDigit(index, query))) {
                            index++;
                        } else {
                            break;
                        }
                    }

                    index++;
                    if (index > 0 && index < queryStr.length()) {
                        c = response.charAt(index);
                        possibles = charPossibilities.computeIfAbsent(c, k -> initializeSet());
                        filterPossibilities(getDigit(index, query), possibles);
                    }
                }

                charPossibilities.forEach((key, value) -> {
                    if (value.size() == 1) {
                        int nextDigit = value.iterator().next();
                        solution.put(nextDigit, key);
                        reverseSolution.put(key, nextDigit);
                    }
                });

                charPossibilities.forEach((key, value) -> solution.keySet().forEach(value::remove));
                if (solution.keySet().size() == 10) {
                    break;
                }
            }

            for (int i = 0; i <= 9; i++) {
                System.out.print(solution.get(i));
            }
            System.out.println();
        }
    }

    private static int getDigit(int index, int number) {
        return Character.getNumericValue(String.valueOf(number).charAt(index));
    }

    private static void filterPossibilities(int digit, Set<Integer> possibles) {
        if (digit < 9) {
            for (int x = digit + 1; x <= 9; x++) {
                possibles.remove(x);
            }
        }
    }

    private static Set<Integer> initializeSet() {
        return new HashSet<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
    }
}