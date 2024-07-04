import java.util.*;

public class Solution {

    private void printAnswer(int T,boolean flag, int[][] board){
        String ans = flag? "POSSIBLE":"IMPOSSIBLE";
        System.out.println("Case #" + T + ": " + ans);
        if(flag){
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[i].length; j++){
                    System.out.print(board[i][j]);
                    if(j != board[i].length - 1)
                        System.out.print(" ");
                }
                System.out.println();
            }
        }
        return ;
    }


    private boolean isValid(int[][] board, int x, int y, int val){

        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length)
            return false;

        for(int i = 0; i < board.length; i++){
            if(board[i][y] == val)
                return false;
        }

        for(int j = 0; j < board[0].length; j++){
            if(board[x][j] == val)
                return false;
        }

        return true;
    }

    private boolean isSolved(int[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 0)
                    return false;
            }
        }
        return true;
    }

    private boolean solve(int[][] board, int x, int y){
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length)
            return false;

        if(isSolved(board))
            return true;
        if(board[x][y] != 0)
            return solve(board, x + (y + 1) / board.length, (y + 1)%board.length);

        for(int i = 1; i <= board.length; i++){
            if(isValid(board, x, y, i)){
                board[x][y] = i;

                if(solve(board, x + (y + 1) / board.length, (y + 1)%board.length))
                    return true;

                board[x][y] = 0;
            }

        }
        return false;
    }
    private void fillBoard(int trace, int[][] board){
        int sum = 0;
        int ind = 0;

        while(sum < trace && ind < board.length){
            board[ind][ind] = 1;
            ind++;
            ++sum;
        }

        ind = 0;
        while(sum < trace && ind < board.length){
            board[ind][ind] = Math.min(board.length, board[ind][ind] + trace - sum);
            sum += board[ind][ind] - 1;
            ind++;
        }
    }

    private boolean findAnswer(int n, int trace, int[][] board){
        int min = n;
        int maxi = n * n;

        if(trace == min + 1 || trace == maxi - 1 ||trace < min || trace > maxi)
            return false;

        for(int[] b: board){
            Arrays.fill(b, 0);
        }

        fillBoard(trace, board);
        return solve(board,0, 0);
        // return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Solution s1 = new Solution();
        int T = sc.nextInt();
        int count = 1;
        while(count <= T){
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[][] board = new int[N][N];
            boolean ans = s1.findAnswer(N, K, board);
            s1.printAnswer(count,ans, board);
            count++;
        }
    }
}
