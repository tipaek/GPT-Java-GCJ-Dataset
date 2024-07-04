import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            List<String> patterns = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                patterns.add(scanner.next());
            }

            String prefix = "";
            String suffix = "";
            StringBuilder middle = new StringBuilder();
            boolean isValid = true;

            for (String pattern : patterns) {
                String[] parts = pattern.split("\\Q*\\E", -1);

                if (!pattern.startsWith("*")) {
                    if (prefix.startsWith(parts[0])) {
                        // Do nothing
                    } else if (parts[0].startsWith(prefix)) {
                        prefix = parts[0];
                    } else {
                        isValid = false;
                        break;
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
                        break;
                    }
                }
            }

            System.out.print("Case #" + t + ": ");
            if (isValid) {
                System.out.println(prefix + middle + suffix);
            } else {
                System.out.println("*");
            }
        }

        scanner.close();
    }
}