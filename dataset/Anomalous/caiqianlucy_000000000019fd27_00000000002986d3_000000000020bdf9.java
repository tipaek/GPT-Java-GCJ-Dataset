import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());

        for (int k = 1; k <= t; k++) {
            int n = Integer.parseInt(in.nextLine());
            List<int[]> c = new ArrayList<>();
            List<int[]> j = new ArrayList<>();
            StringBuilder res = new StringBuilder();

            for (int i = 0; i < n; i++) {
                String[] cur = in.nextLine().split("\\s");
                int start = Integer.parseInt(cur[0]);
                int end = Integer.parseInt(cur[1]);
                int[] time = new int[]{start, end};

                if (canInsert(c, time)) {
                    res.append('C');
                } else if (canInsert(j, time)) {
                    res.append('J');
                } else {
                    res = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println("Case #" + k + ": " + res.toString());
        }
    }

    public static boolean canInsert(List<int[]> list, int[] cur) {
        int start = cur[0], end = cur[1];

        for (int i = 0; i < list.size(); i++) {
            int[] next = list.get(i);
            if (start < next[0]) {
                if (end <= next[0]) {
                    list.add(i, new int[]{start, end});
                    return true;
                } else {
                    return false;
                }
            } else if (start < next[1]) {
                return false;
            }
        }

        if (!list.isEmpty()) {
            int[] last = list.get(list.size() - 1);
            if (last[1] == start) {
                list.set(list.size() - 1, new int[]{last[0], end});
                return true;
            }
        }

        list.add(new int[]{start, end});
        return true;
    }
}