import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = Integer.parseInt(sc.nextLine());

        for (int testCase = 1; testCase <= testCount; testCase++) {
            Set<Character> uniqueCharacters = new HashSet<>();
            List<Character> characterList = new ArrayList<>();
            List<Query> queries = new ArrayList<>();
            int digitCount = Integer.parseInt(sc.nextLine());
            int charCount = 0;

            for (int i = 0; i < 10_000; i++) {
                String[] split = sc.nextLine().split("\\s+");
                String queryResult = split[1];

                if (split[0].length() == split[1].length()) {
                    queries.add(new Query(split[0], split[1]));
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

            List<Character>[] possibleCharactersPerIndex = new List[10];
            for (int i = 0; i < 10; i++) {
                possibleCharactersPerIndex[i] = new ArrayList<>(characterList);
            }

            char[] solution = new char[10];
            int solvedCount = 0;
            int lowestUnsolvedNumber = 1;

            outerLoop:
            for (Query query : queries) {
                char firstOutputChar = query.output.charAt(0);
                int firstInputDigit = Integer.parseInt(query.input.substring(0, 1));

                if (firstInputDigit == lowestUnsolvedNumber && possibleCharactersPerIndex[lowestUnsolvedNumber].contains(firstOutputChar)) {
                    solution[lowestUnsolvedNumber] = firstOutputChar;
                    solvedCount++;
                    if (solvedCount == 10) break outerLoop;

                    lowestUnsolvedNumber++;
                    while (lowestUnsolvedNumber < 10 && solution[lowestUnsolvedNumber] != '\u0000') {
                        lowestUnsolvedNumber++;
                    }

                    for (int i = 0; i < 10; i++) {
                        if (solution[i] == '\u0000') {
                            possibleCharactersPerIndex[i].remove(Character.valueOf(firstOutputChar));
                        }
                    }

                    boolean doLoop;
                    do {
                        doLoop = false;
                        for (int i = 0; i < 10; i++) {
                            if (solution[i] == '\u0000' && possibleCharactersPerIndex[i].size() == 1) {
                                doLoop = true;
                                solution[i] = possibleCharactersPerIndex[i].get(0);
                                solvedCount++;
                                if (solvedCount == 10) break outerLoop;

                                for (int z = 0; z < 10; z++) {
                                    if (solution[z] == '\u0000') {
                                        possibleCharactersPerIndex[z].remove(Character.valueOf(solution[i]));
                                    }
                                }

                                if (i == lowestUnsolvedNumber) {
                                    lowestUnsolvedNumber++;
                                    while (lowestUnsolvedNumber < 10 && solution[lowestUnsolvedNumber] != '\u0000') {
                                        lowestUnsolvedNumber++;
                                    }
                                }
                            }
                        }
                    } while (doLoop);
                } else if (possibleCharactersPerIndex[firstInputDigit].contains(firstOutputChar)) {
                    for (int i = firstInputDigit + 1; i < 11; i++) {
                        possibleCharactersPerIndex[i % 10].remove(Character.valueOf(firstOutputChar));
                    }

                    boolean doLoop;
                    do {
                        doLoop = false;
                        for (int i = 0; i < 10; i++) {
                            if (solution[i] == '\u0000' && possibleCharactersPerIndex[i].size() == 1) {
                                doLoop = true;
                                solution[i] = possibleCharactersPerIndex[i].get(0);
                                solvedCount++;
                                if (solvedCount == 10) break outerLoop;

                                for (int z = 0; z < 10; z++) {
                                    if (solution[z] == '\u0000') {
                                        possibleCharactersPerIndex[z].remove(Character.valueOf(solution[i]));
                                    }
                                }

                                if (i == lowestUnsolvedNumber) {
                                    lowestUnsolvedNumber++;
                                    while (lowestUnsolvedNumber < 10 && solution[lowestUnsolvedNumber] != '\u0000') {
                                        lowestUnsolvedNumber++;
                                    }
                                }
                            }
                        }
                    } while (doLoop);
                }
            }

            StringBuilder result = new StringBuilder("Case #" + testCase + ": ");
            Set<Character> resultSet = new HashSet<>();
            for (char c : solution) {
                if (c == '\u0000' || !resultSet.add(c)) {
                    throw new RuntimeException("Invalid solution");
                }
                result.append(c);
            }
            System.out.println(result);
        }
        sc.close();
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