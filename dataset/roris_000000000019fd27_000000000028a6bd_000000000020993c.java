import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream(args[0]))));

            int cases = in.nextInt();
            int row = 0, col = 0;

            for (int i = 0; i < cases; i++) {
                int n = in.nextInt();
                int[][] matrix = new int[n][n];

                in.nextLine();

                while (row < n) {
                    String line = in.nextLine();
                    String[] arr = line.split(" ");
                    for (String s : arr) {
                        matrix[row][col++] = Integer.parseInt(s);
                    }
                    row++;
                    col = 0;
                }
                row = 0;

                System.out.println(solution(matrix, i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static String solution(int[][] matrix, int caseNumber) {
        int sum             = 0,
            repeatedRow     = 0,
            repeatedColumn  = 0;


        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
            repeatedRow += repeatedRow(matrix, i);
            repeatedColumn += repeatedColumn(matrix, i);
        }
        
        return "Case #" + caseNumber + ": " + sum + " " + repeatedRow + " " + repeatedColumn;
    }

    private static int repeatedRow(int[][] matrix, int row) {
        Set<Integer> set = new HashSet<>();
        boolean repeated = false;

        for (int i = 0; i < matrix.length; i++) {
            if (set.contains(matrix[row][i])) {
                repeated = true;
                break;
            }
            set.add(matrix[row][i]);
        }

        return repeated ? 1 : 0;
    }

    private static int repeatedColumn(int[][] matrix, int column) {
        Set<Integer> set = new HashSet<>();
        boolean repeated = false;

        for (int i = 0; i < matrix.length; i++) {
            if (set.contains(matrix[i][column])) {
                repeated = true;
                break;
            }
            set.add(matrix[i][column]);
        }

        return repeated ? 1 : 0;
    }
}

