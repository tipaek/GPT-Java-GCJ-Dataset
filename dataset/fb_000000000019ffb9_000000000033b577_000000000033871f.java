
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int T = s.nextInt();
        for(int i = 0; i < T; i++) {
            solve(i+1, s);
        }

    }

    private static void solve(int cid, Scanner in) {

        int C = in.nextInt();
        int D = in.nextInt();

        int[] arrival_time = new int[C];
        List<UInfo> info = new ArrayList<UInfo>(C);
        info.add(new UInfo(1, 0));
        for(int i = 2; i <= C; i++) {
            info.add(new UInfo(i, -in.nextInt()));
        }

        // System.out.println(info);
        Collections.sort(info);
        // System.out.println(info);

        int t = 0;
        for(int i = 0; i < C; i++) {
            int s = i;
            while(i < C-1 && info.get(i+1).rank == info.get(s).rank) {
                i++;
            }
            int e = i;
            for(int j = s; j <= e; j++) {
                arrival_time[info.get(j).id-1] = t;
            }
            t++;
        }

        /*
        for(int i = 0; i < C; i++) {
            System.out.print(arrival_time[i] + " ");
        }
        System.out.println();
        */

        System.out.print("Case #" + cid + ":");

        for(int i = 0; i < D; i++) {
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
            int d = Math.abs(arrival_time[u] - arrival_time[v]);
            if(d == 0) {
                d = 1;
            }
            System.out.print(" " + d);
        }

        System.out.println();

    }

    private static class Edge {
        int u, v;
        Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    private static class UInfo implements Comparable<UInfo> {

        int id;
        int rank;

        UInfo(int id, int rank) {
            this.id = id;
            this.rank = rank;
        }

        public int compareTo(UInfo other) {
            return (new Integer(this.rank)).compareTo(new Integer(other.rank));
        }

        public String toString() {
            return "[" + id + "," + rank + "]";
        }

    }

}
