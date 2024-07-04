import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {


    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
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

        public double nextDouble() throws IOException {
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

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }

    static int gcd(int a, int b) {
        // Everything divides 0
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        // base case
        if (a == b)
            return a;

        // a is greater
        if (a > b)
            return gcd(a - b, b);
        return gcd(a, b - a);
    }
        public static class Task{
            int start;
            int end;

            public Task(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }
        public static int sortbyStart(Task t1,Task t2){
        if(t1.start != t2.start) return t1.start-t2.start;
        else return t1.end-t2.end;
        }
        public static boolean taskmerge(Task t1,Task t2){
        if(t2.start>t1.start && t2.end<t1.end) return true;
        else if(t2.start>t1.start && t2.start<t1.end) return true;
        else if(t2.start<t1.start && t2.end>t1.end) return true;
        else return false;
        }
    public static void main(String[] args) throws IOException {
        Reader r = new Reader();
        int t = r.nextInt();
        int flag = 0;
        while (t-- > 0) {
           flag++;
           int n = r.nextInt();
           Task c = new Task(0,0);
           Task j = new Task(0,0);
           HashMap<Integer,Task> hm = new HashMap<>();
           for(int i=0;i<n;i++){
               int start = r.nextInt();
               int end = r.nextInt();
               hm.put(i+1,new Task(start,end));
           }
           int[] index = new int[n];
           for(int i=0;i<n;i++){
               index[i] = i+1;
           }
            for (int i = 0; i < n-1; i++)
                for (int k = 0; k < n-i-1; k++)
                    if (sortbyStart(hm.get(index[k]),hm.get(index[k+1]))>0)
                    {
                        int temp = index[k];
                        index[k] = index[k+1];
                        index[k+1] = temp;
                    }
            int count = 1;
            HashMap<Integer,Character> ans = new HashMap<>();
                    ans.put(index[0],'C');
                    c.start = hm.get(index[0]).start;
                    c.end = hm.get(index[0]).end;
                    for(int i=1;i<n;i++){
                        if(hm.get(index[i]).start>=c.end){
                            c.start = hm.get(index[i]).start;
                            c.end = hm.get(index[i]).end;
                            ans.put(index[i],'C');
                            count++;
                        }
                        else if(hm.get(index[i]).start>=j.end){
                            j.start = hm.get(index[i]).start;
                            j.end = hm.get(index[i]).end;
                            ans.put(index[i],'J');
                            count++;
                        }
                    }
                    System.out.print("Case #"+flag+": ");
                    if(count==n){
                        for(int i=0;i<n;i++){
                            System.out.print(ans.get(i+1));
                        }
                        System.out.println();
                    }else{
                        System.out.println("IMPOSSIBLE");
                    }
        }
    }
}