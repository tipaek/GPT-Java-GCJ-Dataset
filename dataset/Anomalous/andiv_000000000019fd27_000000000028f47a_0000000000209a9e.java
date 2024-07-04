import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            int b = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            for (int i = 1; i <= testCases; i++) {
                if (b == 10) {
                    char[] resultArray = new char[10];
                    for (int j = 0; j < 10; j++) {
                        System.out.println(j + 1);
                        int response = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        resultArray[j] = (char) ('0' + response);
                    }
                    System.out.println(new String(resultArray));
                    String verification = scanner.nextLine();
                    if ("N".equals(verification)) {
                        return;
                    }
                }
                return;
            }
        }
    }
}