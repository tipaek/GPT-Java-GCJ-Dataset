
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static List<List<Integer>> listOfList = null;
    private static int SIZE = 0;
    private static int[][] matrix = null;
        public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        for (int tc = 1; tc <= T; tc++)
        {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            SIZE =N;
            listOfList = new ArrayList<>();
            findCombinations(K, N );
            boolean isSolutionFound = false;
            for(List<Integer> list : listOfList)
            {
                matrix = new int[N][N];
                for(int i=0; i< N ; i++)
                {
                    matrix[i][i] = list.get(i);
                }
                if (solveSudoku())
                {
                    isSolutionFound = true;
                    break;
                }
                else
                    {
                    isSolutionFound = false;
                }
            }
            if(isSolutionFound) {
                System.out.println("Case #" + tc + ": POSSIBLE");
                print(matrix, N);
            }
            else
                System.out.println("Case #"+tc+": IMPOSSIBLE");
        }
        scanner.close();
    }

    private static void findCombinationsUtil(int[] arr, int index, int num, int reducedNum, int digit)
    {
        if (reducedNum < 0)
            return;
        if (reducedNum == 0 )
        {
            if(index==digit)
            {
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < index; i++)
                {
                    if(arr[i]>digit)
                        return;
                    list.add(arr[i]);
                }
                listOfList.add(list);
            }
            return;
        }
        int prev = (index == 0) ? 1 : arr[index - 1];
        for (int k = prev; k <= num ; k++)
        {
            arr[index] = k;
            findCombinationsUtil(arr, index + 1, num,reducedNum - k, digit);
        }
    }

    private static void findCombinations(int n, int digit)
    {
        int[] arr = new int[n];
        findCombinationsUtil(arr, 0, n, n, digit);
    }

    private static void print(int[][] board, int N)
    {
        for (int r = 0; r < N; r++)
        {
            for (int d = 0; d < N; d++)
            {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static void printSudoku()
    {
        for(int i=0;i<SIZE;i++)
        {
            for(int j=0;j<SIZE;j++)
            {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println("");
        }
    }

    private static int[] numberUnassigned(int row, int col)
    {
        int numunassign = 0;
        for(int i=0;i<SIZE;i++)
        {
            for(int j=0;j<SIZE;j++)
            {
                if(matrix[i][j] == 0)
                {
                    row = i;
                    col = j;
                    numunassign = 1;
                    int[] a = {numunassign, row, col};
                    return a;
                }
            }
        }
        int[] a = {numunassign, -1, -1};
        return a;
    }

    private static boolean isSafe(int n, int r, int c)
    {
        for(int i=0;i<SIZE;i++)
        {
            if(matrix[r][i] == n)
                return false;
        }
        for(int i=0;i<SIZE;i++)
        {
            if(matrix[i][c] == n)
                return false;
        }
        return true;
    }
    private static boolean solveSudoku()
    {
        int row=0;
        int col=0;
        int[] a = numberUnassigned(row, col);
        if(a[0] == 0)
            return true;
        row = a[1];
        col = a[2];
        for(int i=1;i<=SIZE;i++)
        {
            if(isSafe(i, row, col))
            {
                matrix[row][col] = i;
                if(solveSudoku())
                    return true;
                matrix[row][col]=0;
            }
        }
        return false;
    }
}
