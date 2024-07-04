import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer input;
        
        int T = Integer.parseInt(in.readLine());
        for (int x = 1; x <= T; x++) {
            String str = in.readLine();
            int len = str.length();
            String s = "";
            for(int i = 0; i < len; i++) {
                int y = str.charAt(i) - '0';
                for(int j = 0; j < y; j++)
                    s += "(";
                s += "" + str.charAt(i);
                for(int k = 0; k < y; k++) 
                    s += ")";
            }
            while(s.contains(")(")) {
                s = s.replaceAll(")(", "");
            }
            out.println("Case #" + x + ": " + s);
        }
        out.close();
    }
}