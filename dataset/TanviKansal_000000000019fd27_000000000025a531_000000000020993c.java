import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Vestigium {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t= Integer.parseInt(br.readLine());
        while (t>0) {
            int size;
            size = Integer.parseInt(br.readLine());
            int matrix[][] = new int[size][size];
            for(int row =0 ;row< size;row++){
                StringTokenizer line = new StringTokenizer(br.readLine(),",");
                for(int col=0;col<size;col++)
                    matrix[row][col] = Integer.parseInt(line.nextToken());
            }
            int trace = 0;
            int countOfRowsWithDuplicate = 0;
            int countOfColumnsWithDuplicate = 0;
            int colCount[];
            int rowCount[];
            for (int row = 0; row < matrix.length; row++) {
                int noOfDuplicateElementsInRow = 0;
                int noOfDuplicateElementsInCol = 0;
                rowCount = new int[matrix.length];
                colCount = new int[matrix.length];
                for (int col = 0; col < matrix[row].length; col++) {
                    if (row == col)
                        trace += matrix[row][col];
                    rowCount[matrix[row][col] - 1] += 1;
                    if (rowCount[matrix[row][col] - 1] == 2) {
                        noOfDuplicateElementsInRow += 1;
                    }
                    colCount[matrix[col][row] - 1] += 1;
                    if (colCount[matrix[col][row] - 1] == 2)
                        noOfDuplicateElementsInCol += 1;
                }
                if (noOfDuplicateElementsInCol > 0)
                    countOfColumnsWithDuplicate += 1;
                if (noOfDuplicateElementsInRow > 0)
                    countOfRowsWithDuplicate += 1;
            }

            System.out.println("Case #"+t+":"+" "+trace + " " + countOfRowsWithDuplicate + " " + countOfColumnsWithDuplicate);
            t--;
        }
    }

}
