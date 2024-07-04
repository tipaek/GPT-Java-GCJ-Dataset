// coded by Krishna Sundar //

import java.lang.*;
import java.io.*;
import java.util.*;

public class Solution {

    public void solve(Read input, Write output) throws Exception {
        int cases = input.readInt(), k= 1;
        while (cases-->0) {
            int N = input.readInt();
            int[][] arr = new int[N][N];
            int trace = 0;
            for (int i=0;i<N;i++) {
                for (int j=0;j<N;j++) {
                    arr[i][j] = input.readInt();
                    if (i==j) {
                        trace += arr[i][j];
                    }
                }
            }
            int rows = 0;
            for (int i=0;i<N;i++) {
                Set<Integer> used = new HashSet<Integer>();
                for (int j=0;j<N;j++) {
                    used.add(arr[i][j]);
                }
                if (used.size()!=N) {
                    rows++;
                }
            }
            int columns = 0;
            for (int j=0;j<N;j++) {
                Set<Integer> used = new HashSet<Integer>();
                for (int i=0;i<N;i++) {
                    used.add(arr[i][j]);
                }
                if (used.size()!=N) {
                    columns++;
                }
            }
            output.printLine("Case #"+k+": "+trace+" "+rows+" "+columns);
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