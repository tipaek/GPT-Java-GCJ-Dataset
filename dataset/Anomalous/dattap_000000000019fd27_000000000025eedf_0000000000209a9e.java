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
            int[] reversed = new int[B];
            int[] reversedComplement = new int[B];

            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
                int bit = Integer.parseInt(sc.nextLine());
                original[i - 1] = bit;
                complement[i - 1] = ~bit;
                reversed[i - 1] = original[B - 1];
                reversedComplement[i - 1] = ~original[B - 1];
            }

            System.out.println(1);
            int secondBit = Integer.parseInt(sc.nextLine());

            if (secondBit == original[0]) {
                printArrayAndCheck(sc, original);
            } else if (secondBit == ~original[0]) {
                printArrayAndCheck(sc, complement);
            } else if (secondBit == original[B - 1]) {
                printArrayAndCheck(sc, reversed);
            } else if (secondBit == ~original[B - 1]) {
                printArrayAndCheck(sc, reversedComplement);
            }
        }
    }

    private static void printArrayAndCheck(Scanner sc, int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(array[i]);
        }
        System.out.println(sb.toString());
        String output = sc.nextLine();
        if (!output.equals("Y")) {
            System.exit(0);
        }
    }
}