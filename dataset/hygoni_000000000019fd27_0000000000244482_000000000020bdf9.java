import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Schedule implements Comparable<Schedule>{
    int s, e, idx;
    public Schedule(int s, int e, int idx) {
        this.s = s;
        this.e = e;
        this.idx = idx;
    }

    @Override
    public int compareTo(Schedule o) {
        return Integer.compare(this.s, o.s);
    }
}

public class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int cameron_end = 0, jamie_end = 0;
            LinkedList<Schedule> list = new LinkedList<>();
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                list.add(new Schedule(s, e, i));
            }
            Collections.sort(list);
            Iterator<Schedule> iter = list.iterator();
            char out[] = new char[N];

            while (iter.hasNext()) {
                Schedule sc = iter.next();
                if (cameron_end <= sc.s) {
                    out[sc.idx] = 'C';
                    cameron_end = sc.e;
                } else if (jamie_end <= sc.s) {
                    out[sc.idx] = 'J';
                    jamie_end = sc.e;
                } else {
                    out = "IMPOSSIBLE".toCharArray();
                    break;
                }
            }
            System.out.printf("Case #%d: %s\n", t + 1, String.valueOf(out));
        }
        br.close();
    }
}
