import java.util.*;

public class Solution {
    private static final Map<Integer, List<int[]>> dp = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        
        for (int i = 0; i < testCaseCount; i++) {
            int r = scanner.nextInt();
            int s = scanner.nextInt();
            List<int[]> results = computeResults(r, s);
            
            System.out.println("Case #" + (i + 1) + ": " + results.size());
            for (int[] result : results) {
                System.out.println(result[0] + " " + result[1]);
            }
        }
    }

    private static List<int[]> computeResults(int r, int s) {
        if (r == 1) {
            return new LinkedList<>();
        }

        int key = r * 100 + s;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        List<int[]> results = new LinkedList<>();
        for (int i = 1; i < s; i++) {
            results.add(new int[]{r * i, r - 1});
        }

        List<int[]> previousResults = computeResults(r - 1, s);
        results.addAll(previousResults);
        dp.put(key, results);

        return results;
    }
}