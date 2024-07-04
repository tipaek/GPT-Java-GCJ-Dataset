import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int nbCases = Integer.parseInt(bufferedReader.readLine());

        for(int iCase = 0; iCase < nbCases; iCase++) {
            int trace = 0, rows = 0, columns = 0;
            int n = Integer.parseInt(bufferedReader.readLine());
            String [][] matrix = new String[n][n];

            for(int iN = 0; iN < n; iN++) {
                matrix[iN] = bufferedReader.readLine().split(" ");
            }

            for(int iRows = 0; iRows < n; iRows++) {
                HashSet<String> elements = new HashSet<>(Arrays.asList(matrix[iRows]));
                if(elements.size() != n) rows++;
                elements.clear();
                for(int iColumns = 0; iColumns < n; iColumns++) {
                    if(iColumns == iRows) trace += Integer.parseInt(matrix[iColumns][iRows]);
                    elements.add(matrix[iColumns][iRows]);
                }
                if(elements.size() != n) columns++;
            }

            System.out.println("Case #" + (iCase + 1) + ": " + trace + " " + rows + " " + columns);
        }
    }
}
