import java.util.*;

public class Solution {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int caseNum = input.nextInt();
        for (int ks = 1; ks <= caseNum; ks++) {
            System.out.println(String.format("Case #%d: %s", ks, new Solution().solve(input)));
        }
    }

    public String solve(Scanner scanner) {
        int N = scanner.nextInt();

        int[][] M = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) M[i][j] = scanner.nextInt();
        }

        int trace = 0;
        for (int i = 0; i < N; i++) trace += M[i][i];

        int r = 0;
        int c = 0;

        for (int i = 0; i < N; i++) {
            int[] row = new int[N];
            for (int j = 0; j < N; j++) row[j] = M[i][j];
            if (check(row)) r++;
        }

        for (int j = 0; j < N; j++) {
            int[] col = new int[N];
            for (int i = 0; i < N; i++) col[i] = M[i][j];
            if (check(col)) c++;
        }
        return String.valueOf(trace + " " + r + " " + c);
    }

    public boolean check(int[] arr) {
        int len = arr.length;
        if (len < 1) return false;
        Arrays.sort(arr);
        int prev = arr[0];
        for (int i = 1; i < len; i++) {
            if (prev == arr[i]) return true;
            prev = arr[i];
        }
        return false;
    }
}
