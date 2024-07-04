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

            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
                int bit = Integer.parseInt(sc.nextLine());
                original[i - 1] = bit;
                complement[i - 1] = ~bit;
                reverse[i - 1] = original[B - i];
                reverseComplement[i - 1] = ~original[B - i];
            }

            int[] received = new int[B];
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
                received[i - 1] = Integer.parseInt(sc.nextLine());
            }

            if (checkAndPrint(sc, received, original, B) || 
                checkAndPrint(sc, received, complement, B) || 
                checkAndPrint(sc, received, reverse, B) || 
                checkAndPrint(sc, received, reverseComplement, B)) {
                continue;
            }
        }
    }

    private static boolean checkAndPrint(Scanner sc, int[] received, int[] pattern, int B) {
        if (matchesPattern(received, pattern, 10)) {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                s.append(pattern[i]);
            }
            System.out.println(s.toString());
            String output = sc.nextLine();
            return output.equals("Y");
        }
        return false;
    }

    private static boolean matchesPattern(int[] received, int[] pattern, int length) {
        for (int i = 0; i < length; i++) {
            if (received[i] != pattern[i]) {
                return false;
            }
        }
        return true;
    }
}