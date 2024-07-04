import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
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

    int N;
    int[][] pascal;

    void arrayPush(int limit) {
        if (limit == 1) {
            pascal = new int[1][1];
            pascal[0][0] = 1;
        } else {
            int[][] tempArray = pascal;
            pascal = new int[limit][limit];
            for (int i = 0; i < limit - 1; i++) {
                System.arraycopy(tempArray[i], 0, pascal[i], 0, limit - 1);
            }
            for (int j = 0; j < limit; j++) {
                pascal[limit - 1][j] = (j == 0) ? 1 : pascal[limit - 2][j] + pascal[limit - 2][j - 1];
            }
        }
    }

    void printPascal() {
        for (int[] row : pascal) {
            System.out.println();
            for (int value : row) {
                System.out.print(value);
            }
        }
    }

    void getResult() {
        int i = 1, sum = 0;
        boolean cal = true;

        while (cal) {
            arrayPush(i);
            if (i == 1) {
                sum += 1;
                System.out.println(i + " " + i);
            } else {
                int j = (i / 2) + (i % 2) - (i % 2);
                boolean innerCal = true;
                while (innerCal) {
                    sum += pascal[i - 1][j];
                    System.out.println(i + " " + (j + 1));
                    if (j != 0 && sum < N) {
                        if (pascal[i - 1][j - 1] < pascal[i - 1][j]) {
                            j--;
                        } else if (j > 1 && pascal[i - 1][j - 1] == pascal[i - 1][j]) {
                            j -= 2;
                        } else {
                            innerCal = false;
                        }
                    } else {
                        innerCal = false;
                    }
                }
            }
            i++;
            if (i > 500 || sum >= N) {
                cal = false;
            }
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            Solution obj = new Solution();
            obj.N = sc.nextInt();
            obj.pascal = new int[0][0];

            System.out.println("Case #" + t + ":");
            obj.getResult();
            System.out.println();
        }
        System.exit(0);
    }
}