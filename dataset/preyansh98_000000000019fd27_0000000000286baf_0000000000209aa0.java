import java.io.*;
import java.util.*;

class Solution {
    private static int[][] _solved;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 1; i<=T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N  = Integer.parseInt(st.nextToken());
            int trace = Integer.parseInt(st.nextToken());

            String soln = solve(N, trace);

            if(soln.equals("POSSIBLE")) {
                System.out.println("Case #" + i + ": " + soln);
                //print board
                for(int row = 0; row<N; row++)
                    System.out.println(Arrays.toString(_solved[row]));
            }
            else if(soln.equals("IMPOSSIBLE"))
                System.out.println("Case #" + i + ": " + soln);
        }
    }

    private static String solve(int N, int T){
        if(T % N != 0) return "IMPOSSIBLE";

        int[][] board = new int[N][N];

        return solve(N, T/N, board);
    }

    private static String solve(int n, int t, int[][] board) {

        int[] next = findNext(board);
        int i = next[0], j = next[1];

        if(i == -1){
            _solved = board;
            return "POSSIBLE";
        }

        if(i == j) {
            board[i][j] = t;
            return solve(n, t, board);
        }

        for(int cand = 0; cand<=n; ++cand){
            if(cand == t) continue;

            if(isValid(board, i, j, cand)){
                board[i][j] = cand;

                if(solve(n, t, board).equals("POSSIBLE"))
                    return "POSSIBLE";

                board[i][j] = 0;
            }
        }

        return "IMPOSSIBLE";
    }

    private static int[] findNext(int[][] board){
        for(int i = 0; i<board.length; i++){
            for(int j = 0;j<board[i].length; j++){
                if(board[i][j] == 0)
                    return new int[]{i,j};
            }
        }

        return new int[]{-1,-1};
    }

    private static boolean isValid(int[][] board, int i, int j, int cand){

        for(int x = 0; x<board.length; x++)
            if(board[x][j] == cand) return false;

        for(int x = 0; x<board[0].length; x++)
            if(board[i][x] == cand) return false;

        return true;
    }
}