import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = scanner.nextInt();
            int b = scanner.nextInt();
            scanner.nextLine();

            for (int i = 1; i <= t; ++i) {
                if (b == 10) {
                    StringBuilder result = new StringBuilder();
                    for (int j = 0; j < 10; j++) {
                        System.out.println(j + 1);
                        int res = scanner.nextInt();
                        scanner.nextLine();
                        result.append(res);
                    }
                    System.out.println(result.toString());
                    String answer = scanner.nextLine();
                    if ("N".equals(answer)) {
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }
}