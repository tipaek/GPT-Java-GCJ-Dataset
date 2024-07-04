
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.InputMismatchException;

public class Solution {

    //static Writer fileWriter;


    public static Writer getFileWriter(String fileName) throws FileNotFoundException {
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8));
    }
    public static String getCurrentPathDirectory() {
        return Paths.get(".").toAbsolutePath().normalize().toString();
    }

    public static final int NANOMETERS = 1000000000;

    private static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public double readDouble() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, readInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return res * Math.pow(10, readInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public long readLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }

    public static class Point {
        int x, y;
        boolean isCenter;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static String query(Point p, InputReader in) throws IOException {
        // all translated of 10^9, 10^9

        System.out.println((p.x-1000000000) + " " + (p.y-1000000000));
        //fileWriter.write("Querying ("+(p.x-1000000000)+", "+(p.y-1000000000)+")\n");
        //fileWriter.flush();
        String answer = in.next();
        //fileWriter.write(answer+"\n");
        //fileWriter.flush();
        return answer;
    }

    public static Point locateCircle(InputReader in) throws IOException {
        Point p = new Point(NANOMETERS / 2, NANOMETERS / 2);
        String ans = query(p, in);
        if ("CENTER".equals(ans)) {
            p.isCenter = true;
            return p;
        } else if ("HIT".equals(ans)) {
            return p;
        } else if ("MISS".equals(ans)) {
            p = new Point(3*NANOMETERS / 2, NANOMETERS / 2);
            ans = query(p, in);
            if ("CENTER".equals(ans)) {
                p.isCenter = true;
                return p;
            } else if ("HIT".equals(ans)) {
                return p;
            } else if ("MISS".equals(ans)) {
                p = new Point(NANOMETERS / 2, 3*NANOMETERS / 2);
                ans = query(p, in);
                if ("CENTER".equals(ans)) {
                    p.isCenter = true;
                    return p;
                } else if ("HIT".equals(ans)) {
                    return p;
                } else if ("MISS".equals(ans)) {
                    p = new Point(3*NANOMETERS / 2, 3*NANOMETERS / 2);
                    ans = query(p, in);
                    if ("CENTER".equals(ans)) {
                        p.isCenter = true;
                        return p;
                    } else if ("HIT".equals(ans)) {
                        return p;
                    } else if ("MISS".equals(ans)) {
                        p = new Point(NANOMETERS, NANOMETERS);
                        ans = query(p, in);
                        if ("CENTER".equals(ans)) {
                            p.isCenter = true;
                            return p;
                        } else if ("HIT".equals(ans)) {
                            return p;
                        } else if ("MISS".equals(ans)) {
                            return null;
                        } else {
                            return null;
                        }
                    } else {
                        return null;
                    }
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public static boolean[] canIncrease(Point p, InputReader in) throws IOException {
        boolean b[] = new boolean[2];
        String ans = query(p, in);
        if ("CENTER".equals(ans)) {
            b[0] = true;
        } else if ("MISS".equals(ans) || "WRONG".equals(ans)) {
            b[1] = true;
        } else {
            b[1] = false;
        }
        return b;
    }

    public static boolean[] canDecrease(Point p, InputReader in) throws IOException {
        boolean b[] = new boolean[2];
        String ans = query(p, in);
        if ("CENTER".equals(ans)) {
            b[0] = true;
        } else if ("MISS".equals(ans) || "WRONG".equals(ans)) {
            b[1] = false;
        } else {
            b[1] = true;
        }
        return b;
    }

    public static Point getRightLimit(Point start, InputReader in) throws IOException {
        Point toReturn = new Point(start.x, start.y);
        int startDim = 2*NANOMETERS;
        int lo = start.x, hi = startDim, mid = 0, ans = 0;
        int lastMid = 0;
        while (hi - lo >= 0) { // when the answer is not found yet
            mid = lo + (hi - lo) / 2; // try the middle value
            if (mid == lastMid) {
                break;
            }
            boolean b[] = canIncrease(new Point(mid, start.y), in);
            if (b[0]) {
                toReturn.isCenter = true;
                return toReturn;
            }
            if (b[1]) {
                ans = mid;
                hi = mid;
            } // save the value, then continue
            else lo = mid;
            lastMid = mid;
        }
        toReturn.x = ans;
        return toReturn;
    }

    public static Point getLeftLimit(Point start, InputReader in) throws IOException {
        Point toReturn = new Point(start.x, start.y);
        int startDim = 2*NANOMETERS;
        int lo = 0, hi = start.x, mid = 0, ans = 0;
        int lastMid = 0;
        while (hi - lo >= 0) { // when the answer is not found yet
            mid = lo + (hi - lo) / 2; // try the middle value
            if (mid == lastMid) {
                break;
            }
            boolean b[] = canDecrease(new Point(mid, start.y), in);
            if (b[0]) {
                toReturn.isCenter = true;
                return toReturn;
            }
            if (b[1]) {
                ans = mid;
                hi = mid;
            } // save the value, then continue
            else lo = mid;
            lastMid = mid;
        }
        toReturn.x = ans;
        return toReturn;
    }

    public static Point getTopLimit(Point start, InputReader in) throws IOException {
        Point toReturn = new Point(start.x, start.y);
        int startDim = 2*NANOMETERS;
        int lo = start.y, hi = startDim, mid = 0, ans = 0;
        int lastMid = 0;
        while (hi - lo >= 0) { // when the answer is not found yet
            mid = lo + (hi - lo) / 2; // try the middle value
            if (mid == lastMid) {
                break;
            }
            boolean b[] = canIncrease(new Point(start.x, mid), in);
            if (b[0]) {
                toReturn.isCenter = true;
                return toReturn;
            }
            if (b[1]) {
                ans = mid;
                hi = mid;
            } // save the value, then continue
            else lo = mid;
            lastMid = mid;
        }
        toReturn.y = ans;
        return toReturn;
    }

    public static Point getBottomLimit(Point start, InputReader in) throws IOException {
        Point toReturn = new Point(start.x, start.y);
        int startDim = 2*NANOMETERS;
        int lo = 0, hi = start.y, mid = 0, ans = 0;
        int lastMid = 0;
        while (hi - lo >= 0) { // when the answer is not found yet
            mid = lo + (hi - lo) / 2; // try the middle value
            if (mid == lastMid) {
                break;
            }
            boolean b[] = canDecrease(new Point(start.x, mid), in);
            if (b[0]) {
                toReturn.isCenter = true;
                return toReturn;
            }
            if (b[1]) {
                ans = mid;
                hi = mid;
            } // save the value, then continue
            else lo = mid;
            lastMid = mid;
        }
        toReturn.y = ans;
        return toReturn;
    }



    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        int test = in.readInt();
        int a = in.readInt();
        int b = in.readInt();
        //fileWriter = getFileWriter(Paths.get(getCurrentPathDirectory(), "output", "OUTPUT").toString());

        for (int t = 0; t < test; t++) {
            //fileWriter.write("Test number #"+t+"\n");
            //fileWriter.flush();
            Point circleLocated = locateCircle(in);
            if (circleLocated == null) {
                //fileWriter.write("Circle located is null");
                //fileWriter.flush();
                break;
            }
            //fileWriter.write("Circle located at ("+(circleLocated.x-1000000000)+", "+(circleLocated.y-1000000000)+")\n");
            //fileWriter.flush();
            if (circleLocated.isCenter) {
                continue;
            }
            //fileWriter.write("Looking left\n");
            //fileWriter.flush();
            Point left = getLeftLimit(circleLocated, in);
            if (left.isCenter) {
                continue;
            }
            //fileWriter.write("Looking right\n");
            //fileWriter.flush();
            Point right = getRightLimit(circleLocated, in);
            if (right.isCenter) {
                continue;
            }
            //fileWriter.write("Looking TOP\n");
            //fileWriter.flush();
            Point top = getTopLimit(circleLocated, in);
            if (top.isCenter) {
                continue;
            }
            //fileWriter.write("Looking bottom\n");
            //fileWriter.flush();
            Point bottom = getBottomLimit(circleLocated, in);
            if (bottom.isCenter) {
                continue;
            }
            int xAns = (right.x + left.x) / 2;
            int yAns = (top.y + bottom.y) / 2;
            String res = query(new Point(xAns, yAns), in);
            //fileWriter.write("My center is in ("+(xAns-1000000000)+", "+(yAns-1000000000)+")\n");
            //fileWriter.flush();
            if ("CENTER".equals(res)) {
                continue;
            } else {
            }

        }
        //fileWriter.close();
    }
}
