import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Set<Character> characters = new HashSet<>();
        List<Character> characterList = new ArrayList<>();
        List<Query> queries = new ArrayList<>();
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = Integer.parseInt(sc.nextLine());
        for (int testCase = 0; testCase < testCount; testCase++) {
            int digitCount = Integer.parseInt(sc.nextLine());
            int charCount = 0;
            for (int query = 0; query < 10_000; query++) {
                String[] split = sc.nextLine().split("\\s+");
                String queryResult = split[1];
                queries.add(new Query(split[0], split[1]));
                if (charCount < 10) {
                    for (int i = 0; i < queryResult.length(); i++) {
                        char character = queryResult.charAt(i);
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
            int lowestUnsolvedNumber = 1; //0 considered 10 for this purpose

            char[] solution = new char[10];

            int solvedCount = 0;

            queryLoop:
            for (Query query : queries) {
                if (query.input.length() == query.output.length()) { //Not deterministic otherwise
                    char c = query.output.charAt(0);
                    int val = Integer.parseInt(query.input.substring(0, 1));
                    if (val == lowestUnsolvedNumber && possibleCharactersPerIndex[lowestUnsolvedNumber].contains(c)) {
                        solution[lowestUnsolvedNumber] = c;
                        solvedCount++;
                        if(solvedCount == 10){
                            break queryLoop;
                        }
                        lowestUnsolvedNumber++;
                        while (lowestUnsolvedNumber < 10 && solution[lowestUnsolvedNumber] != '\u0000') {
                            lowestUnsolvedNumber++;
                        }
                        for (int i = 0; i < 10; i++) {
                            if (solution[i] == '\u0000') {
                                possibleCharactersPerIndex[i].remove(new Character(c));
                            }
                        }

                        boolean doLoop = true;
                        while (doLoop) {
                            doLoop = false;
                            for (int i = 0; i < 10; i++) {
                                if (solution[i] == '\u0000' && possibleCharactersPerIndex[i].size() == 1) {
                                    doLoop = true;
                                    solution[i] = possibleCharactersPerIndex[i].get(0);
                                    solvedCount++;
                                    if(solvedCount == 10){
                                        break queryLoop;
                                    }
                                    for (int z = 0; z < 10; z++) {
                                        if (solution[i] == '\u0000') {
                                            possibleCharactersPerIndex[i].remove(new Character(c));
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
                        }
                    }else if (possibleCharactersPerIndex[val].contains(c)){
                        for(int i = val+1; i<11; i++){
                            possibleCharactersPerIndex[i%10].remove(new Character(c));
                        }
                        boolean doLoop = true;
                        while (doLoop) {
                            doLoop = false;
                            for (int i = 0; i < 10; i++) {
                                if (solution[i] == '\u0000' && possibleCharactersPerIndex[i].size() == 1) {
                                    doLoop = true;
                                    solution[i] = possibleCharactersPerIndex[i].get(0);
                                    solvedCount++;
                                    if(solvedCount == 10){
                                        break queryLoop;
                                    }
                                    if (i == lowestUnsolvedNumber) {
                                        lowestUnsolvedNumber++;
                                        while (lowestUnsolvedNumber < 10 && solution[lowestUnsolvedNumber] != '\u0000') {
                                            lowestUnsolvedNumber++;
                                        }
                                        for (int j = 0; j < 10; j++) {
                                            if (solution[j] == '\u0000') {
                                                possibleCharactersPerIndex[j].remove(c);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            Set<Character> characterSet = new HashSet<>();
            StringBuilder sb = new StringBuilder("Case #" + (testCase + 1) + ": ");
            for(char c: solution){
                if(c == '\u0000'){
                    throw new RuntimeException();
                }
                if(!characterSet.add(c)){
                    throw new RuntimeException();
                }
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


