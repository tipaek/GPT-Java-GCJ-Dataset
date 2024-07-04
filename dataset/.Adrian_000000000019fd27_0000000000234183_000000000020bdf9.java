import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < amount; i++) {
            int n = scanner.nextInt();
            scanner.nextLine();

            List<List<Integer>> activities = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                List<Integer> activity = stringToIntegerList(scanner.nextLine(), 2);
                activity.add(j);
                activities.add(activity);
            }

            String solution = solve(activities);
            if (solution == null) solution = "IMPOSSIBLE";
            System.out.println("Case #" + (i + 1) + ": " + solution);
        }
    }

    private static String solve(List<List<Integer>> activities) {
        activities.sort((l0, l1) -> {
            int i0 = l0.get(0);
            int i1 = l1.get(0);
            return Integer.compare(i0, i1);
        });

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < activities.size(); i++) result.append("O");

        long end0 = -1;
        long end1 = -1;

        for (List<Integer> activity : activities) {
            int start = activity.get(0);
            if (start >= end0) {
                end0 = activity.get(1);
                result.setCharAt(activity.get(2), 'C');
            } else if (start >= end1) {
                end1 = activity.get(1);
                result.setCharAt(activity.get(2), 'J');
            } else {
                return null;
            }
        }

        return result.toString();
    }

    private static List<Integer> stringToIntegerList(String line, int n) {
        String[] parts = line.split(" ", n);
        return Arrays.stream(parts).map(Integer::parseInt).collect(Collectors.toList());
    }
}
