import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution{
    private static int testcaseNumber = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer testcases = scan.nextInt();

        while (testcases > 0) {
            testcaseNumber += 1;
            int rowDuplicateCount = 0;
            int colDuplicateCount = 0;
            int size = scan.nextInt();
            int matrix[][] = new int[size][size];
            int sum = 0;
            Set<Integer>[] columnUniqueValues = getColumnHashset(size);

            for (int i = 0; i < size; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    int curr = scan.nextInt();
                    matrix[i][j] = curr;
                    if (i == j) {
                        sum += curr;
                    }
                    if (!rowSet.contains(curr)) {
                        rowSet.add(curr);
                    }
                    Set<Integer> colUnique = columnUniqueValues[j];
                    if (!colUnique.contains(curr)) {
                        colUnique.add(curr);
                        columnUniqueValues[j] = colUnique;
                    }
                }
                if (rowSet.size() < size) {
                    rowDuplicateCount += 1;
                }
            }

            for (Set<Integer> set : columnUniqueValues) {
                if (set.size() < size) {
                    colDuplicateCount += 1;
                }
            }


            System.out.println("Case #" + testcaseNumber + ": " + sum + " " + rowDuplicateCount + " " + colDuplicateCount);

            testcases--;
        }

    }

    public  static Set<Integer>[] getColumnHashset(int size) {
        Set<Integer>[] set = new HashSet[size];
        for (int i = 0; i < size; i++) {
            set[i] = new HashSet<Integer>();
        }
        return set;
    }
    
}