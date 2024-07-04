import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        //.out.println("codejam");
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            String[] strings = new String[n];
            for (int j = 0; j < n; j++) {
                strings[j] = in.next();
            }
            String ans = solve(strings);
            System.out.println("Case #" + i + ": " + ans);
        }
    }

    private static String solve(String[] strings) {
        //System.out.println(Arrays.toString(strings));
        List<String> list = new ArrayList<>();
        List<String> first = new ArrayList<>();
        List<String> last = new ArrayList<>();
        for (String s : strings) {
            String[] ss = s.split("\\*");
            if (ss.length == 0) {
                continue;
            }
            boolean add1 = false;
            boolean add2 = false;
            if (ss[0].length() > 0) {
                first.add(ss[0]);
            }
            if (s.charAt(s.length()-1) != '*' && ss[ss.length-1].length() > 0) {
                last.add(ss[ss.length-1]);
            }


            for (int i = 1; i < ss.length-1; i++) {
                list.add(ss[i]);
            }
            if (s.charAt(s.length()-1) == '*') {
                list.add(ss[ss.length-1]);
            }
        }

        String begin = solve2(first);
        if (begin.equals("no"))
            return "*";

        String end = solve3(last);
        if (end.equals("no"))
            return "*";

        StringBuilder sb = new StringBuilder();
        //build(sb, list);
        for (String s : list) {
            sb.append(s);
        }

        return begin + sb.toString() + end;

    }

    //private static void build(StringBuilder sb, List<String[]> list) {

    //}

    private static String solve2(List<String> first) {
        String ans = "";
        for (String s : first) {
            if (ans.startsWith(s)) {
                continue;
            } else if (s.startsWith(ans)) {
                ans = s;
            } else {
                return "no";
            }
        }
        return ans;
    }

    private static String solve3(List<String> last) {
        String ans = "";
        for (String s : last) {
            if (ans.endsWith(s)) {
                continue;
            } else if (s.endsWith(ans)) {
                ans = s;
            } else {
                return "no";
            }
        }
        return ans;
    }
}



class TrieNode{
    char c;
    int count;
    TrieNode[] next;
    public TrieNode(char _c){
        c = _c;
        next = new TrieNode[26];
        count = 0;
    }
}
