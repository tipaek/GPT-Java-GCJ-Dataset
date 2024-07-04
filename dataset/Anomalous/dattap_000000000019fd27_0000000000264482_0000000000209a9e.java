import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int T = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        for (int testCase = 1; testCase <= T; testCase++) {
            int[] original = new int[B];
            int[] complement = new int[B];
            int[] reverse = new int[B];
            int[] reverseComplement = new int[B];

            for (int i = 0; i < 10; i++) {
                System.out.println(i + 1);
                int bit = Integer.parseInt(sc.nextLine());
                original[i] = bit;
                complement[i] = ~bit;
                reverse[i] = original[B - i - 1];
                reverseComplement[i] = ~original[B - i - 1];
            }

            int[] received = new int[B];
            for (int i = 0; i < 10; i++) {
                System.out.println(i + 1);
                received[i] = Integer.parseInt(sc.nextLine());
            }

            if (isMatch(received, original, B) || isMatch(received, complement, B) 
                || isMatch(received, reverse, B) || isMatch(received, reverseComplement, B)) {
                String result = arrayToString(original, 10);
                System.out.println(result);
                String output = sc.nextLine();
                if (output.equals("Y")) {
                    continue;
                } else {
                    break;
                }
            }
        }
    }

    private static boolean isMatch(int[] received, int[] pattern, int B) {
        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (received[i] == pattern[i] || received[i] == ~pattern[i]
                || received[i] == pattern[B - i - 1] || received[i] == ~pattern[B - i - 1]) {
                count++;
            }
        }
        return count == 10;
    }

    private static String arrayToString(int[] array, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(array[i]);
        }
        return sb.toString();
    }
}