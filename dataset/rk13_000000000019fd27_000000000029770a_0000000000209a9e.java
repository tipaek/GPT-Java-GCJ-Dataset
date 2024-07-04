import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    static Scanner scanner;

    static int b;
    static int[] cells;
    static int[] complemented;
    static int[] reversed;
    static int[] complementReversed;
    static int[][] nextOptions;

    static LinkedList<Integer> emptyCells;

    public static void main(String[] args) {
        scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String[] s = scanner.nextLine().split(" ");

        int t = Integer.parseInt(s[0]);
        b = Integer.parseInt(s[1]);

        for (int i = 1; i <= t; ++i) {
            calculate();
        }
    }

    private static void calculate() {
        cells = new int[b];
        Arrays.fill(cells, -1);
        emptyCells = IntStream.range(0, b).boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        readCells(10);
        while (!emptyCells.isEmpty()) {
            next();
            readCells(Math.min(emptyCells.size(), 8));
        }

        System.out.println(Arrays.stream(cells).boxed().map(String::valueOf)
                .collect(Collectors.joining()));

        String answer = scanner.nextLine();
        if ("N".equals(answer)) {
            System.exit(1);
        }
    }

    static void next() {
        int[] cellIdsToTest = findCellsToTest();
        int[] testedCells = new int[cellIdsToTest.length];
        for (int i = 0; i < cellIdsToTest.length; i++) {
            System.out.println(cellIdsToTest[i] + 1);
            testedCells[i] = Integer.parseInt(scanner.nextLine());
        }

        for (int i = 0; i < nextOptions.length; i++) {
            int[] state = nextOptions[i];
            boolean eq = true;
            for (int j = 0; j < cellIdsToTest.length; j++) {
                int idx = cellIdsToTest[j];
                if (state[idx] != testedCells[j]) {
                    eq = false;
                    break;
                }
            }
            if (eq) {
                cells = state;
                break;
            }
        }
    }

    static int[] findCellsToTest() {
        List<Integer> candidates = IntStream.range(0, b).boxed().collect(Collectors.toList());
        candidates.removeAll(emptyCells);

        Set<String> set = new HashSet<>();
        for (int i = 0; i < nextOptions.length; i++) {
            set.add(Arrays.toString(nextOptions[i]));
        }
        int states = set.size();

        for (int i = 0; i < candidates.size(); i++) {
            for (int j = i + 1; j < candidates.size(); j++) {
                int[] idx = new int[]{candidates.get(i), candidates.get(j)};
                Set<String> iset = new HashSet<>();
                for (int k = 0; k < nextOptions.length; k++) {
                    String tmp = nextOptions[k][idx[0]] + "$" + nextOptions[k][idx[1]];
                    iset.add(tmp);
                }
                if (iset.size() == states) {
                    return idx;
                }
            }
        }
        throw new RuntimeException();
    }

    static void readCells(int num) {
        for (int i = 0; i < num; i++) {
            int j = emptyCells.pop();
            System.out.println(j + 1);
            cells[j] = Integer.parseInt(scanner.nextLine());
            Collections.reverse(emptyCells);
        }
        reversed = reverse(cells);
        complemented = complement(cells);
        complementReversed = reverse(complemented);
        nextOptions = new int[][]{cells, complemented, complementReversed, reversed};
    }

    static int[] complement(int[] a) {
        int[] cp = Arrays.copyOf(a, a.length);
        for (int i = 0; i < a.length; i++) {
            if (cp[i] != -1) {
                cp[i] = cp[i] == 0 ? 1 : 0;
            }
        }
        return cp;
    }

    static int[] reverse(int[] a) {
        int[] cp = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            cp[a.length - i - 1] = a[i];
        }
        return cp;
    }
}
