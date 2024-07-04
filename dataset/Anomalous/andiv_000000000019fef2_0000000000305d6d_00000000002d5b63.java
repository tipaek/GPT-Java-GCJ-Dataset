import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; ++i) {
            if (a == b) {
                if (a == 1000000000 - 5) {
                    boolean found = false;
                    for (int x = -5; x <= 5 && !found; x++) {
                        for (int y = -5; y <= 5 && !found; y++) {
                            System.out.println(x + " " + y);
                            String response = scanner.nextLine();
                            if ("WRONG".equals(response)) return;
                            if ("CENTER".equals(response)) {
                                found = true;
                            }
                            // "HIT" and "MISS" conditions are effectively no-ops
                        }
                    }
                } else if (a == 1000000000 - 50) {
                    // No operation defined for this condition
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }
}