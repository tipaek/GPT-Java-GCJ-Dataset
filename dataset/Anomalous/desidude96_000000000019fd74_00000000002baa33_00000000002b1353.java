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
        int[][] pascalTriangle = generatePascalTriangle();
        
        for (int caseIndex = 1; caseIndex <= numCases; caseIndex++) {
            int targetSum = scanner.nextInt();
            findPath(targetSum, new LinkedHashSet<>(), 0, 0, pascalTriangle);
            
            System.out.println("Case #" + caseIndex + ":");
            for (String step : steps) {
                System.out.println(step);
            }
            
            steps.clear();
        }
    }

    private static void findPath(int remainingSum, LinkedHashSet<String> visited, int x, int y, int[][] pascalTriangle) {
        if (x < 0 || x >= pascalTriangle.length || y < 0 || y >= pascalTriangle.length || visited.contains((x + 1) + " " + (y + 1)) || !steps.isEmpty() || remainingSum < 0) {
            return;
        }

        visited.add((x + 1) + " " + (y + 1));

        if (remainingSum - pascalTriangle[x][y] == 0) {
            steps = new ArrayList<>(visited);
            return;
        }

        findPath(remainingSum - pascalTriangle[x][y], new LinkedHashSet<>(visited), x - 1, y - 1, pascalTriangle);
        findPath(remainingSum - pascalTriangle[x][y], new LinkedHashSet<>(visited), x, y - 1, pascalTriangle);
        findPath(remainingSum - pascalTriangle[x][y], new LinkedHashSet<>(visited), x - 1, y, pascalTriangle);
        findPath(remainingSum - pascalTriangle[x][y], new LinkedHashSet<>(visited), x + 1, y, pascalTriangle);
        findPath(remainingSum - pascalTriangle[x][y], new LinkedHashSet<>(visited), x, y + 1, pascalTriangle);
        findPath(remainingSum - pascalTriangle[x][y], new LinkedHashSet<>(visited), x + 1, y + 1, pascalTriangle);
    }

    private static int[][] generatePascalTriangle() {
        int size = 500;
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