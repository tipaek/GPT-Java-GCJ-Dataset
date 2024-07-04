import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            processTestCase(scanner);
        }
        scanner.close();
    }

    private static void processTestCase(Scanner scanner) {
        int numIntervals = scanner.nextInt();
        int[] startTimes = new int[numIntervals];
        int[] endTimes = new int[numIntervals];

        for (int i = 0; i < numIntervals; i++) {
            startTimes[i] = scanner.nextInt();
            endTimes[i] = scanner.nextInt();
        }

        List<Integer>[] adjacencyList = createAdjacencyList(numIntervals, startTimes, endTimes);
        boolean[] isPossible = {true};
        Set<Integer> visited = new HashSet<>();
        Set<Integer> setJ = new HashSet<>();
        Set<Integer> setC = new HashSet<>();

        for (int i = 0; i < numIntervals; i++) {
            if (!isPossible[0]) break;
            if (!visited.contains(i)) {
                performTwoColoring(isPossible, true, i, visited, setJ, setC, adjacencyList);
            }
        }

        printResult(isPossible, numIntervals, setJ);
    }

    private static List<Integer>[] createAdjacencyList(int numIntervals, int[] startTimes, int[] endTimes) {
        List<Integer>[] adjacencyList = new LinkedList[numIntervals];
        for (int i = 0; i < numIntervals; i++) {
            adjacencyList[i] = new LinkedList<>();
        }

        for (int i = 0; i < numIntervals; i++) {
            for (int j = 0; j < numIntervals; j++) {
                if (i != j && startTimes[i] <= startTimes[j] && startTimes[j] < endTimes[i]) {
                    adjacencyList[i].add(j);
                    adjacencyList[j].add(i);
                }
            }
        }
        return adjacencyList;
    }

    private static void performTwoColoring(boolean[] isPossible, boolean useJ, int current, Set<Integer> visited, Set<Integer> setJ, Set<Integer> setC, List<Integer>[] adjacencyList) {
        if (!isPossible[0]) return;

        if (useJ) {
            setJ.add(current);
        } else {
            setC.add(current);
        }
        visited.add(current);

        for (int neighbor : adjacencyList[current]) {
            if (!visited.contains(neighbor)) {
                performTwoColoring(isPossible, !useJ, neighbor, visited, setJ, setC, adjacencyList);
            } else {
                if ((useJ && setJ.contains(neighbor)) || (!useJ && setC.contains(neighbor))) {
                    isPossible[0] = false;
                    return;
                }
            }
        }
    }

    private static void printResult(boolean[] isPossible, int numIntervals, Set<Integer> setJ) {
        if (isPossible[0]) {
            for (int i = 0; i < numIntervals; i++) {
                if (setJ.contains(i)) {
                    System.out.print("J");
                } else {
                    System.out.print("C");
                }
            }
        } else {
            System.out.print("IMPOSSIBLE");
        }
        System.out.println();
    }
}