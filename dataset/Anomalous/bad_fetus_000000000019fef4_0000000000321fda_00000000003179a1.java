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

            int charCount = 0;
            for (int query = 0; query < 10_000; query++) {
                String[] parts = sc.nextLine().split("\\s+");
                String queryResult = parts[1];
                queries.add(new Query(parts[0], parts[1]));

                if (charCount < 10) {
                    for (char ch : queryResult.toCharArray()) {
                        if (uniqueCharacters.add(ch)) {
                            charCount++;
                            characterList.add(ch);
                        }
                    }
                }
            }

            List<Character>[] possibleChars = new List[10];
            for (int i = 0; i < 10; i++) {
                possibleChars[i] = new ArrayList<>(characterList);
            }

            int lowestUnsolved = 1;
            char[] solution = new char[10];
            int solvedCount = 0;

            outerLoop:
            for (Query query : queries) {
                if (query.input.length() == query.output.length()) {
                    char firstChar = query.output.charAt(0);
                    int firstDigit = Character.getNumericValue(query.input.charAt(0));

                    if (firstDigit == lowestUnsolved && possibleChars[lowestUnsolved].contains(firstChar)) {
                        solution[lowestUnsolved] = firstChar;
                        solvedCount++;
                        if (solvedCount == 10) break outerLoop;

                        lowestUnsolved = updateLowestUnsolved(solution, lowestUnsolved);
                        removeCharacterFromPossibilities(possibleChars, solution, firstChar);

                        solvedCount = propagateSolutions(possibleChars, solution, solvedCount);
                        if (solvedCount == 10) break outerLoop;
                    } else if (possibleChars[firstDigit].contains(firstChar)) {
                        removeCharacterFromFuturePossibilities(possibleChars, firstChar, firstDigit);

                        solvedCount = propagateSolutions(possibleChars, solution, solvedCount);
                        if (solvedCount == 10) break outerLoop;
                    }
                }
            }

            printSolution(testCase, solution);
        }
    }

    private static int updateLowestUnsolved(char[] solution, int lowestUnsolved) {
        lowestUnsolved++;
        while (lowestUnsolved < 10 && solution[lowestUnsolved] != '\u0000') {
            lowestUnsolved++;
        }
        return lowestUnsolved;
    }

    private static void removeCharacterFromPossibilities(List<Character>[] possibleChars, char[] solution, char character) {
        for (int i = 0; i < 10; i++) {
            if (solution[i] == '\u0000') {
                possibleChars[i].remove(Character.valueOf(character));
            }
        }
    }

    private static void removeCharacterFromFuturePossibilities(List<Character>[] possibleChars, char character, int startIndex) {
        for (int i = startIndex + 1; i < startIndex + 11; i++) {
            possibleChars[i % 10].remove(Character.valueOf(character));
        }
    }

    private static int propagateSolutions(List<Character>[] possibleChars, char[] solution, int solvedCount) {
        boolean continueLoop;
        do {
            continueLoop = false;
            for (int i = 0; i < 10; i++) {
                if (solution[i] == '\u0000' && possibleChars[i].size() == 1) {
                    solution[i] = possibleChars[i].get(0);
                    solvedCount++;
                    continueLoop = true;

                    if (solvedCount == 10) return solvedCount;
                    removeCharacterFromPossibilities(possibleChars, solution, solution[i]);
                }
            }
        } while (continueLoop);
        return solvedCount;
    }

    private static void printSolution(int testCase, char[] solution) {
        StringBuilder result = new StringBuilder("Case #" + (testCase + 1) + ": ");
        for (char c : solution) {
            if (c == '\u0000') throw new RuntimeException("Incomplete solution");
            result.append(c);
        }
        System.out.println(result);
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