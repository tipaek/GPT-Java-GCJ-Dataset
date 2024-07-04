import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(f.readLine());
        int tt = t;
        while(tt-- > 0){
            int n = Integer.parseInt(f.readLine());
            int[][] arr = new int[n][n];
            long trace = 0;
            int rows = 0;
            int cols = 0;
            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(f.readLine());
                HashSet<Integer> seen = new HashSet<Integer>();
                boolean yes = false;
                for(int j = 0; j < n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if(i == j) trace += arr[i][j];
                    if(seen.contains(arr[i][j])) yes = true;
                    seen.add(arr[i][j]);
                }
                if(yes) rows++;
            }
            for(int j = 0; j < n; j++){
                HashSet<Integer> seen = new HashSet<Integer>();
                boolean yes = false;
                for(int i = 0; i < n; i++){
                    if(seen.contains(arr[i][j])) yes = true;
                    seen.add(arr[i][j]);
                }
                if(yes) cols++;
            }
            StringBuilder ans = new StringBuilder("Case #");
            ans.append(t-tt);
            ans.append(": ");
            ans.append(trace);
            ans.append(" ");
            ans.append(rows);
            ans.append(" ");
            ans.append(cols);
            out.println(ans.toString().trim());

        }
        out.close();
    }
}
