import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter pw = new PrintWriter(System.out);
        
        try {
            int t = Integer.parseInt(br.readLine());
            for(int zx=1 ; zx<=t ; zx++) {
                String s = br.readLine();
                StringBuffer ans = new StringBuffer();

                int depth = 0;
                for(int i=0 ; i<s.length() ; i++) {
                    int num = s.charAt(i)-'0';
                    if(depth < num) {
                        while(depth < num) {
                            ans.append('(');
                            depth++;
                        }
                    }
                    else if(depth > num) {
                        while(depth > num) {
                            ans.append(')');
                            depth--;
                        }
                    }
                    ans.append(num);
                }
                while(depth > 0) {
                    ans.append(')');
                    depth--;
                }

                pw.println("Case #" + zx + ": " + ans);
            }
        }
        finally {
            pw.flush();
            pw.close();
        }
    }
}
