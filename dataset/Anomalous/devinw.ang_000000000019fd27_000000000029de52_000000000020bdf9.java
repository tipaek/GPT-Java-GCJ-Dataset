import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int num = sc.nextInt();
            int[][] matrix = new int[num][2];
            for (int k = 0; k < num; k++) {
                for (int j = 0; j < 2; j++) {
                    matrix[k][j] = sc.nextInt();
                }
            }
            out.println("Case #" + i + ": " + solve(matrix, num));
        }
        out.close();
    }

    public static String solve(int[][] mat, int n) {
        ArrayList<Integer> cmin = new ArrayList<>();
        ArrayList<Integer> cmax = new ArrayList<>();
        ArrayList<Integer> jmin = new ArrayList<>();
        ArrayList<Integer> jmax = new ArrayList<>();
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (cmin.isEmpty()) {
                cmin.add(mat[0][0]);
                cmax.add(mat[0][1]);
                str.append("C");
            } else if (works(mat[i], cmin, cmax)) {
                str.append("C");
                cmin.add(mat[i][0]);
                cmax.add(mat[i][1]);
            } else if (jmin.isEmpty()) {
                str.append("J");
                jmin.add(mat[i][0]);
                jmax.add(mat[i][1]);
            } else if (works(mat[i], jmin, jmax)) {
                str.append("J");
                jmin.add(mat[i][0]);
                jmax.add(mat[i][1]);
            } else {
                return "IMPOSSIBLE";
            }
        }
        return str.toString();
    }

    public static boolean works(int[] arr, ArrayList<Integer> min, ArrayList<Integer> max) {
        for (int i = 0; i < min.size(); i++) {
            if ((arr[0] > min.get(i) && arr[0] < max.get(i)) || arr[0] == min.get(i)) {
                return false;
            }
            if ((arr[1] > min.get(i) && arr[1] < max.get(i)) || arr[1] == max.get(i)) {
                return false;
            }
            if (arr[0] > min.get(i) && arr[1] < max.get(i)) {
                return false;
            }
            if (arr[0] < min.get(i) && arr[1] > max.get(i)) {
                return false;
            }
        }
        return true;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
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