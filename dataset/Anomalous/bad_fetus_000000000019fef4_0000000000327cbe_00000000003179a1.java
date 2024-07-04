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

            for (int query = 0; query < 10_000; query++) {
                String[] split = sc.nextLine().split("\\s+");
                String queryResult = split[1];

                if (split[0].length() == queryResult.length()) {
                    queries.add(new Query(split[0], queryResult));
                }

                if (characters.size() < 10) {
                    for (char c : queryResult.toCharArray()) {
                        if (characters.add(c)) {
                            characterList.add(c);
                        }
                    }
                }
            }

            List<Character>[] possibleCharactersPerIndex = new ArrayList[10];
            for (int i = 0; i < 10; i++) {
                possibleCharactersPerIndex[i] = new ArrayList<>(characterList);
            }

            char[] solution = new char[10];
            int solvedCount = 0;
            int lowestUnsolvedNumber = 1;

            for (Query query : queries) {
                char c = query.output.charAt(0);
                int val = Integer.parseInt(query.input.substring(0, 1));

                if (val == lowestUnsolvedNumber && possibleCharactersPerIndex[lowestUnsolvedNumber].contains(c)) {
                    solveCharacter(possibleCharactersPerIndex, solution, c, lowestUnsolvedNumber);
                    solvedCount++;
                    lowestUnsolvedNumber = updateLowestUnsolvedNumber(solution, lowestUnsolvedNumber);
                    if (solvedCount == 10) break;
                } else if (possibleCharactersPerIndex[val].contains(c)) {
                    for (int i = val + 1; i < 11; i++) {
                        possibleCharactersPerIndex[i % 10].remove(Character.valueOf(c));
                    }
                    solvedCount = solveSingleCharacters(possibleCharactersPerIndex, solution, solvedCount);
                    lowestUnsolvedNumber = updateLowestUnsolvedNumber(solution, lowestUnsolvedNumber);
                    if (solvedCount == 10) break;
                }
            }

            validateSolution(solution);
            printSolution(testCase, solution);
        }
    }

    private static void solveCharacter(List<Character>[] possibleCharactersPerIndex, char[] solution, char c, int index) {
        solution[index] = c;
        for (List<Character> characters : possibleCharactersPerIndex) {
            characters.remove(Character.valueOf(c));
        }
    }

    private static int solveSingleCharacters(List<Character>[] possibleCharactersPerIndex, char[] solution, int solvedCount) {
        boolean doLoop = true;
        while (doLoop) {
            doLoop = false;
            for (int i = 0; i < 10; i++) {
                if (solution[i] == '\u0000' && possibleCharactersPerIndex[i].size() == 1) {
                    char c = possibleCharactersPerIndex[i].get(0);
                    solveCharacter(possibleCharactersPerIndex, solution, c, i);
                    solvedCount++;
                    doLoop = true;
                }
            }
        }
        return solvedCount;
    }

    private static int updateLowestUnsolvedNumber(char[] solution, int currentLowest) {
        while (currentLowest < 10 && solution[currentLowest] != '\u0000') {
            currentLowest++;
        }
        return currentLowest;
    }

    private static void validateSolution(char[] solution) {
        Set<Character> characterSet = new HashSet<>();
        for (char c : solution) {
            if (c == '\u0000' || !characterSet.add(c)) {
                throw new RuntimeException("Invalid solution");
            }
        }
    }

    private static void printSolution(int testCase, char[] solution) {
        StringBuilder sb = new StringBuilder("Case #").append(testCase + 1).append(": ");
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