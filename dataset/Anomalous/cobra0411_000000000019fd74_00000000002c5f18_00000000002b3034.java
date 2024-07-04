import java.util.*;

public class Solution {
    private static List<Map.Entry<Integer, Integer>> ans = null;
    private static boolean isFindAns = false;
    private static final Map<Integer, int[]> levels = new HashMap<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int i = 1; i <= t; i++) {
                System.out.println("Case #" + i + ": ");
                List<Map.Entry<Integer, Integer>> start = new ArrayList<>();
                start.add(new AbstractMap.SimpleEntry<>(1, 0));
                levels.put(1, new int[]{1});
                ans = null;
                isFindAns = false;
                traverse(2, 0, 1, scanner.nextInt(), start, 2);
                printList(ans);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printList(List<Map.Entry<Integer, Integer>> list) {
        list.forEach(entry -> System.out.println(entry.getKey() + "  " + (entry.getValue() + 1)));
    }

    private static void traverse(int level, int curIdx, int currentSum, int targetSum, List<Map.Entry<Integer, Integer>> path, int direction) {
        if (isFindAns) return;

        if (currentSum == targetSum) {
            if (ans == null || path.size() < ans.size()) {
                ans = new ArrayList<>(path);
            }
            if (ans.size() < 500) {
                isFindAns = true;
            }
            return;
        }

        if (currentSum > targetSum) return;

        int[] currentArray = levels.computeIfAbsent(level, k -> {
            int[] prevLevel = levels.get(level - 1);
            int[] newArray = new int[level];
            newArray[0] = 1;
            newArray[level - 1] = 1;
            for (int i = 1; i < level - 1; i++) {
                newArray[i] = prevLevel[i - 1] + prevLevel[i];
            }
            return newArray;
        });

        int newSum = currentSum + currentArray[curIdx];
        path.add(new AbstractMap.SimpleEntry<>(level, curIdx));

        if (curIdx < level - 1 && direction != 1) traverse(level, curIdx + 1, newSum, targetSum, path, 0); // move right
        if (curIdx > 0 && direction != 0) traverse(level, curIdx - 1, newSum, targetSum, path, 1); // move left
        traverse(level + 1, curIdx, newSum, targetSum, path, 2); // move down

        if (!path.isEmpty()) {
            path.remove(path.size() - 1);
        }
    }
}