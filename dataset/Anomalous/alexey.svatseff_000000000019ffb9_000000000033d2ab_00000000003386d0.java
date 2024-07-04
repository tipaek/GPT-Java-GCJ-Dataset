import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Solution {
    private static boolean DEBUG = false;

    // Solution //////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static void readCaseInput(int caseNumber, Scanner in) throws Exception {
        N = in.nextInt();
        holes = new int[N][2];
        for (int i = 0; i < N; ++i) {
            holes[i][0] = in.nextInt();
            holes[i][1] = in.nextInt();
        }
    }

    static int T;
    static int N;
    static int[][] holes;

    private static void solveCase(int caseNumber, PrintStream out) throws Exception {
        Map<List<Integer>, Set<Integer>> connectedByVector = new HashMap<>();
        for (int i = 0; i < N; ++i) {
            for (int j = i + 1; j < N; ++j) {
                int vx, vy;
                if (holes[i][0] < holes[j][0] || (holes[i][0] == holes[j][0] && holes[i][1] < holes[j][1])) {
                    // Vector is from i to j
                    vx = holes[j][0] - holes[i][0];
                    vy = holes[j][1] - holes[i][1];
                } else {
                    // Vector is from j to i
                    vx = holes[i][0] - holes[j][0];
                    vy = holes[i][1] - holes[j][1];
                }

                int gcd = gcd(Math.max(Math.abs(vx), Math.abs(vy)), Math.min(Math.abs(vx), Math.abs(vy)));
                vx /= gcd;
                vy /= gcd;

                List<Integer> vector = Arrays.asList(vx, vy);
                Set<Integer> connected = connectedByVector.computeIfAbsent(vector, key -> new HashSet<>());
                connected.add(i);
                connected.add(j);
            }
        }
        int maxConnected = connectedByVector.values().stream().mapToInt(Set::size).max().orElse(0);
        writeCaseResult(out, caseNumber, String.valueOf(Math.min(maxConnected + 2, N)));
    }

    private static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    private static void writeCaseResult(PrintStream out, int caseNumber, String formattedResult) throws IOException {
        out.println("Case #" + caseNumber + ": " + formattedResult);
        out.flush();
    }

    // Helpers ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    static final DecimalFormat DOUBLE_FORMAT = new DecimalFormat("#0.000000");

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);

            try (Scanner in = openInput(args);
                 PrintStream out = openOutput(args)) {

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

    private static Scanner openInput(String[] args) throws FileNotFoundException {
        if (DEBUG) {
            return new Scanner(new BufferedReader(new FileReader(new File(args[0]))));
        } else {
            return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        }
    }

    private static PrintStream openOutput(String[] args) throws IOException {
        if (DEBUG) {
            String inPathBase = args[0].substring(0, args[0].lastIndexOf('.'));
            return new PrintStream(new BufferedOutputStream(new FileOutputStream(new File(inPathBase + ".out"))));
        } else {
            return System.out;
        }
    }
}