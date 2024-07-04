import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static class Entry implements Comparable<Entry> {
        int start;
        int end;

        public Entry(int s, int e){
            start = s;
            end = e;
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
            StringBuilder curr = new StringBuilder();
            String s = "C";
            int N = sc.nextInt();
            PriorityQueue<Entry> pq = new PriorityQueue<>();
            for(int i = 0; i<N; i++){
                pq.add(new Entry(sc.nextInt(), sc.nextInt()));
            }
            Entry e = pq.poll();
            int currStart = e.start;
            int currEnd = e.end;
            curr.append(s);
            for(int i = 0; i<N-1; i++){
                e = pq.poll();
                if(e.start >= currEnd){
                    currStart = e.start;
                    currEnd = e.end;
                    curr.append(s);
                }
                else if (!pq.isEmpty()){
                    if(e.end < currEnd){
                        Entry f = pq.peek();
                        if(f.start < e.end){
                            curr.setLength(0);
                            curr.append("IMPOSSIBLE");
                            break;
                        }
                        else{
                            s = change(s);
                            currStart = e.end;
                            curr.append(s);
                            s = change(s);
                        }
                    }
                    else{
                        Entry f = pq.peek();
                        if(f.start < currEnd){
                            curr.setLength(0);
                            curr.append("IMPOSSIBLE");
                            break;
                        }
                        else{
                            s = change(s);
                            currStart = e.start;
                            currEnd = e.end;
                            curr.append(s);
                        }
                    }
                }
                else{
                    s = change(s);
                    curr.append(s);
                    break;
                }
            }
            sb.append(curr);
            sb.append("\n");
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
