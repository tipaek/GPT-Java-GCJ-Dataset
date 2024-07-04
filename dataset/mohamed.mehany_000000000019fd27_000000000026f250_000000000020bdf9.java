import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static class Pair implements Comparable<Pair> {
        int end;
        int time;
        int index;
        public Pair(int end, int time, int index) {
            this.end = end;
            this.time = time;
            this.index = index;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.time == o.time) {
                return o.end - this.end;
            }
            return this.time - o.time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; ++t) {
            int n = Integer.parseInt(br.readLine());
            List<Pair> pairs = new ArrayList();
            for (int i = 0; i < n; ++i) {
                String[] line = br.readLine().split(" ");
                int start = Integer.parseInt(line[0]), end = Integer.parseInt(line[1]);
                Pair startPair = new Pair(0, start, i);
                Pair endPair = new Pair(1, end, i);
                pairs.add(startPair);
                pairs.add(endPair);
            }
            Collections.sort(pairs);
            Map<Integer, Character> sol = new HashMap();
            char[] solution = new char[n];
            for (Pair p : pairs) {

                if (sol.keySet().size() > 2) {
                    solution = "IMPOSSIBLE".toCharArray();
                    break;
                }
                if (p.end == 0) {
                    char player = 'C';
                    if (sol.keySet().size() > 0){
                        player = (solution[sol.keySet().iterator().next()] == 'C')? 'J' : 'C';
                    }
                    sol.put(p.index, player);
                    solution[p.index] = player;
                }
                else {
                    sol.remove(p.index);
                }

            }

            System.out.println("Case #" + (t + 1) + ": " + String.valueOf(solution));
        }
    }
}
