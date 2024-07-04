import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {
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
        FastReader input = new FastReader();
        int T = input.nextInt();
        for (int t = 0; t < T; t++) {
            int n = input.nextInt();
            ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                ArrayList<Integer> row = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    row.add(input.nextInt());
                }
                matrix.add(row);
            }

            int trace = 0;
            int repeatedRows = 0;
            int repeatedCols = 0;

            for (int i = 0; i < n; i++) {
                trace += matrix.get(i).get(i);
            }

            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    int value = matrix.get(i).get(j);
                    if (!rowSet.add(value) && !rowHasDuplicate) {
                        repeatedRows++;
                        rowHasDuplicate = true;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                HashSet<Integer> colSet = new HashSet<>();
                boolean colHasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    int value = matrix.get(j).get(i);
                    if (!colSet.add(value) && !colHasDuplicate) {
                        repeatedCols++;
                        colHasDuplicate = true;
                    }
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + trace + " " + repeatedRows + " " + repeatedCols);
        }
    }
}