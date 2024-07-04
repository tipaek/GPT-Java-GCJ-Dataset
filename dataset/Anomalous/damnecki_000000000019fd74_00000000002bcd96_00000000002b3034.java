import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.util.*;

public class Solution {

    private static final Scanner IN = new Scanner(new BufferedInputStream(System.in));
    private static final PrintStream OUT = System.out;

    public static void main(String[] args) {
        int T = IN.nextInt();
        
        for (int t = 1; t <= T; t++) {
            int N = IN.nextInt();
            List<List<String>> P = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                String pp = IN.next();
                String[] p = pp.split("\\*");
                
                for (int j = 0; j < p.length; j++) {
                    if (P.size() == j) {
                        P.add(new ArrayList<>());
                    }
                    P.get(j).add(p[j]);
                }
                
                if (pp.endsWith("*") && P.size() == p.length) {
                    P.add(new ArrayList<>());
                    P.get(P.size() - 1).add("");
                }
            }

            for (List<String> part : P) {
                part.sort(new Comp());
            }

            String result = findPattern(P);
            OUT.println("Case #" + t + ": " + result);
        }
    }

    private static String findPattern(List<List<String>> P) {
        String name = "";

        // Check prefix
        String prefix = P.get(0).get(0);
        if (!prefix.isEmpty() && !isValidPrefix(P.get(0), prefix)) {
            return "*";
        }
        name = prefix;

        // Check middle parts
        for (int i = 1; i < P.size() - 1; i++) {
            String part = P.get(i).get(0);
            if (!isValidMiddle(P.get(i), part)) {
                return "*";
            }
            name += part;
        }

        // Check suffix
        String suffix = P.get(P.size() - 1).get(0);
        if (!suffix.isEmpty() && !isValidPrefix(P.get(P.size() - 1), suffix)) {
            return "*";
        }
        name += suffix;

        return name;
    }

    private static boolean isValidPrefix(List<String> parts, String prefix) {
        for (String part : parts) {
            if (!prefix.startsWith(part)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidMiddle(List<String> parts, String part) {
        for (String subPart : parts) {
            if (!part.contains(subPart)) {
                return false;
            }
        }
        return true;
    }

    static class Comp implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o2.length() - o1.length();
        }
    }
}