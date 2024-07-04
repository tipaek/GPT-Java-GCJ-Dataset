import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int noOfTests = Integer.parseInt(scanner.nextLine());
        for (int caseNo = 1; caseNo <= noOfTests; caseNo++)
        {
            int n = Integer.parseInt(scanner.nextLine());

            // Read the matrix in
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++)
            {
                String[] row = scanner.nextLine().split(" ");
                for (int j = 0; j < n; j++)
                {
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
            }

            int trace = 0;

            int rowsWithDuplicates = 0;
            int colsWithDuplicates = 0;
            HashSet<Integer> rowValues = new HashSet<>();
            HashSet<Integer> colValues = new HashSet<>();
            boolean rowHasDuplicates;
            boolean colHasDuplicates;

            for (int i = 0; i < n; i++)
            {
                rowValues.clear();
                colValues.clear();
                rowHasDuplicates = false;
                colHasDuplicates = false;

                for (int j = 0; j < n; j++)
                {
                    // Terminate early if both row and col have duplicates
                    if (rowHasDuplicates && colHasDuplicates)
                    {
                        break;
                    }

                    // Check if current row has duplicates
                    if (!rowHasDuplicates && rowValues.contains(matrix[i][j]))
                    {
                        rowsWithDuplicates++;
                        rowHasDuplicates = true;
                    }
                    rowValues.add(matrix[i][j]);

                    // Check if current col has duplicates
                    if (!colHasDuplicates && colValues.contains(matrix[j][i]))
                    {
                        colsWithDuplicates++;
                        colHasDuplicates = true;
                    }
                    colValues.add(matrix[j][i]);
                }

                // Calculate trace
                trace += matrix[i][i];
            }

            System.out.println("Case #" + caseNo + ": " + trace + " " + rowsWithDuplicates + " " + colsWithDuplicates);
        }
    }
}
