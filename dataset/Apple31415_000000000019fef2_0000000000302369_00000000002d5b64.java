import java.io.*;
import java.util.*;
public class Solution {
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int numcases = Integer.parseInt(st.nextToken());
        for (int i = 0; i < numcases; i++ ){
            st = new StringTokenizer(br.readLine());
            int ranks = Integer.parseInt(st.nextToken());
            int suits = Integer.parseInt(st.nextToken());
            System.out.printf("Case #%d: %s%n", i + 1, (ranks - 1) * (suits - 1));
            System.out.print(genOps(ranks, suits));
        }
        
        br.close();
    }
    
    public static String genOps(int ranks, int suits) {
        String ret = "";
        for (int i = ranks * (suits - 1); i > suits - 1; i--) {
            ret = ret.concat(String.format("%d %d%n", i, (i - 1) / (suits - 1)));
        }
        return ret;
    }
}