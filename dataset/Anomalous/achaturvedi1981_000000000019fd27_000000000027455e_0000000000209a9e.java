import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            String[] input = scanner.nextLine().split(" ");
            int T = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);

            for (int i = 0; i < T; i++) {
                System.out.println(findData(scanner, B));
                String result = scanner.nextLine();
                if ("N".equals(result)) {
                    break;
                }
            }
        }
    }

    private static String findData(Scanner scanner, int b) {
        StringBuilder sb = new StringBuilder();
        int index = 0;

        for (int i = 1; i <= 150; i++) {
            if (i % 10 != 1) { // we might get bad output if last digit is 1
                System.out.println(index + 1);
                int bitValue = scanner.nextInt();
                sb.append(bitValue);
                if (index == b - 1) {
                    break;
                }
                index++;
            }
        }
        return sb.toString();
    }
}