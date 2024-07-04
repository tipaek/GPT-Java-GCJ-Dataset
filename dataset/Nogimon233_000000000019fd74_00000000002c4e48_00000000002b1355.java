import java.util.*;
import java.io.*;

public class Solution {

    static int ans = 0;
    static int[] dir1 = {1,-1,0,0};
    static int[] dir2 = {0, 0, 1, -1};
    public static void main(String[] args) {
        //.out.println("codejam");
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 1; i <= t; ++i) {
            int r = in.nextInt();
            int c = in.nextInt();
            int[][] nums = new int[r][c];
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    nums[j][k] = in.nextInt();
                }
            }
            String ans = solve(nums);
            System.out.println("Case #" + i + ": " + ans);
        }
    }

    private static String solve(int[][] nums) {
        ans = 0;
        boolean result = true;
        while(result) {
            result = round(nums);
            // (int i = 0; i < nums.length; i++) {System.out.println(Arrays.toString(nums[i])); }
            //System.out.println(ans);
        }
        return String.valueOf(ans);
    }

    private static boolean round(int[][] nums) {
        int r = nums.length;
        int c = nums[0].length;
        int[][] ave = new int[r][c];
        int[][] time = new int[r][c];
        for (int i = 1; i < r-1; i++) {
            for (int j = 1; j < c-1; j++) {
                time[i][j] = 4;
            }
        }
        for (int i = 1; i < r-1; i++) {
            time[i][0] = 3;
            time[i][c-1] = 3;
        }
        for (int j = 1; j < c-1; j++) {
            time[0][j] = 3;
            time[r-1][j] = 3;
        }
        time[0][0] = 2;
        time[0][c-1] = 2;
        time[r-1][0] = 2;
        time[r-1][c-1] = 2;

        int sum = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (nums[i][j] != -1) {
                    sum += nums[i][j];
                    add(nums, ave, time, i, j);
                }
            }
        }
        ans += sum;

        boolean change = false;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (time[i][j] == 0 || nums[i][j] == -1) {
                    continue;
                }
                if (nums[i][j] * time[i][j] < ave[i][j]) {
                    nums[i][j] = -1;
                    change = true;
                }
            }
        }
        return change;

    }

    private static void add(int[][] nums, int[][] ave, int[][] time, int i, int j) {
        time[i][j] = 4;
        boolean found = false;
        for (int ii = i-1; ii >= 0; ii--) {
            if (nums[ii][j] != -1) {
                ave[ii][j] += nums[i][j];
                found = true;
                break;
            }
        }
        if (!found) {
            time[i][j]--;
        }

        found = false;
        for (int ii = i+1; ii < nums.length; ii++) {
            if (nums[ii][j] != -1) {
                ave[ii][j] += nums[i][j];
                found = true;
                break;
            }
        }
        if (!found) {
            time[i][j]--;
        }

        found = false;
        for (int jj = j-1; jj >= 0; jj--) {
            if (nums[i][jj] != -1) {
                ave[i][jj] += nums[i][j];
                found = true;
                break;
            }
        }
        if (!found) {
            time[i][j]--;
        }

        found = false;
        for (int jj = j+1; jj < nums[0].length; jj++) {
            if (nums[i][jj] != -1) {
                ave[i][jj] += nums[i][j];
                found = true;
                break;
            }
        }
        if (!found) {
            time[i][j]--;
        }

    }

}

/*
public class Solution {

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
            System.out.println("Case #" + i + ":\n" + ans);
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
        sb.deleteCharAt(sb.length()-1);
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

            sofar += key;
            //System.out.println("visit " + r + " " + key + " sofar " +sofar);
            key++;
            sb.append(r);
            sb.append(' ');
            sb.append(2);
            sb.append('\n');
            r++;
        }

        if (sofar < n) {
            r--;
            sb.append(r);
            sb.append(' ');
            sb.append(1);
            sb.append('\n');
            sofar += 1;
        }

        while(sofar < n) {
            r++;
            sb.append(r);
            sb.append(' ');
            sb.append(1);
            sb.append('\n');
            sofar += 1;
            //System.out.println("visit " + r + " sofar " +sofar);
        }

        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }



}
*/

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
