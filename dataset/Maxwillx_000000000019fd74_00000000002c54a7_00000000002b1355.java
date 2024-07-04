import java.util.*;
class Solution {
    public static void main(String[] arg) {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        int testCnt = 0;
        String line = sc.nextLine();
        testCnt = Integer.parseInt(line);
        for (int k = 0; k < testCnt; k++) {
            String[] dim = sc.nextLine().split("\\s+");
            int m = Integer.parseInt(dim[0]), n = Integer.parseInt(dim[1]);
            int[][] M = new int[m][n];
            for (int i = 0; i < m; i++) {
                line = sc.nextLine();
                String[] vals = line.split("\\s+");
                for (int j = 0; j < n; j++) {
                    M[i][j] = Integer.parseInt(vals[j]);
                }
            }
            s.solve(M, k + 1);
        }
    }
    private void solve(int[][] matrix, int id) {
        int m = matrix.length, n = matrix[0].length, sum = 0, interest = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum += matrix[i][j];
            }
        }
        interest = sum;
        List<int[]> toDelete = scanM(matrix);
        while (toDelete.size() != 0) {
            for (int[] p : toDelete) {
                sum -= matrix[p[0]][p[1]];
                matrix[p[0]][p[1]] = -1;
            }
            interest += sum;
            toDelete = scanM(matrix);
        }
        print(interest, id);
    }
    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{-1, 0, 1, 0};
    private List<int[]> scanM(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == -1) continue;
                int sum = 0, cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k], ny = j + dy[k];
                    while (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                        if (matrix[nx][ny] != -1) {
                            sum += matrix[nx][ny];
                            cnt++;
                            break;
                        }
                        nx = nx + dx[k];
                        ny = ny + dy[k];
                    }
                }
                if (cnt * matrix[i][j] < sum) res.add(new int[]{i, j});
            }
        }
        return res;
    }
    private void print(int sum, int id) {
        System.out.print("Case #" + Integer.toString(id) + ": ");
        System.out.println(Integer.toString(sum));
    }
}