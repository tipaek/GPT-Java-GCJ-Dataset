import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    static LinkedList<Point> path = new LinkedList<>();
    static int targetSum;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        ArrayList<Row> rows = new ArrayList<>();
        rows.add(new Row());

        for (int t = 1; t <= testCases; t++) {
            targetSum = scanner.nextInt();

            findPath(0, 0, 0, rows);
            System.out.println("Case #" + t + ":");

            while (!path.isEmpty()) {
                Point point = path.pop();
                System.out.println((point.y + 1) + " " + (point.x + 1));
            }

            for (Row row : rows) {
                row.resetUsed();
            }
        }
    }

    public static boolean findPath(int i, int j, int sum, ArrayList<Row> rows) {
        if (j < 0 || j >= rows.get(i).length) {
            return false;
        }

        rows.get(i).used[j] = true;
        int currentSum = sum + rows.get(i).row[j];

        if (currentSum == targetSum) {
            path.addFirst(new Point(i, j));
            rows.get(i).used[j] = false;
            return true;
        }

        if (currentSum > targetSum) {
            rows.get(i).used[j] = false;
            return false;
        }

        if (i + 1 >= rows.size()) {
            rows.add(new Row(rows.get(rows.size() - 1).row));
        }

        if (findPath(i + 1, (i % 2 == 0) ? j + 1 : j, currentSum, rows)
                || (!rows.get(i + 1).used[j] && findPath(i + 1, j, currentSum, rows))
                || (!rows.get(i).used[j - 1] && findPath(i, j - 1, currentSum, rows))
                || (j + 1 < rows.get(i).length && !rows.get(i).used[j + 1] && findPath(i, j + 1, currentSum, rows))) {
            path.addFirst(new Point(i, j));
            rows.get(i).used[j] = false;
            return true;
        }

        rows.get(i).used[j] = false;
        return false;
    }
}

class Point {
    int x, y;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Row {
    int[] row;
    boolean[] used;
    int length;

    public Row(int[] previousRow) {
        length = previousRow.length + 1;
        row = new int[length];
        row[0] = 1;

        for (int i = 1; i < length - 1; i++) {
            row[i] = previousRow[i] + previousRow[i - 1];
        }

        row[length - 1] = 1;
        used = new boolean[length];
    }

    public Row() {
        row = new int[1];
        row[0] = 1;
        length = 1;
        used = new boolean[1];
    }

    public void resetUsed() {
        used = new boolean[length];
    }
}