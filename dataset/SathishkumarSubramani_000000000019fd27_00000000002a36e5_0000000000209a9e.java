

import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {

    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int t = scanner.nextInt();
        final int b = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            StringBuffer output = new StringBuffer();
            IntStream.rangeClosed(1, b).forEach((index) -> {
                System.out.println(index);
                int value = scanner.nextInt();
                output.append(value);
            });
            System.out.println(output);
            String answer = scanner.next();
            if (answer.equals("N")) {
                break;
            }
        }
        scanner.close();
    }
}