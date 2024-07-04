import java.util.Scanner;

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

            // Read the first 10 bits
            for (int i = 0; i < 10; i++) {
                System.out.println(i + 1);
                int bit = Integer.parseInt(sc.nextLine());
                original[i] = bit;
                complement[i] = ~bit;
                reverse[i] = original[B - i - 1];
                reverseComplement[i] = ~original[B - i - 1];
            }

            int[] referenceBits = new int[10];
            for (int i = 0; i < 10; i++) {
                System.out.println(i + 1);
                referenceBits[i] = Integer.parseInt(sc.nextLine());
            }

            if (checkMatch(referenceBits, original, B) ||
                checkMatch(referenceBits, complement, B) ||
                checkMatch(referenceBits, reverse, B) ||
                checkMatch(referenceBits, reverseComplement, B)) {
                
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < 10; i++) {
                    result.append(original[i]);
                }
                System.out.println(result);
                String output = sc.nextLine();
                if (!output.equals("Y")) {
                    break;
                }
            }
        }
    }

    private static boolean checkMatch(int[] referenceBits, int[] bits, int B) {
        int count = 0;
        int countComplement = 0;
        int countReverse = 0;
        int countReverseComplement = 0;

        for (int i = 0; i < 10; i++) {
            if (referenceBits[i] == bits[i]) count++;
            if (referenceBits[i] == ~bits[i]) countComplement++;
            if (referenceBits[i] == bits[B - i - 1]) countReverse++;
            if (referenceBits[i] == ~bits[B - i - 1]) countReverseComplement++;
        }

        return count == 10 || countComplement == 10 || countReverse == 10 || countReverseComplement == 10;
    }
}