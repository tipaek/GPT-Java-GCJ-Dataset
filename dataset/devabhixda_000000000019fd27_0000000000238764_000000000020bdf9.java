import java.util.*;
import java.io.*;
public class Solution {
    static int MAX = Integer.MAX_VALUE;
    public static void main(String[] args) {
    Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = scan.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            ArrayList<Integer> in = new ArrayList<>();
            ArrayList<Integer> out = new ArrayList<>();
            int n = scan.nextInt();
            for(int j=0;j<n;j++){
                in.add(scan.nextInt());
                out.add(scan.nextInt());
            }
            Map<Integer, String> str = new TreeMap<>();
            StringBuilder sb = new StringBuilder();
            int c=0, j=0, cnt=0;
            while(cnt<n) {
                int index = in.indexOf((Integer) Collections.min(in));
                int start = in.get(index);
                int end = out.get(index);
                if(c<=start) {
                    c=end;
                    str.put(index, "C");
                } else if(j<=start) {
                    j=end;
                    str.put(index, "J");
                }
                cnt++;
                in.remove(index);
                out.remove(index);
                in.add(index, MAX);
                out.add(index, MAX);
            }
            if(str.size()<n)
                System.out.println("Case #"+i+": IMPOSSIBLE");
            else {
                for(Map.Entry<Integer, String> entry : str.entrySet())
                    sb.append(entry.getValue());
                System.out.println("Case #"+i+": "+sb.toString());
            }

            // for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
            //     if(c<=entry.getKey()){
            //         c=entry.getValue();
            //         om.put(entry.getKey(), "C");
            //         cnt++;
            //     } else if (j<=entry.getKey()){
            //         j=entry.getValue();
            //         om.put(entry.getKey(), "J");
            //         cnt++;
            //     }
            // }
            // if(cnt<n){
            //     System.out.println("Case #"+i+": IMPOSSIBLE");
            // }
            // else {
            //     for(Map.Entry<Integer, String> entry : om.entrySet())
            //         sb.append(entry.getValue());
            //     System.out.println("Case #"+i+": "+sb.toString());
            // }
        }
    }
}