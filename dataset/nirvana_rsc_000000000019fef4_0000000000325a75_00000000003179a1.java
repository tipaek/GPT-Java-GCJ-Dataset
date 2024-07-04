import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public final class Solution {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final CurrProblem solver = new CurrProblem();
        final int t = in.nextInt();
        for (int x = 1; x <= t; x++) {
            System.out.printf("Case #%d: %s\n", x, solver.solve(in));
        }
    }

    static class CurrProblem {
        public String solve(Scanner in) {
            final int u = in.nextInt();
            in.nextLine();
            List<String> list = new ArrayList<>();
            final Map<Character, Integer> freq = new HashMap<>();
            for (int i = 0; i < 10000; i++) {
                final String[] s = in.nextLine().split(" ");
                for (char c : s[1].toCharArray()) {
                    freq.merge(c, 1, Integer::sum);
                }
                list.add(s[1]);
            }
            final String str = freq
                    .entrySet()
                    .stream()
                    .sorted((x, y) -> Integer.compare(y.getValue(), x.getValue()))
                    .map(x -> String.valueOf(x.getKey()))
                    .collect(Collectors.joining());
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                Map<String, Long> keys = new HashMap<>();
                rotate(chars, 1);
                String curr = new String(chars);
                boolean daijoubu = true;
                for (String l : list) {
                    char[] chars1 = l.toCharArray();
                    for (int j = 0; j < chars1.length; j++) {
                        chars1[j] = Character.forDigit(curr.indexOf(chars1[j]), 10);
                    }
                    long as = Long.parseLong(new String(chars1));
                    if (keys.containsKey(l) && keys.get(l) != as) {
                        daijoubu = false;
                        break;
                    }
                    keys.putIfAbsent(l, as);
                }
                if (daijoubu) {
                    return curr;
                }
            }
            return "";
        }
    }

    public static void rotate(char[] chars, int k) {
        k %= chars.length;
        reverse(0, chars.length - 1, chars);
        reverse(0, k - 1, chars);
        reverse(k, chars.length - 1, chars);
    }

    private static void reverse(int from, int to, char[] chars) {
        for (int i = from; 2 * i < to + from; i++) {
            final char temp = chars[i];
            chars[i] = chars[to + from - i];
            chars[to + from - i] = temp;
        }
    }
}
