import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();
        scanner.nextLine();

        for (int t = 1; t <= testCases; t++) {
            char[] data = new char[bitLength];
            char[] state = new char[bitLength];
            int left = 1;
            int right = bitLength;

            while (left < right) {
                System.out.println(left);
                System.out.flush();
                char leftChar = scanner.nextLine().charAt(0);

                System.out.println(right);
                System.out.flush();
                char rightChar = scanner.nextLine().charAt(0);

                if (leftChar == rightChar) {
                    data[left - 1] = 'S';
                    data[right - 1] = 'S';
                } else {
                    data[left - 1] = 'D';
                    data[right - 1] = 'D';
                }

                state[left - 1] = leftChar;
                state[right - 1] = rightChar;
                left++;
                right--;
            }

            String[] candidates = generateCandidates(state);
            String result = determineCorrectCandidate(scanner, bitLength, candidates);

            System.out.println(result);
            System.out.flush();
            String verification = scanner.nextLine();
        }

        scanner.close();
        System.exit(0);
    }

    private static String[] generateCandidates(char[] state) {
        String[] candidates = new String[4];
        candidates[0] = new String(state);
        candidates[1] = invertBits(state);
        candidates[2] = reverseBits(state);
        candidates[3] = reverseAndInvertBits(state);
        return candidates;
    }

    private static String invertBits(char[] state) {
        StringBuilder inverted = new StringBuilder();
        for (char c : state) {
            inverted.append(c == '0' ? '1' : '0');
        }
        return inverted.toString();
    }

    private static String reverseBits(char[] state) {
        StringBuilder reversed = new StringBuilder();
        for (int i = state.length - 1; i >= 0; i--) {
            reversed.append(state[i]);
        }
        return reversed.toString();
    }

    private static String reverseAndInvertBits(char[] state) {
        StringBuilder reversedInverted = new StringBuilder();
        for (int i = state.length - 1; i >= 0; i--) {
            reversedInverted.append(state[i] == '0' ? '1' : '0');
        }
        return reversedInverted.toString();
    }

    private static String determineCorrectCandidate(Scanner scanner, int bitLength, String[] candidates) {
        for (int i = 0; i < 5; i++) {
            int[] scores = new int[4];

            for (int j = 0; j < 10; j++) {
                int index = ((i * 10) + j) % bitLength + 1;
                System.out.println(index);
                System.out.flush();
                char response = scanner.nextLine().charAt(0);

                for (int e = 0; e < 4; e++) {
                    if (candidates[e].charAt(index - 1) == response) {
                        scores[e]++;
                    }
                }
            }

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
        }
        return null;
    }
}