import java.util.Scanner;

/**
 * Created by Sun on 4/3/2020.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        int T = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        for (int i = 0; i < T; i++) {
            String result;
            if (B <= 10) {
                result = probe1(scan, B);
            } else {
                result = probe2(scan, B);
            }
            if (result.equals("N")) {
                return;
            }
        }
    }

    private static String probe1(Scanner scan, int B) {
        StringBuilder output = new StringBuilder(B);
        for (int i = 0; i < B; i++) {
            System.out.println(i + 1);
            int answer = Integer.parseInt(scan.nextLine());
            output.append(answer);
        }
        System.out.println(output.toString());
        return scan.nextLine();
    }

    private static String probe2(Scanner scan, int B) {
        boolean[] bits = new boolean[B];
        int[] keyPositions = new int[]{0, 1, 2, 3, 4, B - 5, B - 4, B - 3, B - 2, B - 1};
        int answer;
        for (int i : keyPositions) {
            System.out.println(i + 1);
            answer = Integer.parseInt(scan.nextLine());
            bits[i] = answer == 1;
        }
        boolean[] invert = invert(bits);
        boolean[] reverse = reverse(bits);
        boolean[] revert = invert(reverse);
        int a = -1, b = -1;
        for (int x = 0; x < keyPositions.length - 1; x++) {
            for (int y = x + 1; y < keyPositions.length; y++) {
                if (hasUnique(bits, invert, reverse, revert, keyPositions[x], keyPositions[y])) {
                    a = keyPositions[x];
                    b = keyPositions[y];
                    break;
                }
            }
            if (a >= 0) {
                break;
            }
        }
        if (a < 0 || b < 0) {
            throw new IllegalStateException("no suitable a and b found!");
        }
        int bitsLeft = B - 10;
        while (bitsLeft > 0) {
            System.out.println(a + 1);
            answer = Integer.parseInt(scan.nextLine());
            boolean newA = answer == 1;
            System.out.println(b + 1);
            answer = Integer.parseInt(scan.nextLine());
            boolean newB = answer == 1;
            int result = combineBits(newA, newB);
            if (result == combineBits(bits, a, b)) {
                // do nothing
            } else if (result == combineBits(invert, a, b)) {
                bits = invert;
            } else if (result == combineBits(reverse, a, b)) {
                bits = reverse;
            } else if (result == combineBits(revert, a, b)) {
                bits = revert;
            }
            int bitsToRead = Math.min(8, bitsLeft);
            for (int i = 0; i < bitsToRead; i++) {
                int position = 4 + bitsLeft;
                System.out.println(position + 1);
                answer = Integer.parseInt(scan.nextLine());
                bits[position] = answer == 1;
                bitsLeft--;
            }
            if (bitsLeft > 0) {
                invert = invert(bits);
                reverse = reverse(bits);
                revert = invert(reverse);
            }
        }
        StringBuilder output = new StringBuilder(B);
        for (boolean bit : bits) {
            output.append(bit ? 1 : 0);
        }
        System.out.println(output.toString());
        return scan.nextLine();
    }

    private static boolean[] invert(boolean[] input) {
        boolean[] output = new boolean[input.length];
        for (int i = 0; i < output.length; i++) {
            output[i] = !input[i];
        }
        return output;
    }

    private static boolean[] reverse(boolean[] input) {
        boolean[] output = new boolean[input.length];
        for (int i = 0; i < output.length; i++) {
            output[i] = input[output.length - i - 1];
        }
        return output;
    }

    private static boolean hasUnique(boolean[] original, boolean[] invert, boolean[] reverse, boolean[] revert,
                                     int a, int b) {
        int[] count = new int[4];
        count[combineBits(original, a, b)]++;
        count[combineBits(invert, a, b)]++;
        count[combineBits(reverse, a, b)]++;
        count[combineBits(revert, a, b)]++;
        return count[0] == 1 && count[1] == 1 && count[2] == 1 && count[3] == 1;
    }

    private static int combineBits(boolean[] bits, int a, int b) {
        return combineBits(bits[a], bits[b]);
    }

    private static int combineBits(boolean a, boolean b) {
        if (a) {
            if (b) {
                return 3;
            } else {
                return 2;
            }
        } else {
            if (b) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
