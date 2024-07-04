import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            String[] strings = new String[n];

            for (int i = 0; i < n; i++) {
                strings[i] = scanner.nextLine();
            }

            String mainPattern = "*";
            for (int i = 0; i < n; i++) {
                String currentString = strings[i].replace("*", "");
                boolean isValid = true;

                for (int j = 0; j < n; j++) {
                    if (!currentString.contains(strings[j].substring(1))) {
                        isValid = false;
                        break;
                    }
                }

                if (isValid) {
                    mainPattern = currentString;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + mainPattern);
            caseNumber++;
        }

        scanner.close();
    }
}