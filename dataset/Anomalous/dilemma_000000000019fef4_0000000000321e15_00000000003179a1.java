import java.util.*;
import java.io.*;

public class Solution {
    static List<Long> list1;
    static List<String> list2;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
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
            if (list1.get(0) == -1) {
                ans = solve3();
            } else {
                ans = solve12();
            }
            out.printf("Case #%d: %s\n", qi, ans);
        }

        out.close();
    }

    public static String solve3() {
        int n = list1.size();
        Set<Character> all = new HashSet<>();
        Set<Character> not0 = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String sstr = list2.get(i);
            for (char ch : sstr.toCharArray()) {
                all.add(ch);
            }
            not0.add(sstr.charAt(0));
        }

        char[] ans = new char[10];
        int index = 0;
        for (Character ch : all) {
            ans[index++] = ch;
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
        List<Integer> constInts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            constInts.add(i);
        }

        Map<Character, Set<Integer>> possible = new HashMap<>();

        int n = list1.size();
        for (int i = 0; i < n; i++) {
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
        for (Integer i : possible.get(ch)) {
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

        int n = list1.size();
        for (int i = 0; i < n; i++) {
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

    static class InputReader {
        BufferedReader br;
        StringTokenizer st;

        public InputReader(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public InputReader(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public boolean hasNext() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return false;
                st = new StringTokenizer(s);
            }
            return true;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}