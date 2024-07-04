import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

class Solution {

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();

        int t = reader.nextInt();
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = reader.nextInt();

            TrieNode prefixTrie = new TrieNode();
            TrieNode suffixTrie = new TrieNode();
            for (int i = 0; i < n; i++) {
                String s = reader.readLine();

                TrieNode temp = prefixTrie;
                temp.nodes++;
                int j;
                for (j = 0; j < s.length(); j++) {
                    if (s.charAt(j) != '*') {
                        temp = temp.insert(s.charAt(j));
                        temp.nodes++;
                    }
                    else {
                        break;
                    }
                }
                temp.leaves++;
                if (j < s.length()) {
                    temp.asterix++;
                }

                temp = suffixTrie;
                temp.nodes++;
                for (j = s.length()-1; j >= 0; j--) {
                    if (s.charAt(j) != '*') {
                        temp = temp.insert(s.charAt(j));
                        temp.nodes++;
                    }
                    else {
                        break;
                    }
                }
                temp.leaves++;
                if (j >= 0) {
                    temp.asterix++;
                }
            }

            boolean notFound = false;

            StringBuilder prefix = new StringBuilder();
            TrieNode temp = prefixTrie;
            int asterix = 0;
            while (temp.leaves + asterix < n) {
                if (temp.nodes + asterix < n) {
                    notFound = true;
                    break;
                }
                asterix += temp.asterix;
                prefix.append(temp.firstChild);
                temp = temp.get(temp.firstChild);
            }

            StringBuilder suffix = new StringBuilder();
            temp = suffixTrie;
            asterix = 0;
            while (temp.leaves + asterix < n) {
                if (temp.nodes + asterix < n) {
                    notFound = true;
                    break;
                }
                asterix += temp.asterix;
                suffix.append(temp.firstChild);
                temp = temp.get(temp.firstChild);
            }

            if (notFound) {
                System.out.printf("Case #%d: %s\n", testCase, "*");
            }
            else {
                System.out.printf("Case #%d: %s\n", testCase, prefix.append(suffix.reverse()).toString());
            }
        }
    }

    private static class TrieNode {
        public TrieNode[] children;
        public int leaves;
        public int nodes;
        public char firstChild;
        public int asterix;
        TrieNode() {
            children = new TrieNode[26];
            leaves = 0;
            nodes = 0;
            firstChild = 0;
            asterix = 0;
        }
        public TrieNode insert(char c) {
            int key = getKey(c);
            if (children[key] == null) {
                children[key] = new TrieNode();
                firstChild = c;
            }
            return children[key];
        }
        public TrieNode get(char c) {
            return children[getKey(c)];
        }
        public int getKey(char c) {
            return c - 'A';
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
