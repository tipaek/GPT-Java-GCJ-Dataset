import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int trace = 0;
            ArrayList<TreeSet<Integer>> rows = new ArrayList<>();
            ArrayList<TreeSet<Integer>> cols = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                rows.add(new TreeSet<>());
                cols.add(new TreeSet<>());
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int num = scanner.nextInt();
                    rows.get(i).add(num);
                    cols.get(j).add(num);
                    if (i == j) {
                        trace += num;
                    }
                }
            }

            int rowCount = countIncompleteSets(rows, n);
            int colCount = countIncompleteSets(cols, n);

            System.out.println("Case #" + (caseNumber++) + ": " + trace + " " + rowCount + " " + colCount);
        }

        scanner.close();
    }

    private static int countIncompleteSets(ArrayList<TreeSet<Integer>> sets, int n) {
        int count = 0;
        for (TreeSet<Integer> set : sets) {
            if (set.size() != n) {
                count++;
            }
        }
        return count;
    }
}