import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.FileChannel.MapMode;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int t_i = 1; t_i <= test; ++t_i) {
            int ans = 0;
            StringTokenizer token = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(token.nextToken());
            int D = Integer.parseInt(token.nextToken());
            token = new StringTokenizer(br.readLine());
            HashMap<Long, Integer> mapAngle = new HashMap<Long, Integer>();
            int maxMultiple = 1;
            ArrayList<Long> liss = new ArrayList<Long>();
            for (int i = 0; i < N; i++) {
                long ll = Long.parseLong(token.nextToken());
                liss.add(ll);
                int val = 1;
                if (mapAngle.containsKey(ll)) {
                    val += mapAngle.get(ll);
                    
                }
                if (maxMultiple < val) {
                        maxMultiple = val;
                }
                mapAngle.put(ll, val);
            }
            Collections.sort(liss);
            // System.out.println(liss + "\n" + mapAngle);
            if (D == 2) {
                if (N == 1) {
                    ans = 1;
                } else if (maxMultiple == 1) {
                    ans = 1;
                } else {
                    ans = 0;
                }
            } else if (D == 3) {

                if (N == 1) {
                    ans = 2;
                } else if (N == 2) {
                    ans = 2;
                    if ((long) liss.get(0) * 2 == (long) liss.get(1)) {
                        ans = 1;
                    }
                } else if (maxMultiple > 2) {
                    ans = 0;
                } else if (maxMultiple == 2) {
                    ans = 2;
                    for (int j = 0; j < liss.size(); j++) {
                        if (mapAngle.get((long) liss.get(j)) ==2
                                && (long) liss.get(j) != (long) liss.get(liss.size() - 1)) {
                            ans = 1;
                            break;
                        }
                    }
                } else {
                    ans = 2;
                    for (int j = 0; j < liss.size(); j++) {
                        if (liss.contains(2 * (long) liss.get(j))) {
                            ans = 1;
                            break;
                        }
                    }
                }
            } else {

            }
            sb.append("Case #" + t_i + ": " + ans).append("\n");

        }
        System.out.print(sb.toString());
    }
}