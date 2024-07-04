import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        Reader reader = new Reader();
        int T = reader.nextInt();
        int cnt = 0;
        while (T > 0) {
            ++cnt;
            System.out.print("Case #" + cnt + ": ");
            --T;
            int C = reader.nextInt();
            int D = reader.nextInt();
            int[] left = new int[D];
            int[] right = new int[D];
            int[] stops = new int[C - 1];
            int[] ans = new int[D];
            int[] dist = new int[C];
            dist[0] = 0;
            boolean[] visited = new boolean[C];
            visited[0] = true;
            for (int i = 0; i < C - 1; ++i) {
                stops[i] = reader.nextInt();
            }
            for (int i = 0; i < D; ++i) {
                left[i] = reader.nextInt();
                right[i] = reader.nextInt();
            }
            Computer[] computer = new Computer[C - 1];
            for (int i = 0; i < C - 1; ++i) {
                computer[i] = new Computer();
                computer[i].connections = new ArrayList<>();
                computer[i].prev = -stops[i];
                computer[i].id = i + 2;
//                System.out.println(computer[i].prev);
            }
            for (int j = 0; j < D; ++j) {
                computer[right[j] - 2].connections.add(left[j] - 1);
            }

            //Sort
            for (int i = 0; i < C - 2; i++) {
                for (int j = 0; j < C - i - 2; j++) {
                    if (computer[j].prev > computer[j + 1].prev) {
                        // Swap
                        Computer temp = new Computer();
                        temp = computer[j];
                        computer[j] = computer[j + 1];
                        computer[j + 1] = temp;
                    }
                }
            }
            int last_max;
            int sum = 0;
            int last = 1;
            ArrayList<Latency> list = new ArrayList<>();
            for (int i = 0; i < C - 1; ++i) {
//                System.out.println(computer[i].connections);
                for (int j = 0; j < computer[i].connections.size(); ++j) {
                    if (visited[computer[i].connections.get(j)]) {
                        Latency latency = new Latency();
                        latency.l = computer[i].connections.get(j) + 1;
                        latency.r = computer[i].id;
//                        System.out.println("DD" + latency.l);
//                        System.out.println(latency.r);
                        int prev = dist[computer[i].connections.get(j)];
                        if (i > 0 && computer[i].prev > computer[i - 1].prev) {
                            last_max = sum + 1;
                            latency.lat = last_max - prev;
                            sum += latency.lat;
                            last = latency.lat;
                            dist[computer[i].id-1] = last;
                        } else {
                            sum += last;
                            latency.lat = last - prev;
                            dist[computer[i].id-1] = last;
                        }
                        visited[i + 1] = true;
                        list.add(latency);
                        break;
                    }
                }
            }
//            for (int i = 0; i < C; ++i)
//                System.out.println(visited[i]);
//            for (int i = 0; i < list.size(); ++i) {
//                System.out.print(list.get(i).l + " ");
//                System.out.print(list.get(i).r + " ");
//                System.out.println(list.get(i).lat);
//            }
            boolean[] edge = new boolean[D];
            for (int i = 0; i < D; ++i) {
                for (int j = 0; j < list.size(); ++j) {
                    if (list.get(j).l == left[i] && list.get(j).r == right[i]) {
                        edge[i] = true;
                        ans[i] = list.get(j).lat;
                    }
                }
            }
            for (int i = 0; i < D; ++i) {
                if (!edge[i]) {
                    ans[i] = 1000000;
                }
            }
            for (int i = 0; i < D; ++i) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }

    static class Computer {
        ArrayList<Integer> connections;
        int prev;
        int id;
    }

    static class Latency {
        int l;
        int r;
        int lat;
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
}
