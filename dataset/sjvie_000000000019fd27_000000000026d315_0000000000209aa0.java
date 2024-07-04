import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amountCases = scanner.nextInt();

        for(int currentCase = 1; currentCase <= amountCases; currentCase ++){
            System.out.print("Case #" + currentCase + ": ");
            solve(scanner);
        }
    }

    public static void solve(Scanner scanner){
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[][] sq = new int[n][n];

        for (int i = 0; i < n; i++) {
            sq[i][i] = 1;
        }

        for (int i = 0; i < Math.pow(n, n); i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += sq[j][j];
            }
            if(sum == k){
                if(bt(sq, 0, 1)){
                    System.out.println("POSSIBLE");
                    print(sq);
                    return;
                }
            }
            for (int j = n-1; j >= 0; j--) {
                sq[j][j]++;
                if(sq[j][j] <= n){
                    break;
                }else{
                    sq[j][j] = 1;
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    public static boolean bt(int[][] sq, int r, int c){
        int n = sq.length;
        if(r == c){
            if(r == n-1){
                return true;
            }else{
                return bt(sq, r, c+1);
            }
        }
        for (int i = 1; i <= n; i++) {

            boolean viable = true;
            for (int j = 0; j < n; j++) {
                if(sq[r][j] == i || sq[j][c] == i){
                    viable = false;
                    break;
                }
            }
            if(viable){
                sq[r][c] = i;
                int nextR = (c == n-1)? r+1 : r;
                int nextC = (c == n-1)? 0 : c+1;

                if(bt(sq, nextR, nextC)){
                    return true;
                }
            }
        }

        sq[r][c] = 0;
        return false;
    }

    public static void print(int[][] sq){
        for (int r = 0; r < sq.length; r++) {
            for (int c = 0; c < sq.length; c++) {
                System.out.print(sq[r][c] + " ");
            }
            System.out.println();
        }
    }
}