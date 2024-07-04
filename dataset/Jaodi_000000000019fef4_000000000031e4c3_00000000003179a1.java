import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            in.nextLine();
            HashMap<Character, Integer> freq = new HashMap<>();
            HashSet<Character> alpha = new HashSet<>();
            for (int j = 0; j < 10000; j++) {
                String line = in.nextLine();
                String[] parts = line.split(" ");
                String code = parts[1];
                if (alpha.size() < 10) {
                    for (int k = 0; k < code.length(); k++) {
                        if (!alpha.contains(code.charAt(k))) {
                            alpha.add(code.charAt(k));
                        }
                    }
                }
                if (code.length() > 1) {
                    freq.put(code.charAt(0), freq.getOrDefault(code.charAt(0), 0) + 1);
                }
            }
            TreeMap<Character, Integer> tm = new TreeMap<>((a, b) -> freq.get(b) - freq.get(a));
            tm.putAll(freq);
            String res = "";
            for (Character c : tm.keySet()) {
                res = res + c;
                alpha.remove(c);
            }
            for (Character c : alpha) {
                res = c + res;
            }
            System.out.println("Case #" + i + ": " + res);
        }
        in.close();
    }

}