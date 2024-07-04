import java.io.*;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        // File file = new File("/Users/berendjanlange/GitDrive/Hashcode/CodeJamQualification/src/scratch.txt");
        // Scanner in = new Scanner(new BufferedReader(new FileReader(file)));
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();
        for (int test = 0; test < tests; test++) {
            int N = in.nextInt();
            boolean[][] cols = new boolean[N][N];
            boolean[][] rows = new boolean[N][N];
            boolean[] cols2 = new boolean[N];
            boolean[] rows2 = new boolean[N];
            int k = 0, r = 0, c = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int no = in.nextInt();
                    if (i == j) {
                        k += no;
                    }
                    if (rows[i][no - 1]) {
                        if (!rows2[i]) {
                            rows2[i] = true;
                            r++;
                        }
                    } else {
                        rows[i][no - 1] = true;
                    }
                    if (cols[j][no - 1]) {
                        if (!cols2[j]) {
                            cols2[j] = true;
                            c++;
                        }
                    } else {
                        cols[j][no - 1] = true;
                    }
                }
            }
            int Case = test + 1;
            System.out.println("Case #" + Case + ": " + k + " " + r + " " + c);
        }
    }
}

//Output
//Case #1: 4 0 0
//Case #2: 9 4 4
//Case #3: 8 0 2