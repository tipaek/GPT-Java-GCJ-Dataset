import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        InputReader.OutputWriter out = new InputReader.OutputWriter(outputStream);

        int t = in.nextInt();
        for (int it = 0; it < t; it++) {
            int n = in.nextInt();
            Interval [] a = new Interval[n];
            for (int i = 0; i < n; i++) {
                a[i] = new Interval(in.nextInt(),in.nextInt());
            }
            Arrays.sort(a,(x,y)->   x.start - y.start == 0
                                    ? x.end - y.end :
                                    x.start - y.start);
         //   out.println(Arrays.toString(a));
            int maxFirst = Integer.MIN_VALUE;
            int maxSecond = Integer.MIN_VALUE;
            StringBuilder sb = new StringBuilder();
            boolean impossible = false;
            for (int i = 0; i < a.length; i++) {
                if(maxFirst == Integer.MIN_VALUE) {
                    maxFirst = a[i].end;
                    sb.append("C");
                }
                else {
                    int startOverlap = Math.max(a[i].start,a[i-1].start);
                    int endOverlap = Math.min(a[i].end,a[i-1].end);
                    // if we have overlap
                    if (startOverlap <= endOverlap) {
                        if(a[i].start >= maxSecond) { // if second can start
                            maxSecond = a[i].end;
                            sb.append("J");
                        }
                        else if(a[i].start >= maxFirst) {
                            maxFirst = a[i].end;
                            sb.append("C");
                        }
                        else {
                         //   out.println(sb);
                           // out.println(maxFirst + " " + maxSecond);
                            impossible = true;
                            break;
                        }
                    }
                    // if there is no overlap use the last man
                    else {
                        char last = sb.charAt(sb.length() - 1);
                        if(last == 'C') maxFirst = a[i].end;
                        else maxSecond = a[i].end;
                        sb.append(last);
                    }
                }
            }
            out.println("Case #" + (it + 1) + ": " +
                        ((impossible) ? "IMPOSSIBLE" : sb));
        }

        out.flush();
    }
}

class Interval {
    int start;
    int end;

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return
                "start=" + start +
                ", end=" + end +
                '}';
    }
}


class InputReader extends BufferedReader {
    StringTokenizer tokenizer;

    public InputReader(InputStream inputStream) {
        super(new InputStreamReader(inputStream), 32768);
    }

    public InputReader(String filename) {
        super(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream(filename)));
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(readLine());
            } catch (IOException e) {
                throw new RuntimeException();
            }
        }
        return tokenizer.nextToken();
    }

    public Integer nextInt(){
        return Integer.valueOf(next());
    }
    public Long nextLong() {
        return  Long.valueOf(next());
    }
    public Double nextDouble() {
        return Double.valueOf(next());
    }
    static class OutputWriter extends PrintWriter {
        public OutputWriter(OutputStream outputStream) {
            super(outputStream);
        }

        public OutputWriter(Writer writer) {
            super(writer);
        }

        public OutputWriter(String filename) throws FileNotFoundException {
            super(filename);
        }

        public void close() {
            super.close();
        }
    }
}
