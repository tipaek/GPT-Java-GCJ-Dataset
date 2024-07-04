import java.util.*;
import java.util.Collections;

class Solution {
    private static Map<Integer, Interval> indexToInterval;
    public static void dfs(int source, List<List<Integer>> adj, boolean[] visited, int color) {
        if(visited[source]) {
            return ;
        }
        Interval interval = indexToInterval.get(source);
        interval.color = color;
        visited[source]  = true;
        for (Integer adjNode : adj.get(source)) {
            dfs(adjNode, adj, visited, (color + 1) % 2);
        }
    }

    public static void main(String[] args) {
        indexToInterval = new HashMap();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1;t<=T;t++) {
            int N = sc.nextInt();
            List<Interval> intervals = new ArrayList();
            for(int i=0;i<N;i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                Interval interval = new Interval(start, end, i);
                intervals.add(interval);
            }
            int count = 0;
            List<List<Integer>> adj = new ArrayList(N);
            for(int i=0;i<N;i++) {
                adj.add(new ArrayList());
            }
            
            for(Interval interval : intervals) {
                indexToInterval.put(interval.index, interval);
            }
            for(Interval interval : intervals) {
                for(Interval interval1 : intervals) {
                    if(interval != interval1) {
                        //System.out.println("Case #" + (count++) + ": " + interval.start + " " + interval.end);
                        if(interval.end <= interval1.start || interval.start >= interval1.end) {
                            continue;
                        }
                        adj.get(interval.index).add(interval1.index);
                    }
                }
            }
            boolean[] visited = new boolean[N];

            for(int i=0;i<N;i++) {
                if(!visited[i]) {
                    dfs(0, adj, visited, 0);  
                }  
            }

            boolean impossible = false;
            
            for(int i=0;i<N;i++) {
                //System.out.print(i + " : ");
                int color = indexToInterval.get(i).color;

                for(Integer j : adj.get(i)) {
                    int adjcolor = indexToInterval.get(j).color;
                    if(adjcolor == color) {
                        impossible = true;
                    }
                    //System.out.print(j + " ");
                }
                //System.out.println();
            }
            if(impossible) {
                System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
            } else {
                Collections.sort(intervals, new IntervalComparatorByIndex());
                System.out.print("Case #" + t + ": ");
                for(Interval interval : intervals) {
                    Character ch = interval.color ==0 ? 'J' : 'C';
                    System.out.print(""+  ch);
                }
                System.out.println("");
            }
        }
    }
}
class IntervalComparatorByIndex implements Comparator<Interval> {
    public int compare(Interval i1, Interval i2) {
        return i1.index - i2.index; 
    }
}

class Interval {
    int start;
    int end;
    int index;
    char assingedTo;
    int color;
    public Interval(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}
