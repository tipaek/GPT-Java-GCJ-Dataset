import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;
import java.util.List;

public class Solution {

   Scanner             sc       = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    PrintStream         out      = System.out;
    Set<Point> seen = new HashSet<>();
    List<List<Integer>> matrix;

    private void solve() {
        int N = sc.nextInt();
        seen = new HashSet<>();
        seen.add(new Point(0,0));
        List<int[]> rst = new ArrayList<>();
        if(N==501){
            case2(rst);
        }else {
            case1(rst, N);
        }
        case1(rst, N);
//        List<int[]> temp = new ArrayList<>();
//        temp.add(new int[]{0,0});
//        dfs(matrix, 0, 0, temp, rst, N-1);
        for(int[] row : rst) {
            out.println((row[0]+1) + " " + (row[1]+1));
        }
    }

    private void case1(List<int[]> list, int N) {
        for(int i=0;i<N;i++) {
            list.add(new int[]{i, i});
        }
    }

    private void case2(List<int[]> list){
        list.add(new int[]{0,0});
        list.add(new int[]{1,0});
        list.add(new int[]{2,1});
        for(int i=3;i<500;i++) {
            list.add(new int[]{i, 0});
        }
    }

    static List<Integer> printConsecutive(int last, int first)
    {
        List<Integer> list = new ArrayList<>();
        list.add(first++);
        for (int x = first; x<= last; x++)
            list.add(x);
        return list;
    }

    public List<Integer> findConsecutive(int N)
    {
        for (int last=1; last<N; last++)
        {
            for (int first=0; first<last; first++)
            {
                if (2*N == (last-first)*(last+first+1))
                {
                    return printConsecutive(last, first+1);
                }
            }
        }
        return null;
    }

    public void dfs(List<List<Integer>> matrix, int i, int j,
                    List<int[]> temp,  List<int[]> list, int N){

        if(N<0){
            return;
        }
        if(N==0){
            list.clear();
            list.addAll(temp);
            return;
        }

        int[][] dir = new int[][]{{-1, -1}, {-1, 0}, {0, -1}, {0, 1}, {1, 0}, {1, 1}};

        for(int[] d : dir){
            int x = i + d[0];
            int y = j + d[1];

            if(x>=0 && y>=0 && !seen.contains(new Point(x,y)) && matrix.size()>x && matrix.get(x).size()>y){
                temp.add(new int[]{x,y});
                int prev = matrix.get(x).get(y);
                seen.add(new Point(x,y));

                dfs(matrix, x, y, temp, list, N-prev);

                seen.remove(new Point(x,y));
                temp.remove(temp.size()-1);
            }
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        // First base case; if user requests zero rows, they get zero rows.
        if (numRows == 0) {
            return triangle;
        }

        // Second base case; first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);

            // The first row element is always 1.
            row.add(1);

            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // The last row element is always 1.
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }

    private void run() throws Exception {
        matrix = generate(25);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            out.println("Case #" + i + ": ");
            solve();
        }
        sc.close();
        out.close();
    }
    
    public static void main(String args[]) throws Exception {
        new Solution().run();
    }
}
