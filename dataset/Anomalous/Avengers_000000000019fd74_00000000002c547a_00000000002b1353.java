import java.util.*;

public class Solution {
    private static List<Map.Entry<Integer, Integer>> answer = null;
    private static boolean isAnswerFound = false;
    private static final Map<Integer, int[]> levels = new HashMap<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int i = 1; i <= t; ++i) {
                System.out.println("Case #" + i + ": ");
                List<Map.Entry<Integer, Integer>> initialPath = new ArrayList<>();
                initialPath.add(new AbstractMap.SimpleEntry<>(1, 0));
                levels.put(1, new int[]{1});
                answer = null;
                isAnswerFound = false;
                traversePath(2, 0, 1, scanner.nextInt(), initialPath, 2);
                printPath(answer);
            }
        } catch (Exception e) {
            // Handle exception if needed
        }
    }

    private static void printPath(List<Map.Entry<Integer, Integer>> path) {
        for (Map.Entry<Integer, Integer> entry : path) {
            System.out.println(entry.getKey() + " " + (entry.getValue() + 1));
        }
    }

    private static void traversePath(int level, int currentIndex, int currentSum, int targetSum, List<Map.Entry<Integer, Integer>> currentPath, int direction) {
        if (isAnswerFound) return;

        if (currentSum == targetSum) {
            if (answer == null || currentPath.size() < answer.size()) {
                answer = new ArrayList<>(currentPath);
            }
            if (answer.size() < 500) {
                isAnswerFound = true;
            }
            return;
        }

        if (currentSum > targetSum) {
            return;
        }

        int[] currentLevelArray = levels.computeIfAbsent(level, k -> {
            int[] previousLevel = levels.get(level - 1);
            int[] newLevel = new int[level];
            newLevel[0] = newLevel[level - 1] = 1;
            for (int i = 1; i < level - 1; i++) {
                newLevel[i] = previousLevel[i - 1] + previousLevel[i];
            }
            return newLevel;
        });

        int newSum = currentSum + currentLevelArray[currentIndex];
        currentPath.add(new AbstractMap.SimpleEntry<>(level, currentIndex));

        if (currentIndex < level - 1 && direction != 1) {
            traversePath(level, currentIndex + 1, newSum, targetSum, currentPath, 0); // move right
        }
        if (currentIndex > 0 && direction != 0) {
            traversePath(level, currentIndex - 1, newSum, targetSum, currentPath, 1); // move left
        }
        traversePath(level + 1, currentIndex, newSum, targetSum, currentPath, 2); // move down

        if (!currentPath.isEmpty()) {
            currentPath.remove(currentPath.size() - 1);
        }
    }
}