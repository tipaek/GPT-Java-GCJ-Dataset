import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] l = new int[n];
            int[] r = new int[n];
            Integer[] indices = new Integer[n];

            for (int i = 0; i < n; i++) {
                l[i] = sc.nextInt();
                r[i] = sc.nextInt();
                indices[i] = i;
            }

            Arrays.sort(indices, Comparator.comparingInt(i -> l[i]));

            int[] dutyEndTime = new int[2];
            char[] schedule = new char[n];
            boolean impossible = false;

            for (int i = 0; i < n; i++) {
                int idx = indices[i];
                if (l[idx] >= dutyEndTime[0]) {
                    dutyEndTime[0] = r[idx];
                    schedule[idx] = 'C';
                } else if (l[idx] >= dutyEndTime[1]) {
                    dutyEndTime[1] = r[idx];
                    schedule[idx] = 'J';
                } else {
                    impossible = true;
                    break;
                }
            }

            String result = impossible ? "IMPOSSIBLE" : new String(schedule);
            System.out.println("Case #" + caseNumber++ + ": " + result);
        }

        sc.close();
    }
}