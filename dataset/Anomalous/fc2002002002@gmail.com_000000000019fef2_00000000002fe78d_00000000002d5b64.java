import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            int r = scanner.nextInt();
            int s = scanner.nextInt();
            List<int[]> result = compute(r, s);
            
            System.out.println("Case #" + (i + 1) + ": " + result.size());
            for (int[] pair : result) {
                System.out.println(pair[0] + " " + pair[1]);
            }
        }
    }

    private static Map<Integer, List<int[]>> memoization = new HashMap<>();

    private static List<int[]> compute(int r, int s) {
        if (r == 1) {
            return new LinkedList<>();
        }

        int key = r * 100 + s;
        if (memoization.containsKey(key)) {
            return memoization.get(key);
        }

        List<int[]> result = new LinkedList<>();
        for (int i = s - 1; i > 0; i--) {
            result.add(new int[]{r * i - 1, 1});
        }

        result.addAll(compute(r - 1, s));
        memoization.put(key, result);

        return result;
    }
}