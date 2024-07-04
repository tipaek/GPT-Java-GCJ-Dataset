import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = Integer.parseInt(sc.nextLine());

        for (int testCase = 0; testCase < testCount; testCase++) {
            Set<Character> characters = new HashSet<>();
            List<Character> characterList = new ArrayList<>();
            List<Query> queries = new ArrayList<>();
            
            int digitCount = Integer.parseInt(sc.nextLine());
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

            int lowestUnsolvedNumber = 1; // 0 considered 10 for this purpose
            char[] solution = new char[10];

            for (Query query : queries) {
                if (query.input.length() == query.output.length()) {
                    char c = query.output.charAt(0);
                    if (Integer.parseInt(query.input.substring(0, 1)) == lowestUnsolvedNumber &&
                        possibleCharactersPerIndex[lowestUnsolvedNumber].contains(c)) {
                        
                        solution[lowestUnsolvedNumber] = c;
                        lowestUnsolvedNumber++;
                        while (lowestUnsolvedNumber < 10 && solution[lowestUnsolvedNumber] != '\u0000') {
                            lowestUnsolvedNumber++;
                        }

                        for (List<Character> possibleCharacters : possibleCharactersPerIndex) {
                            possibleCharacters.remove(Character.valueOf(c));
                        }

                        boolean doLoop = true;
                        while (doLoop) {
                            doLoop = false;
                            for (int i = 0; i < 10; i++) {
                                if (solution[i] == '\u0000' && possibleCharactersPerIndex[i].size() == 1) {
                                    doLoop = true;
                                    solution[i] = possibleCharactersPerIndex[i].get(0);
                                    if (i == lowestUnsolvedNumber) {
                                        lowestUnsolvedNumber++;
                                        while (lowestUnsolvedNumber < 10 && solution[lowestUnsolvedNumber] != '\u0000') {
                                            lowestUnsolvedNumber++;
                                        }
                                        for (List<Character> possibleCharacters : possibleCharactersPerIndex) {
                                            possibleCharacters.remove(Character.valueOf(c));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            StringBuilder sb = new StringBuilder("Case #" + (testCase + 1) + ": ");
            for (char c : solution) {
                sb.append(c);
            }
            System.out.println(sb);
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