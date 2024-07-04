import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            solution.processCase(i + 1, in);
        }
    }

    private void processCase(int t, Scanner in) {
        int n = in.nextInt();
        Map<Integer, Map<Integer, Integer>> values = new HashMap<>();
        values.put(1, new HashMap<>());
        values.get(1).put(1, 1);

        Set<String> result = dp(n, 1, 1, values, new LinkedHashSet<>());
        if(t != 1) {
            System.out.println();
        }
        System.out.println("Case #" + t + ":");
        int counter = 0;
        for (String s : result) {
            int underscoreIndex = s.indexOf('_');
            int val1 = Integer.parseInt(s.substring(0, underscoreIndex));
            int val2 = Integer.parseInt(s.substring(underscoreIndex + 1));
            System.out.print(val1 + " " + val2);
            if(++counter < result.size()) {
                System.out.println();
            }
        }
    }

    private Set<String> dp(int sum, int r, int k, Map<Integer, Map<Integer, Integer>> values, Set<String> visited) {
        String position = r + "_" + k;
        if (sum == 0 && visited.size() <= 500) {
            return visited;
        }
        if (sum < 0 || visited.size() == 501 || visited.contains(position) || !isValid(r, k)) {
            return null;
        }

        int value = getValue(values, r, k);
        visited.add(position);
        Set<String> newPath = dp(sum - value, r - 1, k - 1, values, new LinkedHashSet<>(visited));
        if (newPath != null) return newPath;
        newPath = dp(sum - value, r - 1, k, values, new LinkedHashSet<>(visited));
        if (newPath != null) return newPath;
        newPath = dp(sum - value, r, k - 1, values, new LinkedHashSet<>(visited));
        if (newPath != null) return newPath;
        newPath = dp(sum - value, r, k + 1, values, new LinkedHashSet<>(visited));
        if (newPath != null) return newPath;
        newPath = dp(sum - value, r + 1, k, values, new LinkedHashSet<>(visited));
        if (newPath != null) return newPath;
        newPath = dp(sum - value, r + 1, k + 1, values, new LinkedHashSet<>(visited));
        return newPath;
    }

    private boolean isValid(int r, int k) {
        return k >= 1 && k <= r;
    }

    private int getValue(Map<Integer, Map<Integer, Integer>> values, int r, int k) {
        if(k < 1 || k > r) {
            return 0;
        }
        if (values.containsKey(r) && values.get(r).containsKey(k)) {
            return values.get(r).get(k);
        } else {
            Map<Integer, Integer> prevRow = values.get(r - 1);
            prevRow.putIfAbsent(k - 1, getValue(values, r - 1, k - 1));
            int value1 = prevRow.get(k - 1);
            prevRow.putIfAbsent(k, getValue(values, r - 1, k));
            int value2 = prevRow.get(k);
            values.putIfAbsent(r, new HashMap<>());
            int result = value1 + value2;
            values.get(r).put(k, result);
            return result;
        }
    }
}
