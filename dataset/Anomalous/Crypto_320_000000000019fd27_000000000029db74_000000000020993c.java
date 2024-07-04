import java.util.ArrayList;
import java.util.Scanner;

public class Test96 {
    public static void main(String[] args) {
        isLatinSquare();
    }

    private static void isLatinSquare() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> countRow = new ArrayList<>();

        System.out.println("Enter the number of test cases:");
        int testCase = scanner.nextInt();

        while (testCase > 0) {
            System.out.println("Enter the size of the matrix:");
            int size = scanner.nextInt();
            int[][] theArray = new int[size][size];
            int rowCount = 0;
            int dSum = 0;
            boolean switcherR = false;

            for (int i = 0; i < size; i++) {
                System.out.println("Enter row " + (i + 1) + ":");
                for (int j = 0; j < size; j++) {
                    int z = scanner.nextInt();
                    theArray[i][j] = z;
                    if (i == j) {
                        dSum += theArray[i][j];
                    }
                    if (!switcherR) {
                        for (int k = 0; k < j; k++) {
                            if (theArray[i][k] == theArray[i][j]) {
                                rowCount++;
                                switcherR = true;
                                break;
                            }
                        }
                    }
                }
                switcherR = false;
            }
            countRow.add(dSum);
            countRow.add(rowCount);
            countRow.add(countCols(theArray));
            testCase--;
        }

        for (int i = 0; i < countRow.size(); i += 3) {
            System.out.println("Case #" + (i / 3 + 1) + ": " + countRow.get(i) + " " + countRow.get(i + 1) + " " + countRow.get(i + 2));
        }

        scanner.close();
    }

    private static int countCols(int[][] arr) {
        int countCol = 0;
        boolean switcherC = false;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (!switcherC) {
                    for (int k = 0; k < j; k++) {
                        if (arr[k][i] == arr[j][i]) {
                            countCol++;
                            switcherC = true;
                            break;
                        }
                    }
                }
            }
            switcherC = false;
        }

        return countCol;
    }
}