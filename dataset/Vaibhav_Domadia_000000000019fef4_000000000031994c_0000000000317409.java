import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter pw = new PrintWriter(System.out);
        
        try {
            int t = Integer.parseInt(br.readLine());
            for(int testCase = 1 ; testCase <= t ; testCase++) {

                st = new StringTokenizer(br.readLine());
                int[][] a = new int[4004][4004];

                int x = Integer.parseInt(st.nextToken()) + 2000;
                int y = Integer.parseInt(st.nextToken()) + 2000;
                char[] c = st.nextToken().toCharArray();
                for(int i=0 ; i<c.length ; i++) {
                    if(c[i] == 'S') y--;
                    else if(c[i] == 'N') y++;
                    else if(c[i] == 'E') x--;
                    else if(c[i] == 'W') x++;

                    a[x][y] = (i+1);
                }

                boolean possible = false;
                int ans = Integer.MAX_VALUE;
                for(int i=0 ; i<4004 ; i++) {
                    for(int j=0 ; j<4004 ; j++) {
                        if(a[i][j] != 0) {
                            if(a[i][j] >= Math.abs(i-2000)+Math.abs(j-2000)) {
                                possible = true;
                                ans = Math.min(a[i][j], ans);
                            }
                        }
                    }
                }

                if(possible) {
                    pw.println("Case #" + testCase + ": " + ans);
                }
                else {
                    pw.println("Case #" + testCase + ": IMPOSSIBLE");
                }

            }
        }
        finally {
            pw.flush();
            pw.close();
        }
    }
}
