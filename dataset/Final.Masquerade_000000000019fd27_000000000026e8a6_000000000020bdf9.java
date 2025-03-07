import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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

            for (int i = 0; i < N; i++) {
                if (impossible) break;
                Pair p = new Pair(in.readLine().split(" "));

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
                    res.append("J");
                } else {
                    C.add(p);
                    res.append("C");
                }

                cBusy = false;
            }

            if (!impossible) System.out.println("Case #" + k + ": " + res);
        }
    }
}

class Pair {
    int b;
    int e;

    public Pair(String[] arr) {
        b = Integer.parseInt(arr[0]);
        e = Integer.parseInt(arr[1]);
    }

    boolean isBusy(Pair p) {
        return !((e <= p.b && b <= p.b) || (b >= p.e && e >= p.e));
    }
}
