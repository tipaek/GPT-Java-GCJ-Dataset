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

            for (int i = 0; i < 10; i++) {
                System.out.println(i + 1);
                int bit = Integer.parseInt(sc.nextLine());
                original[i] = bit;
                complement[i] = ~bit;
                reverse[i] = original[B - 1 - i];
                reverseComplement[i] = ~original[B - 1 - i];
            }

            System.out.println(1);
            int bit2 = Integer.parseInt(sc.nextLine());

            System.out.println(2);
            int bit3 = Integer.parseInt(sc.nextLine());

            if (isValidConfiguration(bit2, bit3, original, 0)) {
                if (processConfiguration(sc, original)) continue;
                else break;
            }

            if (isValidConfiguration(bit2, bit3, complement, 0)) {
                if (processConfiguration(sc, complement)) continue;
                else break;
            }

            if (isValidConfiguration(bit2, bit3, original, B - 2)) {
                if (processConfiguration(sc, reverse)) continue;
                else break;
            }

            if (isValidConfiguration(bit2, bit3, complement, B - 2)) {
                if (processConfiguration(sc, reverseComplement)) continue;
                else break;
            }
        }
    }

    private static boolean isValidConfiguration(int bit2, int bit3, int[] array, int startIndex) {
        return bit2 == array[startIndex] && bit3 == array[startIndex + 1];
    }

    private static boolean processConfiguration(Scanner sc, int[] configuration) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(configuration[i]);
        }
        System.out.println(sb.toString());
        String output = sc.nextLine();
        return output.equals("Y");
    }
}