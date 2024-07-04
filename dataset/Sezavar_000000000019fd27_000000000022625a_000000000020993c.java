import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private final static String IMPOSSIBLE = "IMPOSSIBLE";
    private static boolean READ_FROM_FILE = false;
    private static boolean WRITE_TO_FILE = false;
    private static PrintWriter writer = null;

    public final static void main(String[] args) throws IOException {
        Scanner in;
        File inFile = null;
        if (READ_FROM_FILE) {
            inFile = new File(args[0]);
            in = new Scanner(new BufferedReader(new FileReader(args[0])));
        } else {
            in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        }

        if (WRITE_TO_FILE) {
            String fileOut;
            if (inFile == null) {
                fileOut = "out-" + new SimpleDateFormat("YYYYMMdd-HHmmss").format(new Date(System.currentTimeMillis())) + ".out";
            } else {
                fileOut = inFile.getParent() + "/" + inFile.getName().replace(".in", new SimpleDateFormat("YYYYMMdd-HHmmss").format(new Date(System.currentTimeMillis())) + ".out");
            }
            writer = new PrintWriter(new BufferedWriter(new FileWriter(fileOut)));
        }

        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            final Solution solution = new Solution();
            print(i, solution.solve(in));
        }

        if (writer != null) {
            writer.flush();
            writer.close();
        }

    }

    public final static void print(int caseNumber, String result) {
        final String toWrite = "Case #" + caseNumber + ": " + result;
        if (writer != null) {
            writer.println(toWrite);
        } else {
            System.out.println(toWrite);
        }
    }


    /******************************************************************************
     *  Normally you should start coding from here:
     ******************************************************************************/
    public Solution() {
    }

    public String solve(final Scanner in) {
        String res = "";
        int N = in.nextInt();
        int k = 0;
        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int x = in.nextInt();
                A[i][j] = x;
            }
        }
        int r = 0;
        int c = 0;
        for (int i = 0; i < N; i++) {
            Set<Integer> row = new HashSet<>();
            Set<Integer> col = new HashSet<>();
            boolean rf = false;
            boolean cf = false;
            for (int j = 0; j < N; j++) {
                if (i == j) k += A[i][j];
                if (!row.add(A[i][j])) rf = true;
                if (!col.add(A[j][i])) cf = true;
            }
			if(rf) r++;
            if(cf) c++;

        }
        res =  k+" "+r+" "+c;
        return res;
    }
}
/******************************************************************************
 *  Put all final helper classes here:
 ******************************************************************************/
