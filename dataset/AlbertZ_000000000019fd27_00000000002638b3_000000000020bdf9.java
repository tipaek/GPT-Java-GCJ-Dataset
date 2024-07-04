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
        int[][] arr = new int[n][];
        for(int i=0;i<n;i++){
            arr[i] = new int[]{sc.nextInt(), sc.nextInt(),i};
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr,(e1,e2)->(e1[0]!=e2[0]?(e1[0]-e2[0]):(e1[1]-e2[1])));
        int Cend = 0, Jend = 0;
        char[] ans = new char[n];
        for(int[] cur:arr){
            if(cur[0]>=Cend){
                // assign this to Cameron
                ans[cur[2]] = 'C';
                Cend = cur[1];
            } else{
                if(cur[0] >= Jend){
                    ans[cur[2]] = 'J';
                    Jend = cur[1];
                } else{
                    out.println("IMPOSSIBLE");
                    return;
                }
            }
        }
        out.println(new String(ans));
    }
}
