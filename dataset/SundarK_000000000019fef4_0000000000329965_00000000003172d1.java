// coded by Krishna Sundar //

import java.lang.*;
import java.io.*;
import java.util.*;

public class Solution {

    private static class Node {
        public long c,num,i;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return c == node.c &&
                    num == node.num;
        }

        @Override
        public int hashCode() {
            return Objects.hash(c, num);
        }
    }

    public void solve(Read input, Write output) throws Exception {
        int N = input.readInt();
        Long D = input.readLong();
        Long result = D-1;
        Map<Long, Long> count = new TreeMap<>();
        List<Long> sector = new ArrayList<>();
        for (int i=0;i<N;i++) {
            sector.add(input.readLong());
            if (count.get(sector.get(i))==null) {
                count.put(sector.get(i), 1L);
            } else {
                count.put(sector.get(i), count.get(sector.get(i))+1L);
            }
        }
        long max_val = -1, max_c = -1;
        for (Map.Entry<Long, Long> e : count.entrySet()) {
            Long val = e.getKey();
            Long c = e.getValue();
            if (c>max_c) {
                max_val = val;
                max_c = c;
            }
        }
        if (count.size()==1) {
            if (D<=max_c) {
                output.printLine("0");
            } else {
                output.printLine(""+(D-1));
            }
        } else {
            if (((TreeMap<Long, Long>) count).lastEntry().getKey()==max_val) {
                Map.Entry<Long, Long> prev = null;
                for (Map.Entry<Long, Long> ee : count.entrySet()) {
                    if (((TreeMap<Long, Long>) count).lastEntry().equals(ee)) {
                        break;
                    }
                    prev = ee;
                }
                long curr_val = prev.getKey();
                long curr_c = prev.getValue();
                if (D<=curr_c) {
                    output.printLine("0");
                } else {
                    D = D-curr_c;
                    output.printLine(""+Math.max(D-1,1));
                }
            } else {
                if (D<=max_c) {
                    output.printLine("0");
                } else {
                    D = D-max_c;
                    output.printLine(""+Math.max(D-1,1));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Read input = new Read();
        Write output = new Write();
        Solution D = new Solution();
        int cases = input.readInt(), k=1;
        while (cases-->0) {
            output.print("Case #" + k + ": ");
            D.solve(input, output);
            k++;
        }
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