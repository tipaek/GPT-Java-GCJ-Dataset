import java.util.*;

public class Solution {
    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            solve(caseNumber);
        }
    }

    static void solve(int caseNumber) {
        int rank = scanner.nextInt();
        int suit = scanner.nextInt();
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(202, Arrays.asList(2, 1));

        List<Integer> result = getSteps(rank, suit, map);
        System.out.println("Case #" + caseNumber + ": " + result.size() / 2);
        for (int i = 0; i < result.size(); i += 2) {
            System.out.println(result.get(i) + " " + result.get(i + 1));
        }
    }

    static List<Integer> getSteps(int rank, int suit, Map<Integer, List<Integer>> map) {
        if (rank == 1) {
            return new ArrayList<>();
        }

        List<Integer> steps = new ArrayList<>();
        for (int i = 1; i < suit; i++) {
            steps.add(rank * (suit - 1) - i + 1);
            steps.add(rank - 1);
        }
        steps.addAll(getSteps(rank - 1, suit, map));
        map.put(rank * 100 + suit, steps);
        return steps;
    }
}