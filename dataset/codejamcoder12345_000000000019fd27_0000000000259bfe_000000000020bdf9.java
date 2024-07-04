import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int caseNum = 0; caseNum < t; caseNum++) {
            int n = in.nextInt();
            Map<Integer, Set<Integer>> starts = new HashMap<Integer, Set<Integer>>();
            Map<Integer, Set<Integer>> ends = new HashMap<Integer, Set<Integer>>();
            NavigableSet<Integer> all = new TreeSet<Integer>();
            int C = -1;
            int J = -1;
            char[] assignments = new char[n];
            boolean impossible = false;
            for (int i = 0; i < n; i++) {
                int s = in.nextInt();
                int e = in.nextInt();
                if (!starts.containsKey(s)) {
                    starts.put(s, new HashSet<Integer>());
                }
                if (starts.get(s).size() == 2) {
                    impossible = true;
                    break;
                }
                starts.get(s).add(i);
                if (!ends.containsKey(e)) {
                    ends.put(e, new HashSet<Integer>());
                }
                if (ends.get(e).size() == 2) {
                    impossible = true;
                    break;
                }
                ends.get(e).add(i);
                if (!all.contains(s)) {
                    all.add(s);
                }
                if (!all.contains(e)) {
                    all.add(e);
                }
            }
            for (Integer j : all) {
                if (ends.containsKey(j)) {
                    for (Integer k : ends.get(j)) {
                        if (C == k) {
                            C = -1;
                        }
                        if (J == k) {
                            J = -1;
                        }
                    }
                }
                if (starts.containsKey(j)) {
                    for (Integer k : starts.get(j)) {
                        if (C == -1) {
                            assignments[k] = 'C';
                            C = k;
                        } else if (J == -1) {
                            assignments[k] = 'J';
                            J = k;
                        } else {
                            impossible = true;
                            break;
                        }
                    }
                }
            }
            if (impossible) {
                System.out.println("Case #" + String.valueOf(caseNum+1) + ": IMPOSSIBLE");
            } else {
                for (int i = 0; i < n; i++) {
                    if (assignment[i] == '\0') {
                        System.out.println("What?");
                    }
                }
                System.out.print("Case #" + String.valueOf(caseNum+1) + ": ");
                for (int i = 0; i < n; i++) {
                    System.out.print(String.valueOf(assignments[i]));
                }
                System.out.println();
            }
        }
    }
}