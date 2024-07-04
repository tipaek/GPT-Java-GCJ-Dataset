
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private static Scanner in = new Scanner(System.in);
    public static void calcVestigium()
    {
        int row, i, j;


            row = in.nextInt();
            int matrix[][] = new int[row][row];
            int total = 0, rowCount = 0, columnCount = 0;

            for (i = 0; i < row; i++) {
                HashMap<Integer, Integer> map = new HashMap<>();
                int temp = 0;
                for (j = 0; j < row; j++) {
                    matrix[i][j] = in.nextInt();
                    if(map.containsKey(matrix[i][j]) && temp == 0) {
                        rowCount = rowCount + 1;
                        temp = 1;
                    }
                    map.put(matrix[i][j],0);
                    if(i == j) {
                        total = total + matrix[i][j];
                    }
                }
            }
            for (i = 0; i < row; i++) {
                HashMap<Integer, Integer> map = new HashMap<>();
                int temp = 0;
                for (j = 0; j < row; j++) {
                    if(map.containsKey(matrix[j][i])&& temp == 0) {
                        columnCount = columnCount + 1;
                        temp = 1;
                    }
                    map.put(matrix[j][i],0);
                }
            }
            System.out.println(total + " " + rowCount + " "+columnCount);

        }



    public static void main(String[] args)
    {
        int testCase;
        testCase = in.nextInt();
        for(int i = 0; i < testCase; i++) {
            calcVestigium();
        }

    }
} 