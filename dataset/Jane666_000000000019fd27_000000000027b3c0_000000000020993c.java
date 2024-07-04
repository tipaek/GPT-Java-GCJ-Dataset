import java.util.*;

class Solution {
    public static void solve(Scanner input, int t) {
        // get the input
        int N = input.nextInt();
        int[][] matrix = new int[N][N];
        int trace = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = input.nextInt();
                if (i == j) {
                    trace += matrix[i][j];
                }
            }
        }
        
        int r = 0, c = 0;
        for (int i = 0; i < N; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < N; j++) {
                if (!set.add(matrix[i][j])) {
                    r++;
                    break;
                }
            }
        }
        
        for (int j = 0; j < N; j++) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < N; i++) {
                if (!set.add(matrix[i][j])) {
                    c++;
                    break;
                }
            }
        }
        System.out.println("Case #" + t + ": " + trace + " " + r + " " + c);
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int i = 1; i <= T; i++) {
            solve(input, i);
        }
    }
}