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

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                char[] c = st.nextToken().toCharArray();
                int n = c.length;
                int ans = Integer.MAX_VALUE;
                for(int i=0 ; i<c.length ; i++) {
                    if(c[i] == 'S') y--;
                    else if(c[i] == 'N') y++;
                    else if(c[i] == 'E') x++;
                    else if(c[i] == 'W') x--;

                    if(Math.abs(x) + Math.abs(y) <= (i+1)) {
                        ans = Math.min(ans, i+1);
                    }
                }


                if(ans != Integer.MAX_VALUE) {
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
