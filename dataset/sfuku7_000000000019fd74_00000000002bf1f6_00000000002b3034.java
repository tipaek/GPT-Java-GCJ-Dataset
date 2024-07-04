import java.util.*;
import java.io.*;
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        StringBuilder ans = new StringBuilder();
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            String[] p = new String[N];
            for (int i = 0; i < N; i++) {
                p[i] = sc.next();
            }

            boolean match = true;
            StringBuilder head = new StringBuilder();
            StringBuilder tail= new StringBuilder();
            List<List<String>> remain = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                String P = p[i];
                // check head
                int j = 0;
                while (j < P.length() && j < head.length()) {
                    char pc = P.charAt(j);
                    char hc = head.charAt(j);
                    if (pc == '*') {
                        // OK
                        break;
                    }
                    if (pc != hc) {
                        // NG
                        match = false;
                        break;
                    }
                    j++;
                }
                if (!match) {
                    break;
                }
                while (j < P.length() && P.charAt(j) != '*') {
                    head.append(P.charAt(j));
                    j++;
                }

                List<String> rr = null;
                StringBuilder tt = new StringBuilder();
                while (j < P.length()) {
                    if (P.charAt(j) == '*') {
                        if (tt.length() > 0) {
                            if (rr == null) {
                                rr = new ArrayList<>();
                            }
                            rr.add(tt.toString());
                            tt = new StringBuilder();
                        }
                    } else {
                        tt.append(P.charAt(j));
                    }
                    j++;
                }
                if (rr != null) remain.add(rr);

                // check tail
                j = 0;
                while (j < P.length() && j < tail.length()) {
                    char pc = P.charAt(P.length()-1-j);
                    char tc = tail.charAt(j);
                    if (pc == '*') {
                        // OK
                        break;
                    }
                    if (pc != tc) {
                        // NG
                        match = false;
                        break;
                    }
                    j++;
                }
                if (!match) {
                    break;
                }
                while (j < P.length() && P.charAt(P.length()-1-j) != '*') {
                    tail.append(P.charAt(P.length()-1-j));
                    j++;
                }
            }
            String tmp;
            if (!match) {
                tmp = "*";
            } else {
                StringBuilder bb = new StringBuilder(head);
                for (List<String> s : remain) {
                    for (String ss : s) {
                        bb.append(ss);
                    }
                }
                for (int x = tail.length()-1; x >= 0; x--) {
                    bb.append(tail.charAt(x));
                }
                tmp = bb.toString();
            }

            ans.append("Case #"+t+": "+tmp).append('\n'); 
        }
        System.out.print(ans);
    }
}

