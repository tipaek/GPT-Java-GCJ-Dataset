import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int[] tAB = getTAB();
        int t = tAB[0];
        int c = 0;
        while(c++<t) {
            int zeroRange[] = {0,0};
            int x1Range[] = {-1000000000, 1000000000};
            int x2Range[] = {-1000000000, 1000000000};
            int y1Range[] = {-1000000000, 1000000000};
            int y2Range[] = {-1000000000, 1000000000};
            boolean status = false;
            int x1=0,x2=0,y1=0,y2=0;
            try {
                int xOne = findOnePointInXAxis();
                x1 = findX1(xOne);
                x2 = findX2(xOne);
                int yOne = findOnePointInYAxis();
                y1 = findY1(yOne);
                y2 = findY2(yOne);
            } catch (Exception e) {
                status = true;
            }
            if(!status) {
                safeSendAndRead((x1 + x2) / 2, (y1 + y2) / 2);
            }
        }
    }

    private static void safeSendAndRead(int x, int y) {
        try{
            sendAndRead(x,y);
        } catch (Exception e) {}
    }

    private static int findX2(int x) throws Exception {
        int a = x;
        int b = 1000000000;
        while(a<b) {
            int mid = a+(b-a)/2;
            boolean isHitting  = hits(mid,0);
            if(!isHitting) {
                b = mid;
            } else if(misses(mid+1,0)) {
                return mid;
            } else {
                a = mid;
            }
        }
        return a;
    }

    private static int findX1(int x) throws Exception {
        int a = -1000000000;
        int b = x;
        while(a<b) {
            int mid = a+(b-a)/2;
            boolean isHitting  = hits(mid,0);
            if(!isHitting) {
                a = mid;
            } else if(misses(mid-1,0)) {
                return mid;
            } else {
                b = mid;
            }
        }
        return b;
    }

    private static int findOnePointInXAxis() throws Exception {
        List<Integer> list = Arrays.asList(0, -1000000000/2, 1000000000/2, -1000000000/2 + 1000000000/4, -1000000000/4,
                1000000000/4, 1000000000/2 + 1000000000/4);
        for(int i : list) {
            if(hits(i,0)) {
                return i;
            }
        }
        return 0;
    }

    private static int findY2(int y) throws Exception {
        int a = y;
        int b = 1000000000;
        while(a<b) {
            int mid = a+(b-a)/2;
            boolean isHitting  = hits(0,mid);
            if(!isHitting) {
                b = mid;
            } else if(misses(0, mid+1)) {
                return mid;
            } else {
                a = mid;
            }
        }
        return a;
    }

    private static int findY1(int y) throws Exception {
        int a = -1000000000;
        int b = y;
        while(a<b) {
            int mid = a+(b-a)/2;
            boolean isHitting  = hits(0, mid);
            if(!isHitting) {
                a = mid;
            } else if(misses(0, mid-1)) {
                return mid;
            } else {
                b = mid;
            }
        }
        return b;
    }

    private static int findOnePointInYAxis() throws Exception {
        List<Integer> list = Arrays.asList(0, -1000000000/2, 1000000000/2, -1000000000/2 + 1000000000/4, -1000000000/4,
                1000000000/4, 1000000000/2 + 1000000000/4);
        for(int i : list) {
            if(hits(0, i)) {
                return i;
            }
        }
        return 0;
    }

    private static boolean misses(int x, int y) throws Exception {
        return !hits(x,y);
    }

    private static boolean hits(int x, int y) throws Exception {
        return sendAndRead(x,y).equals("HIT");
    }

    private static String sendAndRead(int x, int y) throws Exception {
        System.out.println(x + " " + y);
        System.out.flush();
        String str = s.nextLine();
        if(str.equals("CENTER")) throw new Exception("center");
        return str;
    }


    private static int[] getTAB() {
        return Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }


}
