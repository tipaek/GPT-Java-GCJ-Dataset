import java.io.IOException;
import java.io.InputStream;
import java.util.*;

//class MultiKeyMap{
//    Map<String, Boolean> map = new HashMap<>();
//
//    public Boolean get(int k1, int k2){
//        String key = String.valueOf(k1) + String.valueOf(k2);
//        return map.get(key);
//    }
//
//    public void put(int k1, int k2, Boolean val){
//        String key = String.valueOf(k1) + String.valueOf(k2);
//        map.put(key, val);
//    }
//}

public class Solution {

    public static void main(String[] args) {
        InputReader inputReader = new InputReader(System.in);
        int tc = inputReader.nextInt();
        for(int t=0; t<tc; t++){
            int CX = inputReader.nextInt();
            int CY = inputReader.nextInt();
            String str = inputReader.nextLine();
            char chars[] = str.toCharArray();
            int steps = chars.length;
//            String str = inputReader.nextLine();
//            String[] strarr = str.split(" ");
//            int CX = Integer.valueOf(strarr[0]);
//            int CY = Integer.valueOf(strarr[1]);
//            char chars[] = strarr[2].toCharArray();
//            int steps = chars.length;

            int solve = findSolution(CX, CY, chars, steps);
            if(solve==Integer.MAX_VALUE){
                System.out.println("CASE #"+(t+1)+": IMPOSSIBLE");
            }else{
                System.out.println("CASE #"+(t+1)+": "+ solve);
            }
        }
    }

    private static int findSolution(int cx, int cy, char[] chars, int steps) {
        int currTime = 0;
        int fx = 0;
        int fy = 0;
//        MultiKeyMap multiMap = new MultiKeyMap();
        return findRecur(currTime, fx, fy, cx, cy, chars, steps);
    }

    private static int findRecur(int currTime, int fx, int fy, int cx, int cy, char[] chars, int steps){
        if(fx == cx && fy == cy){
            return currTime;
        }

//        Boolean isvisited = multiMap.get(fx,fy);
//        if(isvisited != null && isvisited){
//            return Integer.MAX_VALUE;
//        }

        if(currTime >= steps){
            return Integer.MAX_VALUE;
        }

        int newcx = 0;
        int newcy = 0;
        switch (chars[currTime]){
            case 'N':
                newcx = cx;
                newcy = cy + 1;
                break;
            case 'E':
                newcx = cx + 1;
                newcy = cy;
                break;
            case 'W':
                newcx = cx - 1;
                newcy = cy;
                break;
            case 'S':
                newcx = cx;
                newcy = cy - 1;
                break;
        }


        //stay there
        int solNostep = findRecur(currTime+1, fx, fy, newcx, newcy, chars, steps);
        //4 directions for the fan
//        multiMap.put(fx,fy,true);
        if(newcx >= fx && newcy >= fy){
            int solN = findRecur(currTime+1, fx, fy + 1, newcx, newcy, chars, steps);
            int solE = findRecur(currTime+1, fx + 1, fy, newcx, newcy, chars, steps);
//            multiMap.put(fx,fy,false);
            return Math.min(solNostep, Math.min(solN, solE));
        }else if(newcx >= fx && newcy <= fy){
            int solE = findRecur(currTime+1, fx + 1, fy, newcx, newcy, chars, steps);
            int solS = findRecur(currTime+1, fx , fy -1, newcx, newcy, chars, steps);
//            multiMap.put(fx,fy,false);
            return Math.min(solNostep, Math.min(solS, solE));
        }else if(newcx <= fx && newcy <= fy){
            int solW = findRecur(currTime+1, fx - 1, fy, newcx, newcy, chars, steps);
            int solS = findRecur(currTime+1, fx , fy -1, newcx, newcy, chars, steps);
//            multiMap.put(fx,fy,false);
            return Math.min(solNostep, Math.min(solS, solW));
        }else if(newcx <= fx && newcy >= fy){
            int solN = findRecur(currTime+1, fx, fy + 1, newcx, newcy, chars, steps);
            int solW = findRecur(currTime+1, fx - 1, fy, newcx, newcy, chars, steps);
//            multiMap.put(fx,fy,false);
            return Math.min(solNostep, Math.min(solN, solW));
        }

        return Integer.MAX_VALUE;
    }

    static class InputReader {
        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;
        public InputReader(InputStream stream) {
            this.stream = stream;
        }
        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }
        public int nextInt() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
        public long nextLong() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }
        public String readString() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }
        public String nextLine() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isEndOfLine(c));
            return res.toString();
        }
        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
}
