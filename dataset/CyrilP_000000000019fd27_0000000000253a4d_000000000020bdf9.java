import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static class Entry implements Comparable<Entry> {
        int start;
        int end;
        int nb;

        public Entry(int s, int e, int i){
            start = s;
            end = e;
            nb = i;
        }

        public int compareTo(Entry e){
            return Integer.compare(this.start, e.start);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for(int t = 0; t<T; t++){
            String s = "C";
            boolean flag = false;
            int N = sc.nextInt();
            String[] curr = new String[N];
            PriorityQueue<Entry> pq = new PriorityQueue<>();
            for(int i = 0; i<N; i++){
                pq.add(new Entry(sc.nextInt(), sc.nextInt(), i));
            }
            Entry e = pq.poll();
            int currStart = e.start;
            int currEnd = e.end;
            curr[e.nb] = s;
            for(int i = 0; i<N-1; i++){
                e = pq.poll();
                if(e.start >= currEnd){
                    currStart = e.start;
                    currEnd = e.end;
                    curr[e.nb] = s;
                }
                else if (!pq.isEmpty()){
                    if(e.end < currEnd){
                        Entry f = pq.peek();
                        if(f.start < e.end){
                            flag = true;
                            break;
                        }
                        else{
                            s = change(s);
                            currStart = e.end;
                            curr[e.nb] = s;
                            s = change(s);
                        }
                    }
                    else{
                        Entry f = pq.peek();
                        if(f.start < currEnd){
                            flag = true;
                            break;
                        }
                        else{
                            s = change(s);
                            currStart = e.start;
                            currEnd = e.end;
                            curr[e.nb] = s;
                        }
                    }
                }
                else{
                    s = change(s);
                    curr[e.nb] = s;
                    break;
                }
            }
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
        System.out.println(sb);
    }
    private static String change(String s){
        if(s.equals("C")){
            return "J";
        }
        else{
            return "C";
        }
    }
}
