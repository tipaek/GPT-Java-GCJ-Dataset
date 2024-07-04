import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;

public class Solution{
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        ParentingPartneringReturns solver = new ParentingPartneringReturns();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class ParentingPartneringReturns {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.readInt();
            int i, k, r;
            Interval[] arr = new Interval[n];
            ArrayList<Interval> c_list = new ArrayList<Interval>();
            ArrayList<Interval> j_list = new ArrayList<Interval>();
            StringBuilder result = new StringBuilder();
            boolean status;
            for(i = 0; i < n; i++){
                arr[i] = new Interval();
                arr[i].s = in.readInt();
                arr[i].e = in.readInt();
                //for each interval check wheteher it contradicts with any of the allocated intervals
                if(i == 0){
                    c_list.add(arr[i]);
                    result.append('C');
                }
                else{
                    //not initial case
                    status = true;
                    r = c_list.size();
                    c_list.add(r, arr[i]);
                    if(isOverlap(c_list)){
                        status = false;
                    }
                    c_list.remove(r);
                    if(status){
                        //that means it doesnt overlap
                        c_list.add(arr[i]);
                        result.append('C');
                        continue;
                    }
                    //reached here that means status was false
                    status = true;
                    //try for jamie
                    r = j_list.size();
                    j_list.add(r, arr[i]);
                    if(isOverlap(j_list)){
                        status = false;
                    }
                    j_list.remove(r);
                    if(status){
                        j_list.add(arr[i]);
                        result.append('J');
                    }
                    else{
                        result.replace(0, result.length(), "IMPOSSIBLE");
                        break;
                    }
                }
            }
            c_list.clear();
            j_list.clear();
            out.printLine("Case #" + testNumber + ":", new String(result));
        }

        public boolean isOverlap(ArrayList<Interval> arr){
            int n = arr.size();
            int max_ele = 0;  
  
            // Find the overall maximum element  
            for (int i = 0; i < n; i++){  
                if (max_ele < arr.get(i).e)  
                    max_ele = arr.get(i).e;  
            }  
  
            // Initialize an array of size max_ele  
            int[] aux = new int[max_ele + 1]; 
            for (int i = 0; i < n; i++){  
                // starting point of the interval  
                int x = arr.get(i).s;   
                // end point of the interval  
                int y = arr.get(i).e;  
                aux[x]++; 
                aux[y]--;  
            }  
            for (int i = 1; i <= max_ele; i++){  
                // Calculating the prefix Sum  
                aux[i] += aux[i - 1];  
                // Overlap  
                if (aux[i] > 1)  
                    return true;  
            }  
  
            // If we reach here, then no Overlap  
            return false;  
        }

        public boolean check_overlap(Interval t1, Interval t2){
            //   ---------
            //---------
            //-------
            //   ------------
            if(t1.s <= t2.s && t1.e > t2.s)
                return true;
            //  ----
            //---------
            if(t1.s >= t2.s && t1.e <= t2.e)
                return true;
            //---------
            //   ----
            if(t1.s < t2.e && t1.e >= t2.e)
                return true;
            return false;
        }

    }

    static class Interval{
        int s, e;
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

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
                if (Character.isValidCodePoint(c)) {
                    res.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

