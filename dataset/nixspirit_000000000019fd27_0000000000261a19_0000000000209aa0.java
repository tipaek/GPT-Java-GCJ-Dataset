
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution
{

    public static void main(String[] args)
    {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();

        //   System.out.println("read T=" + t);
        for (int i = 1; i <= t; ++i)
        {
            int[] line = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            // System.out.println("read line=" + line);
            SolutionData solve = solve(line[0], line[1]);
            System.out.println(String.format("Case #%d: %s%s",
                    i,
                    solve.isPossible() ? "POSSIBLE" : "IMPOSSIBLE",
                    solve.isPossible() ? "\n" + solve.getMatrixAsString() : ""
                    )
            );
        }
    }

    public static SolutionData solve(int n, int k)
    {
        List<int[]> traces = findPossibleTraces(n, k);
        if (traces.isEmpty())
            return SolutionData.IMPOSSIBLE;

        //  for (int[] trace : traces) System.out.println(">>>> TRACE=" + Arrays.toString(trace));

        int[][] square;
        for (int[] trace : traces)
        {
            square = new int[n][n];
            fillWithTrace(square, trace);
            if (solveSquare(square))
                return new SolutionData(true, square);
        }

        return SolutionData.IMPOSSIBLE;
    }

    private static boolean solveSquare(int[][] square)
    {
        return solveSquare(square, 0, 0, new SquareChecker(square));
    }

    private static boolean solveSquare(int[][] square, int i, int j, SquareChecker checker)
    {
        if (i == square.length)
            return true;

        Cell next = nextCell(i, j, square.length);

        if (square[i][j] != 0)
            return solveSquare(square, next.i, next.j, checker);

        for (int candidate = 1; candidate <= square.length; candidate++)
        {
            if (checker.canPlace(i, j, candidate))
            {
                checker.place(i, j, candidate);
                square[i][j] = candidate;

                if (solveSquare(square, next.i, next.j, checker))
                    return true;

                checker.remove(i, j, candidate);
                square[i][j] = 0;
            }
        }

        return false;
    }

    private static Cell nextCell(int i, int j, int n)
    {
        if (j == n - 1)
            return new Cell(i + 1, 0);

        return new Cell(i, j + 1);
    }

    private static List<int[]> findPossibleTraces(int n, int k)
    {
        List<int[]> traces = new ArrayList<>();

        int[] buffer = new int[n];
        doFindPossibleTraces(n, k, buffer, 0, 0, traces);
        return traces;
    }

    private static void doFindPossibleTraces(int n, int k, int[] buffer, int bi, int sum, List<int[]> traces)
    {
        if (sum > k)
            return;

        if (bi == buffer.length)
        {
            if (sum == k)
                traces.add(buffer.clone());

            return;
        }

        for (int i = 1; i <= n; i++)
        {
            buffer[bi] = i;
            sum += i;
            doFindPossibleTraces(n, k, buffer, bi + 1, sum, traces);
            sum -= i;
        }
    }

    private static void fillWithTrace(int[][] square, int[] trace)
    {
        for (int i = 0; i < square.length; i++)
            square[i][i] = trace[i];
    }

    public static class SolutionData
    {
        public static final SolutionData IMPOSSIBLE = new SolutionData(false, null);

        private final int[][] square;

        private boolean possible;

        public String getMatrixAsString()
        {
            if (!possible)
                return "";

            StringBuilder s = new StringBuilder();
            for (int[] r : square)
                s.append(IntStream.of(r).mapToObj(String::valueOf).collect(Collectors.joining(" "))).append('\n');
            return s.toString();
        }

        public boolean isPossible()
        {
            return possible;
        }

        SolutionData(boolean possible, int[][] mtx)
        {
            this.possible = possible;
            this.square = mtx;
        }
    }

    public static class SquareChecker
    {

        public boolean canPlace(int i, int j, int candidate)
        {
            if (row[i][candidate])
                return false;

            if (col[j][candidate])
                return false;

            return true;
        }

        public void place(int i, int j, int candidate)
        {
            if (!canPlace(i, j, candidate))
                return;

            row[i][candidate] = true;
            col[j][candidate] = true;
        }

        public void remove(int i, int j, int candidate)
        {
            row[i][candidate] = false;
            row[j][candidate] = false;
        }

        private final boolean[][] row;
        private final boolean[][] col;

        public SquareChecker(int[][] square)
        {
            row = new boolean[square.length][square.length + 1];
            col = new boolean[square.length][square.length + 1];

            for (int i = 0; i < square.length; i++)
            {
                for (int j = 0; j < square.length; j++)
                {
                    if (square[i][j] != 0)
                        place(i, j, square[i][j]);
                }
            }
        }
    }

    public static class Cell
    {
        public Cell(int i, int j)
        {
            this.i = i;
            this.j = j;
        }

        int i;
        int j;
    }
}
