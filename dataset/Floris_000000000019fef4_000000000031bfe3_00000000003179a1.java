import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream in = System.in;
        Scanner sc = new Scanner(in);
//        sc.useDelimiter(Pattern.compile("[\n /]"));

x:        for (int cs = 1, cases = sc.nextInt(); cs <= cases; cs++) {
            int u = sc.nextInt();

            List<String> inp = new ArrayList<>();

            for (int i = 0; i < 10000; i++) {sc.next(); inp.add(sc.next()); }
            boolean[] usedchars = new boolean[26];
            for (String s : inp) for (int i = 0; i < s.length(); i++) usedchars[s.charAt(i)-'A'] = true;
            int[] count = new int[26];
            for (String s : inp) if (s.length() == u) count[s.charAt(0)-'A']++;

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < 26; i++) if (usedchars[i] && count[i]==0) result.append((char)(i+'A'));
            TreeMap<Integer,String> c = new TreeMap<>();
            for (int i = 0; i < 26; i++) c.put(count[i], (char)(i+'A') + "");
            c.descendingMap().values().stream().limit(9).forEach(a->result.append(a));

            System.out.printf("Case #%d: %s%n", cs, result);
        }
    }
}
