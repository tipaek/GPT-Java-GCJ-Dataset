package p3;

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
        ArrayList<int[]> C_time = new ArrayList<>(timeSlot);
        ArrayList<int[]> J_time = new ArrayList<>(timeSlot);

        int n = scanInt();
        StringBuilder result = new StringBuilder();
        boolean resultCheck = false;
        for (int i = 0; i < n ; i++) {
            int[] input = scanArray();
            int start = input[0];
            int end = input[1];
            if(J_time.size() > C_time.size()){
                if (add(start, end, C_time)) {
                    result.append("C");
                }else if (add(start, end, J_time)) {
                    result.append("J");
                }else {
                    resultCheck = true;
                    break;
                }
            }else {
                if (add(start, end, J_time)) {
                    result.append("J");
                }else if (add(start, end, C_time)) {
                    result.append("C");
                }else {
                    resultCheck = true;
                    break;
                }
            }
        }

        if (resultCheck){
            printCase(FAIL);
        }else {
            printCase(result.toString());
        }
    }


    static boolean add(int start, int end, ArrayList<int[]> timeSlot){
        for(int[] time : timeSlot) {
            if (checkContain(time, start, end))
                return false;
        }

        int[] newTime = {start, end};
        timeSlot.add(newTime);
        return true;
    }

    static boolean checkContain(int[] time, int start, int end){
        if(time[0] >= end)
            return false;

        if(time[1] <= start)
            return false;

        if(time[0] == start)
            return true;
        if(time[1] == end)
            return true;

        if(time[0] <= start && time[1] > start){
            return true;
        }

        if(time[0] < end && time[1] >= end){
            return true;
        }

        if(time[0] >= start && time[1] <= end){
            return true;
        }
        return false;
    }
    static int scanInt() throws IOException {
        return parseInt(in.readLine());
    }

    static int[] scanArray() throws IOException {
        tok = new StringTokenizer(in.readLine());
        int start = parseInt(tok.nextToken());
        int end = parseInt(tok.nextToken());
        return new int[]{start, end};
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