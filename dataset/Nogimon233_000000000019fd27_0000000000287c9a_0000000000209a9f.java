import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        //.out.println("codejam");
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 1; i <= t; ++i) {
            String s = in.next();
            String ans = solve(s);
            System.out.println("Case #" + i + ": " + ans);
        }
    }

    private static String solve(String s) {
        int n = s.length();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = s.charAt(i) - '0';
        }

        StringBuilder sb = new StringBuilder();
        int rank = 0;
        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            if (curr > rank) {
                for (int j = 0; j < curr - rank; j++) {
                    sb.append('(');
                }
            } else if (curr < rank) {
                for (int j = 0; j < rank - curr; j++) {
                    sb.append(')');
                }
            }
            sb.append(curr);
            rank = curr;
        }
        while(rank > 0) {
            sb.append(')');
            rank--;
        }
        return sb.toString();

    }


}

/*
public class SolutionQ1 {
    public static void main(String[] args) {
        //.out.println("codejam");
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] nums = new int[n][n];
            for (int i1 = 0; i1 < n; i1++) {
                for (int i2 = 0; i2 < n; i2++) {
                    nums[i1][i2] = in.nextInt();
                }
            }
            int[] ans = solve(n, nums);
            System.out.println("Case #" + i + ": " + ans[0] + " " + ans[1] + " " + ans[2]);
        }
    }

    private static int[] solve(int n, int[][] nums) {
        //row
        int row = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (set.contains(nums[i][j])) {
                    row++;
                    break;
                }
                set.add(nums[i][j]);
            }
        }
        int col = 0;
        for (int j = 0; j < n; j++) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (set.contains(nums[i][j])) {
                    col++;
                    break;
                }
                set.add(nums[i][j]);
            }
        }

        //trace
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += nums[i][i];
        }

        return new int[] {trace, row, col};

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