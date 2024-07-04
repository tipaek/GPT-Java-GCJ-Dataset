import java.util.*;
import java.io.*;

public class Solution {
    static Map<Integer, Pair> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int tci = 0; tci < tc; tci++) {
            int n = Integer.parseInt(br.readLine());
            map = new TreeMap<>();
            StringTokenizer st;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                map.put(i, new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            boolean[] boolC = new boolean[24 * 60];
            boolean[] boolJ = new boolean[24 * 60];
            char[] solution = new char[n];
            boolean impossible = false;

            List<Pair> list = new ArrayList<>(map.values());
            Collections.sort(list);

            for (Pair p : list) {
                int x = p.x;
                int y = p.y;
                boolean CIsFull = false, JIsFull = false;

                for (int i = x; i < y; i++) {
                    if (boolC[i]) {
                        CIsFull = true;
                        break;
                    }
                }
                if (!CIsFull) {
                    Arrays.fill(boolC, x, y, true);
                    solution[find(p)] = 'C';
                    continue;
                }

                for (int i = x; i < y; i++) {
                    if (boolJ[i]) {
                        JIsFull = true;
                        break;
                    }
                }
                if (!JIsFull) {
                    Arrays.fill(boolJ, x, y, true);
                    solution[find(p)] = 'J';
                    continue;
                }

                impossible = true;
                break;
            }

            if (impossible) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", tci + 1);
            } else {
                System.out.printf("Case #%d: %s\n", tci + 1, new String(solution));
            }
        }
        br.close();
    }

    public static int find(Pair p) {
        for (Map.Entry<Integer, Pair> entry : map.entrySet()) {
            if (entry.getValue().equals(p)) {
                int i = entry.getKey();
                map.remove(i);
                return i;
            }
        }
        return -1;
    }
}

class Pair implements Comparable<Pair> {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pair pair = (Pair) obj;
        return x == pair.x && y == pair.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    @Override
    public int compareTo(Pair p) {
        if (this.x == p.x) {
            return this.y - p.y;
        }
        return this.x - p.x;
    }
}