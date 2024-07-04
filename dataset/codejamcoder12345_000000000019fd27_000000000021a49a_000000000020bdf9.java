import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int caseNum = 0; caseNum < t; caseNum++) {
            int n = in.nextInt();
            Map<Integer, HashSet<Integer>> starts = new HashMap<Integer, HashSet<Integer>>();
            Map<Integer, HashSet<Integer>> ends = new HashMap<Integer, HashSet<Integer>>();
            Map<Integer, HashSet<Integer>> mids = new HashMap<Integer, HashSet<Integer>>();
            NavigableSet<Integer> all = new TreeSet<Integer>();
            int[] assignments = new int[n];
            for (int i = 0; i < n; i++) {
                int s = in.nextInt();
                int e = in.nextInt();
                if (starts.containsKey(s)) {
                    starts.get(s).add(i);
                } else {
                    starts.put(s, new HashSet<Integer>());
                    starts.get(s).add(i);
                }
                if (ends.containsKey(e)) {
                    ends.get(e).add(i);
                } else {
                    ends.put(e, new HashSet<Integer>());
                    ends.get(e).add(i);
                }
                if (!all.contains(s)) {
                    all.add(s);
                }
                if (!all.contains(e)) {
                    all.add(e);
                }
                for (Integer j : all.subset(s, false, e, false)) {
                    if (mids.containsKey(j)) {
                        mids.get(j).add(i);
                    } else {
                        mids.put(j, new HashSet<Integer>());
                        mids.get(j).add(i);
                    }
                }
            }
        }
    }
}