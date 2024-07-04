import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[][] intervals = new int[N][2];
            char[] assignments = new char[N];
            String result = "";
            boolean isImpossible = false;

            List<Set<Integer>> same = new LinkedList<>();
            List<Set<Integer>> different = new LinkedList<>();
            List<int[]> threeOverlaps = new LinkedList<>();
            List<int[]> twoOverlaps = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
            }

            for (int i = 0; i < N; i++) {
                int overlapCount = 1;
                List<Integer> overlappingTasks = new LinkedList<>();
                for (int j = 0; j < N; j++) {
                    if (j != i && isOverlapping(intervals[i], intervals[j])) {
                        overlapCount++;
                        overlappingTasks.add(j);
                    }
                }

                if (overlapCount > 3) {
                    result = "IMPOSSIBLE";
                    isImpossible = true;
                    break;
                } else if (overlapCount == 3) {
                    int[] task1 = intervals[overlappingTasks.get(0)];
                    int[] task2 = intervals[overlappingTasks.get(1)];
                    if (task1[1] <= task2[0] || task1[0] >= task2[1]) {
                        threeOverlaps.add(new int[]{i, overlappingTasks.get(0), overlappingTasks.get(1)});
                    } else {
                        result = "IMPOSSIBLE";
                        isImpossible = true;
                        break;
                    }
                } else if (overlapCount == 2) {
                    twoOverlaps.add(new int[]{i, overlappingTasks.get(0)});
                }
            }

            if (!isImpossible) {
                processOverlaps(same, different, threeOverlaps, twoOverlaps);
                assignments[0] = 'C';
                assignTasks(assignments, same, different, N);
                result = buildResult(assignments);
            }

            System.out.println("Case #" + test_case + ": " + result);
        }
        sc.close();
    }

    private static boolean isOverlapping(int[] task1, int[] task2) {
        return (task2[0] >= task1[0] && task2[0] < task1[1]) || (task2[1] > task1[0] && task2[1] <= task1[1]);
    }

    private static void processOverlaps(List<Set<Integer>> same, List<Set<Integer>> different, List<int[]> threeOverlaps, List<int[]> twoOverlaps) {
        for (int[] overlap : threeOverlaps) {
            Set<Integer> set1 = new HashSet<>(Arrays.asList(overlap[1], overlap[2]));
            Set<Integer> set2 = new HashSet<>(Arrays.asList(overlap[0], overlap[1]));
            Set<Integer> set3 = new HashSet<>(Arrays.asList(overlap[0], overlap[2]));
            same.add(set1);
            different.add(set2);
            different.add(set3);
        }

        for (int[] overlap : twoOverlaps) {
            Set<Integer> set = new HashSet<>(Arrays.asList(overlap[0], overlap[1]));
            different.add(set);
        }
    }

    private static void assignTasks(char[] assignments, List<Set<Integer>> same, List<Set<Integer>> different, int N) {
        for (int i = 0; i < N; i++) {
            if (!same.isEmpty()) {
                for (Set<Integer> set : same) {
                    if (set.contains(i)) {
                        for (int task : set) {
                            if (task != i) {
                                assignments[task] = assignments[i] == 'C' ? 'C' : 'J';
                            }
                        }
                    }
                }
            }

            if (!different.isEmpty()) {
                for (Set<Integer> set : different) {
                    if (set.contains(i)) {
                        for (int task : set) {
                            if (task != i) {
                                assignments[task] = assignments[i] == 'C' ? 'J' : 'C';
                            }
                        }
                    }
                }
            }
        }
    }

    private static String buildResult(char[] assignments) {
        StringBuilder result = new StringBuilder();
        for (char c : assignments) {
            result.append(c == 0 ? 'C' : c);
        }
        return result.toString();
    }
}