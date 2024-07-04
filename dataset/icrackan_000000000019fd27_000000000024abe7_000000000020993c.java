import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int idxDiagonalTmp = 0;
            int countRepeatRow = 0;
            int countRepeatCol = 0;
            int sumDiagonal = 0;
            int[] countArrRow; //row track
            int[][] countArrCol = new int[N][N];//col track
            boolean[] hadRepeatColArr = new boolean[N];

            for (int i = 0; i < N; i++) {
                countArrRow = new int[N];
                idxDiagonalTmp = i;
                boolean hadRepeatRow = false;
                for (int j = 0; j < N; j++) {
                    int valueJM = scanner.nextInt();
                    //handle row repeat
                    if (countArrRow[valueJM - 1] == 1) {
                        if (!hadRepeatRow) {
                            countRepeatRow++;
                            hadRepeatRow = true;
                        }
                    } else {
                        countArrRow[valueJM - 1]++;
                    }

                    //sum values main diagonal
                    if (j == idxDiagonalTmp) {
                        sumDiagonal += valueJM;
                    }

                    //handle col repeat -> track
                    if (countArrCol[j][valueJM - 1] == 1) {
                        if (!hadRepeatColArr[j]) {
                            countRepeatCol++;
                            hadRepeatColArr[j] = true;
                        }
                    } else {
                        countArrCol[j][valueJM - 1]++;
                    }
                }
            }
            //print result
            System.out.println("Case #" + (t + 1) + ": " +  sumDiagonal + " " + countRepeatRow + " " + countRepeatCol);
        }
    }
}