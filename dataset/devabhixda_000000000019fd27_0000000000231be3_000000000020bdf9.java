import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
    Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = scan.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            TreeMap<Integer, Integer> hm = new TreeMap<>();
            Map<Integer, String> om = new LinkedHashMap<>();
            int n = scan.nextInt();
            for(int j=0;j<n;j++){
                int t1 = scan.nextInt();
                int t2 = scan.nextInt();
                hm.put(t1, t2);
                om.put(t1,t2+"");
            }
            StringBuilder sb = new StringBuilder();
            int c=0, j=0, cnt=0;
            for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
                if(c<=entry.getKey()){
                    c=entry.getValue();
                    om.put(entry.getKey(), "C");
                    cnt++;
                } else if (j<=entry.getKey()){
                    j=entry.getValue();
                    om.put(entry.getKey(), "J");
                    cnt++;
                }
            }
            if(cnt<n){
                System.out.println("Case #"+i+": IMPOSSIBLE");
            }
            else {
                for(Map.Entry<Integer, String> entry : om.entrySet())
                    sb.append(entry.getValue());
                System.out.println("Case #"+i+": "+sb.toString());
            }
        }
    }
}