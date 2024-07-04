import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class MatrixAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int trace = 0;

            ArrayList<TreeSet<Integer>> rows = new ArrayList<>();
            ArrayList<TreeSet<Integer>> columns = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                rows.add(new TreeSet<>());
                columns.add(new TreeSet<>());
            }

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    int num = scanner.nextInt();
                    rows.get(i).add(num);
                    columns.get(j).add(num);

                    if (i == j) {
                        trace += num;
                    }
                }
            }

            int rowDuplicates = countDuplicates(rows, size);
            int columnDuplicates = countDuplicates(columns, size);

            System.out.println("Case #" + testCase + ": " + trace + " " + rowDuplicates + " " + columnDuplicates);
        }
    }

    private static int countDuplicates(ArrayList<TreeSet<Integer>> sets, int size) {
        int duplicateCount = 0;
        for (TreeSet<Integer> set : sets) {
            if (set.size() != size) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }
}