import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Vestigium solver = new Vestigium();
        int testCount = Integer.parseInt(in.readLine());
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in);
        }

    }

    static class Vestigium {

        public void solve(int k, BufferedReader in) throws IOException {
            int N = Integer.parseInt(in.readLine());
            int sum  = 0;
            int rc  = 0;
            int cc  = 0;
            HashMap<Integer, Helper> map = new HashMap(N);
            Set<String> set = new HashSet<>(N);

            for (int i = 0; i < N; i++) {
                String l = in.readLine();
                String[] line = l.split(" ");
                sum += Integer.parseInt(line[i]);
                boolean f = false;
                for (int j = 0; j < N; j++) {

                    // row
                    if (!set.contains(line[j])){
                        set.add(line[j]);
                    } else {
                        if (!f)
                        f = true;
                    }

                    //col
                    Helper h = map.get(j);
                    if (h == null) {
                        final String b = line[j];
                        map.put(j, new Helper(new HashSet<String>(){{add(b);}}));
                    } else {
                        if (h.isAlive) {
                            if (!h.items.add(line[j])) {
                                h.isAlive = false;
                                cc++;
                            }
                        }
                    }
                }

                // check if we have to add row
                if (f) {
                    rc++;
                }
                set.clear();

            }
            //Case #1: 4 0 0
            System.out.println("Case #" + k + ": " + sum + " " + rc + " " + cc);
        }
    }

}

class Helper {
    public Helper(Set<String> s) {
        items = s;
    }
    boolean isAlive = true;
    Set<String> items = new HashSet<>();
}
