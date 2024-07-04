import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = scanner.nextInt();
            int[][] time = new int[n][2];
            int[][] originalTime = new int[n][2];

            for (int i = 0; i < n; i++) {
                time[i][0] = scanner.nextInt();
                time[i][1] = scanner.nextInt();
                originalTime[i][0] = time[i][0];
                originalTime[i][1] = time[i][1];
            }

            Arrays.sort(time, Comparator.comparingInt(a -> a[0]));

            HashMap<String, ArrayList<Integer>> scheduleMap = new HashMap<>();
            boolean isPossible = true;

            for (int i = 0; i < n; i++) {
                if (!assignTask(scheduleMap, "J", time, i) && !assignTask(scheduleMap, "C", time, i)) {
                    isPossible = false;
                    break;
                }
            }

            String[] result = new String[n];
            if (isPossible) {
                fillResult(scheduleMap, result, "C");
                fillResult(scheduleMap, result, "J");

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (originalTime[i][0] == time[j][0] && originalTime[i][1] == time[j][1]) {
                            result[i] = result[j];
                            break;
                        }
                    }
                }
            }

            String output = isPossible ? String.join("", result) : "IMPOSSIBLE";
            System.out.println("Case #" + caseNumber++ + ": " + output);
        }
    }

    private static boolean assignTask(HashMap<String, ArrayList<Integer>> map, String person, int[][] time, int index) {
        map.putIfAbsent(person, new ArrayList<>());
        ArrayList<Integer> tasks = map.get(person);

        for (int task : tasks) {
            if (overlaps(time[task], time[index])) {
                return false;
            }
        }

        tasks.add(index);
        return true;
    }

    private static boolean overlaps(int[] task1, int[] task2) {
        return task1[1] > task2[0] && task2[1] > task1[0];
    }

    private static void fillResult(HashMap<String, ArrayList<Integer>> map, String[] result, String person) {
        if (map.containsKey(person)) {
            for (int index : map.get(person)) {
                result[index] = person;
            }
        }
    }
}