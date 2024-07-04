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

            for (Query query : queries) {
                if (query.input.length() == query.output.length()) {
                    handleEqualLengthQuery(query, possibleCharactersPerIndex, solution, lowestUnsolvedNumber);
                } else {
                    handleDifferentLengthQuery(query, possibleCharactersPerIndex, solution);
                }

                solvedCount = updateSolution(possibleCharactersPerIndex, solution, solvedCount);
                if (solvedCount == 10) break;
            }

            printSolution(testCase, solution);
        }

        sc.close();
    }

    private static void handleEqualLengthQuery(Query query, List<Character>[] possibleCharactersPerIndex, char[] solution, int lowestUnsolvedNumber) {
        char c = query.output.charAt(0);
        int val = Integer.parseInt(query.input.substring(0, 1));

        if (val == lowestUnsolvedNumber && possibleCharactersPerIndex[lowestUnsolvedNumber].contains(c)) {
            solution[lowestUnsolvedNumber] = c;
            removeCharacterFromPossibleLists(possibleCharactersPerIndex, c);
            lowestUnsolvedNumber = updateLowestUnsolvedNumber(solution, lowestUnsolvedNumber);
        } else if (possibleCharactersPerIndex[val].contains(c) && val > lowestUnsolvedNumber) {
            for (int i = val + 1; i < 11; i++) {
                possibleCharactersPerIndex[i % 10].remove(Character.valueOf(c));
            }
        }
    }

    private static void handleDifferentLengthQuery(Query query, List<Character>[] possibleCharactersPerIndex, char[] solution) {
        char c = query.output.charAt(0);
        possibleCharactersPerIndex[0].remove(Character.valueOf(c));
        if (solution[0] == '\u0000' && possibleCharactersPerIndex[0].size() == 1) {
            solution[0] = possibleCharactersPerIndex[0].get(0);
        }
    }

    private static int updateSolution(List<Character>[] possibleCharactersPerIndex, char[] solution, int solvedCount) {
        boolean doLoop = true;
        while (doLoop) {
            doLoop = false;
            for (int i = 0; i < 10; i++) {
                if (solution[i] == '\u0000' && possibleCharactersPerIndex[i].size() == 1) {
                    doLoop = true;
                    solution[i] = possibleCharactersPerIndex[i].get(0);
                    char c = solution[i];
                    solvedCount++;
                    removeCharacterFromPossibleLists(possibleCharactersPerIndex, c);
                }
            }
        }
        return solvedCount;
    }

    private static void removeCharacterFromPossibleLists(List<Character>[] possibleCharactersPerIndex, char c) {
        for (List<Character> characters : possibleCharactersPerIndex) {
            characters.remove(Character.valueOf(c));
        }
    }

    private static int updateLowestUnsolvedNumber(char[] solution, int lowestUnsolvedNumber) {
        lowestUnsolvedNumber++;
        while (lowestUnsolvedNumber < 10 && solution[lowestUnsolvedNumber] != '\u0000') {
            lowestUnsolvedNumber++;
        }
        return lowestUnsolvedNumber;
    }

    private static void printSolution(int testCase, char[] solution) {
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