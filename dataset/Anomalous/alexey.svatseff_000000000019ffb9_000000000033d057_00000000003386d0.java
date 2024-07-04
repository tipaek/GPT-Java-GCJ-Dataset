import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Solution {

    private static final boolean DEBUG = false;
    private static int T;
    private static int N;
    private static int[][] holes;

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
            try (Scanner in = openInput(args); PrintStream out = openOutput(args)) {
                T = in.nextInt();
                for (int caseNumber = 1; caseNumber <= T; caseNumber++) {
                    readCaseInput(caseNumber, in);
                    solveCase(caseNumber, out);
                    out.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readCaseInput(int caseNumber, Scanner in) {
        N = in.nextInt();
        holes = new int[N][2];
        for (int i = 0; i < N; ++i) {
            holes[i][0] = in.nextInt();
            holes[i][1] = in.nextInt();
        }
    }

    private static void solveCase(int caseNumber, PrintStream out) {
        Map<List<Integer>, Set<Integer>> connectedByVector = new HashMap<>();
        for (int i = 0; i < N; ++i) {
            for (int j = i + 1; j < N; ++j) {
                int vx, vy;
                if (holes[i][0] < holes[j][0] || (holes[i][0] == holes[j][0] && holes[i][1] < holes[j][1])) {
                    vx = holes[j][0] - holes[i][0];
                    vy = holes[j][1] - holes[i][1];
                } else {
                    vx = holes[i][0] - holes[j][0];
                    vy = holes[i][1] - holes[j][1];
                }

                int gcd = gcd(Math.abs(vx), Math.abs(vy));
                vx /= gcd;
                vy /= gcd;

                List<Integer> vector = Arrays.asList(vx, vy);
                connectedByVector.computeIfAbsent(vector, k -> new HashSet<>()).add(i);
                connectedByVector.computeIfAbsent(vector, k -> new HashSet<>()).add(j);
            }
        }

        int maxConnected = connectedByVector.values().stream().mapToInt(Set::size).max().orElse(0);
        writeCaseResult(out, caseNumber, String.valueOf(Math.min(maxConnected + 2, N)));
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static void writeCaseResult(PrintStream out, int caseNumber, String formattedResult) {
        out.println("Case #" + caseNumber + ": " + formattedResult);
    }

    private static Scanner openInput(String[] args) throws FileNotFoundException {
        if (DEBUG) {
            File inFile = new File(args[0]);
            return new Scanner(new BufferedReader(new FileReader(inFile)));
        } else {
            return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        }
    }

    private static PrintStream openOutput(String[] args) throws IOException {
        if (DEBUG) {
            String inPathBase = args[0].substring(0, args[0].lastIndexOf('.'));
            File outFile = new File(inPathBase + ".out");
            return new PrintStream(new BufferedOutputStream(new FileOutputStream(outFile)));
        } else {
            return System.out;
        }
    }
}