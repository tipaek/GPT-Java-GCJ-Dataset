
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.exit;

public class Solution {

    static final int timeSlot  = 1441;
    static final String FAIL = "IMPOSSIBLE";

    static void solve() throws Exception {
        boolean[] C_time = new boolean[timeSlot];
        boolean[] J_time = new boolean[timeSlot];
        int n = scanInt();
        StringBuilder result = new StringBuilder();
        boolean resultCheck = true;
        for (int i = 0; i < n ; i++) {
            int start = scanInt();
            int end = scanInt();
            if(checkBusy( start,  end, C_time)){
                if(checkBusy(start, end, J_time)){
                    resultCheck = false;
                    break;
                }else {
                    setBusy(start, end, J_time);
                    result.append("J");
                }
            }else {
                setBusy(start,end, C_time);
                result.append("C");
            }
        }

        if (!resultCheck){
            printCase(FAIL);
        }else {
            printCase(result.toString());
        }
    }

    static boolean checkBusy(int start, int end, boolean[] timeSlot){
        for(int i = start; i < end; i ++){
            if(timeSlot[i])
                return true;
        }
        return false;
    }
    static void setBusy(int start, int end, boolean[] timeSlot){
        for(int i = start; i < end; i ++){
            timeSlot[i] = true;
        }
    }

    static int scanInt() throws IOException {
        return parseInt(scanString());
    }

    static String scanString() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    static void printCase(String result) {
        out.println("Case #" + test + ": " + result);
    }

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;
    static int test;

    public static void main(String[] args) {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int tests = scanInt();
            for (test = 1; test <= tests; test++) {
                solve();
            }
            in.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            exit(1);
        }
    }
}