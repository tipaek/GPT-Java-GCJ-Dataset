// "static void main" must be defined in a public class.
import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int tc = 1; tc <= t; ++tc) {
            int n = in.nextInt();
            PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[0]-b[0]);
            for(int i=0; i<n; i++) minHeap.add(new int[]{in.nextInt(),in.nextInt(),i});
            int c = 0;
            int j = 0;
            char[] schedule = new char[n];
            boolean impossible = false;
            for(int i=0; i<n; i++){
                int[] activity = minHeap.poll();
                if(c<=activity[0]){
                    c = activity[1];
                    schedule[activity[2]] = 'C';
                }else if(j<=activity[0]){
                    j = activity[1];
                    schedule[activity[2]] = 'J';
                }else{
                    impossible = true;
                    break;
                }
            }
            String result = (impossible) ? "IMPOSSIBLE" : new String(schedule);
            System.out.println("Case #" + tc + ": " + new String(result));
        }
    }
}