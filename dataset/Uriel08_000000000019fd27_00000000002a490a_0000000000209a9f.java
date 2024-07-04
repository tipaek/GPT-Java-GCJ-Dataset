import java.io.*;
import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;

public class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = 0;
        
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t;) {
            String str = br.readLine(), newStr = "";
            
            int prev = 0, open = 0;
            for (int j = 0; j < str.length(); j++) {
               int c = Integer.parseInt(str.charAt(j) + "");
               int dif = c - prev;
               if (dif > 0) {
                  open += dif;
                  for (int k = 0; k < dif; k++) {                  
                     newStr += "(";
                  }
               } else if (dif < 0) {
                  dif = dif * -1;
                  open -= dif;
                  for (int k = 0; k < dif; k++) {                  
                     newStr += ")";
                  }
               }
               newStr += c + "";
               prev = c;
            }
            
            //Close remaining
            for (int j = 0; j < open; j++) {
               newStr += ")";
            }
            
            bw.write("Case #" + (++i) + ": " + newStr + "\n");
            bw.flush();
        }
        
        br.close();
        bw.close();
    }
}