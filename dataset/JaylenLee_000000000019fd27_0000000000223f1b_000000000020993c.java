import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {

    public static void main(String[] args) {
        FastIO sc = new FastIO();
        printOutput(sc);
        sc.close();
    }

    public static void printOutput(FastIO sc) {
        int numTest = sc.nextInt();

        for(int i = 1; i <= numTest; i++) {
            int[][] mtx = getMatrix(sc);
            int k = getTrace(mtx);
            int r = getRow(mtx);
            int c = getCol(mtx);
            sc.println("Case #" + i +": " + k + " " + r + " " + c);
        }
    }

    public static int[][] getMatrix(FastIO sc) {
        int row = sc.nextInt();
        int[][] mtx = new int[row][row];
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < row; j++) {
                mtx[i][j] = sc.nextInt();
                
            }
        }
        return mtx;
    }

    public static int getTrace(int[][] mtx) {
        int size = mtx.length - 1;
        int sum = 0;
        while (size >= 0) {
            sum += mtx[size][size];
            size--;
        }

        return sum;
    }

    public static int getRow(int[][] mtx) {
        int size = mtx.length;
        int count = 0;
        boolean[] row = new boolean[size + 1];

        for(int i = 0; i < size; i++) {

            for(int j = 0; j < size; j++) {
                if(row[mtx[i][j]]) {
                    count++;
                    break;
                }
                row[mtx[i][j]] = true;
            }

            Arrays.fill(row, false);
        }

        return count;
    }

    public static int getCol(int[][] mtx) {
        int size = mtx.length;
        int count = 0;
        boolean[] col = new boolean[size + 1];

        for(int i = 0; i < size; i++) {

            for(int j = 0; j < size; j++) {
                if(col[mtx[j][i]]) {
                    count++;
                    break;
                }
                col[mtx[j][i]] = true;
            }

            Arrays.fill(col, false);
        }

        return count;
    }
}

class FastIO extends PrintWriter {

    BufferedReader br;

    StringTokenizer st;


    public FastIO() {

        super(new BufferedOutputStream(System.out));

        br = new BufferedReader(new

                InputStreamReader(System.in));

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