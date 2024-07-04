import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCase = in.nextInt();
        for (int i = 0; i < numberOfTestCase; i++) {
            int n = in.nextInt();
            List<int[]> list = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                list.add(new int[]{in.nextInt(), in.nextInt(), j});
            }
            String result = solve(list);
            System.out.printf("CASE #%d: %s\n", i + 1, result);
        }


    }

    private static String solve(List<int[]> list) {
        list.sort((a, b) -> a[0] - b[0]);
        Set<int[]> J = new HashSet<>();
        Set<int[]> C = new HashSet<>();
        for (int[] e : list) {
            if (canPick(J, e[0], e[1])) {
                J.add(e);
            } else if (canPick(C, e[0], e[1])) {
                C.add(e);
            } else return "IMPOSSIBLE";
        }
        char[] result = new char[list.size()];
        for (int[] x : J) result[x[2]] = 'J';
        for (int[] x : C) result[x[2]] = 'C';
        return new String(result);


    }

    private static boolean canPick(Set<int[]> c, int start, int end) {
        for (int[] task : c) {
            if (start > task[0] && start < task[1]) return false;
            if (end > task[0] && end < task[1]) return false;
        }
        return true;
    }
}
