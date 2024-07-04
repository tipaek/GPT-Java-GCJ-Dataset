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
                String[] split = sc.nextLine().split("\\s+");
                String queryResult = split[1];
                queries.add(new Query(split[0], split[1]));

                if (uniqueCharacters.size() < 10) {
                    for (char character : queryResult.toCharArray()) {
                        if (uniqueCharacters.add(character)) {
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

            for (Query query : queries) {
                if (query.input.length() == query.output.length()) {
                    char firstChar = query.output.charAt(0);
                    int val = Character.getNumericValue(query.input.charAt(0));

                    if (val == lowestUnsolvedNumber && possibleCharactersPerIndex[lowestUnsolvedNumber].contains(firstChar)) {
                        solveCharacter(solution, possibleCharactersPerIndex, firstChar, val, lowestUnsolvedNumber);
                        solvedCount++;
                        if (solvedCount == 10) break;
                        updateLowestUnsolvedNumber(solution, possibleCharactersPerIndex, lowestUnsolvedNumber);
                    } else if (possibleCharactersPerIndex[val].contains(firstChar)) {
                        removeCharacterFromHigherIndexes(possibleCharactersPerIndex, firstChar, val);
                        solvedCount = resolveSingleCharacters(solution, possibleCharactersPerIndex, solvedCount, lowestUnsolvedNumber);
                        if (solvedCount == 10) break;
                    }
                }
            }

            validateAndPrintSolution(testCase, solution);
        }
    }

    private static void solveCharacter(char[] solution, List<Character>[] possibleCharactersPerIndex, char character, int val, int lowestUnsolvedNumber) {
        solution[lowestUnsolvedNumber] = character;
        for (int i = 0; i < 10; i++) {
            if (solution[i] == '\u0000') {
                possibleCharactersPerIndex[i].remove(Character.valueOf(character));
            }
        }
    }

    private static void updateLowestUnsolvedNumber(char[] solution, List<Character>[] possibleCharactersPerIndex, int lowestUnsolvedNumber) {
        lowestUnsolvedNumber++;
        while (lowestUnsolvedNumber < 10 && solution[lowestUnsolvedNumber] != '\u0000') {
            lowestUnsolvedNumber++;
        }
    }

    private static void removeCharacterFromHigherIndexes(List<Character>[] possibleCharactersPerIndex, char character, int val) {
        for (int i = val + 1; i < 11; i++) {
            possibleCharactersPerIndex[i % 10].remove(Character.valueOf(character));
        }
    }

    private static int resolveSingleCharacters(char[] solution, List<Character>[] possibleCharactersPerIndex, int solvedCount, int lowestUnsolvedNumber) {
        boolean doLoop = true;
        while (doLoop) {
            doLoop = false;
            for (int i = 0; i < 10; i++) {
                if (solution[i] == '\u0000' && possibleCharactersPerIndex[i].size() == 1) {
                    solution[i] = possibleCharactersPerIndex[i].get(0);
                    solvedCount++;
                    if (solvedCount == 10) break;
                    for (int z = 0; z < 10; z++) {
                        if (solution[z] == '\u0000') {
                            possibleCharactersPerIndex[z].remove(Character.valueOf(solution[i]));
                        }
                    }
                    if (i == lowestUnsolvedNumber) {
                        updateLowestUnsolvedNumber(solution, possibleCharactersPerIndex, lowestUnsolvedNumber);
                    }
                    doLoop = true;
                }
            }
        }
        return solvedCount;
    }

    private static void validateAndPrintSolution(int testCase, char[] solution) {
        Set<Character> characterSet = new HashSet<>();
        StringBuilder sb = new StringBuilder("Case #" + (testCase + 1) + ": ");
        for (char c : solution) {
            if (c == '\u0000' || !characterSet.add(c)) {
                throw new RuntimeException();
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