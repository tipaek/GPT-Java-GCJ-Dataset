

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.exit;

public class Solution {

    static final int timeSlot  = 1441;
    static final String FAIL = "IMPOSSIBLE";


    static void solve() throws Exception {
        ArrayList<short[]> C_time = new ArrayList<>(timeSlot);
        ArrayList<short[]> J_time = new ArrayList<>(timeSlot);

        int n = scanInt();
        StringBuilder result = new StringBuilder();
        boolean resultCheck = false;
        for (int i = 0; i < n ; i++) {
            short start = scanInt();
            short end = scanInt();

            // if(J_time.size() > C_time.size()){
            //     if (add(start, end, C_time)) {
            //         result.append("C");
            //     }else if (add(start, end, J_time)) {
            //         result.append("J");
            //     }else {

            //         resultCheck = true;
            //         break;
            //     }
            // }else {
            //     if (add(start, end, J_time)) {
            //         result.append("J");
            //     }else if (add(start, end, C_time)) {
            //         result.append("C");
            //     }else {
            //         resultCheck = true;
            //         break;
            //     }
            // }
        }

        if (resultCheck){
            printCase(FAIL);
        }else {
            printCase(result.toString());
        }
    }


    static boolean add(short start, short end, ArrayList<short[]> timeSlot){
        for(short[] time : timeSlot) {
            if (checkContain(time, start) || checkContain(time, end))
                return false;
        }

        short[] newTime = {start, end};
        timeSlot.add(newTime);
        return true;
    }


    static boolean checkContain(short[] time, short value){
        if(time[0] < value && time[1] > value)
            return true;

        return false;
    }
    static short scanInt() throws IOException {
        return Short.valueOf(scanString());
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
            exit(0);
        }
    }
}