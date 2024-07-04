import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            String[] conditions = scanner.nextLine().split(" ");
            int numOfCases = Integer.parseInt(conditions[0]);
            int A = Integer.parseInt(conditions[1]);
            int B = Integer.parseInt(conditions[2]);

            for (int i = 0; i < numOfCases; i++) {
                processCase(scanner, A, B);
            }
        }
    }

    private static void processCase(Scanner scanner, int A, int B) {
        for (int x = -5; x <= 5; x++) {
            for (int y = -5; y <= 5; y++) {
                System.out.println(x + " " + y);
                System.out.flush();

                String response = scanner.next();
                if ("CENTER".equals(response)) {
                    return;
                }
            }
        }
    }
}