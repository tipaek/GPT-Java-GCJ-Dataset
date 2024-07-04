public class Vestigium {
    public static String solve(int[][] data) {
        int trace = 0;
        int N = data.length;
        int r = 0;
        int c = 0;
        for (int i = 0; i < N; i++) {
            int[] rcount = new int[N+1];
            int[] ccount = new int[N+1];
            boolean rrepeat = false;
            boolean crepeat = false;
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    trace += data[i][j];
                }
                if (rcount[data[i][j]] != 0) {
                    rrepeat = true;
                }
                if (ccount[data[j][i]] != 0) {
                    crepeat = true;
                }
                rcount[data[i][j]] = 1;
                ccount[data[j][i]] = 1;
            }
            if (rrepeat) r++;
            if (crepeat) c++;
        }
        return new StringBuilder().append(trace).append(" ").append(r).append(" ").append(c).toString();
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            int N = input.nextInt();
            int[][] data = new int[N][N];
            for (int i = 0; i < N * N; i++) {
                int r = i / N;
                int c = i % N;
                data[r][c] = input.nextInt();
            }
            System.out.println("Case #" + ks + ": " + solve(data));
            System.out.flush();
        }
    }
}