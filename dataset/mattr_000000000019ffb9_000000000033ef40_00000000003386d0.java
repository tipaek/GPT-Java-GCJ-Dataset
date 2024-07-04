import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.util.function.DoubleToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    static class Node {
        List<Node> neighbours = new ArrayList<>();
        int name;
        int latency;
        boolean reached = false;

        Node(int name) {
            this.name = name;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        solve(in);
    }

    public static void solve(Scanner sc) throws Exception {
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= t; ++i) {
            doCase(sc, i);
        }
    }

    private static void doCase(Scanner sc, int caseNumber) throws Exception {
        int n = Integer.parseInt(sc.nextLine());
        int[][] holes = new int[n][2];
        List<String>[] angles = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            angles[i] = new ArrayList<>();
            String[] coordStr = sc.nextLine().split(" ");
            int[] coord = new int[2];

            coord[0] = Integer.parseInt(coordStr[0]);
            coord[1] = Integer.parseInt(coordStr[1]);

            holes[i] = coord;
        }

        if (n == 1) {
            printRes(caseNumber,"1");
            return;
        }

        if (n ==  2) {
            printRes(caseNumber,"2");
            return;
        }

        if (n ==  3) {
            printRes(caseNumber,"3");
            return;
        }

        if (n == 4) {
            printRes(caseNumber,"4");
            return;
        }

        HashMap<int[], String> pairAngle = new HashMap<>();

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                String slope = angle(holes[i], holes[j]);

                int[] pair = new int[2];
                pair[0] = i;
                pair[1] = j;

                int[] counterPair = new int[2];
                counterPair[0] = j;
                counterPair[1] = i;

                pairAngle.put(pair, slope);
            }
        }

        if (n == 5 || n == 6) {
            for (Map.Entry<int[], String> pair1 : pairAngle.entrySet()) {
                for (Map.Entry<int[], String> pair2 : pairAngle.entrySet()) {
                    if (!pair1.equals(pair2) && pair1.getValue().equals(pair2.getValue())) {
                        int[] p1 = pair1.getKey();
                        int[] p2 = pair2.getKey();

                        Set<Integer> set = new HashSet<>();
                        set.add(p1[0]);
                        set.add(p1[1]);
                        set.add(p2[0]);
                        set.add(p2[1]);

                        if (set.size() == 4) {
                            printRes(caseNumber,Integer.toString(n));
                            return;
                        }
                    }
                }
            }

            printRes(caseNumber,"4");
            return;
        }

        for (Map.Entry<int[], String> pair1 : pairAngle.entrySet()) {
            for (Map.Entry<int[], String> pair2 : pairAngle.entrySet()) {
                for (Map.Entry<int[], String> pair3 : pairAngle.entrySet()) {
                    if (!pair1.equals(pair2) && pair1.getValue().equals(pair2.getValue())) {
                        int[] p1 = pair1.getKey();
                        int[] p2 = pair2.getKey();
                        int[] p3 = pair3.getKey();

                        Set<int[]> set = new HashSet<>();
                        set.add(p1);
                        set.add(p2);
                        set.add(p3);

                        if (set.size() >= 3) {
                            printRes(caseNumber, "7");
                            return;
                        }
                    }
                }
            }
        }

        for (Map.Entry<int[], String> pair1 : pairAngle.entrySet()) {
            for (Map.Entry<int[], String> pair2 : pairAngle.entrySet()) {
                if (!pair1.equals(pair2) && pair1.getValue().equals(pair2.getValue())) {
                    int[] p1 = pair1.getKey();
                    int[] p2 = pair2.getKey();

                    Set<Integer> set = new HashSet<>();
                    set.add(p1[0]);
                    set.add(p1[1]);
                    set.add(p2[0]);
                    set.add(p2[1]);

                    if (set.size() == 4) {
                        printRes(caseNumber,"6");
                        return;
                    }
                }
            }
        }

        printRes(caseNumber,"4");
        return;
    }

    private static String angle(int[] x, int[] y) {
        if (x[1] == y[1]) return "inf";
        return Double.toString(((double) (x[0] - y[0])) / ((double)(x[1] - y[1])));
    }

    private static void printRes(int caseNumber, String res) {
        System.out.println("Case #" + Integer.toString(caseNumber) + ": " + res);
    }
}
