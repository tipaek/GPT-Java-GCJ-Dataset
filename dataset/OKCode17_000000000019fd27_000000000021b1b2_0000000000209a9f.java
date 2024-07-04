import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {

    Scanner             sc       = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    PrintStream         out      = System.out;

    private void solve() {
        String input = sc.next();
        char lastC = '0';
        StringBuilder sb = new StringBuilder();
        for(char c : input.toCharArray()) {
            int n = c - lastC;
            if(n>0) {
                for (int i = 0; i < n; i++) {
                    sb.append("(");
                }
            }else if(n<0){
                for(int i=0;i<-n;i++){
                    sb.append(")");
                }
            }
            sb.append(c);
            lastC = c;
        }
        int k = '0' - lastC;
        for(int i=0;i<-k;i++){
            sb.append(")");
        }
        out.println(sb.toString());
    }

    private void run() throws Exception {
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            out.print("Case #" + i + ": ");
            solve();
        }
        sc.close();
        out.close();
    }

    public static void main(String args[]) throws Exception {
        new Solution().run();
    }
}
