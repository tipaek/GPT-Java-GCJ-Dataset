import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = in.nextInt();
            ArrayList<String> ps = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                ps.add(in.next());
            }
            ArrayList<String> prefixes = new ArrayList<>();
            ArrayList<String> suffixes = new ArrayList<>();
            ArrayList<String> tokens = new ArrayList<>();

            for (String p : ps) {
                if (!p.startsWith("*")) {
                    prefixes.add(p.replaceFirst("\\*.*$", ""));
                }
                if (!p.endsWith("*")) {
                    suffixes.add(p.replaceFirst("^.*\\*", ""));
                }
                tokens.addAll(Arrays.asList(p.replaceFirst("\\*\\w+$", "").replaceFirst("^\\w+\\*", "").split("\\*+")));
            }
            String longestPrefix = prefixes.stream().max(Comparator.comparing(String::length)).orElse("");
            String longestSuffix = suffixes.stream().max(Comparator.comparing(String::length)).orElse("");
            boolean isPossible = true;
            for (String prefix : prefixes) {
                if (!longestPrefix.startsWith(prefix)) {
                    isPossible = false;
                    break;
                }
            }
            for (String suffix : suffixes) {
                if (!longestSuffix.endsWith(suffix)) {
                    isPossible = false;
                    break;
                }
            }

            System.out.println("Case #" + t + ": " + ((isPossible)
                    ? tokens.stream().collect(Collectors.joining("", longestPrefix, longestSuffix))
                    : "*"));
        }
    }

}
