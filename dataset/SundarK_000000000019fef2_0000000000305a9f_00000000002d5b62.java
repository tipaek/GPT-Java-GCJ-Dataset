// coded by Krishna Sundar //

import java.lang.*;
import java.io.*;
import java.util.*;

public class Solution {

    private static final long BOUND = 1000000000l;

    private static class Node {
        public long X,Y, step;
        public String path = "";
        public Node (long X, long Y, long step, String path) {
            this.X = X;
            this.Y = Y;
            this.step = step;
            this.path = path;
        }
    }

    private static class Point {
        public long X,Y;

        public Point(long x, long y) {
            X = x;
            Y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return X == point.X &&
                    Y == point.Y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(X, Y);
        }
    }

    public void solve(Read input, Write output) throws Exception {
        int cases = input.readInt(), k=1;
        while (cases-->0) {
            long X = input.readLong();
            long Y = input.readLong();
            int[] dirx = new int[]{0,0,1,-1};
            int[] diry = new int[]{1,-1,0,0};
            LinkedList<Node> Q = new LinkedList<>();
            Q.addLast(new Node(0l, 0l, 0, ""));
            Map<Point, Boolean> visited = new HashMap<>();
            boolean f = false;
            String f_path = "";
            while (!Q.isEmpty()) {
                Node N = Q.removeFirst();
                long next_step = N.step+1;
                String curr_path = N.path;
                visited.put(new Point(N.X, N.Y), true);
                if (X==N.X && Y==N.Y) {
                    f_path = N.path;
                    f = true;
                    break;
                }
                long bx = Math.abs(X);
                long by = Math.abs(Y);
                long up = Math.max(bx, by);
                for (int i=0;i<4;i++) {
                    long nx = N.X+(dirx[i]*(1l<<N.step));
                    long ny = N.Y+(diry[i]*(1l<<N.step));
                    Character next = null;
                    if (i==0) {
                        next = 'N';
                    } else if (i==1) {
                        next = 'S';
                    } else if (i==2) {
                        next = 'E';
                    } else {
                        next = 'W';
                    }

                    if (nx<=BOUND && nx>=(-BOUND) && ny<=BOUND && ny>=(-BOUND)) {
                        if (!(nx>=-up && nx<=up && ny>=-up && ny<=up)) {
                            continue;
                        }
                        if (visited.get(new Point(nx,ny))==null) {
                            visited.put(new Point(nx, ny), true);
                            Q.addLast(new Node(nx,ny,next_step, curr_path+next));
                        } else {
                            continue;
                        }
                    }
                }
            }
            if (f) {
                output.printLine("Case #"+k+": "+f_path);
            } else {
                output.printLine("Case #"+k+": IMPOSSIBLE");
            }
            output.flush();
            k++;
        }
    }

    public static void main(String[] args) throws Exception {
        Read input = new Read();
        Write output = new Write();
        Solution D = new Solution();
        D.solve(input, output);
        output.flush();
        output.close();
    }

    // java fast io reader and writer
    // taken from various sources and customized

    static class Read {

        private byte[] buffer =new byte[10*1024];
        private int index;
        private InputStream input_stream;
        private int total;

        public Read() {
            input_stream = System.in;
        }

        public int read()throws IOException {
            if(total<0)
                throw new InputMismatchException();
            if(index>=total) {
                index=0;
                total= input_stream.read(buffer);
                if(total<=0)
                    return -1;
            }
            return buffer[index++];
        }

        public long readLong() throws IOException {
            long number=0;
            int n= read();
            while(isWhiteSpace(n))
                n= read();
            long neg=1l;
            if(n=='-') {
                neg=-1l;
                n= read();
            }
            while(!isWhiteSpace(n)) {
                if(n>='0'&&n<='9') {
                    number*=10l;
                    number+=(long)(n-'0');
                    n= read();
                }
                else throw new InputMismatchException();
            }
            return neg*number;
        }

        public int readInt() throws IOException {
            int integer=0;
            int n= read();
            while(isWhiteSpace(n))
                n= read();
            int neg=1;
            if(n=='-') {
                neg=-1;
                n= read();
            }
            while(!isWhiteSpace(n)) {
                if(n>='0'&&n<='9') {
                    integer*=10;
                    integer+=n-'0';
                    n= read();
                }
                else throw new InputMismatchException();
            }
            return neg*integer;
        }

        public double readDouble()throws IOException {
            double doub=0;
            int n= read();
            while(isWhiteSpace(n))
                n= read();
            int neg=1;
            if(n=='-') {
                neg=-1;
                n= read();
            }
            while(!isWhiteSpace(n)&&n!='.') {
                if(n>='0'&&n<='9') {
                    doub*=10;
                    doub+=n-'0';
                    n= read();
                }
                else throw new InputMismatchException();
            }

            if(n=='.') {
                n= read();
                double temp=1;
                while(!isWhiteSpace(n)) {
                    if(n>='0'&&n<='9') {
                        temp/=10;
                        doub+=(n-'0')*temp;
                        n= read();
                    }
                    else throw new InputMismatchException();
                }
            }
            return doub*neg;
        }

        public String readString()throws IOException {
            StringBuilder sb = new StringBuilder();
            int n = read();
            while (isWhiteSpace(n))
                n = read();
            while (!isWhiteSpace(n)) {
                sb.append((char)n);
                n = read();
            }
            return sb.toString();
        }

        private boolean isWhiteSpace(int n) {
            if(n==' '|| n=='\n'|| n=='\r'|| n=='\t'|| n==-1)
                return true;
            return false;
        }
    }

    static class Write {

        private final BufferedWriter bw;

        public Write() {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }
        public void print(String str) throws IOException {
            bw.append(str);
        }
        public void printLine(String str) throws IOException {
            print(str);
            bw.append("\n");
        }
        public void close()throws IOException {
            bw.close();
        }
        public void flush()throws IOException {
            bw.flush();
        }
    }
}