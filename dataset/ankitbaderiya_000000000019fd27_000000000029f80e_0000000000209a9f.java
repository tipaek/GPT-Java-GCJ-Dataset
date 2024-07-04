import java.util.Collections;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for (int tt = 0; tt < t; tt++) {
            String s = br.readLine();
            int n = s.length();
            int brac = 0;
            
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<n; i++) {
                int val = s.charAt(i)-48;
                if(val == brac) {
                    sb.append(s.charAt(i));
                }
                else if (val>brac) {
                    int diff = val-brac;
                    sb.append(attachOpenBraces(diff)).append(s.charAt(i));
                    brac = brac+diff;
                }
                else {
                    int diff = brac-val;
                    sb.append(attachCloseBraces(diff)).append(s.charAt(i));
                    brac = brac-diff;
                }
            }
            if (brac>0) {
                sb.append(attachCloseBraces(brac));
            }
            System.out.println(sb.toString());

        }
        System.exit(0);
    }

    public static String attachOpenBraces(int n) {
         return String.join("", Collections.nCopies(n, "("));
    }
    
    public static String attachCloseBraces(int n) {
         return String.join("", Collections.nCopies(n, ")"));
    }
}
