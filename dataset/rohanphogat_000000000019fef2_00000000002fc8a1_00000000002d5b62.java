import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

class Result{
    String path;
    int steps;

    public Result(String path, int steps) {
        this.path = path;
        this.steps = steps;
    }
}

class MultiKeyMap{
    Map<String, Integer> map = new HashMap<>();

    public Integer get(int k1, int k2){
        String key = String.valueOf(k1) + String.valueOf(k2);
        return map.get(key);
    }

    public void put(int k1, int k2, Integer val){
        String key = String.valueOf(k1) + String.valueOf(k2);
        map.put(key, val);
    }

}

public class Solution {

    static MultiKeyMap map = new MultiKeyMap();

    public static Result findPath(int x, int y, int jump, int X, int Y, String currstr){
        Integer temp = map.get(x,y);

        if(temp!=null && temp < jump){
            return null;
        }else{
            map.put(x,y,jump);
        }

        if(Math.abs(x) > Math.abs(X) || Math.abs(y) > Math.abs(Y)){
            return null;
        }

        if(x==X && y==Y){
            return new Result(currstr, jump);
        }

        Result minN = findPath(x,(int) (y + Math.pow(2,jump)), jump+1, X, Y, currstr.concat("N"));
        Result minS = findPath(x,(int) (y - Math.pow(2,jump)), jump+1, X, Y, currstr.concat("S"));
        Result minE = findPath((int) (x + Math.pow(2,jump)),y, jump+1, X, Y, currstr.concat("E"));
        Result minW = findPath((int) (x - Math.pow(2,jump)),y, jump+1, X, Y, currstr.concat("W"));

//        Result minN = findPath(x, (int) (y + Math.pow(2,jump)), jump+1, X, Y, currstr.concat("N"));
//        Result minS = findPath(x, (int) (y - Math.pow(2,jump)), jump+1, X, Y, currstr.concat("S"));
//        Result minE = findPath((int) (x + Math.pow(2,jump)),y, jump+1, X, Y, currstr.concat("E"));
//        Result minW = findPath((int) (x - Math.pow(2,jump)),y, jump+1, X, Y, currstr.concat("W"));

        Result min = null;
        Integer minval = Integer.MAX_VALUE;
        if(minN !=null && minN.steps < minval){
            min = minN;
            minval = minN.steps;
        }
        if(minS !=null && minS.steps < minval){
            min = minS;
            minval = minS.steps;
        }
        if(minE !=null && minE.steps < minval){
            min = minE;
            minval = minE.steps;
        }
        if(minW!=null && minW.steps < minval){
            min = minW;
            minval = minW.steps;
        }

        return min;

    }

    public static void main(String[] args) {
        InputReader inputReader = new InputReader(System.in);
        int tc = inputReader.nextInt();
        for(int t=0; t<tc; t++){
            int targetX = inputReader.nextInt();
            int targetY = inputReader.nextInt();

            Result result = findPath(0,0,0,targetX, targetY, "");
            if(result==null){
                System.out.println("CASE #"+(t+1)+": IMPOSSIBLE");
            }else{
                System.out.println("CASE #"+(t+1)+": "+result.path);
            }
        }
    }

    static class InputReader {
        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private InputReader.SpaceCharFilter filter;
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