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

            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
                int bit = Integer.parseInt(sc.nextLine());
                original[i - 1] = bit;
                complement[i - 1] = ~bit;
                reverse[i - 1] = original[B - 1];
                reverseComplement[i - 1] = ~original[B - 1];
            }

            if (testCase == 1) {
                System.out.println(1);
                int secondBit = Integer.parseInt(sc.nextLine());
                String result = "";

                if (secondBit == original[0]) {
                    for (int i = 0; i < 10; i++) {
                        result += original[i];
                    }
                } else if (secondBit == complement[0]) {
                    for (int i = 0; i < 10; i++) {
                        result += complement[i];
                    }
                } else if (secondBit == reverse[0]) {
                    for (int i = 0; i < 10; i++) {
                        result += reverse[i];
                    }
                } else if (secondBit == reverseComplement[0]) {
                    for (int i = 0; i < 10; i++) {
                        result += reverseComplement[i];
                    }
                }

                System.out.println(result);
            }

            String output = sc.nextLine();
            if (output.equals("Y")) {
                continue;
            }
        }
    }
}