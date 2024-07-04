
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.*;

public class Solution
{
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[2000]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }

    static class Pair<A, B> {

        public final A fst;
        public final B snd;

        public Pair(A fst, B snd) {
            this.fst = fst;
            this.snd = snd;
        }

        public String toString() {
            return "Pair[" + fst + "," + snd + "]";
        }

        public boolean equals(Object other) {
            return
                    other instanceof Pair<?,?> &&
                            Objects.equals(fst, ((Pair<?,?>)other).fst) &&
                            Objects.equals(snd, ((Pair<?,?>)other).snd);
        }

        public int hashCode() {
            if (fst == null) return (snd == null) ? 0 : snd.hashCode() + 1;
            else if (snd == null) return fst.hashCode() + 2;
            else return fst.hashCode() * 17 + snd.hashCode();
        }

        public static <A,B> Pair<A,B> of(A a, B b) {
            return new Pair<>(a,b);
        }
    }

    static class Cell implements Comparable{
        static long id;
        long ids;
        int firstSkill;
        int secondSkill;
        boolean assigned = false;
        int index;
        int end = -1;
        Cell left = null;
        Cell right = null;

        Cell(int firstSkill, int index){
            this.ids = id;
            this.firstSkill = firstSkill;
            this.index = index;
            id++;
        }

        @Override
        public int compareTo(Object o) {
            if(firstSkill - ((Cell) o).firstSkill == 0){
                return (int) ( ids - ((Cell) o).ids);
            }
            return firstSkill - ((Cell) o).firstSkill;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell node = (Cell) o;
            return ids == node.ids;
        }

        @Override
        public int hashCode() {
            return Objects.hash(ids);
        }
    }

    static HashMap<Integer,BigDecimal> dynamic = new HashMap<>();

    public static void main(String[] args) throws IOException
    {
        Reader s = new Reader();
        int testCases = s.nextInt();
        for(int i = 0; i < testCases; i++){
            int X = s.nextInt();
            int Y = s.nextInt();
            String path = s.readLine();
            int maxDist = 0;
            boolean broke = false;
            while(true){
                if(path.length() == 0){
                    if(Math.abs(X) + Math.abs(Y) <= maxDist){
                        broke = true;
                    }
                    break;
                }
                char current = path.charAt(0);
                path = path.substring(1);
                if(Math.abs(X) + Math.abs(Y) <= maxDist){
                    broke = true;
                    break;
                }
                if(current == 'N'){
                    Y++;
                }
                if(current == 'S'){
                    Y--;
                }
                if(current == 'E'){
                    X++;
                }
                if(current == 'W'){
                    X--;
                }
                maxDist++;
            }
            if(!broke){
                writer.write(String.format("Case #%d: IMPOSSIBLE\n", i + 1));
            }
            else {
                writer.write(String.format("Case #%d: %s\n", i + 1, maxDist));
            }
            writer.flush();
        }
        writer.close();
    }
}