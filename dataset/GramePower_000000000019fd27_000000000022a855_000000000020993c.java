import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        int t;

        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();

        for(int i=0;i<t;i++) {
            int n = scanner.nextInt();
            ArrayList<String> inputStrings = new ArrayList<>();
            while(inputStrings.size() != (n + 1)) {
                inputStrings.add(scanner.nextLine());
            }
            inputStrings.remove(0);
            inputStrings.remove("");
            System.out.println("Case #" + (i + 1) + ": " + (new MatrixProfile(n, inputStrings).krcResponse()));
        }

        scanner.close();
    }

    static class MatrixProfile {

        int n;
        ArrayList<String> inputStrings;

        public MatrixProfile(int n, ArrayList<String> inputStrings) {
            this.n = n;
            this.inputStrings = inputStrings;
        }

        public String krcResponse() {

            int[][] matrix = new int[n][];
            HashSet<Integer> repeatedRows = new HashSet<>();
            HashSet<Integer> repeatedColumns = new HashSet<>();

            for (int row=0; row < inputStrings.size(); row++) {
                String[] spilt = inputStrings.get(row).split(" ");

                HashSet<Integer> repeated = new HashSet<>();
                for(int column=0; column < spilt.length; column++) {
                    if(matrix[row] == null) matrix[row] = new int[n];
                    matrix[row][column] = Integer.parseInt(spilt[column]);
                    repeated.add(matrix[row][column]);
                }

                if(repeated.size() != n) repeatedRows.add(row);

            }

            for (int column=0; column < n; column++) {
                HashSet<Integer> repeated = new HashSet<>();
                for (int row=0; row < n; row++) {
                    repeated.add(matrix[row][column]);
                }
                if(repeated.size() != n) repeatedColumns.add(column);
            }

            int sum = matrix[0][0] + matrix[1][1] + matrix[2][2] + matrix[3][3];

            return sum + " " + repeatedRows.size() + " " + repeatedColumns.size();
        }

    }

}
