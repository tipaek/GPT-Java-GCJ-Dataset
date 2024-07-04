import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = Integer.parseInt(sc.nextLine());

        for (int testCase = 0; testCase < testCount; testCase++) {
            Set<Character> characters = new HashSet<>();
            List<Character> characterList = new ArrayList<>();
            List<Query> queries = new ArrayList<>();
            int digitCount = Integer.parseInt(sc.nextLine());
            int charCount = 0;

            for (int query = 0; query < 10_000; query++) {
                String[] split = sc.nextLine().split("\\s+");
                String queryResult = split[1];

                if (split[0].length() == split[1].length()) {
                    queries.add(new Query(split[0], split[1]));
                }

                if (charCount < 10) {
                    for (char character : queryResult.toCharArray()) {
                        if (characters.add(character)) {
                            charCount++;
                            characterList.add(character);
                        }
                    }
                }
            }

            List<Character>[] possibleCharactersPerIndex = new List[10];
            for (int i = 0; i < 10; i++) {
                possibleCharactersPerIndex[i] = new ArrayList<>(characterList);
            }

            int lowestUnsolvedNumber = 1;
            char[] solution = new char[10];
            int solvedCount = 0;

            queryLoop:
            for (Query query : queries) {
                char c = query.output.charAt(0);
                int val = Integer.parseInt(query.input.substring(0, 1));

                if (val == lowestUnsolvedNumber && possibleCharactersPerIndex[lowestUnsolvedNumber].contains(c)) {
                    solution[lowestUnsolvedNumber] = c;
                    solvedCount++;

                    if (solvedCount == 10) break queryLoop;

                    lowestUnsolvedNumber = updateLowestUnsolvedNumber(solution, lowestUnsolvedNumber);

                    removeCharacterFromPossibleLists(possibleCharactersPerIndex, c, solution);

                    solveSingleCharacterEntries(possibleCharactersPerIndex, solution);
                    solvedCount = updateSolvedCount(solution);
                } else if (possibleCharactersPerIndex[val].contains(c) && val > lowestUnsolvedNumber) {
                    removeCharacterFromFutureLists(possibleCharactersPerIndex, c, val);

                    solveSingleCharacterEntries(possibleCharactersPerIndex, solution);
                    solvedCount = updateSolvedCount(solution);
                }
            }

            validateAndPrintSolution(testCase, solution);
        }
        sc.close();
    }

    private static int updateLowestUnsolvedNumber(char[] solution, int lowestUnsolvedNumber) {
        lowestUnsolvedNumber++;
        while (lowestUnsolvedNumber < 10 && solution[lowestUnsolvedNumber] != '\u0000') {
            lowestUnsolvedNumber++;
        }
        return lowestUnsolvedNumber;
    }

    private static void removeCharacterFromPossibleLists(List<Character>[] possibleCharactersPerIndex, char c, char[] solution) {
        for (int i = 0; i < 10; i++) {
            if (solution[i] == '\u0000') {
                possibleCharactersPerIndex[i].remove(Character.valueOf(c));
            }
        }
    }

    private static void solveSingleCharacterEntries(List<Character>[] possibleCharactersPerIndex, char[] solution) {
        boolean doLoop = true;
        while (doLoop) {
            doLoop = false;
            for (int i = 0; i < 10; i++) {
                if (solution[i] == '\u0000' && possibleCharactersPerIndex[i].size() == 1) {
                    doLoop = true;
                    char c = possibleCharactersPerIndex[i].get(0);
                    solution[i] = c;
                    removeCharacterFromPossibleLists(possibleCharactersPerIndex, c, solution);
                }
            }
        }
    }

    private static int updateSolvedCount(char[] solution) {
        int solvedCount = 0;
        for (char c : solution) {
            if (c != '\u0000') {
                solvedCount++;
            }
        }
        return solvedCount;
    }

    private static void removeCharacterFromFutureLists(List<Character>[] possibleCharactersPerIndex, char c, int val) {
        for (int i = val + 1; i < 11; i++) {
            possibleCharactersPerIndex[i % 10].remove(Character.valueOf(c));
        }
    }

    private static void validateAndPrintSolution(int testCase, char[] solution) {
        Set<Character> characterSet = new HashSet<>();
        StringBuilder sb = new StringBuilder("Case #" + (testCase + 1) + ": ");
        for (char c : solution) {
            if (c == '\u0000' || !characterSet.add(c)) {
                throw new RuntimeException("Invalid solution");
            }
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