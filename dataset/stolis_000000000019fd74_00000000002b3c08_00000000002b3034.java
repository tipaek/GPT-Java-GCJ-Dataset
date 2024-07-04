import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t=1; t<=T; t++) {
            int N = in.nextInt();
            String[] P = new String[N];
            for (int n=0; n<N; n++) {
                P[n] = in.next();
            }
            boolean possible = true;
            String prefix = "";
            String suffix = "";
            StringBuilder middle = new StringBuilder();
            for (String s : P) {
                int idx1 = s.indexOf('*');
                String p = s.substring(0,idx1);
                if (prefix.length() > p.length()) {
                    possible &= prefix.startsWith(p);
                } else {
                    possible &= p.startsWith(prefix);
                    prefix = p;
                }
                
                int idx2 = s.lastIndexOf('*');
                p = s.substring(idx2+1);
                if (suffix.length() > p.length()) {
                    possible &= suffix.endsWith(p);
                } else {
                    possible &= p.endsWith(suffix);
                    suffix = p;
                }
                
                for (int i=idx1; i<idx2; i++) {
                    char c = s.charAt(i);
                    if (c != '*') {
                        middle.append(c);
                    }
                }
            }
            String answer;
            if (possible) {
                answer = prefix + middle + suffix;
            } else {
                answer = "*";
            }
            System.out.printf("Case #%d: %s\n", t, answer);
        }
    }

}
