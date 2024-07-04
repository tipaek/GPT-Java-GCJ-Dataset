
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
        List<UInfo> time_info = new ArrayList<UInfo>(C);
        List<UInfo> rank_info = new ArrayList<UInfo>(C);
        List<UInfo> comb_info = new ArrayList<UInfo>(C);
        rank_info.add(new UInfo(1, 0, 0));
        for(int i = 2; i <= C; i++) {
            int x = in.nextInt();
            if(x >= 0) {
                time_info.add(new UInfo(i, x, -1));
            } else {
                rank_info.add(new UInfo(i, -1, -x));
            }
        }

        Collections.sort(time_info);
        Collections.sort(rank_info);

        int tptr = 0;
        for(int i = 0; i < rank_info.size(); i++) {
            while(comb_info.size() < rank_info.get(i).rank) {
                comb_info.add(time_info.get(tptr++));
            }
            comb_info.add(rank_info.get(i));
        }

        int t = 0;
        for(int i = 0; i < C; i++) {
            if(comb_info.get(i).time == -1) {
                int s = i;
                while(i < C-1 && comb_info.get(i+1).time == -1
                        && comb_info.get(i+1).rank == comb_info.get(s).rank) {
                    i++;
                }
                int e = i;
                for(int j = s; j <= e; j++) {
                    arrival_time[comb_info.get(j).id-1] = t;
                }
                t++;
            } else {
                t = comb_info.get(i).time;
                arrival_time[comb_info.get(i).id-1] = t;
                t++;
            }
        }
        

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

    private static class UInfo implements Comparable<UInfo> {

        int id;
        int time;
        int rank;

        UInfo(int id, int time, int rank) {
            this.id = id;
            this.time = time;
            this.rank = rank;
        }

        public int compareTo(UInfo other) {
            if(this.time == -1){
                return (new Integer(this.rank)).compareTo(new Integer(other.rank));
            }
            return (new Integer(this.time)).compareTo(new Integer(other.time));

        }

        public String toString() {
            return "[" + id + "," + time + "," + rank + "]";
        }

    }

}
