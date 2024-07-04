import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = Integer.parseInt(scanner.nextLine().trim().split(" ")[0]);

        for (int testIndex = 0; testIndex < numberOfTests; testIndex++) {
            StringBuilder answerBuilder = new StringBuilder();

            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
                String response = scanner.nextLine().trim();
                if ("N".equals(response)) {
                    System.exit(1);
                }
                answerBuilder.append(response);
                System.out.flush();
            }

            System.out.println(answerBuilder.toString());
            String finalResponse = scanner.nextLine().trim();
            if ("N".equals(finalResponse)) {
                System.exit(1);
            }
            System.out.flush();
        }
    }
}