import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    BufferedReader rd;

    Solution() throws IOException {
        rd = new BufferedReader(new InputStreamReader(System.in));
        compute();
    }

    private void compute() throws IOException {
        int n = pint();
        for(int i=1;i<=n;i++) {
            out("Case #" + i + ": " + solve());
        }
    }

    private String solve() throws IOException {
        long u = plong();
        List<Node> nodes = new ArrayList<>(10000);
        for(int i=0;i<10000;i++) {
            String[] h = split(rd.readLine());
            nodes.add(new Node(plong(h[0]), h[1].toCharArray()));
        }
        return solve(u, nodes);
    }

    private String solve(long u, List<Node> nodes) {
        int[] pos = new int[26];
        char[] res = new char[10];
        for(Node node: nodes) {
            for(char c: node.s) {
                pos[c-'A']++;
            }
        }
        for(int i=1;i<=9;i++) {
            for(Node node: nodes) {
                if(firstDigit(node.m) == i && node.s.length == countDigits(node.m)) {
                    boolean ok = true;
                    for(int j=1;j<i;j++) {
                        if(res[j] == node.s[0]) {
                            ok = false;
                            break;
                        }
                    }
                    if(ok) {
                        res[i] = node.s[0];
                        break;
                    }
                }
            }
        }
        for(int i=0;i<26;i++) {
            if(pos[i] > 0) {
                char c = (char)(i+'A');
                boolean ok = true;
                for(int j=1;j<10;j++) {
                    if(res[j] == c) {
                        ok = false;
                        break;
                    }
                }
                if(ok) {
                    res[0] = c;
                    break;
                }
            }
        }
        return new String(res);
    }

    private int countDigits(long m) {
        int res = 0;
        while(m > 0) {
            res++;
            m /= 10;
        }
        return res;
    }

    private int firstDigit(long m) {
        while(m >= 10) {
            m /= 10;
        }
        return (int)m;
    }

    private class Node {
        long m;
        char[] s;

        public Node(long m, char[] s) {
            this.m = m;
            this.s = s;
        }
    }

    private int pint() throws IOException {
        return pint(rd.readLine());
    }

    private int pint(String s) {
        return Integer.parseInt(s);
    }

    private long plong() throws IOException {
        return plong(rd.readLine());
    }

    private long plong(String s) {
        return Long.parseLong(s);
    }

    public String[] split(String s) {
        if(s == null) {
            return new String[0];
        }
        int n = s.length();
        int start = -1;
        int end = 0;
        int sp = 0;
        boolean lastWhitespace = true;
        for(int i=0;i<n;i++) {
            char c = s.charAt(i);
            if(isWhitespace(c)) {
                lastWhitespace = true;
            } else {
                if(lastWhitespace) {
                    sp++;
                }
                if(start == -1) {
                    start = i;
                }
                end = i;
                lastWhitespace = false;
            }
        }
        if(start == -1) {
            return new String[0];
        }
        String[] res = new String[sp];
        int last = start;
        int x = 0;
        lastWhitespace = true;
        for(int i=start;i<=end;i++) {
            char c = s.charAt(i);
            boolean w = isWhitespace(c);
            if(w && !lastWhitespace) {
                res[x++] = s.substring(last,i);
            } else if(!w && lastWhitespace) {
                last = i;
            }
            lastWhitespace = w;
        }
        res[x] = s.substring(last,end+1);
        return res;
    }

    private boolean isWhitespace(char c) {
        return c==' ' || c=='\t';
    }

    private static void out(Object x) {
        System.out.println(x);
    }

    public static void main(String[] args) throws IOException {
        new Solution();
    }
}
