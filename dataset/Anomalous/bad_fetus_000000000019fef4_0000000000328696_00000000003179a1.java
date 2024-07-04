import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = Integer.parseInt(scanner.nextLine());

        for (int testCase = 0; testCase < testCount; testCase++) {
            int digitCount = Integer.parseInt(scanner.nextLine());
            Set<Character> uniqueCharacters = new HashSet<>();
            List<Character> characterList = new ArrayList<>();
            List<Query> queries = new ArrayList<>();
            int charCount = 0;

            for (int query = 0; query < 10_000; query++) {
                String[] input = scanner.nextLine().split("\\s+");
                String queryResult = input[1];

                if (input[0].length() == queryResult.length()) {
                    queries.add(new Query(input[0], queryResult));
                }

                if (charCount < 10) {
                    for (char character : queryResult.toCharArray()) {
                        if (uniqueCharacters.add(character)) {
                            charCount++;
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

            outerLoop:
            for (Query query : queries) {
                char firstChar = query.output.charAt(0);
                int firstDigit = Integer.parseInt(query.input.substring(0, 1));

                if (firstDigit == lowestUnsolvedNumber && possibleCharactersPerIndex[lowestUnsolvedNumber].contains(firstChar)) {
                    solution[lowestUnsolvedNumber] = firstChar;
                    solvedCount++;
                    if (solvedCount == 10) break outerLoop;

                    lowestUnsolvedNumber++;
                    while (lowestUnsolvedNumber < 10 && solution[lowestUnsolvedNumber] != '\u0000') {
                        lowestUnsolvedNumber++;
                    }

                    for (List<Character> possibleCharacters : possibleCharactersPerIndex) {
                        possibleCharacters.remove(Character.valueOf(firstChar));
                    }

                    boolean updated;
                    do {
                        updated = false;
                        for (int i = 0; i < 10; i++) {
                            if (solution[i] == '\u0000' && possibleCharactersPerIndex[i].size() == 1) {
                                solution[i] = possibleCharactersPerIndex[i].get(0);
                                firstChar = solution[i];
                                solvedCount++;
                                if (solvedCount == 10) break outerLoop;

                                for (List<Character> possibleCharacters : possibleCharactersPerIndex) {
                                    possibleCharacters.remove(Character.valueOf(firstChar));
                                }

                                if (i == lowestUnsolvedNumber) {
                                    lowestUnsolvedNumber++;
                                    while (lowestUnsolvedNumber < 10 && solution[lowestUnsolvedNumber] != '\u0000') {
                                        lowestUnsolvedNumber++;
                                    }
                                }
                                updated = true;
                            }
                        }
                    } while (updated);
                } else if (possibleCharactersPerIndex[firstDigit].contains(firstChar) && firstDigit > lowestUnsolvedNumber) {
                    for (int i = firstDigit + 1; i < 11; i++) {
                        possibleCharactersPerIndex[i % 10].remove(Character.valueOf(firstChar));
                    }

                    boolean updated;
                    do {
                        updated = false;
                        for (int i = 0; i < 10; i++) {
                            if (solution[i] == '\u0000' && possibleCharactersPerIndex[i].size() == 1) {
                                solution[i] = possibleCharactersPerIndex[i].get(0);
                                firstChar = solution[i];
                                solvedCount++;
                                if (solvedCount == 10) break outerLoop;

                                for (List<Character> possibleCharacters : possibleCharactersPerIndex) {
                                    possibleCharacters.remove(Character.valueOf(firstChar));
                                }

                                if (i == lowestUnsolvedNumber) {
                                    lowestUnsolvedNumber++;
                                    while (lowestUnsolvedNumber < 10 && solution[lowestUnsolvedNumber] != '\u0000') {
                                        lowestUnsolvedNumber++;
                                    }
                                }
                                updated = true;
                            }
                        }
                    } while (updated);
                }
            }

            StringBuilder result = new StringBuilder("Case #" + (testCase + 1) + ": ");
            for (char c : solution) {
                if (c == '\u0000') {
                    throw new RuntimeException("Incomplete solution");
                }
                result.append(c);
            }
            System.out.println(result);
        }

        scanner.close();
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