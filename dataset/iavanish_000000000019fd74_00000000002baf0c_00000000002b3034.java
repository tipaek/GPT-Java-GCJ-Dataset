import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Solution {


    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();

        int t = reader.nextInt();

        for (int testCase = 1; testCase <= t; testCase++) {
            int n = reader.nextInt();

            List<String> s = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                s.add(reader.readLine());
            }

            boolean notFound = false;
            StringBuilder constructPrefix = new StringBuilder();
            StringBuilder constructSuffix = new StringBuilder();
            while (!s.isEmpty()) {
                List<String> sCopy = new ArrayList<>();
                String prefix = "";
                String suffix = "";
                for (int i = 0; i < s.size(); i++) {
                    int first = s.get(i).indexOf('*');
                    int last = s.get(i).indexOf('*');
                    if (first < 0) {
                        if (prefix.isEmpty() || s.get(i).indexOf(prefix) == 0) {
                            prefix = s.get(i);
                            suffix = s.get(i);
                        }
                        else if (prefix.indexOf(s.get(i)) == 0) {
                        }
                        else {
                            notFound = true;
                            break;
                        }
                    }
                    else {
                        String tempPrefix = s.get(i).substring(0, first);
                        String tempSuffix = new StringBuilder(s.get(i).substring(last+1)).reverse().toString();
                        if ((prefix.isEmpty() || s.get(i).indexOf(tempPrefix) == 0) && (suffix.isEmpty() || s.get(i).indexOf(tempSuffix) == 0)) {
                            prefix = s.get(i);
                            suffix = s.get(i);
                            if (first != last) {
                                sCopy.add(s.get(i).substring(first+1, last));
                            }
                        }
                        else if (tempPrefix.indexOf(s.get(i)) == 0 && tempSuffix.indexOf(s.get(i)) == 0) {
                        }
                        else {
                            notFound = true;
                            break;
                        }
                    }
                }
                
                constructPrefix.append(prefix);
                constructSuffix.append(suffix);
            }

            if (notFound) {
                System.out.printf("Case #%d: %s\n", testCase, "*");
            }
            else {
                System.out.printf("Case #%d: %s\n", testCase, constructPrefix.append(constructSuffix.reverse()).toString());
            }
        }
    }

    /**
     * Fast input code borrowed from
     * http://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
     */
    private static class Reader {
        private final int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String fileName) throws IOException {
            din = new DataInputStream(new FileInputStream(fileName));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[10000000];
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    break;
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) {
                return -ret;
            }
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) {
                return -ret;
            }
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
            if (neg) {
                return -ret;
            }
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) {
                buffer[0] = -1;
            }
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) {
                fillBuffer();
            }
            return buffer[bufferPointer++];
        }
    }

}
