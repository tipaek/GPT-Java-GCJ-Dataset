import java.io.*;
import java.util.*;

public class Solution {
    static Scanner sc = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)throws IOException {
//        String[] buf = reader.readLine().split(" ");
//        int T = Integer.parseInt(buf[0]);
        Solution sl = new Solution();
        int T = sc.nextInt();
        for(int i=1;i<=T;i++){
            out.print(String.format("Case #%d: ",i));
            sl.solve();
//            out.println(sl.solve());
        }
        out.flush();
        System.exit(0);
    }
    void solve() throws IOException{
        char[] arr = sc.next().toCharArray();
        int n = 0;
        int left = 0;
        StringBuilder sb = new StringBuilder();
        for(char c:arr){
            int cur = c-'0';
            if(cur<left){
                for(int j=0;j<left-cur;j++) sb.append(')');
            } else if(cur>left){
                for(int j=0;j<cur-left;j++) sb.append('(');
            }
            sb.append(c);
            left = cur;
        }
        while(left-->0) sb.append(')');
        out.println(sb.toString());
    }
}
