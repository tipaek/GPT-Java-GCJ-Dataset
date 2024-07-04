import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static List<String> steps = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = scanner.nextInt();
        int[][] pascalTriangle = generatePascalTriangle(500);

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int targetSum = scanner.nextInt();
            findPath(targetSum, new LinkedHashSet<>(), 0, 0, pascalTriangle);
            System.out.println("Case #" + caseNum + ":");
            for (String step : steps) {
                System.out.println(step);
            }
            steps.clear();
        }
    }

    private static void findPath(int remainingSum, LinkedHashSet<String> path, int x, int y, int[][] triangle) {
        if (x < 0 || x >= triangle.length || y < 0 || y >= triangle.length || path.contains((x + 1) + " " + (y + 1)) || !steps.isEmpty() || remainingSum < 0 || path.size() >= 500) {
            return;
        }

        path.add((x + 1) + " " + (y + 1));
        if (remainingSum - triangle[x][y] == 0) {
            steps = new ArrayList<>(path);
            return;
        }

        findPath(remainingSum - triangle[x][y], new LinkedHashSet<>(path), x - 1, y - 1, triangle);
        findPath(remainingSum - triangle[x][y], new LinkedHashSet<>(path), x, y - 1, triangle);
        findPath(remainingSum - triangle[x][y], new LinkedHashSet<>(path), x - 1, y, triangle);
        findPath(remainingSum - triangle[x][y], new LinkedHashSet<>(path), x + 1, y, triangle);
        findPath(remainingSum - triangle[x][y], new LinkedHashSet<>(path), x, y + 1, triangle);
        findPath(remainingSum - triangle[x][y], new LinkedHashSet<>(path), x + 1, y + 1, triangle);
    }

    private static int[][] generatePascalTriangle(int size) {
        int[][] triangle = new int[size][size];
        triangle[0][0] = triangle[1][0] = triangle[1][1] = 1;

        for (int i = 2; i < size; i++) {
            triangle[i][0] = triangle[i][i] = 1;
            for (int j = 1; j < i; j++) {
                triangle[i][j] = triangle[i - 1][j] + triangle[i - 1][j - 1];
            }
        }

        return triangle;
    }
}