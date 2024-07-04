import java.util.*;
import java.io.*;

public class Solution {
    static final int PASCAL_TOWER_SIZE = 50;
    static long[][] pascalTower;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testSetSize = scanner.nextInt();
        pascalTower = generatePascalTower(PASCAL_TOWER_SIZE);

        for (int i = 1; i <= testSetSize; ++i) {
            int pascalSum = scanner.nextInt();
            List<String> resultList = solve(pascalSum);
            System.out.println("Case #" + i + ": ");
            for (String result : resultList) {
                System.out.println(result);
            }
        }
    }

    public static List<String> solve(int pascalSum) {
        List<String> resultList = new ArrayList<>();
        int sum = 0, r = 0, k = 0;
        boolean leftToRight = true;

        while (calculateRowSum(r) + sum <= pascalSum) {
            if (leftToRight) {
                for (k = 0; k <= r && pascalTower[r][k] != 0; k++) {
                    resultList.add((r + 1) + " " + (k + 1));
                    sum += pascalTower[r][k];
                }
            } else {
                for (k = r; k >= 0 && pascalTower[r][k] != 0; k--) {
                    resultList.add((r + 1) + " " + (k + 1));
                    sum += pascalTower[r][k];
                }
            }
            leftToRight = !leftToRight;
            r++;
        }

        while (sum < pascalSum) {
            resultList.add((r + 1) + " " + (k + 1));
            sum++;
            if (k != 0) {
                k++;
            }
            r++;
        }

        System.out.println("SUM = " + sum);
        System.out.println("Number of Steps = " + resultList.size());
        return resultList;
    }

    static int calculateRowSum(int r) {
        int sum = 0;
        for (int k = 0; k < PASCAL_TOWER_SIZE; k++) {
            sum += pascalTower[r][k];
        }
        return sum;
    }

    public static long[][] generatePascalTower(int size) {
        long[][] tower = new long[size][size];
        tower[0][0] = 1;
        tower[1][0] = 1;
        tower[1][1] = 1;

        for (int r = 2; r < size; r++) {
            for (int k = 0; k <= r; k++) {
                if (k == 0 || k == r) {
                    tower[r][k] = 1;
                } else {
                    tower[r][k] = tower[r - 1][k - 1] + tower[r - 1][k];
                }
            }
        }
        return tower;
    }
}