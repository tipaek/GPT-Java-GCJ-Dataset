
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



    public static class Time{
        int start;
        int end;

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public Time(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    static void solve() throws Exception {
        ArrayList<Time> C_time = new ArrayList<>();
        ArrayList<Time> J_time = new ArrayList<>();
        C_time.add(new Time(0, timeSlot));
        J_time.add(new Time(0, timeSlot));

        int n = scanInt();
        StringBuilder result = new StringBuilder();
        boolean resultCheck = true;
        for (int i = 0; i < n ; i++) {
            int start = scanInt();
            int end = scanInt();

            if(add(start, end, C_time)){
                result.append("C");
            }else {
                if(add(start, end, J_time)){
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

    static boolean add(int start, int end, ArrayList<Time> times){
        Time freeTime = checkFree(start, end, times);
        if(freeTime == null)
            return false;

        setBusy(start,end, times, freeTime);
        return true;
    }

    static Time checkFree(int start, int end, ArrayList<Time> timeSlot){
        for(Time freeTime: timeSlot){
            if(freeTime.start <= start && freeTime.end >= end)
                return freeTime;
        }
        return null;
    }
    static void setBusy(int start, int end, ArrayList<Time> timeSlot, Time removeTime){
        timeSlot.remove(removeTime);
        if(removeTime.start < start) {
            Time freeTimePre = new Time(removeTime.start, start);
            timeSlot.add(freeTimePre);
        }
        if(removeTime.end > end){
            Time freeTimeAfter = new Time(end, removeTime.end);
            timeSlot.add(freeTimeAfter);
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