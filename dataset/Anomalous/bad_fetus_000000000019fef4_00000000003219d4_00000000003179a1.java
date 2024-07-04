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
                String[] parts = sc.nextLine().split("\\s+");
                String queryResult = parts[1];
                queries.add(new Query(parts[0], parts[1]));

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
                    char c = query.output.charAt(0);
                    int val = Integer.parseInt(query.input.substring(0, 1));

                    if (val == lowestUnsolvedNumber && possibleCharactersPerIndex[lowestUnsolvedNumber].contains(c)) {
                        solution[lowestUnsolvedNumber] = c;
                        solvedCount++;
                        if (solvedCount == 10) break;

                        lowestUnsolvedNumber++;
                        while (lowestUnsolvedNumber < 10 && solution[lowestUnsolvedNumber] != '\u0000') {
                            lowestUnsolvedNumber++;
                        }

                        removeCharacterFromUnsolved(solution, possibleCharactersPerIndex, c);

                        updateSolution(solution, possibleCharactersPerIndex);
                        if (solvedCount == 10) break;

                    } else if (possibleCharactersPerIndex[val].contains(c)) {
                        for (int i = val + 1; i < 11; i++) {
                            possibleCharactersPerIndex[i % 10].remove(Character.valueOf(c));
                        }

                        updateSolution(solution, possibleCharactersPerIndex);
                        if (solvedCount == 10) break;
                    }
                }
            }

            StringBuilder result = new StringBuilder("Case #" + (testCase + 1) + ": ");
            for (char c : solution) {
                result.append(c);
            }
            System.out.println(result);
        }
    }

    private static void removeCharacterFromUnsolved(char[] solution, List<Character>[] possibleCharactersPerIndex, char c) {
        for (int i = 0; i < 10; i++) {
            if (solution[i] == '\u0000') {
                possibleCharactersPerIndex[i].remove(Character.valueOf(c));
            }
        }
    }

    private static void updateSolution(char[] solution, List<Character>[] possibleCharactersPerIndex) {
        boolean doLoop = true;
        while (doLoop) {
            doLoop = false;
            for (int i = 0; i < 10; i++) {
                if (solution[i] == '\u0000' && possibleCharactersPerIndex[i].size() == 1) {
                    solution[i] = possibleCharactersPerIndex[i].get(0);
                    doLoop = true;
                }
            }
        }
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