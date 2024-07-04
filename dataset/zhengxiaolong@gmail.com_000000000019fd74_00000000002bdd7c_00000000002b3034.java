
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    private static final String POSSIBLE = "POSSIBLE";
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = in.nextInt();
            handleTestCase(in, tc, N);
        }

        in.close();
    }

    private static void handleTestCase(Scanner in, int tc, int n) {
        Set<String> patterns = new LinkedHashSet<>();
        for (int i = 0; i < n; ++i) {
            String next = in.next();
            patterns.add(removeDupsAsterisk(next));
        }

        List<String> list = new ArrayList<>(patterns);

        StringBuilder sb = new StringBuilder();


        while (!list.isEmpty()) {
            String longest = "";
            Set<String> temp = new HashSet<>();
            for (String l : list) {
                if (l.contains("*")) {
                    String prefix = l.substring(0, l.indexOf('*'));
                    String rest = l.substring(l.indexOf('*') + 1);
                    if (!rest.isEmpty()) {
                        temp.add(rest);
                    }

                    if (longest.isEmpty()) {
                        longest = prefix;
                    } else {
                        if (longest.startsWith(prefix) || longest.equals(prefix)) {

                        } else if (prefix.startsWith(longest)) {
                            longest = prefix;
                        } else {
                            if (!longest.isEmpty()) {
                                String output = String.format("Case #%d: *", tc);
                                System.out.println(output);
                                return;
                            }
                        }
                    }
                } else {
                    String prefix = l;
                    if (longest.isEmpty()) {
                        longest = prefix;
                    } else {
                        if (longest.endsWith(prefix) || longest.equals(prefix)) {

                        } else if (prefix.endsWith(longest)) {
                            longest = prefix;
                        } else {
                            if (!longest.isEmpty()) {
                                String output = String.format("Case #%d: *", tc);
                                System.out.println(output);
                                return;
                            }
                        }
                    }
                }
            }
            sb.append(longest);
            list = new ArrayList<>(temp);
        }
        String output = String.format("Case #%d: %s", tc, sb.toString());
        System.out.println(output);

    }

    public static String removeDupsAsterisk(String word) {
        StringBuilder output = new StringBuilder();
        //System.out.println(word);
        char prev = word.charAt(0);
        output.append(prev);
        for (int i = 1; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (prev == ch && ch == '*') {

            } else {
                output.append(ch);
            }
            prev = ch;
        }
        return output.toString();
    }
}