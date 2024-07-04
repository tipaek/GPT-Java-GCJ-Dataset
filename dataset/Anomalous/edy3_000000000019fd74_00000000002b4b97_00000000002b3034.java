import java.util.*;

public class Solution {
    public static String solve(List<String> lst) {
        StringBuilder prefix = new StringBuilder();
        StringBuilder suffix = new StringBuilder();

        for (String s : lst) {
            int i = s.indexOf('*');
            String localPrefix = s.substring(0, i);
            String localSuffix = s.substring(i + 1);

            if (localPrefix.startsWith(prefix.toString()) || prefix.toString().startsWith(localPrefix) || prefix.length() == 0) {
                if (localPrefix.length() >= prefix.length()) {
                    prefix.setLength(0);
                    prefix.append(localPrefix);
                }
            } else {
                return "*";
            }

            if (localSuffix.endsWith(suffix.toString()) || suffix.toString().endsWith(localSuffix) || suffix.length() == 0) {
                if (localSuffix.length() >= suffix.length()) {
                    suffix.setLength(0);
                    suffix.append(localSuffix);
                }
            } else {
                return "*";
            }
        }

        return prefix.toString() + suffix.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            int cases = scanner.nextInt();
            List<String> lst = new ArrayList<>(cases);
            for (int j = 0; j < cases; j++) {
                lst.add(scanner.next());
            }
            System.out.printf("Case #%d: %s%n", i, solve(lst));
        }
    }
}