import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int b = scanner.nextInt();

        for (int testCase = 1; testCase <= t; testCase++) {
            boolean[] bits = new boolean[b];
            boolean[] matches = new boolean[b / 2];

            for (int i = 0; i < b / 2; i++) {
                System.out.println(i + 1);
                bits[i] = scanner.nextInt() == 1;
                System.out.println(b - i);
                bits[b - i - 1] = scanner.nextInt() == 1;
                matches[i] = bits[i] == bits[b - i - 1];
            }

            // StringBuilder to construct the output string
            StringBuilder output = new StringBuilder();
            for (boolean bit : bits) {
                output.append(bit ? '1' : '0');
            }

            System.out.println(output);

            // Check if the judge responds with "N" to stop
            if (scanner.next().equals("N")) {
                break;
            }
        }
    }
}