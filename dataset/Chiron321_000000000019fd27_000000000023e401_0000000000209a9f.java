import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseNo =1;
        int matrixSize;
        int[][] ar;
        int trace ;
        int row ;
        int column;
        int input;
        int noOfTest = sc.nextInt();
        while (noOfTest--> 0) {
            matrixSize = sc.nextInt();
            ar = new int[matrixSize][matrixSize];
            trace = 0;
            row = 0;
            for (int i = 0; i < matrixSize; i++) {
                boolean flag = true;
                for (int j = 0; j < matrixSize; j++) {
                    input = sc.nextInt();
                    if (check(ar[i], input) == true && flag == true) {
                        row++;
                        flag = false;
                    }
                    ar[i][j] = input;
                    if (i == j)
                        trace += ar[i][j];
                }
            }
            column = 0;
            int[] columnArray = new int[matrixSize];
            for (int j = 0; j < matrixSize; j++) {
                for (int i = 0; i < matrixSize; i++) {
                    columnArray[i] = ar[i][j];
                }
                outer: for (int i = 0; i < matrixSize - 1; i++) {
                    for (int k = i + 1; k < matrixSize; k++) {
                        if (columnArray[i] == columnArray[k]) {
                            column++;
                            break outer;
                        }
                    }

                }
            }
            System.out.println("Case #"+caseNo+": "+trace + " " + row + " " + column);
            caseNo++;
        }
    }

    public static boolean check(int[] arr, int toCheckValue) {
        boolean test = false;
        for (int element: arr) {
            if (element == toCheckValue) {
                test = true;
                break;
            }
        }
        return test;
    }
}