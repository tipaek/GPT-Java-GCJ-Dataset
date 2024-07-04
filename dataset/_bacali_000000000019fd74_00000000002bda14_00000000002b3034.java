import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int p = 0; p < t; p++) {
            int n = in.nextInt();
            String prefix = "";
            String suffix = "";
            Map<Integer, String> keys = new HashMap<>();
            boolean found = true;
            for (int i = 0; i < n; i++) {
                String ch = in.next();
                String pf = ch.split("\\*")[0];
                String sf = new StringBuilder(new StringBuilder(ch).reverse().toString().split("\\*")[0]).reverse().toString();
                if (pf.startsWith(prefix) || prefix.startsWith(pf)) {
                    prefix = pf.length() > prefix.length() ? pf : prefix;
                } else {
                    found = false;
                }
                if (sf.endsWith(suffix) || suffix.endsWith(sf)) {
                    suffix = sf.length() > suffix.length() ? sf : suffix;
                } else {
                    found = false;
                }
                String acc = "";
                int pos = 0;
                for (int j = 0; found && j < ch.length(); j++) {
                    if (ch.charAt(j) == '*') {
                        if (!acc.isEmpty()) {
                            if (pos > 0) {
                                String curr = keys.getOrDefault(pos, "*");
                                if (curr.equals("*") || acc.contains(curr)) {
                                    keys.put(pos, acc);
                                } else if (!curr.contains(acc)) {
                                    found = false;
                                }
                            }
                            acc = "";
                            pos++;
                        }
                        if (pos == 0) pos++;
                        String curr = keys.getOrDefault(pos, "*");
                        if (curr.equals("*")) {
                            keys.put(pos, "*");
                        }
                        pos++;
                    } else {
                        acc += ch.charAt(j);
                    }
                }
            }
            System.out.print(String.format("Case #%d: ", p + 1));
            if (found) {
                StringBuilder res = new StringBuilder();
                keys.values().stream().filter(s -> !s.equals("*")).forEach(res::append);
                System.out.println(prefix + res.toString() + suffix);
            } else {
                System.out.println("*");
            }
        }
    }
}
