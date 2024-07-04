import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseAmount = Integer.parseInt(scanner.nextLine());

        for (int index = 0; index < testCaseAmount; index++) {
            int N = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[N][];

            for (int row = 0; row < N; row++) {
                matrix[row] = new int[N];
                for (int col = 0; col < matrix[row].length; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
                scanner.nextLine();
            }

            System.out.println(printTrace(matrix, index + 1, N));
        }

        scanner.close();
    }

    public static String printTrace(int[][] matrix, int testcaseNo, int N){
        int rowCount = 0;
        int trace = 0;

        for (int row = 0; row < N; row++) {
            boolean isRowHaveDup = false;
            HashSet<Integer> seen = new HashSet<>();

            for (int col = 0; col < N; col++) {
                int val = matrix[row][col];

                if(row == col){
                    trace += val;
                }

                if(seen.contains(val)){
                    isRowHaveDup = true;
                }else{
                    seen.add(val);
                }
            }

            rowCount += isRowHaveDup ? 1 : 0;
        }

        return "Case #" + testcaseNo + ": " + trace + " " + rowCount + " " + getColCount(matrix);
    }

    private static int getColCount(int[][] matrix) {
        int count = 0;

        for (int col = 0; col < matrix[0].length; col++) {
            boolean isColHaveDup = false;
            HashSet<Integer> seen = new HashSet<>();

            for (int row = 0; row < matrix.length; row++) {
                int val = matrix[row][col];

                if(seen.contains(val)){
                    isColHaveDup = true;
                }else{
                    seen.add(val);
                }
            }

            count += isColHaveDup ? 1 : 0;
        }

        return count;
    }
}