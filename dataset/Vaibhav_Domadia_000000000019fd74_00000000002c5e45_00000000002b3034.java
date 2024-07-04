import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter pw = new PrintWriter(System.out);
        
        try {
            int t = Integer.parseInt(br.readLine());
            for(int zx = 1 ; zx<=t ; zx++) {
                int n = Integer.parseInt(br.readLine());
                String[] s = new String[n];
                for(int i=0 ; i<n ; i++) {
                    s[i] = br.readLine().substring(1);
                }

                Arrays.sort(s, (o1, o2) -> o1.length()-o2.length());

                boolean possible = true;
                for(int i=0 ; i<n-1 ; i++) {
                    if(!s[i+1].endsWith(s[i])) {
                        possible = false;
                        break;
                    }
                }



                if(possible) pw.println("Case #" + zx + ": " + s[n-1]);
                else pw.println("Case #" + zx + ": " + "*");
            }
        }
        finally {
            pw.flush();
            pw.close();
        }
    }
}
