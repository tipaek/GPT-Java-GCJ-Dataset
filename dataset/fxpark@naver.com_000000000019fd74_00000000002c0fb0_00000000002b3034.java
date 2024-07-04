
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;


public class Solution implements Runnable {
    public static void main(String[] args) {
        new Thread(new Solution()).start();
    }

    @Override
    public void run() {
        try {
            solve();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    BufferedReader rd;
    PrintWriter wr;
    StringTokenizer tok = null;

    String nextToken() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(rd.readLine());
        }
        return tok.nextToken();
    }

    private void solve() throws IOException {
        rd = new BufferedReader(new InputStreamReader(System.in));
        wr = new PrintWriter(System.out);
        int t = Integer.parseInt(nextToken());
        for (int i = 0; i < t; ++i) {
            String res = subsolve();
            wr.println(String.format("Case #%d: %s", i + 1, res));
        }
        rd.close();
        wr.close();
    }

    private String subsolve() throws IOException {
        int n = Integer.parseInt(nextToken());
        List<String> patterns = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String pattern = nextToken();
            patterns.add(pattern);
        }

        /*patterns.sort((String s1, String s2) -> {
            if(s1.length() < s2.length())
                return 1;

            if(s1.length() == s2.length()) {
                if(s2.charAt(s2.length() - 1) == '*')
                    return 1;

            }
            return 0;

        });*/
        patterns.sort(Comparator.comparing(String::length).reversed());

        StringBuilder sb = new StringBuilder();

        while(!patterns.get(0).isEmpty()) {
            char decide = '*';
            int baseLen = patterns.get(0).length();

            for(int i = 0; i < patterns.size(); i++) {
                String pattern = patterns.get(i);

                //System.out.println(pattern);

                if(pattern.isEmpty())
                    continue;

                char c = pattern.charAt(pattern.length() - 1);
                if(c == '*') {
                    if(decide != '*') {
                        if(baseLen == 1) {
                            patterns.set(i, pattern.substring(0, pattern.length() - 1));
                        }

                        else if(baseLen == pattern.length()) {
                            if(pattern.charAt(pattern.length() - 2) == decide) {
                                patterns.set(i, pattern.substring(0, pattern.length() - 2));
                            } /*else {
                                patterns.set(i, pattern.substring(0, pattern.length() - 1));
                            }*/
                        }
                    }
                } else {
                    if(decide != '*' && decide != c)
                        return "*";

                    decide = c;
                    patterns.set(i, pattern.substring(0, pattern.length() - 1));
                }

            }
            if(decide == '*') {
                for(int i = 0; i < patterns.size(); i++) {
                    String pattern = patterns.get(i);

                    if(pattern.isEmpty())
                        continue;

                    if(pattern.length() == baseLen) {
                        patterns.set(i, pattern.substring(0, pattern.length() - 1));
                    }
                }
            }


            patterns.sort(Comparator.comparing(String::length).reversed());

            //System.out.println("decided = " + decide);
            if(decide != '*') {
                sb.append(decide);
            }

            for(String p : patterns) {
                if(p.isEmpty())
                    return sb.reverse().toString();
            }
        }

        return sb.reverse().toString();
    }
}