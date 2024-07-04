import java.io.*;
import java.util.*;
import java.lang.Math;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int limit = Integer.parseInt(in.nextLine());
        for(int i = 0; i < limit; i ++){
            StringTokenizer limits = new StringTokenizer(in.nextLine());
            int p = Integer.parseInt(limits.nextToken());
            int d = Integer.parseInt(limits.nextToken());
            ArrayList<Long> pan = new ArrayList<Long>(p);
            StringTokenizer pl = new StringTokenizer(in.nextLine());
            for(int j = 0; j < p; j ++){
                pan.add(Long.parseLong(pl.nextToken())*10);
            }
            Collections.sort(pan);
            Set<Long> unique = new HashSet<Long>(pan);
            int curr = 0, max = 0;
            long currKey = 0;
            for(long key : unique) {
                curr = Collections.frequency(pan, key);
                if(max == curr){
                    if(key < currKey){
                        currKey = key;
                    }
                }
                if(max < curr){
                    max = curr;
                    currKey = key;
                }
            }
            if(d == max) System.out.println("Case #" + (i+1) + ": " + "0");
            else if(pan.get(pan.size()-1) != currKey) System.out.println("Case #" + (i+1) + ": " + (d-1));
            else if(d-max == 1) System.out.println("Case #" + (i+1) + ": " + "0");
            else if(pan.get(pan.size()-1)%currKey == 0) System.out.println("Case #" + (i+1) + ": " + (d-max-1));
            else System.out.println("Case #" + (i+1) + ": " + (d-max));
        }
    }
}