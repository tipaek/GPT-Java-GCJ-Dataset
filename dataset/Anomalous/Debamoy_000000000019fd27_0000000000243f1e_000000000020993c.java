import java.util.*;

class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int size = sc.nextInt();
            sc.nextLine(); // Consume the remaining newline

            String[][] matrix = new String[size][size];
            for (int i = 0; i < size; i++) {
                matrix[i] = sc.nextLine().split(" ");
            }

            int trace = calculateTrace(matrix, size);
            int rowCount = calculateRowCount(matrix, size);
            int colCount = calculateColCount(matrix, size);

            System.out.println("Case #" + t + ": " + trace + " " + rowCount + " " + colCount);
        }
    }

    private static int calculateTrace(String[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += Integer.parseInt(matrix[i][i]);
        }
        return trace;
    }

    private static int calculateRowCount(String[][] matrix, int size) {
        int rowCount = 0;
        for (String[] row : matrix) {
            Set<String> uniqueElements = new HashSet<>(Arrays.asList(row));
            if (uniqueElements.size() < size) {
                rowCount++;
            }
        }
        return rowCount;
    }

    private static int calculateColCount(String[][] matrix, int size) {
        int colCount = 0;
        for (int col = 0; col < size; col++) {
            Set<String> uniqueElements = new HashSet<>();
            for (int row = 0; row < size; row++) {
                uniqueElements.add(matrix[row][col]);
            }
            if (uniqueElements.size() < size) {
                colCount++;
            }
        }
        return colCount;
    }
}