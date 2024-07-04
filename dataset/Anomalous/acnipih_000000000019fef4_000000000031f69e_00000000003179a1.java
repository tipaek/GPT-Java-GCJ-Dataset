import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    static class Pair {
        int value;
        String str;

        public Pair(int value, String str) {
            this.value = value;
            this.str = str;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int u = in.nextInt();
            Pair[] logs = new Pair[10000];
            for (int j = 0; j < 10000; j++) {
                logs[j] = new Pair(in.nextInt(), in.next());
            }
            String result = solve(logs);
            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    private static String solve(Pair[] logs) {
        char[] dStr = new char[10];
        Set<Character> used = new HashSet<>();
        Set<Character> set = new HashSet<>();

        for (int i = 1; i <= 9; i++) {
            for (Pair pair : logs) {
                String str = String.valueOf(pair.value);
                if (set.size() < 10) {
                    for (int k = 0; k < pair.str.length(); k++) {
                        set.add(pair.str.charAt(k));
                    }
                }
                int digits = str.length();
                if (pair.value / Math.pow(10, digits - 1) == i && pair.str.length() == digits) {
                    if (!used.contains(pair.str.charAt(0))) {
                        dStr[i] = pair.str.charAt(0);
                        used.add(pair.str.charAt(0));
                        break;
                    }
                }
            }
        }

        for (Character c : set) {
            if (!used.contains(c)) {
                dStr[0] = c;
                break;
            }
        }

        return new String(dStr);
    }
}