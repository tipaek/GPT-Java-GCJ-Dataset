import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            System.out.print("Case #" + i + ": ");
            long x = in.nextLong();
            long y = in.nextLong();
            testCase(x, y);
        }
    }
    private static void testCase(long x, long y) {
        Queue<String> q = new LinkedList<>();
        q.add("E");
        q.add("W");
        q.add("N");
        q.add("S");
        int depth = 0;
        while(true) {
            depth++;
            if(depth > 8) {
                System.out.println("IMPOSSIBLE");
                return;
            }
            Queue<String> nextQueue = new LinkedList<>();
            while(!q.isEmpty()) {
                String s = q.poll();
                long tempX = getX(s);
                long tempY = getY(s);
                if(tempX == x && tempY == y) {
                    System.out.println(s);
                    return;
                }
                nextQueue.add(s+"E");
                nextQueue.add(s+"W");
                nextQueue.add(s+"N");
                nextQueue.add(s+"S");
            }
            q = nextQueue;
        }
        
    }
    private static long getX(String s) {
        long step = 1;
        long x = 0;
        int len = s.length();
        for(int i=0; i<len; i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'E':
                    x += step;
                    break;
                case 'W':
                    x -= step;
                    break;
            }
            step *= 2;
        }
        return x;
    }
    private static long getY(String s) {
        long step = 1;
        long y = 0;
        int len = s.length();
        for(int i=0; i<len; i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'N':
                    y += step;
                    break;
                case 'S':
                    y -= step;
                    break;
            }
            step *= 2;
        }
        return y;
    }
}