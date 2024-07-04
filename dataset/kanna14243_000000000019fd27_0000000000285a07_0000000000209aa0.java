import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTests = sc.nextInt();
        int x = 1;
        while (x <= numTests) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] sqr = new int[n][n];
            if (generateMatrix(k, sqr, 0, 0, new HashMap<>(), new HashMap<>())) {
                System.out.println("Case #" + (x) + ": POSSIBLE");
                printArr(sqr);
            } else {
                System.out.println("Case #" + (x) + ": IMPOSSIBLE");
            }
            x++;
        }

    }

    private static void printArr(int[][] sqr) {
        for(int i = 0; i < sqr.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < sqr.length; j++) {
                sb.append(sqr[i][j]);
                if (j!=sqr.length -1) {
                    sb.append(" ");
                }
            }
            System.out.println(sb.toString());
        }
    }

    public static boolean generateMatrix(int k,
                                         int[][] sqr,
                                         int row,
                                         int col,
                                         HashMap<Integer, Set<Integer>> rowMap,
                                         HashMap<Integer, Set<Integer>> colMap) {
        rowMap.putIfAbsent(row, new HashSet<>());
        colMap.putIfAbsent(col, new HashSet<>());
        Set<Integer> rowCount = rowMap.get(row);
        Set<Integer> colCount = colMap.get(col);
        for (int i = 1; i <= sqr.length; i++) {
            if (!rowCount.contains(i) && !colCount.contains(i)) {
                sqr[row][col] = i;
                rowCount.add(i);
                colCount.add(i);
                if (col < sqr.length - 1) {
                    if (generateMatrix(k, sqr, row, col + 1, rowMap, colMap)) {
                        return true;
                    } else {
                        rowCount.remove(i);
                        colCount.remove(i);
                    }
                } else if (row < sqr.length - 1) {
                    if (generateMatrix(k, sqr, row + 1, 0, rowMap, colMap)) {
                        return true;
                    } else {
                        rowCount.remove(i);
                        colCount.remove(i);
                    }
                } else {
                    if(trace(sqr) == k) {
                        return true;
                    } else {
                        rowCount.remove(i);
                        colCount.remove(i);
                    }
                }
            }
        }
        return false;
    }

    private static int trace(int[][] sqr) {
        int sum = 0;
        for (int i = 0; i < sqr.length; i++) {
            sum += sqr[i][i];
        }
        return sum;
    }

}
