import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter pw = new PrintWriter(System.out);
        
        try {
            int t = Integer.parseInt(br.readLine());
            for(int zx=1 ; zx<=t ; zx++) {
                int n = Integer.parseInt(br.readLine());
                int[][] mat = new int[n][n];

                for(int i=0 ; i<n ; i++) {
                    st = new StringTokenizer(br.readLine());
                    for(int j=0 ; j<n ; j++) {
                        mat[i][j] = Integer.parseInt(st.nextToken());
                    }
                }

                long sum = 0;
                for(int i=0 ; i<n ; i++) {
                    sum += mat[i][i];
                }

                int row_count = 0;
                int col_count = 0;
                for(int i=0 ; i<n ; i++) {
                    HashSet<Integer> hs = new HashSet<>();

                    for(int j=0 ; j<n ; j++) {
                        if(hs.contains(mat[i][j])) {
                            row_count++;
                            break;
                        }
                        hs.add(mat[i][j]);
                    }

                    hs = new HashSet<>();
                    for(int j=0 ; j<n ; j++) {
                        if(hs.contains(mat[j][i])) {
                            col_count++;
                            break;
                        }
                        hs.add(mat[j][i]);
                    }
                }

                pw.println("Case #" + zx + ": " + sum + " " + row_count + " " + col_count);
            }
        }
        finally {
            pw.flush();
            pw.close();
        }
    }
}
