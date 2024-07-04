import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static int max_moves = Integer.MAX_VALUE;
    private static Set<String> possible;

    public static void main(String[] args) throws Exception {
        //String s = solve(-4,10);
        //System.out.println(s);

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int X = in.nextInt();
            int Y = in.nextInt();
            System.out.println("Case #" + i + ": " + solve(X, Y));
        }
    }

    private static String solve(int x, int y) {
        int x_norm = Math.abs(x);
        int y_norm = Math.abs(y);        

        if (x_norm % 2 == 0 && y_norm % 2 == 0) return "IMPOSSIBLE";
        if (x_norm % 2 == 1 && y_norm % 2 == 1) return "IMPOSSIBLE";

        max_moves = log2(Math.max(x_norm, y_norm)) + 2;
        
        possible = new HashSet<>();
        target(x_norm, new HashSet<>(), 0, 0, 0, "", "");
        Set<String> x_possible = new HashSet<>(possible);
        if (x_possible.isEmpty()) {
            return "IMPOSSIBLE";
        }
        possible = new HashSet<>();
        target(y_norm, new HashSet<>(), 0, 0, 0, "", "");
        Set<String> y_possible = new HashSet<>(possible);
        if (y_possible.isEmpty()) {
            return "IMPOSSIBLE";
        }

        return compare(x, y, x_possible, y_possible);
    }

    private static String compare(int x, int y, Set<String> x_possible, Set<String> y_possible) {
        String seq = "";

        for (String combo : x_possible) {
            String[] arr = combo.split("-");
            List<String> lst = new ArrayList<>();
            lst.add(arr[0]);
            lst.add(arr[1]);

            for (String y_combo : y_possible) {
                List<String> next_lst = new ArrayList<>(lst);

                String[] y_arr = y_combo.split("-");
                next_lst.add(y_arr[0]);
                next_lst.add(y_arr[1]);
                String next = overlap(x, y, next_lst);
                if (!next.equals("")) {
                    if (seq.equals("") || next.length() < seq.length()) {
                        seq = next;
                    }
                }
            }
        }

        return seq;
    }

    private static String overlap(int x, int y, List<String> lst) {
        while (lst.get(0).length() < lst.get(2).length()) {
            String s1 = "0" + lst.get(0);
            String s2 = "0" + lst.get(1);
            lst.set(0, s1);
            lst.set(1, s2);
        }

        while (lst.get(2).length() < lst.get(0).length()) {
            String s1 = "0" + lst.get(2);
            String s2 = "0" + lst.get(3);
            lst.set(2, s1);
            lst.set(3, s2);
        }

        int size = lst.get(0).length();
        String s1 = lst.get(0);
        String s2 = lst.get(1);
        String s3 = lst.get(2);
        String s4 = lst.get(3);

        for (int i = 0; i < size; i++) {
            int n1 = Integer.parseInt(s1.charAt(i) + "");
            int n2 = Integer.parseInt(s2.charAt(i) + "");
            int n3 = Integer.parseInt(s3.charAt(i) + "");
            int n4 = Integer.parseInt(s4.charAt(i) + "");
            if (n1 + n2 + n3 + n4 != 1) {
                return "";
            }
        }

        String res = "";
        for (int i = size - 1; i >= 0; i--) {
            int n1 = Integer.parseInt(s1.charAt(i) + "");
            int n2 = Integer.parseInt(s2.charAt(i) + "");
            int n3 = Integer.parseInt(s3.charAt(i) + "");
            int n4 = Integer.parseInt(s4.charAt(i) + "");
            if (n1 == 1) {
                res = x > 0 ? res + "E" : res + "W";
            }
            if (n2 == 1) {
                res = x > 0 ? res + "W" : res + "E";
            }
            if (n3 == 1) {
                res = y > 0 ? res + "N" : res + "S";
            }
            if (n4 == 1) {
                res = y > 0 ? res + "S" : res + "N";
            }
        }

        return res;
    }

    private static int log2(int num) {
        return (int) (Math.log(num) / Math.log(2));
    }

    private static void target(int target, Set<Integer> seen, int moves, int curr, int pow, String pos, String neg) {
        if (target == 0) {
            possible.add("0-0");
            return;
        }

        if (curr == target) {
            possible.add(pos + "-" + neg);
            return;
        }
        if (seen.contains(target)) {
            return;
        }
        if (moves >= max_moves) {
            return;
        }
        seen.add(curr);

        int next = (int)Math.pow(2, pow);
        target(target, seen, moves + 1, curr + next, pow + 1, "1" + pos, "0" + neg);
        target(target, seen, moves + 1, curr - next, pow + 1, "0" + pos, "1" + neg);
        target(target, seen, moves + 1, curr, pow + 1, "0" + pos, "0" + neg);
    }
}
