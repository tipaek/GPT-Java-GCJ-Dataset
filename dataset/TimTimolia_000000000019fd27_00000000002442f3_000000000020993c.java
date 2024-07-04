import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        System.out.println();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int trace = 0;
            int errorLines = 0;
            int errorColumns = 0;
            in.nextLine();
            int[][] matrix = new int[n][n];
            for (int k = 0; k < n; k++) {
                String line = in.nextLine();
                String[] array = line.split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[k][j] = Integer.parseInt(array[j]);
                }
            }
            for (int k = 0; k < n; k++) {
                { //trace + errorLines
                    List<Integer> list = new ArrayList<>();
                    for (int a : matrix[k]) {
                        if (list.contains(a)) {
                            errorLines++;
                            break;
                        } else {
                            list.add(a);
                        }
                    }
                    trace += matrix[k][k];
                }
                { //errorColumns
                    List<Integer> list = new ArrayList<>();
                    for (int j = 0; j < n; j++) {
                        int a = matrix[j][k];
                        if (list.contains(a)) {
                            errorColumns++;
                            break;
                        } else {
                            list.add(a);
                        }
                    }
                }
            }
            System.out.println("Case #" + i + ": " + trace + " " + errorLines + " " + errorColumns);
        }
    }

}
