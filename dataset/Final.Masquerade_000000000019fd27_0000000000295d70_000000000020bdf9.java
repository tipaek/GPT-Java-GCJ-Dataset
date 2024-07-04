import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(in.readLine());
        Solver s = new Solver();
        for (int i = 1; i <= testCount; i++) {
            s.solve(i, in);
        }
    }

    static class Solver {

        public void solve(int k, BufferedReader in) throws IOException {
            StringBuilder res = new StringBuilder();
            ArrayList<Pair> C = new ArrayList();
            ArrayList<Pair> J = new ArrayList();
            int N = Integer.parseInt(in.readLine());
            boolean cBusy = false;
            boolean impossible = false;

            ArrayList<Pair> pairs = new ArrayList();
            ArrayList<Pair> originalPairs = new ArrayList();
            for (int i = 0; i < N; i++) {
                Pair buf = new Pair(in.readLine().split(" "));
                pairs.add(buf);
                originalPairs.add(buf);
            }
            pairs.sort(Comparator.comparingInt(p -> p.b));

            for (int i = 0; i < N; i++) {
                Pair p = pairs.get(i);
                if (!impossible) {

                    for (Pair pair : C) {
                        if (pair.isBusy(p)) {
                            cBusy = true;
                            break;
                        }
                    }


                    if (cBusy) {
                        for (Pair pair : J) {
                            if (pair.isBusy(p)) {
                                // IMPOSSIBLE
                                System.out.println("Case #" + k + ": " + "IMPOSSIBLE");
                                impossible = true;
                                break;
                            }
                        }
                        J.add(p);
                        for (Pair originalPair : originalPairs) {
                            if (originalPair.b == p.b && originalPair.e == p.e) {
                                originalPair.letter = "J";
                            }
                        }
                        //res.append("J");
                    } else {
                        C.add(p);
                        for (Pair originalPair : originalPairs) {
                            if (originalPair.b == p.b && originalPair.e == p.e) {
                                originalPair.letter = "C";
                            }
                        }
                        //res.append("C");
                    }

                    cBusy = false;
                }

            }

            for (Pair p: originalPairs) {
                res.append(p.letter);
            }

            if (!impossible) System.out.println("Case #" + k + ": " + res);
        }
    }
}

class Pair {
    int b;
    int e;
    String letter = "X";

    public Pair(String[] arr) {
        b = Integer.parseInt(arr[0]);
        e = Integer.parseInt(arr[1]);
    }

    boolean isBusy(Pair p) {
        return !((e <= p.b) || (b >= p.e));
    }
}

