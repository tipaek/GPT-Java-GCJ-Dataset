
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.exit;

public class Solution {

    static final int timeSlot  = 1441;
    static final String FAIL = "IMPOSSIBLE";

    static String create(int start, int end){
        return start + ":" + end;
    }
    static void solve() throws Exception {
        HashSet<String> C_time = new HashSet<>();
        HashSet<String> J_time = new HashSet<>();
        C_time.add(create(0, timeSlot));
        J_time.add(create(0, timeSlot));

        int n = scanInt();
        StringBuilder result = new StringBuilder();
        boolean resultCheck = true;
        for (int i = 0; i < n ; i++) {
            int start = scanInt();
            int end = scanInt();

            if(checkFree(start, end, C_time)){
                result.append("C");
            }else {
                if(checkFree(start, end, J_time)){
                    result.append("J");
                }else {
                    resultCheck = false;
                    break;
                }
            }
        }

        if (!resultCheck){
            printCase(FAIL);
        }else {
            printCase(result.toString());
        }
    }


    static boolean checkFree(int start, int end, HashSet<String> timeSlot){
        for(String freeTime: timeSlot){

            String[] free = freeTime.split(":");
            int freeStart = Integer.valueOf(free[0]);
            int freeEnd = Integer.valueOf(free[1]);

            if(freeStart <= start && freeEnd >= end) {
                timeSlot.remove(freeTime);
                setBusy(start, end, timeSlot, freeStart, freeEnd);
                return true;
            }
        }
        return false;
    }
    static void setBusy(int start, int end, HashSet<String> timeSlot, int freeStart, int freeEnd){
        if(freeStart < start) {
            timeSlot.add(create(freeStart, start));
        }
        if(freeEnd> end){
            timeSlot.add(create(end, freeEnd));
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