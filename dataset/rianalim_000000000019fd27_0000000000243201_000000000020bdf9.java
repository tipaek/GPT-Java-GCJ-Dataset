import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for( int i = 1; i <= T; i++ ) {
            int N = in.nextInt();
            PriorityQueue<Job> pq = new PriorityQueue<>();
            char[] assign = new char[N];
            for( int j = 0; j < N; j++ ) {
                int s = in.nextInt(), e = in.nextInt();
                pq.add(new Job(j, s, 1));
                pq.add(new Job(j, e, 0));
            }
            int sweep = 0;
            StringBuilder sb = new StringBuilder();
            int ca = -1,ja = -1; // curr jobs
            boolean flag = false;
            while(!pq.isEmpty()) {
                Job curr = pq.remove();
                if( curr.type == 1 ) { // start
                    sweep++;
                    if( sweep > 2 ) {
                        flag = true;
                        break;
                    }
                    if( ca==-1 ) {
                        ca = curr.ind;
                        assign[curr.ind] = 'C';
                    } else {
                        ja = curr.ind;
                        assign[curr.ind] = 'J';
                    }
                } else { // end
                    sweep--;
                    if( ca == curr.ind ) ca = -1;
                    else if( ja == curr.ind ) ja = -1;
                }
            }
            if(flag) sb.append("IMPOSSIBLE");
            else {
                for( char cr : assign ) sb.append(cr);
            }
            System.out.printf("Case #%d: %s\n", i, sb.toString());
        }
    }
    public static class Job implements Comparable<Job> {
        int ind, time, type;
        // type:
        // 0 - end
        // 1 - start
        public Job(int ind, int time, int type) {
            this.ind = ind;
            this.time = time;
            this.type = type;
        }
        public int compareTo(Job j) {
            if( time == j.time ) return type-j.type;
            return time-j.time;
        }
    }
}