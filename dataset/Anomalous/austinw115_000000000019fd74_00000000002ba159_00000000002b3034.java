import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 32768);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        int T = Integer.parseInt(br.readLine().trim());
        
        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine().trim());
            String[] arr = new String[N];
            String longest = "*";
            
            for (int j = 0; j < N; j++) {
                String P = br.readLine().trim();
                if (P.length() > longest.length()) {
                    longest = P;
                }
                arr[j] = P;
            }
            
            String ans = longest.substring(1);
            
            for (String s1 : arr) {
                if (!s1.equals(longest)) {
                    if (s1.length() > 1) {
                        s1 = s1.substring(1);
                    }
                    
                    if (longest.indexOf(s1) == -1 || longest.lastIndexOf(s1) + s1.length() < longest.length()) {
                        ans = "*";
                        break;
                    }
                }
            }
            pw.println("Case #" + i + ": " + ans);
        }
        pw.close();
    }
}