import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public boolean overlap(int[][] intervals, LinkedList<Integer>[] overlaps, int i, int j) {
        int[] interval1 = intervals[i];
        int[] interval2 = intervals[j];
        return !(interval1[1] <= interval2[0] || interval1[0] >= interval2[1]);
    }

    public boolean isPossible(int[][] intervals, LinkedList<Integer>[] overlaps, int idx) {
        if (overlaps[idx].size() >= 2) {
            for (int i = 0; i < overlaps[idx].size(); i++) {
                for (int j = i + 1; j < overlaps[idx].size(); j++) {
                    if (overlap(intervals, overlaps, overlaps[idx].get(i), overlaps[idx].get(j))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = scanner.nextInt();
            int[][] intervals = new int[N][2];
            char[] assignment = new char[N];
            LinkedList<HashSet<Integer>> sameSets = new LinkedList<>();
            LinkedList<HashSet<Integer>> diffSets = new LinkedList<>();
            LinkedList<LinkedList<Integer>> complexOverlaps = new LinkedList<>();
            LinkedList<int[]> tripleOverlaps = new LinkedList<>();
            LinkedList<int[]> doubleOverlaps = new LinkedList<>();
            boolean impossible = false;

            for (int i = 0; i < N; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            LinkedList<Integer>[] overlaps = new LinkedList[N];
            for (int i = 0; i < N; i++) {
                overlaps[i] = new LinkedList<>();
                for (int j = 0; j < N; j++) {
                    if (j != i && overlap(intervals, overlaps, i, j)) {
                        overlaps[i].add(j);
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                if (overlaps[i].size() >= 2) {
                    if (!solution.isPossible(intervals, overlaps, i)) {
                        impossible = true;
                        break;
                    } else {
                        LinkedList<Integer> list = new LinkedList<>();
                        list.add(i);
                        list.addAll(overlaps[i]);
                        complexOverlaps.add(list);
                    }
                } else if (overlaps[i].size() == 1) {
                    doubleOverlaps.add(new int[]{i, overlaps[i].get(0)});
                }
            }

            if (!impossible) {
                assignment[0] = 'C';
                for (int i = 0; i < N; i++) {
                    for (HashSet<Integer> set : diffSets) {
                        if (set.contains(i)) {
                            for (Integer other : set) {
                                if (!other.equals(i)) {
                                    if (assignment[i] == 0) {
                                        assignment[i] = '0';
                                        assignment[other] = '1';
                                    } else if (assignment[i] == 'C') {
                                        assignment[other] = 'J';
                                    } else if (assignment[i] == 'J') {
                                        assignment[other] = 'C';
                                    } else if (assignment[i] == '0') {
                                        assignment[other] = '1';
                                    } else if (assignment[i] == '1') {
                                        assignment[other] = '0';
                                    }
                                }
                            }
                        }
                    }
                }
            }

            StringBuilder answer = new StringBuilder();
            if (!impossible) {
                for (char c : assignment) {
                    if (c == 0) {
                        answer.append('C');
                    } else if (c == 'C' || c == 'J') {
                        answer.append(c);
                    } else if (c == '0') {
                        answer.append('C');
                    } else if (c == '1') {
                        answer.append('J');
                    }
                }
            } else {
                answer.append("IMPOSSIBLE");
            }

            System.out.println("Case #" + testCase + ": " + answer);
        }
        scanner.close();
    }
}