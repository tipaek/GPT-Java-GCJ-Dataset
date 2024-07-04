import java.util.*;
import java.io.*;

class Solution {
    static class Interval{
        int start, end, index;
        public Interval(int start, int end, int index){
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        int x = 0;
        while (x++ < T){
            int n = scanner.nextInt();
            Interval[] intervals = new Interval[n];
            StringBuilder result = new StringBuilder();
            for (int i=0; i<n; i++){
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals[i] = new Interval(start, end, i);
                result.append('C');
            }
            Arrays.sort(intervals, (a,b) -> a.start - b.start);
            PriorityQueue<Interval> pq1 = new PriorityQueue<>((a, b) -> a.end - b.end);
            PriorityQueue<Interval> pq2 = new PriorityQueue<>((a, b) -> a.end - b.end);
            pq1.add(intervals[0]);
            boolean flag = true;
            for (int i=1; i<n; i++){
                Interval curr = intervals[i];
                Interval earliest1 = pq1.remove();
                if(curr.start >= earliest1.end){
                    earliest1.end = curr.end;
                }
                else {
                    if (pq2.size() == 0){
                        pq2.add(curr);
                        //result.setCharAt(curr.index, 'J');
                    }
                    else{
                        Interval earliest2 = pq2.remove();
                        if (curr.start >= earliest2.end){
                            earliest2.end = curr.end;
                        }
                        else
                            flag = false;
                        pq2.add(earliest2);
                    }
                    result.setCharAt(curr.index, 'J');
                    if (!flag)
                        break;
                }
                pq1.add(earliest1);
            }
            if (flag)
                System.out.println("Case #"+ x +": "+ result.toString());
            else
                System.out.println("Case #"+ x +": "+ "IMPOSSIBLE");
        }
    }

}
/*
5
3
360 480
420 540
600 660
3
0 1440
1 3
2 4
5
99 150
1 100
100 301
2 5
150 250
2
0 720
720 1440
3
1 2
1 2
1 2
 */