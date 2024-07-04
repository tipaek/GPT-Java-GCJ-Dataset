import java.util.*;

class Solution {
    static String solve(List<String> lst) {
        String prefix = "";
        String suffix = "";
        for (String s : lst) {
            int i = s.indexOf('*');
            String localPrefix = s.substring(0, i);
            String localSuffix = s.substring(i + 1);

            if (localPrefix.startsWith(prefix) || prefix.startsWith(localPrefix) || prefix.isEmpty()) {
                if (localPrefix.length() >= prefix.length()) {
                    prefix = localPrefix;
                }
            } else {
                return "*";
            }

            if (localSuffix.endsWith(suffix) || suffix.endsWith(localSuffix) || suffix.isEmpty()) {
                if (localSuffix.length() >= suffix.length()) {
                    suffix = localSuffix;
                }
            } else {
                return "*";
            }
        }

        return prefix + suffix;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        for (int i = 1; i <= n; ++i) {
            int cases = in.nextInt();
            List<String> lst = new ArrayList<>(cases);
            for (int j = 1; j <= cases; ++j) {
                lst.add(in.next());
            }
            System.out.print(String.format("Case #%d: ", i));
            System.out.println(solve(lst));
        }
    }
}