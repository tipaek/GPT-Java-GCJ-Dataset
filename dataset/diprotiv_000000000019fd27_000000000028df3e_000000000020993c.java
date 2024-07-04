import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for(int t = 1; t <= test; t++) {
            int n = Integer.parseInt(br.readLine());
            int X[][] = new int[n][n];
            for(int i = 0; i < n; i++) {
                String input[] = ((br.readLine()).trim()).split("\\s+");
                for(int j = 0; j < n; j++) {
                    X[i][j] = Integer.parseInt(input[j]);
                }
            }

            int trace = 0;
            int rows = 0;
            int cols = 0;
            for(int i = 0; i < n; i++) {
                trace += X[i][i];
            }
            HashSet<Integer> h = new HashSet<>();
            for(int i = 0; i < n; i++) {
                h.clear();
                for(int j = 0; j < n; j++) {
                    h.add(X[i][j]);
                }
                if(h.size() != n) {
                    rows++;
                }
            }
            for(int j = 0; j < n; j++) {
                h.clear();
                for(int i = 0; i < n; i++) {
                    h.add(X[i][j]);
                }
                if(h.size() != n) {
                    cols++;
                }
            }
            System.out.println(String.format("Case #%d: %d %d %d", t, trace, rows, cols));
        }
    }
}
