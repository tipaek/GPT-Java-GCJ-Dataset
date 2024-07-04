import java.io.*;
import java.util.*;

public class Solution {
    static Scanner sc = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    long mod = 1000000000;
    double[] logFac;
    double ln2 = Math.log(2);
    public static void main(String[] args)throws IOException {
//        String[] buf = reader.readLine().split(" ");
//        int T = Integer.parseInt(buf[0]);
        Solution sl = new Solution();
        int T = sc.nextInt();
        for(int i=1;i<=T;i++){
            out.print(String.format("Case #%d: ",i));
            out.println(sl.solve());
        }
        out.flush();
        System.exit(0);
    }
    String solve() {
        int x = sc.nextInt(), y = sc.nextInt();
        char[] arr = sc.next().toCharArray();
        int n = arr.length;
        if(x==0&&y==0) return ("0");
        for(int i=1;i<=n;i++){
            char dir = arr[i-1];
            if(dir=='E') x++;
            else if(dir=='S') y--;
            else if(dir=='W') x--;
            else y++;
            if(Math.abs(x)+Math.abs(y)<=i) return (Integer.toString(i));
        }
        return "IMPOSSIBLE";
    }
}
