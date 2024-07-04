import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T;
        T = input.nextInt();
        //start of loop T
        for (int t = 1; t <= T; t++) {
            int n = input.nextInt();
            int A[][] = new int[n][n];

            //start array var
            for (int m = 0; m < A.length; m++) {
                for (int v = 0; v < A.length; v++) {
                    A[m][v] = input.nextInt();
                }
            }
            //end array var

            //start sum
            int sum = 0;
            for (int i = 0; i < A.length; i++) {
                sum = A[i][i] + sum;
            }
            //end sum

            //start row
            int sumRow = 0;
            for (int y = 0; y < A.length; y++) {
                boolean check = true;
                for (int a = 0; a < A.length - 1; a++) {
                    for (int b = a + 1; b < A.length; b++) {
                        if (A[y][a] == A[y][b]) {
                            sumRow++;
                            check = false;
                            break;
                        }
                    }
                    if (check == false) {
                        break;
                    }
                }

            }
            //end row

            //start col
            int sumCol = 0;
            for (int x = 0; x < A.length; x++) {
                boolean check = true;
                for (int a = 0; a < A.length - 1; a++) {
                    for (int b = a + 1; b < A.length; b++) {
                        if (A[a][x] == A[b][x]) {
                            sumCol++;
                            check = false;
                            break;
                        }
                    }
                    if (check == false) {
                        break;
                    }
                }

            }
            //end col
            //start output
            System.out.printf("Case #%d: %d %d %d\n", t, sum, sumRow,sumCol);
            //end output
        }//end of loop T

    }
}