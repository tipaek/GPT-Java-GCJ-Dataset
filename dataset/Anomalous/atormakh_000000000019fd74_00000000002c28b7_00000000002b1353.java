import java.util.*;
import java.io.*;

public class Solution {
    static long[][] pascalTower;
    static final int PASCAL_TOWER_SIZE = 50;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testSetSize = scanner.nextInt();
        pascalTower = generatePascalTower(PASCAL_TOWER_SIZE);

        for (int i = 1; i <= testSetSize; ++i) {
            int pascalSum = scanner.nextInt();
            List<String> resultList = solve(pascalSum);
            System.out.println("Case #" + i + ":");
            for (String result : resultList) {
                System.out.println(result);
            }
        }
    }

    public static List<String> solve(int pascalSum) {
        List<String> resultList = new ArrayList<>();
        int sum = 0;
        int row = 0, col = 0;
        boolean leftToRight = true;

        while (calculateRowSum(row) + sum <= pascalSum) {
            if (leftToRight) {
                col = 0;
                while (pascalTower[row][col] != 0) {
                    resultList.add((row + 1) + " " + (col + 1));
                    sum += pascalTower[row][col];
                    col++;
                }
            } else {
                col = row;
                while (col >= 0 && pascalTower[row][col] != 0) {
                    resultList.add((row + 1) + " " + (col + 1));
                    sum += pascalTower[row][col];
                    col--;
                }
                col = 0;
            }
            leftToRight = !leftToRight;
            row++;
        }

        while (sum < pascalSum) {
            resultList.add((row + 1) + " " + (col + 1));
            sum += 1;
            if (col != 0) {
                col++;
            }
            row++;
        }

        return resultList;
    }

    static int calculateRowSum(int row) {
        int sum = 0;
        for (int col = 0; col < PASCAL_TOWER_SIZE; col++) {
            sum += pascalTower[row][col];
        }
        return sum;
    }

    public static long[][] generatePascalTower(int size) {
        long[][] pascalTower = new long[size][size];
        pascalTower[0][0] = 1;
        pascalTower[1][0] = 1;
        pascalTower[1][1] = 1;

        for (int row = 2; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (col == 0 || col == row) {
                    pascalTower[row][col] = 1;
                } else {
                    pascalTower[row][col] = pascalTower[row - 1][col - 1] + pascalTower[row - 1][col];
                }
            }
        }
        return pascalTower;
    }
}