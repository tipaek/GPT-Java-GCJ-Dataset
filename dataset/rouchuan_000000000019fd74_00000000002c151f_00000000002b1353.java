import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();
        for (int i = 0; i < tests; i++) {
            helper(i + 1, in.nextInt());
        }
    }

    public static void helper(int id, int N) {
        System.out.println("Case #" + id + ":");
        LinkedList<int[]> ans = new LinkedList<>();
        ArrayList<int[]> pascal = new ArrayList<>();
        pascal.add(new int[1]);
        dfs(1, 1, new HashSet<>(), ans, N, pascal);
        for (int[] item : ans) {
            System.out.println(item[0] + " " + item[1]);
        }
    }

    public static boolean dfs(int x, int y, HashSet<String> set, LinkedList<int[]> ans, int remain, ArrayList<int[]> pascal) {
        if (x <= 0 || y > x || y <= 0) return false;
        String key = "r" + x + "c" + y;
        if (set.contains(key)) return false;

        if (pascal.size() == x) {
            int[] lastRow = pascal.get(x - 1);
            int[] currentRow = new int[x];
            currentRow[0] = 1;
            currentRow[x - 1] = 1;
            for (int i = 1; i < x - 1; i++) {
                currentRow[i] = lastRow[i - 1] + lastRow[i];
            }
            pascal.add(currentRow);
        }

        int[] currentRow = pascal.get(x);
        remain -= currentRow[y - 1];
        if (remain < 0) return false;
        ans.add(new int[]{x, y});
        if (remain == 0) return true;
        set.add(key);

        int mid = (1 + currentRow.length + 1) / 2;

        if (Math.abs((y + 1 - mid)) < Math.abs(y - mid)) {
            if (dfs(x + 1, y + 1, set, ans, remain, pascal)) return true;
            if (dfs(x + 1, y, set, ans, remain, pascal)) return true;
        } else {
            if (dfs(x + 1, y, set, ans, remain, pascal)) return true;
            if (dfs(x + 1, y + 1, set, ans, remain, pascal)) return true;
        }

        if (dfs(x, y + 1, set, ans, remain, pascal)) return true;
        if (dfs(x, y - 1, set, ans, remain, pascal)) return true;

        if (dfs(x - 1, y, set, ans, remain, pascal)) return true;
        if (dfs(x - 1, y - 1, set, ans, remain, pascal)) return true;
        ans.removeLast();
        set.remove(key);
        return false;
    }
}