package round1c.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

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
            String[] inp = in.readLine().split(" ");
            int N =  Integer.parseInt(inp[0]);
            int D =  Integer.parseInt(inp[1]);
            inp = in.readLine().split(" ");
            int[] deg = new int[N];
            HashMap<Integer, Integer> h = new HashMap<>();

            int res = 0;
            for (int i = 0; i < N; i++) {
                deg[i] = Integer.parseInt(inp[i]);
                
                if (h.containsKey(deg[i])) {
                    h.put(deg[i], h.get(deg[i])+ 1);
                }else{
                    h.put(deg[i], 1);

                }
            }

            for (Map.Entry<Integer, Integer> e : h.entrySet()) {
               if (D == e.getValue()) {
                   System.out.println("Case #" + k + ": " + 0);
               }
            }

            for (Map.Entry<Integer, Integer> e : h.entrySet()) {
      
                
                int x = e.getValue();
                for (Map.Entry<Integer, Integer> ev : h.entrySet()) {
                    if (ev.getValue() != e.getValue() && e.getValue() % ev.getValue() == 0){
                        x++;
                    }
                }
                
                h.put(e.getKey(), x);
            }

            for (Map.Entry<Integer, Integer> ev : h.entrySet()) {
               int m = 0;
               if (ev.getValue() > m) m = ev.getValue();
               if (m > D) {
                   res = D - m;
                   System.out.println("Case #" + k + ": " + res);
                   break;
               }
            }
            
        }
    }
}


/*




 */