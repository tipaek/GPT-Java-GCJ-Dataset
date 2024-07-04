import java.util.*;
import java.io.*;

class Solution {
    static class Reader {
        private static final int BUFFER_SIZE = 1 << 16;
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
            byte[] buf = new byte[64];
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return neg ? -ret : ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return neg ? -ret : ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
            return neg ? -ret : ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din != null) din.close();
        }
    }

    static class Activity {
        int start, end, srNo, assignedTo = 0;

        Activity(int start, int end, int srNo) {
            this.start = start;
            this.end = end;
            this.srNo = srNo;
        }

        @Override
        public String toString() {
            return "srNo = " + srNo + " start = " + start + " , end = " + end + " assignedTo = " + assignedTo + "\n";
        }
    }

    public static void main(String[] args) throws IOException {
        Reader r = new Reader();
        int t = r.nextInt();
        for (int z = 0; z < t; z++) {
            int n = r.nextInt();
            Activity[] activities = new Activity[n];
            for (int i = 0; i < n; i++) {
                int start = r.nextInt();
                int end = r.nextInt();
                activities[i] = new Activity(start, end, i + 1);
            }
            Arrays.sort(activities, Comparator.comparingInt(a -> a.start));

            boolean impossible = false;
            int lastAssignedC = -1, lastAssignedJ = -1;
            for (Activity activity : activities) {
                if (lastAssignedJ <= activity.start) {
                    lastAssignedJ = activity.end;
                    activity.assignedTo = 1;
                } else if (lastAssignedC <= activity.start) {
                    lastAssignedC = activity.end;
                    activity.assignedTo = 2;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + (z + 1) + ": IMPOSSIBLE");
                continue;
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a.srNo));
            StringBuilder ans = new StringBuilder("Case #" + (z + 1) + ": ");
            for (Activity activity : activities) {
                ans.append(activity.assignedTo == 1 ? 'J' : 'C');
            }
            System.out.println(ans);
        }
    }
}