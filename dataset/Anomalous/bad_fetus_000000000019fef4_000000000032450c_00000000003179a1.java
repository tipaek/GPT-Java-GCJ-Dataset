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

                for (int i = 0; i < queryResult.length(); i++) {
                    char character = queryResult.charAt(i);
                    if (uniqueCharacters.add(character)) {
                        characterList.add(character);
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
                    char outputChar = query.output.charAt(0);
                    int inputVal = Integer.parseInt(query.input.substring(0, 1));

                    if (inputVal == lowestUnsolvedNumber && possibleCharactersPerIndex[lowestUnsolvedNumber].contains(outputChar)) {
                        solveCharacter(solution, possibleCharactersPerIndex, outputChar, inputVal);
                        solvedCount++;
                        lowestUnsolvedNumber = updateLowestUnsolvedNumber(solution, lowestUnsolvedNumber);
                        if (solvedCount == 10) break;
                    } else if (possibleCharactersPerIndex[inputVal].contains(outputChar)) {
                        for (int i = inputVal + 1; i < 11; i++) {
                            possibleCharactersPerIndex[i % 10].remove(Character.valueOf(outputChar));
                        }
                        solvedCount = propagateSolutions(solution, possibleCharactersPerIndex, solvedCount, lowestUnsolvedNumber);
                        lowestUnsolvedNumber = updateLowestUnsolvedNumber(solution, lowestUnsolvedNumber);
                        if (solvedCount == 10) break;
                    }
                }
            }

            printSolution(testCase, solution);
        }
    }

    private static void solveCharacter(char[] solution, List<Character>[] possibleCharactersPerIndex, char character, int index) {
        solution[index] = character;
        for (int i = 0; i < 10; i++) {
            if (solution[i] == '\u0000') {
                possibleCharactersPerIndex[i].remove(Character.valueOf(character));
            }
        }
    }

    private static int propagateSolutions(char[] solution, List<Character>[] possibleCharactersPerIndex, int solvedCount, int lowestUnsolvedNumber) {
        boolean doLoop = true;
        while (doLoop) {
            doLoop = false;
            for (int i = 0; i < 10; i++) {
                if (solution[i] == '\u0000' && possibleCharactersPerIndex[i].size() == 1) {
                    solution[i] = possibleCharactersPerIndex[i].get(0);
                    solvedCount++;
                    doLoop = true;
                    if (solvedCount == 10) return solvedCount;
                    for (int j = 0; j < 10; j++) {
                        if (solution[j] == '\u0000') {
                            possibleCharactersPerIndex[j].remove(Character.valueOf(solution[i]));
                        }
                    }
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