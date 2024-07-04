import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int c = 1; c <= t; c++) {
            int n = sc.nextInt();
            boolean isPossible = true;
            StringBuilder result = new StringBuilder();
            List<int[]> intervals = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                intervals.add(new int[]{start, end, i});
            }

            intervals.sort(Comparator.comparingInt(a -> a[0]));

            int[] je = {0, 0};
            int[] ce = {0, 0};
            char[] assignment = new char[n];

            for (int[] interval : intervals) {
                int start = interval[0];
                int end = interval[1];
                int index = interval[2];

                if (start >= je[1]) {
                    je[0] = start;
                    je[1] = end;
                    assignment[index] = 'J';
                } else if (start >= ce[1]) {
                    ce[0] = start;
                    ce[1] = end;
                    assignment[index] = 'C';
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                for (char ch : assignment) {
                    result.append(ch);
                }
                System.out.println("Case #" + c + ": " + result.toString());
            } else {
                System.out.println("Case #" + c + ": IMPOSSIBLE");
            }
        }

        sc.close();
    }
}