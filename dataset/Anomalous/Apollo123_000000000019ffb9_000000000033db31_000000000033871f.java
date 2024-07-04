import java.io.*;
import java.util.*;

public class Solution {
    static Computer[] computers;

    public static void main(String[] args) {
        Kattio scan = new Kattio(System.in);
        int T = scan.getInt();

        for (int t = 1; t <= T; t++) {
            int C = scan.getInt();
            int D = scan.getInt();

            computers = new Computer[C];
            computers[0] = new Computer(0, 0);
            PriorityQueue<Computer> queue = new PriorityQueue<>();
            for (int i = 1; i < C; i++) {
                computers[i] = new Computer(i, -scan.getInt());
                queue.add(computers[i]);
            }

            Connection[] connections = new Connection[D];
            for (int i = 0; i < D; i++) {
                int u = scan.getInt() - 1;
                int v = scan.getInt() - 1;
                Connection conn = new Connection(u, v);
                connections[i] = conn;
                computers[u].addConnection(conn);
                computers[v].addConnection(conn);
            }

            while (!queue.isEmpty()) {
                Computer current = queue.poll();
                Connection conn = current.getMinLatencyConnection();
                Computer previous = computers[conn.getOtherComputer(current.id)];
                conn.latency = current.before - previous.before;
            }

            System.out.print("Case #" + t + ":");
            for (Connection conn : connections) {
                System.out.print(" " + conn.latency);
            }
            System.out.println();
        }
    }

    static class Computer implements Comparable<Computer> {
        int id;
        List<Connection> connections;
        int before;

        Computer(int id, int before) {
            this.id = id;
            this.before = before;
            this.connections = new ArrayList<>();
        }

        void addConnection(Connection conn) {
            connections.add(conn);
        }

        Connection getMinLatencyConnection() {
            int minBefore = Integer.MAX_VALUE;
            Connection minConn = null;
            for (Connection conn : connections) {
                int otherId = conn.getOtherComputer(id);
                if (computers[otherId].before < minBefore) {
                    minBefore = computers[otherId].before;
                    minConn = conn;
                }
            }
            return minConn;
        }

        @Override
        public int compareTo(Computer other) {
            if (this.before != other.before) {
                return Integer.compare(this.before, other.before);
            }
            return Integer.compare(this.id, other.id);
        }
    }

    static class Connection {
        int from;
        int to;
        int latency;

        Connection(int from, int to) {
            this.from = from;
            this.to = to;
            this.latency = Integer.MAX_VALUE;
        }

        int getOtherComputer(int from) {
            return (this.from == from) ? this.to : this.from;
        }
    }

    private static class Kattio extends PrintWriter {
        private BufferedReader reader;
        private StringTokenizer tokenizer;
        private String token;

        public Kattio(InputStream input) {
            super(new BufferedOutputStream(System.out));
            reader = new BufferedReader(new InputStreamReader(input));
        }

        public Kattio(InputStream input, OutputStream output) {
            super(new BufferedOutputStream(output));
            reader = new BufferedReader(new InputStreamReader(input));
        }

        public boolean hasMoreTokens() {
            return peekToken() != null;
        }

        public int getInt() {
            return Integer.parseInt(nextToken());
        }

        public double getDouble() {
            return Double.parseDouble(nextToken());
        }

        public long getLong() {
            return Long.parseLong(nextToken());
        }

        public String getWord() {
            return nextToken();
        }

        private String peekToken() {
            if (token == null) {
                try {
                    while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                        String line = reader.readLine();
                        if (line == null) {
                            return null;
                        }
                        tokenizer = new StringTokenizer(line);
                    }
                    token = tokenizer.nextToken();
                } catch (IOException e) {
                    // Handle the exception
                }
            }
            return token;
        }

        private String nextToken() {
            String result = peekToken();
            token = null;
            return result;
        }
    }
}