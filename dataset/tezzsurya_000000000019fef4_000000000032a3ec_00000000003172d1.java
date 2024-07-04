import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for(int t=1;t<=T;t++) {
            String[] line = br.readLine().trim().split(" ");
            int n = Integer.parseInt(line[0]);
            int d = Integer.parseInt(line[1]);

            line = br.readLine().trim().split(" ");
            HashMap<Long, Integer> map = new HashMap<>();
            for(int i=0;i<n;i++) {
                long ai = Long.parseLong(line[i]);
                Integer val = map.get(ai);
                if(val == null) {
                    val = 0;
                }
                map.put(ai, val + 1);
            }
            sb.append("Case #").append(t).append(": ");
            long maxFKey = 0L; int maxVal = -1;
            for(Long k : map.keySet()) {
                int v = map.get(k);
                if(v > maxVal) {
                    maxFKey = k;
                    maxVal = v;
                } else if(v == maxVal) {
                    if(maxFKey > k) {
                        maxFKey = k;
                    }
                }
            }
            int f = map.get(maxFKey);
            if(f == d) {
                // done
                sb.append("0");
            } else if(f == d - 1) {
                // pick one of keys that are greater than maxFKey
                boolean found = false;
                for(long k : map.keySet()) {
                    if(k > maxFKey) {
                        // found one - return 1
                        found = true;
                        sb.append("1");
                        break;
                    }
                }
                // return d - 1;
                if(!found) sb.append(d - 1);
            } else {
                boolean found = false;
                for(long k : map.keySet()) {
                    if(k % 2 == 0 && map.containsKey(k/2)) {
                        sb.append("1");
                        found = true;
                        break;
                    }
                }
                if(!found) sb.append(d -1);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}