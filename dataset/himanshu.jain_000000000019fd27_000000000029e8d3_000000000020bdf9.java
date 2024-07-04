import java.util.*;
import java.io.*;
public class Solution {

      
public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    HashMap<Integer, PriorityQueue<int[]>> map = new HashMap();
    char[] ch = { 'J', 'C' };

    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int m = 1; m <= t; ++m) {
       int N = in.nextInt();
       List<int[]> intervals = new ArrayList();
       List<int[]> actualList = new ArrayList();
       HashMap<Integer, String> positions = new HashMap();
       
       for(int i = 1; i <= N; i++)
       {
           int st = in.nextInt();
           int et = in.nextInt();
           intervals.add(new int[]{st, et});
           actualList.add(new int[]{st, et});
       }
       
       Collections.sort(intervals, new Comparator<int[]>(){
           public int compare(int[] a, int[] b)
           {
               if(a[0] == b[0]) return a[1] - b[1];
               return a[0]-b[0];
           }
           });
        
        StringBuilder sb = new StringBuilder();
        map.putIfAbsent(0, new PriorityQueue<int[]>((a, b) -> (b[1] - a[1])));
        map.putIfAbsent(1, new PriorityQueue<int[]>((a, b) -> (b[1] - a[1])));
        int k = 0;
        boolean isPossible = true;
        
        for(int i = 0; i < N; i++) {
            int[] cur = intervals.get(i);
            int pos = -1;
            
            for(int j = 0; j < N; j++) {
                int[] temp = actualList.get(j);
                boolean condition = (cur[0] == temp[0]) && (cur[1] == temp[1]);
                if((cur[0] == temp[0]) && (cur[1] == temp[1]) && !positions.containsKey(j)) {
                    pos = j;
                    positions.put(j, "");
                    break;
                }
            }
            
            // System.out.println(" st "+cur[0] + " et "+cur[1] + " pos "+pos);      
            if(map.get(k).isEmpty()) {
                map.get(k).offer(cur);
                positions.put(pos, ch[k]+"");
                k = 1 - k;
            }
            else {
                int[] last = map.get(k).peek();
                int[] other = map.get(1-k).peek();
                if(last[1] > cur[0]  && other[1] > cur[0]) {
                    isPossible = false;
                }
                else if(last[1] <= cur[0]) {
                    map.get(k).offer(cur);
                    positions.put(pos, ch[k]+"");
                }
                else {
                    map.get(1-k).offer(cur);
                    positions.put(pos, ch[1-k]+"");
                }
            }
        }
        
        if(isPossible) {
            for(int i = 0; i < N; i++) {
                sb.append(positions.get(i));
            }
        }
        
        positions.clear();
        map.clear();
        String res = isPossible ? sb.toString() : "IMPOSSIBLE";
        System.out.println("Case #"+m+": "+res);
    }
  }
  
}