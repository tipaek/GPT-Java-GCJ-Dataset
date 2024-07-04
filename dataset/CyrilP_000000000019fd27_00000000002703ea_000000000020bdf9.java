import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static class Entry implements Comparable<Entry> {
        int time;
        int status;
        int nb;

        public Entry(int t, int s, int i){
            time = t;
            status = s;
            nb = i;
        }

        public int compareTo(Entry e){
            if(this.time < e.time){
                return -1;
            }
            else if(this.time > e.time){
                return 1;
            }
            else{
                return Integer.compare(this.status, e.status);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for(int t = 0; t<T; t++){
            boolean flag = false;
            int N = sc.nextInt();
            String[] curr = new String[N];
            ArrayList<Integer> C = new ArrayList<>();
            ArrayList<Integer> J = new ArrayList<>();
            PriorityQueue<Entry> pq = new PriorityQueue<>();
            for(int i = 0; i<N; i++){
                pq.add(new Entry(sc.nextInt(), 1, i));
                pq.add(new Entry(sc.nextInt(), -1, i));
            }
            while(!pq.isEmpty()) {
                Entry e = pq.poll();
                if(e.status==-1){
                    if(!C.remove((Integer) e.nb)){
                        J.remove((Integer) e.nb);
                        curr[e.nb] = "J";
                    }
                    else{
                        curr[e.nb] = "C";
                    }
                }
                else{
                    if(C.size() == 1){
                        if(J.size() == 1){
                            flag = true;
                            break;
                        }
                        else{
                            J.add(e.nb);
                        }
                    }
                    else{
                        C.add(e.nb);
                    }
                }
            }
            sb.append(String.format("Case %d: ",t+1));
            if(flag){
                sb.append("IMPOSSIBLE\n");
            }
            else{
                for (String value : curr) {
                    sb.append(value);
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}
