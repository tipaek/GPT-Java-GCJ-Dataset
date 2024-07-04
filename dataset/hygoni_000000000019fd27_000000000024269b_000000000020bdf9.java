import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Schedule implements Comparable<Schedule>{
    int s, e;
    public Schedule(int s, int e) {
        this.s = s;
        this.e = e;
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
                list.add(new Schedule(s, e));
            }
            Collections.sort(list);
            Iterator<Schedule> iter = list.iterator();
            StringBuilder sb = new StringBuilder();
            while (iter.hasNext()) {
                Schedule sc = iter.next();
                if (cameron_end <= sc.s) {
                    sb.append('C');
                    cameron_end = sc.e;
                } else if (jamie_end <= sc.s) {
                    sb.append('J');
                    jamie_end = sc.e;
                } else {
                    sb = new StringBuilder();
                    sb.append("IMPOSSIBLE");
                    break;
                }
            }
            System.out.printf("Case #%d: %s\n", t + 1, sb.toString());
        }
        br.close();
    }
}
