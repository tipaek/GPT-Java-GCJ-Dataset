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
        int n = sc.nextInt();
//        int[][] mat = new int[n][n];
        HashSet<Integer>[] row = new HashSet[n], col = new HashSet[n];
        for(int i=0;i<n;i++){
            row[i] = new HashSet<>(); col[i] = new HashSet<>();
        }
        int trace = 0 ;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int cur = sc.nextInt();
                if(i==j) trace += cur;
                row[i].add(cur); col[j].add(cur);
            }
        }
        int r= 0, c = 0;
        for(int i=0;i<n;i++){
            if(row[i].size()!=n) r++;
            if(col[i].size()!=n) c++;
        }
        out.println(String.format("%d %d %d",trace,r,c));
    }
}
