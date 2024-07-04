import java.util.*;
import java.io.*;

public class Solution {

    /*
    static Map<String, Map<Integer, List<String>>> map = new HashMap<>();
    static Map<Integer, String> endpoint = new HashMap<>();
    //static Map<String, Integer> pascal = new HashMap<>();
    static int[][] pascal;
    static int[] dir1 = {-1, -1, 0, 0, 1, 1};
    static int[] dir2 = {-1, 0, -1, 1, 0, 1};


     */
    public static void main(String[] args) {
        //.out.println("codejam");
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        //pascal.put("1#1", 1);
//        pascal = new int[1001][1001];
//        buildP(1000);
//        dfs("1#1", 1000, 0, new ArrayList<>());

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            String ans;
            if (n <= 500) {
                ans = solve2(n);
            } else {
                ans = solve3(n);
            }
            System.out.print("Case #" + i + ":\n" + ans);
        }
    }

    private static String solve2(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(i);
            sb.append(' ');
            sb.append(1);
            sb.append('\n');
        }
        return sb.toString();
    }

    private static String solve3(int n) {
        StringBuilder sb = new StringBuilder();
        int sofar = 0;
        int key = 1;
        //first two point
        sb.append("1 1\n");
        sb.append("2 1\n");
        sofar = 2;
        key = 2;
        int r = 3;
        while(true) {
            if (key + sofar > n) {
                break;
            }
            //System.out.println("visit " + r + " " + key + " sofar " +sofar);
            sofar += key;
            key++;
            sb.append(r);
            sb.append(' ');
            sb.append(2);
            sb.append('\n');
            r++;
        }

        sb.append(r);
        sb.append(' ');
        sb.append(1);
        sb.append('\n');
        sofar += 1;

        while(sofar < n) {
            r++;
            sb.append(r);
            sb.append(' ');
            sb.append(1);
            sb.append('\n');
            sofar += 1;
            //System.out.println("visit " + r + " sofar " +sofar);
        }

        return sb.toString();
    }

    /*
    private static String solve(int n) {
        String loc = endpoint.get(n);
        List<String> list = map.get(loc).get(n);

        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s.replace('#', ' '));
            sb.append('\n');
        }
        return sb.toString();



    }

    private static void buildP(int n) {

        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= i; k++) {
                int key = 0;
                if (i == 1 || k == i) {
                    key = 1;
                } else {
                    key = pascal[i-1][k-1] + pascal[i-1][k];
                }
                pascal[i][k] = key;
            }
        }
    }

    private static void dfs(String loc, int n, int sofar, List<String> path) {
        if (sofar > n) {
            return;
        }
        if (!map.containsKey(loc)) {
            map.put(loc, new HashMap<Integer, List<String>>());
        }
        Map<Integer, List<String>> curr = map.get(loc);

        //already visit this point with this number
        if (curr.containsKey(sofar)) {
            return;
        } else { //record this path
            endpoint.put(sofar, loc);
            curr.put(sofar, new ArrayList<>(path));
        }

        String[] ss = loc.split("#");
        int r = Integer.parseInt(ss[0]);
        int k = Integer.parseInt(ss[1]);
        int key = pascal[r][k];

        path.add(loc);
        for (int i = 0; i < 6; i++) {
            int newr = r + dir1[i];
            int newk = k + dir2[i];
            if (newr < 1 || newk < 1 || newr > n || newk > newr) {
                continue;
            }
            String newloc = newr + "#" + newk;
            if (path.contains(newloc)) {
                continue;
            }
            dfs(newloc, n, sofar + key, path);
        }
        path.remove(path.size()-1);


    }

*/

}


/*
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
*/


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
