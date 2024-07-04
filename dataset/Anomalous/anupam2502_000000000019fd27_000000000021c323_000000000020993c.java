import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class LatinMatrix {

    public static void checkLatinMatrix(int[][] mat) {
        int rowNum = mat.length;
        int colLen = mat[0].length;

        int rowDup = checkRepeatedValRow(mat, rowNum, colLen);
        int colDup = checkRepeatedValCol(mat, rowNum, colLen);
        int trace = findTrace(mat, rowNum, colLen);

        System.out.println(trace + " " + rowDup + " " + colDup);
    }

    private static int findTrace(int[][] mat, int rowNum, int colLen) {
        int sum = 0;
        for (int i = 0; i < rowNum && i < colLen; i++) {
            sum += mat[i][i];
        }
        return sum;
    }

    private static int checkRepeatedValRow(int[][] mat, int rowNum, int colLen) {
        int count = 0;
        for (int i = 0; i < rowNum; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < colLen; j++) {
                if (!set.add(mat[i][j])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    private static int checkRepeatedValCol(int[][] mat, int rowNum, int colLen) {
        int count = 0;
        for (int j = 0; j < colLen; j++) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < rowNum; i++) {
                if (!set.add(mat[i][j])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            int m = in.nextInt();
            int[][] mat = new int[m][m];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = in.nextInt();
                }
            }

            checkLatinMatrix(mat);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            in.close();
        }
    }
}