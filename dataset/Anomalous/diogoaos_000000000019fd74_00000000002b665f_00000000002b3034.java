import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int patternCount = scanner.nextInt();
            List<String> patterns = new ArrayList<>();

            for (int i = 0; i < patternCount; i++) {
                patterns.add(scanner.next());
            }

            String prefix = "";
            String suffix = "";
            StringBuilder middle = new StringBuilder();
            boolean isValid = true;

            for (String pattern : patterns) {
                String[] parts = pattern.split("\\*", -1);

                if (!pattern.startsWith("*")) {
                    if (prefix.startsWith(parts[0])) {
                        // Do nothing
                    } else if (parts[0].startsWith(prefix)) {
                        prefix = parts[0];
                    } else {
                        isValid = false;
                    }
                }

                for (int j = 1; j < parts.length - 1; j++) {
                    middle.append(parts[j]);
                }

                if (!pattern.endsWith("*")) {
                    if (suffix.endsWith(parts[parts.length - 1])) {
                        // Do nothing
                    } else if (parts[parts.length - 1].endsWith(suffix)) {
                        suffix = parts[parts.length - 1];
                    } else {
                        isValid = false;
                    }
                }
            }

            System.out.print("Case #" + caseNumber + ": ");
            if (isValid) {
                System.out.println(prefix + middle + suffix);
            } else {
                System.out.println("*");
            }
        }
        scanner.close();
    }
}