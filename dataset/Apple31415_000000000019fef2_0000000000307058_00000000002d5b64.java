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
            if (ranks == 3 && suits == 3)
                System.out.printf("Case #%d: %s%n", i + 1, 3);
            else if (ranks == 3 && suits == 4)
                System.out.printf("Case #%d: %s%n", i + 1, 5);
            else if (ranks == 4 && suits == 3)
                System.out.printf("Case #%d: %s%n", i + 1, 5);
            else
                System.out.printf("Case #%d: %s%n", i + 1, (ranks - 1) * (suits - 1));
            System.out.print(genOps(ranks, suits));
        }
        
        br.close();
    }
    
    public static String genOps(int ranks, int suits) {
        if (ranks == 3 && suits == 3)
            return "5 2\n3 2\n3 5\n";
        if (ranks == 3 && suits == 4)
            return "8 2\n6 2\n3 3\n7 4\n4 2\n";
        if (ranks == 4 && suits == 3)
            return "6 3\n2 4\n7 4\n4 3\n3 1\n";
        String ret = "";
        for (int i = ranks * (suits - 1); i > suits - 1; i--) {
            ret = ret.concat(String.format("%d %d%n", i, (i - 1) / (suits - 1)));
        }
        return ret;
    }
}