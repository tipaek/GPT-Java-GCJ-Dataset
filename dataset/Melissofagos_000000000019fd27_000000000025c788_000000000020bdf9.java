import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {

    private static String parenting(int N, int[] start, int[] end, SortedMap<Integer, Integer> orderedByStart) {
        SortedMap<Integer, Character> orderedByActivity = new TreeMap<Integer, Character>();
        int endC = 0;
        int endJ = 0;
        for(int index: orderedByStart.values()) {
            if (endC <= start[index]) {
                orderedByActivity.put(index, 'C');
                endC = end[index];
            } else if (endJ <= start[index]) {
                orderedByActivity.put(index, 'J');
                endJ = end[index];
            } else {
                return "IMPOSSIBLE";
            }
        }
        StringBuffer result = new StringBuffer();
        for(Character c: orderedByActivity.values()) {
            result.append(c);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        // Read T
        int test_cases_T = in.nextInt();
        // For each testcase
        for(int tc = 1; tc <= test_cases_T; tc++) {
            // Read N
            int N = in.nextInt();
            int[] start = new int[N];
            int[] end = new int[N];
            SortedMap<Integer, Integer> orderedByStart = new TreeMap<Integer, Integer>();
            // Read Start and End times
            for (int i = 0; i < N; i++) {
                start[i] = in.nextInt();
                end[i] = in.nextInt();
                orderedByStart.put(start[i], i);
            }
            // Solve
            System.out.println("Case #"+tc+": "+parenting(N, start, end, orderedByStart));
        }
    }
}
