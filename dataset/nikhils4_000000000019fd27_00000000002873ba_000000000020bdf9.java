import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;

class Solution {

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
            byte[] buf = new byte[64];
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
            } while ((c = read()) >= '0' && c <= '9');
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
            } while ((c = read()) >= '0' && c <= '9');

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

    public static void main(String[] args) throws IOException {
        Reader sc = new Reader();
        int test = sc.nextInt();
        int caseno = 1;
        while (test-->0) {
            int n = sc.nextInt();
            int[] start = new int[n];
            int[] end = new int[n];
            int cstart = 0, jstart = 0;
            int cend = 0, jend = 0;
            boolean possible = true;
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < n; i++) {
                start[i] = sc.nextInt();
                end[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    ans.append('J');
                    jend = end[0];
                    jstart = start[0];
                } else {
                    char ch = ans.charAt(i - 1);
                    if (start[i] > end[i - 1]) {
                        if (ch == 'C') {
                            ans.append('C');
                            cend = end[i];
                            cstart = start[i];
                        } else {
                            ans.append('J');
                            jend = end[i];
                            jstart = start[i];
                        }
                    } else if (start[i] == end[i - 1]) {
                        if (ch == 'C') {
                            ans.append('C');
                            cend = end[i];
                        } else {
                            ans.append('J');
                            jend = end[i];
                        }
                    } else {
                        if (start[i] < end[i - 1] && start[i] >= start[i - 1]) {
                            if (ch == 'C') {
                                if (jend <= start[i] || jstart >= end[i]) {
                                    ans.append('J');
                                    jstart = start[i];
                                    jend = end[i];
                                } else {
                                    possible = false;
                                    break;
                                }
                            } else {
                                if (cend <= start[i] || cstart >= end[i]) {
                                    ans.append('C');
                                    cstart = start[i];
                                    cend = end[i];
                                } else {
                                    possible = false;
                                    break;
                                }
                            }
                        } else if (start[i] < start[i - 1]) {
                            if (end[i] <= end[i - 1]) {
                                if (ch == 'C' && (jstart >= end[i] || jend <= start[i])) {
                                    ans.append('J');
                                    jstart = start[i];
                                    jend = end[i];
                                } else {
                                    if (cstart >= end[i] || cend <= start[i]) {
                                        ans.append('C');
                                        cstart = start[i];
                                        cend = end[i];
                                    } else {
                                        possible = false;
                                        break;
                                    }
                                }
                            } else {
                                if (ch == 'C') {
                                    if (jstart >= end[i] || jend <= start[i]) {
                                        ans.append('J');
                                        jstart = start[i];
                                        jend = end[i];
                                    } else {
                                        possible = false;
                                        break;
                                    }
                                } else {
                                    if (cstart >= end[i] || cend <= start[i]) {
                                        ans.append('J');
                                        cstart = start[i];
                                        cend = end[i];
                                    } else {
                                        possible = false;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (!possible)
                System.out.println("Case #" + caseno++ + ": IMPOSSIBLE");
            else
                System.out.println("Case #" + caseno++ + ": " + ans);
        }
    }
}
