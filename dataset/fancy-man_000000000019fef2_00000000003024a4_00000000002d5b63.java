

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {




    public static byte query (Scanner in, int x, int y)
    {
        System.out.println(x + " " + y);
        System.out.flush();

        String line = in.nextLine();
        if (line.equals("WRONG")) throw new RuntimeException("Exit");
        if (line.equals("HIT")) return HIT;
        if (line.equals("MISS")) return MSS;
        if (line.equals("CENTER")) return CNT;
        throw new RuntimeException("Malformed");
    }

    static final byte CNT = 0;
    static final byte HIT = 1;
    static final byte MSS = 2;


    static final int MAX = 1000000000;
    static final int MIN = -1000000000;

    public static void solve (Scanner in, int B)
    {
        int offset = 0;
        int y = 0;
        int prevmiss = -1;
        while (offset < 100)
        {
            byte res = query(in, MAX -offset, y );

            switch (res){
                case HIT:
                    offset = 100;
                    break;
                case MSS:
                    prevmiss = offset;
                    offset += 2;
                    break;
            }
        }

        if (prevmiss > 0)
        {
            byte res = query(in, MAX - prevmiss - 1, y);
            if (res == MSS)
                prevmiss++;
        }

        int right = prevmiss+1;


        offset=0;
        prevmiss = -1;
        while (offset < 100)
        {
            byte res = query(in, MIN +offset, y );

            switch (res){
                case HIT:
                    offset = 100;
                    break;
                case MSS:
                    prevmiss = offset;
                    offset += 2;
                    break;
            }
        }
        if (prevmiss > 0)
        {
            byte res = query(in, MIN + prevmiss + 1, y);
            if (res == MSS)
                prevmiss++;
        }

        int left = prevmiss+1;
        int x0 = left - right;

        offset =0;
        prevmiss = -1;
        while (offset < 100)
        {
            byte res = query(in, x0, MAX -offset);

            switch (res){
                case HIT:
                    offset = 100;
                    break;
                case MSS:
                    prevmiss = offset;
                    offset += 2;
                    break;
            }
        }
        if (prevmiss > 0)
        {
            byte res = query(in, x0, MAX - prevmiss - 1);
            if (res == MSS)
                prevmiss++;
        }
        int top = prevmiss+1;

        offset =0;
        prevmiss = -1;
        while (offset < 100)
        {
            byte res = query(in, x0, MIN + offset);

            switch (res){
                case HIT:
                    offset = 100;
                    break;
                case MSS:
                    prevmiss = offset;
                    offset += 2;
                    break;
            }
        }
        if (prevmiss > 0)
        {
            byte res = query(in, x0, MIN + prevmiss + 1);
            if (res == MSS)
                prevmiss++;
        }
        int bottom = prevmiss+1;
        int y0 = bottom - top;

        byte fin = query(in, x0, y0);
        if (fin != CNT)
            throw new RuntimeException("ERROR");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String line = in.nextLine();
        String[] tokens = line.split(" ");

        int t = Integer.parseInt(tokens[0]);
        int b = Integer.parseInt(tokens[1]);

        for (int c = 1; c <= t; ++c) {

            solve(in, b);
        }
    }

}
