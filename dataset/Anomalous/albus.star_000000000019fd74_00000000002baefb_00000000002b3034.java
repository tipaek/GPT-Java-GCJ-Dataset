import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        Scanner sc = new Scanner(System.in);
        int testCaseCount = sc.nextInt();
        for (int t = 1; t <= testCaseCount; t++) {
            pw.print("Case #" + t + ": ");
            solve(pw, sc);
            pw.println();
        }
        pw.close();
    }

    public static void solve(PrintWriter pw, Scanner sc) throws IOException {
        int n = sc.nextInt();
        String[] patterns = new String[n];
        int[] asteriskCounts = new int[n];

        for (int i = 0; i < n; i++) {
            patterns[i] = sc.next();
            asteriskCounts[i] = (int) patterns[i].chars().filter(ch -> ch == '*').count();
        }

        ArrayList<String> prefixes = new ArrayList<>();
        ArrayList<String> postfixes = new ArrayList<>();
        ArrayList<String> middles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int len = patterns[i].length();
            int asterisksSeen = 0;
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < len; j++) {
                char c = patterns[i].charAt(j);

                if (asterisksSeen < 1) {
                    if (c == '*') {
                        asterisksSeen++;
                        if (sb.length() > 0) {
                            prefixes.add(sb.toString());
                        }
                        sb.setLength(0);
                    } else {
                        sb.append(c);
                    }
                } else if (asterisksSeen < asteriskCounts[i]) {
                    if (c == '*') {
                        asterisksSeen++;
                        if (sb.length() > 0 && asterisksSeen == asteriskCounts[i]) {
                            middles.add(sb.toString());
                            sb.setLength(0);
                        }
                    } else {
                        sb.append(c);
                    }
                } else {
                    if (c != '*') {
                        sb.append(c);
                    }
                }
            }

            if (sb.length() > 0) {
                postfixes.add(sb.toString());
            }
        }

        Comparator<String> lengthComparator = Comparator.comparingInt(String::length).reversed();
        StringBuilder result = new StringBuilder();

        if (!prefixes.isEmpty()) {
            prefixes.sort(lengthComparator);
            result.append(prefixes.get(0));
            for (int j = 1; j < prefixes.size(); j++) {
                if (!prefixes.get(0).startsWith(prefixes.get(j))) {
                    pw.print("*");
                    return;
                }
            }
        }

        for (String middle : middles) {
            result.append(middle);
        }

        if (!postfixes.isEmpty()) {
            postfixes.sort(lengthComparator);
            result.append(postfixes.get(0));
            for (int j = 1; j < postfixes.size(); j++) {
                if (!postfixes.get(0).endsWith(postfixes.get(j))) {
                    pw.print("*");
                    return;
                }
            }
        }

        pw.print(result.toString());
    }

    public static class Scanner {
        private BufferedReader bufferedReader;
        private StringTokenizer tokenizer;

        public Scanner(InputStream inputStream) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        }

        public int nextInt() throws IOException {
            ensureToken();
            return Integer.parseInt(tokenizer.nextToken());
        }

        public long nextLong() throws IOException {
            ensureToken();
            return Long.parseLong(tokenizer.nextToken());
        }

        public String next() throws IOException {
            ensureToken();
            return tokenizer.nextToken();
        }

        private void ensureToken() throws IOException {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(bufferedReader.readLine());
            }
        }
    }
}