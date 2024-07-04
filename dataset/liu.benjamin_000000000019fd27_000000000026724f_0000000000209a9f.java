import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer input;
        
        int T = Integer.parseInt(in.readLine());
        for (int x = 1; x <= T; x++) {
            String s = in.readLine();
            int n = s.length();
            boolean up = true;
            String a = "";
            
            for(int i = 0; i < n; i++){
                int r = s.charAt(i) - '0';
                for(int j = 0; j < r; j++){ a += "("; }
                a+= "" + s.charAt(i);
                for(int j = 0; j < r; j++){ a += ")"; }
            }
            // replace
            String p = "\\)\\(";
            a = a.replaceAll(p, "");
            out.println("Case #" + x + ": " + a);
        }
        out.close();
    }
}