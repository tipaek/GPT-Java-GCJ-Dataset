import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = Integer.parseInt(sc.nextLine());
        
        for (int testCase = 0; testCase < testCount; testCase++) {
            int digitCount = Integer.parseInt(sc.nextLine());
            Set<Character> characters = new HashSet<>();
            List<Character> characterList = new ArrayList<>();
            List<Query> queries = new ArrayList<>();
            int charCount = 0;

            for (int query = 0; query < 10_000; query++) {
                String[] split = sc.nextLine().split("\\s+");
                String queryResult = split[1];
                queries.add(new Query(split[0], split[1]));
                
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

            char[] solution = new char[10];
            int solvedCount = 0;
            int lowestUnsolvedNumber = 1;

            outerLoop:
            for (Query query : queries) {
                if (query.input.length() == query.output.length()) {
                    char c = query.output.charAt(0);
                    int val = Integer.parseInt(query.input.substring(0, 1));

                    if (val == lowestUnsolvedNumber && possibleCharactersPerIndex[lowestUnsolvedNumber].contains(c)) {
                        solution[lowestUnsolvedNumber] = c;
                        solvedCount++;
                        if (solvedCount == 10) break outerLoop;

                        lowestUnsolvedNumber = updateLowestUnsolvedNumber(solution, lowestUnsolvedNumber);
                        removeCharacterFromPossibleLists(possibleCharactersPerIndex, c, solution);

                        solvedCount = solveSinglePossibilities(solution, possibleCharactersPerIndex, solvedCount);
                        if (solvedCount == 10) break outerLoop;
                    } else if (possibleCharactersPerIndex[val].contains(c)) {
                        for (int i = val + 1; i < 11; i++) {
                            possibleCharactersPerIndex[i % 10].remove(Character.valueOf(c));
                        }

                        solvedCount = solveSinglePossibilities(solution, possibleCharactersPerIndex, solvedCount);
                        if (solvedCount == 10) break outerLoop;
                    }
                }
            }

            validateAndPrintSolution(solution, testCase);
        }
    }

    private static int updateLowestUnsolvedNumber(char[] solution, int lowestUnsolvedNumber) {
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

    private static int solveSinglePossibilities(char[] solution, List<Character>[] possibleCharactersPerIndex, int solvedCount) {
        boolean doLoop;
        do {
            doLoop = false;
            for (int i = 0; i < 10; i++) {
                if (solution[i] == '\u0000' && possibleCharactersPerIndex[i].size() == 1) {
                    solution[i] = possibleCharactersPerIndex[i].get(0);
                    solvedCount++;
                    doLoop = true;

                    removeCharacterFromPossibleLists(possibleCharactersPerIndex, solution[i], solution);
                }
            }
        } while (doLoop);
        return solvedCount;
    }

    private static void validateAndPrintSolution(char[] solution, int testCase) {
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