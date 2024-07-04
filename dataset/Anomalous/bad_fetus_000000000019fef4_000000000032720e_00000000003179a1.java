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

            List<Character>[] possibleCharactersPerIndex = new ArrayList[10];
            for (int i = 0; i < 10; i++) {
                possibleCharactersPerIndex[i] = new ArrayList<>(characterList);
            }

            int lowestUnsolvedNumber = 1;
            char[] solution = new char[10];
            int solvedCount = 0;

            for (Query query : queries) {
                if (query.input.length() == query.output.length()) {
                    char outputChar = query.output.charAt(0);
                    int inputVal = Integer.parseInt(query.input.substring(0, 1));

                    if (inputVal == lowestUnsolvedNumber && possibleCharactersPerIndex[lowestUnsolvedNumber].contains(outputChar)) {
                        solveCharacter(solution, possibleCharactersPerIndex, lowestUnsolvedNumber, outputChar);
                        solvedCount++;
                        if (solvedCount == 10) break;
                        lowestUnsolvedNumber = updateLowestUnsolvedNumber(solution, lowestUnsolvedNumber);
                    } else if (possibleCharactersPerIndex[inputVal].contains(outputChar)) {
                        eliminateCharacterFromFutureIndices(possibleCharactersPerIndex, inputVal, outputChar);
                        solvePendingCharacters(solution, possibleCharactersPerIndex);
                        solvedCount = countSolvedCharacters(solution);
                        if (solvedCount == 10) break;
                        lowestUnsolvedNumber = updateLowestUnsolvedNumber(solution, lowestUnsolvedNumber);
                    }
                }
            }

            printSolution(testCase, solution);
        }
    }

    private static void solveCharacter(char[] solution, List<Character>[] possibleCharactersPerIndex, int index, char character) {
        solution[index] = character;
        for (List<Character> possibleCharacters : possibleCharactersPerIndex) {
            possibleCharacters.remove(Character.valueOf(character));
        }
    }

    private static int updateLowestUnsolvedNumber(char[] solution, int currentLowest) {
        while (currentLowest < 10 && solution[currentLowest] != '\u0000') {
            currentLowest++;
        }
        return currentLowest;
    }

    private static void eliminateCharacterFromFutureIndices(List<Character>[] possibleCharactersPerIndex, int startIndex, char character) {
        for (int i = startIndex + 1; i < startIndex + 11; i++) {
            possibleCharactersPerIndex[i % 10].remove(Character.valueOf(character));
        }
    }

    private static void solvePendingCharacters(char[] solution, List<Character>[] possibleCharactersPerIndex) {
        boolean doLoop;
        do {
            doLoop = false;
            for (int i = 0; i < 10; i++) {
                if (solution[i] == '\u0000' && possibleCharactersPerIndex[i].size() == 1) {
                    doLoop = true;
                    solveCharacter(solution, possibleCharactersPerIndex, i, possibleCharactersPerIndex[i].get(0));
                }
            }
        } while (doLoop);
    }

    private static int countSolvedCharacters(char[] solution) {
        int count = 0;
        for (char c : solution) {
            if (c != '\u0000') {
                count++;
            }
        }
        return count;
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