import java.util.*;
import java.io.*;
public class Solution {

      
 public static void main(String[] args) {
    HashMap<Integer,int[]> map = new HashMap();
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int m = 1; m <= t; ++m) {
       int N = in.nextInt();
       List<int[]> segments = new ArrayList();
       
       for(int i = 1; i <= N; i++)
       {
           int st = in.nextInt();
           int et = in.nextInt();
           segments.add(new int[]{st, et});
       }
       
       Collections.sort(segments, new Comparator<int[]>(){
           public int compare(int[] a, int[] b)
           {
               if(a[1] == b[1]) return a[0] - b[0];
               return a[1]-b[1];
           }
           });
        
        int k = 0;
        StringBuilder sb = new StringBuilder();
        boolean isPossible = true;
        for(int i = 0; i < segments.size(); i++)
        {
            if(map.containsKey(k))
            {
                int[] temp = map.get(k);
                if(segments.get(i)[0] <= temp[0])
                {
                    isPossible = false;
                    break;
                }
            }
            map.put(k, segments.get(i));
            sb = k == 0 ? sb.append("J") : sb.append("C");
            k = 1-k;
        }
        
        map.clear();
        String res = isPossible ? sb.toString() : "IMPOSSIBLE";
        System.out.println("Case #"+m+": "+res);
    }
  }
  
}