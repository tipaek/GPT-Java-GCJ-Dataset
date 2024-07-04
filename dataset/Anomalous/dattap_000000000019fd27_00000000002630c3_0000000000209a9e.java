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

            // Read the first 10 bits
            for (int i = 0; i < 10; i++) {
                System.out.println(i + 1);
                int bit = Integer.parseInt(sc.nextLine());
                original[i] = bit;
                complement[i] = ~bit;
                reversed[i] = original[B - i - 1];
                reversedComplement[i] = ~original[B - i - 1];
            }

            int[] received = new int[B];

            // Read the next 10 bits
            for (int i = 0; i < 10; i++) {
                System.out.println(i + 1);
                received[i] = Integer.parseInt(sc.nextLine());
            }

            // Check each possible pattern
            for (int i = 0; i < 10; i++) {
                if (matchesPattern(received[i], original[i], original[B - i - 1])) {
                    if (printAndCheck(sc, original)) {
                        continue;
                    } else {
                        break;
                    }
                }
                if (matchesPattern(received[i], complement[i], complement[B - i - 1])) {
                    if (printAndCheck(sc, complement)) {
                        continue;
                    } else {
                        break;
                    }
                }
                if (matchesPattern(received[i], reversed[i], reversed[B - i - 1])) {
                    if (printAndCheck(sc, reversed)) {
                        continue;
                    } else {
                        break;
                    }
                }
                if (matchesPattern(received[i], reversedComplement[i], reversedComplement[B - i - 1])) {
                    if (printAndCheck(sc, reversedComplement)) {
                        continue;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    private static boolean matchesPattern(int received, int pattern1, int pattern2) {
        return received == pattern1 || received == ~pattern1 || received == pattern2 || received == ~pattern2;
    }

    private static boolean printAndCheck(Scanner sc, int[] pattern) {
        StringBuilder sb = new StringBuilder();
        for (int bit : pattern) {
            sb.append(bit);
        }
        System.out.println(sb.toString());
        String output = sc.nextLine();
        return output.equals("Y");
    }
}