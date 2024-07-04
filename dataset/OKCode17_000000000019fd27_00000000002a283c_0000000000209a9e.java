import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    Scanner             sc       = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    PrintStream         out      = System.out;

    private void solve(int b) {
        StringBuilder sb = new StringBuilder();
        String orig = null, flip = null, swap = null, flipswap = null;
        for(int i=1;i<=10;i++) {
            out.println(i);
            sb.append(sc.nextInt());
            orig = sb.toString();
            flip = flip(orig);
            swap = swap(orig);
            flipswap = flipswap(orig);
            if(b==10){
                out.println(orig);
            }
        }
        if(b==20) {
            // 10~15
            StringBuilder sb2 = new StringBuilder();
            int action = -1;
            for (int i = 1; i <= 5; i++) {
                out.println(i);
                sb2.append(sc.nextInt());
                if (sb2.toString().equals(orig.substring(0, 5))) {
                    action = 0;
                } else if (sb2.toString().equals(flip.substring(0, 5))) {
                    action = 1;
                } else if (sb2.toString().equals(swap.substring(0, 5))) {
                    action = 2;
                } else if (sb2.toString().equals(flipswap.substring(0, 5))) {
                    action = 3;
                }
            }
            sb2 = new StringBuilder();
            if (action == 0 || action == 1) {
                for (int i = 11; i <= 15; i++) {
                    out.println(i);
                    if (action == 0) {
                        sb.append(sc.nextInt());
                    } else if (action == 1) {
                        sb.append(sc.nextInt() == 0 ? '1' : '0');
                    }
                }
            } else if (action == 2 || action == 3) {
                for (int i = 10; i >= 6; i--) {
                    out.println(i);
                    if (action == 2) {
                        sb.append(sc.nextInt());
                    } else if (action == 3) {
                        sb.append(sc.nextInt() == 0 ? '1' : '0');
                    }
                }
            }
            // 10~15
            sb2 = new StringBuilder();
            action = -1;
            for (int i = 1; i <= 5; i++) {
                out.println(i);
                sb2.append(sc.nextInt());
                if (sb2.toString().equals(orig.substring(0, 5))) {
                    action = 0;
                } else if (sb2.toString().equals(flip.substring(0, 5))) {
                    action = 1;
                } else if (sb2.toString().equals(swap.substring(0, 5))) {
                    action = 2;
                } else if (sb2.toString().equals(flipswap.substring(0, 5))) {
                    action = 3;
                }
            }
            sb2 = new StringBuilder();
            if (action == 0 || action == 1) {
                for (int i = 16; i <= 20; i++) {
                    out.println(i);
                    if (action == 0) {
                        sb.append(sc.nextInt());
                    } else if (action == 1) {
                        sb.append(sc.nextInt() == 0 ? '1' : '0');
                    }
                }
            } else if (action == 2 || action == 3) {
                for (int i = 5; i >= 1; i--) {
                    out.println(i);
                    if (action == 2) {
                        sb.append(sc.nextInt());
                    } else if (action == 3) {
                        sb.append(sc.nextInt() == 0 ? '1' : '0');
                    }
                }
            }
        }
        out.println(sb.toString());
        String response = sc.next();
        if(response.equalsIgnoreCase("N")){
            System.exit(1);
        }
    }

    private String flip(String s){
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            sb.append(c=='0'?'1':'0');
        }
        return sb.toString();
    }

    private String swap(String s){
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            sb.insert(0, c);
        }
        return sb.toString();
    }

    private String flipswap(String s){
        return swap(flip(s));
    }

    private void run() throws Exception {
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int b = sc.nextInt();
            solve(b);
        }
        sc.close();
        out.close();
        System.exit(0);
    }

    public static void main(String args[]) throws Exception {
        new Solution().run();
    }
}
