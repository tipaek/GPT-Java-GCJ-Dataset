import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {

//        InputStream inputStream;
//        try {
//            inputStream = new FileInputStream("src/input/" + "input" + ".in");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        OutputStream outputStream;
//        try {
//            outputStream = new FileOutputStream("src/output/" + "output" + ".out");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        Blindfolded solver = new Blindfolded();
        int testCount = in.nextInt();
        int A = in.nextInt();
        int B = in.nextInt();

        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out, A, B);
        out.close();
    }

    static class Blindfolded {

        private enum ResponseStatus {
            CENTER,
            HIT,
            WRONG,
            MISS
        }

        class Point {
            long x;
            long y;
            ResponseStatus status;

            Point(long x, long y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public String toString() {
                return String.format("%d %d", x, y);
            }
        }

        void solve(int testNumber, InputReader in, PrintWriter out, int min, int max) {

            Point topLeft = new Point(-1000000000, 1000000000);
            Point topRight = new Point(1000000000, 1000000000);
            Point bottomLeft = new Point(-1000000000, -1000000000);
            Point bottomRight = new Point(1000000000, -1000000000);

            Point point = findAPointOnBoard(in, out, min, max);
            if (point == null || point.status == ResponseStatus.CENTER) return;

            if (point.status == ResponseStatus.HIT) {
                long r1 = (long) (point.x - ((0.51 * max)));
                long c1 = (long) (point.y - ((0.51 * max)));

                long r2 = (long) (point.x + ((0.51 * max)));
                long c2 = (long) (point.y + ((0.51 * max)));

                ResponseStatus status = binarySearch(in, out, r1, c1, r2, c2);
                if (status == ResponseStatus.MISS) {
                    return;
                }
            }
        }

        private ResponseStatus binarySearch(InputReader in, PrintWriter out,
                                     long r1, long c1, long r2, long c2) {

            if (r1 >= r2 || c1 >= c2) return ResponseStatus.MISS;

            long rm = (r1 + r2) / 2;
            long cm = (c1 + c2) / 2;

            out.printf("%d %d", rm, cm);

            ResponseStatus status = ResponseStatus.valueOf(in.next());
            if (status == ResponseStatus.CENTER) {
                return status;
            } else if (status == ResponseStatus.HIT) {

                ResponseStatus s1 = binarySearch(in, out, r1, c1, r2, cm);
                ResponseStatus s2 = binarySearch(in, out, r1, cm, rm, c2);

                ResponseStatus s3 = binarySearch(in, out, r1, cm, rm, c2);
                ResponseStatus s4 = binarySearch(in, out, rm, c1, r2, c2);

                if (s1 == ResponseStatus.CENTER || s2 == ResponseStatus.CENTER ||
                        s3 == ResponseStatus.CENTER || s4 == ResponseStatus.CENTER) {
                    return ResponseStatus.CENTER;
                } else if (s1 == ResponseStatus.HIT || s2 == ResponseStatus.HIT ||
                        s3 == ResponseStatus.HIT || s4 == ResponseStatus.HIT) {
                    return ResponseStatus.HIT;
                } else return ResponseStatus.MISS;
            } else {
                return ResponseStatus.MISS;
            }
        }

        Point findAPointOnBoard(InputReader in, PrintWriter out, int min, int max) {

            Queue<Point> queue = new LinkedList<>();
            queue.offer(new Point(0, 0));

            int K = 1000000000;
            int level = 1;

            while (!queue.isEmpty()) {

                int size = queue.size();

                for (int i = 0; i < size; i++) {

                    Point curr = queue.poll();
                    out.print(curr.toString());

                    ResponseStatus status = ResponseStatus.valueOf(in.next());
                    if (status == ResponseStatus.HIT || status == ResponseStatus.CENTER) {
                        curr.status = status;
                        return curr;
                    } else if (status == ResponseStatus.MISS) {
                        int value = (int) (K / Math.pow(2, level));
                        queue.offer(new Point(curr.x - value, curr.y + value)); // top left
                        queue.offer(new Point(curr.x + value, curr.y + value)); // top right
                        queue.offer(new Point(curr.x - value, curr.y - value)); // bottom left
                        queue.offer(new Point(curr.x + value, curr.y - value)); // bottom right
                    } else {
                        return null;
                    }
                }

                level++;
            }

            return null;
        }


    }


    static class InputReader {
        BufferedReader br;
        StringTokenizer st;

        InputReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        String next() {
            return nextToken();
        }

        public String nextToken() {
            while (st == null || !st.hasMoreTokens()) {
                String line;
                try {
                    line = br.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (line == null) {
                    return null;
                }
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }
    }
}