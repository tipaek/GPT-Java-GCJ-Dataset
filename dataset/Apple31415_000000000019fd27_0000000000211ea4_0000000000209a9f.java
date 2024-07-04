import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numcases = Integer.parseInt(br.readLine());
        for (int i = 0; i < numcases; i++) {
            int currentdepth = 0;
            String ans = "";
            while (br.ready()) {
                int c = br.read() - 48;
                if (c == -38)
                    break;
                if (currentdepth < c) {
                    for (; currentdepth < c; currentdepth++)
                        ans = ans.concat("(");
                }
                if (currentdepth > c) {
                    for (; currentdepth > c; currentdepth--)
                        ans = ans.concat(")");
                }
                ans = ans.concat(String.valueOf(c));
            }
            if (currentdepth > 0)
                for (; currentdepth > 0; currentdepth--)
                    ans = ans.concat(")");
            
            System.out.printf("Case #%d: %s%n", i + 1, ans);
            
            
        }
        
    }
    
}