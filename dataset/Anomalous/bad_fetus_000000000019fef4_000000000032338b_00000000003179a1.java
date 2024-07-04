import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = Integer.parseInt(sc.nextLine());

        for (int testCase = 0; testCase < testCount; testCase++) {
            Set<Character> uniqueCharacters = new HashSet<>();
            List<Character> characterList = new ArrayList<>();
            List<Query> queries = new ArrayList<>();

            for (int query = 0; query < 10_000; query++) {
                String[] split = sc.nextLine().split("\\s+");
                String queryResult = split[1];
                queries.add(new Query(split[0], queryResult));

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

            char[] solution = new char[10];
            int lowestUnsolvedIndex = 1;
            int solvedCount = 0;

            for (Query query : queries) {
                if (query.input.length() == query.output.length()) {
                    char outputChar = query.output.charAt(0);
                    int inputVal = Integer.parseInt(query.input.substring(0, 1));

                    if (inputVal == lowestUnsolvedIndex && possibleCharactersPerIndex[lowestUnsolvedIndex].contains(outputChar)) {
                        solution[lowestUnsolvedIndex] = outputChar;
                        solvedCount++;
                        if (solvedCount == 10) break;
                        lowestUnsolvedIndex = updateLowestUnsolvedIndex(solution, lowestUnsolvedIndex);

                        removeCharacterFromPossibleLists(possibleCharactersPerIndex, solution, outputChar);
                        solvedCount = updateSolutionWithSingleOptions(possibleCharactersPerIndex, solution, solvedCount);

                        if (solvedCount == 10) break;
                    } else if (possibleCharactersPerIndex[inputVal].contains(outputChar)) {
                        removeCharacterFromFutureIndices(possibleCharactersPerIndex, inputVal, outputChar);
                        solvedCount = updateSolutionWithSingleOptions(possibleCharactersPerIndex, solution, solvedCount);

                        if (solvedCount == 10) break;
                    }
                }
            }

            validateAndPrintSolution(testCase, solution);
        }
    }

    private static int updateLowestUnsolvedIndex(char[] solution, int lowestUnsolvedIndex) {
        while (lowestUnsolvedIndex < 10 && solution[lowestUnsolvedIndex] != '\u0000') {
            lowestUnsolvedIndex++;
        }
        return lowestUnsolvedIndex;
    }

    private static void removeCharacterFromPossibleLists(List<Character>[] possibleCharactersPerIndex, char[] solution, char outputChar) {
        for (int i = 0; i < 10; i++) {
            if (solution[i] == '\u0000') {
                possibleCharactersPerIndex[i].remove(Character.valueOf(outputChar));
            }
        }
    }

    private static void removeCharacterFromFutureIndices(List<Character>[] possibleCharactersPerIndex, int inputVal, char outputChar) {
        for (int i = inputVal + 1; i < 11; i++) {
            possibleCharactersPerIndex[i % 10].remove(Character.valueOf(outputChar));
        }
    }

    private static int updateSolutionWithSingleOptions(List<Character>[] possibleCharactersPerIndex, char[] solution, int solvedCount) {
        boolean doLoop;
        do {
            doLoop = false;
            for (int i = 0; i < 10; i++) {
                if (solution[i] == '\u0000' && possibleCharactersPerIndex[i].size() == 1) {
                    solution[i] = possibleCharactersPerIndex[i].get(0);
                    solvedCount++;
                    doLoop = true;
                    removeCharacterFromPossibleLists(possibleCharactersPerIndex, solution, solution[i]);
                }
            }
        } while (doLoop);
        return solvedCount;
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