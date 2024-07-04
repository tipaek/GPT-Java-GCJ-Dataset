public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();
        for (int test = 0; test < tests; test++) {
            int N = in.nextInt();
            boolean[][] cols = new boolean[N][N];
            boolean[][] rows = new boolean[N][N];
            int k = 0, r = 0, c = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int no = in.nextInt();
                    if (i == j) {
                        k += no;
                    }
                    if (rows[i][no]) {
                        r++;
                    } else {
                        rows[i][no] = true;
                    }
                    if (cols[j][no]) {
                        c++;
                    } else {
                        rows[j][no] = true;
                    }
                }
            }
            int Case = test + 1;
            System.out.println("Case #" + Case + ": " + k + " " + r + " " + c);
        }
    }
}