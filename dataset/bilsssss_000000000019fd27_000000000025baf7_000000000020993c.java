import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        for (int i=0;i<input;i++) {
            int matrix = Integer.parseInt(scanner.nextLine());

            int[][] matrixArray = new int[matrix][matrix];
            List<Integer> tempList = new ArrayList<>();
            int repeatRow = 0;
            int repeatColumn = 0;
            int sumDiagonal = 0;

            for (int j=0;j<matrix;j++) {
                String row = scanner.nextLine();
                String[] rowArray = row.split(" ");

                for (int k=0;k<rowArray.length;k++) {
                    int rowInt = Integer.parseInt(rowArray[k]);
                    matrixArray[j][k] = rowInt;

                    if (tempList.contains(rowInt)) {
                        repeatRow++;
                        break;
                    } else {
                        tempList.add(rowInt);
                    }
                }
                tempList.clear();
            }

            for (int j=0;j<matrixArray.length;j++) {
                for (int k=0;k<matrixArray[j].length;k++) {
                    if (tempList.contains(matrixArray[k][j])) {
                        repeatColumn++;
                        break;
                    } else {
                        tempList.add(matrixArray[k][j]);
                    }
                }
                tempList.clear();
                sumDiagonal += matrixArray[j][j];
            }
            System.out.println("case #" + (i+1) + ":" + sumDiagonal + " " + repeatRow + " " + repeatColumn);
        }
    }
}