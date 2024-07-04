import java.util.*;
import java.io.*;

class SolutionGCJ {
    private PrintWriter out;

    public void solve(FastReader in, PrintWriter out) {
        this.out = out;
        int testCases = in.nextInt();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int N = in.nextInt();
            int trace = in.nextInt();
            if (trace > N * N || trace < N || trace == N + 1 || trace == N * N - 1) {
                out.println(String.format("Case #%d: IMPOSSIBLE", testCase + 1));
                continue;
            }

            int M = trace / N;
            if (M * N == trace) {
                generateSquare(M, N, testCase, generateStandardOrder(N, M), false);
                continue;
            }

            if (trace > ((N + 1) / 2) * N) {
                M++;
            }

            if (M * N - 1 == trace) {
                M++;
            }

            if (M * N + 1 == trace) {
                M--;
            }

            if (M > (N + 1) / 2) {
                generateSquare(M, N, testCase, generateBigOrder(N, M, trace), true);
            } else {
                generateSquare(M, N, testCase, generateSmallOrder(N, M, trace), true);
            }
        }
    }

    private List<Integer> generateBigOrder(int N, int M, int trace) {
        List<Integer> order = new ArrayList<>();
        int diff = N * M - trace;
        int a = M, b = M, x = 0;
        while (x < diff) {
            if (a != 1) {
                a--;
            } else {
                b--;
            }
            x++;
        }
        order = generateStandardOrder(N, M);
        int i = findIndex(order, a);
        int j = findIndex(order, b);
        swap(order, i, 1);
        swap(order, j, order.size() - 1);
        return order;
    }

    private List<Integer> generateSmallOrder(int N, int M, int trace) {
        List<Integer> order = new ArrayList<>();
        int diff = trace - N * M;
        int a = M, b = M, x = 0;
        while (x < diff) {
            if (a != N) {
                a++;
            } else {
                b++;
            }
            x++;
        }
        order = generateStandardOrder(N, M);
        int i = findIndex(order, a);
        int j = findIndex(order, b);
        swap(order, i, 1);
        swap(order, j, order.size() - 1);
        return order;
    }

    private List<Integer> generateStandardOrder(int N, int M) {
        List<Integer> order = new ArrayList<>();
        order.add(M);
        int i = M % N;
        while (i != (M + N - 1) % N) {
            order.add(i + 1);
            i = (i + 1) % N;
        }
        return order;
    }

    private void generateSquare(int M, int N, int testCase, List<Integer> order, boolean swapRows) {
        Collections.reverse(order);
        List<List<Integer>> square = generateSquareFromList(order);
        for (List<Integer> row : square) {
            Collections.reverse(row);
        }
        if (swapRows) {
            Collections.swap(square, 0, 1);
        }
        out.println(String.format("Case #%d: POSSIBLE", testCase + 1));
        for (List<Integer> row : square) {
            for (int value : row) {
                out.print(value + " ");
            }
            out.println();
        }
        out.println();
    }

    private List<List<Integer>> generateSquareFromList(List<Integer> arr) {
        List<List<Integer>> output = new ArrayList<>();
        int N = arr.size();
        for (int j = 0; j < N; j++) {
            output.add(new ArrayList<>());
        }
        for (int j = 0; j < N; j++) {
            output.get(j).add(arr.get(j));
            int i = (j + 1) % arr.size();
            while (i != j) {
                output.get(j).add(arr.get(i));
                i = (i + 1) % arr.size();
            }
        }
        return output;
    }

    private void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    private int findIndex(List<Integer> list, int value) {
        return list.indexOf(value);
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        SolutionGCJ solution = new SolutionGCJ();
        solution.solve(in, out);
        out.flush();
        out.close();
    }
}

class FastReader {
    private BufferedReader br;
    private StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return str;
    }
}