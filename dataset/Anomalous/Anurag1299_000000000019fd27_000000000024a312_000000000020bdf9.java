import java.util.*;
import java.io.*;

class Solution {

    static class FastReader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public FastReader(String fileName) throws IOException {
            din = new DataInputStream(new FileInputStream(fileName));
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
        FastReader reader = new FastReader();
        int t = reader.nextInt();
        for (int z = 0; z < t; z++) {
            int n = reader.nextInt();
            Activity[] activities = new Activity[n];
            for (int i = 0; i < n; i++) {
                int start = reader.nextInt();
                int end = reader.nextInt();
                activities[i] = new Activity(start, end, i + 1);
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a.end));

            boolean jAssigned = false, cAssigned = false, impossible = false;
            int lastAssignedC = -1, lastAssignedJ = -1;

            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    jAssigned = true;
                    lastAssignedJ = activities[i].end;
                    activities[i].assignedTo = 1;
                    continue;
                }
                if (!jAssigned || lastAssignedJ <= activities[i].start) {
                    jAssigned = true;
                    lastAssignedJ = activities[i].end;
                    activities[i].assignedTo = 1;
                } else if (!cAssigned || lastAssignedC <= activities[i].start) {
                    cAssigned = true;
                    lastAssignedC = activities[i].end;
                    activities[i].assignedTo = 2;
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
            StringBuilder result = new StringBuilder("Case #" + (z + 1) + ": ");
            for (Activity activity : activities) {
                result.append(activity.assignedTo == 1 ? 'J' : 'C');
            }
            System.out.println(result);
        }
    }
}