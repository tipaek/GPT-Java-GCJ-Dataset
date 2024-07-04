import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            List<Set<Integer>> r = new ArrayList();
            List<Set<Integer>> c = new ArrayList();
            for (int i=0; i<N; i++) {
                r.add(new HashSet());
                c.add(new HashSet());
            }

            int s = 0;
            for (int i = 0; i < N; i++) {
                int j = 0;
                for (String x: br.readLine().split(" ")) {
                    int v = Integer.parseInt(x);
                    if (i == j)
                        s += v;
                    r.get(i).add(v);
                    c.get(j).add(v);
                    j++;
                }
            }

            int cr = 0, cc = 0;
            for (Set x: r) {
                cr += x.size() < N? 1: 0;
            }
            for (Set x: c) {
                cc += x.size() < N? 1: 0;
            }

            System.out.println("Case #" + (-~t) + ": " + s + " " + cr + " " + cc);
        }

        br.close();
    }
}