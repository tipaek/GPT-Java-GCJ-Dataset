import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static int gcd(int a, int b) {
        if(b==0)
            return a;
        if(a==0)
            return b;
        return gcd(b,a%b);
    }

    static final long base = 2000L*1000*1000;

    static class Tan {
        int x;
        int y;

        Tan(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public long getHash() {
            return base*x + y;
        }
    }

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        String input;
        String[] inputArray;
        input = br.readLine();
        final int T = Integer.parseInt(input);
        for (int t=1; t<=T; t++) {
            input = br.readLine();
            int n = Integer.parseInt(input);
            int [] x = new int[n];
            int [] y = new int[n];
            for (int i=0; i<n; i++) {
                input = br.readLine();
                inputArray = input.split(" ");
                x[i] = Integer.parseInt(inputArray[0]);
                y[i] = Integer.parseInt(inputArray[1]);
            }
            final HashMap<Long, Set<Integer>> angles = new HashMap<>();
            for (int i=0; i<n-1; i++) {
                for (int j=i+1; j<n; j++) {
                    int d1 = x[i]-x[j];
                    int d2 = y[i]-y[j];
                    int g = gcd(d1, d2);
                    final Tan tan = new Tan(d1/g, d2/g);
                    long tanHash = tan.getHash();
                    if (!angles.containsKey(tanHash)) {
                        angles.put(tanHash, new HashSet<>());
                    }
                    angles.get(tanHash).add(i);
                    angles.get(tanHash).add(j);
                }
            }
            int ans = 0;
            for (Map.Entry<Long, Set<Integer>> set : angles.entrySet()) {
                ans = Math.max(ans, set.getValue().size());
            }
            if (ans+1<=n) {
                ans++;
            }
            if (ans+1<=n) {
                ans++;
            }
            System.out.println(String.format("Case #%d: %d", t, ans));
        }
    }
}
