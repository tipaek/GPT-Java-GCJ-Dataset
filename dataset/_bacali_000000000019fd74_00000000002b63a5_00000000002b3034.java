import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
                            System.out.println(i + " " + pos + " " + acc + " " + curr);
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
                if (!acc.isEmpty() && ch.charAt(ch.length() - 1) != '*') {
                    String curr = keys.getOrDefault(pos, "*");
                    if (curr.equals("*") || acc.contains(curr)) {
                        keys.put(pos, acc);
                    } else if (!curr.contains(acc)) {
                        found = false;
                    }
                }
            }
            System.out.print(String.format("Case #%d: ", p + 1));
            if (found) {
                StringBuilder sb = new StringBuilder();
                keys.values().stream().filter(s -> !s.equals("*")).forEach(sb::append);
                System.out.println(sb.toString());
            } else {
                System.out.println("*");
            }
        }
    }
}
