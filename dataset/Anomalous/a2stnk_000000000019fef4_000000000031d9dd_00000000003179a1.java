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
        char[][] queries = new char[N][];
        char[][] responses = new char[N][];

        int[][] frequency = new int[10][26];
        HashSet<Character> uniqueLetters = new HashSet<>();

        for (int i = 0; i < N; i++) {
            queries[i] = scanner.next().toCharArray();
            responses[i] = scanner.next().toCharArray();
            if (queries[i].length == responses[i].length) {
                frequency[queries[i][0] - '0'][responses[i][0] - 'A']++;
            }
            for (char c : responses[i]) {
                uniqueLetters.add(c);
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j < 26; j++) {
                if (frequency[i][j] > 0) {
                    answer.append((char) ('A' + j));
                    for (int k = i + 1; k <= 9; k++) {
                        frequency[k][j] = 0;
                    }
                    uniqueLetters.remove((char) ('A' + j));
                    break;
                }
            }
        }

        Iterator<Character> iterator = uniqueLetters.iterator();
        if (iterator.hasNext()) {
            char zeroChar = iterator.next();
            answer.insert(0, zeroChar);
        }

        System.out.println(answer.toString());
    }
}