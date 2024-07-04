import java.util.*;

public class Solution {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfCases = scanner.nextInt();
        for(int i = 1; i <= numberOfCases; i++){
            processCase(i);
        }
    }

    private static void processCase(int caseNumber){
        System.out.printf("Case #%d: ", caseNumber);
        long u = scanner.nextLong();
        final long numQueries = (long)1e4;
        HashSet<Character>[] possibleDigits = new HashSet[10];
        HashSet<Character> allLetters = new HashSet<>();

        initializePossibleDigits(possibleDigits);

        for(long i = 0; i < numQueries; i++){
            long m = scanner.nextLong();
            String response = scanner.next();
            updatePossibleDigits(m, response, possibleDigits, allLetters);
        }

        char[] resultDigits = determineDigits(possibleDigits, allLetters);
        System.out.println(new String(resultDigits));
    }

    private static void initializePossibleDigits(HashSet<Character>[] possibleDigits) {
        for(int i = 0; i < 10; i++){
            possibleDigits[i] = new HashSet<>();
            for(char c = 'A'; c <= 'Z'; c++){
                possibleDigits[i].add(c);
            }
        }
    }

    private static void updatePossibleDigits(long m, String response, HashSet<Character>[] possibleDigits, HashSet<Character> allLetters){
        for(char c : response.toCharArray()){
            allLetters.add(c);
        }

        long magnitude = 0, temp = m;
        int lastDigit = 0;
        while(temp > 0){
            magnitude++;
            lastDigit = (int)(temp % 10);
            temp /= 10;
        }

        char firstChar = response.charAt(0);
        if(response.length() < magnitude){
            return;
        }

        for(int i = lastDigit + 1; i < 10; i++){
            possibleDigits[i].remove(firstChar);
        }

        if(magnitude > 0){
            possibleDigits[0].remove(firstChar);
        }
    }

    private static char[] determineDigits(HashSet<Character>[] possibleDigits, HashSet<Character> allLetters) {
        char[] resultDigits = new char[10];
        Arrays.fill(resultDigits, 'a');

        for(int h = 0; h < 10; h++){
            for(int i = 0; i < 10; i++){
                possibleDigits[i].removeIf(c -> !allLetters.contains(c));
                if(possibleDigits[i].size() == 1){
                    char determinedChar = possibleDigits[i].iterator().next();
                    resultDigits[i] = determinedChar;
                    for(int j = 0; j < 10; j++){
                        possibleDigits[j].remove(determinedChar);
                    }
                }
            }
        }

        return resultDigits;
    }
}