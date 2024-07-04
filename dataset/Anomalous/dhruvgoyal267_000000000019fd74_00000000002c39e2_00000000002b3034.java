import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            String[] strings = new String[n];

            for (int i = 0; i < n; i++) {
                strings[i] = scanner.nextLine();
            }

            String result = "*";
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j && strings[i].contains(strings[j].substring(1))) {
                        result = strings[i].substring(1);
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }

        scanner.close();
    }
}