import java.util.*;
import java.io.*;

public class Solution {
    static List<Long> list1;
    static List<String> list2;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("sample.in.txt"));
        PrintWriter out = new PrintWriter(System.out);

        int pi = in.nextInt();
        for (int qi = 1; qi <= pi; qi++) {
            list1 = new ArrayList<>();
            list2 = new ArrayList<>();

            int u = in.nextInt();
            for (int i = 0; i < 10000; i++) {
                list1.add(in.nextLong());
                list2.add(in.next());
            }

            String ans;
            if (list1.get(0) < 0) {
                ans = solve3();
            } else {
                ans = solve12();
            }
            out.printf("Case #%d: %s\n", qi, ans);
        }

        out.close();
    }

    public static String solve3() {
        Set<Character> all = new HashSet<>();
        Set<Character> not0 = new HashSet<>();

        for (String sstr : list2) {
            for (char ch : sstr.toCharArray()) {
                all.add(ch);
            }
            not0.add(sstr.charAt(0));
        }

        char[] ans = new char[10];
        int index = 0;
        for (char ch : all) {
            ans[index++] = ch;
        }

        while (index < 10) {
            for (char ch = 'A'; ch <= 'Z'; ch++) {
                if (!all.contains(ch)) {
                    ans[index++] = ch;
                    all.add(ch);
                    break;
                }
            }
        }

        for (int i = 1; i < 10; i++) {
            if (!not0.contains(ans[i])) {
                char tmp = ans[i];
                ans[i] = ans[0];
                ans[0] = tmp;
                break;
            }
        }

        return String.valueOf(ans);
    }

    public static String solve12() {
        List<Integer> constInts = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        Map<Character, Set<Integer>> possible = new HashMap<>();

        for (int i = 0; i < list1.size(); i++) {
            String istr = list1.get(i).toString();
            String sstr = list2.get(i);

            for (char ch : sstr.toCharArray()) {
                possible.computeIfAbsent(ch, k -> new HashSet<>(constInts));
            }

            char ch = sstr.charAt(0);
            if (istr.length() == sstr.length()) {
                for (int j = istr.charAt(0) - '0' + 1; j < 10; j++) {
                    possible.get(ch).remove(j);
                }
            }
            possible.get(ch).remove(0);
        }

        char[] ans = solve(possible);
        return String.valueOf(ans);
    }

    public static char[] solve(Map<Character, Set<Integer>> possible) {
        char[] ans = new char[10];
        List<Character> list = new ArrayList<>(possible.keySet());
        dfs(possible, ans, list, 0);
        return ans;
    }

    public static boolean dfs(Map<Character, Set<Integer>> possible, char[] ans, List<Character> list, int pos) {
        if (pos == 10) {
            return check(ans);
        }
        char ch = list.get(pos);
        for (int i : possible.get(ch)) {
            if (ans[i] == 0) {
                ans[i] = ch;
                if (dfs(possible, ans, list, pos + 1)) {
                    return true;
                }
                ans[i] = 0;
            }
        }
        return false;
    }

    public static boolean check(char[] ans) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(ans[i], (char) (i + '0'));
        }

        for (int i = 0; i < list1.size(); i++) {
            long k = list1.get(i);
            String sstr = list2.get(i);
            char[] a = new char[sstr.length()];

            for (int j = 0; j < sstr.length(); j++) {
                a[j] = map.get(sstr.charAt(j));
            }

            long k2 = Long.parseLong(String.valueOf(a));
            if (k2 > k) {
                return false;
            }
        }

        return true;
    }
}