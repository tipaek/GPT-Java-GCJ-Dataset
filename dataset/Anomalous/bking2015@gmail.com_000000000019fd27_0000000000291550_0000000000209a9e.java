import java.util.*;
import java.io.*;

class SolutionGCJ {
    private PrintWriter out;
    private FastReader in;
    private int queryCount = 0;

    public void solve(FastReader in, PrintWriter out) {
        this.out = out;
        this.in = in;
        int testCases = in.nextInt();
        int B = in.nextInt();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int[] A = new int[B];
            int sameIndex = -1;
            int diffIndex = -1;
            int i = 0;

            if (B == 1) {
                out.println(q(0));
                out.flush();
                continue;
            }

            while (queryCount <= 148) {
                int x = q(i);
                int y = q(B - 1 - i);

                if (i != B - 1 - i) {
                    if (x != y && diffIndex == -1) {
                        diffIndex = i;
                    } else if (x == y && sameIndex == -1) {
                        sameIndex = i;
                    }
                }

                A[i] = x;
                A[B - 1 - i] = y;
                i++;

                if (i > (B - 1) / 2) {
                    if (queryCount % 10 != 1) {
                        break;
                    } else {
                        i--;
                    }
                }

                if (queryCount % 10 == 0) {
                    q(0);
                }

                if (queryCount % 10 == 1) {
                    boolean sameSame = sameIndex != -1 && A[sameIndex] == q(sameIndex);
                    boolean diffSame = diffIndex != -1 && A[diffIndex] == q(diffIndex);

                    if (!sameSame && !diffSame) {
                        complement(A);
                    } else if (!sameSame) {
                        complement(A);
                        reverse(A);
                    } else if (!diffSame) {
                        reverse(A);
                    }
                }
            }

            for (int value : A) {
                out.print(value);
            }
            out.println();
            out.flush();
        }
    }

    private void reverse(int[] A) {
        for (int i = 0; i < A.length / 2; i++) {
            int temp = A[i];
            A[i] = A[A.length - 1 - i];
            A[A.length - 1 - i] = temp;
        }
    }

    private void complement(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] == 0 ? 1 : 0;
        }
    }

    private int q(int pos) {
        out.println(pos + 1);
        out.flush();
        queryCount++;
        return in.nextInt();
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        new SolutionGCJ().solve(in, out);
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
        }
        return str;
    }
}