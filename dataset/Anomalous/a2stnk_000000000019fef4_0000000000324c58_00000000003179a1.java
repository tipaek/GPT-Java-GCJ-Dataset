import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int i = 0; i < testCases; i++) {
                System.out.printf("Case #%d: ", i + 1);
                solve(scanner);
            }
        }
    }

    private static void solve(Scanner scanner) {
        int U = scanner.nextInt();
        final int N = 10000;
        char[][] responses = new char[N][];
        int[] frequency = new int[26];
        HashSet<Character> uniqueLetters = new HashSet<>();

        for (int i = 0; i < N; i++) {
            scanner.next(); // Read and ignore the query
            responses[i] = scanner.next().toCharArray();
            frequency[responses[i][0] - 'A']++;
            for (char c : responses[i]) {
                uniqueLetters.add(c);
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= 9; i++) {
            int maxIndex = 0;
            for (int j = 1; j < 26; j++) {
                if (frequency[j] > frequency[maxIndex]) {
                    maxIndex = j;
                }
            }
            answer.append((char) ('A' + maxIndex));
            frequency[maxIndex] = 0;
            uniqueLetters.remove((char) ('A' + maxIndex));
        }

        Iterator<Character> iterator = uniqueLetters.iterator();
        if (iterator.hasNext()) {
            char zeroChar = iterator.next();
            answer.insert(0, zeroChar);
        }

        System.out.println(answer.toString());
    }
}