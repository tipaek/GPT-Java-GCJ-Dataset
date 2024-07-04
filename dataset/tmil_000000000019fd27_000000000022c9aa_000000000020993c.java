
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nt = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= nt; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int trace = 0;
            HashSet<Integer>[] itemsByRow = new HashSet[n];
            HashSet<Integer>[] itemsByCol = new HashSet[n];
            HashSet<Integer> rowNums = new HashSet<>();
            HashSet<Integer> colNums = new HashSet<>();

            for (int i = 0; i < n; i++) {
                itemsByCol[i] = new HashSet<>();
                itemsByRow[i] = new HashSet<>();
                trace += map[i][i];
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (itemsByCol[j].contains(map[i][j])) colNums.add(j);
                    if (itemsByRow[i].contains(map[i][j])) rowNums.add(i);
                    itemsByCol[j].add(map[i][j]);
                    itemsByRow[i].add(map[i][j]);
                }
            }
            System.out.println("Case #" + tc + ": " + trace + " " + rowNums.size() + " " + colNums.size());
        }
    }
}
