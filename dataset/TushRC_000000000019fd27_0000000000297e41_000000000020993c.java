import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution
{
    public static void main(String[] args)
    {
        List<CandidateMatrix> matrices = readInputFromConsole(System.in);
        matrices.forEach(mat ->
                System.out.println(String.format("Case #%d: %d %d %d",
                        mat.getCaseNumber(),
                        getTrace(mat),
                        getNumberOfInvalidRows(mat),
                        getNumberOfInvalidCols(mat))));
    }

    private static class CandidateMatrix
    {
        private int[][] squareMatrix;
        private int caseNumber;
        private int matrixSize;

        public CandidateMatrix (int[][] squareMatrix, int caseNumber, int matrixSize)
        {
            this.squareMatrix = squareMatrix;
            this.caseNumber = caseNumber;
            this.matrixSize = matrixSize;
        }

        public int[][] getSquareMatrix()
        {
            return this.squareMatrix;
        }

        public int getCaseNumber()
        {
            return this.caseNumber;
        }

        public int getMatrixSize()
        {
            return this.matrixSize;
        }
    }

    private static int getNumberOfInvalidRows (CandidateMatrix matrix)
    {
        int invalidRows = 0;
        for (int r = 0; r < matrix.getMatrixSize(); r++)
        {
            if (isInvalid(matrix.getSquareMatrix()[r]))
            {
                invalidRows ++;
            }
        }
        return invalidRows;
    }

    private static int getNumberOfInvalidCols (CandidateMatrix matrix)
    {
        int invalidCols = 0;
        for (int c = 0; c < matrix.getMatrixSize(); c++)
        {
            int[] col = new int[matrix.getMatrixSize()];
            for (int r = 0; r < matrix.getMatrixSize(); r++)
            {
                col[r] = matrix.getSquareMatrix()[r][c];
            }
            if (isInvalid(col))
            {
                invalidCols ++;
            }
        }
        return invalidCols;
    }

    private static boolean isInvalid (int[] arrayInt)
    {
        return IntStream.of(arrayInt)
                .boxed()
                .collect(Collectors.toSet()).size() < arrayInt.length;
    }

    private static int getTrace (CandidateMatrix matrix)
    {
        int trace = 0;
        for (int i = 0; i < matrix.getMatrixSize(); i++)
        {
            trace += matrix.getSquareMatrix()[i][i];
        }
        return trace;
    }

    private static List<CandidateMatrix> readInputFromConsole (InputStream inputStream)
    {
        List<CandidateMatrix> candidates;
        try (Scanner console = new Scanner(new BufferedReader(new InputStreamReader(inputStream))))
        {
            int numberOfCases = 0;
            if (console.hasNextLine())
            {
                Scanner firstLine = new Scanner(console.nextLine());
                if (firstLine.hasNextInt())
                {
                    numberOfCases = firstLine.nextInt();

                }
                if (numberOfCases == 0)
                {
                    return Collections.emptyList();
                }
            }

            candidates = new ArrayList<>(numberOfCases);
            for (int i = 1; i <= numberOfCases; i++)
            {
                int N = readSize(new Scanner(console.nextLine()));
                int[][] matrix = new int[N][N];
                for (int r = 0; r < N; r++)
                {
                    if (console.hasNextLine())
                    {
                        matrix[r] = readRow(new Scanner(console.nextLine()), N);
                    }
                }
                candidates.add(new CandidateMatrix(matrix, i, N));
            }
        }
        return candidates;
    }

    private static int readSize (Scanner line)
    {
        if(line.hasNextInt())
        {
            return line.nextInt();
        }
        else return 0;
    }

    private static int[] readRow (Scanner matrixRow, int numberOfColumns)
    {
        int[] row = new int[numberOfColumns];
        int i = 0;
        while (matrixRow.hasNextInt())
        {
            row[i++] = matrixRow.nextInt();
        }
        return row;
    }

}
