import java.io.*;
import java.util.*;

public class Solution {

    private static String solve(int[][] matrix) {


        int sum = 0;
        int rrTotal = 0;
        int rcTotal = 0;

        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> repeatedRow = new HashSet<>();
            int rr = 0;
            int rc = 0;
            Set<Integer> repeatedCol = new HashSet<>();
            for (int j = 0; j < matrix[0].length; j++) {

                //Row
                if (repeatedRow.contains(matrix[i][j])) {
                    rr++;
                }
                repeatedRow.add(matrix[i][j]);

                //Column
                if (repeatedCol.contains(matrix[j][i])) {
                    rc++;
                }
                repeatedCol.add(matrix[j][i]);

                if (i == j) {
                    sum += matrix[i][j];
                }


            }

            if (rr > 0) {
                rrTotal++;
            }
            if (rc > 0){
                rcTotal++;
            }
        }

        return sum + " " + rrTotal + " " + rcTotal;
    }


    public static void main(String[] args) throws FileNotFoundException {


        //InputStream is = new FileInputStream("src/main/resources/qualification/changethis");
        InputStream is = System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                String dimension = scanner.next();
                int r = Integer.parseInt(dimension);
                int c = Integer.parseInt(dimension);
                int[][] matrix = new int[r][c];

                int d = Integer.parseInt(dimension);
                for (int i = 0; i < d; i++) {
                    for (int j = 0; j < d; j++) {
                        String value = scanner.next();
                        matrix[i][j] = Integer.parseInt(value);
                    }
                }

                System.out.println("Case #" + testNumber + ": " + solve(matrix));
            }
        }
    }
}
