import java.util.*;

public class Solution_PascalWalk_James {
    static ArrayList<Map.Entry<Integer, Integer>> ans = null;
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();
            for (int i = 1; i <= t; ++i) {
                System.out.println("Case #" + i + ": ");
                ArrayList<Map.Entry<Integer, Integer>> start = new ArrayList<>();
                start.add(new AbstractMap.SimpleEntry<Integer, Integer>(1, 0));
                levels.put(1, new int[]{1});
                ans = null;
                isFindAns = false;
                travalTran(2, 0, 1, scanner.nextInt(), start, 2);
                printList(ans);
            }
        } catch (Exception e) {
        }
    }
    static boolean isFindAns = false;
    public static void printList(List<Map.Entry<Integer, Integer>> list) {
//        System.out.println("Start log list :");
        for (int i = 0; i < list.size(); i++) {
            Map.Entry<Integer, Integer> element = list.get(i);
            System.out.println(element.getKey() + "  " + (element.getValue() + 1));
        }
//        System.out.println();
//        System.out.println("End log list ====");
    }
    public static void print(String string) {
        System.out.println(string);
    }
    static Map<Integer, int[]> levels = new HashMap<>();
    int way = 0;
    // 0 right
    // 1 left
    // 2 down
    public static void travalTran(
            int level,
            int curIdx,
            int currentSum,
            int targetSum,
            ArrayList<Map.Entry<Integer, Integer>> ansMap,
            int way
    ) {
        if (isFindAns) return;
        if (currentSum == targetSum) {
            if (ans == null) {
                ans = new ArrayList<Map.Entry<Integer, Integer>>();
                ans.addAll(ansMap);
            } else if (ansMap.size() < ans.size()) {
                ans.clear();
                ans.addAll(ansMap);
            }
            if (ans.size() < 500) {
                isFindAns = true;
            }
            return;
        }
        if (currentSum > targetSum) {
            return;
        }
        int[] currentArray = levels.get(level);
        if (currentArray == null) {
            int[] lastLevel = levels.get(level - 1);
            currentArray = new int[level];
            currentArray[0] = 1;
            currentArray[level - 1] = 1;
            for (int i = 1; i < level - 1; i++) {
                currentArray[i] = lastLevel[i - 1] + lastLevel[i];
            }
            levels.put(level, currentArray);
        }
        int sum = currentSum + currentArray[curIdx];
        ansMap.add(new AbstractMap.SimpleEntry<Integer, Integer>(level, curIdx));
        if (curIdx < level - 1 && way != 1)
            travalTran(level, curIdx + 1, sum, targetSum, ansMap, 0); //move right
        if (curIdx > 0 && way != 0)
            travalTran(level, curIdx - 1, sum, targetSum, ansMap, 1); //move left
        travalTran(level + 1, curIdx, sum, targetSum, ansMap, 2); //move down
        if (ansMap.size() > 0) {
            ansMap.remove(ansMap.size() - 1);
        }
        return;
    }
}