import java.util.*;

public class Solution {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            solve(caseNum);
        }
    }

    private static void solve(int caseNum) {
        int rank = scanner.nextInt();
        int suit = scanner.nextInt();
        Map<Integer, List<Integer>> memoizationMap = new HashMap<>();
        List<Integer> initialList = Arrays.asList(2, 1);
        memoizationMap.put(202, initialList);

        List<Integer> result = calculateSteps(rank, suit, memoizationMap);
        System.out.println("Case #" + caseNum + ": " + result.size() / 2);
        for (int i = 0; i < result.size() - 1; i += 2) {
            System.out.println(result.get(i) + " " + result.get(i + 1));
        }
    }

    private static List<Integer> calculateSteps(int rank, int suit, Map<Integer, List<Integer>> memoizationMap) {
        if (rank == 1) {
            return new ArrayList<>();
        }

        int key = rank * 100 + suit;
        if (memoizationMap.containsKey(key)) {
            return memoizationMap.get(key);
        }

        List<Integer> stepsList = new ArrayList<>();
        for (int i = 1; i < suit; i++) {
            stepsList.add(rank * (suit - 1) - i + 1);
            stepsList.add(rank - 1);
        }
        stepsList.addAll(calculateSteps(rank - 1, suit, memoizationMap));
        memoizationMap.put(key, stepsList);

        return stepsList;
    }
}