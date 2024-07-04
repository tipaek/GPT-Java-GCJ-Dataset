import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Scratch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int testCases = Integer.parseInt(in.nextLine()); //  Integer.parseInt(System.console().readLine());

        for (int testCase = 0; testCase < testCases; testCase++) {
            int dim = Integer.parseInt(in.nextLine());

            int[][] arr = new int[dim][dim];

            for (int j = 0; j < dim; j++) {
                String line  = in.nextLine();

                int col = 0;
                for (String currVal : line.split(" ")) {
                    arr[j][col] = Integer.parseInt(currVal);
                    col++;
                }
            }

            int dupsRows = 0;
            int dupCols = 0;
            int trace = 0;

            // go over lines
            for (int row = 0; row < dim; row++) {
                Set<Integer> rowVals = new HashSet<>();
                Set<Integer> colVals = new HashSet<>();
                for (int col = 0; col < dim; col++) {
                    rowVals.add(arr[row][col]);
                    colVals.add(arr[col][row]);
                }
                trace+= arr[row][row];
                if (rowVals.size() < dim) dupsRows++;
                if (colVals.size() < dim) dupCols++;
            }

            System.out.println(String.format("Case #%s: %s %s %s", testCase + 1, trace, dupsRows, dupCols));
        }

    }
}