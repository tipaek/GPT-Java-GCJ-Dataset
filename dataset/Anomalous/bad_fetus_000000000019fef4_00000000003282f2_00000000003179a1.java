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
                String queryInput = split[0];
                String queryOutput = split[1];

                if (queryInput.length() == queryOutput.length()) {
                    queries.add(new Query(queryInput, queryOutput));
                }

                if (charCount < 10) {
                    for (char character : queryOutput.toCharArray()) {
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
                char firstChar = query.output.charAt(0);
                int firstDigit = Character.getNumericValue(query.input.charAt(0));

                if (firstDigit == lowestUnsolvedNumber && possibleCharactersPerIndex[lowestUnsolvedNumber].contains(firstChar)) {
                    solution[lowestUnsolvedNumber] = firstChar;
                    solvedCount++;
                    if (solvedCount == 10) break;

                    lowestUnsolvedNumber++;
                    while (lowestUnsolvedNumber < 10 && solution[lowestUnsolvedNumber] != '\u0000') {
                        lowestUnsolvedNumber++;
                    }

                    for (List<Character> possibleChars : possibleCharactersPerIndex) {
                        possibleChars.remove(Character.valueOf(firstChar));
                    }

                    updateSolution(possibleCharactersPerIndex, solution);
                    solvedCount = (int) Arrays.stream(solution).filter(c -> c != '\u0000').count();
                    if (solvedCount == 10) break;
                } else if (possibleCharactersPerIndex[firstDigit].contains(firstChar) && firstDigit > lowestUnsolvedNumber) {
                    for (int i = firstDigit + 1; i < 11; i++) {
                        possibleCharactersPerIndex[i % 10].remove(Character.valueOf(firstChar));
                    }

                    updateSolution(possibleCharactersPerIndex, solution);
                    solvedCount = (int) Arrays.stream(solution).filter(c -> c != '\u0000').count();
                    if (solvedCount == 10) break;
                }
            }

            StringBuilder result = new StringBuilder("Case #" + (testCase + 1) + ": ");
            for (char c : solution) {
                result.append(c);
            }
            System.out.println(result);
        }
        sc.close();
    }

    private static void updateSolution(List<Character>[] possibleCharactersPerIndex, char[] solution) {
        boolean updated;
        do {
            updated = false;
            for (int i = 0; i < 10; i++) {
                if (solution[i] == '\u0000' && possibleCharactersPerIndex[i].size() == 1) {
                    char determinedChar = possibleCharactersPerIndex[i].get(0);
                    solution[i] = determinedChar;
                    updated = true;
                    for (List<Character> possibleChars : possibleCharactersPerIndex) {
                        possibleChars.remove(Character.valueOf(determinedChar));
                    }
                }
            }
        } while (updated);
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