import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            in.nextLine();
            List<String> prefixes = new ArrayList<>();
            List<String> suffixes = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                String pattern = in.nextLine();
                int index = pattern.indexOf("*");
                prefixes.add(pattern.substring(0, index));
                suffixes.add(pattern.substring(index+1));
            }
            prefixes.sort(new LengthComparator());
            suffixes.sort(new LengthComparator());

            String prefix = getPrefix(prefixes);
            String suffix = getSuffix(suffixes);
            String result = prefix+suffix;
            if (prefix.equals("*") && suffix.equals("*")) {
                result = "*";
            } else if (prefix.equals("*")) {
                result = suffix;
            } else if (suffix.equals("*"))  {
                result = prefix;
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String getPrefix(List<String> patterns) {
        String largest = patterns.get(patterns.size()-1);
        for (int i = patterns.size()-2; i >= 0; i--) {
            if (!largest.startsWith(patterns.get(i))) {
                return "*";
            }
        }
        return largest.length() > 0 ? largest : "*";
    }

    private static String getSuffix(List<String> patterns) {
        String largest = patterns.get(patterns.size()-1);
        for (int i = patterns.size()-2; i >= 0; i--) {
            if (!largest.endsWith(patterns.get(i))) {
                return "*";
            }
        }
        return largest.length() > 0 ? largest : "*";
    }

    static class LengthComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return s1.length() - s2.length();
        }
    }
}