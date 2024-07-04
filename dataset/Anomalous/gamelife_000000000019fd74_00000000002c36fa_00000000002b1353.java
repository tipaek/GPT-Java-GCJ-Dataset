import java.util.*;

public class Solution {
    private static ArrayList<Map.Entry<Integer, Integer>> result = null;
    private static boolean foundSolution = false;
    private static final Map<Integer, int[]> levels = new HashMap<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int i = 1; i <= testCases; ++i) {
                System.out.println("Case #" + i + ": ");
                ArrayList<Map.Entry<Integer, Integer>> initialPath = new ArrayList<>();
                initialPath.add(new AbstractMap.SimpleEntry<>(1, 0));
                levels.put(1, new int[]{1});
                result = null;
                foundSolution = false;
                traversePath(2, 0, 1, scanner.nextInt(), initialPath, 2);
                printPath(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printPath(List<Map.Entry<Integer, Integer>> path) {
        if (path != null) {
            for (Map.Entry<Integer, Integer> entry : path) {
                System.out.println(entry.getKey() + "  " + (entry.getValue() + 1));
            }
        }
    }

    private static void traversePath(int level, int index, int currentSum, int targetSum, 
                                     ArrayList<Map.Entry<Integer, Integer>> currentPath, int direction) {
        if (foundSolution) return;
        if (currentSum == targetSum) {
            if (result == null || currentPath.size() < result.size()) {
                result = new ArrayList<>(currentPath);
            }
            if (result.size() < 500) {
                foundSolution = true;
            }
            return;
        }
        if (currentSum > targetSum) return;

        int[] currentLevel = levels.computeIfAbsent(level, l -> {
            int[] previousLevel = levels.get(l - 1);
            int[] newLevel = new int[l];
            newLevel[0] = 1;
            newLevel[l - 1] = 1;
            for (int i = 1; i < l - 1; i++) {
                newLevel[i] = previousLevel[i - 1] + previousLevel[i];
            }
            return newLevel;
        });

        int newSum = currentSum + currentLevel[index];
        currentPath.add(new AbstractMap.SimpleEntry<>(level, index));

        if (index < level - 1 && direction != 1) {
            traversePath(level, index + 1, newSum, targetSum, currentPath, 0); // move right
        }
        if (index > 0 && direction != 0) {
            traversePath(level, index - 1, newSum, targetSum, currentPath, 1); // move left
        }
        traversePath(level + 1, index, newSum, targetSum, currentPath, 2); // move down

        if (!currentPath.isEmpty()) {
            currentPath.remove(currentPath.size() - 1);
        }
    }
}