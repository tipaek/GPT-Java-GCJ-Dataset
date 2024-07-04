import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Solution {

    static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x; this.y = y;
        }
    }

    static int solve(Scanner scanner) {
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int[][] mat = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0;j < c; j++) {
                mat[i][j] = scanner.nextInt();
            }
        }
        List<Pair> outP = new ArrayList<>();
        int interest = 0;
        do {
            for (Pair pair : outP) {
                mat[pair.x][pair.y] = 0;
            }
            outP.clear();
            for (int i = 0; i < r; i++) {
                candidate:
                for (int j = 0; j < c; j++) {
                    if (mat[i][j] == 0) {
                        continue;
                    }
                    interest += mat[i][j];
                    int sum = 0;
                    int count = 0;
                    int temp = 1;
                    while (i + temp < r && mat[i + temp][j] == 0 ) {
                        temp++;
                    }
                    if (i + temp < r && mat[i + temp][j] != 0) {
                        sum += mat[i+temp][j];
                        count++;
                    }
                    temp = 1;
                    while (i - temp >= 0 && mat[i - temp][j] == 0 ) {
                        temp++;
                    }
                    if (i - temp >= 0 && mat[i - temp][j] != 0) {
                        sum += mat[i-temp][j];
                        count++;
                    }
                    temp = 1;
                    while (j + temp < c && mat[i][j + temp] == 0) {
                        temp++;
                    }
                    if (j + temp < c && mat[i][j + temp] != 0) {
                        sum += mat[i][j+temp];
                        count++;
                    }
                    temp = 1;
                    while (j- temp >= 0 && mat[i][j-temp] == 0) {
                        temp++;
                    }
                    if (j- temp >= 0 && mat[i][j-temp] != 0) {
                        sum += mat[i][j-temp];
                        count++;
                    }
                    if (mat[i][j] * count < sum) {
                        outP.add(new Pair(i, j));
                    }
                }
            }
        } while (!outP.isEmpty());
        return interest;
    }

    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        Scanner scanner = new Scanner(new BufferedReader(new FileReader("test_case.txt")));
        int nr = scanner.nextInt();
        for (int i = 0; i < nr; i++) {
            System.out.printf("Case #%d: %d\n", i+1, solve(scanner));
        }
    }
}
