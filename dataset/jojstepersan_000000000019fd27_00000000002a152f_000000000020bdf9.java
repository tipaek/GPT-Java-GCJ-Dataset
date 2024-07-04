
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Jojstepersan
 */
public class Solution {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int t = Integer.valueOf(in.readLine().trim());
        for (int i = 0; i < t; i++) {
            int n = Integer.valueOf(in.readLine().trim());
            List<Hora> acts = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(in.readLine().trim());
                acts.add(new Hora(Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken())));
            }
            Collections.sort(acts);
            boolean CO = false;
            boolean JO = false;
            Hora hc = null, hj = null;
            boolean imp = false;
            CO = true;
            hc = acts.get(0);
            hc.r = "C";
            for (int j = 1; j < acts.size(); j++) {
                Hora h = acts.get(j);
                if (hc != null && hc.end <= h.init) {
                    CO = false;
                    hc = null;
                }
                if (hj != null && hj.end <= h.init) {
                    JO = false;
                    hj = null;
                }
                if (!CO) {
                    CO = true;
                    hc = h;
                    hc.r = "C";
                } else if (!JO) {
                    JO = true;
                    hj = h;
                    hj.r = "J";
                } else {
                    imp = true;
                    break;

                }
            }
            if (imp) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", i + 1);
            } else {
                Collections.sort(acts, (Hora t1, Hora t2) -> t1.order - t2.order);
                System.out.printf("Case #%d: ",i+1);
                acts.forEach((act) -> {
                    System.out.print(act.r);
                });
                System.out.println("");

            }

        }
    }
}

class Hora implements Comparable<Hora> {

    int init;
    int end;
    int order;
    static int nOrder = 1;
    String r;//responsable

    public Hora(int init, int end) {
        this.init = init;
        this.end = end;
        order = nOrder++;
    }

    @Override
    public int compareTo(Hora t) {
        return this.init - t.init;
    }

    @Override
    public String toString() {
        return "Hora{" + "init=" + init + ", end=" + end + '}' + "r: " + r;
    }

}