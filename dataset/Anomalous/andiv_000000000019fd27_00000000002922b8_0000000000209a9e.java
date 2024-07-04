import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            int bitLength = scanner.nextInt();
            scanner.nextLine(); // consume the remaining newline

            for (int i = 1; i <= testCases; i++) {
                if (bitLength == 10) {
                    char[] result = new char[10];
                    for (int j = 0; j < 10; j++) {
                        System.out.println(j + 1);
                        int response = scanner.nextInt();
                        result[j] = (char) ('0' + response);
                    }
                    scanner.nextLine(); // consume the remaining newline
                    System.out.println(new String(result));
                    String verdict = scanner.nextLine();
                    if ("N".equals(verdict)) {
                        return;
                    }
                }
                return;
            }
        }
    }
}