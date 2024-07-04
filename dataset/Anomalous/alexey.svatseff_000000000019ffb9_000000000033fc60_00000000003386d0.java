import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    private static final boolean DEBUG = false;
    private static int T;
    private static int N;
    private static int[][] holes;

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
            try (Scanner in = openInput(args);
                 PrintStream out = openOutput(args)) {
                T = in.nextInt();
                for (int caseNumber = 1; caseNumber <= T; caseNumber++) {
                    readCaseInput(in);
                    solveCase(caseNumber, out);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readCaseInput(Scanner in) {
        N = in.nextInt();
        holes = new int[N][2];
        for (int i = 0; i < N; i++) {
            holes[i][0] = in.nextInt();
            holes[i][1] = in.nextInt();
        }
    }

    private static void solveCase(int caseNumber, PrintStream out) {
        Map<List<Integer>, Set<Set<Integer>>> connectedByVector = new HashMap<>();
        for (int i = 0; i < N; i++) {
            Map<List<Integer>, Set<Integer>> connectedLocallyByVector = new HashMap<>();
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                int[] vector = calculateVector(i, j);
                List<Integer> vectorList = Arrays.asList(vector[0], vector[1]);
                connectedLocallyByVector.computeIfAbsent(vectorList, k -> new HashSet<>()).add(i);
                connectedLocallyByVector.get(vectorList).add(j);
            }
            for (Map.Entry<List<Integer>, Set<Integer>> entry : connectedLocallyByVector.entrySet()) {
                connectedByVector.computeIfAbsent(entry.getKey(), k -> new HashSet<>()).add(entry.getValue());
            }
        }
        int maxConnected = connectedByVector.values().stream().mapToInt(Solution::calculateMaxConnection).max().orElse(0);
        writeCaseResult(out, caseNumber, String.valueOf(Math.min(maxConnected + 2, N)));
    }

    private static int[] calculateVector(int i, int j) {
        int vx, vy;
        if (holes[i][0] < holes[j][0] || (holes[i][0] == holes[j][0] && holes[i][1] < holes[j][1])) {
            vx = holes[j][0] - holes[i][0];
            vy = holes[j][1] - holes[i][1];
        } else {
            vx = holes[i][0] - holes[j][0];
            vy = holes[i][1] - holes[j][1];
        }
        int gcd = gcd(Math.abs(vx), Math.abs(vy));
        return new int[]{vx / gcd, vy / gcd};
    }

    private static int calculateMaxConnection(Set<Set<Integer>> sets) {
        List<Integer> sizes = sets.stream().map(Set::size).collect(Collectors.toList());
        boolean isOddPair = false;
        int count = 0;
        for (Integer size : sizes) {
            if (size % 2 == 0) {
                count += size;
            } else {
                if (isOddPair) {
                    isOddPair = false;
                    count += size + 1;
                } else {
                    count += size - 1;
                    isOddPair = true;
                }
            }
        }
        return count;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static void writeCaseResult(PrintStream out, int caseNumber, String result) {
        out.println("Case #" + caseNumber + ": " + result);
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
            String inPathName = args[0];
            String outPathName = inPathName.substring(0, inPathName.lastIndexOf('.')) + ".out";
            return new PrintStream(new BufferedOutputStream(new FileOutputStream(new File(outPathName))));
        } else {
            return System.out;
        }
    }
}