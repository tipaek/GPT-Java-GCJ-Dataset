import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static class Input {
        long req;
        String res;

        public Input(long req, String res) {
            this.req = req;
            this.res = res;
        }
    }

    private static boolean isValid(String s, List<Input> inputs) {
        final Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            charMap.put(s.charAt(i), i);
        }

        for (Input i : inputs) {
            if (i.res.charAt(0) == s.charAt(0)) return false;

            long m = (long)Math.pow(10, i.res.length() - 1);
            long res = 0;
            for (int c = 0; c < i.res.length(); c++) {
                res += (charMap.get(i.res.charAt(c)) * m);
                m /= 10;
            }

            if (res > i.req) {
                return false;
            }
        }

        return true;
    }

    private static String compString(String s, List<Input> inputs) {
        char[] a = s.toCharArray();
        int n = a.length;
        int[] p = new int[n];
        int i = 1;
        while (i < n) {
            if (p[i] < i) {
                int j = ((i % 2) == 0) ? 0 : p[i];
                swap(a, i, j);
                String perm = String.valueOf(a);
                if (perm.length() == 10 && isValid(perm, inputs)) {
                    return perm;
                }
                p[i]++;
                i = 1;
            }
            else {
                p[i] = 0;
                i++;
            }
        }

        return "WRONG";
    }

    private static String toString(Set<Character> cs) {
        StringBuilder builder = new StringBuilder();
        for (char c : cs) {
            builder.append(c);
        }
        return builder.toString();
    }

    private static String digits(List<Input> inputs) {
        Set<Character> chars = new HashSet<>();

        for (Input in : inputs) {
            for (int c = 0; c < in.res.length(); c++) {
                chars.add(in.res.charAt(c));
                if (chars.size() == 10) {
                    return toString(chars);
                }
            }
        }

        return "ABCDEFGHIJ";
    }

    private static String digitString(List<Input> inputs) {
        String digits = digits(inputs);
        return compString(digits, inputs);
    }

    private static void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine().trim());

        List<Input> input = new ArrayList<>();
        for (int testCase = 1; testCase <= t; ++testCase) {
            int u = Integer.parseInt(in.nextLine().trim());
            for (int s = 1; s <= 10000; s++) {
                input.add(new Input(
                        in.nextLong(),
                        in.nextLine().trim()
                ));
            }

            System.out.println(String.format("Case #%d: %s", testCase, digitString(input).toUpperCase()));
        }
    }
}
