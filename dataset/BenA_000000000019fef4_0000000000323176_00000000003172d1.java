import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = Integer.parseInt(s.nextLine());
        String[] dirs;
        String[] sli;
        Long[] slic;
        int ans;
        int dins;
        for (int q = 1; q <= cases; q++) {
            dirs = s.nextLine().split(" ");
            dins = Integer.parseInt(dirs[1]);
            sli = s.nextLine().split(" ");
            slic = new Long[sli.length];
            for (int x = 0; x < sli.length; x++) {
                slic[x] = Long.parseLong(sli[x]);
            }
            ans = slices(slic,dins);
            System.out.println("Case #"+q+": "+ans);
        }
    }
    public static int slices(Long[] slic, int diners) {
        HashMap<Long,Integer> pair = new HashMap<Long,Integer>();
        for (int x = 0; x < slic.length; x++) {
            if (pair.containsKey(slic[x])) {
                pair.put(slic[x],pair.get(slic[x])+1);
            }
            else {
                pair.put(slic[x],1);
            }
        }
        for (Map.Entry m : pair.entrySet()) {
            if ((Integer)m.getValue() >= diners) {
                return 0;
            }
        }
        if (diners == 2) {
            return 1;
        }
        for (Map.Entry m : pair.entrySet()) {
            if (pair.containsKey((Long)m.getKey()*2)) {
                return 1;
            }
        }
        for (Map.Entry m : pair.entrySet()) {
            long high = 0;
            for (Map.Entry n : pair.entrySet()) {
                if ((Long)n.getKey() > high) {
                    high = (Long)n.getKey();
                }
            }
            if (high > (Long)m.getKey()) {
                return 1;
            }
        }
        return 2;
    }
}