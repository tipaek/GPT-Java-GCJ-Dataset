import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            int trace = calculateTrace(matrix, n);
            int rowDuplicates = countRowDuplicates(matrix, n);
            int colDuplicates = countColumnDuplicates(matrix, n);

            out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
            caseNumber++;
        }

        out.flush();
        out.close();
    }

    private static int calculateTrace(int[][] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowDuplicates(int[][] matrix, int n) {
        int rowDuplicates = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < n; j++) {
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() != n) {
                rowDuplicates++;
            }
        }
        return rowDuplicates;
    }

    private static int countColumnDuplicates(int[][] matrix, int n) {
        int colDuplicates = 0;
        for (int j = 0; j < n; j++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int i = 0; i < n; i++) {
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() != n) {
                colDuplicates++;
            }
        }
        return colDuplicates;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Pair1 implements Comparable<Pair1> {
    int x;
    int y;

    public Pair1(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair1 o) {
        return o.y - this.y;
    }
}

class Pair2 implements Comparable<Pair2> {
    int x;
    int y;

    public Pair2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair2 o) {
        return this.y - o.y;
    }
}