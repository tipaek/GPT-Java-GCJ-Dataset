import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author hum
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        String result = "Case #%d: %d";
        for (int cas = 1; cas <= n; cas++) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            int[][] arr = new int[row][col];
            int sum = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    arr[i][j] = sc.nextInt();
                    sum += arr[i][j];
                }
            }
            int res = sum;
            int count = -1;
            while (count != 0) {
                count = 0;
                List<int[]> list = new ArrayList<>();
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        if (arr[i][j] == 0) {
                            continue;
                        }
                        int nei = 0;
                        int neiScore = 0;
                        int x = i - 1;
                        int y = j;
                        while (x >= 0 && arr[x][y] == 0) {
                            x--;
                        }
                        if (x >= 0) {
                            nei += 1;
                            neiScore += arr[x][y];
                        }
                        x = i + 1;
                        y = j;
                        while (x < row && arr[x][y] == 0) {
                            x++;
                        }
                        if (x < row) {
                            nei += 1;
                            neiScore += arr[x][y];
                        }
                        x = i;
                        y = j - 1;
                        while (y >= 0 && arr[x][y] == 0) {
                            y--;
                        }
                        if (y >= 0) {
                            nei += 1;
                            neiScore += arr[x][y];
                        }
                        x = i;
                        y = j + 1;
                        while (y < col && arr[x][y] == 0) {
                            y++;
                        }
                        if (y < col) {
                            nei += 1;
                            neiScore += arr[x][y];
                        }
                        if (arr[i][j] * nei < neiScore) {
                            list.add(new int[]{i, j});
                        }
                    }
                }
                for (int[] ints : list) {
                    count += arr[ints[0]][ints[1]];
                    arr[ints[0]][ints[1]] = 0;
                }
                if (count != 0) {
                    res += sum - count;
                    sum = sum - count;
                }
            }
            System.out.println(String.format(result, cas, res));
        }
    }
}