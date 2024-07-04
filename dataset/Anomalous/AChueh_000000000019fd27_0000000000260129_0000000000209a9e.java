import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        int n = scanner.nextInt();

        for (int i = 1; i <= t; ++i) {
            String result = handleInput(scanner, n);
            System.out.println(result);
            System.out.flush();
            if (scanner.next().equals("N")) {
                System.exit(0);
            }
        }
    }

    private static String handleInput(Scanner scanner, int n) {
        char[] answer = new char[n];
        Arrays.fill(answer, 'N');

        for (int i = 1; i <= 5; ++i) {
            System.out.println(i);
            System.out.flush();
            answer[i - 1] = scanner.next().charAt(0);
        }

        for (int i = 1; i <= 5; ++i) {
            System.out.println(n - i + 1);
            System.out.flush();
            answer[n - i] = scanner.next().charAt(0);
        }

        char[][] candidates = generateCandidates(answer, 5);
        int[] positions = determinePositions(candidates[0], 5, n);

        int processedLength = 5;
        for (int i = 0; i < 14; ++i) {
            if (answer[processedLength] != 'N') {
                break;
            }

            char[] trialResults = new char[3];
            for (int j = 0; j < 3; ++j) {
                System.out.println(positions[j] + 1);
                System.out.flush();
                trialResults[j] = scanner.next().charAt(0);
            }

            int matchedIndex = 0;
            for (int j = 0; j < 4; ++j) {
                if (trialResults[0] == candidates[j][positions[0]] &&
                    trialResults[1] == candidates[j][positions[1]] &&
                    trialResults[2] == candidates[j][positions[2]]) {
                    matchedIndex = j;
                    break;
                }
            }

            answer = candidates[matchedIndex];
            for (int j = 1; j <= 7 && processedLength + j < n; ++j) {
                System.out.println(processedLength + j);
                System.out.flush();
                answer[processedLength + j - 1] = scanner.next().charAt(0);
            }
            processedLength += 7;
            if (processedLength >= n) {
                break;
            }
        }
        return new String(answer);
    }

    private static char[][] generateCandidates(char[] currentAnswer, int length) {
        int B = currentAnswer.length;
        char[][] candidates = new char[4][B];
        candidates[0] = Arrays.copyOf(currentAnswer, B);
        candidates[1] = new char[B];
        candidates[2] = new char[B];
        candidates[3] = new char[B];

        for (int i = 0; i < length; ++i) {
            candidates[1][i] = flip(currentAnswer[i]);
            candidates[2][B - 1 - i] = currentAnswer[i];
            candidates[3][B - 1 - i] = flip(currentAnswer[i]);

            candidates[1][B - 1 - i] = flip(currentAnswer[B - 1 - i]);
            candidates[2][i] = currentAnswer[B - 1 - i];
            candidates[3][i] = flip(currentAnswer[B - 1 - i]);
        }

        if (currentAnswer[length] != 'N') {
            candidates[1][length] = flip(currentAnswer[length]);
            candidates[2][B - 1 - length] = currentAnswer[length];
            candidates[3][B - 1 - length] = flip(currentAnswer[length]);
        }

        if (currentAnswer[B - 1 - length] != 'N') {
            candidates[1][B - 1 - length] = flip(currentAnswer[B - 1 - length]);
            candidates[2][length] = currentAnswer[B - 1 - length];
            candidates[3][length] = flip(currentAnswer[B - 1 - length]);
        }

        return candidates;
    }

    private static char flip(char bit) {
        return bit == '0' ? '1' : '0';
    }

    private static int[] determinePositions(char[] candidate, int length, int n) {
        int[] positions = new int[3];
        Arrays.fill(positions, -1);

        for (int i = 0; i < length - 2; ++i) {
            for (int j = 0; j < length - 1; ++j) {
                for (int k = 0; k < length; ++k) {
                    if (!isComplement(candidate[i], candidate[j], candidate[k], candidate[n - i - 1], candidate[n - j - 1], candidate[n - k - 1])) {
                        return new int[]{i, j, k};
                    }
                }
            }
        }
        return positions;
    }

    private static boolean isComplement(char l1, char l2, char l3, char r1, char r2, char r3) {
        if (l1 != '0') {
            l2 = flip(l2);
            l3 = flip(l3);
        }

        if (r1 != '0') {
            r2 = flip(r2);
            r3 = flip(r3);
        }

        return r2 == l2 && r3 == l3;
    }
}