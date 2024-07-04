import java.util.*;
import java.io.*;

class GCJSolution {

    public void solve(FastReader in, PrintWriter out) {
        int testCases = in.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int N = in.nextInt();
            Set<String> uniqueWords = new HashSet<>();
            for (int i = 0; i < N; i++) {
                uniqueWords.add(in.next());
            }
            List<String> words = new ArrayList<>(uniqueWords);

            List<String> prefixes = new ArrayList<>();
            List<String> suffixes = new ArrayList<>();
            for (String word : words) {
                int firstAsterisk = word.indexOf('*');
                int lastAsterisk = word.lastIndexOf('*');
                if (firstAsterisk != 0) prefixes.add(word.substring(0, firstAsterisk));
                if (lastAsterisk != word.length() - 1) suffixes.add(word.substring(lastAsterisk + 1));
            }

            prefixes.sort((a, b) -> b.length() - a.length());
            suffixes.sort((a, b) -> b.length() - a.length());

            String prefix = prefixes.isEmpty() ? "" : prefixes.get(0);
            String suffix = suffixes.isEmpty() ? "" : suffixes.get(0);

            boolean isInvalid = false;

            for (String p : prefixes) {
                if (!prefix.startsWith(p)) {
                    isInvalid = true;
                    break;
                }
            }

            for (String s : suffixes) {
                if (!suffix.endsWith(s)) {
                    isInvalid = true;
                    break;
                }
            }

            StringBuilder result = new StringBuilder();
            if (isInvalid) {
                result.append("*");
            } else {
                result.append(prefix);
                for (String word : words) {
                    String middle = word.substring(word.indexOf('*'), word.lastIndexOf('*')).replace("*", "");
                    if (!middle.isEmpty()) {
                        result.append(middle);
                    }
                }
                result.append(suffix);
            }

            out.println(String.format("Case #%d: %s", testCase, result.toString()));
        }
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        GCJSolution solution = new GCJSolution();
        solution.solve(in, out);
        out.flush();
        out.close();
    }
}

class FastReader {
    BufferedReader br;
    StringTokenizer st;
    public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
    String next() {
        while (st == null || !st.hasMoreElements()) {
            try { st = new StringTokenizer(br.readLine()); }
            catch (IOException e) { e.printStackTrace(); }
        }
        return st.nextToken();
    }
    int nextInt() { return Integer.parseInt(next()); }
    long nextLong() { return Long.parseLong(next()); }
    double nextDouble() { return Double.parseDouble(next()); }
    String nextLine() {
        String str = "";
        try { str = br.readLine(); }
        catch (IOException e) { e.printStackTrace(); }
        return str;
    }
}