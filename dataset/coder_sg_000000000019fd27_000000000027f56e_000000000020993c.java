import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Solution {

        public static void main( String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int t = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            for (int tC = 1; tC <= t; tC++) {
                int n = Integer.parseInt(br.readLine());

                int[][] m = new int[n][n];

                for (int i = 0; i < n; i++) {
                    String[] row = br.readLine().split(" ");
                    for (int j = 0; j < n; j++) 
                        m[i][j] = Integer.parseInt(row[j]);
                }

                int k = 0;

                for (int i = 0; i < n; i++)
                    k += m[i][i];

                int r = 0;

                for (int i = 0; i < n; i++) {
                    Set<Integer> set = new HashSet<>();
                    for (int j = 0; j < n; j++) {
                        if (set.contains(m[i][j])) {
                            r++;
                            break;
                        }
                        set.add(m[i][j]);
                    }
                }

                int c = 0;

                for (int i = 0; i < n; i++) {
                    Set<Integer> set = new HashSet<>();
                    for(int j = 0; j < n; j++) {
                        if(set.contains(m[j][i])) {
                            c++;
                            break;
                        }
                        set.add(m[j][i]);
                    }
                }

                sb.append("Case #"+tC+": "+k+" "+r+" "+c+"\n");
            }
            System.out.println(sb);
    } 
}