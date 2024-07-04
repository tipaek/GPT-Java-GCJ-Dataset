import java.util.*;

public class Solution {

    static List<Set<Integer>> listOfComb = new ArrayList<>();
    static boolean foundSolution = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        List<String> testCases = new ArrayList<>();
        for (int i = 0; i < numberOfTestCases; i++) {
            testCases.add(scanner.nextLine());
        }

        int caseNumber = 1;
        for (String testCase : testCases) {
            System.out.flush();
            System.out.println("Case #" + caseNumber + ": " + checkSolution(testCase));
            System.out.flush();
            caseNumber++;
            resetState();
        }
    }

    private static void resetState() {
        foundSolution = false;
        listOfComb = new ArrayList<>();
    }

    public static String checkSolution(String input) {
        String[] inputArr = input.split(" ");
        int dimension = Integer.parseInt(inputArr[0]);
        int targetTrace = Integer.parseInt(inputArr[1]);

        findCombinations(dimension, new LinkedHashSet<>());

        List<Set<Integer>> columnList = new ArrayList<>();
        buildArrayAndCheckTrace(listOfComb, columnList, dimension, targetTrace);

        return foundSolution ? "POSSIBLE" : "IMPOSSIBLE";
    }

    private static void buildArrayAndCheckTrace(List<Set<Integer>> combinations, List<Set<Integer>> colList, int n, int k) {
        if (colList.size() == n) {
            if (checkForTrace(colList, k)) {
                foundSolution = true;
            }
            return;
        }

        for (Set<Integer> set : combinations) {
            if (isSetPresentInColList(colList, set)) continue;
            colList.add(set);
            buildArrayAndCheckTrace(combinations, colList, n, k);
            if (foundSolution) return;
            colList.remove(set);
        }
    }

    private static boolean isSetPresentInColList(List<Set<Integer>> colList, Set<Integer> set) {
        for (Set<Integer> existingSet : colList) {
            if (!compareSets(existingSet, set)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkForTrace(List<Set<Integer>> colList, int k) {
        int trace = 0;
        int index = 0;
        for (Set<Integer> set : colList) {
            int j = 0;
            for (Integer val : set) {
                if (index == j) {
                    trace += val;
                }
                j++;
            }
            index++;
        }
        return trace == k;
    }

    public static boolean compareSets(Set<Integer> set1, Set<Integer> set2) {
        Iterator<Integer> iter1 = set1.iterator();
        Iterator<Integer> iter2 = set2.iterator();

        while (iter1.hasNext() && iter2.hasNext()) {
            if (!iter1.next().equals(iter2.next())) return false;
        }
        return true;
    }

    private static void findCombinations(int n, LinkedHashSet<Integer> currentSet) {
        if (currentSet.size() == n) {
            listOfComb.add(new LinkedHashSet<>(currentSet));
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (currentSet.contains(i)) continue;
            currentSet.add(i);
            findCombinations(n, currentSet);
            currentSet.remove(i);
        }
    }
}