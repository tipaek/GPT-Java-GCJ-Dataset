import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Vestigium {
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

    public static void main(String[] args) {
        FastReader kb = new FastReader();
        int t1 = kb.nextInt();
        int t = 0;
        while (t++ < t1) {
            int n = kb.nextInt();
            int trace = 0, rowRepeats = 0, colRepeats = 0;
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                ArrayList<Integer> rowList = new ArrayList<>(n);
                boolean rowHasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    int value = kb.nextInt();
                    matrix[i][j] = value;
                    if (rowList.contains(value) && !rowHasDuplicate) {
                        rowRepeats++;
                        rowHasDuplicate = true;
                    }
                    rowList.add(value);
                }
                trace += matrix[i][i];
            }

            for (int i = 0; i < n; i++) {
                ArrayList<Integer> colList = new ArrayList<>(n);
                boolean colHasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    int value = matrix[j][i];
                    if (colList.contains(value) && !colHasDuplicate) {
                        colRepeats++;
                        colHasDuplicate = true;
                    }
                    colList.add(value);
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}