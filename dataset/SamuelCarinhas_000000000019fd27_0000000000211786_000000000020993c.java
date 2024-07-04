import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(input.readLine());
        for(int t = 1; t <= tests; t++) {
            int k = 0, r = 0, c = 0;
            int n = Integer.parseInt(input.readLine());
            int[][] arr = new int[n][n];
            for(int i = 0; i < n; i++) {
                StringTokenizer data = new StringTokenizer(input.readLine());
                for(int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(data.nextToken());
                }
            }
            for(int i = 0; i < n; i++) {
                Set<Integer> row = new HashSet<>(),
                        col = new HashSet<>();
                boolean ro = true, co = true;
                for(int j = 0; j < n; j++) {
                    if(i == j) k+= arr[i][j];
                    if(row.contains(arr[i][j]) && ro) {
                        r++;
                        ro = false;
                    }
                    if(col.contains(arr[j][i]) && co) {
                        c++;
                        co = false;
                    }
                    row.add(arr[i][j]);
                    col.add(arr[j][i]);
                }
            }

            System.out.println("Case #" + t + ": " + k + " " + r + " " + c);
        }
    }

}
