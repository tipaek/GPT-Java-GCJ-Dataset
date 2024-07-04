import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = Integer.parseInt(sc.nextLine());

        for (int testCase = 0; testCase < testCount; testCase++) {
            int digitCount = Integer.parseInt(sc.nextLine());
            Set<Character> uniqueCharacters = new HashSet<>();
            List<Character> characterList = new ArrayList<>();
            List<Query> queries = new ArrayList<>();

            for (int query = 0; query < 10_000; query++) {
                String[] input = sc.nextLine().split("\\s+");
                String queryResult = input[1];
                if (input[0].length() == input[1].length()) {
                    queries.add(new Query(input[0], input[1]));
                }
                if (uniqueCharacters.size() < 10) {
                    for (char ch : queryResult.toCharArray()) {
                        if (uniqueCharacters.add(ch)) {
                            characterList.add(ch);
                        }
                    }
                }
            }

            List<Character>[] possibleChars = new List[10];
            for (int i = 0; i < 10; i++) {
                possibleChars[i] = new ArrayList<>(characterList);
            }

            char[] solution = new char[10];
            int solvedCount = 0;
            int lowestUnsolvedNumber = 1;

            outerLoop:
            for (Query query : queries) {
                char firstChar = query.output.charAt(0);
                int firstDigit = Integer.parseInt(query.input.substring(0, 1));

                if (firstDigit == lowestUnsolvedNumber && possibleChars[lowestUnsolvedNumber].contains(firstChar)) {
                    solution[lowestUnsolvedNumber] = firstChar;
                    solvedCount++;
                    if (solvedCount == 10) break outerLoop;
                    lowestUnsolvedNumber = getNextUnsolvedNumber(solution, lowestUnsolvedNumber);

                    updatePossibleChars(possibleChars, solution, firstChar);
                    solveSinglePossibilities(solution, possibleChars);
                } else if (possibleChars[firstDigit].contains(firstChar) && firstDigit > lowestUnsolvedNumber) {
                    removeCharFromHigherIndices(possibleChars, firstChar, firstDigit);
                    solveSinglePossibilities(solution, possibleChars);
                }
            }

            printSolution(testCase, solution, solvedCount);
        }

        sc.close();
    }

    private static int getNextUnsolvedNumber(char[] solution, int currentUnsolved) {
        while (currentUnsolved < 10 && solution[currentUnsolved] != '\u0000') {
            currentUnsolved++;
        }
        return currentUnsolved;
    }

    private static void updatePossibleChars(List<Character>[] possibleChars, char[] solution, char usedChar) {
        for (int i = 0; i < 10; i++) {
            if (solution[i] == '\u0000') {
                possibleChars[i].remove(Character.valueOf(usedChar));
            }
        }
    }

    private static void solveSinglePossibilities(char[] solution, List<Character>[] possibleChars) {
        boolean updated;
        do {
            updated = false;
            for (int i = 0; i < 10; i++) {
                if (solution[i] == '\u0000' && possibleChars[i].size() == 1) {
                    solution[i] = possibleChars[i].get(0);
                    updated = true;
                    updatePossibleChars(possibleChars, solution, solution[i]);
                }
            }
        } while (updated);
    }

    private static void removeCharFromHigherIndices(List<Character>[] possibleChars, char character, int startIndex) {
        for (int i = startIndex + 1; i < 11; i++) {
            possibleChars[i % 10].remove(Character.valueOf(character));
        }
    }

    private static void printSolution(int testCase, char[] solution, int solvedCount) {
        if (solvedCount < 10) {
            throw new RuntimeException("Solution is incomplete");
        }

        StringBuilder sb = new StringBuilder("Case #" + (testCase + 1) + ": ");
        for (char c : solution) {
            sb.append(c);
        }
        System.out.println(sb);
    }

    static class Query {
        final String input;
        final String output;

        Query(String input, String output) {
            this.input = input;
            this.output = output;
        }
    }
}