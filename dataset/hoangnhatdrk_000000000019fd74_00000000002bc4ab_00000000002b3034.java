public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            in.nextLine();
            String[] patterns = new String[n];
            for (int j = 0; j < n; j++) {
                patterns[j] = in.nextLine();
            }
            String result = match(patterns, n);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String match(String[] patterns, int n) {
        String left = match(patterns, n, true);
        System.out.println(left);
        String right = match(patterns, n, false);
        System.out.println(right);
        if (left.equals("*") || right.equals("*")) {
            return "*";
        } else {
            return left+right;
        }
    }

    public static String match(String[] patterns, int n, boolean ltr) {
        int id = 0;
        int count = 0;
        boolean[] matched = new boolean[n];
        StringBuilder sb = new StringBuilder();

        while (true) {
            char curChar = ' ';
            for (int i=0; i<patterns.length; i++) {
                if (matched[i]) {
                    continue;
                }
                String p = patterns[i];
                if (p.length() <= id) {
                    continue;
                } else {
                    char c = p.charAt(p.length() - 1 - id);
                    if (ltr) {
                        c = p.charAt(id);
                    }

                    if (c == '*') {
                        count++;
                        matched[i] = true;
                        continue;
                    }

                    if (curChar == ' ') {
                        curChar = c;
                        if (id == p.length()-1) {
                            count++;
                        }
                    } else {
                        if (curChar != c) {
                            return "*";
                        }
                    }
                }
            }
            if (curChar != ' ')
                sb.append(curChar);
            if (count == n) {
                return ltr ? sb.toString() : sb.reverse().toString();
            }
            id++;
        }
    }
}