import java.io.*;


public class Solution {
    static Reader sc;
    static Printer out;
    static final String dir = System.getProperty("user.dir");

    public static void main(String[] args) throws IOException {
        sc = new Reader();
        out = new Printer();
        int testCases;
        String s;
        StringBuilder s1;
        char c, c0;
        testCases = sc.nextInt();
        for (int t = 0; t<testCases; t++) {
            s = sc.readLine();
            s1 = new StringBuilder(s.length()*10);
            for (int i = 0; i < (s.charAt(0)-48); i++) {
                s1.append('(');
            }
            s1.append(s.charAt(0));
            for (int i = 1; i < s.length(); i++) {
                c = s.charAt(i);
                c0 = s.charAt(i-1);
                if(c>c0){
                    for (int j = 0; j < (c-c0); j++) {
                        s1.append('(');
                    }
                }
                if(c<c0){
                    for (int j = 0; j < (c0-c); j++) {
                        s1.append(')');
                    }
                }
                s1.append(c);
            }
            for (int i = 0; i < (s.charAt(s.length()-1)-48); i++) {
                s1.append(')');
            }
            out.println("Case #"+(t+1)+": "+s1.toString());
        }

        out.close();
    }


    static class Printer {
        private OutputStream outputStream;

        public Printer() {
            outputStream = new BufferedOutputStream(System.out);
        }

        public Printer(String file_name) {
            try {
                outputStream = new BufferedOutputStream(new FileOutputStream(file_name));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public void print(Object object) throws IOException {
            outputStream.write(String.valueOf(object).getBytes());
        }

        public void println() throws IOException {
            outputStream.write(("\n").getBytes());
        }

        public void println(Object object) throws IOException {
            outputStream.write((object + "\n").getBytes());
        }

        public void close() throws IOException {
            outputStream.flush();
        }
    }

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
            byte[] buf = new byte[120]; // line length
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
}