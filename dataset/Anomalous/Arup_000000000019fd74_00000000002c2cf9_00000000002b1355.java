import java.util.*;

public class GridCalculation {

    public static final int[] DX = {-1, 0, 0, 1};
    public static final int[] DY = {0, -1, 1, 0};

    public static int numRows;
    public static int numCols;
    public static int[][] grid;
    public static TreeSet<Integer>[] rows;
    public static TreeSet<Integer>[] cols;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            numRows = scanner.nextInt();
            numCols = scanner.nextInt();
            grid = new int[numRows][numCols];
            rows = new TreeSet[numRows];
            cols = new TreeSet[numCols];

            for (int i = 0; i < numRows; i++) {
                rows[i] = new TreeSet<>();
                for (int j = 0; j < numCols; j++) {
                    rows[i].add(j);
                }
            }

            for (int i = 0; i < numCols; i++) {
                cols[i] = new TreeSet<>();
                for (int j = 0; j < numRows; j++) {
                    cols[i].add(j);
                }
            }

            long currentSum = 0;
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numCols; j++) {
                    grid[i][j] = scanner.nextInt();
                    currentSum += grid[i][j];
                }
            }

            long result = currentSum;

            while (true) {
                long removedSum = removeElements();
                if (removedSum == 0) break;

                currentSum -= removedSum;
                result += currentSum;
            }

            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    public static long removeElements() {
        int[][] tempGrid = new int[numRows][numCols];
        long totalCost = 0;

        for (int i = 0; i < numRows; i++) {
            List<Integer> removeList = new ArrayList<>();
            Iterator<Integer> iterator = rows[i].iterator();

            while (iterator.hasNext()) {
                int col = iterator.next();
                int neighborSum = 0, count = 0;

                Integer left = rows[i].lower(col);
                if (left != null) {
                    count++;
                    neighborSum += grid[i][left];
                }
                Integer right = rows[i].higher(col);
                if (right != null) {
                    count++;
                    neighborSum += grid[i][right];
                }
                Integer up = cols[col].lower(i);
                if (up != null) {
                    count++;
                    neighborSum += grid[up][col];
                }
                Integer down = cols[col].higher(i);
                if (down != null) {
                    count++;
                    neighborSum += grid[down][col];
                }

                if (count * grid[i][col] < neighborSum) {
                    totalCost += grid[i][col];
                    cols[col].remove(i);
                    removeList.add(col);
                }
            }

            for (Integer col : removeList) {
                rows[i].remove(col);
            }
        }

        return totalCost;
    }
}