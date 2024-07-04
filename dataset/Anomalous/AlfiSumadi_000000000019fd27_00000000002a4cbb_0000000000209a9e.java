import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            StringBuilder bits = new StringBuilder();
            for (int i = 0; i < bitLength; i++) {
                bits.append('x');
            }

            int queryCount = 0;
            int offset = 0;
            while (!isComplete(bits.toString()) && queryCount < 150) {
                System.err.println(bits.toString());

                if (queryCount % 10 == 0) {
                    String reversed = reverse(bits.toString());
                    String complemented = complement(bits.toString());
                    String both = reverse(complement(bits.toString()));
                    
                    for (int j = 0; j < 5; j++) {
                        System.out.println((j + 1 + offset));
                        System.out.flush();
                        bits.setCharAt(j, scanner.next().charAt(0));
                    }
                }

                int position = queryCount + 1;
                System.out.println(position);
                System.out.flush();
                bits.setCharAt(position - 1, scanner.next().charAt(0));

                position = bitLength - queryCount;
                System.out.println(position);
                System.out.flush();
                bits.setCharAt(position - 1, scanner.next().charAt(0));

                queryCount++;
            }

            System.out.println(bits.toString());
            System.out.flush();

            char result = scanner.next().charAt(0);
            if (result == 'N') {
                System.exit(0);
            }
        }

        System.exit(0);
    }

    private static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private static String complement(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            result.append(c == '1' ? '0' : '1');
        }
        return result.toString();
    }

    private static boolean isComplete(String s) {
        for (char c : s.toCharArray()) {
            if (c == 'x') {
                return false;
            }
        }
        return true;
    }
}