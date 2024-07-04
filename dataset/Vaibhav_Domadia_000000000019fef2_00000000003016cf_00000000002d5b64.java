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
                int r = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                int steps = (s-1)*(r-1);
                pw.println("Case #" + testCase + ": " + steps);

                for(int i=0 ; i<r-1 ; i++) {
                    int a = (s-1)*(r-i);
                    int b = (r-i-1);
                    for(int j=0 ; j<s-1 ; j++) {
                        pw.println(a + " " + b);
                        a--;
                    }
                }
            }
        }
        finally {
            pw.flush();
            pw.close();
        }
    }
}
