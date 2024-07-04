import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            Integer[] indices = new Integer[n];
            char[] result = new char[n];
            boolean isPossible = true;

            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                indices[i] = i;
            }

            Arrays.sort(indices, Comparator.comparingInt(i -> intervals[i][0]));

            TreeSet<Integer> cSet = new TreeSet<>();
            TreeSet<Integer> jSet = new TreeSet<>();

            for (int i : indices) {
                int start = intervals[i][0];
                int end = intervals[i][1];

                if (cSet.floor(start - 1) == null || cSet.ceiling(end) == null) {
                    result[i] = 'C';
                    cSet.add(start);
                    cSet.add(end - 1);
                } else if (jSet.floor(start - 1) == null || jSet.ceiling(end) == null) {
                    result[i] = 'J';
                    jSet.add(start);
                    jSet.add(end - 1);
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + t + ": " + new String(result));
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}