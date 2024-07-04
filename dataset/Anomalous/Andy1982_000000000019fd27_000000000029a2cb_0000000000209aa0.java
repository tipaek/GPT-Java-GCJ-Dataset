import java.util.*;

public class Solution {

    static List<Set<Integer>> listOfComb = new ArrayList<>();
    static boolean foundSolution = false;
    static Set<String> solution = new LinkedHashSet<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int noOfTestCases = input.nextInt();
        input.nextLine(); // Consume the newline character

        List<String> testCases = new ArrayList<>();
        for (int i = 0; i < noOfTestCases; i++) {
            testCases.add(input.nextLine());
        }

        int caseNumber = 1;
        for (String testCase : testCases) {
            String result = checkSolution(testCase);
            System.out.println("Case #" + caseNumber + ": " + result);
            if (result.equals("POSSIBLE")) {
                solution.forEach(System.out::println);
            }
            resetState();
            caseNumber++;
        }
    }

    private static String checkSolution(String input) {
        String[] inputArr = input.split(" ");
        int dimension = Integer.parseInt(inputArr[0]);
        int k = Integer.parseInt(inputArr[1]);

        findCombination(dimension, new LinkedHashSet<>());
        List<Set<Integer>> colList = new ArrayList<>();
        buildArrayAndCheckTrace(listOfComb, colList, dimension, k);

        return foundSolution ? "POSSIBLE" : "IMPOSSIBLE";
    }

    private static void buildArrayAndCheckTrace(List<Set<Integer>> combinations, List<Set<Integer>> colList, int n, int k) {
        if (colList.size() == n) {
            if (checkForTrace(colList, k)) {
                foundSolution = true;
                StringBuilder sb = new StringBuilder();
                for (Set<Integer> set : colList) {
                    set.forEach(v -> sb.append(v).append(" "));
                    solution.add(sb.toString().trim());
                    sb.setLength(0);
                }
            }
            return;
        }

        for (Set<Integer> set : combinations) {
            if (colList.stream().anyMatch(existingSet -> !compareHashSet(existingSet, set))) {
                continue;
            }
            colList.add(set);
            buildArrayAndCheckTrace(combinations, colList, n, k);
            if (foundSolution) return;
            colList.remove(set);
        }
    }

    private static boolean checkForTrace(List<Set<Integer>> colList, int k) {
        int trace = 0;
        int counter = 0;
        for (Set<Integer> set : colList) {
            int j = 0;
            for (Integer val : set) {
                if (counter == j) {
                    trace += val;
                }
                j++;
            }
            counter++;
        }
        return trace == k;
    }

    private static boolean compareHashSet(Set<Integer> set1, Set<Integer> set2) {
        Iterator<Integer> iter1 = set1.iterator();
        Iterator<Integer> iter2 = set2.iterator();

        while (iter1.hasNext() && iter2.hasNext()) {
            if (!iter1.next().equals(iter2.next())) return false;
        }
        return true;
    }

    private static void findCombination(int n, LinkedHashSet<Integer> list) {
        if (list.size() == n) {
            listOfComb.add(new LinkedHashSet<>(list));
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!list.contains(i)) {
                list.add(i);
                findCombination(n, list);
                list.remove(i);
            }
        }
    }

    private static void resetState() {
        foundSolution = false;
        listOfComb.clear();
        solution.clear();
    }
}