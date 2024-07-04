import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for(int i = 0; i < cases; i++) {
            int size = scanner.nextInt();
            solveCase(i, size, scanner);
        }
    }

    public static void solveCase(int caseNum, int size, Scanner scanner) {
        System.out.print("Case #" + (caseNum + 1) + ": ");
        int[][] arr = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = scanner.nextInt() - 1;
            }
        }

        int trace = 0;
        int rowsRepeated = 0;
        int colsRepeated = 0;
        for(int i = 0; i < size; i++) {
            boolean[] rowRepeats = new boolean[size];
            boolean rowRepeated = false;
            boolean[] colRepeats = new boolean[size];
            boolean colRepeated = false;
            for(int j = 0; j < size; j++) {
                int rowSpot = arr[j][i];
                int colSpot = arr[i][j];
                if(i==j) {
                    trace += arr[i][j] + 1;
                }
                if(!rowRepeats[rowSpot]) {
                    rowRepeats[rowSpot] = true;
                } else {
                    rowRepeated = true;
                }
                if(!colRepeats[colSpot]) {
                    colRepeats[colSpot] = true;
                } else {
                    colRepeated = true;
                }
            }
            if(rowRepeated) {
                rowsRepeated++;
            }
            if(colRepeated) {
                colsRepeated++;
            }
        }

        System.out.println(trace + " " + colsRepeated + " " + rowsRepeated);
    }
}