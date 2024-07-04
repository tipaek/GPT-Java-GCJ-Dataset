import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

class Solution {

    private Input reader = new Input();

    String openingDepth[] = new String[]{"", "(", "((", "(((", "((((", "(((((", "((((((", "(((((((", "((((((((", "((((((((("};
    String closingDepth[] = new String[]{"", ")", "))", ")))", "))))", ")))))", "))))))", ")))))))", "))))))))", ")))))))))"};


    public static void main(String args[]) throws Exception {
        Solution sol = new Solution();
        sol.solve();
    }

    void solve() throws Exception {

        int t = reader.readInt();
        for (int caseId = 1; caseId <= t; caseId++) {
            char s[] = reader.readLine().toCharArray();
            StringBuilder sbr = new StringBuilder();
            for (int i = 0; i < s.length; i++) {
                int end = sbr.length() - 1;
                if (end < 0 || sbr.charAt(end) == ')') {
                    int d = Character.digit(s[i], 10);
                    sbr.append(openingDepth[d]);
                    sbr.append(s[i]);
                } else {
                    char endChar = sbr.charAt(end);
                    if (endChar == s[i]) {
                        sbr.append(s[i]);
                    } else if (endChar < s[i]) {
                        sbr.append(openingDepth[s[i] - endChar]);
                        sbr.append(s[i]);
                    } else {
                        sbr.append(closingDepth[endChar - s[i]]);
                        sbr.append(s[i]);
                    }
                }
            }
            char lastChar = sbr.charAt(sbr.length() - 1);
            if (Character.isDigit(lastChar)) {
                int d = Character.digit(lastChar, 10);
                sbr.append(closingDepth[d]);
            }
            System.out.printf("Case #%d: %s\n", caseId, sbr.toString());
        }

    }

    private static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int readInt() throws Exception {
            return parseInt(br.readLine());
        }
        
        String readLine() throws Exception {
            return br.readLine();
        }
    }
}

