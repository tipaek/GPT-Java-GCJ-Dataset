//package codegam2020.round1c.OverexcitedFan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            solve();
            in.close();
            out.close();
        } catch (Throwable t) {
            t.printStackTrace(System.err);
            System.exit(-1);
        }
    }

    String readString() throws IOException {
        while (!tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }
    // solution

    void solve() throws IOException {
        int tc = readInt();
        for (int t = 1; t <= tc; ++t) {
            int x = readInt();
            int y = readInt();
            char[] all = readString().toCharArray();
            if(x==0 && y==0) {
                System.out.println(String.format("Case #%s: %s",t, 0));
                continue;
            }
            int maxT = all.length;
            boolean found = false;
            for(int i=0;i<all.length;i++) {
                switch(all[i]) {
                    case 'N':
                        y++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                }
                int dist = Math.abs(x)+Math.abs(y);
                if(dist<=i+1){
                    System.out.println(String.format("Case #%s: %s",t, (i+1)));
                    found=true;
                    break;
                }
            }
            if(!found)
                System.out.println(String.format("Case #%s: IMPOSSIBLE",t));
        }
        return;
    }
}
