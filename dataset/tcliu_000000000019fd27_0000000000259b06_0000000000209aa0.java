import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.IntStream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class Solution {

    public static void fill(int[][] m) {
        MatrixManager mm = new MatrixManager(m);
        Slot markedSlot;
        while ((markedSlot = mm.findAndMark()) != null) {

        }
    }

    public static int[][] init(int n, int k) {
        int[][] m = new int [n][n];
        if (k >= n) {
            int[] counts = new int [n];
            int t = 0;
            for (int i = 0; i < n; i++) {
                m[i][i] = k / n;
                counts[m[i][i] - 1]++;
                t += m[i][i];
            }
            for (int i = 0; t < k; i = (i + 1) % n) {
                if (m[i][i] < n) {
                    counts[m[i][i] - 1]--;
                    m[i][i]++;
                    counts[m[i][i] - 1]++;
                    t++;
                    i++;
                }
            }
            for (int i = 0, pi = -1; i < n; i++) {
                if (m[i][i] > 1 && m[i][i] < n && counts[m[i][i] - 1] == n - 1) {
                    if (pi == -1) {
                        pi = i;
                    } else if (m[i][i] == m[pi][pi]) {
                        m[pi][pi]--;
                        m[i][i]++;
                        pi = -1;
                    }
                }
            }
        }
        return m;
    }

    public static int[][] solve(int n, int k) {
        int[][] m;
        if (k < n || k == n + 1 || k == n*n - 1 || (n < 4 && k % n > 0)) {
            m = null;
        } else {
            m = init(n, k);
            fill(m);
            if (!validate(m)) {
                m = null;
            }
        }
        return m;
    }

    public static void print(int[][] m) {
        for (int i=0; i<m.length; i++) {
            for (int j=0; j<m.length; j++) {
                if (j > 0) {
                    System.out.print(' ');
                }
                System.out.print(m[i][j]);
            }
            System.out.println();
        }
    }
    public static boolean validate(int[][] m) {
        int n = m.length;
        for (int i=0; i<n; i++) {
            boolean[] marks = new boolean [n];
            for (int j=0; j<n; j++) {
                if (m[i][j] == 0 || m[i][j] > n || marks[m[i][j] - 1]) {
                    return false;
                } else {
                    marks[m[i][j] - 1] = true;
                }
            }
        }
        for (int j=0; j<n; j++) {
            boolean[] marks = new boolean [n];
            for (int i=0; i<n; i++) {
                if (m[i][j] == 0 || marks[m[i][j] - 1]) {
                    return false;
                } else {
                    marks[m[i][j] - 1] = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            for (int i=0; i<t; i++) {
                int n = sc.nextInt();
                int k = sc.nextInt();
                int[][] sol = solve(n, k);
                System.out.printf("Case #%s: %s%n", i+1, sol == null ? "IMPOSSIBLE" : "POSSIBLE");
                if (sol != null) {
                    print(sol);
                }
            }
        }
    }

    static class MatrixManager {

        int[][] m;

        int n;

        Set<Integer>[] rowSets;

        Set<Integer>[] colSets;

        Map<Integer, Slot> slots;

        MatrixManager(int[][] m) {
            this.m = m;
            this.n = m.length;
            rowSets = new Set[n];
            colSets = new Set[n];
            slots = new TreeMap<>();
            Set<Integer> allNums = IntStream.rangeClosed(1, n).boxed().collect(toSet());
            for (int i=0; i<n; i++) {
                rowSets[i] = new TreeSet<>(allNums);
                colSets[i] = new TreeSet<>(allNums);
            }
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (m[i][j] == 0) {
                        slots.put(i * n + j, new Slot(i, j, rowSets[i], colSets[j]));
                    } else {
                        mark(i, j, m[i][j]);
                    }
                }
            }
        }

        void mark(int i, int j, int num) {
            if (m[i][j] == 0) {
                m[i][j] = num;
                slots.remove(i * n + j);
            }
            rowSets[i].remove(num);
            colSets[j].remove(num);
        }

        List<Slot> getSortedSlots() {
            return slots.values().stream()
                .sorted(comparing((Slot slot) -> Math.min(slot.rowOpts.size(), slot.colOpts.size()))
                    .thenComparing((Slot slot) -> slot.getOpts().size()))
                .collect(toList());
        }

        Slot findAndMark() {
            Slot markedSlot = null;
            List<Slot> sortedSlots = getSortedSlots();
            Iterator<Slot> itr = sortedSlots.iterator();
            if (itr.hasNext()) {
                Slot slot = itr.next();
                Set<Integer> numOpts = slot.getOpts();
                if (numOpts.isEmpty()) {
                    markedSlot = null;
                } else {
                    mark(slot.i, slot.j, numOpts.iterator().next());
                    markedSlot = slot;
                }
            }
            return markedSlot;
        }

        void printStatus() {
            getSortedSlots().forEach(System.out::println);
        }

    }

    private static class Slot {

        int i;

        int j;

        Set<Integer> rowOpts;

        Set<Integer> colOpts;

        Slot(int i, int j, Set<Integer> rowOpts, Set<Integer> colOpts) {
            this.i = i;
            this.j = j;
            this.rowOpts = rowOpts;
            this.colOpts = colOpts;
        }

        @Override
        public String toString() {
            return String.format("Slot(i=%d,j=%d,opts=%s,rowOpts=%s,colOpts=%s)", i, j, getOpts(), rowOpts, colOpts);
        }

        Set<Integer> getOpts() {
            return rowOpts.stream()
                .filter(colOpts::contains)
                .collect(toSet());
        }

    }
}
