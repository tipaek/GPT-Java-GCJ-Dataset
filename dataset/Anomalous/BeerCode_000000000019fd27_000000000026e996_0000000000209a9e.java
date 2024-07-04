import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int B = scanner.nextInt();
        scanner.nextLine();

        for (int t = 1; t <= T; t++) {
            char[] data = new char[B];
            char[] state = new char[B];
            int left = 1;
            int right = B;

            while (left < right) {
                System.out.println(left);
                System.out.flush();
                char a = scanner.nextLine().charAt(0);

                System.out.println(right);
                System.out.flush();
                char b = scanner.nextLine().charAt(0);

                if (a == b) {
                    data[left - 1] = 'S';
                    data[right - 1] = 'S';
                } else {
                    data[left - 1] = 'D';
                    data[right - 1] = 'D';
                }

                state[left - 1] = a;
                state[right - 1] = b;
                left++;
                right--;
            }

            String result = determineResult(B, state, scanner);
            System.out.println(result);
            System.out.flush();
            String check = scanner.nextLine();
        }
        scanner.close();
        System.exit(0);
    }

    private static String determineResult(int B, char[] state, Scanner scanner) {
        if (B <= 10) {
            return new String(state);
        }

        String[] candidates = generateCandidates(state);
        for (int i = 0; i < B / 20; i++) {
            int[] scores = new int[4];
            for (int j = 0; j < 10; j++) {
                int k = (i * 10 + j) % B + 1;
                System.out.println(k);
                System.out.flush();
                char response = scanner.nextLine().charAt(0);
                updateScores(candidates, scores, k, response);
            }

            String result = findUniqueCandidate(scores, candidates);
            if (result != null) {
                return result;
            }
        }

        return new String(state);
    }

    private static String[] generateCandidates(char[] state) {
        String[] candidates = { new String(state), "", "", "" };
        for (char c : state) {
            candidates[1] += (c == '0') ? '1' : '0';
        }
        for (int i = state.length - 1; i >= 0; i--) {
            candidates[2] += state[i];
        }
        for (int i = state.length - 1; i >= 0; i--) {
            candidates[3] += (state[i] == '0') ? '1' : '0';
        }

        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                if (candidates[i].equals(candidates[j])) {
                    candidates[j] = candidates[j].replace('0', 'x').replace('1', 'y');
                }
            }
        }

        return candidates;
    }

    private static void updateScores(String[] candidates, int[] scores, int k, char response) {
        for (int e = 0; e < 4; e++) {
            if (candidates[e].charAt(k - 1) == response) {
                scores[e]++;
            }
        }
    }

    private static String findUniqueCandidate(int[] scores, String[] candidates) {
        int fullCount = 0;
        for (int score : scores) {
            if (score == 10) {
                fullCount++;
            }
        }

        if (fullCount == 1) {
            for (int e = 0; e < 4; e++) {
                if (scores[e] == 10) {
                    return candidates[e];
                }
            }
        }

        return null;
    }
}