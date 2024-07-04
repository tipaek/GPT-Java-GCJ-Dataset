import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int p = 0; p < t; p++) {
            int n = in.nextInt();
            Map<Integer, String> keys = new HashMap<>();
            boolean found = true;
            for (int i = 0; i < n; i++) {
                String ch = in.next();
                String acc = "";
                int pos = 0;
                for (int j = 0; found && j < ch.length(); j++) {
                    if (ch.charAt(j) == '*') {
                        if (!acc.isEmpty()) {
                            String curr = keys.getOrDefault(pos, "*");
                            if (curr.equals("*") || acc.contains(curr)) {
                                keys.put(pos, acc);
                            } else if (!curr.contains(acc)) {
                                found = false;
                            }
                            acc = "";
                            pos++;
                        }
                        String curr = keys.getOrDefault(pos, "*");
                        if (curr.equals("*")) {
                            keys.put(pos, "*");
                        }
                        pos++;
                    } else {
                        acc += ch.charAt(j);
                    }
                }
                if (found && !acc.isEmpty() && ch.charAt(ch.length() - 1) != '*') {
                    String curr = keys.getOrDefault(pos, "*");
                    if (curr.equals("*") || acc.endsWith(curr)) {
                        keys.put(pos, acc);
                    } else if (!curr.endsWith(acc)) {
                        found = false;
                    }
                }
            }
            System.out.print(String.format("Case #%d: ", p + 1));
            if (found) {
                StringBuilder res = new StringBuilder();
                keys.values().stream().filter(s -> !s.equals("*")).forEach(res::append);
                System.out.println(res.toString());
            } else {
                System.out.println("*");
            }
        }
    }
}
