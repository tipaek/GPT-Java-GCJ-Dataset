import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int numLines = scanner.nextInt();
            String[] conditions = new String[numLines];

            for (int j = 0; j < numLines; j++) {
                conditions[j] = scanner.next();
            }

            boolean found = false;

            for (int j = 0; j < numLines; j++) {
                boolean isValid = true;
                String currentCondition = conditions[j].substring(1);

                for (int k = 0; k < numLines; k++) {
                    if (!currentCondition.contains(conditions[k].substring(1))) {
                        isValid = false;
                        break;
                    }
                }

                if (isValid && !found) {
                    System.out.println("Case #" + (i + 1) + ": " + currentCondition);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Case #" + (i + 1) + ": *");
            }
        }
    }
}