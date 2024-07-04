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
        }
    }
    
    public static boolean findPath(int i, int j, int currentSum, ArrayList<Row> rows) {
        if (j < 0 || j >= rows.get(i).length) {
            return false;
        }
        
        int newSum = currentSum + rows.get(i).row[j];
        
        if (newSum == targetSum) {
            path.addFirst(new Point(i, j));
            return true;
        }
        
        if (newSum > targetSum) {
            return false;
        }
        
        if (i + 1 >= rows.size()) {
            rows.add(new Row(rows.get(rows.size() - 1).row));
        }
        
        if (findPath(i + 1, (i % 2 == 0) ? j + 1 : j, newSum, rows)
                || findPath(i + 1, j, newSum, rows)
                || findPath(i, j - 1, newSum, rows)
                || findPath(i, j + 1, newSum, rows)) {
            path.addFirst(new Point(i, j));
            return true;
        }
        
        return false;
    }
}

class Point {
    int x, y;
    
    public Point(int i, int j) {
        this.y = i;
        this.x = j;
    }
}

class Row {
    int[] row;
    boolean[] used;
    int length;
    
    public Row(int[] previousRow) {
        this.length = previousRow.length + 1;
        this.row = new int[length];
        this.row[0] = 1;
        
        for (int i = 1; i < length - 1; i++) {
            this.row[i] = previousRow[i] + previousRow[i - 1];
        }
        
        this.row[length - 1] = 1;
        this.used = new boolean[length];
    }
    
    public Row() {
        this.row = new int[1];
        this.row[0] = 1;
        this.length = 1;
    }
}