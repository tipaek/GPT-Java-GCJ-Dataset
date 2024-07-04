import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scn = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scn.nextInt();
        int no = 1;
        while (t-- > 0) {
            int n = scn.nextInt();
            PriorityQueue<pair> q = new PriorityQueue<>(new sort());
            HashMap<Integer, Character> map = new HashMap<>();
            for (int i = 0; i < n; ++i) {
                q.add(new pair(scn.nextInt(), scn.nextInt(), i));
                map.put(i, '-');
            }
            int ec = 0;
            int ej = 0;
            StringBuilder sb = new StringBuilder("");
            boolean possible = true;
            while (!q.isEmpty()) {
                pair p = q.poll();
                if (ec <= p.start) {
                    map.put(p.id, 'C');
                    ec = p.end;
                } else if (ej <= p.start) {
                    map.put(p.id, 'J');
                    ej = p.end;
                } else {
                    possible = false;
                    break;
                }
            }

            for (int i = 0; i < n; ++i) {
                sb.append(map.get(i));
            }
            if (!possible) {
                sb = new StringBuilder("IMPOSSIBLE");
            }
            System.out.println("Case #" + no + ": " + sb.toString());
            no++;
        }
    }
}

class pair {
    int start;
    int end;
    int id;

    pair(int start, int end, int id) {
        this.start = start;
        this.end = end;
        this.id = id;
    }
}

class sort implements Comparator<pair> {

    @Override
    public int compare(pair o1, pair o2) {
        if (o1.start == o2.start) {
            return o1.end - o2.end;
        }
        return o1.start - o2.start;
    }
}
